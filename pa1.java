import java.util.*;
import java.io.*;
import java.lang.Math;
import java.util.concurrent.atomic.AtomicBoolean;


public class pa1 
{
    
    public static void main (String [] args) 
    {
        long startTime = System.nanoTime();
        //final AtomicBoolean prime = new AtomicBoolean();
        final AtomicBoolean[] prime = new AtomicBoolean[(int)Math.pow(10, 8)];
        for(int i = 0; i < prime.length; i++)
            prime[i] = new AtomicBoolean(false);
        


        for (int i = 0; i < 8; i++)
        {
            MultithreadThing thread = new MultithreadThing(i, prime);
            Thread myThread = new Thread(thread);
            myThread.start();
        }

        int count = 0;
        int sum = 0;
        for (int k = 2; k < Math.pow(10, 8); k++)
        {
            if (prime[k].get() == true)
            {
                count++;
                sum += k;
                System.out.println(k + " is prime");
            }
        }

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        
        System.out.println("Time: " + totalTime + "nanoseconds");
        System.out.println("Count: " + count + " primes");
        System.out.println("Sum: " + sum);
    }
}


class MultithreadThing implements Runnable {

    private int threadNum;
    final AtomicBoolean[] prime;
    public MultithreadThing (int threadNum, final AtomicBoolean[] prime) 
    {
        this.threadNum = threadNum;
        this.prime = prime;
    }




    @Override
    public void run() 
    {
        System.out.println("this is thread " + threadNum);

        int sum = 0;
        int n = (int)Math.pow(10, 8) / 8;
        int start = threadNum * n;
        int finish = threadNum * (n + 1);

        if (start == 0)
            start = 2;

        for (int i = start; i * i <= n * 8; i++)
        {
            // if at prime
            if (prime[i].get() == false)
                System.out.println("false");
            
            if (prime[i].get() == true)
            {
                // marks primes of multiples
                for (int j = i * i; j <= n * 8; j += i)
                {
                    prime[j].set(false);
                    System.out.println("marking " + j + " true");
                }
            }
        }


    }
}