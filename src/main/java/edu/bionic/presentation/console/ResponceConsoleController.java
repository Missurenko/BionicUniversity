package edu.bionic.presentation.console;

import edu.bionic.domain.Product;
import edu.bionic.domain.Response;
import edu.bionic.service.ResponceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

/**
 * Created by bm on 10.07.17.
 */
@Controller
public class ResponceConsoleController {

    private ResponceService responceService;


    @Autowired
    public ResponceConsoleController(ResponceService responceService) {
        this.responceService = responceService;
    }

    public void printResponceByIdProduct(Integer productId) {
        System.out.println( responceService.getByIdProduct(productId).printInfo());

    }

    public void printAllResponceAllProduct( ) {

        responceService.getAll().forEach(response -> System.out.println(response.printInfo()));
    }

    public void doResponce(Integer idProduct, String nameBuyer, String text, Integer rating) {
        responceService.createNewResponce(idProduct, nameBuyer, text, rating);
    }

}
