package dev.rhenergy.customer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class Customer {

    private Integer customerId;

    @NotEmpty
    private String firstName;

    private String middleName;

    @NotEmpty
    private String lastName;

    private String suffix;

    @Email
    private String email;

    private String phone;

    public Integer getCustomerId() {
        return customerId;
    }

    public Customer setCustomerId(Integer customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Customer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Customer setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getSuffix() {
        return suffix;
    }

    public Customer setSuffix(String suffix) {
        this.suffix = suffix;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Customer setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(customerId, customer.customerId) && firstName.equals(customer.firstName) && Objects.equals(middleName, customer.middleName) && lastName.equals(customer.lastName) && Objects.equals(suffix, customer.suffix) && Objects.equals(email, customer.email) && Objects.equals(phone, customer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstName, middleName, lastName, suffix, email, phone);
    }
}
