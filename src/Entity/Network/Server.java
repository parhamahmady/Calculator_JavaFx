package Entity.Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private ServerSocket welcomingSocket;
    private HashMap<Integer, ServerAction> activeSessions;
    private ExecutorService sessionPool;
    private boolean isOn;
    private int sessoinNumbers;

    /**
     * 
     * @param port port of Server
     * @throws IOException in case the port was busy
     */
    private Server(int port) throws IOException {

        welcomingSocket = new ServerSocket(port);
        sessionPool = Executors.newCachedThreadPool();

    }

    /**
     * Static Factory Method
     * 
     * @param port
     * @return server
     */
    public static Server makeServer(int port) {
        Server server;
        try {

            server = new Server(port);
            server.isOn = true;
            return server;

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }

    }

    private void tripleHandShake() {

        while (isOn) {
            try {

                ServerAction tempServerAction = ServerAction.makeServerAction(welcomingSocket.accept(), this,
                        ++sessoinNumbers);
                activeSessions.put(tempServerAction.getSessionId(), tempServerAction);
                sessionPool.execute(tempServerAction);
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
