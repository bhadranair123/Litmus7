package com.litmus7.retail.service;

import java.util.List;

import com.litmus7.retail.dao.ProductDaoImpl;
import com.litmus7.retail.dto.Product;
import com.litmus7.retail.exception.ProductDataAccessException;
import com.litmus7.retail.exception.ProductServiceException;

public class ProductService {
	ProductDaoImpl productDaoImpl = null;

	public Product addProduct(Product product) throws ProductServiceException {

		try {
			productDaoImpl = new ProductDaoImpl();
			ProductService service = new ProductService();
			if (service.getProductByName(product.getProductId()).equals(product.getName())) {
				Product newProduct = productDaoImpl.addProduct(product);
				return newProduct;
			} else {
				throw new ProductServiceException("Product already exists");
			}
		} catch (ProductDataAccessException e) {
			throw new ProductServiceException("Unable to process the request at the moment " + e.getMessage());
		}
	}

	public Product getProductById(int productId) throws ProductServiceException {
		try {
			productDaoImpl = new ProductDaoImpl();
			Product product = null;
			product = productDaoImpl.getProductById(productId);
			return product;
		} catch (ProductDataAccessException e) {
			throw new ProductServiceException("Unable to process the request at the moment " + e.getMessage());
		}

	}

	public List<Product> getAllProducts() throws ProductServiceException {
		try {
			productDaoImpl = new ProductDaoImpl();
			List<Product> products = productDaoImpl.getAllProducts();
			return products;
		} catch (ProductDataAccessException e) {
			throw new ProductServiceException("Unable to process the request at the moment " + e.getMessage());
		}
	}

	public Product updateProduct(Product product) throws ProductServiceException {
		try {
			productDaoImpl = new ProductDaoImpl();
			if ((productDaoImpl.getProductById(product.getProductId())) != null) {
				Product updatedProduct = productDaoImpl.updateProduct(product);
				return updatedProduct;
			} else {
				return null;
			}
		} catch (ProductDataAccessException e) {
			throw new ProductServiceException("Unable to process the request at the moment " + e.getMessage());
		}
	}

	public void deleteProduct(int productId) throws ProductServiceException {

		try {
			productDaoImpl = new ProductDaoImpl();
			if ((productDaoImpl.getProductById(productId)) != null) {
				productDaoImpl.deleteProduct(productId);
			} else {
				throw new ProductServiceException("Product does not exist");
			}
		} catch (ProductDataAccessException e) {
			throw new ProductServiceException("Unable to process the request at the moment " + e.getMessage());
		}
	}

	public String getProductByName(int productId) throws ProductServiceException {

		try {
			productDaoImpl = new ProductDaoImpl();
			Product product = productDaoImpl.getProductById(productId);
			if (product != null) {
				String productName = product.getName();
				return productName;
			} else {
				return null;
			}
		} catch (ProductDataAccessException e) {
			throw new ProductServiceException("Unable to process the request at the moment " + e.getMessage());
		}
	}

}
