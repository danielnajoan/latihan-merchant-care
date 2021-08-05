package id.co.bca.magenta.api.merchantcare.manager.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.TrustStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import id.co.bca.magenta.api.merchantcare.entity.Complaint;
import id.co.bca.magenta.api.merchantcare.entity.ComplaintCall;
import id.co.bca.magenta.api.merchantcare.entity.ComplaintEDC;
import id.co.bca.magenta.api.merchantcare.entity.ComplaintMain;
import id.co.bca.magenta.api.merchantcare.entity.Outlet;
import id.co.bca.magenta.api.merchantcare.entity.OutletDevice;
import id.co.bca.magenta.api.merchantcare.entity.Pemilik;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.ComplaintCreateViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.ComplaintViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.ManagerViewModel;
import id.co.bca.magenta.api.merchantcare.hcp.Utils;
import id.co.bca.magenta.api.merchantcare.manager.ComplaintManager;
import id.co.bca.magenta.api.merchantcare.repository.ComplaintRepository;
import id.co.bca.magenta.api.merchantcare.repository.EDCRepository;
import id.co.bca.magenta.api.merchantcare.repository.MagentaRepository;
import id.co.bca.magenta.api.merchantcare.util.Criteria;
import id.co.bca.magenta.api.merchantcare.util.ErrorDetail;
import id.co.bca.magenta.api.merchantcare.util.SpStatusMsg2;
import id.co.bca.magenta.api.merchantcare.util.StaticVariable;

@Service
public class ComplaintManagerImpl extends ManagerImpl implements ComplaintManager {
	private static final Logger logger = LoggerFactory.getLogger(ComplaintManagerImpl.class);

//	@Autowired
//	@Qualifier("txManagerEmsmh")
//	private PlatformTransactionManager txManagerEmsmh;
	
	@Autowired
	private ComplaintRepository complaintRepository;

	@Autowired
	private EDCRepository edcRepository;

	@Autowired
	private MagentaRepository magentaRepository;

	@Override
	public ManagerViewModel<List<ComplaintViewModel>> findAll(long hashing, 
			int page, int size, String search, String orderby, String baseUrl) {		
		ManagerViewModel<List<ComplaintViewModel>> mvm = new ManagerViewModel<>();

		try {
			List<Complaint> listData = complaintRepository
					.findAll(hashing, page, size, search, orderby);

			if (null != listData && listData.size() > 0) {
				List<ComplaintViewModel> listDataVm = new ArrayList<>();
				for (Complaint item : listData) {
					String complainImgViewUrl = StaticVariable.getProp("complain.image.view.url");
					String requestId = item.getRequestid();
					// http://{baseURL}/api.merchantcare/1.0/file/getImageMerchantCare/{requestId}
					complainImgViewUrl = complainImgViewUrl.replace("{baseURL}", baseUrl);
					complainImgViewUrl = complainImgViewUrl.replace("{requestId}", requestId);
					item.setImage_path(complainImgViewUrl);
					
					ComplaintViewModel vm = new ComplaintViewModel();
					BeanUtils.copyProperties(item, vm);
					listDataVm.add(vm);
				}
				
				mvm.setContent(listDataVm);
				mvm.setTotalrows(listData.get(0).getTotalCount());
				mvm.setInfo(getInfoOk("Success"));
			} else {
				mvm.setTotalrows(0);
				mvm.setInfo(getInfoNoContent());
			}
		} catch (Exception e) {
			String errMsg = StaticVariable.starckTraceToString(e);
			logger.error("("+hashing+") "+"errMsg: "+errMsg);
			
			mvm.setTotalrows(0);
			mvm.setInfo(getInfoConflict(errMsg));
		}

		return mvm;
	}

