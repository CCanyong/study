package com.ccy.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class ZeroCopy {
    public static void main(String[] args) throws IOException {
        File file = new File("");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        FileChannel fileChannel = fileOutputStream.getChannel();
        SocketChannel socketChannel = SocketChannel.open();
        fileChannel.transferTo(0, fileChannel.size(), socketChannel);
    }
}
