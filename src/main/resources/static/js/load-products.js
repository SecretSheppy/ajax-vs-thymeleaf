'use strict';

/**
 * Automatically loads the products from the api when this bit of the
 * html is executed.
 */
$.ajax({
    url: "/products/api/products_list"
}).done((products) => {
    products.map(product => newProduct(product));
});