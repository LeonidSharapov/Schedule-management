package example.Controller.Model;

import javax.persistence.*;

@Entity
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name="userId", unique = true)
    private int userId;
    private String name,status,password;

    public Members(int userId,String name, String status, String password) {
        this.userId=userId;
        this.name = name;
        this.status = status;
        this.password = password;
    }

    public Members() {
    }

    public int getUserId() {
    	return userId;
    }
    public void setUserId(int userId) {
    	this.userId=userId;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}