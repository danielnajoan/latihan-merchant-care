package id.co.bca.magenta.api.merchantcare.entity;

public class Pemilik {
	private Integer id;
	private String code;
	private String cis;
	private String name;
	private String jenisNasabah;
	private String segmenNasabah;
	private String accountNo;
	private String accountType;
	private String identityType;
	private String identityNo;
	private String identityImgPath;
	private String pob;
	private String dateDob;  //Date
	private String pjb1Name;
	private String pjb1IdentityType;
	private String pjb1IdentityNo;
	private String pjb1Pob;
	private String pjb1DateOb;  //Date
	private String pjb2Name;
	private String pjb2IdentityType;
	private String pjb2IdentityNo;
	private String pjb2Pob;
	private String pjb2DateOb;  //Date
	private String pengendaliAkhir;
	private String npwp;
	private String npwpImgPath;
	private String address;
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
	private String mobilePhone;
	private String phone;
	private String email;
	private Boolean isRepresented;
	private String penerimaKuasa;
	private String ktpPenerimaKuasa;
	private Boolean isIdentity;
	private Boolean isSiup;
	private Boolean isBapu;
	private Boolean isKtpPenerimaKuasa;
	private Boolean isKuasaPengajuanEdc;
	private Boolean isPjb1IdentityNo;
	private Boolean isAktaPerubahanTerkahir;
	private Boolean isSkmenkeh;
	private Boolean isPengajuanDikuasakan;
	private Boolean isNpwp;
	private String accountOtherBankNo;
	private String accountOtherBankName;
	private String accountOtherBankBankName;
	private String accountOtherBankBankCode;
	private Boolean isAccountBca;

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
	public String getCis() {
		return cis;
	}
	public void setCis(String cis) {
		this.cis = cis;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJenisNasabah() {
		return jenisNasabah;
	}
	public void setJenisNasabah(String jenisNasabah) {
		this.jenisNasabah = jenisNasabah;
	}
	public String getSegmenNasabah() {
		return segmenNasabah;
	}
	public void setSegmenNasabah(String segmenNasabah) {
		this.segmenNasabah = segmenNasabah;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getIdentityType() {
		return identityType;
	}
	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}
	public String getIdentityNo() {
		return identityNo;
	}
	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}
	public String getIdentityImgPath() {
		return identityImgPath;
	}
	public void setIdentityImgPath(String identityImgPath) {
		this.identityImgPath = identityImgPath;
	}
	public String getPob() {
		return pob;
	}
	public void setPob(String pob) {
		this.pob = pob;
	}
	public String getDateDob() {
		return dateDob;
	}
	public void setDateDob(String dateDob) {
		this.dateDob = dateDob;
	}
	public String getPjb1Name() {
		return pjb1Name;
	}
	public void setPjb1Name(String pjb1Name) {
		this.pjb1Name = pjb1Name;
	}
	public String getPjb1IdentityType() {
		return pjb1IdentityType;
	}
	public void setPjb1IdentityType(String pjb1IdentityType) {
		this.pjb1IdentityType = pjb1IdentityType;
	}
	public String getPjb1IdentityNo() {
		return pjb1IdentityNo;
	}
	public void setPjb1IdentityNo(String pjb1IdentityNo) {
		this.pjb1IdentityNo = pjb1IdentityNo;
	}
	public String getPjb1Pob() {
		return pjb1Pob;
	}
	public void setPjb1Pob(String pjb1Pob) {
		this.pjb1Pob = pjb1Pob;
	}
	public String getPjb1DateOb() {
		return pjb1DateOb;
	}
	public void setPjb1DateOb(String pjb1DateOb) {
		this.pjb1DateOb = pjb1DateOb;
	}
	public String getPjb2Name() {
		return pjb2Name;
	}
	public void setPjb2Name(String pjb2Name) {
		this.pjb2Name = pjb2Name;
	}
	public String getPjb2IdentityType() {
		return pjb2IdentityType;
	}
	public void setPjb2IdentityType(String pjb2IdentityType) {
		this.pjb2IdentityType = pjb2IdentityType;
	}
	public String getPjb2IdentityNo() {
		return pjb2IdentityNo;
	}
	public void setPjb2IdentityNo(String pjb2IdentityNo) {
		this.pjb2IdentityNo = pjb2IdentityNo;
	}
	public String getPjb2Pob() {
		return pjb2Pob;
	}
	public void setPjb2Pob(String pjb2Pob) {
		this.pjb2Pob = pjb2Pob;
	}
	public String getPjb2DateOb() {
		return pjb2DateOb;
	}
	public void setPjb2DateOb(String pjb2DateOb) {
		this.pjb2DateOb = pjb2DateOb;
	}
	public String getPengendaliAkhir() {
		return pengendaliAkhir;
	}
	public void setPengendaliAkhir(String pengendaliAkhir) {
		this.pengendaliAkhir = pengendaliAkhir;
	}
	public String getNpwp() {
		return npwp;
	}
	public void setNpwp(String npwp) {
		this.npwp = npwp;
	}
	public String getNpwpImgPath() {
		return npwpImgPath;
	}
	public void setNpwpImgPath(String npwpImgPath) {
		this.npwpImgPath = npwpImgPath;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getIsRepresented() {
		return isRepresented;
	}
	public void setIsRepresented(Boolean isRepresented) {
		this.isRepresented = isRepresented;
	}
	public String getPenerimaKuasa() {
		return penerimaKuasa;
	}
	public void setPenerimaKuasa(String penerimaKuasa) {
		this.penerimaKuasa = penerimaKuasa;
	}
	public String getKtpPenerimaKuasa() {
		return ktpPenerimaKuasa;
	}
	public void setKtpPenerimaKuasa(String ktpPenerimaKuasa) {
		this.ktpPenerimaKuasa = ktpPenerimaKuasa;
	}
	public Boolean getIsIdentity() {
		return isIdentity;
	}
	public void setIsIdentity(Boolean isIdentity) {
		this.isIdentity = isIdentity;
	}
	public Boolean getIsSiup() {
		return isSiup;
	}
	public void setIsSiup(Boolean isSiup) {
		this.isSiup = isSiup;
	}
	public Boolean getIsBapu() {
		return isBapu;
	}
	public void setIsBapu(Boolean isBapu) {
		this.isBapu = isBapu;
	}
	public Boolean getIsKtpPenerimaKuasa() {
		return isKtpPenerimaKuasa;
	}
	public void setIsKtpPenerimaKuasa(Boolean isKtpPenerimaKuasa) {
		this.isKtpPenerimaKuasa = isKtpPenerimaKuasa;
	}
	public Boolean getIsKuasaPengajuanEdc() {
		return isKuasaPengajuanEdc;
	}
	public void setIsKuasaPengajuanEdc(Boolean isKuasaPengajuanEdc) {
		this.isKuasaPengajuanEdc = isKuasaPengajuanEdc;
	}
	public Boolean getIsPjb1IdentityNo() {
		return isPjb1IdentityNo;
	}
	public void setIsPjb1IdentityNo(Boolean isPjb1IdentityNo) {
		this.isPjb1IdentityNo = isPjb1IdentityNo;
	}
	public Boolean getIsAktaPerubahanTerkahir() {
		return isAktaPerubahanTerkahir;
	}
	public void setIsAktaPerubahanTerkahir(Boolean isAktaPerubahanTerkahir) {
		this.isAktaPerubahanTerkahir = isAktaPerubahanTerkahir;
	}
	public Boolean getIsSkmenkeh() {
		return isSkmenkeh;
	}
	public void setIsSkmenkeh(Boolean isSkmenkeh) {
		this.isSkmenkeh = isSkmenkeh;
	}
	public Boolean getIsPengajuanDikuasakan() {
		return isPengajuanDikuasakan;
	}
	public void setIsPengajuanDikuasakan(Boolean isPengajuanDikuasakan) {
		this.isPengajuanDikuasakan = isPengajuanDikuasakan;
	}
	public Boolean getIsNpwp() {
		return isNpwp;
	}
	public void setIsNpwp(Boolean isNpwp) {
		this.isNpwp = isNpwp;
	}
	public String getAccountOtherBankNo() {
		return accountOtherBankNo;
	}
	public void setAccountOtherBankNo(String accountOtherBankNo) {
		this.accountOtherBankNo = accountOtherBankNo;
	}
	public String getAccountOtherBankName() {
		return accountOtherBankName;
	}
	public void setAccountOtherBankName(String accountOtherBankName) {
		this.accountOtherBankName = accountOtherBankName;
	}
	public String getAccountOtherBankBankName() {
		return accountOtherBankBankName;
	}
	public void setAccountOtherBankBankName(String accountOtherBankBankName) {
		this.accountOtherBankBankName = accountOtherBankBankName;
	}
	public String getAccountOtherBankBankCode() {
		return accountOtherBankBankCode;
	}
	public void setAccountOtherBankBankCode(String accountOtherBankBankCode) {
		this.accountOtherBankBankCode = accountOtherBankBankCode;
	}
	public Boolean getIsAccountBca() {
		return isAccountBca;
	}
	public void setIsAccountBca(Boolean isAccountBca) {
		this.isAccountBca = isAccountBca;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pemilik [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append(", cis=");
		builder.append(cis);
		builder.append(", name=");
		builder.append(name);
		builder.append(", jenisNasabah=");
		builder.append(jenisNasabah);
		builder.append(", segmenNasabah=");
		builder.append(segmenNasabah);
		builder.append(", accountNo=");
		builder.append(accountNo);
		builder.append(", accountType=");
		builder.append(accountType);
		builder.append(", identityType=");
		builder.append(identityType);
		builder.append(", identityNo=");
		builder.append(identityNo);
		builder.append(", identityImgPath=");
		builder.append(identityImgPath);
		builder.append(", pob=");
		builder.append(pob);
		builder.append(", dateDob=");
		builder.append(dateDob);
		builder.append(", pjb1Name=");
		builder.append(pjb1Name);
		builder.append(", pjb1IdentityType=");
		builder.append(pjb1IdentityType);
		builder.append(", pjb1IdentityNo=");
		builder.append(pjb1IdentityNo);
		builder.append(", pjb1Pob=");
		builder.append(pjb1Pob);
		builder.append(", pjb1DateOb=");
		builder.append(pjb1DateOb);
		builder.append(", pjb2Name=");
		builder.append(pjb2Name);
		builder.append(", pjb2IdentityType=");
		builder.append(pjb2IdentityType);
		builder.append(", pjb2IdentityNo=");
		builder.append(pjb2IdentityNo);
		builder.append(", pjb2Pob=");
		builder.append(pjb2Pob);
		builder.append(", pjb2DateOb=");
		builder.append(pjb2DateOb);
		builder.append(", pengendaliAkhir=");
		builder.append(pengendaliAkhir);
		builder.append(", npwp=");
		builder.append(npwp);
		builder.append(", npwpImgPath=");
		builder.append(npwpImgPath);
		builder.append(", address=");
		builder.append(address);
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
		builder.append(", mobilePhone=");
		builder.append(mobilePhone);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", email=");
		builder.append(email);
		builder.append(", isRepresented=");
		builder.append(isRepresented);
		builder.append(", penerimaKuasa=");
		builder.append(penerimaKuasa);
		builder.append(", ktpPenerimaKuasa=");
		builder.append(ktpPenerimaKuasa);
		builder.append(", isIdentity=");
		builder.append(isIdentity);
		builder.append(", isSiup=");
		builder.append(isSiup);
		builder.append(", isBapu=");
		builder.append(isBapu);
		builder.append(", isKtpPenerimaKuasa=");
		builder.append(isKtpPenerimaKuasa);
		builder.append(", isKuasaPengajuanEdc=");
		builder.append(isKuasaPengajuanEdc);
		builder.append(", isPjb1IdentityNo=");
		builder.append(isPjb1IdentityNo);
		builder.append(", isAktaPerubahanTerkahir=");
		builder.append(isAktaPerubahanTerkahir);
		builder.append(", isSkmenkeh=");
		builder.append(isSkmenkeh);
		builder.append(", isPengajuanDikuasakan=");
		builder.append(isPengajuanDikuasakan);
		builder.append(", isNpwp=");
		builder.append(isNpwp);
		builder.append(", accountOtherBankNo=");
		builder.append(accountOtherBankNo);
		builder.append(", accountOtherBankName=");
		builder.append(accountOtherBankName);
		builder.append(", accountOtherBankBankName=");
		builder.append(accountOtherBankBankName);
		builder.append(", accountOtherBankBankCode=");
		builder.append(accountOtherBankBankCode);
		builder.append(", isAccountBca=");
		builder.append(isAccountBca);
		builder.append("]");
		return builder.toString();
	}
}
