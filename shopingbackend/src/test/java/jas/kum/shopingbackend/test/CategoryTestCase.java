package jas.kum.shopingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jas.kum.shopingbackend.dao.CategoryDAO;
import jas.kum.shopingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
		
	
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("jas.kum.shopingbackend");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
		
	@Test
	public void testAddCategory(){
		category= new Category();
		
		category.setName("Laptop");
	      category.setDescripton("this is description for Laptop");
	      category.setImageURL("CAT_1.png");
	      
	      assertEquals("Successfully added a category inside the table!  ",true,categoryDAO.add(category));
	}
	
	}

