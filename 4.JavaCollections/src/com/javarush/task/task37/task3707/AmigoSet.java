package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Cloneable, Serializable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<E, Object>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        this.map = new HashMap<E, Object>(Math.max((int) (collection.size() / .75f) + 1, 16));
        this.addAll(collection);
    }
    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null ? true : false;
    }

    @Override
    public Iterator<E> iterator() {
        return this.map.keySet().iterator();
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.map.containsKey(o);
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return this.map.remove(o, o);
    }

    @Override
    public Object clone() {
        AmigoSet<E> set = new AmigoSet<>();
        try {
            set.map = (HashMap<E, Object>) this.map.clone();
        } catch (Exception e) {
            throw new InternalError(e);
        }
        return set;
    }

    private void writeObject(ObjectOutputStream objectOutputStream){
        try {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
            objectOutputStream.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
            objectOutputStream.writeInt(this.map.keySet().size());
            for (E e: map.keySet()) {
                objectOutputStream.writeObject(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream inputStream){
        try {
            inputStream.defaultReadObject();
            int capacity = inputStream.readInt();
            float loadFactor = inputStream.readFloat();
            map = new HashMap<>(capacity, loadFactor);
            int size = inputStream.readInt();
            for (int i = 0; i < size; i++) {
                map.put((E) inputStream.readObject(), PRESENT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
