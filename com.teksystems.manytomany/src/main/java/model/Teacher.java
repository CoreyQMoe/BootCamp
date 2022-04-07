package model;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="Teacher")
public class Teacher{
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private int tit;
    private String salary;
    private String Teachername;

    @ManyToMany(targetEntity = Cohort.class)
    private Set CohortSet;
    public Teacher(String salary, String teachername, Set CohortSet) {
        this.salary = salary;
        this.Teachername = teachername;
        this.CohortSet = CohortSet;

    }
    public Teacher() {
        super();
    }

    public Set getCohortSet() {
        return CohortSet;
    }
    public void setCohortSet(Set cohortSet) {
        CohortSet = cohortSet;
    }
    public int getTit() {
        return tit;
    }
    public void setTit(int tit) {
        this.tit = tit;
    }
    public String getSalary() {
        return salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }
    public String getTeachername() {
        return Teachername;
    }
    public void setTeachername(String teachername) {
        Teachername = teachername;
    }
}

