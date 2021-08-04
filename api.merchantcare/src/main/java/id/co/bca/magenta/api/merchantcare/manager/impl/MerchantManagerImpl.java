package id.co.bca.magenta.api.merchantcare.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.bca.magenta.api.merchantcare.entity.Merchant;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.ManagerViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.MerchantViewModel;
import id.co.bca.magenta.api.merchantcare.manager.MerchantManager;
import id.co.bca.magenta.api.merchantcare.repository.MerchantRepository;
import id.co.bca.magenta.api.merchantcare.util.StaticVariable;

@Service
public class MerchantManagerImpl extends ManagerImpl implements MerchantManager {
	private static final Logger logger = LoggerFactory.getLogger(MerchantManagerImpl.class);

	@Autowired
	private MerchantRepository merchantRepository;

	@Override
	public ManagerViewModel<List<MerchantViewModel>> findAll(long hashing, 
			int page, int size, String search, String orderby) {		
		ManagerViewModel<List<MerchantViewModel>> mvm = new ManagerViewModel<>();

		try {
			List<Merchant> listData = merchantRepository
					.findAll(hashing, page, size, search, orderby);

			if (null != listData && listData.size() > 0) {
				List<MerchantViewModel> listDataVm = new ArrayList<MerchantViewModel>();
				for (Merchant item : listData) {
					MerchantViewModel vm = new MerchantViewModel();
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
	public ManagerViewModel<MerchantViewModel> findById(long hashing, String id) {	
		ManagerViewModel<MerchantViewModel> mvm = new ManagerViewModel<>();

		try {
			mvm.setTotalrows(0);
			mvm.setInfo(getInfoNoContent());
			
//			if (isExist(id)) {
				Merchant e = merchantRepository.findById(hashing, id); 
	
				if (null != e && StaticVariable.compareString(e.getMID(), id)) {
					MerchantViewModel vm = new MerchantViewModel();
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
		return merchantRepository.isExist(hashing, id);
	}
}
