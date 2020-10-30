package online.devises.visionmatetask.model;

import javax.persistence.*;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String login;
    private String password;
    @OneToOne(targetEntity=Role.class, fetch= FetchType.EAGER, cascade = {CascadeType.ALL})
    private Role role;

    public User(){

    }

    public User(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
