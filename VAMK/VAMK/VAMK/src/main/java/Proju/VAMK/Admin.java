package Proju.VAMK;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;


@Entity

@Table
public class Admin {


    @Id
    private String username;


    @Column
    private String password;

    // Constructor for creating an Admin object with username and password
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Default constructor required by JPA
    public Admin() {

    }

    // Getters and setters
    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Equals method for comparing two Admin objects based on username and password
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admins = (Admin) o;
        return Objects.equals(username, admins.username) && Objects.equals(password, admins.password);
    }

    // ToString method for creating a string representation of the Admin object
    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}