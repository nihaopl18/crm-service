package cn.com.yusys.yscrm.cust.person.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DataUtils {
	// 默认值1
	public static final String DEF_VALUE_TRUE = "1";

	// 默认值0
	public static final String DEF_VALUE_FALSE = "0";

	// 提示周期
	public static final Integer DEF_TIP_CYCLE = 7;
	// 默认分页条数
	public final static int PAGE_SIZE = 10;
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;

	// 默认除法运算精度
	private static final int DEF_DIV_SCALE = 15;

	/**
	 * 截取字符串
	 * 
	 * @param param
	 *            需截取的字符串
	 * @param startLength
	 *            起始位置
	 * @param endLength
	 *            截止位置
	 * @return
	 */
	public static String substr(String param, String startLength,
			String endLength) {
		int x = Integer.parseInt(startLength);
		int y = Integer.parseInt(endLength);
		String str = param.substring(x, y);
		return str;
	}

	/**
	 * 两个字符串连接
	 * 
	 * @param str1
	 *            字符串1
	 * @param str2
	 *            字符串2
	 * @return 新的连接后的字符串
	 */
	public static String connect(String str1, String str2) {
		String newStr = str1 + str2;
		return newStr;
	}

	/**
	 * 提供精确的加法运算。
	 * 
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */
	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * 提供精确的减法运算。
	 * 
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 */
	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 提供精确的乘法运算。
	 * 
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 提供精确的小数位四舍五入处理。
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 字符串转为流
	 * 
	 * @param str
	 * @return
	 */
	public static InputStream String2InputStream(String str) {
		ByteArrayInputStream stream = new ByteArrayInputStream(str.getBytes());
		return stream;
	}

	/**
	 * 流转为字符串
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static String inputStream2String(InputStream is) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while ((line = in.readLine()) != null) {
			buffer.append(line);
		}
		return buffer.toString();
	}

	/**
	 * 将 字符串 进行 BASE64 编码
	 * 
	 * @param s
	 *            要编码的字符串
	 * @return 编码后的字符串
	 */
	public static String getBASE64(String s) {
		if (s == null)
			return null;
		return (new BASE64Encoder()).encode(s.getBytes());
	}

	/**
	 * 将base64字符串进行解码
	 * 
	 * @param s
	 *            要解码的字符串
	 * @return 解码后的字符串
	 */
	// 将 BASE64 编码的字符串 s 进行解码
	public static String getFromBASE64(String s) {
		if (s == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return new String(b);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 16进制数据转换为字节数组
	 * 
	 * @param hex
	 * @return
	 */
	public static byte[] hexStringToByte(String hex) {
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] achar = hex.toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
			// log.info(result[i]);
		}
		// log.info(result.length);
		return result;
	}

	private static byte toByte(char c) {
		byte b = (byte) "0123456789ABCDEF".indexOf(c);
		return b;
	}

	/**
	 * 字节数组转换为16进制数据
	 * 
	 * @param bArray
	 * @return
	 */
	public static final String bytesToHexString(byte[] bArray) {
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 编码16进制数据
	 * 
	 * @param bytes
	 * @return
	 */
	public static final String encodeHex(byte[] bytes) {
		StringBuffer buff = new StringBuffer(bytes.length * 2);
		String b;
		for (int i = 0; i < bytes.length; i++) {
			b = Integer.toHexString(bytes[i]);
			// byte是两个字节的， 而上面的Integer.toHexString会把字节扩展为4个字节
			buff.append(b.length() > 2 ? b.substring(6, 8) : b);

			// buff.append(" ");
		}
		return buff.toString();
	}

	/**
	 * 将不带小数点的金额字符串转为带小数点
	 * 
	 * @param amt
	 *            不带小数点的金额字符串
	 * @return 带小数点的金额字符串
	 */
	public static String getAmtWithPoint(String amt) {
		String rtnValue = "";
		int trunLength = 0;
		String tmpStr1 = "";
		String tmpStr2 = "";
		if (amt.length() > 2) {
			trunLength = amt.length() - 2;
			tmpStr1 = amt.substring(0, trunLength);
			tmpStr2 = amt.substring(trunLength, amt.length());
			rtnValue = tmpStr1 + "." + tmpStr2;

		} else if (amt.length() == 2) {
			rtnValue = "0." + amt;
		} else if (amt.length() == 1) {
			rtnValue = "0.0" + amt;
		}
		return rtnValue;
	}

	/**
	 * 将带小数点的金额字符串转为不带小数点
	 * 
	 * @param amt
	 *            带小数点的金额字符串
	 * @return 不带小数点的金额字符串
	 */
	public static String getAmtNotWithPoint(String amt) {
		String rtnValue = "";
		int trunLength = 0;
		String tmpStr1 = "";
		String tmpStr2 = "";
		trunLength = amt.indexOf(".");
		tmpStr1 = amt.substring(0, trunLength);
		tmpStr2 = amt.substring(trunLength + 1, amt.length());
		if (tmpStr2.length() < 2) {
			tmpStr2 = tmpStr2 + "0";
		}
		rtnValue = tmpStr1 + tmpStr2;
		return String.valueOf(Long.parseLong(rtnValue));

	}

	/**
	 * 将日历对象转换为本地时间的字符串对象并返回
	 * 
	 * @param calendar
	 *            日历对象
	 * @return "2009-08-25 23:21:50" 此格式类型的字符串
	 */
	public static String toLocalDate(Calendar calendar) {
		// 日期格式化类,格式可根据需要修改。
		SimpleDateFormat format = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss.SSS");
		return format.format(calendar.getTime());
	}

	/**
	 * 按长度截取字符串，并添加相应的字符
	 * 
	 * @param str
	 *            : 要截取的字符串
	 * @param width
	 *            : 截取长度
	 * @param ellipsis
	 *            : 添加到字符串末尾的字符如"..."
	 * @return 截取后的字符串
	 * 
	 */
	public static String abbreviate(String str, int width, String ellipsis) {
		if (str == null || "".equals(str)) {
			return "";
		}

		int d = 0; // byte length
		int n = 0; // char length
		for (; n < str.length(); n++) {
			d = (int) str.charAt(n) > 256 ? d + 2 : d + 1;
			if (d > width) {
				break;
			}
		}

		if (d > width) {
			n = n - ellipsis.length() / 2;
			return str.substring(0, n > 0 ? n : 0) + ellipsis;
		}

		return str = str.substring(0, n);
	}

	/**
	 * 过滤html字符串
	 * 
	 * @param str
	 *            : 需过滤的字符串
	 * @return String Object
	 * 
	 */
	public static String Html2Text(String inputString) {
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;

		java.util.regex.Pattern p_html1;
		java.util.regex.Matcher m_html1;

		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
			// }
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
			// }
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
			String regEx_html1 = "<[^>]+";
			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签

			p_html1 = Pattern.compile(regEx_html1, Pattern.CASE_INSENSITIVE);
			m_html1 = p_html1.matcher(htmlStr);
			htmlStr = m_html1.replaceAll(""); // 过滤html标签

			textStr = htmlStr;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return textStr;// 返回文本字符串
	}

	/**
	 * 获得文中第一个IMG标签中的src内容
	 * 
	 * @param content
	 *            文章内容
	 * @return 图片名称
	 */
	public static String getFirstImg(String content) {
		Pattern p_image;
		Matcher m_image;
		String img = "";
		String regEx_img = "<img.*src=(.*?)[^>]*?>"; // 图片链接地址
		p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
		m_image = p_image.matcher(content);
		int i = 0;
		String image[] = new String[5];
		while (m_image.find()) {
			img = img + "," + m_image.group();
			Matcher m = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(img); // 匹配src
			while (m.find()) {
				image[i] = m.group(1);
				i++;
			}
		}
		System.out.println(image[0]);
		String rtnStr = "";
		if (image[0].length() > 0) {
			rtnStr = image[0].substring(image[0].lastIndexOf("/") + 1);
		}
		return rtnStr;
	}

	/**
	 * md5加密
	 * 
	 * @param str
	 * @return
	 */
	public static String getMD5Str(String str) {
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");

			messageDigest.reset();

			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}

		return md5StrBuff.toString();
	}

	/**
	 * 在字符串前面补0,
	 * 
	 * @param str
	 *            需补0的字符串
	 * @param length
	 *            总长度
	 * @return
	 */
	public static String appendZero(String str, int length) {
		int strLength = str.length();
		int append = 0;
		if (strLength < length) {
			append = length - strLength;
			for (int i = 0; i < append; i++) {
				str = "0" + str;
			}
		}
		return str;
	}

	/**
	 * 在字符串后面补字符,
	 * 
	 * @param str
	 *            需补字符的字符串
	 * @param length
	 *            总长度
	 * 
	 * @return
	 */
	public static String appendStr(String str, int length, String appendStr) {
		int strLength = str.length();
		int append = 0;
		if (strLength < length) {
			append = length - strLength;
			for (int i = 0; i < append; i++) {
				str += appendStr;
			}
		}
		return str;
	}

	/**
	 * 半角转全角
	 * 
	 * @param input
	 *            String.
	 * @return 全角字符串.
	 */
	public static String ToSBC(String input) {
		char c[] = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ') {
				c[i] = '\u3000';
			} else if (c[i] < '\177') {
				c[i] = (char) (c[i] + 65248);

			}
		}
		return new String(c);
	}

	/**
	 * 全角转半角
	 * 
	 * @param input
	 *            String.
	 * @return 半角字符串
	 */
	public static String ToDBC(String input) {

		char c[] = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '\u3000') {
				c[i] = ' ';
			} else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
				c[i] = (char) (c[i] - 65248);

			}
		}
		String returnString = new String(c);

		return returnString;
	}

	public static void main(String args[]) throws Exception {
		String str = "辽H77C38";
		System.out.println(ToSBC(str));
		// System.out.println(appendZero("123",6));
		// // System.out.println("4406130101000001".substring(10));
		// String str1="4";
		// String str2="4";
		// System.out.println(str1.compareTo(str2));
		// System.out.println(getAmtNotWithPoint("12.3"));
		// String str =
		// "<p><font size=\"2\"><span style=\" mce_style=\"font-size: 10.5pt\">"
		// +
		// "依据绩abc效管理体系的规定，公司决定于</span><span style=\" mce_style=\"font-size: 10.5pt\">"
		// +
		// "2008</span><span style=\" mce_style=\"font-size: 10.5pt\">年</span><span style=\" "
		// +
		// "mce_style=\"font-size: 10.5pt\">12</span><span style=\" mce_style=\"font-size: 10.5pt\">"
		// +
		// "月</span><span style=\" mce_style=\"font-size: 10.5pt\">22</span><span style=\" "
		// +
		// "mce_style=\"font-size: 10.5pt\">日</span><span style=\" mce_style=\"font-size: 10.5pt\">"
		// +
		// "\"-2009</span><span style=\" mce_style=\"font-size: 10.5pt\">年</span><span style=\" "
		// +
		// "mce_style=\"font-size: 10.5pt\">1</span><span style=\" mce_style=\"font-size: 10.5pt\">"
		// +
		// "月</span><span style=\" mce_style=\"font-size: 10.5pt\"> 23& </span><span style=\" "
		// +
		// "mce_style=\"font-size: 10.5pt\">日期间进行</span><span style=\" mce_style=\"font-size: "
		// +
		// "10.5pt\">2008</span><span style=\" mce_style=\"font-size: 10.5pt\">年年度绩效考评工作，"
		// + "具体事项如下：</span></font></p>";
		// String str_text = Html2Text(str);
		// System.out.println(str_text);
		// String slice = abbreviate(str_text, 100, "...");
		// System.out.println(slice);
		// System.out.println(getMD5Str("xxzx"));
		//
		// String ss= "6,3号库";
		// String tmpName[] = ss.split(",");
		// System.out.println("***"+tmpName[0]+"****"+tmpName[1]);
		// System.out.println(BigDecimal.valueOf(DataUtils.mul(
		// DataUtils.div(10000, 30000, 4), 100)));
		// String name = "aaa.xlsx";
		// System.out.println(name.substring(name.lastIndexOf(".")));
		// System.out.println(DataUtils.getDiffer("2011-10-01", "2012-01-31"));
		//
		// System.out.println(getDateOfNextMonth("2010-10-10", 1));
		String t = "hfjkds中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国hfsdkj<img src='sasa' /> fjldsajflkdsjaflkdsjalf <img src='sada' ait=''/>sfdsfadas";
		t = new String(t.getBytes("GBK"), "GBK");
		System.out.println(t);
		// String utf8 = new String(t.getBytes( "UTF-8"));
		// System.out.println(utf8);
		// String unicode = new String(utf8.getBytes(),"UTF-8");
		// System.out.println(unicode);
		// String gbk = new String(unicode.getBytes("GBK"));
		//
		// System.out.println(gbk);

	}
}
