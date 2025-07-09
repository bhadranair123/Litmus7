package com.litmus7.retail.app;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import com.litmus7.retail.controller.ProductController;
import com.litmus7.retail.dto.Product;
import com.litmus7.retail.exception.ProductServiceException;
import com.litmus7.retail.dto.Response;

public class ProductApp {
	public static void main(String[] args) throws ProductServiceException {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("------------MENU----------------");
			System.out.println("1. Add Product \r\n" + "2. View Product by ID \r\n" + "3. View All Products \r\n"
					+ "4. Update Product \r\n" + "5. Delete Product \r\n" + "6. Exit ");
			System.out.println("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			ProductController productController = new ProductController();
			switch (choice) {

//		ADDING NEW PRODUCT
			case 1:

				System.out.println("Enter Product ID: ");
				int productId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter Product Name: ");
				String name = scanner.nextLine();
				System.out.println("Enter Category: ");
				String category = scanner.nextLine();
				System.out.println("Enter Price: ");
				double price = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Enter Stock: ");
				int stock = scanner.nextInt();
				scanner.nextLine();
				Product product1 = new Product(productId, name, category, price, stock);
				Response response1 = new Response();
				response1 = productController.addProduct(product1);
				if (response1.getStatusCode() == 200) {
					System.out.println("Product added successfully!");

				} else {
					System.out.println("Product with name " + name
							+ " already exists.Product Addition Failed. You may update the product if required.");
				}
				break;
//		PRODUCT SEARCH
			case 2:
				System.out.println("Enter Product ID to search: ");
				int searchProductId = scanner.nextInt();
				Response response2 = new Response();
				response2 = productController.getProductById(searchProductId);
				if (response2.getStatusCode() == 200 && response2.getData() != null) {
					System.out.println(response2.getData());
				} else {
					System.out.println("Product with ID " + searchProductId + " not found");
				}
				break;
//		GET ALL PRODUCTS
			case 3:
				Response<List<Product>> response3 = new Response();
				response3 = productController.getAllProducts();
				if (response3.getStatusCode() == 200) {
					System.out.println("All Products in Catalog: ");
					List<Product> products = response3.getData();
					for (Product product : products) {
						System.out.println(product.toString());
					}
				}
				break;
//		PRODUCT UPDATION
			case 4:
				System.out.println("Enter Product ID to update: ");
				int productIdToUpdate = scanner.nextInt();
				scanner.nextLine();
				Response<Product> response4 = new Response();
				response4 = productController.getProductById(productIdToUpdate);
				if (response4.getStatusCode() == 200 && response4.getData() != null) {
					Product currentProduct = response4.getData();
					System.out.println("Enter new name( " + currentProduct.getName() + "):");
					String nameToUpdate = scanner.nextLine();
					System.out.println("Enter new category( " + currentProduct.getCategory() + ")");
					String categoryToUpdate = scanner.nextLine();
					System.out.println("Enter new price( " + currentProduct.getPrice() + ")");
					double priceToUpdate = scanner.nextDouble();
					scanner.nextLine();
					System.out.println("Enter new stock( " + currentProduct.getStockQuantity() + ")");
					int stockToUpdate = scanner.nextInt();
					scanner.nextLine();
					Product productToUpdate = new Product(productIdToUpdate, nameToUpdate, categoryToUpdate,
							priceToUpdate, stockToUpdate);
					Response response5 = productController.updateProduct(productToUpdate);
					if (response5.getStatusCode() == 200) {
						System.out.println("Product Updated successfully!");
					}
				} else {
					System.out.println("Product with ID " + productIdToUpdate + " not found. Update failed.");

				}
				break;
//		PRODUCT DELETION
			case 5:
				System.out.println("Enter Product ID to delete: ");
				int productIdToDelete = scanner.nextInt();
				Response response6 = new Response();
				response6 = productController.deleteProduct(productIdToDelete);
				if (response6.getStatusCode() == 200) {
					System.out.println("Product deleted successfully!");
				} else {
					System.out.println("Product with ID " + productIdToDelete + " not found. Deletion failed");
				}
				break;
//		EXIT
			case 6:
				System.out.println("Exited the Program!");
				System.exit(0);
				break;
//      DEFAULT
			case 7:
				System.out.println("Invalid Choice. Review the options please");
			}
		}
	}
}