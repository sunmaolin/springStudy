package annotation.conditional;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 定义装配role组件的条件
 */
public class RoleConditional implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获取上下文环境
        Environment environment = conditionContext.getEnvironment();
        //可以获取到Property配置文件的内容
        // 比如判断是否包含数据源的配置
        environment.containsProperty("jdbc.database.driver");
        //返回true的时候才会装配，这里我们返回false，看看会不会装配到
        return false;
    }
}
