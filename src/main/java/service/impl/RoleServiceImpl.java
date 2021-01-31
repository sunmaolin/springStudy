package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pojo.Role;
import service.RoleService;

@Component
public class RoleServiceImpl implements RoleService {

    //自动装配-依赖注入，这里是按类型(by type)进行注入
    //在所有的Bean定义完后，会根据类型找到相应的Bean进行注入
    /**
     * 问题1：在默认情况下，若没有找到该类型实例注入会抛出异常，若不是必须需要可使用注解
     * @Autowired(required = false)
     * 问题2：若role存在多个实现类或子类怎么办？装配时就会蒙蔽，不知道使用哪个实例进行装配，这就是歧义性
     * 解决：1.在role的实现类或子类上添加@Primary注解  代表优先使用
     *      2.在需要装配的属性上添加@Qualifier注解 这样就会使用按名字(by name)进行注入 就是我们定义时候的@Component("role")
     */
    /**
     * 该属性还可以定义在set方法或参数上,作用是一样的
     * @Autowired
     * public void setRole(Role role){
     *     this.role = role;
     * }
     * public void RoleServiceImpl(@Autowired Role role){
     *     this.role = role;
     * }
     */
    @Autowired
    @Qualifier("role")
    private Role role = null;

    @Override
    public void printRole(Role role) {
        System.out.println(role.getRoleId());
        System.out.println(role.getRoleName());
        System.out.println(role.getNote());
    }

    @Override
    public void printRole() {
        System.out.println(this.role.getRoleId());
        System.out.println(this.role.getRoleName());
        System.out.println(this.role.getNote());
    }
}
