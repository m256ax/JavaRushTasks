package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BotClient extends Client{

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
        protected SocketThread getSocketThread(){
            return new BotSocketThread();
        }

        protected boolean shouldSendTextFromConsole(){
            return false;
        }

        protected String getUserName(){
            return "date_bot_" + (int)(Math.random()*100);
        }

    public class BotSocketThread extends SocketThread{

        protected void clientMainLoop() throws IOException, ClassNotFoundException{
           sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
           super.clientMainLoop();
        }

    @Override
    protected void processIncomingMessage(String message){
        ConsoleHelper.writeMessage(message);
        if (!message.contains(": ")) return;
        String [] strings = message.split(": ");
        String name = strings[0];
        Calendar calendar = new GregorianCalendar();
        Date date = calendar.getTime();
        String answer = strings[1].trim();
        String sdf = "";
        switch (answer){
            case "дата": sdf = new SimpleDateFormat("d.MM.YYYY").format(date);
            break;
            case "день": sdf = new SimpleDateFormat("d").format(date);
            break;
            case "месяц": sdf = new SimpleDateFormat("MMMM").format(date);
            break;
            case "год": sdf = new SimpleDateFormat("YYYY").format(date);
            break;
            case "время": sdf = new SimpleDateFormat("H:mm:ss").format(date);
            break;
            case "час": sdf = new SimpleDateFormat("H").format(date);
            break;
            case "минуты": sdf = new SimpleDateFormat("m").format(date);
            break;
            case "секунды": sdf = new SimpleDateFormat("s").format(date);
            break;
            default: return;
        }
        sendTextMessage(String.format("Информация для %s: %s", name, sdf));
    }
    }
}
