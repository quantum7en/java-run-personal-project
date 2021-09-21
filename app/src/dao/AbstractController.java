package dao;

import java.sql.Connection;
import java.util.List;

public abstract class AbstractController <E, K> {
    //todo adapt this class to class InstaAccountRepositoryJdbcImplement?
    private Connection connection;
//    private ConnectionPool connectionPool;
//
//    public AbstractController() {
//        connectionPool = ConnectionPool.getConnectionPool();
//        connection = connectionPool.getConnection();
//    }

    public abstract List<E> getAll();
    public abstract E getEntityById(K id);
    public abstract E update(E entity);
    public abstract boolean delete(K id);
    public abstract boolean create(E entity);


}
