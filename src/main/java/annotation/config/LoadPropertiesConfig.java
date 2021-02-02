package annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * 加载properties文件配置
 */

/**
 * 将properties文件加载进来。ignoreResourceNotFound属性为是否允许没有该文件，默认为false
 * @Configuration注解用于定义配置类，如果不加获取不到properties的属性
 * 仅仅是加了PropertySource注解并不能解析属性占位符的能力，我们可以使用PropertySourcesPlaceholderConfiguare类去解析
 * 占位符就是类似mybatis的  ${jdbc.database.url}
 */
@Configuration
@PropertySource(value = {"classpath:database-config.properties"},ignoreResourceNotFound = true)
@ComponentScan(basePackages = {"bean"},lazyInit = true)
public class LoadPropertiesConfig {

    /**
     * 我们配置了解析占位符，那如何使用呢？看下dataSourceBean
     * @return
     */
    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
