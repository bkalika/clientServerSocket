package example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Phone {
    private final Socket socket;
    private final BufferedReader reader;
    private final BufferedWriter writer;

    public Phone(Socket socket) {
        this.socket = socket;
        this.reader = createReader();
        this.writer = createWriter();
    }

    public Phone(ServerSocket server) {
        this.socket = server.accept();
        this.reader = createReader();
        this.writer = createWriter();
    }

    private BufferedReader createReader() {
        try {
            return new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedWriter createWriter() {
        try {
            return new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
