package edu.bionic;

import edu.bionic.presentation.console.OrderConsoleController;
import edu.bionic.presentation.console.ProductConsoleController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleApplication {

    private static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    private static ProductConsoleController productController;
    private static OrderConsoleController orderConsoleController;

    public static void main(String[] args) throws IOException {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring/spring-app.xml"});

        productController = context.getBean("productConsoleController", ProductConsoleController.class);
        orderConsoleController = context.getBean("orderConsoleController", OrderConsoleController.class);

        startPage();
    }

    private static void startPage() throws IOException {
        System.out.println("Добро пожаловать в iStore");
        System.out.println();
        System.out.println("Выберите действие:");
        System.out.println("1. Купить товары");
        System.out.println("2. Просмотреть заказы");
        System.out.println("0. Выйти из приложения");
        switch (consoleReader.readLine()) {
            case "1":
                System.out.println("---------------------------------------");
                byuProducts();
                break;
            case "2":
                System.out.println("---------------------------------------");
                printOrders();
                break;
            case "0":
                System.exit(0);
            default:
                startPage();
        }

    }

    private static void byuProducts() throws IOException {
        orderConsoleController.printProductsInBasket();
        System.out.println("Выберите товар из списка");
        productController.printAllProducts();
        System.out.println();
        System.out.println("0. Завершить заказ");

        int enteredNumber = Integer.parseInt(consoleReader.readLine());
        if (enteredNumber == 0) {
            orderConsoleController.saveOrder();
            startPage();
        } else {
            orderConsoleController.addProductToBasket(enteredNumber);
        }
        System.out.println("--------------------------------------");
        byuProducts();
    }

    private static void printOrders() throws IOException {
        orderConsoleController.printPreviousOrders();
        System.out.println("--------------------------------------");
        startPage();
    }
}
