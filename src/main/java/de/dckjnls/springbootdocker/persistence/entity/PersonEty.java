package de.dckjnls.springbootdocker.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "person")
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PersonEty {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_id")
    @SequenceGenerator(name = "project_id", sequenceName = "project_id", allocationSize = 1)
    private Long id;

    private String firstName;

    private String lastName;

    public PersonEty(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
