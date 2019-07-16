package com.rjnsh.cart;

import com.rjnsh.cart.constants.CartStatusEnum;
import com.rjnsh.cart.constants.ProductCategoryEnum;
import com.rjnsh.cart.model.Cart;
import com.rjnsh.cart.model.Product;
import com.rjnsh.cart.service.CartManagementService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class CartManagementApplicationTests {

	@Autowired
	CartManagementService cartManagementService;

	void setUp()
	{
		Product p1 = new Product();
		p1.setProductId("1");
		p1.setProductName("Shirt");
		p1.setCategory(ProductCategoryEnum.CLOTHING.getCategory());
		p1.setPrice(BigDecimal.valueOf(100));

		Product p2 = new Product();
		p2.setProductId("56");
		p2.setProductName("Bun");
		p2.setCategory(ProductCategoryEnum.EATABLE.getCategory());
		p2.setPrice(BigDecimal.valueOf(10));

		Cart cart = new Cart();
		cart.setCartId(1);
		cart.setStatus(CartStatusEnum.ORDERED.getStatus());


		Product p3 = new Product();
		p3.setProductId("4");
		p3.setProductName("Lamp");
		p3.setCategory(ProductCategoryEnum.ELECTRONICS.getCategory());
		p3.setPrice(BigDecimal.valueOf(10));


		Cart cart1 = new Cart();
		cart1.setCartId(2);
		cart1.setStatus(CartStatusEnum.DISCARDED.getStatus());

		Map<Product, Integer> productList = new HashMap<>();
		productList.put(p1,1);
		productList.put(p2,2);

		cart.setProductList(productList);

		Map<Product, Integer> productList1 = new HashMap<>();
		productList1.put(p1,1);
		productList1.put(p2,2);
		productList1.put(p3,2);

		cart1.setProductList(productList1);


		cartManagementService.carts.put(1,cart);
		cartManagementService.carts.put(2,cart1);
	}

	@Test
	void testFetchCartsByStatus() {
		setUp();
		System.out.println(cartManagementService.fetchCartsByStatus(CartStatusEnum.ORDERED.getStatus()));

		Assertions.assertTrue(!CollectionUtils.isEmpty(cartManagementService.fetchCartsByStatus(CartStatusEnum.ORDERED.getStatus())));

	}


	@Test
	void testFetchProdHistory() {
		setUp();
		System.out.println(cartManagementService.fetchProdHistory("1"));
		Assertions.assertEquals(cartManagementService.fetchProdHistory("1").size(),1 );

	}

	@Test
	void testFetchCartsByProdCategory() {
		setUp();
		System.out.println(cartManagementService.fetchCartsByProdCategory(ProductCategoryEnum.CLOTHING.getCategory()));
		Assertions.assertEquals(cartManagementService.fetchCartsByProdCategory(ProductCategoryEnum.CLOTHING.getCategory()).size(),1 );

	}

}
