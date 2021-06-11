package com.example.fidledemo.backLogin.realm;

import com.example.fidledemo.BO.AdminBO;
import com.example.fidledemo.DO.AdminDO;
import com.example.fidledemo.DO.PermissionDO;
import com.example.fidledemo.DO.RoleDO;
import com.example.fidledemo.backHomepage.service.AdminService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminShiroRealm extends AuthorizingRealm {
    @Autowired
    AdminService adminService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String account = (String) principals.getPrimaryPrincipal();
        AdminDO adminDO = new AdminDO();
        adminDO.setAccount(account);
        AdminBO adminBO = adminService.getAdminBoByDO(adminDO);
        List<RoleDO> roleDOList = adminService.getRoleDoByAdminBO(adminBO);
        for (RoleDO roleDO : roleDOList) {
            authorizationInfo.addRole(roleDO.getRoleName());
            List<PermissionDO> permissionDOList = adminService.getPermissionDOByRoleDO(roleDO);
            for (PermissionDO permissionDO : permissionDOList) {
                authorizationInfo.addStringPermission(permissionDO.getPermission());
            }
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String account = (String) token.getPrincipal();
        AdminDO adminDO = new AdminDO();
        adminDO.setAccount(account);
        AdminBO adminBO = adminService.getAdminBoByDO(adminDO);
        if (adminBO == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(adminBO.getAccount(), adminBO.getPassword(),
                ByteSource.Util.bytes(adminBO.getSalt()), getName());
        return authenticationInfo;
    }
}
