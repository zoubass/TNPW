package cz.tnpwteam.model;

import javax.persistence.*;

/**
 * Created by Admin on 19.4.2016.
 */
@Entity
@Table(name = "authorities")
public class Authorities {
    private Integer id;
    private String username;
    private AuthoritiesEnum authority;


    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "authority")
    public AuthoritiesEnum getAuthority() {
        return authority;
    }

    public void setAuthority(AuthoritiesEnum authority) {
        this.authority = authority;
    }

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
