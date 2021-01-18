package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.coderslab.qualifier.Logger;

import java.sql.*;
import java.time.LocalDateTime;

@Component
@Logger
//@Primary
public class DBCustomerLogger implements CustomerLogger {

    private String url;
    private String userName;
    private String password;


    public String getUrl() {
        return url;
    }

    @Autowired
    @Qualifier("getUrl")
    public void setUrl(String url) {
        this.url = url;
    }

    public DBCustomerLogger(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    @Autowired
    @Qualifier("getUserName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    @Autowired
    @Qualifier("getPassword")
    public void setPassword(String password) {
        this.password = password;
    }


    public DBCustomerLogger(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    public DBCustomerLogger() {
    }

    @Override
    public void log() {
        try (Connection con = DriverManager.getConnection(url, userName, password);
             PreparedStatement statement = con.prepareStatement("insert into logger (timestamp, action)\n" +
                     "values (?,?)")) {
            statement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            statement.setString(2, "Customer operation");
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
