package Entity.Network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import Entity.Arithmatic.Calculator;

public class ServerAction implements Runnable {
    private Socket connectionSocket;
    private Server server;
    private int sessionId;
    private InputStream is;
    private OutputStream os;

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
        os = connectionsSocket.getOutputStream();
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
        commandParser();
    }

    private void commandParser() {
        try {
            byte[] buffer = new byte[2048];
            int read = is.read(buffer);
            String command = new String(buffer, 0, read);
            switch (command) {
                case "calc":
                    os.write("OK".getBytes());// tells client im ready
                    System.out.println("Calc");
                    calc();
                    return; // DeActive the parser to calculate

            }

        } catch (Exception e) {

            try {

                os.write(" ".getBytes()); // To Tell The Client SomeThing Is Wrong
            } catch (Exception ee) {

                System.out.println("IM In Trouble Man");
            }
        }

    }

    private void calc() throws IOException {
        byte[] buffer = new byte[2048];
        int read = is.read(buffer);

        String firstNumber = new String(buffer, 0, read);
        os.write("OK1".getBytes());// tells client im ready to recive second Number

        int read2 = is.read(buffer);
        String secondNumber = new String(buffer, 0, read2);
        os.write("OK2".getBytes());// tells client im ready to recive Func

        int read3 = is.read(buffer);
        String func = new String(buffer, 0, read3);
        os.write(Calculator.Calculate(firstNumber, secondNumber, func).getBytes()); // return Awnser

        commandParser();
    }

    public int getSessionId() {
        return sessionId;
    }
}
