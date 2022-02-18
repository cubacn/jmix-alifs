package cn.jmix.alifs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties(prefix = "jmix.alifs")
@ConstructorBinding
public class AliFileStorageProperties {
    String accessKey;
    String secretAccessKey;
    String bucket;
    int chunkSize;
    String endpointUrl;

    public AliFileStorageProperties(
            String accessKey,
            String secretAccessKey,
            String bucket,
            @DefaultValue("8192") int chunkSize,
            @DefaultValue("") String endpointUrl) {
        this.accessKey = accessKey;
        this.secretAccessKey = secretAccessKey;
        this.bucket = bucket;
        this.chunkSize = chunkSize;
        this.endpointUrl = endpointUrl;
    }

    /**
     * Ali OSS access key.
     */
    public String getAccessKey() {
        return accessKey;
    }

    /**
     * Ali OSS secret access key.
     */
    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    /**
     * Ali OSS bucket name.
     */
    public String getBucket() {
        return bucket;
    }

    /**
     *  chunk size (kB).
     */
    public int getChunkSize() {
        return chunkSize;
    }

    /**
     * Return Ali OSS storage endpoint URL.
     */
    public String getEndpointUrl() {
        return endpointUrl;
    }
}
