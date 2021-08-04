package id.co.bca.magenta.api.merchantcare.repository;

import java.util.List;
import java.util.Map;

import id.co.bca.magenta.api.merchantcare.entity.OutletDetail;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.MidRequestDto;

public interface MagentaRepository extends RepositoryBase {
	public boolean isExistMID (long hashing, String mid);
	public List<String> getTerminalInitByMID(long hashing, String mid);
	public List<OutletDetail> getOutletDetailByListMID(long hashing, MidRequestDto mid);
	public Map<String, Object> callSPGetDataByTerminalInit(long hashing, String terminalInit);
}
