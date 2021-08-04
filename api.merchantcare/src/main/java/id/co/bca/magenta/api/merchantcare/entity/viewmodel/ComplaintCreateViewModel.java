package id.co.bca.magenta.api.merchantcare.entity.viewmodel;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Complaint Create View Model")
public class ComplaintCreateViewModel {
	
	private String productid;
	private String merchantpic;
	private String notes;
	private String contactno;
	private String createdby;
	private String createdterminal;
	private String casecategory_id;
	private String summary;
	private String jumlahItem;
	private String satuan;
	private String alamatSaatIni;
	private String kodePosSaatIni;
	private String namaMerchant;
	private String email;
	private String alamatUsaha1;
	private String alamatUsaha2;
	private String nasabah;
	private String rekeningNasabah;
	private String kodePos;
	private String kotaKabupaten;
	private String kecamatan;
	private String kelurahan;
	private String kcuLokasiUsaha;
	private String kanwilLokasiUsaha;
	private String namaPemilik;
	private String telpPemilik;
	private String pejabatBerwenang1;
	private String pejabatBerwenang2;
	private String contactMethod;
	private String konversiNilai;
	private String jumlahItemKonversi;
	private String complaintcall_id;
	private String complaintmain_id;
	private String image_path;
	private String agentBankSaatIni;
	
//	private String invoicerequestcount;
	
//	public String getInvoicerequestcount() {
//	return invoicerequestcount;
//  }
//  public void setInvoicerequestcount(String invoicerequestcount) {
//	this.invoicerequestcount = invoicerequestcount;
//  }
	
