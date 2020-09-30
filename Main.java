import Client.ClientReceiver;
import Client.ClientSender;
import Commands.*;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.channels.SocketChannel;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Help helpCommand = new Help();
        Info infoCommand = new Info();
        Exit exitCommand = new Exit();
        Show showCommand = new Show();
        AddNew addNewCommand = new AddNew();
        UpdateId updateCommand = new UpdateId();
        RemoveById removeByIdCommand = new RemoveById();
        Clear clearCommand = new Clear();
        ExecuteScriptFileName executeScriptCommand = new ExecuteScriptFileName();
        Head headCommand = new Head();
        RemoveFirst removeFirstCommand = new RemoveFirst();
        RemoveGreater removeGreaterCommand = new RemoveGreater();
        AverageOfEmployeesCount averageOfEmployeesCountCommand = new AverageOfEmployeesCount();
        PrintFieldDescendingPostalAddress printFieldDescendingPostalAddress = new PrintFieldDescendingPostalAddress();
        FilterStartsWithName filterStartsWithName = new FilterStartsWithName();
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        ClientSender clientSender = null;
        while (flag) {
            try {
                System.out.print("Enter server host\n> ");
                String host;

                host = in.nextLine();
                System.out.print("Enter server port\n> ");
                int port = Integer.parseInt(in.nextLine());
                clientSender = new ClientSender(host, port);
                ClientSender.socketChannel = SocketChannel.open(ClientSender.socketAddress);
                ClientSender.socketChannel.close();
                flag = false;

            } catch (Exception e) {
                System.out.println("Incorrect data.");
            }
        }
        ClientReceiver receiver = new ClientReceiver(clientSender);
        while (true) {
            System.out.println("Enter you action, use >help to get the list of all commands");
            System.out.print("> ");
            String commandName = in.nextLine();
            if (!commandName.equals("")) {
                try {
                    Map<Command, String> map = CommandExecutor.execute(commandName);
                    if (map != null) {
                        ClientSender.connect();
                        clientSender.send(map);
                        System.out.println(receiver.receive());
                        ClientSender.socketChannel.close();
                    }
                } catch (SocketTimeoutException | InterruptedException e) {
                    System.out.println("Perhaps the server is busy by another user, please wait and try again.");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
