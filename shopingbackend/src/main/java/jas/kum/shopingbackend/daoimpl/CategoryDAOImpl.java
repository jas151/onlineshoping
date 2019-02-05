 package jas.kum.shopingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jas.kum.shopingbackend.dao.CategoryDAO;
import jas.kum.shopingbackend.dto.Category;
  
@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	//private static 	List<Category> categories=new ArrayList<>();
	
	//static block to define a list of categories
	/*static{
		      //adding first category
		      Category category=new Category();
		      category.setId(1);
		      category.setName("Television");
		      category.setDescripton("this is description for television");
		      category.setImageURL("CAT_1.png");
		      categories.add(category);
		
		        //adding second category
				Category category2=new Category();
				category2.setId(2);
				category2.setName("Mobile");
				category2.setDescripton("this is description for mobile");
				category2.setImageURL("CAT_2.png");
				categories.add(category2);
				
				//adding third category
				Category category3=new Category();
				category3.setId(3);
				category3.setName("Laptop");
				category3.setDescripton("this is description for laptop");
				category3.setImageURL("CAT_3.png");
				categories.add(category3);
	}*/
	@Override
	public List<Category> list() {
		String selectActiveCategory="FROM Category WHERE active= :active";
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active",true);
		
		return query.getResultList();
	}
	
	//Getting single category based on id
	@Override
	public Category get(int id) {
		
		/*for(Category category:categories){
			if(category.getId()==id){
				return category;}}*/
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		

	}
	@Override
	
	public boolean add(Category category) {
		
		try {
			//add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}
	
	//updating a single category
	@Override
	public boolean update(Category category) {
		try {
			//add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		try {
			//add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
