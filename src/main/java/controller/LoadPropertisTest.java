package controller;


import annotation.config.LoadPropertiesConfig;
import bean.DataSourceBean;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LoadPropertisTest {

    private static Logger logger = Logger.getLogger(LoadPropertisTest.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(LoadPropertiesConfig.class);
        //通过环境获取加载进来的属性文件
//        logger.info(applicationContext.getEnvironment().getProperty("jdbc.database.url"));
        //配置了占位解析类，就可以直接通过占位获取值
        DataSourceBean dataSourceBean = applicationContext.getBean(DataSourceBean.class);
        logger.info(dataSourceBean.getUsername());
    }
}
