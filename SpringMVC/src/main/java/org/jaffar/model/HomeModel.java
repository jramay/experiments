package org.jaffar.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.jaffar.validator.NameConstraint;

public class HomeModel {

   @NameConstraint(nameAllowed="Jaffar", message = "Name must be {nameAllowed} only !!!") 
   String firstName;

   String lastName;
   
   @NotEmpty(message="Password can't be empty")
   String password;
   String message;
   
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
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public String getMessage() {
    return message;
}
public void setMessage(String message) {
    this.message = message;
}
}
