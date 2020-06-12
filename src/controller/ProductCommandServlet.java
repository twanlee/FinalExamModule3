package controller;

import dao.ProductDAO;
import dao.impl.ProductDAOImpl;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductCommandServlet", urlPatterns = "/command")
public class ProductCommandServlet extends HttpServlet {
    ProductDAO productDAO = new ProductDAOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if(action==null) action="";
        try {
            switch (action){
                case "addProduct":
                    addProduct(request,response);
                    break;
                case "update":
                    updateProduct(request,response);
                    break;
                case "search":
                    showSearchResult(request,response);
                    break;
                default:
                    showProductForm(request,response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void showSearchResult(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Product> products = new ArrayList<>();
        String name = request.getParameter("name");
        products = productDAO.findByName(name);
        request.setAttribute("products",products);
        showSearchForm(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null) action="";
        try {
            switch (action){
                case "addProduct":
                    showAddform(request,response);
                    break;
                case "delete":
                    deleteProduct(request,response);
                    break;
                case "update":
                    showUpdateForm(request,response);
                    break;
                case "search":
                    showSearchForm(request,response);
                    break;
                default:
                    showProductForm(request,response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("search_form.jsp");
            dispatcher.forward(request,response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name= request.getParameter("name");
        double price = Double.valueOf(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = new Product(id,name,price,quantity,color);
        productDAO.updateProduct(product);
        request.setAttribute("message","Done");
        showUpdateForm(request,response);

    }
    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.findById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("update_form.jsp");
        dispatcher.forward(request,response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.deleteProduct(id);
        request.setAttribute("message","Done");
        showProductForm(request,response);
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Product product;
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String cate = request.getParameter("category");
        int cate_id = -1;
        if(cate.equals("mobile")){
            cate_id=1;
        }else cate_id=2;
        product = new Product(name,price,quantity,color,cate_id);
        productDAO.addProduct(product);
        request.setAttribute("message","Done");
        showAddform(request,response);

    }
    private void showAddform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add_product_form.jsp");
        dispatcher.forward(request,response);
    }

    private void showProductForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Product> products = new ArrayList<>();
        products = productDAO.selectAll();
        request.setAttribute("products",products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product_form.jsp");
        dispatcher.forward(request,response);
    }
}
