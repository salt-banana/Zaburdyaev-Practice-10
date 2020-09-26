package SumOfDigits;

import java.util.Scanner;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.Random;

public class Main {


    static int spf[];
    static Random random = new Random();



    public static int digitsSum(int x) {
        if (x == 0)
            return x;
        return x%10 + digitsSum(x/10);

    }




    public static int gcd(int a, int b) {
        int max = max(a,b);
        int min = min(a,b);
        if (max % min == 0)
            return min;
        return gcd(min, max % min);
    }



    public static int power(int a, int n, int m) {

        int result = 1;

        a = a % m;

        while (n > 0) {
            if (n % 2 == 1)
                result = (result * a) % m;
            n = n / 2;
            a = (a * a) % m;
        }

        return result;

    }



    public static boolean isPrime(int p) {
        int a = 2 + random.nextInt(p-2);
        if (gcd(a,p) != 1)
            return false;
        return power(a,p-1, p) == 1;
    }



    public static void sieve(int x) {

        spf = new int[x+1];

        spf[1] = 1;

        for (int i = 2; i < x+1; i++)
            spf[i] = i;
        for (int i = 4; i < x+1; i+=2)
            spf[i] = 2;

        for (int i = 3; i*i < x+1; i++) {
            if (spf[i] == i) {
                for (int j = i*i; j < x+1; j += i) {
                    if (spf[j] == j)
                        spf[j] = i;
                }
            }
        }

    }



    public static void printPrimeFactors(int x) {

        sieve(x);

        while (x != 1) {
            System.out.print(spf[x] + " ");
            x = x / spf[x];
        }

    }



    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("ENTER A NUMBER TO GET SUM OF IT'S DIGITS: ");
        int numToSum = in.nextInt();

        System.out.print("ENTER A NUMBER TO CHECK IF IT'S PRIME: ");
        int checkPrimeNum = in.nextInt();

        System.out.print("ENTER A NUMBER TO GET IT'S PRIME FACTORIZATION: ");
        int factorizeNum = in.nextInt();

        in.close();


        int sumOfDigits = digitsSum(numToSum);
        boolean isPrimeNum = isPrime(checkPrimeNum);


        System.out.println("SUM OF DIGITS: " + sumOfDigits);


        System.out.print("IS " + checkPrimeNum + " PRIME: ");

        if (isPrimeNum)
            System.out.println("YES");
        else
            System.out.println("NO");


        System.out.print("PRIME FACTORS OF " + factorizeNum + " : ");
        printPrimeFactors(factorizeNum);

    }

}
