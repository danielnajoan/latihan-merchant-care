
package id.co.bca.magenta.api.merchantcare.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class StaticVariable {

	// ######## DEVELOPMENT COS ########
	// public static final String PROPS_MMSBO_PATH =
	// "D:\\PROJECT\\MAGENTA\\api.emsmh\\src\\";
	// public static final String PROPS_MMSBO = "api.merchantcare.properties";
	// public static final String PROPERTIES_PATH = PROPS_MMSBO_PATH + PROPS_MMSBO;
	// public static final String LOG4J_PATH =
	// "D:\\PROJECT\\MAGENTA\\api.emsmh\\src\\api.merchantsolution.log4j.properties";

	// ######## DEVELOPMENT QIQI ########
	 public static final String PROPS_MMSBO_PATH =
	 "D:\\Java\\Eclipse-Workspace\\api.merchantcare\\";
	 public static final String PROPS_MMSBO = "api.merchantcare.properties";
	 public static final String PROPERTIES_PATH = PROPS_MMSBO_PATH + PROPS_MMSBO;
//	 public static final String LOG4J_PATH =
//	 "C:\\Java\\eclipse-jee-oxygen-magenta.ms-workspace\\api.merchantcare\\api.merchantsolution.log4j.properties";

	// ######## DEVELOPMENT - WEBLOGIC ########
//
//		public static final String PROPS_MMSBO_PATH = "D:\\MyWork\\BCA\\Magenta\\api.emsmh\\src\\";
//		public static final String PROPS_MMSBO = "api.merchantcare.properties";
//		public static final String PROPERTIES_PATH = PROPS_MMSBO_PATH + PROPS_MMSBO;
//		public static final String LOG4J_PATH = "D:\\MyWork\\BCA\\Magenta\\api.emsmh\\src\\api.merchantsolution.log4j.properties";
	// ######## DEVELOPMENT - WEBLOGIC ########

//	public static final String PROPS_MMSBO_PATH = "/bcaedcc/app/config/";
//	public static final String PROPS_MMSBO = "api.merchantcare.properties";
//	public static final String PROPERTIES_PATH = PROPS_MMSBO_PATH + PROPS_MMSBO;
//	public static final String LOG4J_PATH = "/bcaedcc/app/config/api.merchantsolution.log4j.properties";

	// ######## OTHER ########
	public static final String LOGGER = "mms_bo_app.log4j.properties";
	public static final String PROP_PATH = "mms.properties.path";
	public static final String PROP_URL = "mms.properties.url";
	public static final String PROP_DB = "mms.properties.db.";
	public static final String PROP = "mms.properties";

	public static final String TOTAL_COUNT = "totalcount";
	public static final String ERR_MSG = "err_msg";
	public static final String ISSUCCESS = "issuccess";
	public static final String AFFECTEDROW = "affectedrow";
	public static final String MESSAGE = "message";
	public static final String GO = "\nGO\n";
	public static final String DATE_PATTERN = "yyyy-MM-dd";
	public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";

	public static final String CRITERIA = "criteria";
	public static final String PARAMETER_TYPE = "parameter_type";
	public static final String PARAMETER_VALUE = "parameter_value";
	public static final String ROLE_USER = "ROLE_USER";
	public static final String ROLE_ADMIN = "ROLE_ADMIN";

	public static ErrorDetail getErrorDetailSaveUpdate(String err_msg) {
		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(err_msg, JsonObject.class);
		int isSuccess = gson.fromJson(jsonObject.get("err_msg").getAsJsonObject().get("issuccess"), Integer.class);

		// *****CONVERT OUTPUT JSON TO OBJECT*****
		ListFromJSON listFromJSON = new ListFromJSON(err_msg);
		List<GenericClass> list = listFromJSON.getList();
		GenericJSON info = new GenericJSON();
		info.setAdditionalProperty(list);

		// *****SET ERROR DETAIL*****
		ErrorDetail _errorDetail = new ErrorDetail();
		if (isSuccess == 0) {
			_errorDetail.setStatus(HttpStatus.CONFLICT.value());
			_errorDetail.setMessage(HttpStatus.CONFLICT.name());
		} else {
			_errorDetail.setStatus(HttpStatus.OK.value());
			_errorDetail.setMessage(HttpStatus.OK.name());
		}
		_errorDetail.setDetailInfo(info);
		return _errorDetail;
	}

	// ######## TABLE NAME ########

	// public static final String FDM_GROUP = "FDM_GROUP";
	// public static final String FDM_PEMILIK = "FDM_PEMILIK";
	// public static final String FDM_MERCHANT = "FDM_MERCHANT";
	// public static final String FDM_OUTLET = "FDM_OUTLET";
	// public static final String FDM_OUTLET_TERMINAL = "FDM_OUTLET_TERMINAL";
	// public static final String TEMPLATE2 = "TEMPLATE";
	// public static final String HELLOWORLD = "TEMPLATE";

	// ######## MASTER ########

	// public static final String MCC = "MCC";
	// public static final String LOB = "LOB";
	// public static final String MERK = "MERK";
	// public static final String LOKASIUSAHA = "LOKASIUSAHA";
	// public static final String MERCHANTOFFICER = "MERCHANTOFFICER";
	// public static final String TIPELOKASIUSAHA = "TIPELOKASIUSAHA";
	// public static final String FACILITY = "FACILITY";
	// public static final String FACILITY_ITEM = "FACILITY_ITEM";
	// public static final String FACILITY_FITUR = "FACILITY_FITUR";
	// public static final String FACILITYCARD = "FACILITYCARD";
	// public static final String FAC_FITUR_ITEM = "FAC_FITUR_ITEM";
	// public static final String FAC_FITUR_LIST = "FAC_FITUR_LIST";
	// public static final String FAC_FITUR_LIST_CARD = "FAC_FITUR_LIST_CARD";
	// public static final String GROUP = "INDUK";
	// public static final String CABANG = "CABANG";
	// public static final String DSR = "DSR";
	public static final String EDC_CARE_PROMO = "EDCCare_Promo";
	public static final String EDC_CARE_lOGIN = "EDCCare_login";
	public static final String EDC_CARE_SK = "EDCCare_SK";
	public static final String COMPLAINT_CALL = "ComplaintCall";
	public static final String COMPLAINT_MAIN = "ComplaintMain";
	public static final String COMPLAINT_EDC = "ComplaintEDC";

	// ######## STORED PROCEDURE RETURN ########
	public static final String SP_STATUS_MSG = "O_STATUS_MSG";
	public static final String SP_CURR_RECORD = "O_CURR_RECORD";
	public static final String SP_DATA_RECORD = "O_DATA_RECORD";

	// ######## LABEL ########
	public static final String LB_EXIST = "EXIST";
	public static final String LB_AVAILABLE = "AVAILABLE";
	
	public static String getProp(String key) {
		return ApiMerchantCareUtility.getInstance().getProperty(key);
	}
	
	public static String getProp(String key, String de_fault) {
		return ApiMerchantCareUtility.getInstance().getProperty(key,de_fault);
	}

	public static String getNFirstCharacter(String value, Integer length, String de_fault) {
		if (StringUtils.isEmpty(value)) {
			return de_fault;
		} else {
			if (value.length() > length) {
				return value.substring(0, length);
			} else {
				return value;
			}
		}
	}
	
	public static String getNLastCharacter(String value, Integer length, String de_fault) {
		if (StringUtils.isEmpty(value)) {
			return de_fault;
		} else {
			if (value.length() > length) {
				return value.substring(value.length() - length, value.length());
			} else {
				return value;
			}
		}
	}
	
	public static String dateStringConvPattern(String date, String srcPattern, String destPattern)
			throws ParseException {
		if (null == date || date.trim().isEmpty()) {
			return null;
		} else {
			if (null == srcPattern || srcPattern.trim().isEmpty())
				srcPattern = StaticVariable.DATE_PATTERN;
			if (null == destPattern || destPattern.trim().isEmpty())
				destPattern = StaticVariable.DATE_PATTERN;
			
			Date srcDate = StaticVariable.string2Date(date, srcPattern);
			
			SimpleDateFormat sdf = new SimpleDateFormat(destPattern);
			return sdf.format(srcDate);
		}
	}

	public static String date2String(Date date, String pattern) {
		if (null == date) {
			return null;
		} else {
			if (StringUtils.isBlank(pattern)) {
				pattern = StaticVariable.DATE_PATTERN;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.format(date);
		}
	}

	public static Date string2Date(String date, String pattern) throws ParseException {
		if (StringUtils.isBlank(date) || date.trim().equalsIgnoreCase("null")) {
			return null;
		} else {
			if (StringUtils.isBlank(pattern)) {
				pattern = StaticVariable.DATE_PATTERN;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.parse(date);
		}
	}

	public static boolean compareString(String str1, String str2) {
		if (StringUtils.isBlank(str1) || str1.trim().equalsIgnoreCase("null")) {
			str1 = null;
		}
		if (StringUtils.isBlank(str2) || str2.trim().equalsIgnoreCase("null")) {
			str2 = null;
		}
		if (null != str1 && null != str2)
			return str1.equals(str2);

		if (null == str1 && null == str2)
			return true;

		return false;
	}

	public static boolean compareStringIgnoreCase(String str1, String str2) {
		if (StringUtils.isBlank(str1) || str1.trim().equalsIgnoreCase("null")) {
			str1 = null;
		}
		if (StringUtils.isBlank(str2) || str2.trim().equalsIgnoreCase("null")) {
			str2 = null;
		}
		if (null != str1 && null != str2)
			return str1.equalsIgnoreCase(str2);

		if (null == str1 && null == str2)
			return true;

		return false;
	}

	public static boolean compareInteger(Integer int1, Integer int2) {
		if (null != int1 && null != int2)
			return int1.equals(int2);

		if (null == int1 && null == int2)
			return true;
		
		return false;
	}

	public static boolean compareLong(Long long1, Long long2) {
		if (null != long1 && null != long2)
			return long1.equals(long2);

		if (null == long1 && null == long2)
			return true;
		
		return false;
	}

	public static boolean compareDate(Date date1, Date date2) {
		if (null != date1 && null != date2)
			return date1.compareTo(date2) == 0;

		if (null == date1 && null == date2)
			return true;
		
		return false;
	}

	public static boolean compareBoolean(Boolean bol1, Boolean bol2) {
		if (null != bol1 && null != bol2)
			return bol1.equals(bol2);

		if (null == bol1 && null == bol2)
			return true;
		
		return false;
	}

	public static boolean getDefaultBoolean(Boolean bol) {
		if (null == bol)
			return false;

		return bol;
	}

	public static LocalDateTime string2DateTime(String dateTime, String pattern) throws ParseException {
		if (null == dateTime || dateTime.trim().isEmpty()) {
			return null;
		} else {
			if (StringUtils.isBlank(pattern)) 
				pattern = StaticVariable.DATETIME_PATTERN;
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
			return LocalDateTime.parse(dateTime, dtf);
		}
	}
	
	public static <T> Predicate<T> distinctByKey(
		    Function<? super T, ?> keyExtractor) {
		  
	    Map<Object, Boolean> seen = new ConcurrentHashMap<>(); 
	    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null; 
	}

	public static String starckTraceToString(Exception ex) {
		String result = ex.getMessage() + "\n";
		result += ex.toString() + "\n";
		StackTraceElement[] trace = ex.getStackTrace();
		for (int i = 0; i < trace.length; i++) {
			result += trace[i].toString() + "\n";
		}
		return result;
	}

	public static String map2String(Map inParamMap) {
		if (null == inParamMap)
			return null;
		return Arrays.toString(inParamMap.entrySet().toArray());
	}

	public static String getOrderBy(String orderby) {
		String part[] = orderby.split(Pattern.quote(" "));
		String multiorder[] = orderby.split(",");
		String val = "";

		if (part[0].toUpperCase().contains("DATE")) {
			if (part.length == 1) {
				val = " ORDER BY TO_DATE(" + orderby + ",'DD-MM-YYYY HH24:MI:SS')";
			} else {
				val = " ORDER BY TO_DATE(" + part[0] + ",'DD-MM-YYYY HH24:MI:SS') " + part[1];
			}

		} else if (part.length == 1) {
			if(multiorder.length==1) {
			val = " ORDER BY UPPER(" + orderby + ")";
		} else {
				val = " ORDER BY " + orderby;
			}
			
		} else {
			if(multiorder.length==1) {
			val = " ORDER BY UPPER(" + part[0] + ") " + part[1];
			}else {
				val = " ORDER BY " + part[0] + " " + part[1];
			}
			
		}
		return val;
	}
}
