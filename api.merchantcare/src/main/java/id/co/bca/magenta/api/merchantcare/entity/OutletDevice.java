package id.co.bca.magenta.api.merchantcare.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OutletDevice {
	private Integer id;
	private String productId;
	private String serialNumber;
	private Integer deviceStatusId;
	private Integer outletId;
	private Integer deviceTypeId;
	private Integer deviceConnectionTypeId;
	private BigDecimal biayaSewa;
	private Date tglTarik;
	private Date lastJo;
	private Date lastInit;
	private Date lastPasang;
	private String requestId;
	private String statusOnFdm;
	private String status;
	private String keterangan;
	private String deviceTypeName;
	private String deviceConnectionTypeName;
	private Boolean isSameParentFacility;
	private String terminalInit;
    private Integer deviceMachineId;
    private String deviceMachineName;
	private Boolean isActiveRequest;
    private String messageActiveRequest;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Integer getDeviceStatusId() {
		return deviceStatusId;
	}
	public void setDeviceStatusId(Integer deviceStatusId) {
		this.deviceStatusId = deviceStatusId;
	}
	public Integer getOutletId() {
		return outletId;
	}
	public void setOutletId(Integer outletId) {
		this.outletId = outletId;
	}
	public Integer getDeviceTypeId() {
		return deviceTypeId;
	}
	public void setDeviceTypeId(Integer deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}
	public Integer getDeviceConnectionTypeId() {
		return deviceConnectionTypeId;
	}
	public void setDeviceConnectionTypeId(Integer deviceConnectionTypeId) {
		this.deviceConnectionTypeId = deviceConnectionTypeId;
	}
	public BigDecimal getBiayaSewa() {
		return biayaSewa;
	}
	public void setBiayaSewa(BigDecimal biayaSewa) {
		this.biayaSewa = biayaSewa;
	}
	public Date getTglTarik() {
		return tglTarik;
	}
	public void setTglTarik(Date tglTarik) {
		this.tglTarik = tglTarik;
	}
	public Date getLastJo() {
		return lastJo;
	}
	public void setLastJo(Date lastJo) {
		this.lastJo = lastJo;
	}
	public Date getLastInit() {
		return lastInit;
	}
	public void setLastInit(Date lastInit) {
		this.lastInit = lastInit;
	}
	public Date getLastPasang() {
		return lastPasang;
	}
	public void setLastPasang(Date lastPasang) {
		this.lastPasang = lastPasang;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getStatusOnFdm() {
		return statusOnFdm;
	}
	public void setStatusOnFdm(String statusOnFdm) {
		this.statusOnFdm = statusOnFdm;
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
	public String getDeviceTypeName() {
		return deviceTypeName;
	}
	public void setDeviceTypeName(String deviceTypeName) {
		this.deviceTypeName = deviceTypeName;
	}
	public String getDeviceConnectionTypeName() {
		return deviceConnectionTypeName;
	}
	public void setDeviceConnectionTypeName(String deviceConnectionTypeName) {
		this.deviceConnectionTypeName = deviceConnectionTypeName;
	}
	public Boolean getIsSameParentFacility() {
		return isSameParentFacility;
	}
	public void setIsSameParentFacility(Boolean isSameParentFacility) {
		this.isSameParentFacility = isSameParentFacility;
	}
	public String getTerminalInit() {
		return terminalInit;
	}
	public void setTerminalInit(String terminalInit) {
		this.terminalInit = terminalInit;
	}
	public Integer getDeviceMachineId() {
		return deviceMachineId;
	}
	public void setDeviceMachineId(Integer deviceMachineId) {
		this.deviceMachineId = deviceMachineId;
	}
	public String getDeviceMachineName() {
		return deviceMachineName;
	}
	public void setDeviceMachineName(String deviceMachineName) {
		this.deviceMachineName = deviceMachineName;
	}
	public Boolean getIsActiveRequest() {
		return isActiveRequest;
	}
	public void setIsActiveRequest(Boolean isActiveRequest) {
		this.isActiveRequest = isActiveRequest;
	}
	public String getMessageActiveRequest() {
		return messageActiveRequest;
	}
	public void setMessageActiveRequest(String messageActiveRequest) {
		this.messageActiveRequest = messageActiveRequest;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OutletDevice [id=");
		builder.append(id);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", serialNumber=");
		builder.append(serialNumber);
		builder.append(", deviceStatusId=");
		builder.append(deviceStatusId);
		builder.append(", outletId=");
		builder.append(outletId);
		builder.append(", deviceTypeId=");
		builder.append(deviceTypeId);
		builder.append(", deviceConnectionTypeId=");
		builder.append(deviceConnectionTypeId);
		builder.append(", biayaSewa=");
		builder.append(biayaSewa);
		builder.append(", tglTarik=");
		builder.append(tglTarik);
		builder.append(", lastJo=");
		builder.append(lastJo);
		builder.append(", lastInit=");
		builder.append(lastInit);
		builder.append(", lastPasang=");
		builder.append(lastPasang);
		builder.append(", requestId=");
		builder.append(requestId);
		builder.append(", statusOnFdm=");
		builder.append(statusOnFdm);
		builder.append(", status=");
		builder.append(status);
		builder.append(", keterangan=");
		builder.append(keterangan);
		builder.append(", deviceTypeName=");
		builder.append(deviceTypeName);
		builder.append(", deviceConnectionTypeName=");
		builder.append(deviceConnectionTypeName);
		builder.append(", isSameParentFacility=");
		builder.append(isSameParentFacility);
		builder.append(", terminalInit=");
		builder.append(terminalInit);
		builder.append(", deviceMachineId=");
		builder.append(deviceMachineId);
		builder.append(", deviceMachineName=");
		builder.append(deviceMachineName);
		builder.append(", isActiveRequest=");
		builder.append(isActiveRequest);
		builder.append(", messageActiveRequest=");
		builder.append(messageActiveRequest);
		builder.append("]");
		return builder.toString();
	}
}
