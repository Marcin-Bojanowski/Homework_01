package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.coderslab.qualifier.Logger;

import java.sql.*;
import java.time.LocalDateTime;

@Component
public class DBCustomerRepository implements CustomerRepository {
    private CustomerLogger customerLogger;
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    @Autowired
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public CustomerLogger getCustomerLogger() {
        return customerLogger;
    }

    @Autowired
    @Logger
    public void setCustomerLogger(CustomerLogger customerLogger) {
        this.customerLogger = customerLogger;
    }

    @Override
    public void addCustomer(Customer customer) {
        try (PreparedStatement statement = connection.prepareStatement("insert into users (first_name, last_name)\n" +
                "values (?,?)")) {
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
customerLogger.log();
    }

    @Override
    public void deleteCustomer() {

    }

    @Override
    public void getCustomerList() {

    }
}
