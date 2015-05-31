package org.struts2sifat.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 *
 */
public class LoginManager {

	/**
	 */
	public static enum LOGIN_RESULT {
		/**
		 */
		NOT_CHECKED,

		/**
		 */
		SUCCESS,

		/**
		 */
		ID_NOT_EXIST,

		/**
		 */
		PASSWORD_ERROR,

		/**
		 */
		FILE_NOT_EXIST,

		/**
		 */
		FILE_FORMAT_ERROR,
	};

	/**
	 */
	public static LOGIN_RESULT certifyLoginInfo(String userid, String password)
			throws Exception {

		BufferedReader br = null;
		String path = null;
		path = Common.GetResourcesString("loginfile");
		LOGIN_RESULT result = LOGIN_RESULT.NOT_CHECKED;
		// try {
		File csv = new File(path);  

		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					csv), Consts.CHARSET_SHIFT_JIS));

			String line;

			while ((line = br.readLine()) != null) {
				if (!line.contains(",")) {
					result = LOGIN_RESULT.FILE_FORMAT_ERROR;
					break;
				}

				int commaIndex = line.indexOf(",");
				String file_userid = line.substring(0, commaIndex).trim();
				String file_password = line.substring(commaIndex + 1).trim();

				if (file_userid.length() == 0) {
					result = LOGIN_RESULT.FILE_FORMAT_ERROR;
					break;
				}
				if (userid.equals(file_userid)) {

					if (password.equals(file_password)) {
						result = LOGIN_RESULT.SUCCESS;
						break;
					} else {
						result = LOGIN_RESULT.PASSWORD_ERROR;
						break;
					}
				}
			}
			if (result == LOGIN_RESULT.NOT_CHECKED) {
				result = LOGIN_RESULT.ID_NOT_EXIST;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw e;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			result = LOGIN_RESULT.FILE_NOT_EXIST;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (Exception e) {
			}
		}
		return result;
	}

}
