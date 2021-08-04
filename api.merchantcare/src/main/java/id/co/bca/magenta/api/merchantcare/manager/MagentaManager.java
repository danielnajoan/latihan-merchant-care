package id.co.bca.magenta.api.merchantcare.manager;

import java.util.List;

import id.co.bca.magenta.api.merchantcare.entity.viewmodel.ManagerViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.MidRequestDto;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.OutletDetailViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.TerminalViewModel;

public interface MagentaManager extends ManagerBase {
	public ManagerViewModel<List<OutletDetailViewModel>> getOutletDetailByListMID(
			long hashing, MidRequestDto mid);
	public ManagerViewModel<TerminalViewModel> getTerminalInitByMID(long hashing, String mid);
}
