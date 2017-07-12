package edu.bionic;

import edu.bionic.presentation.console.OrderConsoleController;
import edu.bionic.presentation.console.ProductConsoleController;
import edu.bionic.presentation.console.ResponceConsoleController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleApplication {

    private static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    private static ProductConsoleController productController;
    private static OrderConsoleController orderConsoleController;
    private static ResponceConsoleController responceConsoleController;

    public static void main(String[] args) throws IOException {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring/spring-app.xml"});

        productController = context.getBean("productConsoleController", ProductConsoleController.class);
        orderConsoleController = context.getBean("orderConsoleController", OrderConsoleController.class);
        responceConsoleController = context.getBean("responceConsoleController",ResponceConsoleController.class);
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
        System.out.println("33. Вивести все отзиви");
        int enteredNumber = Integer.parseInt(consoleReader.readLine());
        if (enteredNumber == 0) {
            orderConsoleController.saveOrder();
            startPage();
        }else if (enteredNumber == 33){
            System.out.println("All Responce");
            responceConsoleController.printAllResponceAllProduct();
        }
        else {

            productController.printProductByID(enteredNumber);

            responceConsoleController.printResponceByIdProduct(enteredNumber);
            System.out.println("1. Купить продукт");
            System.out.println("2. Return to start");
            System.out.println("3. Оставить отзив");
            int enteredNumberForResponce = Integer.parseInt(consoleReader.readLine());
            if (enteredNumberForResponce == 1) {
                orderConsoleController.addProductToBasket(enteredNumber);
            } else if (enteredNumberForResponce == 3) {
                System.out.println("NAME");
                String nameBuyer = consoleReader.readLine();
                System.out.println("TEXT");
                String text = consoleReader.readLine();
                System.out.println("RATING");
                Integer rating = Integer.parseInt(consoleReader.readLine());
                responceConsoleController.doResponce(enteredNumber, nameBuyer, text, rating);
            }
        }
        System.out.println("--------------------------------------");
        byuProducts();
    }

    private static void printOrders() throws IOException {
        orderConsoleController.printPreviousOrders();
        System.out.println("--------------------------------------");
        startPage();
    }

    private static void askAboutResponse() {

    }
}
