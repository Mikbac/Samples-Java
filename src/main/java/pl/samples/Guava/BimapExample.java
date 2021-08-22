package pl.samples.Guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BimapExample {

    public static void main(String[] args) {
        BiMap<String, String> bimap = HashBiMap.create();

        bimap.put("key-1", "value-1");
        bimap.put("key-2", "value-2");
        bimap.put("key-3", "value-3");
        bimap.put("key-4", "value-4");

        log.info("bimap size = {}", bimap.size()); // 4
        log.info("bimap get by key -> {}", bimap.get("key-2")); // value-2
        log.info("bimap get by value -> {}", bimap.inverse().get("value-2")); // key-2
    }
}
