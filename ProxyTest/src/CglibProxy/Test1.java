package CglibProxy;

import org.junit.Test;


/**
 * 测试类
 */
public class Test1{

    @Test
    public void test(){
        //目标对象
        User target = new User();

        //代理对象
        User proxy = (User)new ProxyFactory(target).getProxyInstance();

        //执行代理对象的方法
        proxy.save();
        proxy.delete();
    }
}