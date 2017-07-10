package edu.bionic.presentation.console;

import edu.bionic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductConsoleController {

    private ProductService productService;

    @Autowired
    public ProductConsoleController(ProductService productService) {
        this.productService = productService;
    }

    public void printAllProducts() {
        productService.getAll().forEach(product -> System.out.println(product.printInfo()));
    }
}
