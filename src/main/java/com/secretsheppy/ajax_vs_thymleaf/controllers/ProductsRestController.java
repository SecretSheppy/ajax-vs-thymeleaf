package com.secretsheppy.ajax_vs_thymleaf.controllers;

import com.secretsheppy.ajax_vs_thymleaf.Product;
import com.secretsheppy.ajax_vs_thymleaf.Products;
import com.secretsheppy.ajax_vs_thymleaf.Response;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ProductsRestController {

    @GetMapping("/products/api/products_list")
    public List<Product> getProducts() {
        return Products.getProducts();
    }

    @GetMapping("/products/api/next_id")
    public int getNextId() {
        return Products.getNextProductId();
    }

    @PostMapping("/products/api/new")
    public ResponseEntity<Response> createProduct(@Valid @RequestBody Product product, BindingResult binding) {

        if (binding.hasErrors()) {
            return ResponseEntity.badRequest().body(new Response(binding.getAllErrors().get(0).getDefaultMessage(), null));
        }

        Products.addProducts(product);

        return ResponseEntity.ok(new Response("Product created", product));
    }

}
