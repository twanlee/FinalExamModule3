package dao;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    List<Product> selectAll() throws SQLException;
    List<Product> findByName(String name) throws SQLException;
    Product findById(int id) throws SQLException;
    void deleteProduct(int id) throws SQLException;
    void updateProduct(Product product) throws SQLException;
    void addProduct(Product product) throws SQLException;

}
