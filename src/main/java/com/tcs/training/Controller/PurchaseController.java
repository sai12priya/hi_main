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
import com.tcs.training.Service.ProductService;
import com.tcs.training.Service.PurchaseService;
import com.tcs.training.Service.VendorService;
@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	@Autowired
	PurchaseService pservice;
	@Autowired
	ProductService proservice;
	@Autowired
	VendorService vendorService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addPurchase(@RequestBody Purchase purchaseRequest) {
	    try {
	        if (purchaseRequest == null || purchaseRequest.getVendor() == null || purchaseRequest.getVendor().getId() == null) {
	            return ResponseEntity.badRequest()
	                .body(Map.of("error", "Invalid request: Vendor ID is required"));
	        }
	        
	        // Fetch complete vendor from database
	        Vendor vendor = vendorService.getVendorById(purchaseRequest.getVendor().getId());
	        //Product product=proservice.getProductByName(purchaseRequest.getVendor().getProduct().getName());
	        if (vendor == null) {
	            return ResponseEntity.badRequest()
	                .body(Map.of("error", "Vendor not found with ID: " + purchaseRequest.getVendor().getId()));
	        }
	     // Update the purchase request with complete vendor
	        //purchaseRequest.getVendor().setProduct(product);
	        int quantity=purchaseRequest.getVendor().getProduct().getQuantityAvailable();
	        Double price=purchaseRequest.getVendor().getProduct().getPrice();
	        Vendor vv=vendorService.getVendorById(purchaseRequest.getVendor().getId());
	        Long id=vv.getProduct().getId();
	        Product p=proservice.findById(id);
	      int quantity1=p.getQuantityAvailable()==null?quantity:p.getQuantityAvailable()+quantity;
	       p.setQuantityAvailable(quantity1);
	        p.setPrice(price);
	        
	        proservice.updateProduct(p);
	        
	        // Update the purchase request with complete vendor
	        purchaseRequest.setVendor(vendor);
	        
	        // Save the purchase
	        Purchase savedPurchase = pservice.addPurchase(purchaseRequest);
	        
	        return ResponseEntity.ok(savedPurchase);
	    } catch (Exception e) {
	        return ResponseEntity.badRequest()
	            .body(Map.of("error", e.getMessage()));
	    }
	}

}
