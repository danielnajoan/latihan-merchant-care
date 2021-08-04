package id.co.bca.magenta.api.merchantcare.util;

public class SpStatusMsg2 {
	private int isSuccess;
	private String errorMessage;
	private int rowAffected;
	private String email;
	private String firstname;
	public int getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getRowAffected() {
		return rowAffected;
	}
	public void setRowAffected(int rowAffected) {
		this.rowAffected = rowAffected;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SpStatusMsg2 [isSuccess=");
		builder.append(isSuccess);
		builder.append(", errorMessage=");
		builder.append(errorMessage);
		builder.append(", rowAffected=");
		builder.append(rowAffected);
		builder.append(", email=");
		builder.append(email);
		builder.append(", firstname=");
		builder.append(firstname);
		builder.append("]");
		return builder.toString();
	}
}
