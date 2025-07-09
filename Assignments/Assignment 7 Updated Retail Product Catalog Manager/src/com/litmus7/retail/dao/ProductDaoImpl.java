package com.litmus7.retail.dao;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.litmus7.retail.dto.Product;
import com.litmus7.retail.util.DBUtil;
import com.litmus7.retail.exception.ProductDataAccessException;

public class ProductDaoImpl implements ProductDao {
	private Connection connection;

	public void connectToDB() throws SQLException {
		connection = DBUtil.getConnection();
	}

	@Override
	public Product addProduct(Product product) throws ProductDataAccessException {
		try {
			connectToDB();
			String sql = "insert into products values (?,?,?,?,?) ";
			PreparedStatement statement = connection.prepareStatement(sql);
			int productId = product.getProductId();
			String name = product.getName();
			String category = product.getCategory();
			Double price = product.getPrice();
			int stockQuantity = product.getStockQuantity();
			statement.setInt(1, productId);
			statement.setString(2, name);
			statement.setString(3, category);
			statement.setDouble(4, price);
			statement.setInt(5, stockQuantity);
			statement.executeUpdate();
			return product;
		} catch (SQLException e) {
			throw new ProductDataAccessException(e.getMessage());
		}

	}

	@Override
	public Product getProductById(int productId) throws ProductDataAccessException {
		try {
			connectToDB();
			String sql = "select name,category,price,stock_quantity from products where product_id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, productId);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String name = resultSet.getString(1);
				String category = resultSet.getString(2);
				Double price = resultSet.getDouble(3);
				int stockQuantity = resultSet.getInt(4);

				Product product = new Product(productId, name, category, price, stockQuantity);
				return product;
			}

		} catch (SQLException e) {
			throw new ProductDataAccessException("Unable to access user database at the moment " + e.getMessage());

		}
		return null;
	}

	@Override
	public List<Product> getAllProducts() throws ProductDataAccessException {
		List<Product> products = new ArrayList<>();
		try {
			connectToDB();
			String sql = "select product_id,name,category,price,stock_quantity from products";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				int productId = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String category = resultSet.getString(3);
				Double price = resultSet.getDouble(4);
				int stockQuantity = resultSet.getInt(5);

				Product product = new Product(productId, name, category, price, stockQuantity);
				products.add(product);
			}
			return products;

		} catch (SQLException e) {
			throw new ProductDataAccessException("Unable to access user database at the moment " + e.getMessage());

		}

	}

	@Override
	public Product updateProduct(Product product) throws ProductDataAccessException {
		try {
			connectToDB();
			String sql = "update products set name=?,category=?,price=?,stock_quantity=? where product_id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			int productId = product.getProductId();
			String name = product.getName();
			String category = product.getCategory();
			Double price = product.getPrice();
			int stockQuantity = product.getStockQuantity();
			statement.setString(1, name);
			statement.setString(2, category);
			statement.setDouble(3, price);
			statement.setInt(4, stockQuantity);
			statement.setInt(5, productId);
			statement.executeUpdate();
			return product;
		} catch (SQLException e) {
			throw new ProductDataAccessException("Unable to access user database at the moment " + e.getMessage());

		}
	}

	@Override
	public void deleteProduct(int productId) throws ProductDataAccessException {
		try {
			connectToDB();
			String sql = "delete from products where product_id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, productId);
			statement.executeUpdate();

		} catch (SQLException e) {
			throw new ProductDataAccessException("Unable to access user database at the moment " + e.getMessage());

		}
	}

}
