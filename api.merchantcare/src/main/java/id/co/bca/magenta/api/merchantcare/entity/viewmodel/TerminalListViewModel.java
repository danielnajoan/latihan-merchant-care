package id.co.bca.magenta.api.merchantcare.entity.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class TerminalListViewModel extends ListViewModel implements IListViewModel{
	private List<TerminalViewModel> listViewModel;

	public TerminalListViewModel(List<TerminalViewModel> listViewModel) {
		super();
		this.listViewModel = listViewModel;
	}

	public TerminalListViewModel(TerminalViewModel viewModel) {
		List<TerminalViewModel> listViewModel = new ArrayList<TerminalViewModel>();
		listViewModel.add(viewModel);
		this.listViewModel = listViewModel;
	}

	public TerminalListViewModel() {
		List<TerminalViewModel> listViewModel = new ArrayList<TerminalViewModel>();
		this.listViewModel = listViewModel;
	}

	@Override
	public Object getContent() {
		// TODO Auto-generated method stub
		return listViewModel;
	}
}
