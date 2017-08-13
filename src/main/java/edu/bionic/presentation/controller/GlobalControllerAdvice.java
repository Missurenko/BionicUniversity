package edu.bionic.presentation.controller;

import edu.bionic.domain.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("basket")
    public Order createBasket() {
        return new Order();
    }
}
