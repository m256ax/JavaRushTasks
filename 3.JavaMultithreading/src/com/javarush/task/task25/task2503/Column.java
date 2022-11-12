package com.javarush.task.task25.task2503;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable{
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();
//        for (Column column : values()) {
//            if(column.isShown()) result.add(column);
//        }
//        List<Column> res = new LinkedList<>();
//        for( int i=1; i<=result.size(); i++) {
//            res.add(i-1, result.get(result.size()-i));
//        }

        for (int i = 0; i < realOrder.length; i++)
            result.add(null);

        Column[] values = Column.values();
        for (int i = 0; i < realOrder.length; i++){
            if (realOrder[i] != -1){
                result.add(realOrder[i], values[i]);
            }
        }

        Iterator iterator = result.iterator();
        while (iterator.hasNext()){
            Object column = iterator.next();
            if (column == null)
                iterator.remove();
        }
        return result;
    }

    @Override
    public String getColumnName() {
        return Column.this.columnName;
    }

    @Override
    public boolean isShown() {
        boolean bool=false;
        if (realOrder[this.ordinal()]!=-1) bool=true;
        return bool;
    }

    @Override
    public void hide() {
        List<Column> result = Column.getVisibleColumns();
        result.remove(this);

        Column.realOrder[this.ordinal()] = -1;
        Column [] newOrder = result.toArray(new Column[result.size()]);
        configureColumns(newOrder);
    }
}
