import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class App {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", exchange -> {

            String html = """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Shevchaha Company</title>
                    <style>
                        body {
                            font-family: Arial, sans-serif;
                            background: linear-gradient(135deg, #1e3c72, #2a5298);
                            color: white;
                            display: flex;
                            justify-content: center;
                            align-items: center;
                            height: 100vh;
                            margin: 0;
                        }
                        .box {
                            background: rgba(0, 0, 0, 0.4);
                            padding: 40px;
                            border-radius: 10px;
                            text-align: center;
                        }
                        h1 {
                            font-size: 36px;
                            margin-bottom: 10px;
                        }
                        p {
                            font-size: 18px;
                        }
                    </style>
                </head>
                <body>
                    <div class="box">
                        <h1>Welcome to Shevchaha Company</h1>
                        <p>DevOps • Cloud • Automation</p>
                        <p>Powered by Java, Docker & Jenkins</p>
                    </div>
                </body>
                </html>
            """;

            byte[] response = html.getBytes(StandardCharsets.UTF_8);

            exchange.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
            exchange.sendResponseHeaders(200, response.length);

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response);
            }
        });

        server.start();
        System.out.println("Server started on port 8080");
    }
}
