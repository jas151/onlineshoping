package jas.kum.onlineshoping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jas.kum.shopingbackend.dao.ProductDAO;
import jas.kum.shopingbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	

	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts(){
		System.out.println("inside the getAllProducts");
		List<Product> pro=productDAO.listActiveProducts();
		System.out.println("inside the getallproducts ended"+pro);
		return pro;
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getAllProductsByCategory(@PathVariable int id){
		System.out.println("inside the getAllProducts by id "+id);
		List<Product> pro=productDAO.listActiveProductsByCategory(id);
		System.out.println("inside the getallproducts by id ended"+pro); 
		
		return pro;
	}

}
