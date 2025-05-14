package com.tcs.training.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    
    private Long quantity;
    
    @Column(name = "unit_price")
    private Double unitPrice;
    
    @Column(name = "total_amount" )
    private Double totalAmount;
    
    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;
    
    @Column(name = "expected_delivery_date")
    private LocalDate expectedDeliveryDate;
    
    @Enumerated(EnumType.STRING)
    private PurchaseStatus status;
    
    public Purchase() {}

	public Purchase(Long id, Vendor vendor, Product product, Long quantity, Double unitPrice, Double totalAmount,
			LocalDateTime purchaseDate, LocalDate expectedDeliveryDate, PurchaseStatus status) {
		super();
		this.id = id;
		this.vendor = vendor;
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalAmount = totalAmount;
		this.purchaseDate = purchaseDate;
		this.expectedDeliveryDate = expectedDeliveryDate;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public LocalDate getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public PurchaseStatus getStatus() {
		return status;
	}

	public void setStatus(PurchaseStatus status) {
		this.status = status;
	}
	
	
    
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", vendor=" + vendor + ", product=" + product + ", quantity=" + quantity
				+ ", unitPrice=" + unitPrice + ", totalAmount=" + totalAmount + ", purchaseDate=" + purchaseDate
				+ ", expectedDeliveryDate=" + expectedDeliveryDate + ", status=" + status + "]";
	}



	public enum PurchaseStatus {
	    PENDING, COMPLETED, CANCELLED
	}
    
}

