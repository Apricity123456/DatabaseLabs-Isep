package dao;

import model.Emp;
import java.sql.*;

public class EmpDAO extends DAO<Emp> {
    public EmpDAO(Connection conn) {
        super(conn);
    }

    @Override
    public Emp find(int id) {
        Emp emp = null;
        try {
            PreparedStatement stmt = connect.prepareStatement("SELECT * FROM emp WHERE empno = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int mgrId = rs.getInt("mgr");
                Emp mgr = null;
                if (!rs.wasNull()) {
                    mgr = this.find(mgrId);
                }
                emp = new Emp(
                        rs.getInt("empno"),
                        rs.getString("ename"),
                        rs.getString("job"),
                        mgr,
                        rs.getDate("hiredate"),
                        rs.getDouble("sal"),
                        rs.getObject("comm") != null ? rs.getDouble("comm") : null,
                        rs.getInt("deptno")
                );
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public boolean create(Emp emp) { return false; }

    @Override
    public boolean update(Emp emp) { return false; }

    @Override
    public boolean delete(Emp emp) { return false; }
}
