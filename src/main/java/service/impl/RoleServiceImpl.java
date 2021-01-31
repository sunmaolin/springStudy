package service.impl;

import org.springframework.stereotype.Component;
import pojo.Role;
import service.RoleService;

@Component
public class RoleServiceImpl implements RoleService {

    @Override
    public void printRole(Role role) {
        System.out.println(role.getRoleId());
        System.out.println(role.getRoleName());
        System.out.println(role.getNote());
    }
}
