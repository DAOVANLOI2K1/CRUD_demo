package rk25finalexam.demo.Entities;

import lombok.Data;
import org.hibernate.annotations.Where;
import rk25finalexam.demo.Common.Constants;

import javax.persistence.*;
import java.text.ParseException;

@Entity
@Table(name = "account")
@Data
@Where(clause = "is_deleted = 0")
public class Account extends CommonEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", unique = true, nullable = false, length = 50)
    private String username;

    @Column(name = "password", unique = true, nullable = false, length = 800)
    private String password;

    @Column(name = "first_name", unique = true, nullable = false, length = 50)
    private String firstname;

    @Column(name = "last_name", unique = true, nullable = false, length = 50)
    private String lastname;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Constants.ROLE role;

    @Override
    public void prePersist(){
        super.prePersist();
        this.role = Constants.ROLE.EMPLOYEE;
    }

    @OneToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;
}
