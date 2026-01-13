import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HelloDevOps {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", exchange -> {
            String response = "hii Hello hiii guys from DevOps pipeline this is done on aws and using webhook pvm ";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.start();
        System.out.println("Server started on port 8080");
    }
}

AWS WEBHOOK TEST Tue Jan 13 10:55:06 PM IST 2026
AWS WEBHOOK TEST Tue Jan 13 10:58:21 PM IST 2026
AWS WEBHOOK TEST Tue Jan 13 10:59:15 PM IST 2026
