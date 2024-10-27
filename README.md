# Ajax (JQuery) vs Pure Thymeleaf

A short program/demo that shows the differences in functionality and implementation between building
a pure thymeleaf multipage application and a hybrid Ajax (JQuery) and thymeleaf application.

This project uses the swing boot java framework, but should be a good illustration as to what the
differences would be in any compatible frameworks.

## Overview

Both versions produce identical pages, on which a list of products stored in the system (as a member
variable `products` of the `Products` class). Each page also allows you to attempt to add a new
product into the system.

## Demo Links

Pure Thymeleaf implementation:
 - code [Controller](src/main/java/com/secretsheppy/ajax_vs_thymleaf/controllers/ProductsController.java)
 - code [Template](src/main/resources/templates/thymeleaf.html)
 - demo [localhost](http://localhost/products/thymeleaf)

Ajax Implementation:
 - code [Controller](src/main/java/com/secretsheppy/ajax_vs_thymleaf/controllers/ProductsRestController.java)
 - code [Template](src/main/resources/templates/ajax.html)
 - demo [localhost](http://localhost/products/ajax)