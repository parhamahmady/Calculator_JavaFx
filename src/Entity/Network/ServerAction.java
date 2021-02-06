package Entity.Network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerAction implements Runnable {
    private Socket connectionSocket;
    private Server server;
    private int sessionId;
    private InputStream is;
    private OutputStream io;

    /**
     * Constructor
     * 
     * @param connectionsSocket
     * @param server
     */
    private ServerAction(Socket connectionsSocket, Server server, int id) throws IOException {
        this.connectionSocket = connectionsSocket;
        this.server = server;
        this.sessionId = id;
        is = connectionsSocket.getInputStream();
        io = connectionsSocket.getOutputStream();
    }

    /**
     * Static Factory Method
     * 
     * @param connectionsSocket
     * @param server
     * @return Server Action
     */
    public static ServerAction makeServerAction(Socket connectionsSocket, Server server, int id) throws IOException {
        return new ServerAction(connectionsSocket, server, id);
    }

    @Override
    public void run() {

    }

    public int getSessionId() {
        return sessionId;
    }
}
