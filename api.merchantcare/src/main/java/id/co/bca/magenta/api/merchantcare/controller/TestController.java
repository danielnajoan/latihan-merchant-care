package id.co.bca.magenta.api.merchantcare.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import id.co.bca.magenta.api.merchantcare.entity.viewmodel.ComplaintCreateViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.MasterViewModel;
import id.co.bca.magenta.api.merchantcare.manager.ComplaintManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@SuppressWarnings({ "rawtypes", "unchecked" })
@Api(value = "Test API", description = "Test Operations", tags = "Test")
@RequestMapping("/test")
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	ComplaintManager complaintManager;
	
	// ####### Create Complaint Merchat Care #######
	@ApiOperation(value = "Insert Complaint", response = MasterViewModel.class)
	@PostMapping("/save")
	public ResponseEntity<MasterViewModel> createComplaintMerchatCare(
			@RequestParam String json) throws JsonMappingException, JsonProcessingException {

	    ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		ComplaintCreateViewModel viewModel = mapper.readValue(json, ComplaintCreateViewModel.class);

		MasterViewModel result = new MasterViewModel();
		result.setContent(viewModel);
		
		return new ResponseEntity<MasterViewModel>(result, HttpStatus.OK);
	}
	
}
