package id.co.bca.magenta.api.merchantcare.entity.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class MerchantListViewModel extends ListViewModel implements IListViewModel {
	private List<MerchantViewModel> listViewModel;

	public MerchantListViewModel(List<MerchantViewModel> listViewModel) {
		super();
		this.listViewModel = listViewModel;
	}

	public MerchantListViewModel(MerchantViewModel viewModel) {
		List<MerchantViewModel> listViewModel = new ArrayList<MerchantViewModel>();
		listViewModel.add(viewModel);
		this.listViewModel = listViewModel;
	}

	public MerchantListViewModel() {
		List<MerchantViewModel> listViewModel = new ArrayList<MerchantViewModel>();
		this.listViewModel = listViewModel;
	}

	public Object getContent() {
		return listViewModel;
	}
}
