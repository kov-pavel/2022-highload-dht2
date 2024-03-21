package ok.dht.test.kovalenko.rpc;

import one.nio.net.ConnectionString;
import one.nio.rpc.RpcClient;

import java.lang.reflect.Proxy;

public class MyRpcClient {

    public static MyRpcService from(int port) {
        ConnectionString conn = new ConnectionString("localhost:" + port);
        return (MyRpcService) Proxy.newProxyInstance(
                MyRpcService.class.getClassLoader(),
                new Class[] {MyRpcService.class},
                new RpcClient(conn));
    }

    public static void main(String[] args) {
        MyRpcService client = from(19300);

    }
}