	@Override
	public ManagerViewModel<ComplaintViewModel> findById(long hashing, String id) {
		ManagerViewModel<ComplaintViewModel> mvm = new ManagerViewModel<>();

		try {
			mvm.setTotalrows(0);
			mvm.setInfo(getInfoNoContent());
			
//			if (isExist(id)) {
				Complaint e = complaintRepository.findById(hashing, id); 
	
				if (null != e && StaticVariable.compareString(e.getRequestid(), id)) {
					ComplaintViewModel vm = new ComplaintViewModel();
					BeanUtils.copyProperties(e, vm);
					
					mvm.setContent(vm);
					mvm.setTotalrows(1);
					mvm.setInfo(getInfoOk("Success"));
				}
//			}
		} catch (Exception e) {
			String errMsg = StaticVariable.starckTraceToString(e);
			logger.error("("+hashing+") "+"errMsg: "+errMsg);
			
			mvm.setTotalrows(0);
			mvm.setInfo(getInfoConflict(errMsg));
		}

		return mvm;
	}

	@Override
	public ManagerViewModel<ComplaintViewModel> findByIdMaskingImagesLocation(long hashing, 
			String id, String baseUrl) {
		ManagerViewModel<ComplaintViewModel> mvm = findById(hashing, id);

		try {
			if (null != mvm && mvm.getTotalrows() > 0 && null != mvm.getContent()) {
				ComplaintViewModel vm = mvm.getContent();
				String complainImgViewUrl = StaticVariable.getProp("complain.image.view.url");
				String requestId = vm.getRequestid();
				// http://{baseURL}/api.merchantcare/1.0/file/getImageMerchantCare/{requestId}
				complainImgViewUrl = complainImgViewUrl.replace("{baseURL}", baseUrl);
				complainImgViewUrl = complainImgViewUrl.replace("{requestId}", requestId);
				vm.setImage_path(complainImgViewUrl);
			}
		} catch (Exception e) {
			String errMsg = StaticVariable.starckTraceToString(e);
			logger.error("("+hashing+") "+"errMsg: "+errMsg);
			
			mvm.setTotalrows(0);
			mvm.setInfo(getInfoConflict(errMsg));
		}

		return mvm;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional("txManagerEmsmh")
	public ManagerViewModel<ErrorDetail> saveToSpV2(long hashing, ComplaintCreateViewModel view) {
		ManagerViewModel<ErrorDetail> mvm = new ManagerViewModel<>();
		
		try {
			if (null != view.getProductid()) {
				//Flow complaint
				Map<String, Object> rtrn = magentaRepository.callSPGetDataByTerminalInit(hashing, view.getProductid());
				List<OutletDevice> outletDevices = (List<OutletDevice>) rtrn.get("O_OUTLET_DEVICE_REC");

				if (null != outletDevices &&  outletDevices.size() > 0) {
					String caseCategoryId = view.getCasecategory_id();
					logger.warn("("+hashing+") "+"caseCategoryId: " + caseCategoryId);
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("isComplaint", "true");
					// Generate COMPLAINTCALL's values
					ComplaintCall complaintCall = genComplaintCallV2(hashing, view, rtrn);
					logger.info("{}",complaintCall);
					params.put(StaticVariable.COMPLAINT_CALL, complaintCall.getQuery());
		
					// Generate COMPLAINTMAIN's values
					ComplaintMain complaintMain = genComplaintMainV2(hashing, view, rtrn);
					logger.info("{}",complaintMain);
					params.put(StaticVariable.COMPLAINT_MAIN, complaintMain.getQuery());

					// Generate COMPLAINTEDC's values
					ComplaintEDC complaintEDC = genComplaintEDCv2(hashing, view, rtrn);
					logger.info("{}",complaintEDC);
					params.put(StaticVariable.COMPLAINT_EDC, complaintEDC.getQuery());

					Map<String, Object> result = complaintRepository.save(hashing, params, caseCategoryId);

					List<SpStatusMsg2> rtrnData = (List<SpStatusMsg2>) result.get(StaticVariable.SP_STATUS_MSG);
					
					if (null != rtrnData && rtrnData.size() > 0) {
						SpStatusMsg2 detailReturn = rtrnData.get(0);

						if (detailReturn.getIsSuccess() != 0) {
							String rtrnMsg = detailReturn.getErrorMessage() + ";" 
									+ detailReturn.getRowAffected() + " row affected";
							
							mvm.setTotalrows(detailReturn.getRowAffected());
							mvm.setInfo(getInfoCreated(rtrnMsg));
							mvm.setContent(getInfoCreated(rtrnMsg));
						} else {
							String errMsg = detailReturn.getErrorMessage();
							logger.warn("("+hashing+") "+errMsg);

							mvm.setTotalrows(0);
							mvm.setInfo(getInfoNotImplemented(errMsg));
							mvm.setContent(getInfoNotImplemented(errMsg));
						}
					} else {
						String errMsg = "Return message is not available!" + ";" + 0 + " row affected";
						logger.warn("("+hashing+") "+errMsg);

						mvm.setTotalrows(0);
						mvm.setInfo(getInfoConflict(errMsg));
						mvm.setContent(getInfoConflict(errMsg));
					}
				} else {
					String warn = "Data Outlet Device with Product ID (Terminal Init) = '" + view.getProductid() 
							+ "' is not available!" + ";" + 0 + " row affected";
					logger.warn("("+hashing+") "+warn);

					mvm.setTotalrows(0);
					mvm.setInfo(getInfoNoContent());
					mvm.setContent(getInfoNoContent());
				}				
			} else {
				//Flow Pengajuan
				String caseCategoryId = view.getCasecategory_id();
				logger.warn("("+hashing+") "+"caseCategoryId: " + caseCategoryId);
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("isComplaint", "false");

				// Generate COMPLAINTCALL's values
				ComplaintCall complaintCall = genComplaintCallV2(hashing, view, null);

				params.put(StaticVariable.COMPLAINT_CALL, complaintCall.getQuery());

				// Generate COMPLAINTMAIN's values
				ComplaintMain complaintMain = genComplaintMainV2(hashing, view, null);
				params.put(StaticVariable.COMPLAINT_MAIN, complaintMain.getQuery());

				// Generate COMPLAINTEDC's values
				ComplaintEDC complaintEDC = genComplaintEDCv2(hashing, view, null);
				params.put(StaticVariable.COMPLAINT_EDC, complaintEDC.getQuery());
				Map<String, Object> result = complaintRepository.save(hashing, params, caseCategoryId);

				List<SpStatusMsg2> rtrnData = (List<SpStatusMsg2>) result.get(StaticVariable.SP_STATUS_MSG);
				if (null != rtrnData && rtrnData.size() > 0) {
					SpStatusMsg2 detailReturn = rtrnData.get(0);

					if (detailReturn.getIsSuccess() != 0) {
						String rtrnMsg = detailReturn.getErrorMessage() + ";" 
								+ detailReturn.getRowAffected() + " row affected";
						
						mvm.setTotalrows(detailReturn.getRowAffected());
						mvm.setInfo(getInfoCreated(rtrnMsg));
						mvm.setContent(getInfoCreated(rtrnMsg));
					} else {
						String errMsg = detailReturn.getErrorMessage();
						logger.warn("("+hashing+") "+errMsg);

						mvm.setTotalrows(0);
						mvm.setInfo(getInfoNotImplemented(errMsg));
						mvm.setContent(getInfoNotImplemented(errMsg));
					}
				} else {
					String errMsg = "Return message is not available!" + ";" + 0 + " row affected";
					logger.warn("("+hashing+") "+errMsg);

					mvm.setTotalrows(0);
					mvm.setInfo(getInfoConflict(errMsg));
					mvm.setContent(getInfoConflict(errMsg));
				}				
			}

		} catch (Exception e) {
			String errMsg = StaticVariable.starckTraceToString(e);
			logger.error("("+hashing+") "+"errMsg: "+errMsg);
			
			mvm.setTotalrows(0);
			mvm.setInfo(getInfoConflict(errMsg));
			mvm.setContent(getInfoConflict(errMsg));
		}

		return mvm;
	}

	@Override
	public boolean isExist(long hashing, String id) {
		return complaintRepository.isExist(hashing, id);
	}

	private ComplaintCall genComplaintCallV2(long hashing, 
			ComplaintCreateViewModel view, Map<String, Object> rtrn) {
		
		Outlet outlet = null;
		Pemilik pemilik = null;
		
		if (rtrn != null) {
			List<Pemilik> pemiliks = (List<Pemilik>) rtrn.get("O_PEMILIK_REC");
			List<Outlet> outlets = (List<Outlet>) rtrn.get("O_OUTLET_REC");

			outlet = outlets.stream().findFirst().orElse(null);
			pemilik = pemiliks.stream().findFirst().orElse(null);			
		}


		ComplaintCall complaintCall = new ComplaintCall();
		complaintCall.setCallID("@tempvarCallID");
		complaintCall.setContactNo(view.getContactno());
		complaintCall.setCreateBy(view.getCreatedby());
		complaintCall.setCreateTerminal(view.getCreatedterminal());
		complaintCall.setUpdateBy(view.getCreatedby());
		complaintCall.setUpdateTerminal(view.getCreatedterminal());
		complaintCall.setMerchantPIC(view.getMerchantpic());
		complaintCall.setStatus("Open");
		complaintCall.setContactMethod("EDCCare");
		logger.info("Checkpoint Method 1");
		logger.info("{}",complaintCall);
		logger.debug("{}",complaintCall);

		if(null != outlet) {
			complaintCall.setAlamatUsaha(outlet.getAddress1());
			complaintCall.setAlamatUsaha2(outlet.getAddress2());
			complaintCall.setCity(outlet.getRegencyName());
			complaintCall.setEmailAddress(outlet.getEmailAddressStatetement());
			complaintCall.setEmailAddressStatement(outlet.getEmailAddressStatetement2());
			complaintCall.setFax(outlet.getFax());
			complaintCall.setKodePos(outlet.getPostalCode());
			complaintCall.setMerchantID(String.valueOf(outlet.getId()));
			complaintCall.setMerchantName(outlet.getName());
			complaintCall.setmID(outlet.getMid());
			complaintCall.setPhone(outlet.getPhone());
			complaintCall.setMerchantName(outlet.getName());
			complaintCall.setEmailAddress(outlet.getEmail());
			complaintCall.setAlamatUsaha(outlet.getAddress1());
			complaintCall.setAlamatUsaha2(outlet.getAddress2());
			complaintCall.setKodePos(outlet.getPostalCode());
			complaintCall.setKecamatan(outlet.getSubdistrictName());
			complaintCall.setKelurahan(outlet.getVillageName());
		} else {
			if (view.getAlamatUsaha1() != null) {
				complaintCall.setAlamatUsaha(view.getAlamatUsaha1());				
			}
			if (view.getAlamatUsaha2() != null) {
				complaintCall.setAlamatUsaha2(view.getAlamatUsaha2());		
			}
			if (view.getKotaKabupaten() != null) {
				complaintCall.setCity(view.getKotaKabupaten());				
			}
			if (view.getKodePos() != null) {
				complaintCall.setKodePos(view.getKodePos());				
			}
			if (view.getNamaMerchant() != null) {
				complaintCall.setMerchantName(view.getNamaMerchant());				
			}
			if (view.getKecamatan() != null) {
				complaintCall.setKecamatan(view.getKecamatan());				
			}
			if (view.getKelurahan() != null) {
				complaintCall.setKelurahan(view.getKelurahan());				
			}

		}

		if(null != pemilik) {
//			complaintCall.setFaxPemilik("");
			complaintCall.setHpPemilik(pemilik.getMobilePhone());
			complaintCall.setNamaPemilik(pemilik.getName());
			complaintCall.setTelpPemilik(pemilik.getPhone());
			complaintCall.setPejabatBerwenang1(pemilik.getPjb1Name());
			complaintCall.setPejabatBerwenang2(pemilik.getPjb2Name());
		} else {
			if (view.getTelpPemilik() != null) {
				complaintCall.setTelpPemilik(view.getTelpPemilik());				
			}
			if (view.getNamaPemilik() != null) {
				complaintCall.setNamaPemilik(view.getNamaPemilik());				
			}
		}
		
		complaintCall.setAlamatSaatIni(view.getAlamatSaatIni());
		complaintCall.setKodePosSaatIni(view.getKodePosSaatIni());
		complaintCall.setAgentBankSaatIni(view.getAgentBankSaatIni());
		complaintCall.setContactMethod(view.getContactMethod());
		logger.info("Checkpoint Method 2");
		logger.info("{}",complaintCall);
		logger.debug("{}",complaintCall);
		return complaintCall;
	}

	private ComplaintMain genComplaintMainV2(long hashing, 
			ComplaintCreateViewModel view, Map<String, Object> rtrn) {
		
		OutletDevice outletDevice = null;
		Pemilik pemilik = null;
		
		if (rtrn != null) {
			List<OutletDevice> outletDevices = (List<OutletDevice>) rtrn.get("O_OUTLET_DEVICE_REC");
			outletDevice = outletDevices.stream().findFirst().orElse(null);			
			
			List<Pemilik> pemiliks = (List<Pemilik>) rtrn.get("O_PEMILIK_REC");
			pemilik = pemiliks.stream().findFirst().orElse(null);	
			
		}


		ComplaintMain complaintMain = new ComplaintMain();
		complaintMain.setRequestID("@tempvarMainID");
		complaintMain.setComplaintCall_id("@tempvarCallID_id");
		complaintMain.setCaseCategory_id(view.getCasecategory_id());
		complaintMain.setJumlahItemKonversi(view.getJumlahItemKonversi());
		complaintMain.setCreateBy(view.getCreatedby());
		complaintMain.setCreateTerminal(view.getCreatedterminal());
		complaintMain.setUpdateBy(view.getCreatedby());
		complaintMain.setUpdateTerminal(view.getCreatedterminal());
		complaintMain.setNotes(view.getNotes());
		// rtrn.setOwner(entity.Owner);
		complaintMain.setUpdateBy(view.getCreatedby());
		complaintMain.setDueDate("@tempvarDueDate");
		complaintMain.setStatus("Assigned");
		complaintMain.setImage_Path(view.getImage_path());
		complaintMain.setSummary(view.getSummary());// sebagai kolom untuk menyimpan
											// visited
//		complaintMain.setInvoicerequestcount(view.getInvoicerequestcount());

		logger.info("Checkpoint Method 3");
		logger.info("{}",complaintMain);
		logger.debug("{}",complaintMain);
		// address
		if(null != outletDevice) {
			complaintMain.setProductID(outletDevice.getTerminalInit());
		}
		
		complaintMain.setJumlahItem(view.getJumlahItem());
		if(StringUtils.isEmpty(view.getSatuan())) {
			complaintMain.setSatuan("Rol");
		} else {
			complaintMain.setSatuan(view.getSatuan());
		}
		
		complaintMain.setNasabah(view.getNasabah());
		complaintMain.setRekeningNasabah(view.getRekeningNasabah());
		
		
		if (null != pemilik) {
			complaintMain.setPejabatBerwenang1(view.getPejabatBerwenang1());
			complaintMain.setPejabatBerwenang2(view.getPejabatBerwenang2());
		} else {
			
			if (view.getPejabatBerwenang1()!= null) {
				complaintMain.setPejabatBerwenang1(view.getPejabatBerwenang1());				
			}else {
				complaintMain.setPejabatBerwenang1(pemilik.getPjb1Name());
				
			}
			
			if (view.getPejabatBerwenang2()!= null) {
				complaintMain.setPejabatBerwenang2(view.getPejabatBerwenang2());
			}else {
				complaintMain.setPejabatBerwenang2(pemilik.getPjb2Name());
			}
		}
		complaintMain.setKanwilLokasiUsaha(view.getKanwilLokasiUsaha());
		complaintMain.setKcuLokasiUsaha(view.getKcuLokasiUsaha());			

		logger.info("Checkpoint Method 4");
		logger.info("{}",complaintMain);
		logger.debug("{}",complaintMain);
		return complaintMain;
	}

	private ComplaintEDC genComplaintEDCv2(long hashing, 
			ComplaintCreateViewModel view, Map<String, Object> rtrn) {
		
		Outlet outlet = null;
		OutletDevice outletDevice = null;

		if (rtrn != null) {
			List<Outlet> outlets = (List<Outlet>) rtrn.get("O_OUTLET_REC");
			List<OutletDevice> outletDevices = (List<OutletDevice>) rtrn.get("O_OUTLET_DEVICE_REC");

			outlet = outlets.stream().findFirst().orElse(null);
			outletDevice = outletDevices.stream().findFirst().orElse(null);			
		}


		ComplaintEDC compalintEDC = new ComplaintEDC();
		compalintEDC.setComplaintMain_Id("@tempvarMainID_id");
//		compalintEDC.setBrandID("");
//		compalintEDC.setBrandName("");
		// rtrn.setCloseBy(view.CloseBy);
		compalintEDC.setCreateBy(view.getCreatedby());
		compalintEDC.setCreateTerminal(view.getCreatedterminal());
		compalintEDC.setUpdateBy(view.getCreatedby());
		compalintEDC.setUpdateTerminal(view.getCreatedterminal());
//		compalintEDC.setEdcID();

//		compalintEDC.setModelID("");
//		compalintEDC.setModelName("");
		compalintEDC.setNotes(view.getNotes());
		compalintEDC.setStatus("Open");			

		logger.info("Checkpoint Method 5");
		logger.info("{}",compalintEDC);
		logger.debug("{}",compalintEDC);
		// rtrn.setVendorMaintenance_id(edc.getStockist_id());
		if(null != outlet) {
			compalintEDC.setMerchantID(String.valueOf(outlet.getId()));
			compalintEDC.setmID(outlet.getMid());
		}
		if(null != outletDevice) {
			compalintEDC.setProductID(outletDevice.getTerminalInit());
			compalintEDC.setSerialID(outletDevice.getSerialNumber());
		}
		

		logger.info("Checkpoint Method 6");
		logger.info("{}",compalintEDC);
		logger.debug("{}",compalintEDC);
		return compalintEDC;
	}

	@Override
	public StreamingResponseBody getComplainImages(long hashing, 
			String id, HttpServletResponse response) {		
		String namespace = StaticVariable.getProp("edccare.hcp.url.namespace");
		if (StringUtils.isNotEmpty(namespace) && !namespace.endsWith("/"))
			namespace = namespace + "/";
		String complaintfolderpath = StaticVariable.getProp("edccare.hcp.url.complaintfolderpath");
		if (StringUtils.isNotEmpty(complaintfolderpath) && !complaintfolderpath.endsWith("/"))
			complaintfolderpath = complaintfolderpath + "/";
		
		String pathImage = "";
		ManagerViewModel<ComplaintViewModel> mvmFindById = findById(hashing, id);
		if (null != mvmFindById && mvmFindById.getTotalrows() > 0 
				&& null != mvmFindById.getContent()) {
			ComplaintViewModel vm = mvmFindById.getContent();
			pathImage = vm.getImage_path();
		}

		if (StringUtils.isNotEmpty(pathImage) && pathImage.startsWith("/"))
			pathImage = StaticVariable.getNLastCharacter(pathImage, (pathImage.length() - 1), "");

		String fullPath = namespace + complaintfolderpath + pathImage;

		String fileName = "";
		String extention = "";
		if (StringUtils.isNotEmpty(fullPath)) {
			int slashCnt = fullPath.lastIndexOf("/");
			if (slashCnt > 0) {
				fileName = fullPath.substring(slashCnt+1);
				int dotCnt = fileName.indexOf(".");
				if (slashCnt > 0) {
					extention = fileName.substring(dotCnt+1);
				}
			}
		}
		
		String auth = "HCP " + Utils.getBase64Value(StaticVariable.getProp("edccare.hcp.url.username")) + ":"
				+ Utils.getMD5Value(StaticVariable.getProp("edccare.hcp.url.password"));
		
//			System.out.println("fullPath : " + fullPath);
		logger.info("("+hashing+") "+"Full Path: "+fullPath);

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.set(Criteria.HCPAuthHeaderKey, auth);

		HttpEntity<?> httpEntity = new HttpEntity<Object>(requestHeaders);
		RestTemplate restTemplate = restTemplateSkipSSL(hashing);
		ResponseEntity<byte[]> byteImage = restTemplate.exchange(fullPath, HttpMethod.GET, httpEntity, byte[].class);

		byte[] byteFile = null; 
		if (null != byteImage) {
			byteFile = byteImage.getBody();

			logger.info("("+hashing+") "+"extention: "+extention);
			if (StringUtils.isNotEmpty(extention) && extention.equalsIgnoreCase("pdf")) {
				response.setContentType(MediaType.APPLICATION_PDF_VALUE);
			} else if (StringUtils.isNotEmpty(extention) && (extention.equalsIgnoreCase("jpg") || extention.equalsIgnoreCase("jpeg"))) {
				response.setContentType(MediaType.IMAGE_JPEG_VALUE);
			} else if (StringUtils.isNotEmpty(extention) && extention.equalsIgnoreCase("png")) {
				response.setContentType(MediaType.IMAGE_PNG_VALUE);
			} else if (StringUtils.isNotEmpty(extention) && (extention.equalsIgnoreCase("xls") || extention.equalsIgnoreCase("xlsx"))) {
				response.setContentType("application/vnd.ms-excel");
				response.addHeader("Content-disposition", "attachment; filename=\"" + fileName + "\"");
			} else if (StringUtils.isNotEmpty(extention) && (extention.equalsIgnoreCase("doc") || extention.equalsIgnoreCase("docx"))) {
				response.setContentType("application/msword");
				response.addHeader("Content-disposition", "attachment; filename=\"" + fileName + "\"");
			} else if (StringUtils.isNotEmpty(extention) && (extention.equalsIgnoreCase("ppt") || extention.equalsIgnoreCase("pptx"))) {
				response.setContentType("application/vnd.ms-powerpoint");
				response.addHeader("Content-disposition", "attachment; filename=\"" + fileName + "\"");
			} else {
				response.setContentType(MediaType.TEXT_PLAIN_VALUE);
			}

	        InputStream inputStream = new ByteArrayInputStream(byteFile);
	        return outputStream -> {
	            int nRead;
	            byte[] data = new byte[1024];
	            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
	                outputStream.write(data, 0, nRead);
	            }
	        };
		}
		
		return null;
	}
	
