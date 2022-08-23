package rk25finalexam.demo.Entities;

import lombok.Data;
import org.hibernate.annotations.Where;
import rk25finalexam.demo.Common.Constants;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "department")
@Data
@Where(clause = "is_deleted = 0")
public class Department extends CommonEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "total_member")
    private Integer totalMember;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Constants.TYPE type;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Override
    public void prePersist(){
        super.prePersist();
        if(this.createdDate == null) {
            this.createdDate = new Date();
        }
    }
}
