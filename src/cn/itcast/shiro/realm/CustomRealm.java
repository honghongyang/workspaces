package cn.itcast.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by gddev2 on 15/8/7.
 */
public class CustomRealm extends AuthorizingRealm {
    @Override
    public void setName(String name) {
        super.setName("CustomRealm");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {

        String userCode = (String) token.getPrincipal();
        //根据userCode查询数据库
        //如果没有查询到，则返回null
        /**
         * if(!userCode.equals("zhangsansan")){return null}
         */

        //模拟从数据库中查询到密码
        String password = "111111";

        //如果查询到密码，则返回AuthenticationInfo
        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(userCode, password, getName());
        return simpleAuthenticationInfo;

    }
}
