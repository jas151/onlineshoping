package jas.kum.shopingbackend.dao;

import java.util.List;

import jas.kum.shopingbackend.dto.Category;

public interface CategoryDAO {
	
	
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	

	

}
