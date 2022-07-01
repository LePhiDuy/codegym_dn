package repository;

import module.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductReopsitoryImpl implements IProductRepository {
    public static final String SELECT_FROM_PRODUCT = "select * from product";
    public static final String INSERT = "insert into product(name, price, color) value (?, ?, ?)";
    public static final String UPDATE = "update product set name = ?, price = ?, color = ? where id = ?";
    public static final String SEARCH = "select * from product where id = ?";
    public static final String DELETE = "delete from product where id = ?";

    @Override
    public List<Product> findAll() {
        Connection connection = DbConnection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        List<Product> products = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(SELECT_FROM_PRODUCT);
                Product product = null;
                while (resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    double price = resultSet.getDouble(3);
                    String color = resultSet.getString(4);
                    product = new Product(id, name, price, color);
                    products.add(product);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DbConnection.close();
            }
        }
        return products;
    }
    @Override
    public void save(Product product) {
        Connection connection = DbConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(product.getId() > 0 ? UPDATE : INSERT);
                statement.setString(1, product.getName());
                statement.setDouble(2, product.getPrice());
                statement.setString(3, product.getColor());
                if (product.getId() > 0) {
                    statement.setInt(4, product.getId());
                }
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DbConnection.close();
            }
        }
    }
    @Override
    public boolean remove(int id) {
        boolean isDeleteSuccess = false;
        Connection connection = DbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE);
                preparedStatement.setInt(1, id);
                isDeleteSuccess = preparedStatement.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isDeleteSuccess;
    }
    @Override
    public Product searchByID(int id) {
        Product product = null;
        Connection connection = DbConnection.getConnection();
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int idResult = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    double price = resultSet.getDouble(3);
                    String color = resultSet.getString(4);
                    product = new Product(idResult, name, price, color);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return product;
    }
}
