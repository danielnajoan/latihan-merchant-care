package id.co.bca.magenta.api.merchantcare.repository;

import java.util.List;

import id.co.bca.magenta.api.merchantcare.entity.EDC;

public interface EDCRepository extends RepositoryBase {
	public List<EDC> findAll(long hashing, 
			int page, int size, String search, String orderby);
	public EDC findById(long hashing, String id);
	public boolean isExist(long hashing, String id);
}