package com.cts.product.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.cts.product.entity.Product;
@Repository
public class ProductDaoImpl implements ProductDao {

	@org.springframework.beans.factory.annotation.Autowired(required=true)
	private SessionFactory sf;

	@Override
	public void saveProduct(Product prod) {
		Session s = sf.openSession();
		s.save(prod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listProds() {
		Session s = sf.openSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> root = cq.from(Product.class);
		cq.select(root);
		
		Query q = s.createQuery(cq);

		return q.getResultList();

		
		
	}

}
