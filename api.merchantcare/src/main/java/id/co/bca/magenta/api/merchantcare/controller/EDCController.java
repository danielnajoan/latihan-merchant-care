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

import id.co.bca.magenta.api.merchantcare.entity.viewmodel.EDCListViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.EDCViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.ManagerViewModel;
import id.co.bca.magenta.api.merchantcare.manager.EDCManager;
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
@Tag(name = "EDC API", description = "Operations pertaining to EDC")
public class EDCController {
	private static final Logger logger = LoggerFactory.getLogger(EDCController.class);

	@Autowired
	private EDCManager edcManager;
	
	private long getCurrentHashing() {
		return new Date().getTime();
	}
	
	@Operation(summary = "Get List EDC Data ver 2.0", description = "Get List EDC Data ver 2.0", 
		tags = "EDC API")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Success", 
	            content = @Content(schema = @Schema(implementation = EDCListViewModel.class))),
	    @ApiResponse(responseCode = "204", description = "No Content"),
	    @ApiResponse(responseCode = "409", description = "Conflict", 
	    	content = @Content(schema = @Schema(implementation = EDCListViewModel.class)))})
	@GetMapping("/1.1/edcs")
	public ResponseEntity<EDCListViewModel> getListByQuery(
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size,
			@RequestParam(value = "orderby", required = false, defaultValue = "productid") String orderby,
			@RequestParam(value = "query", required = false, defaultValue = "") String search) {
		long hashing = getCurrentHashing();
		
		logger.info("("+hashing+") "+"Get List EDC Data");
		
		ManagerViewModel<List<EDCViewModel>> mvm = edcManager
				.findAll(hashing, page, size, search, orderby);

		EDCListViewModel lvm = new EDCListViewModel();
		if (null != mvm) {
			List<EDCViewModel> listData = mvm.getContent();
			if (null != listData && listData.size() > 0) {
				lvm = new EDCListViewModel(listData);
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
		
		return new ResponseEntity<EDCListViewModel>(lvm, HttpStatus.OK);
	}

	// ####### Retrieve Single EDC #######
	@Operation(summary = "Get Single EDC Data ver 2.0", description = "Get Single EDC Data ver 2.0", 
		tags = "EDC API")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Success", 
	            content = @Content(schema = @Schema(implementation = EDCListViewModel.class))),
	    @ApiResponse(responseCode = "204", description = "No Content"),
	    @ApiResponse(responseCode = "409", description = "Conflict", 
	    	content = @Content(schema = @Schema(implementation = EDCListViewModel.class)))})
	@GetMapping("/2.0/edcs/{requestId}")
	public ResponseEntity<EDCListViewModel> getRecordById(@PathVariable("requestId") String reqId) {
		long hashing = getCurrentHashing();
		
		logger.info("("+hashing+") "+"Get Single EDC Data by Request ID: " + reqId);

		ManagerViewModel<EDCViewModel> mvm = edcManager.findById(hashing, reqId);

		EDCListViewModel lvm = new EDCListViewModel();
		if (null != mvm) {
			EDCViewModel vm = mvm.getContent();
			if (null != vm && mvm.getTotalrows() > 0) {
				lvm = new EDCListViewModel(vm);
				lvm.setInfo(mvm.getInfo());
				lvm.setTotalrows(mvm.getTotalrows());
			} else {
				lvm.setInfo(mvm.getInfo());
				lvm.setTotalrows(mvm.getTotalrows());
			}
		} else {
			logger.warn("("+hashing+") "+"Get Single EDC Data by Request ID: [" + reqId + "] is Not Found!");
			
			ErrorDetail info = new ErrorDetail();
			info.setMessage(HttpStatus.NO_CONTENT.name());
			info.setStatus(HttpStatus.NO_CONTENT.value());
			
			lvm.setInfo(info);
			lvm.setTotalrows(0);
		}
		
		return new ResponseEntity<EDCListViewModel>(lvm, HttpStatus.OK);
	}
}
