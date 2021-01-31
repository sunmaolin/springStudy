package controller;

import annotation.config.ApplicationConfig;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.ComplexAssembly;
import pojo.PojoConfig;
import pojo.Role;
import service.RoleService;
import service.impl.RoleServiceImpl;

import java.util.Arrays;

public class InjectBeanTest {
    
    private static Logger logger = Logger.getLogger(InjectBeanTest.class);
    
    public static void main(String[] args) {
        String path = "assemblyBean/spring-config.xml";
//        testOrdinaryBean(path);
//        testComplexBean(path);
//        testComplexNameSpaceBean(path);
//        testInjectBeanByAnnotation();
//        testDifferentPackageScan();
        testAutowired();
    }

    /**
     * 测试普通bean装配
     * @param path
     */
    public static void testOrdinaryBean(String path){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
        Role role = (Role) applicationContext.getBean("roleConstructInject");
        logger.info(role);
    }

    /**
     * 测试复杂bean装配
     * @param path
     */
    public static void testComplexBean(String path){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
        ComplexAssembly complexAssembly = applicationContext.getBean("complexAssembly", ComplexAssembly.class);
        logger.info(complexAssembly);
    }

    /**
     * 测试使用命名空间装配复杂bean
     * @param path
     */
    public static void testComplexNameSpaceBean(String path){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
        ComplexAssembly complexAssembly = applicationContext.getBean("nameSpaceComplexInject",ComplexAssembly.class);
        logger.info(complexAssembly.getList().toString());
    }

    /**
     * 测试使用注解的方式装配bean
     */
    public static void testInjectBeanByAnnotation(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PojoConfig.class);
        Role role = applicationContext.getBean(Role.class);
        logger.info(role.getRoleId());
    }

    /**
     * 测试在config配置类扫描不同的包进行装配
     */
    public static void testDifferentPackageScan(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Role role = applicationContext.getBean(Role.class);
        //这里只定义了RoleServiceImpl注解component，为什么能扫描到呢？因为之定义了一个RoleService的实现类
        RoleService roleService = applicationContext.getBean(RoleService.class);
        roleService.printRole(role);
    }

    /**
     * 测试自动注入@Autowired注解
     */
    public static void testAutowired(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        RoleService roleService = applicationContext.getBean(RoleService.class);
        roleService.printRole();
    }


}
