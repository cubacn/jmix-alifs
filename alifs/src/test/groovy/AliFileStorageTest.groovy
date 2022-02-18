import cn.jmix.alifs.AliFileStorage
import cn.jmix.alifs.AliFileStorageConfiguration
import io.jmix.core.CoreConfiguration
import io.jmix.core.FileRef
import io.jmix.core.FileStorage
import io.jmix.core.UuidProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import test_support.AliFileStorageTestConfiguration
import test_support.TestContextInititalizer

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.NONE
)
@ContextConfiguration(
        classes = [CoreConfiguration, AliFileStorageConfiguration,AliFileStorageTestConfiguration],
        initializers = [TestContextInititalizer]
)
class AliFileStorageTest extends Specification {

    @Autowired
    private FileStorage fileStorage


    def "save stream"(){
        def fileName=UuidProvider.createUuid().toString()+".txt";
        def fileStream=this.getClass().getClassLoader().getResourceAsStream("files/simple.txt");
        def fileRef=fileStorage.saveStream(fileName,fileStream);
        def openedStream=fileStorage.openStream(fileRef);
        expect:
            openedStream!=null
    }

    def "fileExists"() {
        def storageName = fileStorage.getStorageName()
        def fileKey = "2021/11/05/38a0405a-c885-5f75-cef7-6727b71838c1.txt"
        def fileName="38a0405a-c885-5f75-cef7-6727b71838c1.txt"

        def fileref = new FileRef(storageName, fileKey, fileName);
        def exists = fileStorage.fileExists(fileref)

        expect:  exists

    }


    def "removeFile"(){
        def storageName = fileStorage.getStorageName()
        def fileKey = "2021/11/05/38a0405a-c885-5f75-cef7-6727b71838c1.txt"
        def fileName="38a0405a-c885-5f75-cef7-6727b71838c1.txt"

        def fileref = new FileRef(storageName, fileKey, fileName);
        fileStorage.removeFile(fileref)


        def exists = fileStorage.fileExists(fileref)

        expect:  !exists
    }

    def "ali storage initialized"() {
        expect:
        fileStorage.getStorageName() == AliFileStorage.DEFAULT_STORAGE_NAME
    }
}