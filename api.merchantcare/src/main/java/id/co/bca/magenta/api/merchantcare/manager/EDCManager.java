package id.co.bca.magenta.api.merchantcare.manager;

import java.util.List;

import id.co.bca.magenta.api.merchantcare.entity.viewmodel.EDCViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.ManagerViewModel;

public interface EDCManager extends ManagerBase {
	public ManagerViewModel<List<EDCViewModel>> findAll(long hashing, 
			int page, int size, String search, String orderby);
	public ManagerViewModel<EDCViewModel> findById(long hashing, String id);
	public boolean isExist(long hashing, String id);
}
