package id.co.bca.magenta.api.merchantcare.repository;

import java.util.List;

import id.co.bca.magenta.api.merchantcare.entity.Merchant;

public interface MerchantRepository extends RepositoryBase {
	public List<Merchant> findAll(long hashing, 
			int page, int size, String search, String orderby);
	public Merchant findById(long hashing, String id);
	public boolean isExist(long hashing, String id);
}