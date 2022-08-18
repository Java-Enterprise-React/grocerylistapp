package com.revature.models;


/* 
 * the models package is going to hold classes that dont have any functionality.
 *      their sole purpose is to make a new datatype that we can utilize throughout
 *      our application
 * 
 * What is encapsulation?
 *      the restriction of direct access.
 * 
 * We restrict access utilizing access modifiers
 * 
 * What are the 4 access modifiers in java?
 *     - public: can be seen in any package in java
 *     - protected: can be seen...
 *          - through the package you are currently in
 *          - through the subclasses 
 *     - default: can be seen through the package you are currently in
 *     - private: can only be seen within the class you are in
 * 
 * The general rule for achieving encapsulation in java is to...
 *          -  make your variables private
 *          -  make your getters and setters public
 * 
 * to auto generate getters
 */
public class User {
    private Integer id;

    private String username = "";
    private String password = "";
    private String firstname = "";
    private String lastname = "";

    public User(Integer id, String username, String password, String firstname, String lastname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }  

    public User(String username, String password, String firstname, String lastname) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(){
        
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    
    /* polymorphism means to take on many forms
     * 
     *  Two main types of polymorphism we see in java:
     *      - method overloading
     *          - 2 or methods with the same name but different parameters that is in the same class
     *      - method overriding
     *          - have the same method signature in the child class as the parent class
     *              - the child class overrides the method in the parent class... meaning you can no longer use the parent class if youre instantiating with the child datatype
     */



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", firstname='" + getFirstname() + "'" +
            ", lastname='" + getLastname() + "'" +
            "}";
    }

}
