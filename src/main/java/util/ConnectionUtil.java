package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static Connection getConnection(){
        Connection conn = null;
        /// System.getenv() is how we retrieve environment variables from our machine
        String url = "jdbc:postgresql://" + System.getenv("AWS_RDS_ENDPOINT") + "/project-1";
        String username = System.getenv("RDS_USERNAME");
        String password = System.getenv("RDS_PASSWORD");
        System.out.println(username);
        try {
            conn = DriverManager.getConnection(url, username, password);
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

        return conn;
    }
}
