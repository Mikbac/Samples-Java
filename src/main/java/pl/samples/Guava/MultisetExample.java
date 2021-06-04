package pl.samples.Guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

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

        System.out.println("multiset size = " + multiset.size()); // 5
        System.out.println("multiset aaa quantity = " + multiset.count("aaa")); // 3

    }

}
