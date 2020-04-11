package com.ccy.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;

public class IOCopy {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("");
        byte[] bytes = new byte[1024 * 8];
        fileInputStream.read(bytes);
        Socket socket = new Socket();
        socket.getOutputStream().write(bytes);

    }
}
