package com.example.demo.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
@Table(name="user_t")
public class User {

    public enum Role {
        Admin,Normal
    }

    @Id
    private String id;
    private String username;
    private String password;
    private String telephone;

    @Convert(converter = RoleConverter.class)
    private List<Role> roles;

    private static class RoleConverter implements AttributeConverter<List, String> {

        @Override
        public String convertToDatabaseColumn(List o) {
            if (o.isEmpty()) {
                return "";
            }

            StringBuilder builder = new StringBuilder();
            for (Role s : (List<Role>) o) {
                builder.append(s).append(",");
            }
            return builder.substring(0, builder.length() - 1);
        }

        @Override
        public List convertToEntityAttribute(String o) {
            String[] items = o.split(",");
            List<Role> list = new ArrayList<>();
            for (String item : items) {
                list.add(Role.valueOf(item));
            }
            return list;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + username + '\'' +
                ", telephone=" + telephone+ '\'' +
                ", roles=" + roles    +
                '}';
    }

}

