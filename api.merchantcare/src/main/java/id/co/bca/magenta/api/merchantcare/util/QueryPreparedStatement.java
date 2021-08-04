package id.co.bca.magenta.api.merchantcare.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryPreparedStatement {
	private static final Logger logger = LoggerFactory.getLogger(Criteria.class);

	// operator
	public static final String EQUALS = "=";
	public static final String GREATER = ">";
	public static final String GREATEREQUAL = ">=";
	public static final String LESS = "<";
	public static final String LESSEQUAL = "<=";
	public static final String LIKE = "LIKE";
	public static final String LEFT_LIKE = "LEFT_LIKE";
	public static final String RIGHT_LIKE = "RIGHT_LIKE";
	public static final String FULL_LIKE = "FULL_LIKE";
	public static final String NOTEQUAL = "<>";
	public static final String IN = "IN";
	public static final String NOT_IN = "NOT IN";
	public static final String OUTER_JOIN = "(+)";
	public static final String EQUALSDATE = "=date";
	public static final String BETWEENDATE = "BETWEEN";

	// operator not use
	public static final String NOT_NULL = "IS NOT NULL";
	public static final String NULL = "IS NULL";

	// punctuation
	public static final String QUESTION_MARK = "?";
	public static final String WILDCARD = "%";
	public static final String ENCLOSE = "(";
	public static final String DISCLOSE = ")";
	public static final String APOSTROPHE = "'";
	public static final String apostrophe = "apostrophe";
	public static final String DOUBLE_APOSTROPHE = "''";
	public static final String COMMA = ",";
	public static final String LEFT_SQUARE_BRACKET = "[";
	public static final String RIGHT_SQUARE_BRACKET = "]";
	public static final String EMPTY = "";
	public static final String SEMICOLON = ";";
	public static final String AND_OPT = ";;";
	public static final String OR_OPT = "\\|\\|";
	public static final String SPACE = " ";
	public static final String ENTER = "\n";
	public static final String DOUBLEENTER = "\n\n";
	public static final String TAB = "\t";
	public static final String PLUS = "+";
	public static final String MINUS = "-";
	public static final String default_begintime = " 00:00:00:000";
	public static final String default_endtime = " 23:59:59:999";
	public static final String SLASH = "/";
	public static final String BACKSLASH = "\\";
	public static final String BEGIN = "BEGIN" + ENTER;
	public static final String END = ENTER + "END;";
	public static final String[] DELIMITER1 = new String[]{AND_OPT,OR_OPT};
	public static final String DELIMITER2 = SEMICOLON;
	public static final String DELIMITER3 = COMMA;
	public static final String UPPER = "UPPER";
	public static final String LOWER = "LOWER";
	public static final String TO_DATE = "TO_DATE";
	public static final String AND = "AND";
	public static final String OR = "OR";
	public static final String DDMMYYYY = "DD-MM-YYYY";
	public static final String TIME24H = "HH24:MI:SS";
	public static final String TIME12H = "HH:MI:SS";
	public static final String BETWEENDATE_ENDFORMAT = 
			APOSTROPHE + COMMA + SPACE + APOSTROPHE + DDMMYYYY + SPACE
			+ TIME24H + APOSTROPHE + DISCLOSE;
	public static final String BETWEENDATE_default_begintime = 
			SPACE + "00:00:00" + BETWEENDATE_ENDFORMAT + SPACE + AND
			+ SPACE;
	public static final String BETWEENDATE_default_endtime = 
			SPACE + "23:59:59" + BETWEENDATE_ENDFORMAT;

	public static final String BETWEENDATE_ONLYDATE_ENDFORMAT = 
			APOSTROPHE + COMMA + SPACE + APOSTROPHE + DDMMYYYY + APOSTROPHE + DISCLOSE;
	public static final String BETWEENDATE_ONLYDATE_default_begin = 
			BETWEENDATE_ONLYDATE_ENDFORMAT + SPACE + AND
			+ SPACE;
	public static final String BETWEENDATE_ONLYDATE_default_end = 
			BETWEENDATE_ONLYDATE_ENDFORMAT;
	public static final String UNDERSCORE = "_";
	public static final String DOT = ".";
	public static final String CREATEDDATE = "createddate;equals;sysdate";
	public static final String MODIFIEDDATE = "modifieddate;equals;sysdate";
	public static final String HCPAuthHeaderKey = "Authorization";

	private final String left;
	private final String operator;
	private final String right;

	public static final String PROPS = "mms_bo_app.properties";
	public static final String LOGGER = "log4jApp.properties";
	public static final String PROP_PATH = "mms.properties.path";
	public static final String PROP_URL = "mms.properties.url";
	public static final String PROP_DB = "mms.properties.db.";
	public static final String PROP = "mms.properties";

	public QueryPreparedStatement(String left, String operator, String right) {
		this.left = left;
		this.operator = operator;

		if (right.contains(APOSTROPHE + SPACE + APOSTROPHE)) {
			right = right.replace(APOSTROPHE + SPACE + APOSTROPHE, EMPTY);
		}
		this.right = right;

	}

	public String toString() {
		StringBuilder criteria = new StringBuilder();
		String defaultCriteria = EMPTY;

		if (operator.equals(EQUALSDATE)) {
			defaultCriteria = "convert(varchar(20)," + left + ",105)" + operator.replace("date", EMPTY) + " ";
			criteria.append(defaultCriteria);
			criteria.append(right);
		} else if (operator.equals(BETWEENDATE)) {
			String[] between = right.split(",");
			String convertpart1 = "convert(varchar(10),convert(datetime, ";
			String convertpart2 = ", 105),121)";
			String between1 = convertpart1 + between[0] + convertpart2 + PLUS + APOSTROPHE + default_begintime
					+ APOSTROPHE + " AND ";
			String between2 = convertpart1 + between[1] + convertpart2 + PLUS + APOSTROPHE + default_endtime
					+ APOSTROPHE;
			defaultCriteria = left + " " + operator + " " + between1 + between2;
			criteria.append(defaultCriteria);
		} else if ((operator.equals(EQUALS) || operator.equals(NOTEQUAL)) && right.toUpperCase().contains("NULL")) {
			String _operator = "IS NULL"; 
			if (operator.equals(NOTEQUAL)) {
				_operator = "IS NOT NULL"; 
			}
			defaultCriteria = left + " " + _operator;
			criteria.append(defaultCriteria);
		} else if ((operator.equals(IN) || operator.equals(NOT_IN)) && right.toUpperCase().contains("NULL")) {
			String _operator = "IS NULL"; 
			if (operator.equals(NOT_IN)) {
				_operator = "IS NOT NULL"; 
			}
			
			criteria.append(ENCLOSE);
			// set handler for null values
			defaultCriteria = left + " " + _operator;
			criteria.append(defaultCriteria);
			
			List<String> valList = new ArrayList<>(); 
			String[] arValues = right.split(",");
			// eliminate null values
			for (String val : arValues) {
				if (!val.toUpperCase().contains("NULL"))
					valList.add(val);
			}
			
			if (valList.size() > 0) {
				criteria.append(" OR ");
				String valStr = String.join(",", valList);

				defaultCriteria = left + " " + operator + " ";
				criteria.append(defaultCriteria);
				criteria.append(ENCLOSE);
				criteria.append(valStr);
				criteria.append(DISCLOSE);
			}
			
			criteria.append(DISCLOSE);
		} else {
			defaultCriteria = left + " " + (operator.contains(LIKE) ? LIKE : operator) + " ";
			criteria.append(defaultCriteria);
		}
		
		if (operator.equals(EQUALS) && left.toUpperCase().contains("MID")) {
			if (right.contains(APOSTROPHE)) {
				criteria.append(right.replace(APOSTROPHE, EMPTY));
			} else {
				criteria.append(right);
			}
		} else if (operator.equals(EQUALS) || operator.equals(NOTEQUAL) || operator.equals(LESS)
				|| operator.equals(LESSEQUAL) || operator.equals(GREATER) || operator.equals(GREATEREQUAL)) {
			criteria.append(right);
		}
		if (operator.equals(IN) && !right.toUpperCase().contains("NULL")) {
			criteria.append(ENCLOSE);
			criteria.append(right);
			criteria.append(DISCLOSE);
		}
		if (operator.equals(NOT_IN) && !right.toUpperCase().contains("NULL")) {
			criteria.append(ENCLOSE);
			criteria.append(right);
			criteria.append(DISCLOSE);
		}
		if (operator.contains(LIKE)) {
			if (operator.equals(LEFT_LIKE)) {
				criteria.append(WILDCARD);
				criteria.append(right.replace(APOSTROPHE, EMPTY));
			}
			if (operator.equals(RIGHT_LIKE)) {
				criteria.append(right.replace(APOSTROPHE, EMPTY));
				criteria.append(WILDCARD);
			}
			if (operator.equals(FULL_LIKE)) {
				criteria.append(WILDCARD);
				criteria.append(right.replace(APOSTROPHE, EMPTY));
				criteria.append(WILDCARD);
			}
		}

		criteria.append(" ");

		return criteria.toString();
	}

	public static String ConvertToOperator(String operator) {
		String result = EMPTY;
		if (operator.equals("EQUALS")) {
			result = EQUALS;
		} else if (operator.equals("GREATER")) {
			result = GREATER;
		} else if (operator.equals("GREATEREQUAL")) {
			result = GREATEREQUAL;
		} else if (operator.equals("LESS")) {
			result = LESS;
		} else if (operator.equals("LESSEQUAL")) {
			result = LESSEQUAL;
		} else if (operator.equals("LEFT_LIKE")) {
			result = LEFT_LIKE;
		} else if (operator.equals("RIGHT_LIKE")) {
			result = RIGHT_LIKE;
		} else if (operator.equals("FULL_LIKE")) {
			result = FULL_LIKE;
		} else if (operator.equals("NOTEQUAL")) {
			result = NOTEQUAL;
		} else if (operator.equals("IN")) {
			result = IN;
		} else if (operator.equals("NOT_IN")) {
			result = NOT_IN;
		} else if (operator.equals("OUTER_JOIN")) {
			result = OUTER_JOIN;
		} else if (operator.equals("EQUALSDATE")) {
			result = EQUALSDATE;
		} else if (operator.equals("BETWEENDATE")) {
			result = BETWEENDATE;
		}
		return result;
	}}
