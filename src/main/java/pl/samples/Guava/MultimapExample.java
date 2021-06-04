package pl.samples.Guava;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;

public class MultimapExample {

    private static final String USER_CART_ONE = "user-cart-1";
    private static final String USER_CART_TWO = "user-cart-2";

    public static void main(String[] args) {

        Multimap<String, String> multimap = MultimapBuilder
                .hashKeys()
                .arrayListValues()
                .build();

        multimap.put(USER_CART_ONE, "apple");
        multimap.put(USER_CART_ONE, "banana");
        multimap.put(USER_CART_ONE, "lemon");

        multimap.put(USER_CART_TWO, "scissors");
        multimap.put(USER_CART_TWO, "pen");

        System.out.println("multimap key quantity = " + multimap.keySet().size()); // 2
        System.out.println("multimap size = " + multimap.size()); // 5

        multimap.get(USER_CART_ONE).forEach(k -> {
            System.out.println(k); // [apple, banana, lemon]
        });

    }

}
