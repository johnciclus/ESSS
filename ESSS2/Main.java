package ESSS2;

import java.util.*;

public class Main {

    public static int[] primes;

    public static void main(String[] args) {
        Integer value;

        definePrimes(100000000);

        if (validations(args)) {
            value = Integer.valueOf(args[0]);
            System.out.println(getFactors(value).size());
        }
    }

    public static List<Integer> getFactors(int value){
        List<Integer> factors = new ArrayList<Integer>();
        Boolean isPrime = false;
        Integer p;

        if(value >= 1) {
            while (value > 1) {
                p = 0;
                while (!isPrime) {
                    if (value % primes[p] == 0) {
                        isPrime = true;
                        factors.add(primes[p]);
                        value = value / primes[p];
                    }
                    p++;
                }
                if (isPrime) {
                    isPrime = false;
                }
            }
        }
        return factors;
    }

    public static void definePrimes(int n){
        // initially assume all integers are prime
        boolean[] isPrime = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // mark non-primes <= n using Sieve of Eratosthenes
        for (int factor = 2; factor*factor <= n; factor++) {

            // if factor is prime, then mark multiples of factor as nonprime
            // suffices to consider mutiples factor, factor+1, ...,  n/factor
            if (isPrime[factor]) {
                for (int j = factor; factor*j <= n; j++) {
                    isPrime[factor*j] = false;
                }
            }
        }

        // count primes
        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) count++;
        }

        primes = new int[count];
        count = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]){
                primes[count] = i;
                count++;
            }
        }
    }

    public static boolean validations(String[] args){
        if(args.length == 1){
            Integer value = Integer.valueOf(args[0]);
            if(value >= 1000 && value <= 1000000000 ){
                return true;
            }
            else{
                System.out.println("An error has occurred");
                System.out.println("The value value should be between 10^3 and 10^9");
            }
        }
        else{
            System.out.println("An error has occurred");
            System.out.println("Please enter a number as argument");
        }
        System.exit(1);
        return false;
    }
}
