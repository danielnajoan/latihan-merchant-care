package id.co.bca.magenta.api.merchantcare.util;

import static id.co.bca.magenta.api.merchantcare.util.Criteria.AND_OPT;
import static id.co.bca.magenta.api.merchantcare.util.Criteria.APOSTROPHE;
import static id.co.bca.magenta.api.merchantcare.util.Criteria.COMMA;
import static id.co.bca.magenta.api.merchantcare.util.Criteria.ConvertToOperator;
import static id.co.bca.magenta.api.merchantcare.util.Criteria.DELIMITER1;
import static id.co.bca.magenta.api.merchantcare.util.Criteria.DELIMITER2;
import static id.co.bca.magenta.api.merchantcare.util.Criteria.DELIMITER3;
import static id.co.bca.magenta.api.merchantcare.util.Criteria.DELIMITER_OPT;
import static id.co.bca.magenta.api.merchantcare.util.Criteria.DISCLOSE;
import static id.co.bca.magenta.api.merchantcare.util.Criteria.EMPTY;
import static id.co.bca.magenta.api.merchantcare.util.Criteria.ENCLOSE;
import static id.co.bca.magenta.api.merchantcare.util.Criteria.ENTER;
import static id.co.bca.magenta.api.merchantcare.util.Criteria.LEFT_SQUARE_BRACKET;
import static id.co.bca.magenta.api.merchantcare.util.Criteria.MINUS;
import static id.co.bca.magenta.api.merchantcare.util.Criteria.OR_OPT;
import static id.co.bca.magenta.api.merchantcare.util.Criteria.QUESTION_MARK;
import static id.co.bca.magenta.api.merchantcare.util.Criteria.RIGHT_SQUARE_BRACKET;
import static id.co.bca.magenta.api.merchantcare.util.Criteria.SEMICOLON;
import static id.co.bca.magenta.api.merchantcare.util.Criteria.SPACE;
import static id.co.bca.magenta.api.merchantcare.util.Criteria.TAB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 		selectBuilder(tablename, restQuery, aliasname, columname)
        whereBuilder(restWhereQuery, aliasname)
        updateBuilder(tablename, restUpdateQuery)
        insertBuilder(tablename, restInsertQuery)
 * */
public class QueryBuilder {
	private static final Logger logger = LoggerFactory.getLogger(QueryBuilder.class);

	public String queryBuilder(String tablename, String restQuery, String aliasname, String columname) {
		String query = build(tablename, restQuery, aliasname, columname);
		return query;
	}

	public static String build(String tablename, String restQuery, String aliasname, String columname) {

		SelectQuery sql = new SelectQuery();
		Table table = new Table(tablename, aliasname);// Tablename,aliasTablename
		table.addColumnsToSelect(columname);// columnname

		// for add table
		sql.addTable(table);
		if (StringUtils.isBlank(restQuery)) {

		} else {
			List<String> criteriaOperator = new ArrayList<>();
			List<List<String>> criteria = queryDelimiter(restQuery, 
					DELIMITER_OPT, DELIMITER2, DELIMITER3, criteriaOperator);
			sql.setCriteriaOperator(criteriaOperator);
			for (int i = 0; i < criteria.size(); i++) {
				String column = "", operator = "", value = "";
				for (int j = 0; j < criteria.get(i).size(); j++) {
					column = criteria.get(i).get(0);
					operator = ConvertToOperator(criteria.get(i).get(1).toUpperCase());
					value = criteria.get(i).get(2).toUpperCase();
				}
				sql.addCriteria(table, column, operator, value);
			}
		}
		return sql.toString();
	}

