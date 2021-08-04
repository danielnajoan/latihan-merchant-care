package id.co.bca.magenta.api.merchantcare.manager;

import java.util.List;

import id.co.bca.magenta.api.merchantcare.entity.viewmodel.ManagerViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.MerchantViewModel;

public interface MerchantManager extends ManagerBase {
	public ManagerViewModel<List<MerchantViewModel>> findAll(long hashing, 
			int page, int size, String search, String orderby);
	public ManagerViewModel<MerchantViewModel> findById(long hashing, String id);
	public boolean isExist(long hashing, String id);
}
