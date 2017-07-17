package edu.bionic.presentation.servlet.calc;

/**
 * Created by bm on 14.07.17.
 */


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class Process extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter printWriter = res.getWriter();
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String input = req.getParameter("input");
        printWriter.println(calC(num1, input, num2));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private double calC(String inputNum1, String input, String inputNum2) {
        double num1 = Double.parseDouble(inputNum1);
        double num2 = Double.parseDouble(inputNum2);
        if (input.equals("+")) {
            return num1 + num2;
        } else if (input.equals("-")) {
            return num1 - num2;

        } else if (input.equals("*")) {
            return num1 * num2;
        } else if (input.equals("/")) {
            return num1 / num2;
        } else return -1;
    }
}





