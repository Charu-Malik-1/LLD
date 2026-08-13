package bms.demo.lld.models;

//import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
public class BaseModel {

//    @CreatedDate
//    @Column(nullable = false,updatable = false)
    private Date createdAt;

//    @LastModifiedDate
//    @Column(nullable = false)
    private Date updatedAt;
    public BaseModel(){
        this.createdAt= new Date();
        this.updatedAt=new Date();
    }
}
