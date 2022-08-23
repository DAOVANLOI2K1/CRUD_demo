package rk25finalexam.demo.Entities;

import lombok.Data;
import rk25finalexam.demo.Common.Constants;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

@Data
@MappedSuperclass
public class CommonEntity {

    @Column(name = "is_deleted")
    private Integer isDeleted;

    @PrePersist
    public void prePersist(){
        this.isDeleted = Constants.IS_DELETED.FALSE;
    }
}
