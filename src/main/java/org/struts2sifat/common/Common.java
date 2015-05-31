package org.struts2sifat.common;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringEscapeUtils;
 
public class Common {

	/**
	 *
	 */
	public static boolean IsNullOrEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 *
	 */
	public static boolean IsNullorDataYYYYMMDD(String str) {
		if (IsNullOrEmpty(str)) {
			return true;
		} else {
			return IsDataYYYYMMDD(str);
		}
	}

	/**
	 *
	 */
	public static boolean IsDataYYYYMMDD(String str) {
		boolean result = false;
		if (str != null) {
			if (str.length() != 8 || str.getBytes().length != 8) {
				return result;
			}
			String strDate = String.format("%s/%s/%s", str.substring(0, 4),
					str.substring(4, 6), str.substring(6, 8));
			DateFormat format = DateFormat.getDateInstance();
			format.setLenient(false);
			try {
				format.parse(strDate);
				if (str.compareTo("17530101") < 0
						|| 0 < str.compareTo("99991231")) {
					result = false;
				} else {
					result = true;
				}
			} catch (ParseException e) {
				result = false;
			}
		} else {
			result = true;
		}
		return result;
	}

	/**
	 *
	 */
	public static boolean isDataYYYYMMDDWithSlash(String strDateWithSlash) {

		boolean result = false;

		if (strDateWithSlash != null) {

			if (strDateWithSlash.length() != 10 || strDateWithSlash.getBytes().length != 10) {
				return result;
			}

			DateFormat format = DateFormat.getDateInstance();

			format.setLenient(false);

			try {
				format.parse(strDateWithSlash);

				String strDate = strDateWithSlash.replaceAll("/", "");

				if (strDate.compareTo("17530101") < 0
						|| 0 < strDate.compareTo("99991231")) {
					result = false;
				} else {
					result = true;
				}
			} catch (ParseException e) {
				result = false;
			}
		} else {
			result = true;
		}
		return result;
	}

	/**
	 *
	 */
	public static String CommaFormat(Double dbl) {
		String result = null;
		if (dbl != null) {
			DecimalFormat df1 = new DecimalFormat("#,###");
			result = df1.format(dbl);
		}
		return result;
	}

	/**
	 *
	 */
	public static String CommaFormat(int intNumber) {
		String result = null;
		DecimalFormat df1 = new DecimalFormat("#,###");
		result = df1.format(intNumber);
		return result;
	}

	/**
	 */
	public static int decodeCommaFormat(String strNumber) {

		int intNumber = 0;

		try {
			String decodeStrNumber = strNumber.replaceAll(",", "");
			intNumber = Integer.parseInt(decodeStrNumber);
		} catch (NumberFormatException e) {
		}

		return intNumber;
	}

	/**
	 */
	public static String URLEncode(String str) throws UnsupportedEncodingException {
		String result = str;
		result = URLEncoder.encode(str, Consts.CHARSET_UTF_8);
		return result;
	}

	/**
	 */
	public static String URLDecode(String str) throws UnsupportedEncodingException {
		return URLDecoder.decode(str, Consts.CHARSET_UTF_8);
	}

	/**
	 *
	 * @param str
	 */
	public static String EscapeLike(String str) {
		return str.replaceAll("\\[", "\\[\\[\\]").replaceAll("%", "\\[%\\]")
				.replaceAll("_", "\\[_\\]");
	}

	/**
	 *
	 * @param str
	 */
	public static String CsvEscape(String str) {
		if (str == null) {
			return "\"\"";
		}
		return "\"" + str.trim().replace("\"", "\"\"") + "\"";
	}

	/**
	 */
	public static String CsvEscapeNoTrim(String str) {
		if (str == null) {
			return "\"\"";
		}
		return "\"" + str.replace("\"", "\"\"") + "\"";
	}

	/**
	 */
	public static String ConvertDownloadString(String str)
			throws UnsupportedEncodingException {
		return new String(str.getBytes(Consts.CHARSET_WINDOWS_31J),
				Consts.CHARSET_UTF_8);
//		return new String(str.getBytes(Consts.CHARSET_UTF_8),
//				Consts.CHARSET_MS932);
//		return new String(str.getBytes(Consts.CHARSET_UTF_8),
//				Consts.CHARSET_8859_1);
	}

	/**
	 */
	public static String ConvertToyyyy_MM_dd(Date date) {
		String result = "";
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			result = df.format(date);
		}
		return result;
	}

	/**
	 */
	public static String dateFormat(Date date, String format) {
		String result = "";

		try{
			if (date != null) {
				SimpleDateFormat df = new SimpleDateFormat(format);
				result = df.format(date);
			}
		}catch(Exception e){

		}
		return result;
	}

	/**
	 */
	public static String CsvGetDateData(Date date) {
		return "\"" + ConvertToyyyy_MM_dd(date) + "\"";
	}

	/**
	 */
	public static String CsvGetDoubleData(Double dbl) {
		if (dbl == null) {
			return "";
		}
		DecimalFormat df = new DecimalFormat("####"); // (1)
		return df.format(dbl);
	}

	/**
	 */
	public static String CsvGetBigDecimalData(BigDecimal bdc) {
		if (bdc == null) {
			return "";
		}
		DecimalFormat df = new DecimalFormat("####"); // (1)
		return df.format(bdc);
	}

	/**
	 */
	public static String CsvGetIntegerData(Integer itg) {
		if (itg == null) {
			return "";
		}
		DecimalFormat df = new DecimalFormat("####"); // (1)
		return df.format(itg);
	}

	/**
	 */
	public static String GetResourcesString(String tagname) throws MissingResourceException {
		ResourceBundle resourceBundle = ResourceBundle
				.getBundle("ApplicationResources");
		return resourceBundle.getString(tagname);
	}

	/**
	 */
	public static Integer GetResourcesInteger(String tagname) throws MissingResourceException {
		ResourceBundle resourceBundle = ResourceBundle
				.getBundle("ApplicationResources");
		return Integer.parseInt(resourceBundle.getString(tagname));
	}

	/**
	 */
	public static String HtmlEncodeWithCRLF(String html) {
		String result = null;

		if (html != null) {
			result = StringEscapeUtils.escapeHtml3(html)
					.replaceAll("&lt;br&gt;", "<br>")
					.replaceAll("\r\n", "<br>").replaceAll("\r", "<br>")
					.replaceAll("\n", "<br>");
		}
		return result;
	}

	/**
	 */
	public static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 */
	public static String addMonth(String dateString, int addCount) {

		if (dateString == null || dateString.trim().length() != 7) {
			return "";
		}

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM");
		Date dateData = null;

		try {
			dateData = dateFormat.parse(dateString);
		} catch (ParseException e) {
			return "";
		}

		Calendar cal = new GregorianCalendar();
		cal.setTime(dateData);

		cal.add(Calendar.MONTH, addCount);

		return dateFormat.format(cal.getTime());
	}

	/**
	 */
	public static java.sql.Date createNewDate() {

		java.util.Date utilDate = new java.util.Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(utilDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());

		return sqlDate;
	}
}


