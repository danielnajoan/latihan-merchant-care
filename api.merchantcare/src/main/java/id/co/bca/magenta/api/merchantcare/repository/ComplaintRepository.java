package id.co.bca.magenta.api.merchantcare.repository;

import java.util.List;
import java.util.Map;

import id.co.bca.magenta.api.merchantcare.entity.Complaint;

public interface ComplaintRepository extends RepositoryBase {
	public List<Complaint> findAll(long hashing, 
			int page, int size, String search, String orderby);
	public Complaint findById(long hashing, String id);
	public boolean isExist(long hashing, String id);
	public Map<String, Object> save(long hashing, Map params, String caseCategoryId);
}
