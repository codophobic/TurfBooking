package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.UserType;

@Getter
@Setter
public class User extends BaseEntity{
    private String name;
    private static int cnt = 0;
    private UserType userType;
    public User(String name,UserType userType) {
        super(cnt++);
        this.name = name;
        this.userType = userType;
    }
}
