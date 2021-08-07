package id.co.bca.magenta.api.merchantcare.entity.viewmodel;

public class DetailMessageViewModel {
	private String callId;
	private String requestId;
	private String dueDate;
	private int caseCategoryId;
	private String caseCategoryName;
	private String productId;
	
	public String getCallId() {
		return callId;
	}
	public void setCallId(String callId) {
		this.callId = callId;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public int getCaseCategoryId() {
		return caseCategoryId;
	}
	public void setCaseCategoryId(int caseCategoryId) {
		this.caseCategoryId = caseCategoryId;
	}
	public String getCaseCategoryName() {
		return caseCategoryName;
	}
	public void setCaseCategoryName(String caseCategoryName) {
		this.caseCategoryName = caseCategoryName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DetailMessageViewModel [callId=");
		builder.append(callId);
		builder.append(", requestId=");
		builder.append(requestId);
		builder.append(", dueDate=");
		builder.append(dueDate);
		builder.append(", caseCategoryId=");
		builder.append(caseCategoryId);
		builder.append(", caseCategory=");
		builder.append(caseCategoryName);
		builder.append(", productId=");
		builder.append(productId);
		builder.append("]");
		return builder.toString();
	}
}