	public ComplaintCreateViewModel() {
		
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getMerchantpic() {
		return merchantpic;
	}

	public void setMerchantpic(String merchantpic) {
		this.merchantpic = merchantpic;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getCreatedterminal() {
		return createdterminal;
	}

	public void setCreatedterminal(String createdterminal) {
		this.createdterminal = createdterminal;
	}

	public String getCasecategory_id() {
		return casecategory_id;
	}

	public void setCasecategory_id(String casecategory_id) {
		this.casecategory_id = casecategory_id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

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

	public String getAlamatSaatIni() {
		return alamatSaatIni;
	}

	public void setAlamatSaatIni(String alamatSaatIni) {
		this.alamatSaatIni = alamatSaatIni;
	}

	public String getKodePosSaatIni() {
		return kodePosSaatIni;
	}

	public void setKodePosSaatIni(String kodePosSaatIni) {
		this.kodePosSaatIni = kodePosSaatIni;
	}

	public String getNamaMerchant() {
		return namaMerchant;
	}

	public void setNamaMerchant(String namaMerchant) {
		this.namaMerchant = namaMerchant;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlamatUsaha1() {
		return alamatUsaha1;
	}

	public void setAlamatUsaha1(String alamatUsaha1) {
		this.alamatUsaha1 = alamatUsaha1;
	}

	public String getAlamatUsaha2() {
		return alamatUsaha2;
	}

	public void setAlamatUsaha2(String alamatUsaha2) {
		this.alamatUsaha2 = alamatUsaha2;
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

	public String getKodePos() {
		return kodePos;
	}

	public void setKodePos(String kodePos) {
		this.kodePos = kodePos;
	}

	public String getKotaKabupaten() {
		return kotaKabupaten;
	}

	public void setKotaKabupaten(String kotaKabupaten) {
		this.kotaKabupaten = kotaKabupaten;
	}

	public String getKecamatan() {
		return kecamatan;
	}

	public void setKecamatan(String kecamatan) {
		this.kecamatan = kecamatan;
	}

	public String getKelurahan() {
		return kelurahan;
	}

	public void setKelurahan(String kelurahan) {
		this.kelurahan = kelurahan;
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

	public String getNamaPemilik() {
		return namaPemilik;
	}

	public void setNamaPemilik(String namaPemilik) {
		this.namaPemilik = namaPemilik;
	}

	public String getTelpPemilik() {
		return telpPemilik;
	}

	public void setTelpPemilik(String telpPemilik) {
		this.telpPemilik = telpPemilik;
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

	public String getContactMethod() {
		return contactMethod;
	}

	public void setContactMethod(String contactMethod) {
		this.contactMethod = contactMethod;
	}

	public String getComplaintcall_id() {
		return complaintcall_id;
	}

	public void setComplaintcall_id(String complaintcall_id) {
		this.complaintcall_id = complaintcall_id;
	}

	public String getComplaintmain_id() {
		return complaintmain_id;
	}

	public void setComplaintmain_id(String complaintmain_id) {
		this.complaintmain_id = complaintmain_id;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public String getAgentBankSaatIni() {
		return agentBankSaatIni;
	}

	public void setAgentBankSaatIni(String agentBankSaatIni) {
		this.agentBankSaatIni = agentBankSaatIni;
	}

	public String getKonversiNilai() {
		return konversiNilai;
	}

	public void setKonversiNilai(String konversiNilai) {
		this.konversiNilai = konversiNilai;
	}

	public String getJumlahItemKonversi() {
		return jumlahItemKonversi;
	}

	public void setJumlahItemKonversi(String jumlahItemKonversi) {
		this.jumlahItemKonversi = jumlahItemKonversi;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ComplaintCreateViewModel [productid=");
		builder.append(productid);
		builder.append(", merchantpic=");
		builder.append(merchantpic);
		builder.append(", notes=");
		builder.append(notes);
		builder.append(", contactno=");
		builder.append(contactno);
		builder.append(", createdby=");
		builder.append(createdby);
		builder.append(", createdterminal=");
		builder.append(createdterminal);
		builder.append(", casecategory_id=");
		builder.append(casecategory_id);
		builder.append(", summary=");
		builder.append(summary);
		builder.append(", jumlahItem=");
		builder.append(jumlahItem);
		builder.append(", satuan=");
		builder.append(satuan);
		builder.append(", alamatSaatIni=");
		builder.append(alamatSaatIni);
		builder.append(", kodePosSaatIni=");
		builder.append(kodePosSaatIni);
		builder.append(", namaMerchant=");
		builder.append(namaMerchant);
		builder.append(", email=");
		builder.append(email);
		builder.append(", alamatUsaha1=");
		builder.append(alamatUsaha1);
		builder.append(", alamatUsaha2=");
		builder.append(alamatUsaha2);
		builder.append(", nasabah=");
		builder.append(nasabah);
		builder.append(", rekeningNasabah=");
		builder.append(rekeningNasabah);
		builder.append(", kodePos=");
		builder.append(kodePos);
		builder.append(", kotaKabupaten=");
		builder.append(kotaKabupaten);
		builder.append(", kecamatan=");
		builder.append(kecamatan);
		builder.append(", kelurahan=");
		builder.append(kelurahan);
		builder.append(", kcuLokasiUsaha=");
		builder.append(kcuLokasiUsaha);
		builder.append(", kanwilLokasiUsaha=");
		builder.append(kanwilLokasiUsaha);
		builder.append(", namaPemilik=");
		builder.append(namaPemilik);
		builder.append(", telpPemilik=");
		builder.append(telpPemilik);
		builder.append(", pejabatBerwenang1=");
		builder.append(pejabatBerwenang1);
		builder.append(", pejabatBerwenang2=");
		builder.append(pejabatBerwenang2);
		builder.append(", contactMethod=");
		builder.append(contactMethod);
		builder.append(", konversiNilai=");
		builder.append(konversiNilai);
		builder.append(", jumlahItemKonversi=");
		builder.append(jumlahItemKonversi);
		builder.append(", complaintcall_id=");
		builder.append(complaintcall_id);
		builder.append(", complaintmain_id=");
		builder.append(complaintmain_id);
		builder.append(", image_path=");
		builder.append(image_path);
		builder.append(", agentBankSaatIni=");
		builder.append(agentBankSaatIni);
		builder.append("]");
		return builder.toString();
	}
}
