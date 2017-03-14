package cz.tnpwteam.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Admin on 19.4.2016.
 */
@Entity
@Table(name = "users")
public class User {
    private String username;
    private String password;
    private boolean enabled;

    @Id
    @NotNull
    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    @Size(max=50)
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    @NotNull
    @Column(name = "enabled")
    public boolean getEnabled() {
        return enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
