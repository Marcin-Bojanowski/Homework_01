package pl.coderslab.beans;

public interface CustomerRepository {
    void addCustomer(Customer customer);

    void deleteCustomer();

    void getCustomerList();
}

