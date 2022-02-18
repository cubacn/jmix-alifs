package cn.jmix.alifs;

import io.jmix.core.FileStorage;
import io.jmix.core.FileStorageLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;

@ManagedResource(description = "Manages Ali OSS file storage client", objectName = "jmix.alifs:type=AliFileStorage")
@Component("alifs_AliFileStorageManagementFacade")
public class AliFileStorageManagementFacade {
    @Autowired
    protected FileStorageLocator fileStorageLocator;

    @ManagedOperation(description = "Refresh Ali OSS file storage client")
    public String refreshAliOssClient() {
        FileStorage fileStorage = fileStorageLocator.getDefault();
        if (fileStorage instanceof AliFileStorage) {
            ((AliFileStorage) fileStorage).refreshOssClient();
            return "Refreshed successfully";
        }
        return "Not an Ali file storage - refresh attempt ignored";
    }

    @ManagedOperation(description = "Refresh Ali OSS file storage client by storage name")
    @ManagedOperationParameters({
            @ManagedOperationParameter(name = "storageName", description = "Storage name"),
            @ManagedOperationParameter(name = "accessKey", description = "Ali OSS access key"),
            @ManagedOperationParameter(name = "secretAccessKey", description = "Ali OSS secret access key")})
    public String refreshAliOssClient(String storageName, String accessKey, String secretAccessKey) {
        FileStorage fileStorage = fileStorageLocator.getByName(storageName);
        if (fileStorage instanceof AliFileStorage) {
            AliFileStorage aliFileStorage = (AliFileStorage) fileStorage;
            aliFileStorage.setAccessKey(accessKey);
            aliFileStorage.setSecretAccessKey(secretAccessKey);
            aliFileStorage.refreshOssClient();
            return "Refreshed successfully";
        }
        return "Not an Ali OSS file storage - refresh attempt ignored";
    }

    @ManagedOperation(description = "Refresh Ali OSS file storage client by storage name")
    @ManagedOperationParameters({
            @ManagedOperationParameter(name = "storageName", description = "Storage name"),
            @ManagedOperationParameter(name = "accessKey", description = "Ali OSS access key"),
            @ManagedOperationParameter(name = "secretAccessKey", description = "Ali OSS secret access key"),
            @ManagedOperationParameter(name = "bucket", description = "Ali OSS bucket name"),
            @ManagedOperationParameter(name = "chunkSize", description = "Ali OSS chunk size (kB)"),
            @ManagedOperationParameter(name = "endpointUrl", description = "Optional custom Ali oss storage endpoint URL")})
    public String refreshAliOssClient(String storageName, String accessKey, String secretAccessKey,
                                  String region, String bucket, int chunkSize, @Nullable String endpointUrl) {
        FileStorage fileStorage = fileStorageLocator.getByName(storageName);
        if (fileStorage instanceof AliFileStorage) {
            AliFileStorage aliFileStorage = (AliFileStorage) fileStorage;
            aliFileStorage.setAccessKey(accessKey);
            aliFileStorage.setSecretAccessKey(secretAccessKey);
            aliFileStorage.setRegion(region);
            aliFileStorage.setBucket(bucket);
            aliFileStorage.setChunkSize(chunkSize);
            aliFileStorage.setEndpointUrl(endpointUrl);
            aliFileStorage.refreshOssClient();
            return "Refreshed successfully";
        }
        return "Not an Ali OSS file storage - refresh attempt ignored";
    }
}
