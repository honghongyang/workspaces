package cn.itcast.shiro.cn.itcast.shiro.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

/**
 * Created by gddev2 on 15/8/7.
 */
public class Md5Util {//散列算法，对密码继续散列加密
    @Test
    public void test01()
    {
        //原始密码
        String source="111111";
        //盐
        String salt ="qwerty";
        //散列次数
        int hashItetation =2;

        Md5Hash md5Hash= new Md5Hash(source,salt,hashItetation);
        System.out.println(md5Hash.toString());
        //36f2dfa24d0a9fa97276abbe13e596fc
        //36f2dfa24d0a9fa97276abbe13e596fc
    }

}
