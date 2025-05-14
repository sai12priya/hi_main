package com.tcs.training.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.training.Entity.Product;
import com.tcs.training.Entity.Purchase;
import com.tcs.training.Entity.Vendor;
import com.tcs.training.Service.PurchaseService;
import com.tcs.training.dto.PurchaseRequestDTO;
@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	@Autowired
	PurchaseService pservice;
	
	@PostMapping("/add")
	public ResponseEntity<?> addVendor(@RequestBody PurchaseRequestDTO prdto) {
		
		try {
            System.out.println("Received DTO: " + prdto);
            if (prdto == null || prdto.getVendor() == null || prdto.getProduct() == null) {
                return ResponseEntity.badRequest()
                    .body(Map.of("error", "Invalid DTO: Vendor or Product is null"));
            }

            Product product = prdto.getProduct();
            Vendor vendor = prdto.getVendor();
            Purchase purchase=prdto.getPurchase();
            System.out.println("Product: " + product);
            System.out.println("Vendor: " + vendor);
            System.out.println("Vendor: " + purchase);

            Purchase savedPurchase = pservice.addPurchase(purchase);
           
            System.out.println("Saved Vendor: " + savedPurchase);
          return ResponseEntity.ok(savedPurchase);
        } catch (Exception e) {
            System.err.println("Error in addVendor: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest()
                .body(Map.of("error", e.getMessage()));
        }
    
    }

}
