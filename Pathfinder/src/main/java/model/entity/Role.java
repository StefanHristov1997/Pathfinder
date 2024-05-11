package model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import model.enums.Name;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    private Name name;
}
