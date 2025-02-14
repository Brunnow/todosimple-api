package com.brunow.todosimple.models;




import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

import org.apache.catalina.User;

@Entity
@Table(name = user.TABLE_NAME)
public class user {

    public interface CreateUser {
    }
    public interface Updateuser {
    
        
    }

    public static final String TABLE_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "username", length = 100, nullable = false, unique = true)
    @NotNull(groups = CreateUser.class)
    @NotEmpty(groups = CreateUser.class)
    @Size(groups = CreateUser.class, min = 2, max = 100)
    private String username;

    //@JsonProperty(acess = Access.WRITE_ONLY)
    @Column(name = "password", length = 60, nullable = false)
    @NotNull (groups = {CreateUser.class, Updateuser.class})
    @NotEmpty(groups = {CreateUser.class, Updateuser.class})
    @Size(groups = {CreateUser.class, Updateuser.class}, min = 8, max = 60)
    private String password;

    //private List<Taks> task = new ArrayList<>();

    public user(){

    }
    public user(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        user user = (user) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }



    @Override
    public int hashCode(){
        final int prime = 31; 
        int result = 1;
        result = prime * result +((this.id == null )? 0 : this.id.hashCode());
        return result;
    }

}
