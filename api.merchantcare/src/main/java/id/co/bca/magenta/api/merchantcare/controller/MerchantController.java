package id.co.bca.magenta.api.merchantcare.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.bca.magenta.api.merchantcare.entity.viewmodel.ManagerViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.MerchantListViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.MerchantViewModel;
import id.co.bca.magenta.api.merchantcare.manager.MerchantManager;
import id.co.bca.magenta.api.merchantcare.util.ErrorDetail;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@SuppressWarnings({ "rawtypes", "unchecked" })
@Tag(name = "Merchant API", description = "Operations pertaining to Merchant")
public class MerchantController {
	private static final Logger logger = LoggerFactory.getLogger(MerchantController.class);

	@Autowired
	MerchantManager merchantManager;
	
	private long getCurrentHashing() {
		return new Date().getTime();
	}

	@Operation(summary = "Get List Merchant Data ver 2.0", description = "Get List Merchant Data ver 2.0", 
			tags = "Merchant API")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", 
                    content = @Content(schema = @Schema(implementation = MerchantListViewModel.class))),
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "409", description = "Conflict", 
            	content = @Content(schema = @Schema(implementation = MerchantListViewModel.class)))})
	@GetMapping("/1.1/merchants")
	public ResponseEntity<MerchantListViewModel> getListByQuery(
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size,
			@RequestParam(value = "orderby", required = false, defaultValue = "mid") String orderby,
			@RequestParam(value = "query", required = false, defaultValue = "") String search) {
		long hashing = getCurrentHashing();

		logger.info("("+hashing+") "+"Get List Merchant Data");
		
		ManagerViewModel<List<MerchantViewModel>> mvm = merchantManager
				.findAll(hashing, page, size, search, orderby);

		MerchantListViewModel lvm = new MerchantListViewModel();
		if (null != mvm) {
			List<MerchantViewModel> listData = mvm.getContent();
			if (null != listData && listData.size() > 0) {
				lvm = new MerchantListViewModel(listData);
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
		
		return new ResponseEntity<MerchantListViewModel>(lvm, HttpStatus.OK);
	}

	// ####### Retrieve Single Merchant #######
	@Operation(summary = "Get Single Merchant Data ver 2.0", description = "Get Single Merchant Data ver 2.0", 
		tags = "Merchant API")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Success", 
	            content = @Content(schema = @Schema(implementation = MerchantListViewModel.class))),
	    @ApiResponse(responseCode = "204", description = "No Content"),
	    @ApiResponse(responseCode = "409", description = "Conflict", 
	    	content = @Content(schema = @Schema(implementation = MerchantListViewModel.class)))})
	@GetMapping("/2.0/merchants/{merchantId}")
	public ResponseEntity<MerchantListViewModel> getRecordById(@PathVariable("merchantId") String id) {
		long hashing = getCurrentHashing();

		logger.info("("+hashing+") "+"Get Single Merchant Data by ID: " + id);

		ManagerViewModel<MerchantViewModel> mvm = merchantManager.findById(hashing, id);

		MerchantListViewModel lvm = new MerchantListViewModel();
		if (null != mvm) {
			MerchantViewModel vm = mvm.getContent();
			if (null != vm && mvm.getTotalrows() > 0) {
				lvm = new MerchantListViewModel(vm);
				lvm.setInfo(mvm.getInfo());
				lvm.setTotalrows(mvm.getTotalrows());
			} else {
				lvm.setInfo(mvm.getInfo());
				lvm.setTotalrows(mvm.getTotalrows());
			}
		} else {
			logger.warn("("+hashing+") "+"Get Merchant by ID : [" + id + "] is Not Found!");
			
			ErrorDetail info = new ErrorDetail();
			info.setMessage(HttpStatus.NO_CONTENT.name());
			info.setStatus(HttpStatus.NO_CONTENT.value());
			
			lvm.setInfo(info);
			lvm.setTotalrows(0);
		}
		
		return new ResponseEntity<MerchantListViewModel>(lvm, HttpStatus.OK);
	}
}
