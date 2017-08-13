package edu.bionic.presentation.controller;

import edu.bionic.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.format.DateTimeFormatter;

@Controller
@SessionAttributes("basket")
@RequestMapping("orders")
public class OrderController {

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d-MM-yyyy HH:mm");

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String showOrders(Model model) {
        model.addAttribute("orders", orderService.getAll());
        model.addAttribute("dateTimeFormatter", dateTimeFormatter);

        return "order-list";
    }
}
