package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    List<Entry> entryList;
    int count;

    public CustomTree() {
        this.root = new Entry("0");
        entryList = new LinkedList<>();
        entryList.add(root);
    }

    @Override
    public boolean add(String elementName) {
        Entry<String> top = root;
        int cursor = 0;
        while (cursor++ <= size()) {

                if (top.availableToAddLeftChildren && top.availableToAddRightChildren) {
                    entryList.add(top.leftChild = new Entry<>(elementName));
                    top.availableToAddLeftChildren = false;
                    top.leftChild.parent = top;
                    count++;
                    return true;
                }
                if (top.availableToAddRightChildren) {
                    entryList.add(top.rightChild = new Entry<>(elementName));
                    top.availableToAddRightChildren = false;
                    top.rightChild.parent = top;
                    count++;
                    return true;
                }
                top = entryList.get(cursor);
            }

        return false;
    }

    public String getParent(String elementName) {
        Entry<String> top = root;
        String result = "Нет такого элемента";
        int cursor = 0;
        while (cursor++ < size()) {
            if (!top.availableToAddLeftChildren && top.leftChild.elementName.equals(elementName)) {
                return result = top.elementName;
            }
            if (!top.availableToAddRightChildren && top.rightChild.elementName.equals(elementName)) {
                return result = top.elementName;
            }
            top = entryList.get(cursor);
        }
        return result;
    }

    @Override
    public String get(int index) {
        if (index >= 0 && index <= size()) {
            return entryList.get(index).elementName;
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return count;
    }

    public boolean remove(Object o) {
        if (o == null || !(o instanceof String)) {
            throw new UnsupportedOperationException();
        }

        List<Entry> forRemove = new ArrayList<>();
        Entry<String> top = null;
        
        String search = (String) o;
//        int index = Integer.parseInt(search);
//        if (index >= 0 && index <= size()) {

            for(Entry entry : entryList){
                if (entry.elementName.equals(search)) {
                    top = entry;
                }
            }
            
           
            forRemove.add(top);

            int cursor = -1;
            while (++cursor < forRemove.size()) {
                if (!top.availableToAddLeftChildren) {
                    top.availableToAddLeftChildren = true;
                    forRemove.add(top.leftChild);
                }
                if (!top.availableToAddRightChildren) {
                    top.availableToAddRightChildren = true;
                    forRemove.add(top.rightChild);
                }
                top = forRemove.get(cursor);
            }

            for (Entry entry : forRemove) {
                Entry<String> parent = entry.parent;
                if (!parent.availableToAddLeftChildren && parent.leftChild.elementName.equals(entry.elementName)) {
                    parent.leftChild = null;
                    parent.availableToAddLeftChildren = true;

                } else if (!parent.availableToAddRightChildren && parent.rightChild.elementName.equals(entry.elementName)) {
                    parent.rightChild = null;
                    parent.availableToAddRightChildren = true;
                }
                count--;
                entryList.remove(entry);
            }
            return true;
//        }
//        throw new UnsupportedOperationException();
    }


    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }
}
