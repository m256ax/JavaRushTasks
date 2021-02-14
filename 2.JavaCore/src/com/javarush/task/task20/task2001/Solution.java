package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("/Users/work/Desktop/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2001/temp", null);
            OutputStream outputStream = new FileOutputStream("/Users/work/Desktop/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2001/test");
            InputStream inputStream = new FileInputStream("/Users/work/Desktop/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2001/test1");

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
//            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
//            oos.writeObject(this.name);
//            oos.writeObject(this.assets);

            PrintWriter pW = new PrintWriter(outputStream);
            pW.println(this.name);
            if (this.assets.isEmpty()) pW.println("0");
            else {
                pW.println(this.assets.size());
                for (int i = 0; i < this.assets.size(); i++) {
                    pW.println(this.assets.get(i).getName());
                    pW.println(this.assets.get(i).getPrice());
                }
            }
            pW.flush();
            pW.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
//            ObjectInputStream ois = new ObjectInputStream(inputStream);
//            this.name = (String) (ois.readObject());
//            this.assets = (List<Asset>) ois.readObject();
            BufferedReader bR = new BufferedReader(new InputStreamReader(inputStream));
            this.name = bR.readLine();
            int size = Integer.parseInt(bR.readLine());
            if (size != 0) {
                for (int i = 0; i < size; i++) {
                    this.assets.add(new Asset(bR.readLine(), Double.parseDouble(bR.readLine())));
                }
                bR.close();
            }
        }
    }
}