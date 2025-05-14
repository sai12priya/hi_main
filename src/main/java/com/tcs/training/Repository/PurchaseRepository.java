package com.tcs.training.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.training.Entity.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Long>{

	
}
