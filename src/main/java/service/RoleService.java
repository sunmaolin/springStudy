package service;

import pojo.Role;

public interface RoleService {
    /**
     * 打印role
     * @param role
     */
    void printRole(Role role);

    /**
     * 测试自动注入@Autowired注解
     */
    void printRole();
}
