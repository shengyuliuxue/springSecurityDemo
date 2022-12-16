package com.shz.service;

import com.shz.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("myUserDetailService")
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserInfoService userInfoService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        UserInfo userInfo = null;
        User user = null;
        if(username != null){
            userInfo = userInfoService.findUserInfo(username);
            if(userInfo != null){
                List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+userInfo.getRole());
                grantedAuthorityList.add(authority);
                user = new User(userInfo.getUsername(),userInfo.getPassword(), grantedAuthorityList);
            }
        }
        return user;
    }
}
