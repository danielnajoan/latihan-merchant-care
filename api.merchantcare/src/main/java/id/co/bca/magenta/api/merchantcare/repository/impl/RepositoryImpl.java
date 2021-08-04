package id.co.bca.magenta.api.merchantcare.repository.impl;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;

import org.apache.commons.lang3.StringUtils;

public class RepositoryImpl {
	public String reformatSearchValue(Class clazz, String search) {
		if (StringUtils.isNotBlank(search)) {
		    List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
	        for(Field field: fields) {
	        	Column col = field.getAnnotation(Column.class);
	            if (null != col) {
		            String fieldName = field.getName();
	            	String colName = col.name();
		            search = search.replace(fieldName+";", colName+";");
	            }
	        }
		}
		
		return search;
	}
	
	public String reformatOrderValue(Class clazz, String order) {
		if (StringUtils.isNotBlank(order)) {
		    List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
			String[] arOrderby = order.split(",");
			
			for (int i = 0; i < arOrderby.length; i++) {
				String orderTmp = arOrderby[i] + " ";
		        for(Field field: fields) {
		        	Column col = field.getAnnotation(Column.class);
		            if (null != col) {
			            String fieldName = field.getName();
		            	String colName = col.name();
		            	orderTmp = orderTmp.replace(fieldName+" ", colName+" ");
		            }
		        }
		        arOrderby[i] = orderTmp;
			}
			
			order = String.join(",", arOrderby);
		}
		
		return order;
	}
}
