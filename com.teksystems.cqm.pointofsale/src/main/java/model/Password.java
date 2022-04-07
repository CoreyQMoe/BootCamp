package model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iD;
    @Column(nullable = false)
    private String password;
    @Column(columnDefinition = "DATETIME DEFAULT CURDATE()")
    private LocalDateTime created;
    @Column(columnDefinition = "DATETIME DEFAULT CURDATE()")
    private LocalDateTime updated;

    public Password() {
    }

    public Password(int iD, String password, LocalDateTime created, LocalDateTime updated) {
        this.iD = iD;
        this.password = password;
        this.created = created;
        this.updated = updated;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
