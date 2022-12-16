package com.shz.mapper;

import com.shz.entity.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper {
    int insertSysUser(SysUser user);
    SysUser selectSysUser(String username);
}
