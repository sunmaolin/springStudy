package annotation.bean;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 在我们使用@Component装配Bean是定义在类上面的，如果我们使用第三方的jar包，我们没有办法
 * 在源码上进行修改添加@Component注解，请看下面
 * 当然  三方jar包，还是推荐使用XML的方式
 */
@Configuration //告诉Spring这是一个配置文件===spring-config.xml，我觉得这个注解与ComponentScan相同
public class InjectTripartiteBean {

    /**
     * 装配数据源
     * 注意@Bean属性不能使用在类上，只能使用在方法上
     * @return
     */
    @Bean("dataSource")
//    @Bean(name = "dataSource",initMethod = "init",destroyMethod = "destory")
    public DataSource getDataSource(){
        Properties properties = new Properties();
        properties.setProperty("driver","com.mysql.cj.jdbc.Driver");
        properties.setProperty("url","jdbc:mysql://localhost:3306/mybatisStudy?serverTimezone=Asia/Shanghai");
        properties.setProperty("username","root");
        properties.setProperty("password","000");
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
