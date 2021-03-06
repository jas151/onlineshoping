 package jas.kum.onlineshoping.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jas.kum.onlineshoping.exception.ProductNotFoundException;
import jas.kum.shopingbackend.dao.CategoryDAO;
import jas.kum.shopingbackend.dao.ProductDAO;
import jas.kum.shopingbackend.dto.Category;
import jas.kum.shopingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger= LoggerFactory.getLogger(PageController.class);

	/*
	 * here we are using depedency injection (ioc container will create the
	 * object of categoryDAO class and inject into pageController class ) using
	 * autowired.
	 */
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		logger.info("Inside PageController index method-INFO ");
		logger.debug("Inside PageController index method-DEBUG ");
		
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		logger.info("Inside PageController index method-INFO Ended ");
		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	@RequestMapping(value = { "/viewList" })
	public ModelAndView viewList() {
		ModelAndView mv = new ModelAndView("page");   
		mv.addObject("title", "View List");
		mv.addObject("userClickViewList", true);
		return mv;
	}

	/*
	 * method to load all the products and bases on category
	 * 
	 */
	@RequestMapping("/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All products");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping("/show/category/{id}/products")
	public ModelAndView showCategoryProduct(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		// categoryDAO to fetch the category as single category

		Category category = null;
		category = categoryDAO.get(id);

		mv.addObject("title", category.getName());
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		// passing the single category object
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
	//viewing a single product
	
	@RequestMapping(value= "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
		
		ModelAndView mv = new ModelAndView("page");
		Product product=productDAO.get(id);
		
		if(product==null)throw new ProductNotFoundException("");
		
		//update the view count
		product.setViews(product.getViews() +1);
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		
		return mv;
		
	}
}
