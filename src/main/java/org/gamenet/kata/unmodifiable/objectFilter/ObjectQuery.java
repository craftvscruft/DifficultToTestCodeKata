package org.gamenet.kata.unmodifiable.objectFilter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ObjectQuery<E> {
    private final Map<String, Object> valueByKeyMap = new HashMap<>();
    private Class<E> objectClass = null;

    public ObjectQuery(Class<E> objectClass) {
        this.objectClass = objectClass;
    }

    public List<E> getObjects(List<E> objectList) throws NoSuchFieldException, IllegalAccessException {
        List<E> matchingList = new ArrayList<>(objectList);
        for (Map.Entry<String, Object> entry : valueByKeyMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            // Use reflection to determine if query criteria matches the object
            Field field = objectClass.getField(key);
            for (Iterator<E> iterator = objectList.iterator(); iterator.hasNext(); ) {
                E e = iterator.next();
                Object fieldValue = field.get(e);
                if (!value.equals(fieldValue)) {
                    matchingList.remove(e);
                }
            }
        }

        return matchingList;
    }

    public void add(String key, Object value) {
        valueByKeyMap.put(key, value);
    }
}
