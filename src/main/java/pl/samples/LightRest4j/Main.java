package pl.samples.LightRest4j;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

class Main {

    public static void getServer(final HttpServer server, final String address, final String message) throws IOException {

        server.createContext(address, (exchange -> {
            if ("GET".equals(exchange.getRequestMethod())) {

                exchange.sendResponseHeaders(200, message.getBytes().length);

                OutputStream output = exchange.getResponseBody();
                output.write(message.getBytes());
                output.flush();

            } else {
                exchange.sendResponseHeaders(405, -1);// Error 405
            }
            exchange.close();
        }));


    }

    public static void main(String[] args) throws IOException {
        HttpServer serverOne = HttpServer.create(new InetSocketAddress(8080), 0);
        getServer(serverOne,  "/api/hello", "Hello world!");
        serverOne.setExecutor(null); // default executor
        serverOne.start();

        HttpServer serverTwo = HttpServer.create(new InetSocketAddress(8081), 0);
        getServer(serverTwo,  "/api/bye", "Bye world!");
        serverTwo.setExecutor(null); // default executor
        serverTwo.start();
    }
}
