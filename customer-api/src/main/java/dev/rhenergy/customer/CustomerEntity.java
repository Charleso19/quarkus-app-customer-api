package dev.rhenergy.customer;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity(name = "Customer")
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "first_name")
    @NotEmpty
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    @NotEmpty
    private String lastName;

    @Column(name = "suffix")
    private String suffix;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "phone")
    private String phone;

    public Integer getCustomerId() {
        return customerId;
    }

    public CustomerEntity setCustomerId(Integer customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CustomerEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public CustomerEntity setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CustomerEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getSuffix() {
        return suffix;
    }

    public CustomerEntity setSuffix(String suffix) {
        this.suffix = suffix;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CustomerEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CustomerEntity setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}