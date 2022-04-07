package model;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@DynamicInsert
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iD;
    @Column(nullable = false)
    private String departmentName;
    @Column(columnDefinition = "DATETIME DEFAULT CURDATE()")
    private LocalDateTime created;
    @Column(columnDefinition = "DATETIME DEFAULT CURDATE()")
    private LocalDateTime updated;

    public Department() {
    }

    public Department(int iD, String departmentName, LocalDateTime created, LocalDateTime updated) {
        this.iD = iD;
        this.departmentName = departmentName;
        this.created = created;
        this.updated = updated;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
