package model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import model.enums.Level;
import model.enums.Name;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String username;
    private String password;
    private String fullName;
    private String email;
    private Name role;
    private Level level;
}

