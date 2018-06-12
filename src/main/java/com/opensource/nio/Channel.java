package com.opensource.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Channel {

	public static void main(String[] args) throws Exception {

		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.socket().bind(new InetSocketAddress(8000));
		serverSocketChannel.configureBlocking(false);
		while (true) {
			SocketChannel socketChannel = serverSocketChannel.accept();
			if (socketChannel != null) {
				System.out.println("ooooooooooooooooooo");
			}
		}
	}

}
