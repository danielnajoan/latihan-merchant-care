package id.co.bca.magenta.api.merchantcare.util;

public class PageSize {
	int offset;
	int fetch;

	public PageSize(int page, int size) {
		int _offset = 0;
		int _fetch = size;
		if (page <= 1) {
			page = 1;
		}

		if (page <= 1) {
			_offset = 0;
		} else {
			_offset = (page - 1) * size;
		}

		this.setFetch(_fetch);
		this.setOffset(_offset);
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getFetch() {
		return fetch;
	}

	public void setFetch(int fetch) {
		this.fetch = fetch;
	}
	
	public String getPaging() {
		if (getFetch() > 0) {
			return " OFFSET " + getOffset() + " ROWS FETCH NEXT " + getFetch() + " ROWS ONLY ";
		} else {
			return " ";
		}
	}

}
