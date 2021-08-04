package id.co.bca.magenta.api.merchantcare.entity.viewmodel;

public class OutletDetailViewModel {
	private String mid;
	private String name;
	private String merchantCode;
	private String merchantName;
	private String address1;
	private String address2;
	private String village;
	private String postalcode;
	private String subdistrict;
	private String regencyName;
	private String kota;
	private String geolocation;
	private String phone;
	private String mobilePhone;
	private String status;
	private String province;

	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMerchantCode() {
		return merchantCode;
	}
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
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
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getSubdistrict() {
		return subdistrict;
	}
	public void setSubdistrict(String subdistrict) {
		this.subdistrict = subdistrict;
	}
	public String getRegencyName() {
		return regencyName;
	}
	public void setRegencyName(String regencyName) {
		this.regencyName = regencyName;
	}
	public String getKota() {
		return kota;
	}
	public void setKota(String kota) {
		this.kota = kota;
	}
	public String getGeolocation() {
		return geolocation;
	}
	public void setGeolocation(String geolocation) {
		this.geolocation = geolocation;
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
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OutletDetailViewModel [mid=");
		builder.append(mid);
		builder.append(", name=");
		builder.append(name);
		builder.append(", merchantCode=");
		builder.append(merchantCode);
		builder.append(", merchantName=");
		builder.append(merchantName);
		builder.append(", address1=");
		builder.append(address1);
		builder.append(", address2=");
		builder.append(address2);
		builder.append(", village=");
		builder.append(village);
		builder.append(", postalcode=");
		builder.append(postalcode);
		builder.append(", subdistrict=");
		builder.append(subdistrict);
		builder.append(", regencyName=");
		builder.append(regencyName);
		builder.append(", kota=");
		builder.append(kota);
		builder.append(", geolocation=");
		builder.append(geolocation);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", mobilePhone=");
		builder.append(mobilePhone);
		builder.append(", status=");
		builder.append(status);
		builder.append(", province=");
		builder.append(province);
		builder.append("]");
		return builder.toString();
	}
}
