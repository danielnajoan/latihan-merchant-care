package id.co.bca.magenta.api.merchantcare.entity.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class EDCListViewModel extends ListViewModel implements IListViewModel {
	private final List<EDCViewModel> listViewModel;

	public EDCListViewModel(List<EDCViewModel> listViewModel) {
		super();
		this.listViewModel = listViewModel;
	}

	public EDCListViewModel(EDCViewModel viewModel) {
		List<EDCViewModel> listViewModel = new ArrayList<EDCViewModel>();
		listViewModel.add(viewModel);
		this.listViewModel = listViewModel;
	}

	public EDCListViewModel() {
		List<EDCViewModel> listViewModel = new ArrayList<EDCViewModel>();
		this.listViewModel = listViewModel;
	}

	public Object getContent() {
		return listViewModel;
	}
}
