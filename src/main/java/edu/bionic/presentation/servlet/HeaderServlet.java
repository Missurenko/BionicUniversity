package edu.bionic.presentation.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by bm on 14.07.17.
 */
@WebServlet("/header")
public class HeaderServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            handleRequest(req,resp);
//            req.getRequestDispatcher("header.jsp").forward(req,resp);
        }
        @Override
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            handleRequest(request,response);
        }

        public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {

            PrintWriter out = res.getWriter();
            res.setContentType("text/plain");

            Enumeration<String> headerNames = req.getHeaderNames();

            while (headerNames.hasMoreElements()) {

                String headerName = headerNames.nextElement();

                out.write(headerName + "\n");

                out.write("n");

                Enumeration<String> headers = req.getHeaders(headerName);

                while (headers.hasMoreElements()) {

                    String headerValue = headers.nextElement();

                    out.write("t" + headerValue);

                    out.write("n");

                }
            }

            out.close();

        }

}
