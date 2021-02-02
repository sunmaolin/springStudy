package controller;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import pojo.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试El表达式
 */
public class ElBeanTest {

    public static void main(String[] args) {
//        testEl();
        testElVariable();
    }

    public static void testEl(){
        //表达式解析器  Spring El 实现类
        ExpressionParser parser = new SpelExpressionParser();
        //设置表达式
        Expression expression = parser.parseExpression("'hello world!'");
        System.out.println(expression.getValue());
        //通过El访问普通方法
        expression = parser.parseExpression("'hello'.charAt(0)");
        System.out.println(expression.getValue());
        //通过El访问getter方法  getBytes
        expression = parser.parseExpression("'hello'.bytes");
        System.out.println(expression.getValue());
        //通过El访问属性 getBytes().length
        expression = parser.parseExpression("'hello'.bytes.length");
        System.out.println(expression.getValue());

        expression = parser.parseExpression("new String('abc')");
        System.out.println(expression.getValue());
    }

    /**
     * 测试EL表达式解析变量
     */
    public static void testElVariable(){
        //创建角色类
        Role role = new Role(1,"孙茂林");
        ExpressionParser parser = new SpelExpressionParser();
        //解析userName变量
        Expression expression = parser.parseExpression("roleName");
        //将需要解析的类传进去
        String userName = (String) expression.getValue(role);
        System.out.println(userName);

        //变量环境类，并且将role作为根节点
        EvaluationContext context = new StandardEvaluationContext(role);
        //变量环境类，操作根节点
        parser.parseExpression("roleName").setValue(context,"郑婷");
        //重新获取名字
        userName = parser.parseExpression("roleName").getValue(role,String.class);
        System.out.println(userName);
        //屌用方法获取姓名
        userName = parser.parseExpression("getRoleName()").getValue(role,String.class);
        System.out.println(userName);

        //新增环境变量
        List<String> list = new ArrayList<>();
        list.add("value1");
        list.add("value2");
        //给变量环境增加变量
        context.setVariable("list",list);
        //在通过表达式去读写环境变量
        parser.parseExpression("#list[1]").setValue(context,"update_value2");
        System.out.println(parser.parseExpression("#list[1]").getValue(context));


    }
}
