package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("/Users/work/Desktop/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2001/temp", null);
            OutputStream outputStream = new FileOutputStream("/Users/work/Desktop/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2001/test");
            InputStream inputStream = new FileInputStream("/Users/work/Desktop/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2001/test1");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Rubi");
            user.setLastName("Rail");
            user.setBirthDate(new Date(1508944516168L));
            user.setMale(true);
            user.setCountry(User.Country.OTHER);

            User user1 = new User();
            user1.setFirstName("Vasa1");
            user1.setLastName("Peta1");
            user1.setBirthDate(new Date(1508944516163L));
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);

            User user3 = new User();
            user3.setFirstName("Solo");
            user3.setLastName("Han");
            user3.setBirthDate(new Date(1508944516169L));
            user3.setMale(true);
            user3.setCountry(User.Country.UKRAINE);

            javaRush.users.add(user);
            javaRush.users.add(user1);
            javaRush.users.add(user3);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

//            System.out.println(javaRush.equals(loadedObject));


        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter pR = new PrintWriter(outputStream);
            if(!this.users.isEmpty()) {
                for(User u:users){
                    pR.println(u.getFirstName());
                    pR.println(u.getLastName());
                    pR.println(u.getBirthDate().getTime());
                    pR.println(u.isMale());
                    pR.println(u.getCountry().getDisplayName());
                }
                pR.flush();
                pR.close();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bR = new BufferedReader(new InputStreamReader(inputStream));
            while (bR.ready()) {
                User user = new User();
                  user.setFirstName(bR.readLine());
                  user.setLastName(bR.readLine());
                  user.setBirthDate(new Date(Long.parseLong(bR.readLine())));
                  user.setMale(Boolean.parseBoolean(bR.readLine()));
//                  user.setCountry(User.Country.valueOf(bR.readLine()));
                  switch (bR.readLine()) {
                      case "Russia":
                          user.setCountry(User.Country.RUSSIA);
                          break;
                      case "Ukraine":
                          user.setCountry(User.Country.UKRAINE);
                          break;
                      case "Other":
                          user.setCountry(User.Country.OTHER);
                          break;
                  }
                  this.users.add(user);
            }
            bR.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
