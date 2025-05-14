package com.tcs.training.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.training.Entity.Vendor;
import com.tcs.training.Repository.ProductRepository;
import com.tcs.training.Repository.VendorRepository;
import com.tcs.training.dto.VendorProductDTO;

@Service
public class VendorService {
	@Autowired
	VendorRepository vrepo;
	@Autowired
	ProductRepository prepo;

    public Vendor addVendor(Vendor vendor) {
      
    	System.out.println("im in publisher vendor service");
        Vendor v=vrepo.save(vendor);
        return v;
    }
    public List<Vendor> allVendors(){
    	return vrepo.findAll();
    }

}
