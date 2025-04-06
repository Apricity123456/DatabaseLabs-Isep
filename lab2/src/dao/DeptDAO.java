package dao;

import model.Dept;
import java.sql.*;

public class DeptDAO extends DAO<Dept> {
    public DeptDAO(Connection conn) {
        super(conn);
    }

    @Override
    public Dept find(int id) {
        Dept dept = null;
        try {
            PreparedStatement stmt = connect.prepareStatement("SELECT * FROM dept WHERE deptno = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                dept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
    }

    @Override
    public boolean create(Dept dept) {
        try {
            PreparedStatement stmt = connect.prepareStatement("INSERT INTO dept VALUES (?, ?, ?)");
            stmt.setInt(1, dept.getDeptno());
            stmt.setString(2, dept.getDname());
            stmt.setString(3, dept.getLoc());
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Dept dept) {
        try {
            PreparedStatement stmt = connect.prepareStatement("UPDATE dept SET dname = ?, loc = ? WHERE deptno = ?");
            stmt.setString(1, dept.getDname());
            stmt.setString(2, dept.getLoc());
            stmt.setInt(3, dept.getDeptno());
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Dept dept) {
        try {
            PreparedStatement stmt = connect.prepareStatement("DELETE FROM dept WHERE deptno = ?");
            stmt.setInt(1, dept.getDeptno());
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
