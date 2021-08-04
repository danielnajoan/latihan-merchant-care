package id.co.bca.magenta.api.merchantcare.manager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.bca.magenta.api.merchantcare.entity.OutletDetail;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.ManagerViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.MidRequestDto;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.OutletDetailViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.TerminalViewModel;
import id.co.bca.magenta.api.merchantcare.manager.MagentaManager;
import id.co.bca.magenta.api.merchantcare.repository.MagentaRepository;
import id.co.bca.magenta.api.merchantcare.util.StaticVariable;

@Service
public class MagentaManagerImpl extends ManagerImpl implements MagentaManager {
	private static final Logger logger = LoggerFactory.getLogger(MagentaManagerImpl.class);

	@Autowired
	private MagentaRepository magentaRepository;

	@Override
	public ManagerViewModel<TerminalViewModel> getTerminalInitByMID(long hashing, String mid) {
		ManagerViewModel<TerminalViewModel> mvm = new ManagerViewModel<>();

		try {
			mvm.setTotalrows(0);
			mvm.setInfo(getInfoNoContent());
			
//			if (isExist(id)) {
				List<String> midList = magentaRepository.getTerminalInitByMID(hashing, mid);
				if (null != midList && midList.size() > 0) {
					TerminalViewModel vm = new TerminalViewModel(mid, midList);
						
					mvm.setContent(vm);
					mvm.setTotalrows(midList.size());
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
	public ManagerViewModel<List<OutletDetailViewModel>> getOutletDetailByListMID(long hashing, 
			MidRequestDto mid) {
		ManagerViewModel<List<OutletDetailViewModel>> mvm = new ManagerViewModel<>();

		try {
			List<OutletDetail> listData = magentaRepository
					.getOutletDetailByListMID(hashing, mid);

			if (null != listData && listData.size() > 0) {
				List<OutletDetailViewModel> listDataVm = new ArrayList<OutletDetailViewModel>();
				for (OutletDetail item : listData) {
					OutletDetailViewModel vm = new OutletDetailViewModel();
					BeanUtils.copyProperties(item, vm);
					listDataVm.add(vm);
				}
				
				mvm.setContent(listDataVm);
				mvm.setTotalrows(listData.size());
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
}
