package com.dmdev.http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Scanner;

public class SocketRunner {
    public static void main(String[] args) throws Exception {
        var localhost = Inet4Address.getByName("localhost");
        try (var socket = new Socket(localhost, 111);
             var inputStream = new DataInputStream(socket.getInputStream());
             var outputStream = new DataOutputStream(socket.getOutputStream());
             Scanner scanner = new Scanner(System.in);
        ) {
            while (scanner.hasNextLine()) {
                var request = scanner.nextLine();
                outputStream.writeUTF(request);
                System.out.println("Response " + inputStream.readUTF());
            }
        }
    }
}
