package Client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientSender {

    private static boolean serverisconnected = false;

    public static SocketAddress socketAddress;
    public static SocketChannel socketChannel;
    public ClientSender(String host,int port){
        socketAddress = new InetSocketAddress(host,port);
    }

    public static void connect() throws InterruptedException {
        boolean connected = false;
        while (!connected) {
            try {
                socketChannel = SocketChannel.open(ClientSender.socketAddress);
                ClientReceiver.socket = socketChannel.socket();
                connected = true;
            }catch (ConnectException e){
                System.out.println("Error,server is unavailable,trying to reconnect...");
                Thread.sleep(2000);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public  static void send(Object o){
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(o);
            objectOutputStream.flush();
            objectOutputStream.close();
            byte[] buff = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            socketChannel.write(ByteBuffer.wrap(buff));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
