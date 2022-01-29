import java.util.*;
import java.io.*;
import java.lang.Math;


public class pa1serial 
{
    public static void main (String [] args) 
    {
        long startTime = System.nanoTime();
        int count = 0;
        int sum = 0;
        int n = (int)Math.pow(10, 8);
        Boolean[] prime = new Boolean[n + 1];
        Arrays.fill(prime, Boolean.TRUE);

        for (int i = 2; i * i <= n; i++)
        {
            // if at prime
            if (prime[i] == true)
            {
                // marks primes of multiples
                for (int j = i * i; j <= n; j += i)
                {
                    prime[j] = false;
                    //System.out.println("marking " + j + " true");
                }
            }
        }

        for (int k = 2; k <= n; k++)
        {
            if (prime[k] == true)
            {
                count++;
                sum += k;
                //System.out.println(k + " is prime");
            }
        }

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        
        System.out.println("Time: " + totalTime + "nanoseconds");
        System.out.println("Count: " + count + " primes");
        System.out.println("Sum: " + count);
        
        
    }
}


