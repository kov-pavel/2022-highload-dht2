package ok.dht.test.kovalenko.rpc;

import one.nio.net.ConnectionString;
import one.nio.rpc.RpcServer;
import one.nio.server.ServerConfig;

import java.io.IOException;

public class MyRpcServer implements MyRpcService {

    public static void main(String[] args) throws IOException {
        ServerConfig config = ServerConfig.from(new ConnectionString("localhost:" + 19300));
        new RpcServer<>(config, new MyRpcServer()).start();
        System.out.println("Server started");
    }

}
