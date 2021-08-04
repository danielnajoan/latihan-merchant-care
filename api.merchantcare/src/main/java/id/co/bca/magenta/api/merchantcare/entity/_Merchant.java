package id.co.bca.magenta.api.merchantcare.entity;

import java.util.Date;

public class _Merchant {
	private Integer id;
	private String code;
	private String name;
	private Integer groupId;
	private Integer merkId;
	private Integer villageId;
	private String villageName;
	private Integer postalId;
	private String postalCode;
	private Integer subdistrictId;
	private String subdistrictName;
	private Integer regencyId;
	private String regencyName;
	private Integer provinceId;
	private String provinceName;
	private Integer countryId;
	private String countryName;
	private String geolocation;
	private String email;
	private Boolean isCcBca;
	private String ccBcaAccountNo;
	private String ccBcaAccountName;
	private String ccBcaBranch;
	private Boolean isCcOtherBank;
	private String ccOtherBankAccNo;
	private String ccOtherBankAccName;
	private String ccOtherBankBranch;
	private Boolean isDebitBca;
	private String debitBcaAccNo;
	private String debitBcaAccName;
	private String debitBcaBranch;
	private String aktaPendirian;
	private String pengesahanHakim;
	private String aktaPergantianPeng;
	private String siup;
	private Date siupDate;
	private Date siupExpiredDate;
	private String notesDocument;
	private Integer pemilikId;
	private Integer statusDokumenId;
	private String pemilikName; // mapping to pemilik table
	private String segmenNasabah; // mapping to pemilik table
	private String phone;
	private String mobilePhone;
	private String status;
	private String keterangan;
	private Integer agentBankId;
	private String agentBankName;
	private Integer lamaProses;
	private Boolean isFranchise;
	private String address;
	private String agentBankCode;
	private Integer cabangBankId;
	private String cabangBankCode;
	private String cabangBankName;
	private String picPerekturanMerchName;
	private String persetujuanPermohonanName;
	private String persetujuanDokumenName;
	private String picPerekrutanMercJabatan;
	private String persetujuanPermohonanJabatan;
	private String persetujuanDokumenJabatan;
	private Date picPerekrutanMercDate;
	private Date persetujuanPermohonanDate;
	private Date persetujuanDokumenDate;
	private String groupName;
	private String merkName;
	private Boolean isSales;
	private String salesName;
	private Boolean isPengajuanCabang;
	private String salesCode;
	private Boolean rekomendasiCabang;
	private Integer merchantsettleId;
	private String merchantsettleCode;
	private String merchantsettleName;
	private String trackingId;
	private String laporanId;
	private String groupCode;
	private String source;
	private String notesPendingDocument;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public Integer getMerkId() {
		return merkId;
	}
	public void setMerkId(Integer merkId) {
		this.merkId = merkId;
	}
	public Integer getVillageId() {
		return villageId;
	}
	public void setVillageId(Integer villageId) {
		this.villageId = villageId;
	}
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	public Integer getPostalId() {
		return postalId;
	}
	public void setPostalId(Integer postalId) {
		this.postalId = postalId;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public Integer getSubdistrictId() {
		return subdistrictId;
	}
	public void setSubdistrictId(Integer subdistrictId) {
		this.subdistrictId = subdistrictId;
	}
	public String getSubdistrictName() {
		return subdistrictName;
	}
	public void setSubdistrictName(String subdistrictName) {
		this.subdistrictName = subdistrictName;
	}
	public Integer getRegencyId() {
		return regencyId;
	}
	public void setRegencyId(Integer regencyId) {
		this.regencyId = regencyId;
	}
	public String getRegencyName() {
		return regencyName;
	}
	public void setRegencyName(String regencyName) {
		this.regencyName = regencyName;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getGeolocation() {
		return geolocation;
	}
	public void setGeolocation(String geolocation) {
		this.geolocation = geolocation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getIsCcBca() {
		return isCcBca;
	}
	public void setIsCcBca(Boolean isCcBca) {
		this.isCcBca = isCcBca;
	}
	public String getCcBcaAccountNo() {
		return ccBcaAccountNo;
	}
	public void setCcBcaAccountNo(String ccBcaAccountNo) {
		this.ccBcaAccountNo = ccBcaAccountNo;
	}
	public String getCcBcaAccountName() {
		return ccBcaAccountName;
	}
	public void setCcBcaAccountName(String ccBcaAccountName) {
		this.ccBcaAccountName = ccBcaAccountName;
	}
	public String getCcBcaBranch() {
		return ccBcaBranch;
	}
	public void setCcBcaBranch(String ccBcaBranch) {
		this.ccBcaBranch = ccBcaBranch;
	}
	public Boolean getIsCcOtherBank() {
		return isCcOtherBank;
	}
	public void setIsCcOtherBank(Boolean isCcOtherBank) {
		this.isCcOtherBank = isCcOtherBank;
	}
	public String getCcOtherBankAccNo() {
		return ccOtherBankAccNo;
	}
	public void setCcOtherBankAccNo(String ccOtherBankAccNo) {
		this.ccOtherBankAccNo = ccOtherBankAccNo;
	}
	public String getCcOtherBankAccName() {
		return ccOtherBankAccName;
	}
	public void setCcOtherBankAccName(String ccOtherBankAccName) {
		this.ccOtherBankAccName = ccOtherBankAccName;
	}
	public String getCcOtherBankBranch() {
		return ccOtherBankBranch;
	}
	public void setCcOtherBankBranch(String ccOtherBankBranch) {
		this.ccOtherBankBranch = ccOtherBankBranch;
	}
	public Boolean getIsDebitBca() {
		return isDebitBca;
	}
	public void setIsDebitBca(Boolean isDebitBca) {
		this.isDebitBca = isDebitBca;
	}
	public String getDebitBcaAccNo() {
		return debitBcaAccNo;
	}
	public void setDebitBcaAccNo(String debitBcaAccNo) {
		this.debitBcaAccNo = debitBcaAccNo;
	}
	public String getDebitBcaAccName() {
		return debitBcaAccName;
	}
	public void setDebitBcaAccName(String debitBcaAccName) {
		this.debitBcaAccName = debitBcaAccName;
	}
	public String getDebitBcaBranch() {
		return debitBcaBranch;
	}
	public void setDebitBcaBranch(String debitBcaBranch) {
		this.debitBcaBranch = debitBcaBranch;
	}
	public String getAktaPendirian() {
		return aktaPendirian;
	}
	public void setAktaPendirian(String aktaPendirian) {
		this.aktaPendirian = aktaPendirian;
	}
	public String getPengesahanHakim() {
		return pengesahanHakim;
	}
	public void setPengesahanHakim(String pengesahanHakim) {
		this.pengesahanHakim = pengesahanHakim;
	}
	public String getAktaPergantianPeng() {
		return aktaPergantianPeng;
	}
	public void setAktaPergantianPeng(String aktaPergantianPeng) {
		this.aktaPergantianPeng = aktaPergantianPeng;
	}
	public String getSiup() {
		return siup;
	}
	public void setSiup(String siup) {
		this.siup = siup;
	}
	public Date getSiupDate() {
		return siupDate;
	}
	public void setSiupDate(Date siupDate) {
		this.siupDate = siupDate;
	}
	public Date getSiupExpiredDate() {
		return siupExpiredDate;
	}
	public void setSiupExpiredDate(Date siupExpiredDate) {
		this.siupExpiredDate = siupExpiredDate;
	}
	public String getNotesDocument() {
		return notesDocument;
	}
	public void setNotesDocument(String notesDocument) {
		this.notesDocument = notesDocument;
	}
	public Integer getPemilikId() {
		return pemilikId;
	}
	public void setPemilikId(Integer pemilikId) {
		this.pemilikId = pemilikId;
	}
	public Integer getStatusDokumenId() {
		return statusDokumenId;
	}
	public void setStatusDokumenId(Integer statusDokumenId) {
		this.statusDokumenId = statusDokumenId;
	}
	public String getPemilikName() {
		return pemilikName;
	}
	public void setPemilikName(String pemilikName) {
		this.pemilikName = pemilikName;
	}
	public String getSegmenNasabah() {
		return segmenNasabah;
	}
	public void setSegmenNasabah(String segmenNasabah) {
		this.segmenNasabah = segmenNasabah;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	public Integer getAgentBankId() {
		return agentBankId;
	}
	public void setAgentBankId(Integer agentBankId) {
		this.agentBankId = agentBankId;
	}
	public String getAgentBankName() {
		return agentBankName;
	}
	public void setAgentBankName(String agentBankName) {
		this.agentBankName = agentBankName;
	}
	public Integer getLamaProses() {
		return lamaProses;
	}
	public void setLamaProses(Integer lamaProses) {
		this.lamaProses = lamaProses;
	}
	public Boolean getIsFranchise() {
		return isFranchise;
	}
	public void setIsFranchise(Boolean isFranchise) {
		this.isFranchise = isFranchise;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAgentBankCode() {
		return agentBankCode;
	}
	public void setAgentBankCode(String agentBankCode) {
		this.agentBankCode = agentBankCode;
	}
	public Integer getCabangBankId() {
		return cabangBankId;
	}
	public void setCabangBankId(Integer cabangBankId) {
		this.cabangBankId = cabangBankId;
	}
	public String getCabangBankCode() {
		return cabangBankCode;
	}
	public void setCabangBankCode(String cabangBankCode) {
		this.cabangBankCode = cabangBankCode;
	}
	public String getCabangBankName() {
		return cabangBankName;
	}
	public void setCabangBankName(String cabangBankName) {
		this.cabangBankName = cabangBankName;
	}
	public String getPicPerekturanMerchName() {
		return picPerekturanMerchName;
	}
	public void setPicPerekturanMerchName(String picPerekturanMerchName) {
		this.picPerekturanMerchName = picPerekturanMerchName;
	}
	public String getPersetujuanPermohonanName() {
		return persetujuanPermohonanName;
	}
	public void setPersetujuanPermohonanName(String persetujuanPermohonanName) {
		this.persetujuanPermohonanName = persetujuanPermohonanName;
	}
	public String getPersetujuanDokumenName() {
		return persetujuanDokumenName;
	}
	public void setPersetujuanDokumenName(String persetujuanDokumenName) {
		this.persetujuanDokumenName = persetujuanDokumenName;
	}
	public String getPicPerekrutanMercJabatan() {
		return picPerekrutanMercJabatan;
	}
	public void setPicPerekrutanMercJabatan(String picPerekrutanMercJabatan) {
		this.picPerekrutanMercJabatan = picPerekrutanMercJabatan;
	}
	public String getPersetujuanPermohonanJabatan() {
		return persetujuanPermohonanJabatan;
	}
	public void setPersetujuanPermohonanJabatan(String persetujuanPermohonanJabatan) {
		this.persetujuanPermohonanJabatan = persetujuanPermohonanJabatan;
	}
	public String getPersetujuanDokumenJabatan() {
		return persetujuanDokumenJabatan;
	}
	public void setPersetujuanDokumenJabatan(String persetujuanDokumenJabatan) {
		this.persetujuanDokumenJabatan = persetujuanDokumenJabatan;
	}
	public Date getPicPerekrutanMercDate() {
		return picPerekrutanMercDate;
	}
	public void setPicPerekrutanMercDate(Date picPerekrutanMercDate) {
		this.picPerekrutanMercDate = picPerekrutanMercDate;
	}
	public Date getPersetujuanPermohonanDate() {
		return persetujuanPermohonanDate;
	}
	public void setPersetujuanPermohonanDate(Date persetujuanPermohonanDate) {
		this.persetujuanPermohonanDate = persetujuanPermohonanDate;
	}
	public Date getPersetujuanDokumenDate() {
		return persetujuanDokumenDate;
	}
	public void setPersetujuanDokumenDate(Date persetujuanDokumenDate) {
		this.persetujuanDokumenDate = persetujuanDokumenDate;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getMerkName() {
		return merkName;
	}
	public void setMerkName(String merkName) {
		this.merkName = merkName;
	}
	public Boolean getIsSales() {
		return isSales;
	}
	public void setIsSales(Boolean isSales) {
		this.isSales = isSales;
	}
	public String getSalesName() {
		return salesName;
	}
	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}
	public Boolean getIsPengajuanCabang() {
		return isPengajuanCabang;
	}
	public void setIsPengajuanCabang(Boolean isPengajuanCabang) {
		this.isPengajuanCabang = isPengajuanCabang;
	}
	public String getSalesCode() {
		return salesCode;
	}
	public void setSalesCode(String salesCode) {
		this.salesCode = salesCode;
	}
	public Boolean getRekomendasiCabang() {
		return rekomendasiCabang;
	}
	public void setRekomendasiCabang(Boolean rekomendasiCabang) {
		this.rekomendasiCabang = rekomendasiCabang;
	}
	public Integer getMerchantsettleId() {
		return merchantsettleId;
	}
	public void setMerchantsettleId(Integer merchantsettleId) {
		this.merchantsettleId = merchantsettleId;
	}
	public String getMerchantsettleCode() {
		return merchantsettleCode;
	}
	public void setMerchantsettleCode(String merchantsettleCode) {
		this.merchantsettleCode = merchantsettleCode;
	}
	public String getMerchantsettleName() {
		return merchantsettleName;
	}
	public void setMerchantsettleName(String merchantsettleName) {
		this.merchantsettleName = merchantsettleName;
	}
	public String getTrackingId() {
		return trackingId;
	}
	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}
	public String getLaporanId() {
		return laporanId;
	}
	public void setLaporanId(String laporanId) {
		this.laporanId = laporanId;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getNotesPendingDocument() {
		return notesPendingDocument;
	}
	public void setNotesPendingDocument(String notesPendingDocument) {
		this.notesPendingDocument = notesPendingDocument;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("_Merchant [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", groupId=");
		builder.append(groupId);
		builder.append(", merkId=");
		builder.append(merkId);
		builder.append(", villageId=");
		builder.append(villageId);
		builder.append(", villageName=");
		builder.append(villageName);
		builder.append(", postalId=");
		builder.append(postalId);
		builder.append(", postalCode=");
		builder.append(postalCode);
		builder.append(", subdistrictId=");
		builder.append(subdistrictId);
		builder.append(", subdistrictName=");
		builder.append(subdistrictName);
		builder.append(", regencyId=");
		builder.append(regencyId);
		builder.append(", regencyName=");
		builder.append(regencyName);
		builder.append(", provinceId=");
		builder.append(provinceId);
		builder.append(", provinceName=");
		builder.append(provinceName);
		builder.append(", countryId=");
		builder.append(countryId);
		builder.append(", countryName=");
		builder.append(countryName);
		builder.append(", geolocation=");
		builder.append(geolocation);
		builder.append(", email=");
		builder.append(email);
		builder.append(", isCcBca=");
		builder.append(isCcBca);
		builder.append(", ccBcaAccountNo=");
		builder.append(ccBcaAccountNo);
		builder.append(", ccBcaAccountName=");
		builder.append(ccBcaAccountName);
		builder.append(", ccBcaBranch=");
		builder.append(ccBcaBranch);
		builder.append(", isCcOtherBank=");
		builder.append(isCcOtherBank);
		builder.append(", ccOtherBankAccNo=");
		builder.append(ccOtherBankAccNo);
		builder.append(", ccOtherBankAccName=");
		builder.append(ccOtherBankAccName);
		builder.append(", ccOtherBankBranch=");
		builder.append(ccOtherBankBranch);
		builder.append(", isDebitBca=");
		builder.append(isDebitBca);
		builder.append(", debitBcaAccNo=");
		builder.append(debitBcaAccNo);
		builder.append(", debitBcaAccName=");
		builder.append(debitBcaAccName);
		builder.append(", debitBcaBranch=");
		builder.append(debitBcaBranch);
		builder.append(", aktaPendirian=");
		builder.append(aktaPendirian);
		builder.append(", pengesahanHakim=");
		builder.append(pengesahanHakim);
		builder.append(", aktaPergantianPeng=");
		builder.append(aktaPergantianPeng);
		builder.append(", siup=");
		builder.append(siup);
		builder.append(", siupDate=");
		builder.append(siupDate);
		builder.append(", siupExpiredDate=");
		builder.append(siupExpiredDate);
		builder.append(", notesDocument=");
		builder.append(notesDocument);
		builder.append(", pemilikId=");
		builder.append(pemilikId);
		builder.append(", statusDokumenId=");
		builder.append(statusDokumenId);
		builder.append(", pemilikName=");
		builder.append(pemilikName);
		builder.append(", segmenNasabah=");
		builder.append(segmenNasabah);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", mobilePhone=");
		builder.append(mobilePhone);
		builder.append(", status=");
		builder.append(status);
		builder.append(", keterangan=");
		builder.append(keterangan);
		builder.append(", agentBankId=");
		builder.append(agentBankId);
		builder.append(", agentBankName=");
		builder.append(agentBankName);
		builder.append(", lamaProses=");
		builder.append(lamaProses);
		builder.append(", isFranchise=");
		builder.append(isFranchise);
		builder.append(", address=");
		builder.append(address);
		builder.append(", agentBankCode=");
		builder.append(agentBankCode);
		builder.append(", cabangBankId=");
		builder.append(cabangBankId);
		builder.append(", cabangBankCode=");
		builder.append(cabangBankCode);
		builder.append(", cabangBankName=");
		builder.append(cabangBankName);
		builder.append(", picPerekturanMerchName=");
		builder.append(picPerekturanMerchName);
		builder.append(", persetujuanPermohonanName=");
		builder.append(persetujuanPermohonanName);
		builder.append(", persetujuanDokumenName=");
		builder.append(persetujuanDokumenName);
		builder.append(", picPerekrutanMercJabatan=");
		builder.append(picPerekrutanMercJabatan);
		builder.append(", persetujuanPermohonanJabatan=");
		builder.append(persetujuanPermohonanJabatan);
		builder.append(", persetujuanDokumenJabatan=");
		builder.append(persetujuanDokumenJabatan);
		builder.append(", picPerekrutanMercDate=");
		builder.append(picPerekrutanMercDate);
		builder.append(", persetujuanPermohonanDate=");
		builder.append(persetujuanPermohonanDate);
		builder.append(", persetujuanDokumenDate=");
		builder.append(persetujuanDokumenDate);
		builder.append(", groupName=");
		builder.append(groupName);
		builder.append(", merkName=");
		builder.append(merkName);
		builder.append(", isSales=");
		builder.append(isSales);
		builder.append(", salesName=");
		builder.append(salesName);
		builder.append(", isPengajuanCabang=");
		builder.append(isPengajuanCabang);
		builder.append(", salesCode=");
		builder.append(salesCode);
		builder.append(", rekomendasiCabang=");
		builder.append(rekomendasiCabang);
		builder.append(", merchantsettleId=");
		builder.append(merchantsettleId);
		builder.append(", merchantsettleCode=");
		builder.append(merchantsettleCode);
		builder.append(", merchantsettleName=");
		builder.append(merchantsettleName);
		builder.append(", trackingId=");
		builder.append(trackingId);
		builder.append(", laporanId=");
		builder.append(laporanId);
		builder.append(", groupCode=");
		builder.append(groupCode);
		builder.append(", source=");
		builder.append(source);
		builder.append(", notesPendingDocument=");
		builder.append(notesPendingDocument);
		builder.append("]");
		return builder.toString();
	}
}
