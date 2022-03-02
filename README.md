# Jmix 阿里对象存储

此扩展提供了一个 FileStorage 实现，可将基于Jmix文件引用(FileRef)数据存储到 [阿里对象存储OSS](https://help.aliyun.com/product/31815.html) 。

## 安装

下表展示了扩展组件的版本以及兼容的Jmix平台版本。

| Jmix 版本     | 扩展组件版本     | Implementation                             |
|--------------|----------------|--------------------------------------------|
| 1.1.*        | 1.0.0          | cn.jmix:jmixcn-alifs-starter:1.0.0                |

 `build.gradle` 文件中添加依赖:

```gradle
implementation 'cn.jmix:jmixcn-alifs-starter:1.0.0'
```

# 配置
在 `application.properties` 配置文件中添加以下属性配置:

| 属性名                      | 默认值   | 说明                                                                                                          |
|----------------------------|---------|-----------------------------------|
| jmix.alifs.accessKey       |         | AccessKey ID，用于标识用户          |         
| jmix.alifs.secretAccessKey |         | AccessKey Secret，用于验证用户的密钥 |
| jmix.alifs.bucket          |         | 存储空间                           |
| jmix.alifs.chunkSize       |   8192  | 块大小，单位是KB                    |
| jmix.alifs.endpointUrl     |         | 服务端点地址                        |

