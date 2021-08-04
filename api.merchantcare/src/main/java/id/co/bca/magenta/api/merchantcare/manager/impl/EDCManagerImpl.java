package id.co.bca.magenta.api.merchantcare.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.bca.magenta.api.merchantcare.entity.EDC;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.EDCViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.ManagerViewModel;
import id.co.bca.magenta.api.merchantcare.manager.EDCManager;
import id.co.bca.magenta.api.merchantcare.repository.EDCRepository;
import id.co.bca.magenta.api.merchantcare.util.StaticVariable;

@Service
public class EDCManagerImpl extends ManagerImpl implements EDCManager {
	private static final Logger logger = LoggerFactory.getLogger(EDCManagerImpl.class);
	
	@Autowired
	private EDCRepository edcRepository;
	
	@Override
	public ManagerViewModel<List<EDCViewModel>> findAll(long hashing, 
			int page, int size, String search, String orderby) {			
		ManagerViewModel<List<EDCViewModel>> mvm = new ManagerViewModel<>();

		try {
			List<EDC> listData = edcRepository
					.findAll(hashing, page, size, search, orderby);

			if (null != listData && listData.size() > 0) {
				List<EDCViewModel> listDataVm = new ArrayList<EDCViewModel>();
				for (EDC item : listData) {
					EDCViewModel vm = new EDCViewModel();
					BeanUtils.copyProperties(item, vm);
					listDataVm.add(vm);
				}
				
				mvm.setContent(listDataVm);
				mvm.setTotalrows(listData.get(0).getTotalCount());
				mvm.setInfo(getInfoOk("Success"));
			} else {
				mvm.setTotalrows(0);
				mvm.setInfo(getInfoNoContent());
			}
		} catch (Exception e) {
			String errMsg = StaticVariable.starckTraceToString(e);
			logger.error("("+hashing+") "+"errMsg: "+errMsg);
			
			mvm.setTotalrows(0);
			mvm.setInfo(getInfoConflict(errMsg));
		}

		return mvm;
	}

	@Override
	public ManagerViewModel<EDCViewModel> findById(long hashing, String id) {
		ManagerViewModel<EDCViewModel> mvm = new ManagerViewModel<>();

		try {
			mvm.setTotalrows(0);
			mvm.setInfo(getInfoNoContent());
			
//			if (isExist(id)) {
				EDC e = edcRepository.findById(hashing, id);
	
				if (null != e && StaticVariable.compareString(e.getProductid(), id)) {
					EDCViewModel vm = new EDCViewModel();
					BeanUtils.copyProperties(e, vm);
					
					mvm.setContent(vm);
					mvm.setTotalrows(1);
					mvm.setInfo(getInfoOk("Success"));
				}
//			}
		} catch (Exception e) {
			String errMsg = StaticVariable.starckTraceToString(e);
			logger.error("("+hashing+") "+"errMsg: "+errMsg);
			
			mvm.setTotalrows(0);
			mvm.setInfo(getInfoConflict(errMsg));
		}

		return mvm;
	}

	@Override
	public boolean isExist(long hashing, String id) {
		return edcRepository.isExist(hashing, id);
	}
}
