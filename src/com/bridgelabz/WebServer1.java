package com.bridgelabz;

import com.sun.net.httpserver.HttpServer;


import java.io.IOException;
import java.net.InetSocketAddress;

public class WebServer1 {
    public static int DEFAULT_PORT = 8000;
    public static int port;
    private HttpServer httpServer;
    private void start(int port) {
        this.port = port;
        try{
            httpServer = HttpServer.create(new InetSocketAddress(port),0);
            System.out.println("port number: " +port);
            httpServer.createContext("/",new Handlers.RootHandler());
            httpServer.createContext("/echoHeader",new Handlers.EchoHeaderHandler());
            httpServer.createContext("/echoGet",new Handlers.EchoGetHandler());
            httpServer.createContext("/echoPost",new Handlers.EchoPostHandler());
            httpServer.setExecutor(null);
            httpServer.start();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
//        SpringApplication.run(WebServer1.class, args);
        WebServer1 webServer1 = new WebServer1();
        webServer1.start(DEFAULT_PORT);
    }

}
