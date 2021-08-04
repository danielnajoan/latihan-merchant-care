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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import id.co.bca.magenta.api.merchantcare.entity.viewmodel.ManagerViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.MidRequestDto;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.OutletDetailListViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.OutletDetailViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.TerminalListViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.TerminalViewModel;
import id.co.bca.magenta.api.merchantcare.manager.MagentaManager;
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
@Tag(name = "Magenta API", description = "Operations pertaining to Magenta")
public class MagentaController {
	private static final Logger logger = LoggerFactory.getLogger(MagentaController.class);

	@Autowired
	MagentaManager magentaManager;
	
	private long getCurrentHashing() {
		return new Date().getTime();
	}
	
	@Operation(summary = "Get List Terminal Init by MID", description = "Get List Terminal Init by MID", 
		tags = "Magenta API")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Success", 
	            content = @Content(schema = @Schema(implementation = OutletDetailListViewModel.class))),
	    @ApiResponse(responseCode = "204", description = "No Content"),
	    @ApiResponse(responseCode = "409", description = "Conflict", 
	    	content = @Content(schema = @Schema(implementation = OutletDetailListViewModel.class)))})
	@GetMapping("/getTerminalByMID/{mid}")
	public ResponseEntity<TerminalListViewModel> getRecordByMid(@PathVariable("mid") String mid) {
		long hashing = getCurrentHashing();

		logger.info("("+hashing+") "+"Get List Terminal Data by MID: " + mid);

		ManagerViewModel<TerminalViewModel> mvm = magentaManager.getTerminalInitByMID(hashing, mid);

		TerminalListViewModel lvm = new TerminalListViewModel();
		if (null != mvm) {
			TerminalViewModel vm = mvm.getContent();
			if (null != vm && mvm.getTotalrows() > 0) {
				lvm = new TerminalListViewModel(vm);
				lvm.setInfo(mvm.getInfo());
				lvm.setTotalrows(mvm.getTotalrows());
			} else {
				lvm.setInfo(mvm.getInfo());
				lvm.setTotalrows(mvm.getTotalrows());
			}
		} else {
			logger.warn("("+hashing+") "+"Get List Terminal Data by MID: [" + mid + "] is Not Found!");
			
			ErrorDetail info = new ErrorDetail();
			info.setMessage(HttpStatus.NO_CONTENT.name());
			info.setStatus(HttpStatus.NO_CONTENT.value());
			
			lvm.setInfo(info);
			lvm.setTotalrows(0);
		}
		
		return new ResponseEntity<TerminalListViewModel>(lvm, HttpStatus.OK);
	}

	@Operation(summary = "Get Outlet Detail from ArrayList MID", description = "Get Outlet Detail from ArrayList MID", 
		tags = "Magenta API")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Success", 
	            content = @Content(schema = @Schema(implementation = OutletDetailListViewModel.class))),
	    @ApiResponse(responseCode = "204", description = "No Content"),
	    @ApiResponse(responseCode = "409", description = "Conflict", 
	    	content = @Content(schema = @Schema(implementation = OutletDetailListViewModel.class)))})
	@PostMapping("/getOutletDetailByListMID")
	public ResponseEntity<OutletDetailListViewModel> getOutletRecordByListMID(@RequestBody MidRequestDto mid) {
		long hashing = getCurrentHashing();

		logger.info("("+hashing+") "+"Get Outlet Detail from ArrayList MID: " + mid);

		ManagerViewModel<List<OutletDetailViewModel>> mvm = magentaManager
				.getOutletDetailByListMID(hashing, mid);

		OutletDetailListViewModel lvm = new OutletDetailListViewModel();
		if (null != mvm) {
			List<OutletDetailViewModel> vm = mvm.getContent();
			if (null != vm && mvm.getTotalrows() > 0) {
				lvm = new OutletDetailListViewModel(vm);
				lvm.setInfo(mvm.getInfo());
				lvm.setTotalrows(mvm.getTotalrows());
			} else {
				lvm.setInfo(mvm.getInfo());
				lvm.setTotalrows(mvm.getTotalrows());
			}
		} else {
			logger.warn("("+hashing+") "+"Get Outlet Detail from ArrayList MID: [" + mid + "] is Not Found!");
			
			ErrorDetail info = new ErrorDetail();
			info.setMessage(HttpStatus.NO_CONTENT.name());
			info.setStatus(HttpStatus.NO_CONTENT.value());
			
			lvm.setInfo(info);
			lvm.setTotalrows(0);
		}
		
		return new ResponseEntity<OutletDetailListViewModel>(lvm, HttpStatus.OK);
	}
}
