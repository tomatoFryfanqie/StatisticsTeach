package org.jplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus
 * @Author: lzh
 * @CreateTime: 2019/10/31
 * @Description: Description
 */
@SpringBootApplication
@MapperScan("org.jplus.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
