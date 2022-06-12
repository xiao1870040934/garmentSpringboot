package cn.ccsu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("cn.ccsu.mapper")
@EnableTransactionManagement
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class GarmentSpringbootApplication {
    public static void main(String[] args){
        SpringApplication.run(GarmentSpringbootApplication.class,args);
    }
}
