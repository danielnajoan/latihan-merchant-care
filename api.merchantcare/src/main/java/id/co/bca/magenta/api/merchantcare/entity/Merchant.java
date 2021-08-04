package id.co.bca.magenta.api.merchantcare.entity;

public class Merchant {
	private String id;
	private String MID;
	private String MerchantName;
	private String MerchantStatus;
	private String MerchantAddress1;
	private String MerchantAddress2;
	private String City;
	private String PostalCode;
	private String Phone;
	private String Fax;
	private String NamaPemilik;
	private String TelpPemilik;
	private String HpPemilik;
	private String FaxPemilik;
	private String EmailAddressStatement;
	private String EmailAddress;
	private String AgentBank_ID;
	private String AgentBankName;
	private String KCUID;
	private String KCUName;
	private String KartuDebetBankLainAtasNama;
	private String KartuKreditBankLainAtasNama;
	private String KartuDebetAccNo;
	private String KartuKreditAccNo;
	private Integer totalCount;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMID() {
		return MID;
	}
	public void setMID(String mID) {
		MID = mID;
	}
	public String getMerchantName() {
		return MerchantName;
	}
	public void setMerchantName(String merchantName) {
		MerchantName = merchantName;
	}
	public String getMerchantStatus() {
		return MerchantStatus;
	}
	public void setMerchantStatus(String merchantStatus) {
		MerchantStatus = merchantStatus;
	}
	public String getMerchantAddress1() {
		return MerchantAddress1;
	}
	public void setMerchantAddress1(String merchantAddress1) {
		MerchantAddress1 = merchantAddress1;
	}
	public String getMerchantAddress2() {
		return MerchantAddress2;
	}
	public void setMerchantAddress2(String merchantAddress2) {
		MerchantAddress2 = merchantAddress2;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getFax() {
		return Fax;
	}
	public void setFax(String fax) {
		Fax = fax;
	}
	public String getNamaPemilik() {
		return NamaPemilik;
	}
	public void setNamaPemilik(String namaPemilik) {
		NamaPemilik = namaPemilik;
	}
	public String getTelpPemilik() {
		return TelpPemilik;
	}
	public void setTelpPemilik(String telpPemilik) {
		TelpPemilik = telpPemilik;
	}
	public String getHpPemilik() {
		return HpPemilik;
	}
	public void setHpPemilik(String hpPemilik) {
		HpPemilik = hpPemilik;
	}
	public String getFaxPemilik() {
		return FaxPemilik;
	}
	public void setFaxPemilik(String faxPemilik) {
		FaxPemilik = faxPemilik;
	}
	public String getEmailAddressStatement() {
		return EmailAddressStatement;
	}
	public void setEmailAddressStatement(String emailAddressStatement) {
		EmailAddressStatement = emailAddressStatement;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	public String getAgentBank_ID() {
		return AgentBank_ID;
	}
	public void setAgentBank_ID(String agentBank_ID) {
		AgentBank_ID = agentBank_ID;
	}
	public String getAgentBankName() {
		return AgentBankName;
	}
	public void setAgentBankName(String agentBankName) {
		AgentBankName = agentBankName;
	}
	public String getKCUID() {
		return KCUID;
	}
	public void setKCUID(String kCUID) {
		KCUID = kCUID;
	}
	public String getKCUName() {
		return KCUName;
	}
	public void setKCUName(String kCUName) {
		KCUName = kCUName;
	}
	public String getKartuDebetBankLainAtasNama() {
		return KartuDebetBankLainAtasNama;
	}
	public void setKartuDebetBankLainAtasNama(String kartuDebetBankLainAtasNama) {
		KartuDebetBankLainAtasNama = kartuDebetBankLainAtasNama;
	}
	public String getKartuKreditBankLainAtasNama() {
		return KartuKreditBankLainAtasNama;
	}
	public void setKartuKreditBankLainAtasNama(String kartuKreditBankLainAtasNama) {
		KartuKreditBankLainAtasNama = kartuKreditBankLainAtasNama;
	}
	public String getKartuDebetAccNo() {
		return KartuDebetAccNo;
	}
	public void setKartuDebetAccNo(String kartuDebetAccNo) {
		KartuDebetAccNo = kartuDebetAccNo;
	}
	public String getKartuKreditAccNo() {
		return KartuKreditAccNo;
	}
	public void setKartuKreditAccNo(String kartuKreditAccNo) {
		KartuKreditAccNo = kartuKreditAccNo;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Merchant [id=");
		builder.append(id);
		builder.append(", MID=");
		builder.append(MID);
		builder.append(", MerchantName=");
		builder.append(MerchantName);
		builder.append(", MerchantStatus=");
		builder.append(MerchantStatus);
		builder.append(", MerchantAddress1=");
		builder.append(MerchantAddress1);
		builder.append(", MerchantAddress2=");
		builder.append(MerchantAddress2);
		builder.append(", City=");
		builder.append(City);
		builder.append(", PostalCode=");
		builder.append(PostalCode);
		builder.append(", Phone=");
		builder.append(Phone);
		builder.append(", Fax=");
		builder.append(Fax);
		builder.append(", NamaPemilik=");
		builder.append(NamaPemilik);
		builder.append(", TelpPemilik=");
		builder.append(TelpPemilik);
		builder.append(", HpPemilik=");
		builder.append(HpPemilik);
		builder.append(", FaxPemilik=");
		builder.append(FaxPemilik);
		builder.append(", EmailAddressStatement=");
		builder.append(EmailAddressStatement);
		builder.append(", EmailAddress=");
		builder.append(EmailAddress);
		builder.append(", AgentBank_ID=");
		builder.append(AgentBank_ID);
		builder.append(", AgentBankName=");
		builder.append(AgentBankName);
		builder.append(", KCUID=");
		builder.append(KCUID);
		builder.append(", KCUName=");
		builder.append(KCUName);
		builder.append(", KartuDebetBankLainAtasNama=");
		builder.append(KartuDebetBankLainAtasNama);
		builder.append(", KartuKreditBankLainAtasNama=");
		builder.append(KartuKreditBankLainAtasNama);
		builder.append(", KartuDebetAccNo=");
		builder.append(KartuDebetAccNo);
		builder.append(", KartuKreditAccNo=");
		builder.append(KartuKreditAccNo);
		builder.append(", totalCount=");
		builder.append(totalCount);
		builder.append("]");
		return builder.toString();
	}
}
