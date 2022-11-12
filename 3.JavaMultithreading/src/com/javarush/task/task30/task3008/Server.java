package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage("Cервер запущен...");

            while (true) {
                new Handler(serverSocket.accept()).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
    private Socket socket;

    public Handler (Socket socket) {
        this.socket = socket;
    }

        public void run(){
            ConsoleHelper.writeMessage(socket.getRemoteSocketAddress().toString());
            String name="";
            try (Connection connection = new Connection(socket)){
                name = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));
                notifyUsers(connection, name);
                serverMainLoop(connection, name);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            if(!name.isEmpty()) {
                connectionMap.remove(name);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            String name;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                name = message.getData();
                if (message.getType().equals(MessageType.USER_NAME) && !name.isEmpty()) {
                        if (!connectionMap.containsKey(name)) {
                            connectionMap.put(name, connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED,name));
                            break;
                        }
                    }
                }
            return name;
        }

        private void notifyUsers(Connection connection, String userName) throws IOException{
            for (String name: connectionMap.keySet()
            ) {
                if(!name.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();
                if (message.getType()==(MessageType.TEXT)){
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                } else ConsoleHelper.writeMessage("Error.");
            }
        }
    }

    public static void sendBroadcastMessage(Message message){
        for (Connection con: connectionMap.values()
             ) {
            try {
                con.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Сообщение не отправлено...");
            }
        }
    }

}