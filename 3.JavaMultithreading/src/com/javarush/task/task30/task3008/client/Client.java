package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        try {
            synchronized (this) {
                this.wait();
            } } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("При работе клиента возникла ошибка");
        }

        while (clientConnected){
                String string = ConsoleHelper.readString();
                if (string.equals("exit")) break;
                if(shouldSendTextFromConsole()) sendTextMessage(string);
            }
    }

    public class SocketThread extends Thread{

        public void run(){
            try {
                ConsoleHelper.writeMessage("Введите адрес сервера...");
                String address = getServerAddress();
                ConsoleHelper.writeMessage("Введите порт...");
                int port = getServerPort();
                Client.this.connection = new Connection(new Socket(address, port));
                ConsoleHelper.writeMessage("Введите Ваше имя...");
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }

        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " присоеденился к чату");
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " вышел из чата");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();
                if (message.getType()==MessageType.NAME_REQUEST) {connection.send(new Message(MessageType.USER_NAME, getUserName()));}
                 else if (message.getType()==MessageType.NAME_ACCEPTED) {notifyConnectionStatusChanged(true); break;}
                 else  throw new IOException("Unexpected MessageType");
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while (true) {
                Message message = connection.receive();
                if (message.getType()==MessageType.TEXT) processIncomingMessage(message.getData());
                else if (message.getType()==MessageType.USER_ADDED) informAboutAddingNewUser(message.getData());
                else if (message.getType()==MessageType.USER_REMOVED) informAboutDeletingNewUser(message.getData());
                else  throw new IOException("Unexpected MessageType");
            }
        }
    }

    protected String getServerAddress(){
        return ConsoleHelper.readString();
    }

    protected int getServerPort(){
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
         return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            e.printStackTrace();
            clientConnected=false;
        }
    }
}
