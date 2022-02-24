package test_support;

import cn.jmix.alifs.AliFileStorageConfiguration;
import io.jmix.core.annotation.JmixModule;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:/test_support/test-app.properties")
@PropertySource(value = "classpath:/test_support/test-secrects.properties",ignoreResourceNotFound = true)
@JmixModule(dependsOn = AliFileStorageConfiguration.class)
public class AliFileStorageTestConfiguration {
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }
}
