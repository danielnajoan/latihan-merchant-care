package id.co.bca.magenta.api.merchantcare.entity.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class OutletDetailListViewModel extends ListViewModel implements IListViewModel {
	private List<OutletDetailViewModel> listViewModel;

	public OutletDetailListViewModel(List<OutletDetailViewModel> listViewModel) {
		super();
		this.listViewModel = listViewModel;
	}

	public OutletDetailListViewModel(OutletDetailViewModel viewModel) {
		List<OutletDetailViewModel> listViewModel = new ArrayList<OutletDetailViewModel>();
		listViewModel.add(viewModel);
		this.listViewModel=listViewModel;
	}

	public OutletDetailListViewModel() {
		List<OutletDetailViewModel> listViewModel = new ArrayList<OutletDetailViewModel>();
		this.listViewModel=listViewModel;
	}

	@Override
	public Object getContent() {

		return listViewModel;
	}
}
