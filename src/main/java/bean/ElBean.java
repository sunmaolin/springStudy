package bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 测试El属性注入
 */
@Component
public class ElBean {

    //数字
    @Value("#{1}")
    private int id;

    //字符串
    @Value("#{'name'}")
    private String name;

    //从role的Bean中取id
    @Value("#{role.id}")
    private int roleId;

    //从role的bean中取roleName
    @Value("#{role.roleName}")
    private String roleName;

    //pi的值
    @Value("#{T(java.lang.Math).PI}")
    private double pi;

    //简单拼接
    @Value("#{role.roleName + '123'}")
    private String str;

    //三目运算符
    @Value("#{1+1>2?false:true}")
    private boolean el;

}
