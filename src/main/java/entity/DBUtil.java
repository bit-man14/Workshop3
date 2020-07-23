package entity;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
    private static final Logger log = LogManager.getLogger(DBUtil.class);
    private static final String DB_URL = "jdbc:mysql://localhost:3306/workshop3?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "coderslab";
    //podłączenie do bazy
    public static Connection conn() {
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                //Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            log.debug("Conn failed");
        }
        return conn();
    }
    
    //executeUpdate - zmiany w tabeli
    public static int execUpdate(Connection conn, String sql, String... params) {
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            return statement.executeUpdate();
        } catch (SQLException sq) {
            System.out.println("SQL error, check integrity constraints");
            //sq.printStackTrace();
            return -1;
        }
    }
    
    
    //executeQuery - odczyt z tabeli
    public static void execSelect(Connection conn, String query, String... columnNames) {
        
        try (PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                for (String param : columnNames) {
                    System.out.print((resultSet.getString(param)) + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void printData(Connection conn, String query, String... columnNames) {
        
        try (PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                for (String param : columnNames) {
                    System.out.print(StringUtils.rightPad(resultSet.getString(param),20));
                    
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<String> dataToList(Connection conn, String query, String... columnNames) {
        List<String> list=new ArrayList<>();
        //StringBuilder row = new StringBuilder();
        try (PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                List<String> rowList=new ArrayList<>();
                for (String param : columnNames) {
                    rowList.add(resultSet.getString(param));
                    ////row.append(resultSet.getString(param)).append(";");
                   ////list.add(resultSet.getString(param));
                }
                list.add(rowList.toString());
                ////row = new StringBuilder();
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    //return field value
    public static String returnVal(Connection conn, String query, String... columnNames) {
      String result=null;
        try (PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                for (String param : columnNames) {
                    result=resultSet.getString(param);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
