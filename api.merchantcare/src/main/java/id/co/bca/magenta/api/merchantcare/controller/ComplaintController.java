package id.co.bca.magenta.api.merchantcare.controller;

import java.io.File;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.TrustStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import id.co.bca.magenta.api.merchantcare.entity.viewmodel.ComplaintCreateViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.ComplaintListViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.ComplaintViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.ManagerViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.MasterViewModel;
import id.co.bca.magenta.api.merchantcare.hcp.HCP;
import id.co.bca.magenta.api.merchantcare.hcp.Utils;
import id.co.bca.magenta.api.merchantcare.manager.ComplaintManager;
import id.co.bca.magenta.api.merchantcare.util.ErrorDetail;
import id.co.bca.magenta.api.merchantcare.util.MultiRequest;
import id.co.bca.magenta.api.merchantcare.util.StaticVariable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Encoding;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@SuppressWarnings({ "rawtypes", "unchecked" })
@Tag(name = "Complaint API", description = "Operations pertaining to Complaint")
public class ComplaintController {
	private static final Logger logger = LoggerFactory.getLogger(ComplaintController.class);

	@Autowired
	ComplaintManager complaintManager;
	
	private long getCurrentHashing() {
		return new Date().getTime();
	}

	@Operation(summary = "Get List Complaint Data ver 2.0", description = "Get List Complaint Data ver 2.0", 
		tags = "Complaint API")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Success", 
	            content = @Content(schema = @Schema(implementation = ComplaintListViewModel.class))),
	    @ApiResponse(responseCode = "204", description = "No Content"),
	    @ApiResponse(responseCode = "409", description = "Conflict", 
	    	content = @Content(schema = @Schema(implementation = ComplaintListViewModel.class)))})
	@GetMapping("/1.1/complaints")
	public ResponseEntity<ComplaintListViewModel> getListByQuery(
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size,
			@RequestParam(value = "orderby", required = false, defaultValue = "requestid") String orderby,
			@RequestParam(value = "query", required = false, defaultValue = "") String search) {
		long hashing = getCurrentHashing();

		logger.info("("+hashing+") "+"Get List Complaint Data");
		
		String baseUrl = ServletUriComponentsBuilder
				.fromCurrentContextPath().build().toUriString();
		
		ManagerViewModel<List<ComplaintViewModel>> mvm = complaintManager
				.findAll(hashing, page, size, search, orderby, baseUrl);

		ComplaintListViewModel lvm = new ComplaintListViewModel();
		if (null != mvm) {
			List<ComplaintViewModel> listData = mvm.getContent();
			if (null != listData && listData.size() > 0) {
				lvm = new ComplaintListViewModel(listData);
				lvm.setInfo(mvm.getInfo());
				lvm.setTotalrows(mvm.getTotalrows());
			} else {
				lvm.setInfo(mvm.getInfo());
				lvm.setTotalrows(mvm.getTotalrows());
			}
		} else {
			ErrorDetail info = new ErrorDetail();
			info.setMessage(HttpStatus.NO_CONTENT.name());
			info.setStatus(HttpStatus.NO_CONTENT.value());
			
			lvm.setInfo(info);
			lvm.setTotalrows(0);
		}
		
		return new ResponseEntity<ComplaintListViewModel>(lvm, HttpStatus.OK);
	}

	// ####### Retrieve Single Complaint #######
	@Operation(summary = "Get Single Complaint Data ver 2.0", description = "Get Single Complaint Data ver 2.0", 
		tags = "Complaint API")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Success", 
	            content = @Content(schema = @Schema(implementation = ComplaintListViewModel.class))),
	    @ApiResponse(responseCode = "204", description = "No Content"),
	    @ApiResponse(responseCode = "409", description = "Conflict", 
	    	content = @Content(schema = @Schema(implementation = ComplaintListViewModel.class)))})
	@GetMapping("/2.0/complaints/{requestId}")
	public ResponseEntity<ComplaintListViewModel> getRecordById(@PathVariable("requestId") String id) {
		long hashing = getCurrentHashing();

		logger.info("("+hashing+") "+"Get Complaint Data by Request ID: " + id);
		
		String baseUrl = ServletUriComponentsBuilder
				.fromCurrentContextPath().build().toUriString();

		ManagerViewModel<ComplaintViewModel> mvm = complaintManager
				.findByIdMaskingImagesLocation(hashing, id, baseUrl);

		ComplaintListViewModel lvm = new ComplaintListViewModel();
		if (null != mvm) {
			ComplaintViewModel vm = mvm.getContent();
			if (null != vm && mvm.getTotalrows() > 0) {
				lvm = new ComplaintListViewModel(vm);
				lvm.setInfo(mvm.getInfo());
				lvm.setTotalrows(mvm.getTotalrows());
			} else {
				lvm.setInfo(mvm.getInfo());
				lvm.setTotalrows(mvm.getTotalrows());
			}
		} else {
			logger.warn("("+hashing+") "+"Get Complaint by Request ID : [" + id + "] is Not Found!");
			
			ErrorDetail info = new ErrorDetail();
			info.setMessage(HttpStatus.NO_CONTENT.name());
			info.setStatus(HttpStatus.NO_CONTENT.value());
			
			lvm.setInfo(info);
			lvm.setTotalrows(0);
		}
		
		return new ResponseEntity<ComplaintListViewModel>(lvm, HttpStatus.OK);
	}

	// ####### Save Complaint #######
	@Operation(summary = "Save Complaint - NEW : Using HCP", description = "Save Complaint - NEW : Using HCP", 
		tags = "Complaint API", 
		requestBody = @RequestBody(
				content = @Content(
						mediaType = "multipart/form-data",
						schema = @Schema(implementation = MultiRequest.class),
						encoding = @Encoding(name = "file",
								contentType = "image/jpeg, image/png"
								)
						)
				)
	)
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "201", description = "Created", 
	            content = @Content(schema = @Schema(implementation = MasterViewModel.class))),
	    @ApiResponse(responseCode = "204", description = "No Content"),
	    @ApiResponse(responseCode = "409", description = "Conflict", 
	    	content = @Content(schema = @Schema(implementation = MasterViewModel.class))),
	    @ApiResponse(responseCode = "501", description = "Not Implemented")})
	@PostMapping("/1.2/complaint/create")
	public MasterViewModel doSave2(@RequestPart(required = false, value = "file") MultipartFile file,
			@RequestParam("param") String param) {
		long hashing = getCurrentHashing();

		logger.info("("+hashing+") "+"Save Complaint");

		MasterViewModel result = new MasterViewModel();
		ErrorDetail info = new ErrorDetail();
		ObjectMapper mapper = new ObjectMapper();

		String filePath = "";
		String uploadPath = "";
		String fullUploadPath = "";

		LocalDateTime localDate = LocalDateTime.now();
		String dateNameFolder = DateTimeFormatter.ofPattern("yyyyMMdd").format(localDate);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS_");
		String orgName = "";

		ComplaintCreateViewModel view;
		try {
			view = mapper.readValue(param, ComplaintCreateViewModel.class);
			if (null != file) {
				logger.info("("+hashing+") "+"File is not null");
			}
			if (null == file) {
				logger.warn("("+hashing+") "+"File is null");
			}
			if (null != file && !file.isEmpty()) {
				try {
					String complaintImgPath = StaticVariable.getProp("mms.properties.path.complaint");
//        			if (null != complaintImgPath && !(complaintImgPath.endsWith("\\") || complaintImgPath.endsWith("/")))
//        				complaintImgPath = complaintImgPath + File.separator;
        			
					uploadPath = File.separator + dateNameFolder + File.separator;
					fullUploadPath = complaintImgPath + uploadPath;

					if (!new File(fullUploadPath).exists()) {
						new File(fullUploadPath).mkdir();
					}

					orgName = "requestid_" + dtf.format(localDate) + file.getOriginalFilename().toLowerCase();

					filePath = fullUploadPath + orgName;

					logger.info("("+hashing+") "+"uploadPath : " + uploadPath);
					logger.info("("+hashing+") "+"fullUploadPath : " + fullUploadPath);
					logger.info("("+hashing+") "+"filePath : " + filePath);

				} catch (Exception e) {
					String errMsg = "You failed to upload " + file.getOriginalFilename() + " => " + StaticVariable.starckTraceToString(e);
					logger.error("("+hashing+") "+errMsg);

					info.setMessage(HttpStatus.CONFLICT.name());
					info.setStatus(HttpStatus.CONFLICT.value());
					info.setDetailmessage("Error: " + errMsg);
					
					result.setContent(info);
				}
			}

			view.setImage_path((uploadPath + orgName).replace("\\", "/"));
			logger.info("("+hashing+") "+"view.getImage_path() : " + view.getImage_path());

			ManagerViewModel<ErrorDetail> mvm = complaintManager.saveToSpV2(hashing, view);
			ErrorDetail detail = mvm.getContent();
			result.setContent(detail);

			String errmsg[] = ((String) detail.getDetailmessage()).split(";");

			logger.info("("+hashing+") "+"errmsg : " + Arrays.asList(errmsg));
			if (errmsg[0].toUpperCase().contains("COMMIT")) {
				// SIMPAN ke HCP
				if (null != file && !file.isEmpty()) {
					logger.info("("+hashing+") "+"Save to HCP....");
					String auth = "HCP " + Utils.getBase64Value(StaticVariable.getProp("edccare.hcp.url.username")) + ":"
							+ Utils.getMD5Value(StaticVariable.getProp("edccare.hcp.url.password"));
					String namespace = StaticVariable.getProp("edccare.hcp.url.namespace");
					String folderpath = StaticVariable.getProp("edccare.hcp.url.complaintfolderpath")
							+ Utils.getDateFolderName();
					
					String filename_ext = orgName.replace("requestid_", errmsg[2] + "_");
					logger.info("("+hashing+") "+"folderpath : " + folderpath);
					logger.info("("+hashing+") "+"filename_ext : " + filename_ext);
					
					// call https
					TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
					
					SSLContext sslContext;sslContext = org.apache.http.ssl.SSLContexts.custom()
					        .loadTrustMaterial(null, acceptingTrustStrategy)
					        .build();

					SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

					HttpClient client = HttpClients.custom()
					        .setSSLSocketFactory(csf)
					        .build();
					
					HCP.post(client, auth, namespace, folderpath, filename_ext, file);
				}
			}

			return result;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			String errMsg = StaticVariable.starckTraceToString(e1);
			logger.error("("+hashing+") "+errMsg);

			e1.printStackTrace();
			
			info.setMessage(HttpStatus.CONFLICT.name());
			info.setStatus(HttpStatus.CONFLICT.value());
			info.setDetailmessage("Error: " + errMsg);
			result.setContent(info);

			return result;
		}
	}
	
	// ####### Create Complaint Merchat Care #######
	@Operation(summary = "Save Complaint - NEW : Using HCP", description = "Save Complaint - NEW : Using HCP", 
			tags = "Complaint API", 
			requestBody = @RequestBody(
					content = @Content(
							mediaType = "multipart/form-data",
							schema = @Schema(implementation = MultiRequest.class),
							encoding = @Encoding(name = "file",
									contentType = "image/jpeg, image/png"
									)
							)
					)
		)
		@ApiResponses(value = {
		    @ApiResponse(responseCode = "201", description = "Created", 
		            content = @Content(schema = @Schema(implementation = MasterViewModel.class))),
		    @ApiResponse(responseCode = "204", description = "No Content"),
		    @ApiResponse(responseCode = "409", description = "Conflict", 
		    	content = @Content(schema = @Schema(implementation = MasterViewModel.class))),
		    @ApiResponse(responseCode = "501", description = "Not Implemented")})
	@PostMapping("/save")
	public MasterViewModel createComplaintMerchatCare(@RequestPart(required = false, value = "file") MultipartFile file,
			@RequestParam String jsonData) throws JsonMappingException, JsonProcessingException{
		long hashing = getCurrentHashing();
		logger.info("("+hashing+") "+"Save Complaint");
		
		MasterViewModel result = new MasterViewModel();
		ErrorDetail info = new ErrorDetail();
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		
		String filePath = "";
		String uploadPath = "";
		String fullUploadPath = "";

		LocalDateTime localDate = LocalDateTime.now();
		String dateNameFolder = DateTimeFormatter.ofPattern("yyyyMMdd").format(localDate);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS_");
		String orgName = "";
		

		ComplaintCreateViewModel view = mapper.readValue(jsonData, ComplaintCreateViewModel.class);
			try {
				if (null != file) {
					logger.info("("+hashing+") "+"File is not null");
				}
				if (null == file) {
					logger.warn("("+hashing+") "+"File is null");
				}
				if (null != file && !file.isEmpty()) {
					try {
						String complaintImgPath = StaticVariable.getProp("mms.properties.path.complaint");
						uploadPath = File.separator + dateNameFolder + File.separator;
						fullUploadPath = complaintImgPath + uploadPath;
	
						if (!new File(fullUploadPath).exists()) {
							new File(fullUploadPath).mkdir();
						}
	
						orgName = "requestid_" + dtf.format(localDate) + file.getOriginalFilename().toLowerCase();
	
						filePath = fullUploadPath + orgName;
	
						logger.info("("+hashing+") "+"uploadPath : " + uploadPath);
						logger.info("("+hashing+") "+"fullUploadPath : " + fullUploadPath);
						logger.info("("+hashing+") "+"filePath : " + filePath);
	
					} catch (Exception e) {
						String errMsg = "You failed to upload " + file.getOriginalFilename() + " => " + StaticVariable.starckTraceToString(e);
						logger.error("("+hashing+") "+errMsg);
	
						info.setMessage(HttpStatus.CONFLICT.name());
						info.setStatus(HttpStatus.CONFLICT.value());
						info.setDetailmessage("Error: " + errMsg);
						
						result.setContent(info);
					}
				}
	
				view.setImage_path((uploadPath + orgName).replace("\\", "/"));
				logger.info("("+hashing+") "+"view.getImage_path() : " + view.getImage_path());
	
				ManagerViewModel<ErrorDetail> mvm = complaintManager.saveToSpV2(hashing, view);
				ErrorDetail detail = mvm.getContent();
				result.setContent(detail);
	
				String errmsg[] = ((String) detail.getDetailmessage()).split(";");
	
				logger.info("("+hashing+") "+"errmsg : " + Arrays.asList(errmsg));
				if (errmsg[0].toUpperCase().contains("COMMIT")) {
					// SIMPAN ke HCP
					if (null != file && !file.isEmpty()) {
						logger.info("("+hashing+") "+"Save to HCP....");
						String auth = "HCP " + Utils.getBase64Value(StaticVariable.getProp("edccare.hcp.url.username")) + ":"
								+ Utils.getMD5Value(StaticVariable.getProp("edccare.hcp.url.password"));
						String namespace = StaticVariable.getProp("edccare.hcp.url.namespace");
						String folderpath = StaticVariable.getProp("edccare.hcp.url.complaintfolderpath")
								+ Utils.getDateFolderName();
						
						String filename_ext = orgName.replace("requestid_", errmsg[2] + "_");
						logger.info("("+hashing+") "+"folderpath : " + folderpath);
						logger.info("("+hashing+") "+"filename_ext : " + filename_ext);
						
						// call https
						TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
						
						SSLContext sslContext;sslContext = org.apache.http.ssl.SSLContexts.custom()
						        .loadTrustMaterial(null, acceptingTrustStrategy)
						        .build();
	
						SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
	
						HttpClient client = HttpClients.custom()
						        .setSSLSocketFactory(csf)
						        .build();
						
						HCP.post(client, auth, namespace, folderpath, filename_ext, file);
					}
				}return result;
			}catch (Exception e1) {
				// TODO Auto-generated catch block
				String errMsg = StaticVariable.starckTraceToString(e1);
				logger.error("("+hashing+") "+errMsg);
	
				e1.printStackTrace();
				
				info.setMessage(HttpStatus.CONFLICT.name());
				info.setStatus(HttpStatus.CONFLICT.value());
				info.setDetailmessage("Error: " + errMsg);
				result.setContent(info);
			return result;
		}
	}

	@Operation(summary = "Get Compalin Image by Request Id", description = "Get Compalin Image by Request Id", 
		tags = "Complaint API")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Success", 
	            content = @Content(schema = @Schema(implementation = StreamingResponseBody.class))),
	    @ApiResponse(responseCode = "204", description = "No Content"),
	    @ApiResponse(responseCode = "409", description = "Conflict", 
	    	content = @Content(schema = @Schema(implementation = StreamingResponseBody.class)))})
	@GetMapping(value = "/1.0/file/getImageMerchantCare/{requestId}")
	public StreamingResponseBody getImageMs(
			HttpServletResponse response,
			@PathVariable("requestId") String requestId) throws IOException {
		long hashing = getCurrentHashing();
		
		logger.info("("+hashing+") "+"Get Compalin Image by Request Id: " + requestId);
		ManagerViewModel<StreamingResponseBody> mvm = complaintManager
				.getComplainImagesWrap(hashing, requestId, response);
		StreamingResponseBody streamingResponseBody = mvm.getContent();
		
		return streamingResponseBody;
//		return complaintManager.getComplainImages(hashing, requestId, response);
	}
}
