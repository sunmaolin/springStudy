package controller;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.ComplexAssembly;
import pojo.Role;

public class InjectBeanTest {
    
    private static Logger logger = Logger.getLogger(InjectBeanTest.class);
    
    public static void main(String[] args) {
        String path = "assemblyBean/spring-config.xml";
//        testOrdinaryBean(path);
        testComplexBean(path);
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
     * 测试负责bean装配
     * @param path
     */
    public static void testComplexBean(String path){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
        ComplexAssembly complexAssembly = applicationContext.getBean("complexAssembly", ComplexAssembly.class);
        logger.info(complexAssembly);
    }
}
