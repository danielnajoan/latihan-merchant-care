package id.co.bca.magenta.api.merchantcare.entity;

import java.lang.reflect.Field;

import org.apache.commons.lang3.ArrayUtils;

import id.co.bca.magenta.api.merchantcare.util.Criteria;

public class ComplaintMain {
	private String id;// --auto
	private String requestID;// --exec spGetComplaintMainID
	private String nasabah;
	private String rekeningNasabah;
	private String noKartu;
	private String tglTransaksi;
	private String nominal;
	private String termID;
	private String batchNo;
	private String solusi;
	private String deskripsi;
	private String summary;
	private String alasan;
	private String complaintDate;
	private String status;
	private String type;
	private String priority;
	private String dueDate;
	private String followUp;
	private String productID;
	private String notes;
	private String closeBy;
	private String closeDate;
	private String reOpenDate;
	private String owner;
	private String createDate;
	private String createBy;
	private String createTerminal;
	private String updateDate;
	private String updateBy;
	private String updateTerminal;
	private String complaintCall_id;
	private String complaintParent_id;
	private String levelParent;
	private String caseCategory_id;
	private String Image_Path;
//	private String invoicerequestcount;
	private String jumlahItem;
	private String satuan;
	private String kcuLokasiUsaha;
	private String kanwilLokasiUsaha;
	private String pejabatBerwenang1;
	private String pejabatBerwenang2;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRequestID() {
		return requestID;
	}
	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}
	public String getNasabah() {
		return nasabah;
	}
	public void setNasabah(String nasabah) {
		this.nasabah = nasabah;
	}
	public String getRekeningNasabah() {
		return rekeningNasabah;
	}
	public void setRekeningNasabah(String rekeningNasabah) {
		this.rekeningNasabah = rekeningNasabah;
	}
	public String getNoKartu() {
		return noKartu;
	}
	public void setNoKartu(String noKartu) {
		this.noKartu = noKartu;
	}
	public String getTglTransaksi() {
		return tglTransaksi;
	}
	public void setTglTransaksi(String tglTransaksi) {
		this.tglTransaksi = tglTransaksi;
	}
	public String getNominal() {
		return nominal;
	}
	public void setNominal(String nominal) {
		this.nominal = nominal;
	}
	public String getTermID() {
		return termID;
	}
	public void setTermID(String termID) {
		this.termID = termID;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getSolusi() {
		return solusi;
	}
	public void setSolusi(String solusi) {
		this.solusi = solusi;
	}
	public String getDeskripsi() {
		return deskripsi;
	}
	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAlasan() {
		return alasan;
	}
	public void setAlasan(String alasan) {
		this.alasan = alasan;
	}
	public String getComplaintDate() {
		return complaintDate;
	}
	public void setComplaintDate(String complaintDate) {
		this.complaintDate = complaintDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getFollowUp() {
		return followUp;
	}
	public void setFollowUp(String followUp) {
		this.followUp = followUp;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
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
	public String getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}
	public String getReOpenDate() {
		return reOpenDate;
	}
	public void setReOpenDate(String reOpenDate) {
		this.reOpenDate = reOpenDate;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
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
	public String getComplaintCall_id() {
		return complaintCall_id;
	}
	public void setComplaintCall_id(String complaintCall_id) {
		this.complaintCall_id = complaintCall_id;
	}
	public String getComplaintParent_id() {
		return complaintParent_id;
	}
	public void setComplaintParent_id(String complaintParent_id) {
		this.complaintParent_id = complaintParent_id;
	}
	public String getLevelParent() {
		return levelParent;
	}
	public void setLevelParent(String levelParent) {
		this.levelParent = levelParent;
	}
	public String getCaseCategory_id() {
		return caseCategory_id;
	}
	public void setCaseCategory_id(String caseCategory_id) {
		this.caseCategory_id = caseCategory_id;
	}
	public String getImage_Path() {
		return Image_Path;
	}
	public void setImage_Path(String image_Path) {
		Image_Path = image_Path;
	}
//	public String getInvoicerequestcount() {
//		return invoicerequestcount;
//	}
//	public void setInvoicerequestcount(String invoicerequestcount) {
//		this.invoicerequestcount = invoicerequestcount;
//	}
	public String getJumlahItem() {
		return jumlahItem;
	}
	public void setJumlahItem(String jumlahItem) {
		this.jumlahItem = jumlahItem;
	}
	public String getSatuan() {
		return satuan;
	}
	public void setSatuan(String satuan) {
		this.satuan = satuan;
	}
	
	public String getKcuLokasiUsaha() {
		return kcuLokasiUsaha;
	}
	public void setKcuLokasiUsaha(String kcuLokasiUsaha) {
		this.kcuLokasiUsaha = kcuLokasiUsaha;
	}
	public String getKanwilLokasiUsaha() {
		return kanwilLokasiUsaha;
	}
	public void setKanwilLokasiUsaha(String kanwilLokasiUsaha) {
		this.kanwilLokasiUsaha = kanwilLokasiUsaha;
	}
	public String getPejabatBerwenang1() {
		return pejabatBerwenang1;
	}
	public void setPejabatBerwenang1(String pejabatBerwenang1) {
		this.pejabatBerwenang1 = pejabatBerwenang1;
	}
	public String getPejabatBerwenang2() {
		return pejabatBerwenang2;
	}
	public void setPejabatBerwenang2(String pejabatBerwenang2) {
		this.pejabatBerwenang2 = pejabatBerwenang2;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ComplaintMain [id=");
		builder.append(id);
		builder.append(", requestID=");
		builder.append(requestID);
		builder.append(", nasabah=");
		builder.append(nasabah);
		builder.append(", rekeningNasabah=");
		builder.append(rekeningNasabah);
		builder.append(", noKartu=");
		builder.append(noKartu);
		builder.append(", tglTransaksi=");
		builder.append(tglTransaksi);
		builder.append(", nominal=");
		builder.append(nominal);
		builder.append(", termID=");
		builder.append(termID);
		builder.append(", batchNo=");
		builder.append(batchNo);
		builder.append(", solusi=");
		builder.append(solusi);
		builder.append(", deskripsi=");
		builder.append(deskripsi);
		builder.append(", summary=");
		builder.append(summary);
		builder.append(", alasan=");
		builder.append(alasan);
		builder.append(", complaintDate=");
		builder.append(complaintDate);
		builder.append(", status=");
		builder.append(status);
		builder.append(", type=");
		builder.append(type);
		builder.append(", priority=");
		builder.append(priority);
		builder.append(", dueDate=");
		builder.append(dueDate);
		builder.append(", followUp=");
		builder.append(followUp);
		builder.append(", productID=");
		builder.append(productID);
		builder.append(", notes=");
		builder.append(notes);
		builder.append(", closeBy=");
		builder.append(closeBy);
		builder.append(", closeDate=");
		builder.append(closeDate);
		builder.append(", reOpenDate=");
		builder.append(reOpenDate);
		builder.append(", owner=");
		builder.append(owner);
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
		builder.append(", complaintCall_id=");
		builder.append(complaintCall_id);
		builder.append(", complaintParent_id=");
		builder.append(complaintParent_id);
		builder.append(", levelParent=");
		builder.append(levelParent);
		builder.append(", caseCategory_id=");
		builder.append(caseCategory_id);
		builder.append(", Image_Path=");
		builder.append(Image_Path);
//		builder.append(", invoicerequestcount=");
//		builder.append(invoicerequestcount);
		builder.append(", jumlahItem=");
		builder.append(jumlahItem);
		builder.append(", satuan=");
		builder.append(satuan);
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
