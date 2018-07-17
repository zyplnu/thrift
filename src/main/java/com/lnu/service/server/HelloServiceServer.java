package com.lnu.service.server;

import com.lnu.service.Hello;
import com.lnu.service.HelloServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class HelloServiceServer {

    public static void main(String[] args) throws TTransportException {
        System.out.println("服务开启...");
        TProcessor tProcessor = new Hello.Processor<Hello.Iface>(new HelloServiceImpl());
        TServerSocket serverSocket = new TServerSocket(9898);
        TServer.Args targs = new TServer.Args(serverSocket);
        targs.processor(tProcessor);
        targs.protocolFactory(new TBinaryProtocol.Factory());
        TServer server = new TSimpleServer(targs);
        server.serve();
    }

}
