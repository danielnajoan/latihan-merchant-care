package id.co.bca.magenta.api.merchantcare.entity;

import java.lang.reflect.Field;

import org.apache.commons.lang3.ArrayUtils;

import id.co.bca.magenta.api.merchantcare.util.Criteria;

public class ComplaintEDC {
	private String id;
	private String edcID;
	private String productID;
	private String serialID;
	private String modelID;
	private String modelName;
	private String brandID;
	private String brandName;
	private String merchantID;
	private String mID;
	private String notes;
	private String closeBy;
	private String Status;
	private String closeDate;
	private String createDate;
	private String createBy;
	private String createTerminal;
	private String updateDate;
	private String updateBy;
	private String updateTerminal;
	private String vendorMaintenance_id;
	private String complaintMain_Id;
	public String getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getUpdateTerminal() {
		return updateTerminal;
	}
	public void setUpdateTerminal(String updateTerminal) {
		this.updateTerminal = updateTerminal;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEdcID() {
		return edcID;
	}
	public void setEdcID(String edcID) {
		this.edcID = edcID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getSerialID() {
		return serialID;
	}
	public void setSerialID(String serialID) {
		this.serialID = serialID;
	}
	public String getModelID() {
		return modelID;
	}
	public void setModelID(String modelID) {
		this.modelID = modelID;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getBrandID() {
		return brandID;
	}
	public void setBrandID(String brandID) {
		this.brandID = brandID;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getMerchantID() {
		return merchantID;
	}
	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}
	public String getmID() {
		return mID;
	}
	public void setmID(String mID) {
		this.mID = mID;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getCloseBy() {
		return closeBy;
	}
	public void setCloseBy(String closeBy) {
		this.closeBy = closeBy;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateTerminal() {
		return createTerminal;
	}
	public void setCreateTerminal(String createTerminal) {
		this.createTerminal = createTerminal;
	}
	public String getVendorMaintenance_id() {
		return vendorMaintenance_id;
	}
	public void setVendorMaintenance_id(String vendorMaintenance_id) {
		this.vendorMaintenance_id = vendorMaintenance_id;
	}
	public String getComplaintMain_Id() {
		return complaintMain_Id;
	}
	public void setComplaintMain_Id(String complaintMain_Id) {
		this.complaintMain_Id = complaintMain_Id;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ComplaintEDC [id=");
		builder.append(id);
		builder.append(", edcID=");
		builder.append(edcID);
		builder.append(", productID=");
		builder.append(productID);
		builder.append(", serialID=");
		builder.append(serialID);
		builder.append(", modelID=");
		builder.append(modelID);
		builder.append(", modelName=");
		builder.append(modelName);
		builder.append(", brandID=");
		builder.append(brandID);
		builder.append(", brandName=");
		builder.append(brandName);
		builder.append(", merchantID=");
		builder.append(merchantID);
		builder.append(", mID=");
		builder.append(mID);
		builder.append(", notes=");
		builder.append(notes);
		builder.append(", closeBy=");
		builder.append(closeBy);
		builder.append(", Status=");
		builder.append(Status);
		builder.append(", closeDate=");
		builder.append(closeDate);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", createBy=");
		builder.append(createBy);
		builder.append(", createTerminal=");
		builder.append(createTerminal);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append(", updateBy=");
		builder.append(updateBy);
		builder.append(", updateTerminal=");
		builder.append(updateTerminal);
		builder.append(", vendorMaintenance_id=");
		builder.append(vendorMaintenance_id);
		builder.append(", complaintMain_Id=");
		builder.append(complaintMain_Id);
		builder.append("]");
		return builder.toString();
	}
	public String getQuery() {
		StringBuilder result = new StringBuilder();
		for (Field f : ArrayUtils.addAll(getClass().getDeclaredFields(), getClass().getSuperclass().getDeclaredFields())) {
			try {
				// 2016.12.28-1-ambil yang bukan null
				if (f.get(this) != null) {
					// 2016.12.07-1-pengecekan jika bukan null dan string kosong
					// dijadikan MINUS
					if (f.get(this).equals("")) {
						result.append(f.getName()).append(";EQUALS;")
								.append((f.get(this).toString().equals(Criteria.EMPTY)) ? Criteria.MINUS : f.get(this)).append(";;");
					} else {
						result.append(f.getName()).append(";EQUALS;").append(f.get(this)).append(";;");
					}
				}
				// .append(System.getProperty("line.separator"));
			} catch (IllegalStateException ise) {
				result.append(f.getName()).append(" : ").append("[cannot retrieve value]")
						.append(System.getProperty("line.separator"));
			}
			// nope
			catch (IllegalAccessException iae) {
			}
		}
		return result.toString();
	}

}
