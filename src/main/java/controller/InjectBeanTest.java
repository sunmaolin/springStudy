package controller;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Role;

public class InjectBeanTest {
    
    private static Logger logger = Logger.getLogger(InjectBeanTest.class);
    
    public static void main(String[] args) {
        String path = "assemblyBean/spring-config.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
        Role role = (Role) applicationContext.getBean("roleConstructInject");
        logger.info(role);
    }
}
