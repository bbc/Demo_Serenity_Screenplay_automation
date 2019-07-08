package restapi;

import io.restassured.RestAssured;
import org.apache.http.conn.ssl.SSLSocketFactory;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.SecureRandom;

import static io.restassured.config.SSLConfig.sslConfig;

public class SetupApi {

    public static void initialiseSSLSocketFactory() throws Exception {
        SSLSocketFactory e = getSocketFactory();
        RestAssured.config = RestAssured.config().sslConfig(sslConfig().sslSocketFactory(e));
    }

    private static SSLSocketFactory getSocketFactory() throws Exception {

        KeyStore keystore = KeyStore.getInstance("PKCS12");
        FileInputStream keystoreInput = new FileInputStream("src/test/java/resources/certs/proteus-rest-test.pfx");
        keystore.load(keystoreInput, "21042016".toCharArray());
        KeyStore truststore = KeyStore.getInstance(KeyStore.getDefaultType());

        FileInputStream truststoreInput = new FileInputStream("src/test/java/resources/certs/cacerts");
        truststore.load(truststoreInput, "changeit".toCharArray());

        return new SSLSocketFactory(
                (String) null,
                keystore,
                "21042016",
                truststore, (SecureRandom) null,
                SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER
        );
    }
}
