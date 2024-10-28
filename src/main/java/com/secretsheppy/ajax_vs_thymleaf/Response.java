package com.secretsheppy.ajax_vs_thymleaf;

public class Response {

    private String message;
    private Product product;

    public Response(String message, Product product) {
        this.message = message;
        this.product = product;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
