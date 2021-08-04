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

import id.co.bca.magenta.api.merchantcare.entity.Complaint;
import id.co.bca.magenta.api.merchantcare.repository.ComplaintRepository;
import id.co.bca.magenta.api.merchantcare.util.BeanPropertyRowMapperCustomized;
import id.co.bca.magenta.api.merchantcare.util.Criteria;
import id.co.bca.magenta.api.merchantcare.util.PageSize;
import id.co.bca.magenta.api.merchantcare.util.QueryBuilder;
import id.co.bca.magenta.api.merchantcare.util.SpStatusMsg2;
import id.co.bca.magenta.api.merchantcare.util.StaticVariable;

@Repository
public class ComplaintRepositoryImpl extends RepositoryImpl implements ComplaintRepository {
	private static final Logger logger = LoggerFactory.getLogger(ComplaintRepositoryImpl.class);

	@Autowired
	@Qualifier("jdbcTemplateEmsmh")
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Complaint> findAll(long hashing, 
			int page, int size, String search, String orderby) {
		Map<String, Object> getDataByCallSP = getDataByCallSP(hashing, 
				page, size, search, orderby);
		List<Complaint> list = (List<Complaint>) getDataByCallSP.get(StaticVariable.SP_DATA_RECORD);

		return list;
	}

	@Override
	public Complaint findById(long hashing, String id) {
		Map<String, Object> getDataByCallSP = getDataByCallSP(hashing, 
				1, 1, "requestid;equals;" + id, "requestid");
		List<Complaint> list = (List<Complaint>) getDataByCallSP.get(StaticVariable.SP_DATA_RECORD);

		if (null != list && list.size() > 0) {
			return list.get(0);
		}

		return null;
	}

	@Override
	public Map<String, Object> save(long hashing, Map params, String caseCategoryId) {
		String queryGetCallID = "--GET CALLID" + Criteria.ENTER
				+ "DECLARE @tempvarCallIDT TABLE (ResultValue varchar(8))" + Criteria.ENTER
				+ "DECLARE @tempvarCallID varchar(8)" + Criteria.ENTER + "INSERT INTO @tempvarCallIDT(ResultValue)"
				+ Criteria.ENTER + "exec spGetComplaintCallID" + Criteria.ENTER
				+ "SET @tempvarCallID=(select * FROM @tempvarCallIDT)";
		String queryGetDueDate = "--GET DueDate " + Criteria.ENTER
				+ "DECLARE @tempvarDueDateT TABLE (ResultValue datetime)" + Criteria.ENTER
				+ "DECLARE @tempvarDueDate datetime" + Criteria.ENTER + "DECLARE @tempvarSLA int=0" + Criteria.ENTER
				+ "DECLARE @tempvarEntryDate datetime=(select replace(convert(varchar(10),getdate(),102),'.','-'))"
				+ Criteria.ENTER + "SET @tempvarSLA=(select SLA from ComplaintCaseCategory where id=" + caseCategoryId
				+ ")" + Criteria.ENTER + "INSERT INTO @tempvarDueDateT(ResultValue)" + Criteria.ENTER
				+ "exec SP_GetDueDate @tempvarEntryDate,@tempvarSLA" + Criteria.ENTER
				+ "SET @tempvarDueDate=(select ResultValue from @tempvarDueDateT)";

		String queryGetCallID_id = "--GET CALLID_id" + Criteria.ENTER + "DECLARE @tempvarCALLID_id int" + Criteria.ENTER
				+ "SET @tempvarCALLID_id =(select id from ComplaintCall where CALLID=@tempvarCallID)";

		String queryGetMainID = "--GET MAINID" + Criteria.ENTER
				+ "DECLARE @tempvarMainIDT TABLE (ResultValue varchar(8))" + Criteria.ENTER
				+ "DECLARE @tempvarMainID varchar(8)" + Criteria.ENTER + "INSERT INTO @tempvarMainIDT(ResultValue)"
				+ Criteria.ENTER + "exec spGetComplaintMainID" + Criteria.ENTER
				+ "SET @tempvarMainID=(select * FROM @tempvarMainIDT)";

		String queryGetMainID_id = "--GET MAINID_id" + Criteria.ENTER + "DECLARE @tempvarMAINID_id int" + Criteria.ENTER
				+ "SET @tempvarMAINID_id=(select id from ComplaintMAIN where REQUESTID=@tempvarMAINID)";

		String query = "";
		String createddate = "createdate;=;getdate();;updatedate;=;getdate();;";

		// Complaint Call
		query = query + queryGetCallID + Criteria.ENTER;
		query = query + Criteria.ENTER
				+ QueryBuilder.insertBuilder(StaticVariable.COMPLAINT_CALL,
						params.get(StaticVariable.COMPLAINT_CALL) + createddate)
				+ Criteria.SEMICOLON + Criteria.DOUBLEENTER;

		// Complaint Main
		query = query + queryGetCallID_id + Criteria.ENTER + queryGetMainID + Criteria.ENTER + queryGetDueDate
				+ Criteria.ENTER;
		query = query + Criteria.ENTER
				+ QueryBuilder.insertBuilder(StaticVariable.COMPLAINT_MAIN,
						params.get(StaticVariable.COMPLAINT_MAIN) + createddate)
				+ Criteria.SEMICOLON + Criteria.DOUBLEENTER;
		query = query.replace("requestid_", "'+@tempvarMainID+'_") + queryGetMainID_id + Criteria.ENTER;
		
		if (params.get("isComplaint").equals("true")) {
			// Complaint EDC
			query = query + Criteria.ENTER
					+ QueryBuilder.insertBuilder(StaticVariable.COMPLAINT_EDC,
							params.get(StaticVariable.COMPLAINT_EDC) + createddate)
					+ Criteria.SEMICOLON + Criteria.DOUBLEENTER;			
		}


		logger.info("("+hashing+") "+"query: "+query);
		return insertDataByCallSP(hashing, query);
	}

