//package com.tcs.training.Controller;
//
//import java.util.ArrayList;
//import org.springframework.ui.Model;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//
//import com.example.ims.Entity.Product;
//import com.tcs.training.Service.ProductService;
//
//@Controller
//public class ProductController {
//	@Autowired
//	ProductService ps;
//	
//	
//	@PostMapping("/add")
//	public String addProduct(Product p) {
//		ps.addProduct(p);
//		return "redirect:/admin/dashboard";
//	}
//	@GetMapping("admin/edit/{pid}")
//    public String showEditForm(@PathVariable int pid, Model model) {
//        Product product = ps.getProductById(pid);
//        model.addAttribute("product", product);
//        return "editproduct"; // Thymeleaf template for editing
//    }
//
//  
//    @PostMapping("admin/edit/{pid}")
//    public String updateProduct(@PathVariable int pid, 
//                             @ModelAttribute Product updatedProduct,
//                             Model model) {
//     
//            Product product = ps.editProduct(pid, updatedProduct);
//            return "redirect:/admin/dashboard";
//    }
//    @DeleteMapping("admin/delete/{pid}")
//    public String deleteProduct(@PathVariable int pid) {
//    	ps.deleteProduct(pid);
//    	return "redirect:/admin/dashboard";
//    }
//    
//	
//}
