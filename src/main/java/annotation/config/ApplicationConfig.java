package annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import pojo.Role;
import service.RoleService;
//扫描所定义的包
@ComponentScan(basePackages = {"pojo","service"})
//扫描所定义的类
//@ComponentScan(basePackageClasses = {Role.class,RoleService.class})
//或者同时定义
//@ComponentScan(basePackages = {"pojo"},basePackageClasses = {Role.class})
//注意：使用basePackages与basePackageClasses重复扫描不会导致重复创建 ， 而只是单纯的使用@Component会


//将xml定义的Bean扫描进来
//@ImportResource({"classpath:spring-config.xml"})
//若我们有好多的配置类如ApplicationConfig1\ApplicationConfig2,可通过下面的注解
//@Import({ApplicationConfig1.class})
public class ApplicationConfig {
}
