package pl.coderslab.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "pl.coderslab")
public class AppConfig {
    @Bean
    public String firstFilename() {
        return "firstFilename.txt";
    }

    @Bean
    public String secondFilename() {
        return "secondFilename.txt";
    }

    @Primary
    @Bean
    public String getUrl() {
        return "jdbc:mysql://localhost:3306/spring?serverTimezone=UTC";
    }

    @Bean
    public String getUserName() {
        return "root";
    }

    @Bean
    public String getPassword() {
        return "coderslab2020";
    }
    @Bean
    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(getUrl(), getUserName(), getPassword());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }
}

