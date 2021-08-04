package id.co.bca.magenta.api.merchantcare.entity.viewmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import id.co.bca.magenta.api.merchantcare.util.ErrorDetail;

public class ManagerViewModel<T> {
    @JsonProperty("info")
	private ErrorDetail info;
    @JsonProperty("totalrows")
    private int totalrows;
    @JsonProperty("content")
	private T content;

    @JsonProperty("info")
	public ErrorDetail getInfo() {
		return info;
	}

    @JsonProperty("info")
	public void setInfo(ErrorDetail info) {
		this.info = info;
	}

    @JsonProperty("totalrows")
    public int getTotalrows() {
		return totalrows;
	}

    @JsonProperty("totalrows")
	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	@JsonProperty("content")
	public T getContent() {
		return content;
	}

    @JsonProperty("content")
	public void setContent(T content) {
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MasterViewModel [info=");
		builder.append(info);
		builder.append(", totalrows=");
		builder.append(totalrows);
		builder.append(", content=");
		builder.append(content);
		builder.append("]");
		return builder.toString();
	}
}
