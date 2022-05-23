package com.dmdev.http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.util.Scanner;

public class ServerSocketRunner {

    public static void main(String[] args) throws Exception {

        try (var server = new ServerSocket(111);
             var socket = server.accept();
             var inputStream = new DataInputStream(socket.getInputStream());
             var outputStream = new DataOutputStream(socket.getOutputStream());
             Scanner scanner = new Scanner(System.in);
        ) {
            var request = inputStream.readUTF();
            while (!"stop".equals(request)) {
                System.out.println("Request " + request);
                var response = scanner.nextLine();
                outputStream.writeUTF(response);
                request = inputStream.readUTF();
            }
        }
    }

}
