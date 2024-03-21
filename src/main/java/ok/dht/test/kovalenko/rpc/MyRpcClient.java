package ok.dht.test.kovalenko.rpc;

import one.nio.net.ConnectionString;
import one.nio.rpc.RpcClient;

import java.lang.reflect.Proxy;

public class MyRpcClient {

    public static void main(String[] args) {
        int port = 19300;
        ConnectionString conn = new ConnectionString("localhost:" + port);
        MyRpcService client = (MyRpcService) Proxy.newProxyInstance(
                MyRpcService.class.getClassLoader(),
                new Class[] {MyRpcService.class},
                new RpcClient(conn));

    }
}
