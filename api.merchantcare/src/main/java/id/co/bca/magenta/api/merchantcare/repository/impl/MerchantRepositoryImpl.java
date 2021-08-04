package id.co.bca.magenta.api.merchantcare.repository.impl;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import id.co.bca.magenta.api.merchantcare.entity.Merchant;
import id.co.bca.magenta.api.merchantcare.repository.MerchantRepository;
import id.co.bca.magenta.api.merchantcare.util.BeanPropertyRowMapperCustomized;
import id.co.bca.magenta.api.merchantcare.util.PageSize;
import id.co.bca.magenta.api.merchantcare.util.QueryBuilder;
import id.co.bca.magenta.api.merchantcare.util.StaticVariable;

@Repository
public class MerchantRepositoryImpl extends RepositoryImpl implements MerchantRepository {
	private static final Logger logger = LoggerFactory.getLogger(MerchantRepositoryImpl.class);

	@Autowired
	@Qualifier("jdbcTemplateEms")
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Merchant> findAll(long hashing, int page, int size, String search, String orderby) {
		Map<String, Object> getDataByCallSP = getDataByCallSP(hashing, page, size, search, orderby);
		List<Merchant> list = (List<Merchant>) getDataByCallSP.get(StaticVariable.SP_DATA_RECORD);
		
		return list;
	}

	@Override
	public Merchant findById(long hashing, String id) {
		Map<String, Object> getDataByCallSP = getDataByCallSP(hashing, 
				1, 1, "mid;equals;" + id, "mid");
		List<Merchant> list = (List<Merchant>) getDataByCallSP.get(StaticVariable.SP_DATA_RECORD);
		
		if (null != list && list.size() > 0) {
			return list.get(0);
		}
		
		return null;
	}

	@Override
	public boolean isExist(long hashing, String id) {
		return (null != findById(hashing, id));
	}

	private Map<String, Object> getDataByCallSP(long hashing, 
			int page, int size, String search, String orderby) {
		search = reformatSearchValue(Merchant.class, search);

		// *****DEFINE WHERE*****
		String where = QueryBuilder.whereBuilder(search, "").replace("user_", "u.");

		orderby = reformatOrderValue(Merchant.class, orderby);

		// *****DEFINE ORDERBY*****
		if (StringUtils.isNotBlank(orderby)) {
			orderby = " ORDER BY " + orderby + "\n";
		}

		// *****DEFINE OFFSET and FETCH*****
		PageSize ps = new PageSize(page, size);
		String paging = ps.getPaging();
		
		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("whereq", where);
		inParamMap.put("orderby", orderby);
		inParamMap.put("paging", paging);

		logger.info("("+hashing+") "+"Call: [SP_GetMerchant], with param: "+
				StaticVariable.map2String(inParamMap));
		
		//https://docs.spring.io/spring/docs/3.0.0.M4/reference/html/ch12s05.html
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate);
		Map<String, Object> map = call.withoutProcedureColumnMetaDataAccess()
				.withProcedureName("SP_GetMerchant") //dbo.SP_GetListMerchant
				.declareParameters(new SqlParameter[] {
						new SqlParameter("whereq", Types.VARCHAR), 
						new SqlParameter("orderby", Types.VARCHAR),
						new SqlParameter("paging", Types.VARCHAR),
				 })
				.returningResultSet(StaticVariable.SP_DATA_RECORD,
//                      ParameterizedBeanPropertyRowMapperCustomized.newInstance(Merchant.class));
            			BeanPropertyRowMapperCustomized.newInstance(Merchant.class))
				.execute(inParamMap);

		return map;
	}
}
