package cz.tnpwteam.dto;

import cz.tnpwteam.model.Authorities;
import cz.tnpwteam.model.AuthoritiesEnum;
import cz.tnpwteam.model.User;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.validation.constraints.NotNull;

/**
 * Created by Admin on 16.6.2016.
 */
public class UserDto {
    @NotNull
    private User user;
    private Authorities authorities;

    public UserDto() {}

    public UserDto(User user, Authorities authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Authorities getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Authorities authorities) {
        this.authorities = authorities;
    }
}
