/*************************************************
 File: Main.java
 By: Jeanine Nebrija
 Date: 4/24/24
 Compile: Open directory as IntelliJ project, compile and run.
 System: Windows w/ Java
 Description: Implement a Builder class named BankCustomerBuilder within the BankCustomer class
               to facilitate the construction of BankCustomer objects.
 *************************************************/

import java.time.LocalDate;

public class BankCustomer {
    private int id=-1;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String sex;
    private LocalDate birthday;

    public BankCustomer(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "BankCustomer{" +
                "id = '" + id + '\'' +
                ", firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", email = '" + email + '\'' +
                ", phone = '" + phone + '\'' +
                ", sex = '" + sex + '\'' +
                ", birthday = '" + birthday + '\'' +
                '}';
    }
}

class BankCustomerBuilder {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String sex;
    private LocalDate birthday;

    public BankCustomerBuilder() {
    }

    public BankCustomerBuilder buildWithId(int id) {
        this.id = id;
        return this;
    }

    public BankCustomerBuilder buildWithFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public BankCustomerBuilder buildWithLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BankCustomerBuilder buildWithEmail(String email) {
        this.email = email;
        return this;
    }

    public BankCustomerBuilder buildWithPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public BankCustomerBuilder buildWithSex(String sex) {
        this.sex = sex;
        return this;
    }

    public BankCustomerBuilder buildWithBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public BankCustomer build() {
        BankCustomer bc=new BankCustomer(id);
        bc.setFirstName(firstName);
        bc.setLastName(lastName);
        bc.setEmail(email);
        bc.setPhone(phone);
        bc.setSex(sex);
        bc.setBirthday(birthday);
        return bc;
    }
}
