package ro.bogdanmunteanu.testapp.helpers;

import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

/**
 * Created by Bogdan on 3/7/2018.
 */

public class NumberHelper {

    //using minSdk 24 so can generate a Fibonacci list in a clean way :)
    public static List<Integer> generateFibonacciList(int series) {
        return Stream.iterate(new int[]{0, 1}, s -> new int[]{s[1], s[0] + s[1]})
                .limit(series)
                .map(n -> n[0])
                .collect(toList());
    }


    //checks whether an int is prime or not.
    boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
