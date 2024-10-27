package com.secretsheppy.ajax_vs_thymleaf.controllers;

import com.secretsheppy.ajax_vs_thymleaf.Product;
import com.secretsheppy.ajax_vs_thymleaf.Products;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductsController {

    @GetMapping("/products/ajax")
    public String getAjaxProductsPage(Model model) {
        return "ajax";
    }

    @GetMapping("/products/thymeleaf")
    public String getThymleafProductsPage(Model model) {
        model.addAttribute("products", Products.getProducts());
        model.addAttribute("id", Products.getNextProductId());
        model.addAttribute("product", new Product());
        return "thymeleaf";
    }

    @PostMapping("/products/thymeleaf/new")
    public String createNewProduct(@Valid @ModelAttribute Product product,
                                   BindingResult bindingResult,
                                   Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getAllErrors().get(0).getDefaultMessage());
        } else {
            Products.addProducts(product);
        }

        model.addAttribute("products", Products.getProducts());
        return "thymeleaf";
    }

}
