package pl.samples.Guava;

import com.google.common.collect.Range;

public class RangeExample {

    public static void main(String[] args) {

        boolean exampleOne = Range.closed(5, 10).isConnected(Range.closed(10, 15));
        System.out.println(exampleOne); // true

        boolean exampleTwo = Range.open(5, 10).isConnected(Range.open(10, 15));
        System.out.println(exampleTwo); // false

        boolean exampleThree = Range.closed(5, 10).isConnected(Range.open(9, 15));
        System.out.println(exampleThree); // true

        Range<Integer> exampleFour = Range.closed(0, 10).intersection(Range.closed(7, 20));
        System.out.println(exampleFour); // [7..10] // maximum range

        Range<Integer> exampleFive = Range.closed(0, 10).span(Range.closed(7, 20));
        System.out.println(exampleFive); // [0..20] // minimal range
    }

}
