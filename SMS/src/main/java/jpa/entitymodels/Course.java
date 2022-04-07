package jpa.entitymodels;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Course implements Serializable {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private int cId;
    @Column(name = "name", length = 50, nullable = false)
    private String cName;
    @Column(name = "Instructor", length = 50, nullable = false)
    private String cInstructorName;

    public Course() {
        this.cId = 0;
        this.cName = null;
        this.cInstructorName = null;
    }

    public Course(int cId, String cName, String cInstructorName) {
        this.cId = cId;
        this.cName = cName;
        this.cInstructorName = cInstructorName;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcInstructorName() {
        return cInstructorName;
    }

    public void setcInstructorName(String cInstructorName) {
        this.cInstructorName = cInstructorName;
    }
}
