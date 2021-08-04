package id.co.bca.magenta.api.merchantcare.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Outlet {
	private Integer id;
	private String mid;
	private String status;
	private String name;
	private String nameOnInvoice;
	private String address1;
	private String address2;
	private Integer postalId;
	private String postalCode;
	private Integer subdistrictId;
	private String subdistrictName;
	private Integer regencyId;
	private String regencyName;
	private Integer provinceId;
	private String provinceName;
	private Integer villageId;
	private String villageName;
	private Integer countryId;
	private String countryName;
	private String phone;
	private String mobilePhone;
	private String fax;
	private String notes;
	private String geolocation;
	private Integer lokasiUsahaId;
	private String lokasiUsahaName;
	private String posisiLokasiUsaha;
	private String tipeLokasiUsaha;
	private Integer tipeLokasiUsahaId;
	private String tipeLokasiUsahaName;
	private Integer jumlahCounter;
	private String emailAddressStatetement;
	private String emailAddressStatetement2;
	private Boolean kepemilikan;
	private Integer kepemilikanWaktu;
	private String kepemilikanNotes;
	private Integer lamaUsaha;
	private Boolean edcBankLain;
	private String edcBankLainName1;
	private String edcBankLainName2;
	private String edcBankLainName3;
	private String termurah;
	private String perTermurah;
	private String termahal;
	private String perTermahal;
	private BigDecimal rata2NominalTransaksi;
	private BigDecimal omsetPerbulan;
	private BigDecimal frekTransaksi;
	private String operasionalStartTime;
	private String operasionalEndTime;
	private Boolean isCcBca;
	private String ccBcaAccountNo;
	private String ccBcaAccountName;
	private String ccBcaBranch;
	private Boolean isCcOtherBank;
	private String ccOtherBankAccNo;
	private String ccOtherBankAccName;
	private String ccOtherBankCode;
	private String ccOtherBankName;
	private Boolean isDebitBca;
	private String debitBcaAccNo;
	private String debitBcaAccName;
	private String debitBcaBranch;
	private String flazzBcaAccNo;
	private String flazzBcaAccName;
	private String flazzBcaBranch;
	private String sakukuBcaAccNo;
	private String sakukuBcaAccName;
	private String sakukuBcaBranch;
	private Boolean isSplitCredit;
	private Boolean isSplitDebit;
	private Date tglSelesaiPameran;
	private String ecommWebUrl;
	private String ecommCallbackUrl;
	private String ecommBackendUrl;
	private String ecommAmount3Dsecure;
	private String ecomm3Dsecure;
	private String ecommIntegration;
	private String ecommIntegrationReturnUrl;
	private String ecommIntegrationBackendUrl;
	private String ecommApps;
	private Boolean ecommFraud;
	private String ecommFraudPspName;
	private Boolean ecommInventoryMngmt;
	private String ecommSuperAdminName;
	private String ecommSuperAdminPhone;
	private String ecommSuperAdminEmail;
	private String ecommKeyReceiverName;
	private String ecommKeyReceiverPhone;
	private String ecommKeyReceiverEmail;
	private String ecommPassReceiverName;
	private String ecommPassReceiverPhone;
	private String ecommPassReceiverEmail;
	private String ecommBchName;
	private String ecommBchPhone;
	private String ecommBchEmail;
	private String ecommPmName;
	private String ecommPmPhone;
	private String ecommPmEmail;
	private String ecommFraudhandlingName;
	private String ecommFraudhandlingPhone;
	private String ecommFraudhandlingEmail;
	private String ecommKlikpayCabang;
	private String ecommKlikpayCode;
	private String ecommKlikpayCcodeDc23;
	private String ecommKlikpayName;
	private String ecommMutationName;
	private String ecommTrxMinFullPayment;
	private String ecommTrxMaxFullPayment;
	private String ecommTrxMinCicilan;
	private String ecommTrxMaxCicilan;
	private Date tglBerdiri;
	private String mposPic;
	private String mposJabatan;
	private String mposPhone;
	private String mposMobilePhone;
	private String mposEmailUserId;
	private String mposEmailPassword;
	private String picName;
	private String picPhone;
	private String picEmail;
	private String agentBankCode;
	private String cabangCode;
	private String dateOpen;
	private String lastMntDate;
	private Integer merchantId;
	private Integer mccId;
	private Integer bcaMerchantTypeId;
	private Boolean isMagenta;
	private String address1Invoice;
	private String address2Invoice;
	private String jenisOutlet;
	private String lokasiUsahaCode;
	private Date tglPasang;
	private Date tglTarik;
	private Integer agentBankId;
	private String agentBankName;
	private Integer cabangBankId;
	private String cabangBankCode;
	private String cabangBankName;
	private Integer cabangPemasanganId;
	private String cabangPemasanganCode;
	private String cabangPemasanganName;
	private String ecommType;
	private BigDecimal ecommTrxMaxKlikpay;
	private BigDecimal ecommTrxMinKlikpay;
	private Integer readerOnly;
	private String mccName;
	private BigDecimal rata2PenjualanPerbulan;
	private String ecommReturnUrl;
	private String ecommFasilitas;
	private BigDecimal ecommMinimumAmmount;
	private String lokasiUsaha;
	private Integer posisiLokasiUsahaId;
	private String statusKepemilikan;
	private Integer statusKepemilikanId;
	private Integer merchantSettleId;
	private String merchantSettleCode;
	private String merchantSettleName;
	private Boolean isSameAddress;
	private String otherAddress1;
	private String otherAddress2;
	private Integer villageIdPemasangan;
	private String villageNamePemasangan;
	private Integer postalIdPemasangan;
	private String postalCodePemasangan;
	private Integer regencyIdPemasangan;
	private String regencyNamePemasangan;
	private Integer provinceIdPemasangan;
	private String provinceNamePemasangan;
	private Integer countryIdPemasangan;
	private String countryNamePemasangan;
	private Integer subdistrictIdPemasangan;
	private String subdistrictNamePemasangan;
	private Boolean isSameParentFacility;
	private Boolean isAddressPengiriman;
	private String address1Pengiriman;
	private String address2Pengiriman;
	private Integer villageIdPengiriman;
	private String villageNamePengiriman;
	private Integer postalIdPengiriman;
	private Integer postalCodePengiriman;
	private Integer regencyIdPengiriman;
	private String regencyNamePengiriman;
	private Integer provinceIdPengiriman;
	private String provinceNamePengiriman;
	private Integer countryIdPengiriman;
	private String countryNamePengiriman;
	private Boolean isAddressPenarikan;
	private String address1Penarikan;
	private String Address2Penarikan;
	private Integer villageIdPenarikan;
	private String villageNamePenarikan;
	private Integer postalIdPenarikan;
	private Integer postalCodePenarikan;
	private Integer regencyIdPenarikan;
	private String regencyNamePenarikan;
	private Integer provinceIdPenarikan;
	private String provinceNamePenarikan;
	private Integer countryIdPenarikan;
	private String countryNamePenarikan;
	private Boolean isOutlet;
	private Integer subdistrictIdPengiriman;
	private String subdistrictNamePengiriman;
	private Integer subdistrictIdPenarikan;
	private String subdistrictNamePenarikan;
	private String namaPameran;
	private String mccCode;
	private String memo;
	private String email;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameOnInvoice() {
		return nameOnInvoice;
	}
	public void setNameOnInvoice(String nameOnInvoice) {
		this.nameOnInvoice = nameOnInvoice;
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
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getGeolocation() {
		return geolocation;
	}
	public void setGeolocation(String geolocation) {
		this.geolocation = geolocation;
	}
	public Integer getLokasiUsahaId() {
		return lokasiUsahaId;
	}
	public void setLokasiUsahaId(Integer lokasiUsahaId) {
		this.lokasiUsahaId = lokasiUsahaId;
	}
	public String getLokasiUsahaName() {
		return lokasiUsahaName;
	}
	public void setLokasiUsahaName(String lokasiUsahaName) {
		this.lokasiUsahaName = lokasiUsahaName;
	}
	public String getPosisiLokasiUsaha() {
		return posisiLokasiUsaha;
	}
	public void setPosisiLokasiUsaha(String posisiLokasiUsaha) {
		this.posisiLokasiUsaha = posisiLokasiUsaha;
	}
	public String getTipeLokasiUsaha() {
		return tipeLokasiUsaha;
	}
	public void setTipeLokasiUsaha(String tipeLokasiUsaha) {
		this.tipeLokasiUsaha = tipeLokasiUsaha;
	}
	public Integer getTipeLokasiUsahaId() {
		return tipeLokasiUsahaId;
	}
	public void setTipeLokasiUsahaId(Integer tipeLokasiUsahaId) {
		this.tipeLokasiUsahaId = tipeLokasiUsahaId;
	}
	public String getTipeLokasiUsahaName() {
		return tipeLokasiUsahaName;
	}
	public void setTipeLokasiUsahaName(String tipeLokasiUsahaName) {
		this.tipeLokasiUsahaName = tipeLokasiUsahaName;
	}
	public Integer getJumlahCounter() {
		return jumlahCounter;
	}
	public void setJumlahCounter(Integer jumlahCounter) {
		this.jumlahCounter = jumlahCounter;
	}
	public String getEmailAddressStatetement() {
		return emailAddressStatetement;
	}
	public void setEmailAddressStatetement(String emailAddressStatetement) {
		this.emailAddressStatetement = emailAddressStatetement;
	}
	public String getEmailAddressStatetement2() {
		return emailAddressStatetement2;
	}
	public void setEmailAddressStatetement2(String emailAddressStatetement2) {
		this.emailAddressStatetement2 = emailAddressStatetement2;
	}
	public Boolean getKepemilikan() {
		return kepemilikan;
	}
	public void setKepemilikan(Boolean kepemilikan) {
		this.kepemilikan = kepemilikan;
	}
	public Integer getKepemilikanWaktu() {
		return kepemilikanWaktu;
	}
	public void setKepemilikanWaktu(Integer kepemilikanWaktu) {
		this.kepemilikanWaktu = kepemilikanWaktu;
	}
	public String getKepemilikanNotes() {
		return kepemilikanNotes;
	}
	public void setKepemilikanNotes(String kepemilikanNotes) {
		this.kepemilikanNotes = kepemilikanNotes;
	}
	public Integer getLamaUsaha() {
		return lamaUsaha;
	}
	public void setLamaUsaha(Integer lamaUsaha) {
		this.lamaUsaha = lamaUsaha;
	}
	public Boolean getEdcBankLain() {
		return edcBankLain;
	}
	public void setEdcBankLain(Boolean edcBankLain) {
		this.edcBankLain = edcBankLain;
	}
	public String getEdcBankLainName1() {
		return edcBankLainName1;
	}
	public void setEdcBankLainName1(String edcBankLainName1) {
		this.edcBankLainName1 = edcBankLainName1;
	}
	public String getEdcBankLainName2() {
		return edcBankLainName2;
	}
	public void setEdcBankLainName2(String edcBankLainName2) {
		this.edcBankLainName2 = edcBankLainName2;
	}
	public String getEdcBankLainName3() {
		return edcBankLainName3;
	}
	public void setEdcBankLainName3(String edcBankLainName3) {
		this.edcBankLainName3 = edcBankLainName3;
	}
	public String getTermurah() {
		return termurah;
	}
	public void setTermurah(String termurah) {
		this.termurah = termurah;
	}
	public String getPerTermurah() {
		return perTermurah;
	}
	public void setPerTermurah(String perTermurah) {
		this.perTermurah = perTermurah;
	}
	public String getTermahal() {
		return termahal;
	}
	public void setTermahal(String termahal) {
		this.termahal = termahal;
	}
	public String getPerTermahal() {
		return perTermahal;
	}
	public void setPerTermahal(String perTermahal) {
		this.perTermahal = perTermahal;
	}
	public BigDecimal getRata2NominalTransaksi() {
		return rata2NominalTransaksi;
	}
	public void setRata2NominalTransaksi(BigDecimal rata2NominalTransaksi) {
		this.rata2NominalTransaksi = rata2NominalTransaksi;
	}
	public BigDecimal getOmsetPerbulan() {
		return omsetPerbulan;
	}
	public void setOmsetPerbulan(BigDecimal omsetPerbulan) {
		this.omsetPerbulan = omsetPerbulan;
	}
	public BigDecimal getFrekTransaksi() {
		return frekTransaksi;
	}
	public void setFrekTransaksi(BigDecimal frekTransaksi) {
		this.frekTransaksi = frekTransaksi;
	}
	public String getOperasionalStartTime() {
		return operasionalStartTime;
	}
	public void setOperasionalStartTime(String operasionalStartTime) {
		this.operasionalStartTime = operasionalStartTime;
	}
	public String getOperasionalEndTime() {
		return operasionalEndTime;
	}
	public void setOperasionalEndTime(String operasionalEndTime) {
		this.operasionalEndTime = operasionalEndTime;
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
	public String getCcOtherBankCode() {
		return ccOtherBankCode;
	}
	public void setCcOtherBankCode(String ccOtherBankCode) {
		this.ccOtherBankCode = ccOtherBankCode;
	}
	public String getCcOtherBankName() {
		return ccOtherBankName;
	}
	public void setCcOtherBankName(String ccOtherBankName) {
		this.ccOtherBankName = ccOtherBankName;
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
	public String getFlazzBcaAccNo() {
		return flazzBcaAccNo;
	}
	public void setFlazzBcaAccNo(String flazzBcaAccNo) {
		this.flazzBcaAccNo = flazzBcaAccNo;
	}
	public String getFlazzBcaAccName() {
		return flazzBcaAccName;
	}
	public void setFlazzBcaAccName(String flazzBcaAccName) {
		this.flazzBcaAccName = flazzBcaAccName;
	}
	public String getFlazzBcaBranch() {
		return flazzBcaBranch;
	}
	public void setFlazzBcaBranch(String flazzBcaBranch) {
		this.flazzBcaBranch = flazzBcaBranch;
	}
	public String getSakukuBcaAccNo() {
		return sakukuBcaAccNo;
	}
	public void setSakukuBcaAccNo(String sakukuBcaAccNo) {
		this.sakukuBcaAccNo = sakukuBcaAccNo;
	}
	public String getSakukuBcaAccName() {
		return sakukuBcaAccName;
	}
	public void setSakukuBcaAccName(String sakukuBcaAccName) {
		this.sakukuBcaAccName = sakukuBcaAccName;
	}
	public String getSakukuBcaBranch() {
		return sakukuBcaBranch;
	}
	public void setSakukuBcaBranch(String sakukuBcaBranch) {
		this.sakukuBcaBranch = sakukuBcaBranch;
	}
	public Boolean getIsSplitCredit() {
		return isSplitCredit;
	}
	public void setIsSplitCredit(Boolean isSplitCredit) {
		this.isSplitCredit = isSplitCredit;
	}
	public Boolean getIsSplitDebit() {
		return isSplitDebit;
	}
	public void setIsSplitDebit(Boolean isSplitDebit) {
		this.isSplitDebit = isSplitDebit;
	}
	public Date getTglSelesaiPameran() {
		return tglSelesaiPameran;
	}
	public void setTglSelesaiPameran(Date tglSelesaiPameran) {
		this.tglSelesaiPameran = tglSelesaiPameran;
	}
	public String getEcommWebUrl() {
		return ecommWebUrl;
	}
	public void setEcommWebUrl(String ecommWebUrl) {
		this.ecommWebUrl = ecommWebUrl;
	}
	public String getEcommCallbackUrl() {
		return ecommCallbackUrl;
	}
	public void setEcommCallbackUrl(String ecommCallbackUrl) {
		this.ecommCallbackUrl = ecommCallbackUrl;
	}
	public String getEcommBackendUrl() {
		return ecommBackendUrl;
	}
	public void setEcommBackendUrl(String ecommBackendUrl) {
		this.ecommBackendUrl = ecommBackendUrl;
	}
	public String getEcommAmount3Dsecure() {
		return ecommAmount3Dsecure;
	}
	public void setEcommAmount3Dsecure(String ecommAmount3Dsecure) {
		this.ecommAmount3Dsecure = ecommAmount3Dsecure;
	}
	public String getEcomm3Dsecure() {
		return ecomm3Dsecure;
	}
	public void setEcomm3Dsecure(String ecomm3Dsecure) {
		this.ecomm3Dsecure = ecomm3Dsecure;
	}
	public String getEcommIntegration() {
		return ecommIntegration;
	}
	public void setEcommIntegration(String ecommIntegration) {
		this.ecommIntegration = ecommIntegration;
	}
	public String getEcommIntegrationReturnUrl() {
		return ecommIntegrationReturnUrl;
	}
	public void setEcommIntegrationReturnUrl(String ecommIntegrationReturnUrl) {
		this.ecommIntegrationReturnUrl = ecommIntegrationReturnUrl;
	}
	public String getEcommIntegrationBackendUrl() {
		return ecommIntegrationBackendUrl;
	}
	public void setEcommIntegrationBackendUrl(String ecommIntegrationBackendUrl) {
		this.ecommIntegrationBackendUrl = ecommIntegrationBackendUrl;
	}
	public String getEcommApps() {
		return ecommApps;
	}
	public void setEcommApps(String ecommApps) {
		this.ecommApps = ecommApps;
	}
	public Boolean getEcommFraud() {
		return ecommFraud;
	}
	public void setEcommFraud(Boolean ecommFraud) {
		this.ecommFraud = ecommFraud;
	}
	public String getEcommFraudPspName() {
		return ecommFraudPspName;
	}
	public void setEcommFraudPspName(String ecommFraudPspName) {
		this.ecommFraudPspName = ecommFraudPspName;
	}
	public Boolean getEcommInventoryMngmt() {
		return ecommInventoryMngmt;
	}
	public void setEcommInventoryMngmt(Boolean ecommInventoryMngmt) {
		this.ecommInventoryMngmt = ecommInventoryMngmt;
	}
	public String getEcommSuperAdminName() {
		return ecommSuperAdminName;
	}
	public void setEcommSuperAdminName(String ecommSuperAdminName) {
		this.ecommSuperAdminName = ecommSuperAdminName;
	}
	public String getEcommSuperAdminPhone() {
		return ecommSuperAdminPhone;
	}
	public void setEcommSuperAdminPhone(String ecommSuperAdminPhone) {
		this.ecommSuperAdminPhone = ecommSuperAdminPhone;
	}
	public String getEcommSuperAdminEmail() {
		return ecommSuperAdminEmail;
	}
	public void setEcommSuperAdminEmail(String ecommSuperAdminEmail) {
		this.ecommSuperAdminEmail = ecommSuperAdminEmail;
	}
	public String getEcommKeyReceiverName() {
		return ecommKeyReceiverName;
	}
	public void setEcommKeyReceiverName(String ecommKeyReceiverName) {
		this.ecommKeyReceiverName = ecommKeyReceiverName;
	}
	public String getEcommKeyReceiverPhone() {
		return ecommKeyReceiverPhone;
	}
	public void setEcommKeyReceiverPhone(String ecommKeyReceiverPhone) {
		this.ecommKeyReceiverPhone = ecommKeyReceiverPhone;
	}
	public String getEcommKeyReceiverEmail() {
		return ecommKeyReceiverEmail;
	}
	public void setEcommKeyReceiverEmail(String ecommKeyReceiverEmail) {
		this.ecommKeyReceiverEmail = ecommKeyReceiverEmail;
	}
	public String getEcommPassReceiverName() {
		return ecommPassReceiverName;
	}
	public void setEcommPassReceiverName(String ecommPassReceiverName) {
		this.ecommPassReceiverName = ecommPassReceiverName;
	}
	public String getEcommPassReceiverPhone() {
		return ecommPassReceiverPhone;
	}
	public void setEcommPassReceiverPhone(String ecommPassReceiverPhone) {
		this.ecommPassReceiverPhone = ecommPassReceiverPhone;
	}
	public String getEcommPassReceiverEmail() {
		return ecommPassReceiverEmail;
	}
	public void setEcommPassReceiverEmail(String ecommPassReceiverEmail) {
		this.ecommPassReceiverEmail = ecommPassReceiverEmail;
	}
	public String getEcommBchName() {
		return ecommBchName;
	}
	public void setEcommBchName(String ecommBchName) {
		this.ecommBchName = ecommBchName;
	}
	public String getEcommBchPhone() {
		return ecommBchPhone;
	}
	public void setEcommBchPhone(String ecommBchPhone) {
		this.ecommBchPhone = ecommBchPhone;
	}
	public String getEcommBchEmail() {
		return ecommBchEmail;
	}
	public void setEcommBchEmail(String ecommBchEmail) {
		this.ecommBchEmail = ecommBchEmail;
	}
	public String getEcommPmName() {
		return ecommPmName;
	}
	public void setEcommPmName(String ecommPmName) {
		this.ecommPmName = ecommPmName;
	}
	public String getEcommPmPhone() {
		return ecommPmPhone;
	}
	public void setEcommPmPhone(String ecommPmPhone) {
		this.ecommPmPhone = ecommPmPhone;
	}
	public String getEcommPmEmail() {
		return ecommPmEmail;
	}
	public void setEcommPmEmail(String ecommPmEmail) {
		this.ecommPmEmail = ecommPmEmail;
	}
	public String getEcommFraudhandlingName() {
		return ecommFraudhandlingName;
	}
	public void setEcommFraudhandlingName(String ecommFraudhandlingName) {
		this.ecommFraudhandlingName = ecommFraudhandlingName;
	}
	public String getEcommFraudhandlingPhone() {
		return ecommFraudhandlingPhone;
	}
	public void setEcommFraudhandlingPhone(String ecommFraudhandlingPhone) {
		this.ecommFraudhandlingPhone = ecommFraudhandlingPhone;
	}
	public String getEcommFraudhandlingEmail() {
		return ecommFraudhandlingEmail;
	}
	public void setEcommFraudhandlingEmail(String ecommFraudhandlingEmail) {
		this.ecommFraudhandlingEmail = ecommFraudhandlingEmail;
	}
	public String getEcommKlikpayCabang() {
		return ecommKlikpayCabang;
	}
	public void setEcommKlikpayCabang(String ecommKlikpayCabang) {
		this.ecommKlikpayCabang = ecommKlikpayCabang;
	}
	public String getEcommKlikpayCode() {
		return ecommKlikpayCode;
	}
	public void setEcommKlikpayCode(String ecommKlikpayCode) {
		this.ecommKlikpayCode = ecommKlikpayCode;
	}
	public String getEcommKlikpayCcodeDc23() {
		return ecommKlikpayCcodeDc23;
	}
	public void setEcommKlikpayCcodeDc23(String ecommKlikpayCcodeDc23) {
		this.ecommKlikpayCcodeDc23 = ecommKlikpayCcodeDc23;
	}
	public String getEcommKlikpayName() {
		return ecommKlikpayName;
	}
	public void setEcommKlikpayName(String ecommKlikpayName) {
		this.ecommKlikpayName = ecommKlikpayName;
	}
	public String getEcommMutationName() {
		return ecommMutationName;
	}
	public void setEcommMutationName(String ecommMutationName) {
		this.ecommMutationName = ecommMutationName;
	}
	public String getEcommTrxMinFullPayment() {
		return ecommTrxMinFullPayment;
	}
	public void setEcommTrxMinFullPayment(String ecommTrxMinFullPayment) {
		this.ecommTrxMinFullPayment = ecommTrxMinFullPayment;
	}
	public String getEcommTrxMaxFullPayment() {
		return ecommTrxMaxFullPayment;
	}
	public void setEcommTrxMaxFullPayment(String ecommTrxMaxFullPayment) {
		this.ecommTrxMaxFullPayment = ecommTrxMaxFullPayment;
	}
	public String getEcommTrxMinCicilan() {
		return ecommTrxMinCicilan;
	}
	public void setEcommTrxMinCicilan(String ecommTrxMinCicilan) {
		this.ecommTrxMinCicilan = ecommTrxMinCicilan;
	}
	public String getEcommTrxMaxCicilan() {
		return ecommTrxMaxCicilan;
	}
	public void setEcommTrxMaxCicilan(String ecommTrxMaxCicilan) {
		this.ecommTrxMaxCicilan = ecommTrxMaxCicilan;
	}
	public Date getTglBerdiri() {
		return tglBerdiri;
	}
	public void setTglBerdiri(Date tglBerdiri) {
		this.tglBerdiri = tglBerdiri;
	}
	public String getMposPic() {
		return mposPic;
	}
	public void setMposPic(String mposPic) {
		this.mposPic = mposPic;
	}
	public String getMposJabatan() {
		return mposJabatan;
	}
	public void setMposJabatan(String mposJabatan) {
		this.mposJabatan = mposJabatan;
	}
	public String getMposPhone() {
		return mposPhone;
	}
	public void setMposPhone(String mposPhone) {
		this.mposPhone = mposPhone;
	}
	public String getMposMobilePhone() {
		return mposMobilePhone;
	}
	public void setMposMobilePhone(String mposMobilePhone) {
		this.mposMobilePhone = mposMobilePhone;
	}
	public String getMposEmailUserId() {
		return mposEmailUserId;
	}
	public void setMposEmailUserId(String mposEmailUserId) {
		this.mposEmailUserId = mposEmailUserId;
	}
	public String getMposEmailPassword() {
		return mposEmailPassword;
	}
	public void setMposEmailPassword(String mposEmailPassword) {
		this.mposEmailPassword = mposEmailPassword;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public String getPicPhone() {
		return picPhone;
	}
	public void setPicPhone(String picPhone) {
		this.picPhone = picPhone;
	}
	public String getPicEmail() {
		return picEmail;
	}
	public void setPicEmail(String picEmail) {
		this.picEmail = picEmail;
	}
	public String getAgentBankCode() {
		return agentBankCode;
	}
	public void setAgentBankCode(String agentBankCode) {
		this.agentBankCode = agentBankCode;
	}
	public String getCabangCode() {
		return cabangCode;
	}
	public void setCabangCode(String cabangCode) {
		this.cabangCode = cabangCode;
	}
	public String getDateOpen() {
		return dateOpen;
	}
	public void setDateOpen(String dateOpen) {
		this.dateOpen = dateOpen;
	}
	public String getLastMntDate() {
		return lastMntDate;
	}
	public void setLastMntDate(String lastMntDate) {
		this.lastMntDate = lastMntDate;
	}
	public Integer getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}
	public Integer getMccId() {
		return mccId;
	}
	public void setMccId(Integer mccId) {
		this.mccId = mccId;
	}
	public Integer getBcaMerchantTypeId() {
		return bcaMerchantTypeId;
	}
	public void setBcaMerchantTypeId(Integer bcaMerchantTypeId) {
		this.bcaMerchantTypeId = bcaMerchantTypeId;
	}
	public Boolean getIsMagenta() {
		return isMagenta;
	}
	public void setIsMagenta(Boolean isMagenta) {
		this.isMagenta = isMagenta;
	}
	public String getAddress1Invoice() {
		return address1Invoice;
	}
	public void setAddress1Invoice(String address1Invoice) {
		this.address1Invoice = address1Invoice;
	}
	public String getAddress2Invoice() {
		return address2Invoice;
	}
	public void setAddress2Invoice(String address2Invoice) {
		this.address2Invoice = address2Invoice;
	}
	public String getJenisOutlet() {
		return jenisOutlet;
	}
	public void setJenisOutlet(String jenisOutlet) {
		this.jenisOutlet = jenisOutlet;
	}
	public String getLokasiUsahaCode() {
		return lokasiUsahaCode;
	}
	public void setLokasiUsahaCode(String lokasiUsahaCode) {
		this.lokasiUsahaCode = lokasiUsahaCode;
	}
	public Date getTglPasang() {
		return tglPasang;
	}
	public void setTglPasang(Date tglPasang) {
		this.tglPasang = tglPasang;
	}
	public Date getTglTarik() {
		return tglTarik;
	}
	public void setTglTarik(Date tglTarik) {
		this.tglTarik = tglTarik;
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
	public Integer getCabangPemasanganId() {
		return cabangPemasanganId;
	}
	public void setCabangPemasanganId(Integer cabangPemasanganId) {
		this.cabangPemasanganId = cabangPemasanganId;
	}
	public String getCabangPemasanganCode() {
		return cabangPemasanganCode;
	}
	public void setCabangPemasanganCode(String cabangPemasanganCode) {
		this.cabangPemasanganCode = cabangPemasanganCode;
	}
	public String getCabangPemasanganName() {
		return cabangPemasanganName;
	}
	public void setCabangPemasanganName(String cabangPemasanganName) {
		this.cabangPemasanganName = cabangPemasanganName;
	}
	public String getEcommType() {
		return ecommType;
	}
	public void setEcommType(String ecommType) {
		this.ecommType = ecommType;
	}
	public BigDecimal getEcommTrxMaxKlikpay() {
		return ecommTrxMaxKlikpay;
	}
	public void setEcommTrxMaxKlikpay(BigDecimal ecommTrxMaxKlikpay) {
		this.ecommTrxMaxKlikpay = ecommTrxMaxKlikpay;
	}
	public BigDecimal getEcommTrxMinKlikpay() {
		return ecommTrxMinKlikpay;
	}
	public void setEcommTrxMinKlikpay(BigDecimal ecommTrxMinKlikpay) {
		this.ecommTrxMinKlikpay = ecommTrxMinKlikpay;
	}
	public Integer getReaderOnly() {
		return readerOnly;
	}
	public void setReaderOnly(Integer readerOnly) {
		this.readerOnly = readerOnly;
	}
	public String getMccName() {
		return mccName;
	}
	public void setMccName(String mccName) {
		this.mccName = mccName;
	}
	public BigDecimal getRata2PenjualanPerbulan() {
		return rata2PenjualanPerbulan;
	}
	public void setRata2PenjualanPerbulan(BigDecimal rata2PenjualanPerbulan) {
		this.rata2PenjualanPerbulan = rata2PenjualanPerbulan;
	}
	public String getEcommReturnUrl() {
		return ecommReturnUrl;
	}
	public void setEcommReturnUrl(String ecommReturnUrl) {
		this.ecommReturnUrl = ecommReturnUrl;
	}
	public String getEcommFasilitas() {
		return ecommFasilitas;
	}
	public void setEcommFasilitas(String ecommFasilitas) {
		this.ecommFasilitas = ecommFasilitas;
	}
	public BigDecimal getEcommMinimumAmmount() {
		return ecommMinimumAmmount;
	}
	public void setEcommMinimumAmmount(BigDecimal ecommMinimumAmmount) {
		this.ecommMinimumAmmount = ecommMinimumAmmount;
	}
	public String getLokasiUsaha() {
		return lokasiUsaha;
	}
	public void setLokasiUsaha(String lokasiUsaha) {
		this.lokasiUsaha = lokasiUsaha;
	}
	public Integer getPosisiLokasiUsahaId() {
		return posisiLokasiUsahaId;
	}
	public void setPosisiLokasiUsahaId(Integer posisiLokasiUsahaId) {
		this.posisiLokasiUsahaId = posisiLokasiUsahaId;
	}
	public String getStatusKepemilikan() {
		return statusKepemilikan;
	}
	public void setStatusKepemilikan(String statusKepemilikan) {
		this.statusKepemilikan = statusKepemilikan;
	}
	public Integer getStatusKepemilikanId() {
		return statusKepemilikanId;
	}
	public void setStatusKepemilikanId(Integer statusKepemilikanId) {
		this.statusKepemilikanId = statusKepemilikanId;
	}
	public Integer getMerchantSettleId() {
		return merchantSettleId;
	}
	public void setMerchantSettleId(Integer merchantSettleId) {
		this.merchantSettleId = merchantSettleId;
	}
	public String getMerchantSettleCode() {
		return merchantSettleCode;
	}
	public void setMerchantSettleCode(String merchantSettleCode) {
		this.merchantSettleCode = merchantSettleCode;
	}
	public String getMerchantSettleName() {
		return merchantSettleName;
	}
	public void setMerchantSettleName(String merchantSettleName) {
		this.merchantSettleName = merchantSettleName;
	}
	public Boolean getIsSameAddress() {
		return isSameAddress;
	}
	public void setIsSameAddress(Boolean isSameAddress) {
		this.isSameAddress = isSameAddress;
	}
	public String getOtherAddress1() {
		return otherAddress1;
	}
	public void setOtherAddress1(String otherAddress1) {
		this.otherAddress1 = otherAddress1;
	}
	public String getOtherAddress2() {
		return otherAddress2;
	}
	public void setOtherAddress2(String otherAddress2) {
		this.otherAddress2 = otherAddress2;
	}
	public Integer getVillageIdPemasangan() {
		return villageIdPemasangan;
	}
	public void setVillageIdPemasangan(Integer villageIdPemasangan) {
		this.villageIdPemasangan = villageIdPemasangan;
	}
	public String getVillageNamePemasangan() {
		return villageNamePemasangan;
	}
	public void setVillageNamePemasangan(String villageNamePemasangan) {
		this.villageNamePemasangan = villageNamePemasangan;
	}
	public Integer getPostalIdPemasangan() {
		return postalIdPemasangan;
	}
	public void setPostalIdPemasangan(Integer postalIdPemasangan) {
		this.postalIdPemasangan = postalIdPemasangan;
	}
	public String getPostalCodePemasangan() {
		return postalCodePemasangan;
	}
	public void setPostalCodePemasangan(String postalCodePemasangan) {
		this.postalCodePemasangan = postalCodePemasangan;
	}
	public Integer getRegencyIdPemasangan() {
		return regencyIdPemasangan;
	}
	public void setRegencyIdPemasangan(Integer regencyIdPemasangan) {
		this.regencyIdPemasangan = regencyIdPemasangan;
	}
	public String getRegencyNamePemasangan() {
		return regencyNamePemasangan;
	}
	public void setRegencyNamePemasangan(String regencyNamePemasangan) {
		this.regencyNamePemasangan = regencyNamePemasangan;
	}
	public Integer getProvinceIdPemasangan() {
		return provinceIdPemasangan;
	}
	public void setProvinceIdPemasangan(Integer provinceIdPemasangan) {
		this.provinceIdPemasangan = provinceIdPemasangan;
	}
	public String getProvinceNamePemasangan() {
		return provinceNamePemasangan;
	}
	public void setProvinceNamePemasangan(String provinceNamePemasangan) {
		this.provinceNamePemasangan = provinceNamePemasangan;
	}
	public Integer getCountryIdPemasangan() {
		return countryIdPemasangan;
	}
	public void setCountryIdPemasangan(Integer countryIdPemasangan) {
		this.countryIdPemasangan = countryIdPemasangan;
	}
	public String getCountryNamePemasangan() {
		return countryNamePemasangan;
	}
	public void setCountryNamePemasangan(String countryNamePemasangan) {
		this.countryNamePemasangan = countryNamePemasangan;
	}
	public Integer getSubdistrictIdPemasangan() {
		return subdistrictIdPemasangan;
	}
	public void setSubdistrictIdPemasangan(Integer subdistrictIdPemasangan) {
		this.subdistrictIdPemasangan = subdistrictIdPemasangan;
	}
	public String getSubdistrictNamePemasangan() {
		return subdistrictNamePemasangan;
	}
	public void setSubdistrictNamePemasangan(String subdistrictNamePemasangan) {
		this.subdistrictNamePemasangan = subdistrictNamePemasangan;
	}
	public Boolean getIsSameParentFacility() {
		return isSameParentFacility;
	}
	public void setIsSameParentFacility(Boolean isSameParentFacility) {
		this.isSameParentFacility = isSameParentFacility;
	}
	public Boolean getIsAddressPengiriman() {
		return isAddressPengiriman;
	}
	public void setIsAddressPengiriman(Boolean isAddressPengiriman) {
		this.isAddressPengiriman = isAddressPengiriman;
	}
	public String getAddress1Pengiriman() {
		return address1Pengiriman;
	}
	public void setAddress1Pengiriman(String address1Pengiriman) {
		this.address1Pengiriman = address1Pengiriman;
	}
	public String getAddress2Pengiriman() {
		return address2Pengiriman;
	}
	public void setAddress2Pengiriman(String address2Pengiriman) {
		this.address2Pengiriman = address2Pengiriman;
	}
	public Integer getVillageIdPengiriman() {
		return villageIdPengiriman;
	}
	public void setVillageIdPengiriman(Integer villageIdPengiriman) {
		this.villageIdPengiriman = villageIdPengiriman;
	}
	public String getVillageNamePengiriman() {
		return villageNamePengiriman;
	}
	public void setVillageNamePengiriman(String villageNamePengiriman) {
		this.villageNamePengiriman = villageNamePengiriman;
	}
	public Integer getPostalIdPengiriman() {
		return postalIdPengiriman;
	}
	public void setPostalIdPengiriman(Integer postalIdPengiriman) {
		this.postalIdPengiriman = postalIdPengiriman;
	}
	public Integer getPostalCodePengiriman() {
		return postalCodePengiriman;
	}
	public void setPostalCodePengiriman(Integer postalCodePengiriman) {
		this.postalCodePengiriman = postalCodePengiriman;
	}
	public Integer getRegencyIdPengiriman() {
		return regencyIdPengiriman;
	}
	public void setRegencyIdPengiriman(Integer regencyIdPengiriman) {
		this.regencyIdPengiriman = regencyIdPengiriman;
	}
	public String getRegencyNamePengiriman() {
		return regencyNamePengiriman;
	}
	public void setRegencyNamePengiriman(String regencyNamePengiriman) {
		this.regencyNamePengiriman = regencyNamePengiriman;
	}
	public Integer getProvinceIdPengiriman() {
		return provinceIdPengiriman;
	}
	public void setProvinceIdPengiriman(Integer provinceIdPengiriman) {
		this.provinceIdPengiriman = provinceIdPengiriman;
	}
	public String getProvinceNamePengiriman() {
		return provinceNamePengiriman;
	}
	public void setProvinceNamePengiriman(String provinceNamePengiriman) {
		this.provinceNamePengiriman = provinceNamePengiriman;
	}
	public Integer getCountryIdPengiriman() {
		return countryIdPengiriman;
	}
	public void setCountryIdPengiriman(Integer countryIdPengiriman) {
		this.countryIdPengiriman = countryIdPengiriman;
	}
	public String getCountryNamePengiriman() {
		return countryNamePengiriman;
	}
	public void setCountryNamePengiriman(String countryNamePengiriman) {
		this.countryNamePengiriman = countryNamePengiriman;
	}
	public Boolean getIsAddressPenarikan() {
		return isAddressPenarikan;
	}
	public void setIsAddressPenarikan(Boolean isAddressPenarikan) {
		this.isAddressPenarikan = isAddressPenarikan;
	}
	public String getAddress1Penarikan() {
		return address1Penarikan;
	}
	public void setAddress1Penarikan(String address1Penarikan) {
		this.address1Penarikan = address1Penarikan;
	}
	public String getAddress2Penarikan() {
		return Address2Penarikan;
	}
	public void setAddress2Penarikan(String address2Penarikan) {
		Address2Penarikan = address2Penarikan;
	}
	public Integer getVillageIdPenarikan() {
		return villageIdPenarikan;
	}
	public void setVillageIdPenarikan(Integer villageIdPenarikan) {
		this.villageIdPenarikan = villageIdPenarikan;
	}
	public String getVillageNamePenarikan() {
		return villageNamePenarikan;
	}
	public void setVillageNamePenarikan(String villageNamePenarikan) {
		this.villageNamePenarikan = villageNamePenarikan;
	}
	public Integer getPostalIdPenarikan() {
		return postalIdPenarikan;
	}
	public void setPostalIdPenarikan(Integer postalIdPenarikan) {
		this.postalIdPenarikan = postalIdPenarikan;
	}
	public Integer getPostalCodePenarikan() {
		return postalCodePenarikan;
	}
	public void setPostalCodePenarikan(Integer postalCodePenarikan) {
		this.postalCodePenarikan = postalCodePenarikan;
	}
	public Integer getRegencyIdPenarikan() {
		return regencyIdPenarikan;
	}
	public void setRegencyIdPenarikan(Integer regencyIdPenarikan) {
		this.regencyIdPenarikan = regencyIdPenarikan;
	}
	public String getRegencyNamePenarikan() {
		return regencyNamePenarikan;
	}
	public void setRegencyNamePenarikan(String regencyNamePenarikan) {
		this.regencyNamePenarikan = regencyNamePenarikan;
	}
	public Integer getProvinceIdPenarikan() {
		return provinceIdPenarikan;
	}
	public void setProvinceIdPenarikan(Integer provinceIdPenarikan) {
		this.provinceIdPenarikan = provinceIdPenarikan;
	}
	public String getProvinceNamePenarikan() {
		return provinceNamePenarikan;
	}
	public void setProvinceNamePenarikan(String provinceNamePenarikan) {
		this.provinceNamePenarikan = provinceNamePenarikan;
	}
	public Integer getCountryIdPenarikan() {
		return countryIdPenarikan;
	}
	public void setCountryIdPenarikan(Integer countryIdPenarikan) {
		this.countryIdPenarikan = countryIdPenarikan;
	}
	public String getCountryNamePenarikan() {
		return countryNamePenarikan;
	}
	public void setCountryNamePenarikan(String countryNamePenarikan) {
		this.countryNamePenarikan = countryNamePenarikan;
	}
	public Boolean getIsOutlet() {
		return isOutlet;
	}
	public void setIsOutlet(Boolean isOutlet) {
		this.isOutlet = isOutlet;
	}
	public Integer getSubdistrictIdPengiriman() {
		return subdistrictIdPengiriman;
	}
	public void setSubdistrictIdPengiriman(Integer subdistrictIdPengiriman) {
		this.subdistrictIdPengiriman = subdistrictIdPengiriman;
	}
	public String getSubdistrictNamePengiriman() {
		return subdistrictNamePengiriman;
	}
	public void setSubdistrictNamePengiriman(String subdistrictNamePengiriman) {
		this.subdistrictNamePengiriman = subdistrictNamePengiriman;
	}
	public Integer getSubdistrictIdPenarikan() {
		return subdistrictIdPenarikan;
	}
	public void setSubdistrictIdPenarikan(Integer subdistrictIdPenarikan) {
		this.subdistrictIdPenarikan = subdistrictIdPenarikan;
	}
	public String getSubdistrictNamePenarikan() {
		return subdistrictNamePenarikan;
	}
	public void setSubdistrictNamePenarikan(String subdistrictNamePenarikan) {
		this.subdistrictNamePenarikan = subdistrictNamePenarikan;
	}
	public String getNamaPameran() {
		return namaPameran;
	}
	public void setNamaPameran(String namaPameran) {
		this.namaPameran = namaPameran;
	}
	public String getMccCode() {
		return mccCode;
	}
	public void setMccCode(String mccCode) {
		this.mccCode = mccCode;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Outlet [id=");
		builder.append(id);
		builder.append(", mid=");
		builder.append(mid);
		builder.append(", status=");
		builder.append(status);
		builder.append(", name=");
		builder.append(name);
		builder.append(", nameOnInvoice=");
		builder.append(nameOnInvoice);
		builder.append(", address1=");
		builder.append(address1);
		builder.append(", address2=");
		builder.append(address2);
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
		builder.append(", villageId=");
		builder.append(villageId);
		builder.append(", villageName=");
		builder.append(villageName);
		builder.append(", countryId=");
		builder.append(countryId);
		builder.append(", countryName=");
		builder.append(countryName);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", mobilePhone=");
		builder.append(mobilePhone);
		builder.append(", fax=");
		builder.append(fax);
		builder.append(", notes=");
		builder.append(notes);
		builder.append(", geolocation=");
		builder.append(geolocation);
		builder.append(", lokasiUsahaId=");
		builder.append(lokasiUsahaId);
		builder.append(", lokasiUsahaName=");
		builder.append(lokasiUsahaName);
		builder.append(", posisiLokasiUsaha=");
		builder.append(posisiLokasiUsaha);
		builder.append(", tipeLokasiUsaha=");
		builder.append(tipeLokasiUsaha);
		builder.append(", tipeLokasiUsahaId=");
		builder.append(tipeLokasiUsahaId);
		builder.append(", tipeLokasiUsahaName=");
		builder.append(tipeLokasiUsahaName);
		builder.append(", jumlahCounter=");
		builder.append(jumlahCounter);
		builder.append(", emailAddressStatetement=");
		builder.append(emailAddressStatetement);
		builder.append(", emailAddressStatetement2=");
		builder.append(emailAddressStatetement2);
		builder.append(", kepemilikan=");
		builder.append(kepemilikan);
		builder.append(", kepemilikanWaktu=");
		builder.append(kepemilikanWaktu);
		builder.append(", kepemilikanNotes=");
		builder.append(kepemilikanNotes);
		builder.append(", lamaUsaha=");
		builder.append(lamaUsaha);
		builder.append(", edcBankLain=");
		builder.append(edcBankLain);
		builder.append(", edcBankLainName1=");
		builder.append(edcBankLainName1);
		builder.append(", edcBankLainName2=");
		builder.append(edcBankLainName2);
		builder.append(", edcBankLainName3=");
		builder.append(edcBankLainName3);
		builder.append(", termurah=");
		builder.append(termurah);
		builder.append(", perTermurah=");
		builder.append(perTermurah);
		builder.append(", termahal=");
		builder.append(termahal);
		builder.append(", perTermahal=");
		builder.append(perTermahal);
		builder.append(", rata2NominalTransaksi=");
		builder.append(rata2NominalTransaksi);
		builder.append(", omsetPerbulan=");
		builder.append(omsetPerbulan);
		builder.append(", frekTransaksi=");
		builder.append(frekTransaksi);
		builder.append(", operasionalStartTime=");
		builder.append(operasionalStartTime);
		builder.append(", operasionalEndTime=");
		builder.append(operasionalEndTime);
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
		builder.append(", ccOtherBankCode=");
		builder.append(ccOtherBankCode);
		builder.append(", ccOtherBankName=");
		builder.append(ccOtherBankName);
		builder.append(", isDebitBca=");
		builder.append(isDebitBca);
		builder.append(", debitBcaAccNo=");
		builder.append(debitBcaAccNo);
		builder.append(", debitBcaAccName=");
		builder.append(debitBcaAccName);
		builder.append(", debitBcaBranch=");
		builder.append(debitBcaBranch);
		builder.append(", flazzBcaAccNo=");
		builder.append(flazzBcaAccNo);
		builder.append(", flazzBcaAccName=");
		builder.append(flazzBcaAccName);
		builder.append(", flazzBcaBranch=");
		builder.append(flazzBcaBranch);
		builder.append(", sakukuBcaAccNo=");
		builder.append(sakukuBcaAccNo);
		builder.append(", sakukuBcaAccName=");
		builder.append(sakukuBcaAccName);
		builder.append(", sakukuBcaBranch=");
		builder.append(sakukuBcaBranch);
		builder.append(", isSplitCredit=");
		builder.append(isSplitCredit);
		builder.append(", isSplitDebit=");
		builder.append(isSplitDebit);
		builder.append(", tglSelesaiPameran=");
		builder.append(tglSelesaiPameran);
		builder.append(", ecommWebUrl=");
		builder.append(ecommWebUrl);
		builder.append(", ecommCallbackUrl=");
		builder.append(ecommCallbackUrl);
		builder.append(", ecommBackendUrl=");
		builder.append(ecommBackendUrl);
		builder.append(", ecommAmount3Dsecure=");
		builder.append(ecommAmount3Dsecure);
		builder.append(", ecomm3Dsecure=");
		builder.append(ecomm3Dsecure);
		builder.append(", ecommIntegration=");
		builder.append(ecommIntegration);
		builder.append(", ecommIntegrationReturnUrl=");
		builder.append(ecommIntegrationReturnUrl);
		builder.append(", ecommIntegrationBackendUrl=");
		builder.append(ecommIntegrationBackendUrl);
		builder.append(", ecommApps=");
		builder.append(ecommApps);
		builder.append(", ecommFraud=");
		builder.append(ecommFraud);
		builder.append(", ecommFraudPspName=");
		builder.append(ecommFraudPspName);
		builder.append(", ecommInventoryMngmt=");
		builder.append(ecommInventoryMngmt);
		builder.append(", ecommSuperAdminName=");
		builder.append(ecommSuperAdminName);
		builder.append(", ecommSuperAdminPhone=");
		builder.append(ecommSuperAdminPhone);
		builder.append(", ecommSuperAdminEmail=");
		builder.append(ecommSuperAdminEmail);
		builder.append(", ecommKeyReceiverName=");
		builder.append(ecommKeyReceiverName);
		builder.append(", ecommKeyReceiverPhone=");
		builder.append(ecommKeyReceiverPhone);
		builder.append(", ecommKeyReceiverEmail=");
		builder.append(ecommKeyReceiverEmail);
		builder.append(", ecommPassReceiverName=");
		builder.append(ecommPassReceiverName);
		builder.append(", ecommPassReceiverPhone=");
		builder.append(ecommPassReceiverPhone);
		builder.append(", ecommPassReceiverEmail=");
		builder.append(ecommPassReceiverEmail);
		builder.append(", ecommBchName=");
		builder.append(ecommBchName);
		builder.append(", ecommBchPhone=");
		builder.append(ecommBchPhone);
		builder.append(", ecommBchEmail=");
		builder.append(ecommBchEmail);
		builder.append(", ecommPmName=");
		builder.append(ecommPmName);
		builder.append(", ecommPmPhone=");
		builder.append(ecommPmPhone);
		builder.append(", ecommPmEmail=");
		builder.append(ecommPmEmail);
		builder.append(", ecommFraudhandlingName=");
		builder.append(ecommFraudhandlingName);
		builder.append(", ecommFraudhandlingPhone=");
		builder.append(ecommFraudhandlingPhone);
		builder.append(", ecommFraudhandlingEmail=");
		builder.append(ecommFraudhandlingEmail);
		builder.append(", ecommKlikpayCabang=");
		builder.append(ecommKlikpayCabang);
		builder.append(", ecommKlikpayCode=");
		builder.append(ecommKlikpayCode);
		builder.append(", ecommKlikpayCcodeDc23=");
		builder.append(ecommKlikpayCcodeDc23);
		builder.append(", ecommKlikpayName=");
		builder.append(ecommKlikpayName);
		builder.append(", ecommMutationName=");
		builder.append(ecommMutationName);
		builder.append(", ecommTrxMinFullPayment=");
		builder.append(ecommTrxMinFullPayment);
		builder.append(", ecommTrxMaxFullPayment=");
		builder.append(ecommTrxMaxFullPayment);
		builder.append(", ecommTrxMinCicilan=");
		builder.append(ecommTrxMinCicilan);
		builder.append(", ecommTrxMaxCicilan=");
		builder.append(ecommTrxMaxCicilan);
		builder.append(", tglBerdiri=");
		builder.append(tglBerdiri);
		builder.append(", mposPic=");
		builder.append(mposPic);
		builder.append(", mposJabatan=");
		builder.append(mposJabatan);
		builder.append(", mposPhone=");
		builder.append(mposPhone);
		builder.append(", mposMobilePhone=");
		builder.append(mposMobilePhone);
		builder.append(", mposEmailUserId=");
		builder.append(mposEmailUserId);
		builder.append(", mposEmailPassword=");
		builder.append(mposEmailPassword);
		builder.append(", picName=");
		builder.append(picName);
		builder.append(", picPhone=");
		builder.append(picPhone);
		builder.append(", picEmail=");
		builder.append(picEmail);
		builder.append(", agentBankCode=");
		builder.append(agentBankCode);
		builder.append(", cabangCode=");
		builder.append(cabangCode);
		builder.append(", dateOpen=");
		builder.append(dateOpen);
		builder.append(", lastMntDate=");
		builder.append(lastMntDate);
		builder.append(", merchantId=");
		builder.append(merchantId);
		builder.append(", mccId=");
		builder.append(mccId);
		builder.append(", bcaMerchantTypeId=");
		builder.append(bcaMerchantTypeId);
		builder.append(", isMagenta=");
		builder.append(isMagenta);
		builder.append(", address1Invoice=");
		builder.append(address1Invoice);
		builder.append(", address2Invoice=");
		builder.append(address2Invoice);
		builder.append(", jenisOutlet=");
		builder.append(jenisOutlet);
		builder.append(", lokasiUsahaCode=");
		builder.append(lokasiUsahaCode);
		builder.append(", tglPasang=");
		builder.append(tglPasang);
		builder.append(", tglTarik=");
		builder.append(tglTarik);
		builder.append(", agentBankId=");
		builder.append(agentBankId);
		builder.append(", agentBankName=");
		builder.append(agentBankName);
		builder.append(", cabangBankId=");
		builder.append(cabangBankId);
		builder.append(", cabangBankCode=");
		builder.append(cabangBankCode);
		builder.append(", cabangBankName=");
		builder.append(cabangBankName);
		builder.append(", cabangPemasanganId=");
		builder.append(cabangPemasanganId);
		builder.append(", cabangPemasanganCode=");
		builder.append(cabangPemasanganCode);
		builder.append(", cabangPemasanganName=");
		builder.append(cabangPemasanganName);
		builder.append(", ecommType=");
		builder.append(ecommType);
		builder.append(", ecommTrxMaxKlikpay=");
		builder.append(ecommTrxMaxKlikpay);
		builder.append(", ecommTrxMinKlikpay=");
		builder.append(ecommTrxMinKlikpay);
		builder.append(", readerOnly=");
		builder.append(readerOnly);
		builder.append(", mccName=");
		builder.append(mccName);
		builder.append(", rata2PenjualanPerbulan=");
		builder.append(rata2PenjualanPerbulan);
		builder.append(", ecommReturnUrl=");
		builder.append(ecommReturnUrl);
		builder.append(", ecommFasilitas=");
		builder.append(ecommFasilitas);
		builder.append(", ecommMinimumAmmount=");
		builder.append(ecommMinimumAmmount);
		builder.append(", lokasiUsaha=");
		builder.append(lokasiUsaha);
		builder.append(", posisiLokasiUsahaId=");
		builder.append(posisiLokasiUsahaId);
		builder.append(", statusKepemilikan=");
		builder.append(statusKepemilikan);
		builder.append(", statusKepemilikanId=");
		builder.append(statusKepemilikanId);
		builder.append(", merchantSettleId=");
		builder.append(merchantSettleId);
		builder.append(", merchantSettleCode=");
		builder.append(merchantSettleCode);
		builder.append(", merchantSettleName=");
		builder.append(merchantSettleName);
		builder.append(", isSameAddress=");
		builder.append(isSameAddress);
		builder.append(", otherAddress1=");
		builder.append(otherAddress1);
		builder.append(", otherAddress2=");
		builder.append(otherAddress2);
		builder.append(", villageIdPemasangan=");
		builder.append(villageIdPemasangan);
		builder.append(", villageNamePemasangan=");
		builder.append(villageNamePemasangan);
		builder.append(", postalIdPemasangan=");
		builder.append(postalIdPemasangan);
		builder.append(", postalCodePemasangan=");
		builder.append(postalCodePemasangan);
		builder.append(", regencyIdPemasangan=");
		builder.append(regencyIdPemasangan);
		builder.append(", regencyNamePemasangan=");
		builder.append(regencyNamePemasangan);
		builder.append(", provinceIdPemasangan=");
		builder.append(provinceIdPemasangan);
		builder.append(", provinceNamePemasangan=");
		builder.append(provinceNamePemasangan);
		builder.append(", countryIdPemasangan=");
		builder.append(countryIdPemasangan);
		builder.append(", countryNamePemasangan=");
		builder.append(countryNamePemasangan);
		builder.append(", subdistrictIdPemasangan=");
		builder.append(subdistrictIdPemasangan);
		builder.append(", subdistrictNamePemasangan=");
		builder.append(subdistrictNamePemasangan);
		builder.append(", isSameParentFacility=");
		builder.append(isSameParentFacility);
		builder.append(", isAddressPengiriman=");
		builder.append(isAddressPengiriman);
		builder.append(", address1Pengiriman=");
		builder.append(address1Pengiriman);
		builder.append(", address2Pengiriman=");
		builder.append(address2Pengiriman);
		builder.append(", villageIdPengiriman=");
		builder.append(villageIdPengiriman);
		builder.append(", villageNamePengiriman=");
		builder.append(villageNamePengiriman);
		builder.append(", postalIdPengiriman=");
		builder.append(postalIdPengiriman);
		builder.append(", postalCodePengiriman=");
		builder.append(postalCodePengiriman);
		builder.append(", regencyIdPengiriman=");
		builder.append(regencyIdPengiriman);
		builder.append(", regencyNamePengiriman=");
		builder.append(regencyNamePengiriman);
		builder.append(", provinceIdPengiriman=");
		builder.append(provinceIdPengiriman);
		builder.append(", provinceNamePengiriman=");
		builder.append(provinceNamePengiriman);
		builder.append(", countryIdPengiriman=");
		builder.append(countryIdPengiriman);
		builder.append(", countryNamePengiriman=");
		builder.append(countryNamePengiriman);
		builder.append(", isAddressPenarikan=");
		builder.append(isAddressPenarikan);
		builder.append(", address1Penarikan=");
		builder.append(address1Penarikan);
		builder.append(", Address2Penarikan=");
		builder.append(Address2Penarikan);
		builder.append(", villageIdPenarikan=");
		builder.append(villageIdPenarikan);
		builder.append(", villageNamePenarikan=");
		builder.append(villageNamePenarikan);
		builder.append(", postalIdPenarikan=");
		builder.append(postalIdPenarikan);
		builder.append(", postalCodePenarikan=");
		builder.append(postalCodePenarikan);
		builder.append(", regencyIdPenarikan=");
		builder.append(regencyIdPenarikan);
		builder.append(", regencyNamePenarikan=");
		builder.append(regencyNamePenarikan);
		builder.append(", provinceIdPenarikan=");
		builder.append(provinceIdPenarikan);
		builder.append(", provinceNamePenarikan=");
		builder.append(provinceNamePenarikan);
		builder.append(", countryIdPenarikan=");
		builder.append(countryIdPenarikan);
		builder.append(", countryNamePenarikan=");
		builder.append(countryNamePenarikan);
		builder.append(", isOutlet=");
		builder.append(isOutlet);
		builder.append(", subdistrictIdPengiriman=");
		builder.append(subdistrictIdPengiriman);
		builder.append(", subdistrictNamePengiriman=");
		builder.append(subdistrictNamePengiriman);
		builder.append(", subdistrictIdPenarikan=");
		builder.append(subdistrictIdPenarikan);
		builder.append(", subdistrictNamePenarikan=");
		builder.append(subdistrictNamePenarikan);
		builder.append(", namaPameran=");
		builder.append(namaPameran);
		builder.append(", mccCode=");
		builder.append(mccCode);
		builder.append(", memo=");
		builder.append(memo);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
}
