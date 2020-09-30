package Client;

import This.NewElementData;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.Map;

public class ClientReceiver {
    ClientSender clientSender;
    public ClientReceiver(ClientSender clientSender){
        this.clientSender = clientSender;
    }
    /**
     * The constant client.
     */
    public static Socket socket;
    private static ByteBuffer buffer = ByteBuffer.allocate(10000);
    public Object receive() throws IOException, ClassNotFoundException, SocketTimeoutException {
        socket.setSoTimeout(2500);
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        Object obj = objectInputStream.readObject();

        Map<Object,Integer> answerMap = (Map<Object, Integer>) obj;
        obj = answerMap.entrySet().iterator().next().getKey();
        int a = answerMap.entrySet().iterator().next().getValue();
        if (a == 0) {
            return obj;
        }

        else if (a == 1){
            System.out.println("\n" +
                    "It is necessary to fill in additional data to execute the command.");
            clientSender.send(NewElementData.createOrganization());
            obj =this.receive();
        }



        return obj;
    }
}