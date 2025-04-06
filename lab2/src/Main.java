
import java.sql.*;
import dao.DeptDAO;
import dao.DAO;
import model.Dept;
import dao.DAOFactory;
import dao.DeptDAO;
import dao.EmpDAO;
import model.Dept;
import model.Emp;
public class Main {

    public static void main(String[] args) {
        // Step 1: Load the JDBC Driver
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Connect to the database
        String url = "jdbc:postgresql://localhost/lab";
        String user = "postgres";
        String pass = "123";

        Connection connection = null;
         //exercise 12 of Part2
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Bdd Connected");

            DAOFactory factory = new DAOFactory(connection);
            DeptDAO deptDao = factory.getDeptDAO();
            Dept dept = deptDao.find(10);
            System.out.println("Department: " + dept);

            EmpDAO empDao = factory.getEmpDAO();
            Emp emp = empDao.find(7839);
            System.out.println("Employee: " + emp);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException ignore) {
                ignore.printStackTrace();
            }
        }
// Part2 exercise 8-11
//        try {
//            Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection(url, user, pass);
//            System.out.println("Bdd Connected");
//
//            DAO<Dept> deptDao = new DeptDAO(connection);
//            Dept dept = deptDao.find(10);
//            System.out.println(dept);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (connection != null)
//                    connection.close();
//            } catch (SQLException ignore) {
//                ignore.printStackTrace();
//            }
//        }


// Exercise 1 -7 of Part 1
//        try {
//            connection = DriverManager.getConnection(url, user, pass);
//            System.out.println("Bdd Connected");
//
//            displayDepartment(connection);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ignore) {
//                    ignore.printStackTrace();
//                }
//            }
//        }
//    }

        // Step 4: Display departments
//    public static void displayDepartment(Connection connection) throws SQLException {
//        Statement statement = connection.createStatement();
//        ResultSet resultat = statement.executeQuery("SELECT deptno, dname, loc FROM dept");
//
//        while (resultat.next()) {
//            int deptno = resultat.getInt("deptno");
//            String dname = resultat.getString("dname");
//            String loc = resultat.getString("loc");
//
//            System.out.println("Department " + deptno + " is for " + dname + " and located in " + loc);
//        }
//
//        resultat.close();
//        statement.close();
//    }
//    public static void moveDepartment(Connection connection, int deptno,int empno) throws SQLException
//    {
//        String command = "UPDATE emp SET deptno = ? Where empno = ?";
//        try(PreparedStatement updateEmp = connection.prepareStatement(command)){
//            updateEmp.setLong(1,deptno);
//            updateEmp.setLong(2,empno);
//            updateEmp.execute();
//            System.out.println("Employee No : " + empno + "is now in the Dept No" + deptno);
//        }catch(Exception err){
//            err.printStackTrace();
//        };
//    }
//    public static void displayTable(Connection connection, String tableName) throws SQLException {
//        Statement stmt = connection.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
//        ResultSetMetaData rsmd = rs.getMetaData();
//        int columnCount = rsmd.getColumnCount();
//
//
//        for (int i = 1; i <= columnCount; i++) {
//            System.out.print(rsmd.getColumnName(i) + "\t");
//        }
//        System.out.println();
//
//
//        while (rs.next()) {
//            for (int i = 1; i <= columnCount; i++) {
//                System.out.print(rs.getString(i) + "\t");
//            }
//            System.out.println();
//        }
//
//        rs.close();
//        stmt.close();
//    }
    }
}
