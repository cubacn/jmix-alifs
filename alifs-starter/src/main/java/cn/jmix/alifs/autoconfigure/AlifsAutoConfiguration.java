package cn.jmix.alifs.autoconfigure;

import cn.jmix.alifs.AliFileStorageConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AliFileStorageConfiguration.class})
public class AlifsAutoConfiguration {
}

