package id.co.bca.magenta.api.merchantcare.entity.viewmodel;

public class ComplaintViewModel {
	private String requestid;
	private String callid;
	private String productid;
	private String serialid;
	private String mid;
	private String merchantname;
	private String address1;
	private String address2;
	private String kodepos;
	private String status;
	private String idcasecategory;
	private String casecategory;
	private String permasalahan;
	private String teknisi;
	private String entrydate;
	private String entryby;
	private String entrybyname;
	private String duedate;
	private String closeddate;
	private String model;
	private String brand;
	private String fasilitas;
	private String notes;
	private String image_path;
	private String summary;
	private String merchantpic;
	private String invoicerequestcount;

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getRequestid() {
		return requestid;
	}

	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}

	public String getCallid() {
		return callid;
	}

	public void setCallid(String callid) {
		this.callid = callid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getSerialid() {
		return serialid;
	}

	public void setSerialid(String serialid) {
		this.serialid = serialid;
	}

	public String getMerchantname() {
		return merchantname;
	}

	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getKodepos() {
		return kodepos;
	}

	public void setKodepos(String kodepos) {
		this.kodepos = kodepos;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCasecategory() {
		return casecategory;
	}

	public void setCasecategory(String casecategory) {
		this.casecategory = casecategory;
	}

	public String getPermasalahan() {
		return permasalahan;
	}

	public void setPermasalahan(String permasalahan) {
		this.permasalahan = permasalahan;
	}

	public String getTeknisi() {
		return teknisi;
	}

	public void setTeknisi(String teknisi) {
		this.teknisi = teknisi;
	}

	public String getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getDuedate() {
		return duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getFasilitas() {
		return fasilitas;
	}

	public void setFasilitas(String fasilitas) {
		this.fasilitas = fasilitas;
	}

	public String getIdcasecategory() {
		return idcasecategory;
	}

	public void setIdcasecategory(String idcasecategory) {
		this.idcasecategory = idcasecategory;
	}

	public String getCloseddate() {
		return closeddate;
	}

	public void setCloseddate(String closeddate) {
		this.closeddate = closeddate;
	}

	public String getEntryby() {
		return entryby;
	}

	public void setEntryby(String entryby) {
		this.entryby = entryby;
	}

	public String getEntrybyname() {
		return entrybyname;
	}

	public void setEntrybyname(String entrybyname) {
		this.entrybyname = entrybyname;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getMerchantpic() {
		return merchantpic;
	}

	public void setMerchantpic(String merchantpic) {
		this.merchantpic = merchantpic;
	}

	public String getInvoicerequestcount() {
		return invoicerequestcount;
	}

	public void setInvoicerequestcount(String invoicerequestcount) {
		this.invoicerequestcount = invoicerequestcount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ComplaintViewModel [requestid=");
		builder.append(requestid);
		builder.append(", callid=");
		builder.append(callid);
		builder.append(", productid=");
		builder.append(productid);
		builder.append(", serialid=");
		builder.append(serialid);
		builder.append(", mid=");
		builder.append(mid);
		builder.append(", merchantname=");
		builder.append(merchantname);
		builder.append(", address1=");
		builder.append(address1);
		builder.append(", address2=");
		builder.append(address2);
		builder.append(", kodepos=");
		builder.append(kodepos);
		builder.append(", status=");
		builder.append(status);
		builder.append(", idcasecategory=");
		builder.append(idcasecategory);
		builder.append(", casecategory=");
		builder.append(casecategory);
		builder.append(", permasalahan=");
		builder.append(permasalahan);
		builder.append(", teknisi=");
		builder.append(teknisi);
		builder.append(", entrydate=");
		builder.append(entrydate);
		builder.append(", entryby=");
		builder.append(entryby);
		builder.append(", entrybyname=");
		builder.append(entrybyname);
		builder.append(", duedate=");
		builder.append(duedate);
		builder.append(", closeddate=");
		builder.append(closeddate);
		builder.append(", model=");
		builder.append(model);
		builder.append(", brand=");
		builder.append(brand);
		builder.append(", fasilitas=");
		builder.append(fasilitas);
		builder.append(", notes=");
		builder.append(notes);
		builder.append(", image_path=");
		builder.append(image_path);
		builder.append(", summary=");
		builder.append(summary);
		builder.append(", merchantpic=");
		builder.append(merchantpic);
		builder.append(", invoicerequestcount=");
		builder.append(invoicerequestcount);
		builder.append("]");
		return builder.toString();
	}
}
