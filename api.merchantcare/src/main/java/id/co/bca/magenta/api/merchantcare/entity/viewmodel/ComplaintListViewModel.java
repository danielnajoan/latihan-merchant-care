package id.co.bca.magenta.api.merchantcare.entity.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class ComplaintListViewModel extends ListViewModel implements IListViewModel {
	private List<ComplaintViewModel> listViewModel;

	public ComplaintListViewModel(List<ComplaintViewModel> listViewModel) {
		super();
		this.listViewModel = listViewModel;
	}

	public ComplaintListViewModel(ComplaintViewModel viewModel) {
		List<ComplaintViewModel> listViewModel = new ArrayList<ComplaintViewModel>();
		listViewModel.add(viewModel);
		this.listViewModel = listViewModel;
	}

	public ComplaintListViewModel() {
		List<ComplaintViewModel> listViewModel = new ArrayList<ComplaintViewModel>();
		this.listViewModel = listViewModel;
	}

	public Object getContent() {
		return listViewModel;
	}
}
