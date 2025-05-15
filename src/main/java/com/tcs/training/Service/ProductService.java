package com.tcs.training.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.training.Entity.Product;
import com.tcs.training.Repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	ProductRepository repo;
	public Product addProduct(Product p) {
		System.out.println("im in publisher product service");
		System.out.println("");
		System.out.println(p);
		return repo.save(p);
	}
//	public List<Product> allProducts(){
//		return repo.findAll();
//	}
//	public Product getProductByName(String name) {
//        return repo.findByName(name);
//               
//    }

	public Product findById(Long id) {
		return repo.findById(id).get();
	}
	
	public Product updateProduct(Product product) {
		return repo.save(product);
	}
//    public Product editProduct(int pid, Product updatedProduct) {
//        Product existingProduct = getProductById(pid);
//        
//        existingProduct.setName(updatedProduct.getName());
//        existingProduct.setDescription(updatedProduct.getDescription());
//        existingProduct.setPrice(updatedProduct.getPrice());
//        existingProduct.setQty(updatedProduct.getQty());
//        
//        return repo.save(existingProduct);
//    }
//	public void deleteProduct(int pid) {
//		// TODO Auto-generated method stub
//		repo.deleteById(pid);
//	}
//	
	
}
