package me.anna.contactapp.models;

import com.sun.org.glassfish.gmbal.NameValue;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;


@Entity
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=1, max=50, message = "Must enter your first name.")
    @NameValue
    private String firstName;

//    @NotNull
//    @Size(min=1, max=50, message = "Must enter your last name.")
    @NameValue
    private String lastName;

    @NotNull
    @Size(min=1, max=50, message = "Must enter your email address.")
    @Email
    private String emailAddress;



//    NotNull
//    @Pattern(regexp="\\d{10}")
//
////    @Size(min=1, message = "Must enter your phone number.")
//    private String phoneNumber;



   // @Digits(integer=, fraction=0, message = "Must enter your 10 digits phone number (1234567890)")
//    @Digits(10)//, message = "Must enter your 10 digits phone number (1234567899).")
    @Min(1000000000)
    @Max(9999999999L)
    private long phoneNumber;

//    NotNull
//    @Range(min=1000000000, max=9999999999l)
//    private Long phoneNumber;


    // ===== Setters and Getters: =====
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }




}
