package com.javarush.task.task20.task2005;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* 
Очень странные дела
*/

public class Solution {
    public static void main(String[] args) {
        //исправь outputStream/inputStream в соответствии с путем к твоему реальному файлу
        try {
            File your_file_name = File.createTempFile("/Users/work/Desktop/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2001/temp", null);
            OutputStream outputStream = new FileOutputStream("/Users/work/Desktop/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2001/test");
            InputStream inputStream = new FileInputStream("/Users/work/Desktop/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2001/test1");

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
            inputStream.close();

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Human human = (Human) o;
            return Objects.equals(name, human.name) &&
                    Objects.equals(assets, human.assets);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, assets);
        }

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
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
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            this.name = reader.readLine();
            int size = Integer.parseInt(reader.readLine());
            if (size != 0) {
                while (reader.ready()) {
                    Asset asset = new Asset(reader.readLine());
                    asset.setPrice(Double.parseDouble(reader.readLine()));
                    this.assets.add(asset);
                }
            }
                reader.close();
        }
    }
}