package pl.coderslab.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.coderslab.beans.*;
import pl.coderslab.config.AppConfig;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Customer customer = new Customer("Marcin", "Bojanowski");
        CustomerRepository customerRepository = context.getBean(DBCustomerRepository.class);
        customerRepository.addCustomer(customer);
        context.close();
    }
}
