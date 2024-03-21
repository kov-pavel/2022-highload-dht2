package ok.dht.test.kovalenko.rpc;

import ok.dht.test.kovalenko.dao.aliases.TypedTimedEntry;
import ok.dht.test.kovalenko.utils.ReplicasUtils;
import one.nio.net.ConnectionString;
import one.nio.rpc.RpcServer;
import one.nio.server.ServerConfig;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class MyRpcServer implements MyRpcService {

    public static void main(String[] args) throws IOException {
        start(19300);
        start(19301);
        start(19302);
    }

    public static void start(int port) throws IOException {
        RpcServer<MyRpcService> rpcServer = from(port);
        rpcServer.start();
        System.out.println("Server localhost:" + port + " was started");
    }

    public static void stop(int port) throws IOException {
        RpcServer<MyRpcService> rpcServer = from(port);
        rpcServer.stop();
        System.out.println("Server localhost:" + port + " was stopped");
    }

    public static RpcServer<MyRpcService> from(int port) throws IOException {
        ServerConfig config = ServerConfig.from(new ConnectionString("localhost:" + port));
        return new RpcServer<>(config, new MyRpcServer());
    }

    public Optional<TypedTimedEntry> handleGet(String key, ReplicasUtils.ReplicasInfo replicasInfo) {
        List<TypedTimedEntry> entries = handleGet(key, key, replicasInfo);
        return entries.stream().findAny();
    }

    public List<TypedTimedEntry> handleGet(String keyFrom, String keyTo, ReplicasUtils.ReplicasInfo replicasInfo) {

    }

}
