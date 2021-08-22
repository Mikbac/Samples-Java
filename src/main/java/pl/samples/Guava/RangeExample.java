package pl.samples.Guava;

import com.google.common.collect.Range;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class RangeExample {

    public static void main(String[] args) {

        boolean exampleOne = Range.closed(5, 10).isConnected(Range.closed(10, 15));
        log.info(exampleOne); // true

        boolean exampleTwo = Range.open(5, 10).isConnected(Range.open(10, 15));
        log.info(exampleTwo); // false

        boolean exampleThree = Range.closed(5, 10).isConnected(Range.open(9, 15));
        log.info(exampleThree); // true

        Range<Integer> exampleFour = Range.closed(0, 10).intersection(Range.closed(7, 20));
        log.info(exampleFour); // [7..10] // maximum range

        Range<Integer> exampleFive = Range.closed(0, 10).span(Range.closed(7, 20));
        log.info(exampleFive); // [0..20] // minimal range
    }

}
