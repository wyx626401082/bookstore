package com.xzsd.app.config;

import com.xzsd.app.utils.QCloudCosUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Farewell is well
 * @date 2019-11-20 15:36
 */
@Configuration
public class QCloudCosUtilsConfig {
    @ConfigurationProperties(prefix = "spring.qcloud")
    @Bean
    public QCloudCosUtils qcloudCosUtils() {
        return new QCloudCosUtils();
    }
}
