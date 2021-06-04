package pl.samples.Guava;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

public class RangeSetExample {

    public static void main(String[] args) {
        RangeSet<Integer> rangeSet = TreeRangeSet.create();

        rangeSet.add(Range.closed(0, 5));
        rangeSet.add(Range.closed(5, 10));
        rangeSet.add(Range.closed(11, 15));

        System.out.println("range set contains 6 -> " + rangeSet.contains(6)); // true
    }
}
