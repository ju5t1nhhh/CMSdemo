package com.niit.cmsdemo.util;


import com.niit.cmsdemo.domain.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {
    //private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private String algorithmName = "md5";
    private int hashIterations = 2;

    public void encryptPassword(User user) {
        //String salt=randomNumberGenerator.nextBytes().toHex();
        String newPassword = new SimpleHash(algorithmName, user.getPassword(),  ByteSource.Util.bytes(user.getLoginId()), hashIterations).toHex();
        //String newPassword = new SimpleHash(algorithmName, user.getPassword()).toHex();
        user.setPassword(newPassword);
    }

//    public static void main(String[] args) {
//        PasswordHelper passwordHelper=new PasswordHelper();
//        User user=new User();
//        user.setUsername("admin");
//        user.setPassword("admin");
//        passwordHelper.encryptPassword(user);
//        System.out.println(user.getPassword());
//    }

}
