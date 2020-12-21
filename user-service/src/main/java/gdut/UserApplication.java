package gdut;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author BUG_BOY
 */
@SpringBootApplication
@MapperScan("gdut.wlz.mapper")
@EnableDiscoveryClient  //开启eureka客户端发现
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
