package com.shz.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SysUser implements UserDetails {

    private Integer id;
    private String username;
    private String password;
    private String realname;
    private boolean isExpired;
    private boolean isLocked;
    private boolean isCredentials;
    private boolean isEnabled;

    private Date createTime;
    private Date loginTime;

    private List<GrantedAuthority> authorities;

    public SysUser(){}

    public SysUser(String username, String password, String realname,
                   boolean isExpired, boolean isLocked, boolean isCredentials, boolean isEnabled, Date createTime,
                   Date loginTime, List<GrantedAuthority> authorities){
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.isExpired = isExpired;
        this.isLocked = isLocked;
        this.isCredentials = isCredentials;
        this.createTime = createTime;
        this.loginTime = loginTime;
        this.authorities = authorities;
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return null;
    }

    public String getUsername() {
        return null;
    }


    public boolean isAccountNonExpired() {
        return isExpired;
    }

    public boolean isAccountNonLocked() {
        return isLocked;
    }

    public boolean isCredentialsNonExpired() {
        return isCredentials;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}
