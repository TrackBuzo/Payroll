
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author CHIBUZOR
 */
public class DBConnection {

    private static Connection con;

    private static Connection getConnection() throws SQLException {
        if (con == null) {
            con = DriverManager.getConnection("jdbc:mysql://localhost/payroll", "root ", "");
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
    
    public static ArrayList<HashMap<String, String>> getStaffTable() throws SQLException{
        String query = "select * from staff"; 
        ResultSet rs = executeQuery(query);
        ResultSetMetaData metaData = rs.getMetaData();
        ArrayList<HashMap<String, String>> table = new ArrayList<>();
        while(rs.next()){
            HashMap<String,String> employee = new HashMap<>();
            for(int i = 1; i <= metaData.getColumnCount(); i++){
                employee.put(metaData.getColumnLabel(i), rs.getString(i));
            }
            table.add(employee);
        }
        return table;
    }

    public static ArrayList<HashMap<String, String>> getDepartmentTable() throws SQLException{
        String query = "select * from department"; 
        ResultSet rs = executeQuery(query);
        ResultSetMetaData metaData = rs.getMetaData();
        ArrayList<HashMap<String, String>> table = new ArrayList<>();
        while(rs.next()){
            HashMap<String,String> department = new HashMap<>();
            for(int i = 1; i <= metaData.getColumnCount(); i++){
                department.put(metaData.getColumnLabel(i), rs.getString(i));
            }
            table.add(department);
        }
        return table;
    }

    public static ArrayList<HashMap<String, String>> getPayTable() throws SQLException{
        String query = "select * from pay";       
        ResultSet rs = executeQuery(query);
        ResultSetMetaData metaData = rs.getMetaData();
        ArrayList<HashMap<String, String>> table = new ArrayList<>();
        while(rs.next()){
            HashMap<String,String> pay = new HashMap<>();
            for(int i = 1; i <= metaData.getColumnCount(); i++){
                pay.put(metaData.getColumnLabel(i), rs.getString(i));
            }
            table.add(pay);
        }
        return table;
    }

    public static ArrayList<HashMap<String, String>> getPaymentsTable() throws SQLException{
        String query = "select * from payment";    
        ResultSet rs = executeQuery(query);
        ResultSetMetaData metaData = rs.getMetaData();
        ArrayList<HashMap<String, String>> table = new ArrayList<>();
        while(rs.next()){
            HashMap<String,String> payment = new HashMap<>();
            for(int i = 1; i <= metaData.getColumnCount(); i++){
                payment.put(metaData.getColumnLabel(i), rs.getString(i));
            }
            table.add(payment);
        }
        return table;
    }
}
