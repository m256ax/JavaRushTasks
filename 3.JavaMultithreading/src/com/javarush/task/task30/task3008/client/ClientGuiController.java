package com.javarush.task.task30.task3008.client;

public class ClientGuiController extends Client{
    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);

    public static void main(String[] args) {
        new ClientGuiController().run();
    }

    @Override
    protected SocketThread getSocketThread(){
//    - должен создавать и возвращать объект типа GuiSocketThread.
        return new GuiSocketThread();
    }

    @Override
    public void run() {
//    - должен получать объект SocketThread через метод getSocketThread() и вызывать у него метод run().
//    Разберись, почему нет необходимости вызывать метод run() в отдельном потоке, как мы это делали для консольного клиента.
        SocketThread socketThread = getSocketThread();
        socketThread.run();
    }

    public String getServerAddress(){
        return view.getServerAddress();
    }

    public int getServerPort(){
        return view.getServerPort();
    }

    public String getUserName(){
        return view.getUserName();
    }
//    Они должны вызывать одноименные методы из представления (view).

    public ClientGuiModel getModel(){
        return model;
    }

    public class GuiSocketThread extends SocketThread {

        public void processIncomingMessage(String message){
//        - должен устанавливать новое сообщение у модели и вызывать обновление вывода сообщений у представления.
            model.setNewMessage(message);
            view.refreshMessages();
        }

        public void informAboutAddingNewUser(String userName){
//        - должен добавлять нового пользователя в модель и вызывать обновление вывода пользователей у отображения.
            model.addUser(userName);
            view.refreshUsers();
        }

        public void informAboutDeletingNewUser(String userName){
//        - должен удалять пользователя из модели и вызывать обновление вывода пользователей у отображения.
            model.deleteUser(userName);
            view.refreshUsers();
        }

        public void notifyConnectionStatusChanged(boolean clientConnected){
            view.notifyConnectionStatusChanged(clientConnected);
        }

    }
}
