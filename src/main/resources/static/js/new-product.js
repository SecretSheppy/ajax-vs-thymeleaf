'use strict';

/**
 * Converts a form element into a json for transmission to the api. This
 * function would be part of the standard frontend library used in all
 * pages.
 *
 * @param {string} formId the formId selector
 * @returns {Object} the product JSON
 */
const formToJSON = (formId) => {
    formId = formId.startsWith('#') ? formId : `#${formId}`;

    let form = $(formId).serializeArray();
    let formJSON = {};

    form.forEach(({name, value}) => {
        formJSON[name] = value;
    });

    return formJSON;
}

/**
 * Appends a new product to the #products div
 *
 * @param {Product} product the new product to display
 */
const newProduct = (product) => {
    $('#products').append(
        $('<div>', {id: product.id, class: "product"}).append(
            $('<h3>', {class: "product-name"}).text(product.name),
            $('<p>', {class: "product-description"}).text(product.description),
            $('<h3>', {class: "product-price"}).text(product.price)
        )
    );
}

/**
 * Prepends a new product error to the #products div
 *
 * @param {string} msg the error message
 */
const newProductError = (msg) => {
    $('#new-product-form').prepend(
        $('<div>', {class: "error"}).text(msg)
    );
}

/**
 * prevents the form from submitting in the default manor. allows ajax
 * request to be made instead and prevents page from refreshing.
 */
$('#new-product-form').on('submit', (event) => {
    event.preventDefault();

    $.ajax({
        url: "/products/api/next_id"
    }).then((id) => {
        $('#product-id').val(id);

        return $.ajax({
            url: '/products/api/new',
            method: 'POST',
            data: JSON.stringify(formToJSON('new-product-form')),
            contentType: "application/json; charset=utf-8"
        });
    }).done((response, statusText, xhr) => {
        newProduct(response.product);
    }).fail((xhr) => {
        newProductError(xhr.responseJSON?.message || 'Failed to reach server');
    });
});

/**
 * @typedef {Object} Product a mirror type declaration of the java object
 * @property {number} id the product id
 * @property {string} name the product name
 * @property {string} description the product description
 * @property {number} price the product price
 */