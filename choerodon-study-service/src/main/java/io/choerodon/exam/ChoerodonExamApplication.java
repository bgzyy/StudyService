package io.choerodon.exam;

import io.choerodon.resource.annoation.EnableChoerodonResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by zhao'yin
 * Date 2019/8/3.
 */
@SpringBootApplication
@EnableChoerodonResourceServer
@EnableFeignClients
@EnableEurekaClient
public class ChoerodonExamApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChoerodonExamApplication.class, args);
    }
}