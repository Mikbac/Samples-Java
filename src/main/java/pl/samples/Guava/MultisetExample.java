package pl.samples.Guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class MultisetExample {

    public static void main(String[] args) {
        Multiset<String> multiset = HashMultiset.create();

        multiset.add("aaa");
        multiset.add("bbb");
        multiset.add("ccc");
        multiset.add("ddd");
        multiset.add("eee");
        multiset.add("aaa");
        multiset.add("aaa");
        multiset.add("eee");

        log.info("multiset size = {}", multiset.size()); // 5
        log.info("multiset aaa quantity = {}", multiset.count("aaa")); // 3

    }

}
