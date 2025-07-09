package com.litmus7.retail.controller;

import com.litmus7.retail.service.ProductService;

import java.util.List;

import com.litmus7.retail.dto.Product;
import com.litmus7.retail.exception.ProductServiceException;
import com.litmus7.retail.dto.Response;

public class ProductController {
	ProductService productService = null;

	public Response<Product> addProduct(Product product) throws ProductServiceException {
		Response response = new Response();
		try {
			productService = new ProductService();
			Product newProduct = productService.addProduct(product);
			response.setData(newProduct);
			response.setStatusCode(response.getSUCCESS_STATUS_CODE());
		} catch (ProductServiceException e) {
			response.setStatusCode(response.getERROR_STATUS_CODE());
			response.setErrorCode("Product Addition Failed");
		}
		return response;
	}

	public Response<Product> getProductById(int productId) throws ProductServiceException {
		Response<Product> response = new Response();
		try {
			productService = new ProductService();
			Product product = productService.getProductById(productId);
			response.setData(product);
			response.setStatusCode(response.getSUCCESS_STATUS_CODE());
		} catch (ProductServiceException e) {
			response.setStatusCode(response.getERROR_STATUS_CODE());
			response.setErrorCode("Product Fetch Failed");
		}
		return response;
	}

	public Response<List<Product>> getAllProducts() throws ProductServiceException {
		Response response = new Response();
		try {
			productService = new ProductService();
			List<Product> products = productService.getAllProducts();
			response.setData(products);
			response.setStatusCode(response.getSUCCESS_STATUS_CODE());
		} catch (ProductServiceException e) {
			response.setStatusCode(response.getERROR_STATUS_CODE());
			response.setErrorCode("Products Fetch Failed");
		}
		return response;
	}

	public Response<Product> updateProduct(Product product) throws ProductServiceException {
		Response response = new Response();
		try {
			productService = new ProductService();
			Product updatedProduct = productService.updateProduct(product);
			response.setData(updatedProduct);
			response.setStatusCode(response.getSUCCESS_STATUS_CODE());
		} catch (ProductServiceException e) {
			response.setStatusCode(response.getERROR_STATUS_CODE());
			response.setErrorCode("Product Updation Failed");
		}
		return response;
	}

	public Response<String> deleteProduct(int productId) throws ProductServiceException {
		Response response = new Response();
		try {
			productService = new ProductService();
			productService.deleteProduct(productId);
			response.setData("Product deleted");
			response.setStatusCode(response.getSUCCESS_STATUS_CODE());
		} catch (ProductServiceException e) {
			response.setStatusCode(response.getERROR_STATUS_CODE());
			response.setErrorCode("Product Delition Failed");
		}
		return response;
	}
}
