package pl.samples.Guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class BimapExample {

    public static void main (String[] args) {
        BiMap<String, String> bimap = HashBiMap.create();

        bimap.put("key-1", "value-1");
        bimap.put("key-2", "value-2");
        bimap.put("key-3", "value-3");
        bimap.put("key-4", "value-4");

        System.out.println("bimap size = " + bimap.size()); // 4
        System.out.println("bimap get by key -> " + bimap.get("key-2")); // value-2
        System.out.println("bimap get by value -> " + bimap.inverse().get("value-2")); // key-2
    }
}
