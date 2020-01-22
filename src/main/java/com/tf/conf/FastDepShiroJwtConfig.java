package com.tf.conf;

import com.louislivi.fastdep.shirojwt.shiro.FastDepShiroJwtAuthorization;
import com.tf.dao.PermissionMapper;
import com.tf.dao.UserMapper;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FastDepShiroJwtConfig extends FastDepShiroJwtAuthorization {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public SimpleAuthorizationInfo getAuthorizationInfo(String userId) {
        // 查询该用户下的所有权限（当前为示例仅查询用户ID真实环境替换为用户的权限值）
        List<String> permissions = permissionMapper.selectPermissionsByUserId(Integer.valueOf(userId));
        Set<String> collect = new HashSet<>(permissions);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        System.out.println(collect);
        // 当前值为 [1]
        // 添加用户权限到SimpleAuthorizationInfo中
        simpleAuthorizationInfo.addStringPermissions(collect);
        return simpleAuthorizationInfo;
    }
}
