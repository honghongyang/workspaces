package cn.itcast.shiro.authentication;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;


/**
 * Created by gddev2 on 15/8/7.
 */
public class TestAuthentication {
    //测试用户到登录和退出
    @Test
    public void testLoginAndLogout() {
        //创建SecurityManager工厂
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro-first.ini");
        //由工厂获得安全管理器
        SecurityManager securityManager = factory.getInstance();
        //将安全管理器设置到当前运行环境中
        SecurityUtils.setSecurityManager(securityManager);

        //从SecurityUtils中获得主体（subject）
        Subject subject = SecurityUtils.getSubject();
        //在认证之前准备好token令牌
        //该处到用户名和密码都是用户登录或者是注册时填写的
        //UsernamePasswordToken token = new UsernamePasswordToken("zhangsansan", "111111");
        UsernamePasswordToken token = new UsernamePasswordToken("lisi", "222222");

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }


        boolean isAuthenticated = subject.isAuthenticated();
        System.out.println("是否认证通过：" + isAuthenticated);

        //退出
        subject.logout();//安全退出
        isAuthenticated = subject.isAuthenticated();
        System.out.println("是否认证通过：" + isAuthenticated);


    }

    @Test
    public void test01()
    {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-first.ini");
        //
        SecurityManager securityManager =factory.getInstance();

        //把安全管理器设置到当前运行环境中
        SecurityUtils.setSecurityManager(securityManager);
        //通过SecurityUtils获取主体Subject
        Subject subject = SecurityUtils.getSubject();

        //在登录前，准备好token令牌
        //该令牌为用户密码令牌
        UsernamePasswordToken token = new UsernamePasswordToken("lisi","222222");


        //执行登录
        try{
            subject.login(token);
        }catch(AuthenticationException e)
        {
            e.printStackTrace();
        }

        //验证是否认证成功与否
        boolean isAuthencated = subject.isAuthenticated();
        System.out.println("认证是否通过："+isAuthencated);

        //执行用户安全退出
        subject.logout();
        isAuthencated = subject.isAuthenticated();
        System.out.println("认证是否通过:"+isAuthencated);
    }


    @Test
    public void test03()
    {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");

        //由工厂创建安全管理器
        SecurityManager securityManager = factory.getInstance();
        //把安全管理器设置到当前运行环境中
        SecurityUtils.setSecurityManager(securityManager);

        //通过SecurityUtils获得主体对象
        Subject subject = SecurityUtils.getSubject();

        //在执行登录前，准备好认证令牌
        //该认证令牌由用户输入
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","111111");

        //执行主体用户登录
        try{
            subject.login(token);
        }catch(AuthenticationException e)
        {
            e.printStackTrace();
        }

        //判断用户登录授权成功与否
        boolean isAuthenticated = subject.isAuthenticated();
        System.out.println("判断认证是否通过："+isAuthenticated);

        subject.logout();
        isAuthenticated = subject.isAuthenticated();
        System.out.println("判断认证是否通过："+isAuthenticated);

    }


}
