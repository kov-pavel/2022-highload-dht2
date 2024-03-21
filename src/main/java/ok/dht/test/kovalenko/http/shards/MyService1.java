package ok.dht.test.kovalenko.http.shards;

import ok.dht.ServiceConfig;
import ok.dht.test.kovalenko.http.MyServiceBase;
import ok.dht.test.kovalenko.utils.Main;

import java.io.IOException;

public class MyService1 extends MyServiceBase {

    private static final int ORDINAL = 1;

    public MyService1(ServiceConfig config) throws IOException {
        super(config);
    }

    public static void main(String[] args) {
        Main.main(ORDINAL);
    }
}
