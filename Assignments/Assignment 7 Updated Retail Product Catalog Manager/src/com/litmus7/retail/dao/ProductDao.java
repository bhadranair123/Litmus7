package com.litmus7.retail.dao;

import java.util.List;

import com.litmus7.retail.dto.Product;
import com.litmus7.retail.exception.ProductDataAccessException;

public interface ProductDao {
	public Product addProduct(Product product) throws ProductDataAccessException;

	public Product getProductById(int productId) throws ProductDataAccessException;

	public List<Product> getAllProducts() throws ProductDataAccessException;

	public Product updateProduct(Product product) throws ProductDataAccessException;

	public void deleteProduct(int productId) throws ProductDataAccessException;

}
