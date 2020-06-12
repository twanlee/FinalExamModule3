package dao.impl;

import com.mysql.jdbc.PreparedStatement;
import dao.ProductDAO;
import model.Product;
import utils.Constant;
import utils.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl  implements ProductDAO {
    DBConnection connection = DBConnection.getInstance();
    @Override
    public List<Product> selectAll() throws SQLException {
        PreparedStatement statement = (PreparedStatement) connection.getConnection().prepareStatement(Constant.SELECT_ALL_PRODUCT);
        List<Product> products = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            int productId = resultSet.getInt(1);
            String productName= resultSet.getString(2);
            double price = resultSet.getDouble(3);
            int quantity = resultSet.getInt(4);
            String color = resultSet.getString(5);
            String cate = resultSet.getString(6);
            products.add(new Product(productId,productName,price,quantity,color,cate));
        }

        return products;
    }

    @Override
    public List<Product> findByName(String name) throws SQLException {
        List<Product> products = new ArrayList<>();
        java.sql.PreparedStatement statement = connection.getConnection().prepareStatement(Constant.FIND_PRODUCT_BY_NAME);
        statement.setString(1,"%"+name+"%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            int productId = resultSet.getInt(1);
            String productName= resultSet.getString(2);
            double price = resultSet.getDouble(3);
            int quantity = resultSet.getInt(4);
            String color = resultSet.getString(5);
            String cate = resultSet.getString(6);
            products.add(new Product(productId,productName,price,quantity,color,cate));
        }

        return products;
    }

    @Override
    public Product findById(int id) throws SQLException {
        java.sql.PreparedStatement statement = connection.getConnection().prepareStatement(Constant.SELECT_PRODUCT_ID);
        statement.setInt(1,id);
        Product product = null;
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            int productId = resultSet.getInt(1);
            String productName= resultSet.getString(2);
            double price = resultSet.getDouble(3);
            int quantity = resultSet.getInt(4);
            String color = resultSet.getString(5);
            String cate = resultSet.getString(6);
            product = new Product(productId,productName,price,quantity,color,cate);
        }
        return product;
    }

    @Override
    public void deleteProduct(int id) throws SQLException {
        java.sql.PreparedStatement statement = connection.getConnection().prepareStatement(Constant.DELETE_PRODUCT_ID);
        statement.setInt(1,id);
        statement.executeUpdate();
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        java.sql.PreparedStatement statement = connection.getConnection().prepareStatement(Constant.UPDATE_PRODUCT);
        statement.setInt(1,product.getProductId());
        statement.setString(2,product.getProductName());
        statement.setDouble(3,product.getPrice());
        statement.setInt(4,product.getQuantity());
        statement.setString(5,product.getColor());
        statement.executeUpdate();

    }

    @Override
    public void addProduct(Product product) throws SQLException {
        java.sql.PreparedStatement statement = connection.getConnection().prepareStatement(Constant.ADD_PRODUCT);
        statement.setString(1,product.getProductName());
        statement.setDouble(2,product.getPrice());
        statement.setInt(3,product.getQuantity());
        statement.setString(4,product.getColor());
        statement.setInt(5,product.getCategory_id());
        statement.executeUpdate();

    }
}
