package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CHIBUZOR
 */
public class DatabaseImpl {

    private static Connection con;

    private static Connection getConnection() throws SQLException {
        if (con == null) {
            con = DriverManager.getConnection("jdbc:mysql://localhost/payroll", "root", "");
            con.setAutoCommit(false);
        }
        return con;
    }

    public static ResultSet executeQuery(String query) throws SQLException {
        Statement s = getConnection().createStatement();
        return s.executeQuery(query);
    }

    public static boolean executeUpdate(String query) throws SQLException {
        Statement s = getConnection().createStatement();
        int rows = s.executeUpdate(query);
        getConnection().commit();
        return rows > 0;
    }

    public static boolean executeBatch(String[] queries) throws SQLException {
        boolean success = true;
        Statement s = getConnection().createStatement();
        for (String string : queries) {
            s.addBatch(string);
        }
        int[] res = s.executeBatch();
        for (int i : res) {
            if (i == Statement.EXECUTE_FAILED) {
                System.err.println("Error on query at index " + i);
                success = false;
            }
        }
        if (success) {
            getConnection().commit();
        } else {
            getConnection().rollback();
        }
        return success;
    }

    public static ArrayList<HashMap<String, String>> getStaffTable() throws SQLException {
        String query = "select * from staff";
        ResultSet rs = executeQuery(query);
        ResultSetMetaData metaData = rs.getMetaData();
        ArrayList<HashMap<String, String>> table = new ArrayList<>();
        while (rs.next()) {
            HashMap<String, String> employee = new HashMap<>();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                employee.put(metaData.getColumnLabel(i), rs.getString(i));
            }
            table.add(employee);
        }
        return table;
    }

    public static HashMap<String, String> getStaff(String id) throws SQLException {
        String query = "select * from staff where " + StaffTable.STAFF_ID + " = '" + id + "'";
        ResultSet rs = executeQuery(query);
        ResultSetMetaData metaData = rs.getMetaData();
        HashMap<String, String> employee = new HashMap<>();
        if (rs.next()) {
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                employee.put(metaData.getColumnLabel(i), rs.getString(i));
            }
        }
        return employee;
    }

    public static ArrayList<HashMap<String, String>> getDepartmentsTable() throws SQLException {
        String query = "select * from departments";
        ResultSet rs = executeQuery(query);
        ResultSetMetaData metaData = rs.getMetaData();
        ArrayList<HashMap<String, String>> table = new ArrayList<>();
        while (rs.next()) {
            HashMap<String, String> department = new HashMap<>();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                department.put(metaData.getColumnLabel(i), rs.getString(i));
            }
            table.add(department);
        }
        return table;
    }

    public static HashMap<String, String> getDepartment(String id) throws SQLException {
        String query = "select * from departments where " + DepartmentsTable.DEPARTMENT_ID + " = '" + id + "'";
        ResultSet rs = executeQuery(query);
        ResultSetMetaData metaData = rs.getMetaData();
        HashMap<String, String> department = new HashMap<>();
        if (rs.next()) {
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                department.put(metaData.getColumnLabel(i), rs.getString(i));
            }
        }
        return department;
    }

    public static ArrayList<HashMap<String, String>> getDesignationsTable() throws SQLException {
        String query = "select * from designations";
        ResultSet rs = executeQuery(query);
        ResultSetMetaData metaData = rs.getMetaData();
        ArrayList<HashMap<String, String>> table = new ArrayList<>();
        while (rs.next()) {
            HashMap<String, String> pay = new HashMap<>();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                pay.put(metaData.getColumnLabel(i), rs.getString(i));
            }
            table.add(pay);
        }
        return table;
    }

    public static HashMap<String, String> getDesignation(String name) throws SQLException {
        String query = "select * from designations where " + DesignationsTable.NAME + " = '" + name + "'";
        ResultSet rs = executeQuery(query);
        ResultSetMetaData metaData = rs.getMetaData();
        HashMap<String, String> pay = new HashMap<>();
        if (rs.next()) {
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                pay.put(metaData.getColumnLabel(i), rs.getString(i));
            }
        }
        return pay;
    }

    public static ArrayList<HashMap<String, String>> getPaymentsTable() throws SQLException {
        String query = "select * from payments";
        ResultSet rs = executeQuery(query);
        ResultSetMetaData metaData = rs.getMetaData();
        ArrayList<HashMap<String, String>> table = new ArrayList<>();
        while (rs.next()) {
            HashMap<String, String> payment = new HashMap<>();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                payment.put(metaData.getColumnLabel(i), rs.getString(i));
            }
            table.add(payment);
        }
        return table;
    }

    public static HashMap<String, String> getPayment(String staffId, String dateOfPayment) throws SQLException {
        String query = "select * from payments where " + PaymentsTable.STAFF_ID + " = '" + staffId + "' "
                + "and " + PaymentsTable.DATE_OF_PAYMENT + " = '" + dateOfPayment + "'";
        ResultSet rs = executeQuery(query);
        ResultSetMetaData metaData = rs.getMetaData();
        HashMap<String, String> payment = new HashMap<>();
        if (rs.next()) {
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                payment.put(metaData.getColumnLabel(i), rs.getString(i));
            }
        }
        return payment;
    }

    public static boolean addEmployee(HashMap<String, String> employee) {
        if (employee == null || employee.isEmpty()) {
            return false;
        }

        StringBuilder query = new StringBuilder("insert into staff set ");
        for (Map.Entry<String, String> entrySet : employee.entrySet()) {
            String field = entrySet.getKey();
            String value = entrySet.getValue();

            query.append(field);
            query.append("=");
            query.append("\'");
            query.append(value);
            query.append("\'");
            query.append(",");
        }
        query.deleteCharAt(query.length() - 1); //Delete last inserted comma

        try {
            return executeUpdate(query.toString());
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean updateEmployee(String id, HashMap<String, String> employee) {
        if (employee == null || employee.isEmpty()) {
            return false;
        }

        StringBuilder query = new StringBuilder("update staff set ");
        for (Map.Entry<String, String> entrySet : employee.entrySet()) {
            String field = entrySet.getKey();
            String value = entrySet.getValue();

            query.append(field);
            query.append("=");
            query.append("\'");
            query.append(value);
            query.append("\'");
            query.append(",");
        }
        query.deleteCharAt(query.length() - 1); //Delete last inserted comma
        query.append(" where staff_id = \"").append(id).append("\"");

        try {
            return executeUpdate(query.toString());
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
