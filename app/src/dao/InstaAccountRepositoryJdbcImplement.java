package dao;

import store.ProductItem;
import store.ProductItemRepository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class InstaAccountRepositoryJdbcImplement extends AbstractController<ProductItem, ProductItemRepository> {
    public static final String SqlSelectByAccountName = "SELECT *"; //instaAccountsTable
    private static final Logger logger = Logger.getLogger("InstaAccountRepositoryJdbcImplement");
    DataSource dataSource;

    public InstaAccountRepositoryJdbcImplement(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void getByName(String instaAccountName) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statemenet = connection.prepareStatement(SqlSelectByAccountName)
        ) {
            logger.info("SQL connection and query");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<ProductItem> getAll() {
        return null;
    }

    @Override
    public ProductItem getEntityById(ProductItemRepository id) {
        return null;
    }

    @Override
    public ProductItem update(ProductItem entity) {
        return null;
    }

    @Override
    public boolean delete(ProductItemRepository id) {
        return false;
    }

    @Override
    public boolean create(ProductItem entity) {
        return false;
    }
}
