package com.tcs.training.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.training.Entity.Purchase;
import com.tcs.training.Repository.PurchaseRepository;

@Service
public class PurchaseService {
	@Autowired
	PurchaseRepository prepo;
	 public Purchase addPurchase(Purchase purchase) {
	      
	    	System.out.println("im in publisher vendor service");
	        Purchase pur=prepo.save(purchase);
	        return pur;
	    }

}
