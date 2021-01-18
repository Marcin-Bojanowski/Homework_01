package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.coderslab.qualifier.Logger;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryCustomerRepository implements CustomerRepository {
    private List<Customer> customerList=new ArrayList<>();

    private CustomerLogger customerLogger;

    @Override

    public void addCustomer(Customer customer) {
        this.customerList.add(customer);
        customerLogger.log();
    }

    @Override
    public void deleteCustomer() {
        customerLogger.log();
    }

    @Override
    public void getCustomerList() {
        customerLogger.log();
    }

    public CustomerLogger getCustomerLogger() {
        return customerLogger;
    }
    @Autowired
    @Logger
    public void setCustomerLogger(CustomerLogger customerLogger) {
        this.customerLogger = customerLogger;
    }
}
