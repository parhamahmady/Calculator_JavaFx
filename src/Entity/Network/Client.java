package Entity.Network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Client
 */
public class Client {
    private Socket socket;
    private InputStream is;
    private OutputStream io;

    /**
     * Constructor
     * 
     * @param serverIp
     * @param serverPort
     * @throws IOException
     */
    public Client(String serverIp, int serverPort) throws IOException {

        socket = new Socket(serverIp, serverPort);
        io = socket.getOutputStream();
        is = socket.getInputStream();
    }

    
}