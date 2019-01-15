package jas.kum.shopingbackend.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
		
	/*@Test
	public void testAddCategory(){
		category= new Category();
		 
		category.setName("Laptop");
	      category.setDescripton("this is description for Laptop");
	      category.setImageURL("CAT_1.png");
	      
	      assertEquals("Successfully added a category inside the table!  ",true,categoryDAO.add(category));
	}
	*/
	
	/*@Test
	public void testGetCategory(){
		category=categoryDAO.get(3);
		assertEquals("Successfully fetched a single category from the table!", "Television",category.getName());
	}*/
	
	
	/*@Test
	public void testUpdateCategory(){
		category=categoryDAO.get(3);
		category.setName("TV");
		assertEquals("Successfully update a single category in the table!",true,categoryDAO.update(category));
	}*/
	
	/*@Test
	public void testDeleteCategory(){
		category=categoryDAO.get(3);
		
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
	}*/
	
	/*@Test
	public void testListCategory(){
		
		
		assertEquals("Successfully fetched a single category from the table!",3,categoryDAO.list().size());
	}*/
	
	@Test
	public void testCURDCategory(){
		
		//add operation
      category= new Category();
		
	 /* category.setName("Laptop");
	  category.setDescripton("this is description for Laptop");
	  category.setImageURL("CAT_1.png");
	  
	  assertEquals("Successfully added a category inside the table!  ",true,categoryDAO.add(category));
	
	     category= new Category();
		 category.setName("Television");
		 category.setDescripton("this is description for Television");
		 category.setImageURL("CAT_2.png");
		      
		 assertEquals("Successfully added a category inside the table!  ",true,categoryDAO.add(category));
	*/

		 //fetching and updating the category
		   /* category=categoryDAO.get(14);
		    category.setName("Laptop");
		    assertEquals("Successfully update a single category in the table!",true,categoryDAO.update(category));
		    */
	
	//delete the category
		   /* boolean b=categoryDAO.delete(category);
		   assertEquals("Successfully deleted a single category in the table!",b,categoryDAO.delete(category));*/
		   
		//fetching the list
		   
		   List<Category> d=categoryDAO.list();
		   for(Category c:d){
			   System.out.println(c.getName());
		   }
		   assertEquals("Successfully fetched a single category from the table!",3,categoryDAO.list().size());
	
	}
	
	}


