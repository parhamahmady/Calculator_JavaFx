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
    private OutputStream os;

    /**
     * Constructor
     * 
     * @param serverIp
     * @param serverPort
     * @throws IOException
     */
    public Client(String serverIp, int serverPort) throws IOException {

        socket = new Socket(serverIp, serverPort);
        os = socket.getOutputStream();
        is = socket.getInputStream();

    }

    /**
     * 
     * @param messages will send to Server
     * @return response
     * @throws IOException
     */
    public synchronized String massenger(String... messages) throws IOException {
        byte[] buffer = new byte[2048];
        String awnser = "";
        for (String message : messages) {
            os.write(message.getBytes()); // Send The Message
            int read = is.read(buffer);
            awnser = new String(buffer, 0, read);
            if (awnser.isBlank())
                return awnser;
        }
        // int read = is.read(buffer);
        // awnser = new String(buffer, 0, read);
        return awnser;
    }
}