	public static List<List<String>> queryDelimiter(String query, String[] delimiters1, String delimiter2,
			String delimiter3, List<String> criteriaOperator) {
		List<List<String>> listCriteria = new ArrayList<List<String>>();
		try {
			if (null != delimiters1) {
				String qTemp = query
						.replaceAll(Criteria.AND_OPT, "~AND~")
	  	    		  	.replaceAll(Criteria.OR_OPT, "~OR~");
			    String patternSplit = Arrays.asList(delimiters1).stream()
			  	      .map(n -> String.valueOf(
			  	    		  n
			  	    		  	.replace(Criteria.AND_OPT, "~AND~")
			  	    		  	.replace(Criteria.OR_OPT, "~OR~")))
			  	      .collect(Collectors.joining(")|(", "(", ")"));
				List<String> splitByDelimiter1List = Arrays
							.stream(qTemp.split(patternSplit))
							.collect(Collectors.toList());
				
				for (String splitByDelimiter1 : splitByDelimiter1List) {
					qTemp = qTemp.replace(splitByDelimiter1, "");
				}
				List<String> criteriaOperatorTmp = Arrays.stream(qTemp.split("~~"))
		  	      .map(n -> String.valueOf(n
		  	    		  	.replace("~", "")))
		  	      .collect(Collectors.toList());
				criteriaOperator.addAll(criteriaOperatorTmp);
				
				for (String part : splitByDelimiter1List) {
					List<String> criteria = new ArrayList<String>();
					String parts2[] = part.toString().split(delimiter2);
					for (int j = 0; j < parts2.length; j++) {
						// String
						// parts3=(j==2)?((!StringUtils.isNumeric(parts2[j].toString()))?APOSTROPHE+parts2[j].toString()+APOSTROPHE:parts2[j].toString()):parts2[j].toString();
						String parts3 = "";
						if (j == 2) {
								if (/*!StringUtils.isNumeric(parts2[j].toString()) && */!parts2[0].toUpperCase().equals("POINT")) {
								parts3 = APOSTROPHE + parts2[j].toString() + APOSTROPHE;
							} else {
								parts3 = parts2[j].toString();
							}
						} else {
							parts3 = parts2[j].toString();
						}
						// 20161222 - diganti ke uppercase semua di awal split
						// //utk operator supaya not casesensitive
						// if (j==1) {
						// parts3=parts3.toUpperCase();
						// }
						if (parts3.toUpperCase().contains("NULL") || parts3.toUpperCase().contains("GETDATE()")
								|| parts3.toUpperCase().contains("SYSDATE") || parts3.toUpperCase().contains("@TEMPVAR")
								|| parts3.toUpperCase().contains("DBO.FN_") || parts3.toUpperCase().contains("SELECT")) {
							parts3 = parts3.replace(APOSTROPHE, EMPTY);
						}
						if (parts3.contains(delimiter3)) {
							List<String> criteria3 = new ArrayList<String>();
							String valueparts3[] = parts3.replace(APOSTROPHE, EMPTY).split(delimiter3);
							for (int k = 0; k < valueparts3.length; k++) {
								String value = valueparts3[k];
								if (!StringUtils.isNumeric(value)) {
									value = APOSTROPHE + value + APOSTROPHE;
								}
								criteria3.add(value);
							}
							parts3 = criteria3.toString().replace(LEFT_SQUARE_BRACKET, EMPTY).replace(RIGHT_SQUARE_BRACKET,
									EMPTY);
						}
						criteria.add(parts3);
					}
					listCriteria.add(criteria);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return listCriteria;
	}
	
	/*
	 * build map object consist of 
	 * 	CRITERIA -> queries where clause per condition
	 *  PARAMETER_TYPE -> list of type parameter used by preparedstatement
	 */
	public static Map<String, Object> queryDelimiterPreparedStatement(String query, String delimiter1,
			String delimiter2, String delimiter3) {
		Map<String, Object> rtrn = new HashMap<>();
		List<List<String>> listCriteria = new ArrayList<List<String>>();
		List<ParameterTypeEnum> listTypeParameter = new ArrayList<>();
		try {
			String[] parts = query.split(delimiter1);
			for (int i = 0; i < parts.length; i++) {
				List<String> criteria = new ArrayList<String>();
				String parts2[] = parts[i].toString().split(delimiter2);
				for (int j = 0; j < parts2.length; j++) {
					// String
					// parts3=(j==2)?((!StringUtils.isNumeric(parts2[j].toString()))?APOSTROPHE+parts2[j].toString()+APOSTROPHE:parts2[j].toString()):parts2[j].toString();
					String parts3 = "";
					ParameterTypeEnum type = ParameterTypeEnum.NULL;
					if (j == 2) {
						if (!StringUtils.isNumeric(parts2[j].toString()) || parts[i].toUpperCase().contains("MID")) {
							parts3 = parts2[j].toString();
							type = ParameterTypeEnum.STRING;
						} else {
							parts3 = parts2[j].toString();
							type = ParameterTypeEnum.INTEGER;
						}
					} else {
						parts3 = parts2[j].toString();
					}
					// 20161222 - diganti ke uppercase semua di awal split
					// //utk operator supaya not casesensitive
					// if (j==1) {
					// parts3=parts3.toUpperCase();
					// }
					if (parts3.toUpperCase().contains("NULL") || parts3.toUpperCase().contains("GETDATE()")
							|| parts3.toUpperCase().contains("SYSDATE") || parts3.toUpperCase().contains("@TEMPVAR")
							|| parts3.toUpperCase().contains("DBO.FN_") || parts3.toUpperCase().contains("SELECT")) {
						parts3 = parts3.replace(APOSTROPHE, EMPTY);
						type = ParameterTypeEnum.STRING;
					}
					if (parts3.contains(delimiter3)) {
						List<String> criteria3 = new ArrayList<String>();
						String valueparts3[] = parts3.replace(APOSTROPHE, EMPTY).split(delimiter3);
						for (int k = 0; k < valueparts3.length; k++) {
							String value = valueparts3[k];
							if (!StringUtils.isNumeric(value) || parts[i].toUpperCase().contains("MID")) {
								type = ParameterTypeEnum.STRING;
							} else {
								type = ParameterTypeEnum.INTEGER;
							}
							if (j == 2) {
								listTypeParameter.add(type);
							}
							criteria3.add(value);
						}
						parts3 = criteria3.toString().replace(LEFT_SQUARE_BRACKET, EMPTY).replace(RIGHT_SQUARE_BRACKET,
								EMPTY);
					} else {
						if (j == 2) {
							listTypeParameter.add(type);
						}

					}
					criteria.add(parts3);
				}
				listCriteria.add(criteria);
			}
			rtrn.put(StaticVariable.CRITERIA, listCriteria);
			rtrn.put(StaticVariable.PARAMETER_TYPE, listTypeParameter);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return rtrn;
	}

	/*
	 * 23 Nov 2016 ADDITION untuk generate query SELECT, UPDATE, INSERT, WHERE
	 */
	// SELECT BUILDER - DONE : SELECT [alias].[columnname] FROM [tablename]
	public static String selectBuilder(String tablename, String restQuery, String aliasname, String columname) {
		String query = build(tablename, restQuery, aliasname, columname);
		return query;
	}

	// WHERE BUILDER - DONE : WHERE [aliasname].[columnname]=[value]
	public static String whereBuilder(String restWhereQuery, String aliasname) {
		return buildWhere("", restWhereQuery, aliasname, "");
	}

	// tambahan baru 03052019 preparedstatement query
	public static Map<String, Object> whereBuilderPreparedStatement(String restWhereQuery, String aliasname) {
		return buildWherePreparedStatement("", restWhereQuery, aliasname, "");
	}

	// INSERT BUILDER - in progress : INSERT INTO [tablename] ([colunname])
	// VALUES ([values])
	public static String insertBuilder(String tablename, String restInsertQuery) {
		return buildInsert(tablename, restInsertQuery, "", "");
	}

	// UPDATE BUILDER - DONE : UPDATE [tablename] set [columnname]=[value]
	public static String updateBuilder(String tablename, String restUpdateQuery) {
		return buildUpdate(tablename, restUpdateQuery, "", "");
	}

	public static String buildWhere(String tablename, String restQuery, String aliasname, String columname) {

		WhereQuery sql = new WhereQuery();
		Table table = new Table(tablename, aliasname);// Tablename,aliasTablename
		table.addColumnsToSelect(columname);// columnname

		// for add table
		sql.addTable(table);
		if (StringUtils.isBlank(restQuery)) {

		} else {
			List<String> criteriaOperator = new ArrayList<>();
			List<List<String>> criteria = queryDelimiter(restQuery, 
					new String[]{AND_OPT,OR_OPT}, SEMICOLON, COMMA, criteriaOperator);
			sql.setCriteriaOperator(criteriaOperator);
			for (int i = 0; i < criteria.size(); i++) {
				String column = "", operator = "", value = "";
				for (int j = 0; j < criteria.get(i).size(); j++) {
					column = criteria.get(i).get(0);
					operator = ConvertToOperator(criteria.get(i).get(1).toUpperCase());
					if (column.toUpperCase().equals("PASSWORD")) {
						value = criteria.get(i).get(2);
					} else {
						value = criteria.get(i).get(2).toUpperCase();
					}

				}
				if (value.toUpperCase().equals("'TRUE'")) {
					value = "1";
				} else if (value.toUpperCase().equals("'FALSE'")) {
					value = "0";
				}
				sql.addCriteria(table, column, operator, value);
			}
		}
		return sql.toString();
	}

	/*
	 * build map object consist of 
	 * 	CRITERIA -> query used for preparedstatement
	 *  PARAMETER_TYPE -> list of type parameter used for preparedstatement 
	 *  PARAMETER_VALUE -> list of value parameter used for preparedstatement
	 */
	public static Map<String, Object> buildWherePreparedStatement(String tablename, String restQuery, String aliasname,
			String columname) {
		WhereQuery sql = new WhereQuery();
		Table table = new Table(tablename, aliasname);// Tablename,aliasTablename
		table.addColumnsToSelect(columname);// columnname
		sql.addTable(table); // for add table
		
		Map<String, Object> mapResult = new HashMap<>();
		List<Integer> parametersType = new ArrayList<>();
		List<String> parametersValue = new ArrayList<>();
		
		if (restQuery.equals("") || restQuery.isEmpty() || restQuery == null || restQuery == "") {

		} else {
			Map<String, Object> result = queryDelimiterPreparedStatement(restQuery, 
					DELIMITER1, DELIMITER2, DELIMITER3);
			List<List<String>> criteria = (List<List<String>>) result.get(StaticVariable.CRITERIA);
			parametersType = (List<Integer>) result.get(StaticVariable.PARAMETER_TYPE);
			for (int i = 0; i < criteria.size(); i++) {
				String column = "", operator = "", value = "";
				column = criteria.get(i).get(0);
				operator = ConvertToOperator(criteria.get(i).get(1).toUpperCase());
				if (column.toUpperCase().equals("PASSWORD")) {
					value = criteria.get(i).get(2);
				} else {
					value = criteria.get(i).get(2).toUpperCase();
				}
				parametersValue.add(value);
				sql.addCriteriaPrepared(table, column, operator, QUESTION_MARK);
			}
		}
		String queryPreparedStatement = sql.toStringPrepare();
		mapResult.put(StaticVariable.CRITERIA, queryPreparedStatement);
		mapResult.put(StaticVariable.PARAMETER_VALUE, parametersValue);
		mapResult.put(StaticVariable.PARAMETER_TYPE, parametersType);
		return mapResult;
	}

	public static String buildUpdate(String tablename, String restQuery, String aliasname, String columname) {

		UpdateQuery sql = new UpdateQuery();
		Table table = new Table(tablename, aliasname);// Tablename,aliasTablename
		table.addColumnsToSelect(columname);// columnname

		// for add table
		sql.addTable(table);
		if (StringUtils.isBlank(restQuery)) {

		} else {
			List<String> criteriaOperator = new ArrayList<>();
			List<List<String>> criteria = queryDelimiter(restQuery, 
					new String[]{AND_OPT,OR_OPT}, SEMICOLON, COMMA, criteriaOperator);
//			sql.setCriteriaOperator(criteriaOperator);
			for (int i = 0; i < criteria.size(); i++) {
				String column = "", operator = "", value = "";
				for (int j = 0; j < criteria.get(i).size(); j++) {
					column = criteria.get(i).get(0);
					operator = ConvertToOperator(criteria.get(i).get(1).toUpperCase());
					value = criteria.get(i).get(2);
				}
				if (value.toUpperCase().equals("'TRUE'")) {
					value = "1";
				} else if (value.toUpperCase().equals("'FALSE'")) {
					value = "0";
				}
				if (!value.equals("null")) {
					if (column.toUpperCase().equals("PHONE")
					// ||column.toUpperCase().equals("MID")
					) {
						value = APOSTROPHE + value + APOSTROPHE;
					}
					// 2016.12.07-1-pengecekan jika MINUS dijadikan EMPTY
					if (value.toUpperCase().equals(APOSTROPHE + MINUS + APOSTROPHE)) {
						value = value.replace(MINUS, EMPTY);
					}
					sql.addCriteria(table, column, operator, value);
				}
			}
		}
		return sql.toString();
	}

	@SuppressWarnings("unused")
	public static String buildInsert(String tablename, String restQuery, String aliasname, String columname) {

		InsertQuery sql = new InsertQuery();

		// table.addColumnsToSelect(columname);//columnname
		List<String> listcolumn = new ArrayList<String>();
		List<String> listvalues = new ArrayList<String>();
		String columndefine = "";
		String valuesdefine = "";
		// for add table

		if (StringUtils.isBlank(restQuery)) {

		} else {
			List<String> criteriaOperator = new ArrayList<>();
			List<List<String>> criteria = queryDelimiter(restQuery, 
					new String[]{AND_OPT,OR_OPT}, SEMICOLON, COMMA, criteriaOperator);
//			sql.setCriteriaOperator(criteriaOperator);
			for (int i = 0; i < criteria.size(); i++) {
				String column = "", operator = "", value = "";
				for (int j = 0; j < criteria.get(i).size(); j++) {
					column = criteria.get(i).get(0);
					operator = ConvertToOperator(criteria.get(i).get(1).toUpperCase());
					value = criteria.get(i).get(2);
				}
				// 2016.12.07 - untuk list yang akan diinsert, hanya akan di
				// list jika value nya tidak null
				if (!value.equals("null")) {
					if (value.toUpperCase().equals("'TRUE'")) {
						value = "1";
					} else if (value.toUpperCase().equals("'FALSE'")) {
						value = "0";
					}
					listcolumn.add(column);
					if (column.toUpperCase().equals("NOTES")) {
						if (StringUtils.isNumeric(value)) {
							value = APOSTROPHE + value + APOSTROPHE;
						}
					}
					/*if (column.toUpperCase().equals("MID") || column.toUpperCase().equals("PHONE")) {
						value = APOSTROPHE + value + APOSTROPHE;
					}*/
					// 2016.12.07-1-pengecekan jika MINUS dijadikan EMPTY
					if (value.toUpperCase().equals(APOSTROPHE + MINUS + APOSTROPHE)) {
						value = value.replace(MINUS, EMPTY);
					}
					listvalues.add(value);
				}

				// sql.addCriteria(table, column, operator, value);
			}
			columndefine = listcolumn.toString().replace(LEFT_SQUARE_BRACKET, EMPTY).replace(RIGHT_SQUARE_BRACKET,
					EMPTY);
			valuesdefine = listvalues.toString().replace(LEFT_SQUARE_BRACKET, EMPTY).replace(RIGHT_SQUARE_BRACKET,
					EMPTY);
		}
		String param = tablename + ENTER + TAB + ENCLOSE + columndefine + DISCLOSE + ENTER + "VALUES" + SPACE + SPACE
				+ ENCLOSE + valuesdefine + DISCLOSE;

		Table table = new Table(param, "");// Tablename,aliasTablename
		sql.addTable(table);
		// System.out.println(columndefine);
		// System.out.println(valuesdefine);
		return sql.toString();
	}
}