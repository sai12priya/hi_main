package com.tcs.training.dto;

import com.tcs.training.Entity.Product;
import com.tcs.training.Entity.Purchase;
import com.tcs.training.Entity.Vendor;

public class PurchaseRequestDTO {
	private Product product;
	private Vendor vendor;
	private Purchase purchase;
	public PurchaseRequestDTO() {}
	public PurchaseRequestDTO(Product product, Vendor vendor, Purchase purchase) {
		super();
		this.product = product;
		this.vendor = vendor;
		this.purchase = purchase;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public Purchase getPurchase() {
		return purchase;
	}
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	

}
