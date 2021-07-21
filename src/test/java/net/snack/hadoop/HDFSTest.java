package net.snack.hadoop;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * hdfs测试
 */
public class HDFSTest {

    @Test
    public void testUrlGet() {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
        try(InputStream in = new URL("hdfs://localhost:9000/readme.txt").openStream()) {
            byte[] bytes = new byte[in.available()];
            int read = in.read(bytes);
            System.out.println("read length: " + read);
            System.out.println(new String(bytes, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
