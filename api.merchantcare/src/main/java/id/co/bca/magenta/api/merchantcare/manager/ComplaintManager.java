package id.co.bca.magenta.api.merchantcare.manager;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import id.co.bca.magenta.api.merchantcare.entity.viewmodel.ComplaintCreateViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.ComplaintViewModel;
import id.co.bca.magenta.api.merchantcare.entity.viewmodel.ManagerViewModel;
import id.co.bca.magenta.api.merchantcare.util.ErrorDetail;

public interface ComplaintManager extends ManagerBase {
	public ManagerViewModel<List<ComplaintViewModel>> findAll(long hashing, 
			int page, int size, String search, String orderby, String baseUrl);
	public ManagerViewModel<ComplaintViewModel> findById(long hashing, String id);
	public ManagerViewModel<ComplaintViewModel> findByIdMaskingImagesLocation(long hashing, 
			String id, String baseUrl);
	public boolean isExist(long hashing, String id);
	public ManagerViewModel<ErrorDetail> saveToSpV2(long hashing, ComplaintCreateViewModel view);
	public StreamingResponseBody getComplainImages(long hashing, 
			String id, HttpServletResponse response);
	public ManagerViewModel<StreamingResponseBody> getComplainImagesWrap(long hashing, String id,
			HttpServletResponse response);
}
