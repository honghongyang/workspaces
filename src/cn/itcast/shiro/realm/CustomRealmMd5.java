package cn.itcast.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * Created by gddev2 on 15/8/7.
 */
public class CustomRealmMd5 extends AuthorizingRealm {
    @Override
    public void setName(String name) {
        super.setName("CustomRealmMd5");
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        String userCode = (String) token.getPrincipal();
        /**
         * if(!userCode.equals("zhangsansan")){return null}
         */

        String password = "f3694f162729b7d0254c6e40260bf15c";
        String salt = "qwerty";

        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(userCode, password, ByteSource.Util.bytes(salt), this.getName());
        return simpleAuthenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

}
