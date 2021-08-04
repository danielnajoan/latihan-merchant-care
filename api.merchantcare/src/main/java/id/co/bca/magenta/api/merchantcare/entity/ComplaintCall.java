package id.co.bca.magenta.api.merchantcare.entity;

import java.lang.reflect.Field;

import org.apache.commons.lang3.ArrayUtils;

import id.co.bca.magenta.api.merchantcare.util.Criteria;

public class ComplaintCall {
	private String callID;
	private String contactMethod;
	private String event;
	private String merchantPIC;
	private String contactNo;
	private String status;
	private String merchantID;
	private String mID;
	private String merchantName;
	private String alamatUsaha;
	private String alamatUsaha2;
	private String city;
	private String kodePos;
	private String phone;
	private String fax;
	private String namaPemilik;
	private String telpPemilik;
	private String hpPemilik;
	private String faxPemilik;
	private String emailAddressStatement;
	private String emailAddress;
	private String agentBankID;
	private String agentBankName;
	private String kcuID;
	private String kcuName;
	private String kartuDebetBankLainAtasNama;
	private String kartuKreditBankLainAtasNama;
	private String kartuDebetAccNo;
	private String kartuKreditAccNo;
	private String createDate;
	private String createBy;
	private String createTerminal;
	private String updateDate;
	private String updateBy;
	private String updateTerminal;
	private String alamatSaatIni;
	private String kodePosSaatIni;
	private String agentBankSaatIni;
	private String kecamatan;
	private String kelurahan;
	private String pejabatBerwenang1;
	private String pejabatBerwenang2;
	public String getCallID() {
		return callID;
	}
	public void setCallID(String callID) {
		this.callID = callID;
	}
	public String getContactMethod() {
		return contactMethod;
	}
	public void setContactMethod(String contactMethod) {
		this.contactMethod = contactMethod;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getMerchantPIC() {
		return merchantPIC;
	}
	public void setMerchantPIC(String merchantPIC) {
		this.merchantPIC = merchantPIC;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getAlamatUsaha() {
		return alamatUsaha;
	}
	public void setAlamatUsaha(String alamatUsaha) {
		this.alamatUsaha = alamatUsaha;
	}
	public String getAlamatUsaha2() {
		return alamatUsaha2;
	}
	public void setAlamatUsaha2(String alamatUsaha2) {
		this.alamatUsaha2 = alamatUsaha2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getKodePos() {
		return kodePos;
	}
	public void setKodePos(String kodePos) {
		this.kodePos = kodePos;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
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
	public String getHpPemilik() {
		return hpPemilik;
	}
	public void setHpPemilik(String hpPemilik) {
		this.hpPemilik = hpPemilik;
	}
	public String getFaxPemilik() {
		return faxPemilik;
	}
	public void setFaxPemilik(String faxPemilik) {
		this.faxPemilik = faxPemilik;
	}
	public String getEmailAddressStatement() {
		return emailAddressStatement;
	}
	public void setEmailAddressStatement(String emailAddressStatement) {
		this.emailAddressStatement = emailAddressStatement;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getAgentBankID() {
		return agentBankID;
	}
	public void setAgentBankID(String agentBankID) {
		this.agentBankID = agentBankID;
	}
	public String getAgentBankName() {
		return agentBankName;
	}
	public void setAgentBankName(String agentBankName) {
		this.agentBankName = agentBankName;
	}
	public String getKcuID() {
		return kcuID;
	}
	public void setKcuID(String kcuID) {
		this.kcuID = kcuID;
	}
	public String getKcuName() {
		return kcuName;
	}
	public void setKcuName(String kcuName) {
		this.kcuName = kcuName;
	}
	public String getKartuDebetBankLainAtasNama() {
		return kartuDebetBankLainAtasNama;
	}
	public void setKartuDebetBankLainAtasNama(String kartuDebetBankLainAtasNama) {
		this.kartuDebetBankLainAtasNama = kartuDebetBankLainAtasNama;
	}
	public String getKartuKreditBankLainAtasNama() {
		return kartuKreditBankLainAtasNama;
	}
	public void setKartuKreditBankLainAtasNama(String kartuKreditBankLainAtasNama) {
		this.kartuKreditBankLainAtasNama = kartuKreditBankLainAtasNama;
	}
	public String getKartuDebetAccNo() {
		return kartuDebetAccNo;
	}
	public void setKartuDebetAccNo(String kartuDebetAccNo) {
		this.kartuDebetAccNo = kartuDebetAccNo;
	}
	public String getKartuKreditAccNo() {
		return kartuKreditAccNo;
	}
	public void setKartuKreditAccNo(String kartuKreditAccNo) {
		this.kartuKreditAccNo = kartuKreditAccNo;
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
	public String getAgentBankSaatIni() {
		return agentBankSaatIni;
	}
	public void setAgentBankSaatIni(String agentBankSaatIni) {
		this.agentBankSaatIni = agentBankSaatIni;
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
		builder.append("ComplaintCall [callID=");
		builder.append(callID);
		builder.append(", contactMethod=");
		builder.append(contactMethod);
		builder.append(", event=");
		builder.append(event);
		builder.append(", merchantPIC=");
		builder.append(merchantPIC);
		builder.append(", contactNo=");
		builder.append(contactNo);
		builder.append(", status=");
		builder.append(status);
		builder.append(", merchantID=");
		builder.append(merchantID);
		builder.append(", mID=");
		builder.append(mID);
		builder.append(", merchantName=");
		builder.append(merchantName);
		builder.append(", alamatUsaha=");
		builder.append(alamatUsaha);
		builder.append(", alamatUsaha2=");
		builder.append(alamatUsaha2);
		builder.append(", city=");
		builder.append(city);
		builder.append(", kodePos=");
		builder.append(kodePos);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", fax=");
		builder.append(fax);
		builder.append(", namaPemilik=");
		builder.append(namaPemilik);
		builder.append(", telpPemilik=");
		builder.append(telpPemilik);
		builder.append(", hpPemilik=");
		builder.append(hpPemilik);
		builder.append(", faxPemilik=");
		builder.append(faxPemilik);
		builder.append(", emailAddressStatement=");
		builder.append(emailAddressStatement);
		builder.append(", emailAddress=");
		builder.append(emailAddress);
		builder.append(", agentBankID=");
		builder.append(agentBankID);
		builder.append(", agentBankName=");
		builder.append(agentBankName);
		builder.append(", kcuID=");
		builder.append(kcuID);
		builder.append(", kcuName=");
		builder.append(kcuName);
		builder.append(", kartuDebetBankLainAtasNama=");
		builder.append(kartuDebetBankLainAtasNama);
		builder.append(", kartuKreditBankLainAtasNama=");
		builder.append(kartuKreditBankLainAtasNama);
		builder.append(", kartuDebetAccNo=");
		builder.append(kartuDebetAccNo);
		builder.append(", kartuKreditAccNo=");
		builder.append(kartuKreditAccNo);
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
		builder.append(", alamatSaatIni=");
		builder.append(alamatSaatIni);
		builder.append(", kodePosSaatIni=");
		builder.append(kodePosSaatIni);
		builder.append(", agentBankSaatIni=");
		builder.append(agentBankSaatIni);
		builder.append(", kecamatan=");
		builder.append(kecamatan);
		builder.append(", kelurahan=");
		builder.append(kelurahan);
		builder.append(", pejabatBerwanang1=");
		builder.append(pejabatBerwenang1);
		builder.append(", pejabatBerwenang2=");
		builder.append(pejabatBerwenang2);
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