	@Override
	public boolean isExist(long hashing, String id) {
		return (null != findById(hashing, id));
	}

	private Map<String, Object> getDataByCallSP(long hashing, 
			int page, int size, String search, String orderby) {
		search = reformatSearchValue(Complaint.class, search);

		// *****DEFINE WHERE*****
		String where = QueryBuilder.whereBuilder(search, "").replace("user_", "u.");

		orderby = reformatOrderValue(Complaint.class, orderby);

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

		logger.info("("+hashing+") "+"Call: [SP_GetComplaint], with param: "+
				StaticVariable.map2String(inParamMap));

		// https://docs.spring.io/spring/docs/3.0.0.M4/reference/html/ch12s05.html
		jdbcTemplate.setResultsMapCaseInsensitive(true);

		// TODO Auto-generated method stub
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate);
		Map<String, Object> map = call.withoutProcedureColumnMetaDataAccess()
				.withProcedureName("SP_GetComplaint") // dbo.SP_GetComplaint
				.declareParameters(new SqlParameter[] { new SqlParameter("whereq", Types.VARCHAR),
						new SqlParameter("orderby", Types.VARCHAR), new SqlParameter("paging", Types.VARCHAR), })
				.returningResultSet(StaticVariable.SP_DATA_RECORD,
						// ParameterizedBeanPropertyRowMapper.newInstance(Complaint.class));
						BeanPropertyRowMapperCustomized.newInstance(Complaint.class))
				.execute(inParamMap);

		return map;
	}

	private Map<String, Object> insertDataByCallSP(long hashing, String query) {
		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("query", query);

		logger.info("("+hashing+") "+"Call: [SP_BeginTry], with param: "+
				StaticVariable.map2String(inParamMap));

		// https://docs.spring.io/spring/docs/3.0.0.M4/reference/html/ch12s05.html
		jdbcTemplate.setResultsMapCaseInsensitive(true);

		// TODO Auto-generated method stub
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate);
		Map<String, Object> map = call.withoutProcedureColumnMetaDataAccess().withProcedureName("SP_BeginTry")
				.declareParameters(new SqlParameter[] { new SqlParameter("query", Types.VARCHAR) })
				.returningResultSet(StaticVariable.SP_STATUS_MSG, 
						BeanPropertyRowMapperCustomized.newInstance(SpStatusMsg2.class))
				.execute(inParamMap);

		return map;
	}
}
