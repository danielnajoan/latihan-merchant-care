package id.co.bca.magenta.api.merchantcare.entity.viewmodel;

import id.co.bca.magenta.api.merchantcare.util.ErrorDetail;

public class ListViewModel {

	public int totalrows;
	public ErrorDetail info;

	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public ErrorDetail getInfo() {
		return info;
	}

	public void setInfo(ErrorDetail info) {
		this.info = info;
	}

}
