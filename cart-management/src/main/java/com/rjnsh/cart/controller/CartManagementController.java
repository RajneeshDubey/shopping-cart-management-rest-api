package com.rjnsh.cart.controller;

import com.rjnsh.cart.model.Cart;
import com.rjnsh.cart.service.CartManagementService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/cart/", produces = "application/json")
@Api(value = "CartManagement", description = "Operation to manage carts")
public class CartManagementController {

    @Autowired
    CartManagementService cartManagementService;

    Logger log = Logger.getLogger(CartManagementController.class.getName());

    @GetMapping(value = "cartsByStatus/{status}")
    @ApiOperation(value = "CartByStatus Operation to fetch carts with a particular status.")
    public List<Cart> fetchCartsByStatus(final @PathVariable String status) {
        List<Cart> cartListWithStatus = new ArrayList<>();
        try {
            cartListWithStatus = cartManagementService.fetchCartsByStatus(status);
        }
        catch(Exception e)
        {
            log.warning("Could Not Fetch Carts with this status.");
        }
        return cartListWithStatus;
    }


    @GetMapping(value = "cartsByProdCategory/{prodCategory}")
    @ApiOperation(value = "CartByProdCategory Operation to fetch carts with a particular product category.")
    public Map<String, Integer> fetchCartsByProdCategory(final @PathVariable String prodCategory) {
        Map<String, Integer> cartListByProductCategory = new HashMap<>();
        try {
            cartListByProductCategory = cartManagementService.fetchCartsByProdCategory(prodCategory);
        }
        catch(Exception e)
        {
            log.warning("Could Not Fetch Carts with this product Category.");

        }
        return cartListByProductCategory;
    }


    @GetMapping(value = "fetchProdHistory/{prodId}")
    @ApiOperation(value = "fetchProdHistory Operation to fetch the history of the product i.e. number of times it was ordered, dicarded and number of purchase happening.")
    public Map<String, Integer> fetchProdHistory(final @PathVariable String prodId) {
        Map<String, Integer> prodHistory = new HashMap<>();
        try {
            prodHistory = cartManagementService.fetchProdHistory(prodId);
        }
        catch(Exception e)
        {
            log.warning("Could Not Fetch Any Details for the given product Id.");

        }
        return prodHistory;
    }
}
