package cn.ccsu.tests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author 潇洒哥queen
 * @Date 2022/5/30 22:04
 * @Version 1.0
 */
@SpringBootTest
public class UserTest {
    @Test
    public void TestBCryptPasswordEncoder(){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        //String encode=passwordEncoder.encode("1234");
       // System.out.println(encode);
        boolean matches = passwordEncoder.matches("1234", "$2a$10$wytuy.7yHGKimMDgbcuyoO9FKD8lgtGeHCbagFi8vT6x2MEi2nrnW");
        System.out.println(matches);
    }
}
