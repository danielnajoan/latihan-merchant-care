package id.co.bca.magenta.api.merchantcare.entity.viewmodel;

public class MasterViewModel<T> {
	public T content;

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
}
