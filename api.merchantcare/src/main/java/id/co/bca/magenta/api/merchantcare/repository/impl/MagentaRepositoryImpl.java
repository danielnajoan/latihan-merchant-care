package id.co.bca.magenta.api.merchantcare.repository.impl;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import id.co.bca.magenta.api.merchantcare.entity.Outlet;
import id.co.bca.magenta.api.merchantcare.entity.OutletDetail;
import id.co.bca.magenta.api.merchantcare.entity.OutletDevice;
import id.co.bca.magenta.api.merchantcare.entity.Pemilik;
import id.co.bca.magenta.api.merchantcare.entity._Merchant;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.MidRequestDto;
import id.co.bca.magenta.api.merchantcare.repository.MagentaRepository;
import id.co.bca.magenta.api.merchantcare.util.BeanPropertyRowMapperCustomized;
import id.co.bca.magenta.api.merchantcare.util.StaticVariable;
import oracle.jdbc.OracleTypes;

@Repository
public class MagentaRepositoryImpl extends RepositoryImpl implements MagentaRepository {
	private static final Logger logger = LoggerFactory.getLogger(MagentaRepositoryImpl.class);

	@Autowired
	@Qualifier("jdbcTemplateMagenmc")
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean isExistMID(long hashing, String mid) {
		String sql = "SELECT COUNT (1) FROM OUTLET WHERE MID = ?";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class, mid);
		return count != null && count > 0;
	}

	@Override
	public List<String> getTerminalInitByMID(long hashing, String mid) {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT OD.TERMINAL_INIT FROM OUTLET O ");
		builder.append("INNER JOIN OUTLET_DEVICE OD ON OD.OUTLET_ID=O.ID ");
		builder.append("WHERE O.MID = ? ");
		
		String query = builder.toString();
		
		List<String> listTerminalinit = this.jdbcTemplate.queryForList(query, String.class, mid);
		
		return listTerminalinit;
	}

	@Override
	public List<OutletDetail> getOutletDetailByListMID(long hashing, MidRequestDto mids) {
		StringBuilder result = new StringBuilder();
		for(int index = 0; index < mids.getMid().length; index++){
			if(index == mids.getMid().length-1){
				result.append("'").append(mids.getMid()[index]).append("'");
			}else {
				result.append("'").append(mids.getMid()[index]).append("'").append(",");
			}
		}
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ");
		sqlBuilder
			.append("O.MID")
			.append(",O.NAME")
			.append(",M.CODE MERCHANT_CODE")
			.append(",M.NAME MERCHANT_NAME")
			.append(",O.ADDRESS1")
			.append(",O.ADDRESS2")
			.append(",O.VILLAGE_NAME VILLAGE")
			.append(",O.POSTAL_CODE")
			.append(",O.SUBDISTRICT_NAME SUBDISTRICT")
			.append(",O.REGENCY_NAME")
			.append(",O.TYPE_REGENCY KOTA")
			.append(",O.GEOLOCATION")
			.append(",O.PHONE")
			.append(",O.MOBILEPHONE MOBILE_PHONE")
			.append(",O.STATUS")
			.append(",O.PROVINCE_NAME PROVINCE");
		sqlBuilder.append(" FROM MERCHANT M ");
		sqlBuilder.append(" INNER JOIN OUTLET O ON O.MERCHANT_ID=M.ID ");
		sqlBuilder.append(" WHERE O.MID IN  (").append(result.toString()).append(")");
		String query = sqlBuilder.toString();
		List<OutletDetail> listTerminalinit = this.jdbcTemplate.query(
				query, new BeanPropertyRowMapperCustomized<>(OutletDetail.class));

		return listTerminalinit;
	}

	@Override
	public Map<String, Object> callSPGetDataByTerminalInit(long hashing, String terminalInit) {
		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("I_TERMINALINIT", terminalInit);

		logger.info("("+hashing+") "+"Call: [SP_EMSMH_GET_TERMINALINIT], with param: "+
				StaticVariable.map2String(inParamMap));

		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate);
		Map<String, Object> map = call.withoutProcedureColumnMetaDataAccess()
				.withProcedureName("SP_EMSMH_GET_TERMINALINIT")
				// .withCatalogName("MY_PACKAGE") // Package Name, if exist
				.declareParameters(new SqlParameter[] {
						new SqlParameter("I_TERMINALINIT", Types.VARCHAR),
						new SqlOutParameter("O_STATUS_MSG", Types.VARCHAR),
						new SqlOutParameter("O_PEMILIK_REC",
								OracleTypes.CURSOR, BeanPropertyRowMapperCustomized.newInstance(Pemilik.class)),
						new SqlOutParameter("O_MERCHANT_REC",
								OracleTypes.CURSOR, BeanPropertyRowMapperCustomized.newInstance(_Merchant.class)),
						new SqlOutParameter("O_OUTLET_REC",
								OracleTypes.CURSOR, BeanPropertyRowMapperCustomized.newInstance(Outlet.class)),
						new SqlOutParameter("O_OUTLET_DEVICE_REC",
								OracleTypes.CURSOR, BeanPropertyRowMapperCustomized.newInstance(OutletDevice.class)) })
				.execute(inParamMap);

		return map;
	}
}
