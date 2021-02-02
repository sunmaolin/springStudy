package pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 使用注解的形式，需要加上@Compinent注解 默认id为类名第一个小写
 */
@Component
//也可以自定义id
//@Component(value = "role")
/**
 * 配置单例或者多例
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Role {

    //通过注解的形式给属性赋初值
    @Value("1")
    private int roleId;
    private String roleName;
    private String note;

    public Role() {
    }

    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Role(int roleId, String roleName, String note) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.note = note;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
