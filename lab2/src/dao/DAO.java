package dao;

import java.sql.Connection;

public abstract class DAO<T> {
    protected Connection connect = null;

    public DAO(Connection conn) {
        this.connect = conn;
    }

    public abstract T find(int id);

    public abstract boolean create(T obj);

    public abstract boolean update(T obj);

    public abstract boolean delete(T obj);
}
