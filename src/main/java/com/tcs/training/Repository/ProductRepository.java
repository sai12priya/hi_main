package com.tcs.training.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.training.Entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
	
}