	@Override
	public ManagerViewModel<StreamingResponseBody> getComplainImagesWrap(long hashing, 
			String id, HttpServletResponse response) {		
		ManagerViewModel<StreamingResponseBody> mvm = new ManagerViewModel<>();
		try {
			String namespace = StaticVariable.getProp("edccare.hcp.url.namespace");
			if (StringUtils.isNotEmpty(namespace) && !namespace.endsWith("/"))
				namespace = namespace + "/";
			String complaintfolderpath = StaticVariable.getProp("edccare.hcp.url.complaintfolderpath");
			if (StringUtils.isNotEmpty(complaintfolderpath) && !complaintfolderpath.endsWith("/"))
				complaintfolderpath = complaintfolderpath + "/";
			
			String pathImage = "";
			ManagerViewModel<ComplaintViewModel> mvmFindById = findById(hashing, id);
			if (null != mvmFindById && mvmFindById.getTotalrows() > 0 
					&& null != mvmFindById.getContent()) {
				ComplaintViewModel vm = mvmFindById.getContent();
				pathImage = vm.getImage_path();
			}

			if (StringUtils.isNotEmpty(pathImage) && pathImage.startsWith("/"))
				pathImage = StaticVariable.getNLastCharacter(pathImage, (pathImage.length() - 1), "");

			String fullPath = namespace + complaintfolderpath + pathImage;

			String fileName = "";
			String extention = "";
			if (StringUtils.isNotEmpty(fullPath)) {
				int slashCnt = fullPath.lastIndexOf("/");
				if (slashCnt > 0) {
					fileName = fullPath.substring(slashCnt+1);
					int dotCnt = fileName.indexOf(".");
					if (slashCnt > 0) {
						extention = fileName.substring(dotCnt+1);
					}
				}
			}
			
			String auth = "HCP " + Utils.getBase64Value(StaticVariable.getProp("edccare.hcp.url.username")) + ":"
					+ Utils.getMD5Value(StaticVariable.getProp("edccare.hcp.url.password"));
			
//			System.out.println("fullPath : " + fullPath);
			logger.info("("+hashing+") "+"Full Path: "+fullPath);

			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.set(Criteria.HCPAuthHeaderKey, auth);

			HttpEntity<?> httpEntity = new HttpEntity<Object>(requestHeaders);
			RestTemplate restTemplate = restTemplateSkipSSL(hashing);
			ResponseEntity<byte[]> byteImage = restTemplate.exchange(fullPath, HttpMethod.GET, httpEntity, byte[].class);
			logger.info("("+hashing+") "+"byteImage: "+byteImage);

			byte[] byteFile = null; 
			if (null != byteImage) {
				byteFile = byteImage.getBody();
				
				if (StringUtils.isNotEmpty(extention) && extention.equalsIgnoreCase("pdf")) {
					response.setContentType(MediaType.APPLICATION_PDF_VALUE);
				} else if (StringUtils.isNotEmpty(extention) && (extention.equalsIgnoreCase("jpg") || extention.equalsIgnoreCase("jpeg"))) {
					response.setContentType(MediaType.IMAGE_JPEG_VALUE);
				} else if (StringUtils.isNotEmpty(extention) && extention.equalsIgnoreCase("png")) {
					response.setContentType(MediaType.IMAGE_PNG_VALUE);
				} else if (StringUtils.isNotEmpty(extention) && (extention.equalsIgnoreCase("xls") || extention.equalsIgnoreCase("xlsx"))) {
					response.setContentType("application/vnd.ms-excel");
					response.addHeader("Content-disposition", "attachment; filename=\"" + fileName + "\"");
				} else if (StringUtils.isNotEmpty(extention) && (extention.equalsIgnoreCase("doc") || extention.equalsIgnoreCase("docx"))) {
					response.setContentType("application/msword");
					response.addHeader("Content-disposition", "attachment; filename=\"" + fileName + "\"");
				} else if (StringUtils.isNotEmpty(extention) && (extention.equalsIgnoreCase("ppt") || extention.equalsIgnoreCase("pptx"))) {
					response.setContentType("application/vnd.ms-powerpoint");
					response.addHeader("Content-disposition", "attachment; filename=\"" + fileName + "\"");
				} else {
					response.setContentType(MediaType.TEXT_PLAIN_VALUE);
				}
				
		        InputStream inputStream = new ByteArrayInputStream(byteFile);
		        StreamingResponseBody streamResponseBody = outputStream -> {
		            int nRead;
		            byte[] data = new byte[1024];
		            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
		                outputStream.write(data, 0, nRead);
		            }
		        };
		        
		        mvm.setContent(streamResponseBody);
				mvm.setTotalrows(1);
				mvm.setInfo(getInfoOk("Success"));
			}
		} catch (Exception e) {
			String errMsg = StaticVariable.starckTraceToString(e);
			logger.error("("+hashing+") "+"errMsg: "+errMsg);

			mvm.setTotalrows(0);
			mvm.setInfo(getInfoConflict(errMsg));
		}
		
		return mvm;
	}

	private RestTemplate restTemplateSkipSSL(long hashing) {
		try {
			TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
			
			SSLContext sslContext;sslContext = org.apache.http.ssl.SSLContexts.custom()
			        .loadTrustMaterial(null, acceptingTrustStrategy)
			        .build();

			SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

			CloseableHttpClient httpClient = HttpClients.custom()
			        .setSSLSocketFactory(csf)
			        .build();

			HttpComponentsClientHttpRequestFactory requestFactory =
			        new HttpComponentsClientHttpRequestFactory();

			requestFactory.setHttpClient(httpClient);
			
			return new RestTemplate(requestFactory);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			logger.error("(" + hashing + ") " + StaticVariable.starckTraceToString(e));
		}
		
		return new RestTemplate();
	}
}
