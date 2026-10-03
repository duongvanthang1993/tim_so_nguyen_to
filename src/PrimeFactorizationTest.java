class LazyPrimeFactorization implements Runnable {
    @Override
    public void run() {
        int number = 2;
        System.out.println("LazyPrimeFactorization bat dau chay");
        while (true) {
            if (isPrime(number)) {
                System.out.println("[lazy] tim thay so nguyen to " + number);
            }
            number++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("lazyPrimeFactorization bi gian doan");
                break;
            }
        }
    }

    private boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i < n; i++) {
            if (n % 2 == 0) {
                return false;
            }
        }
        return false;
    }
}

class OptimizedPrimeFactorization implements Runnable {
    @Override

    public void run() {
        int number = 2;
        System.out.println("OptimizePrimeFactorization bat dau chay ");

        while (true) {
            if (isPrime(number)) {
                System.out.println("Optimized tim thay so nguyen to " + number);
            }
            number++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("OptimixePrimeFactoryzation bi gian doan");
                break;
            }
        }
    }

    private boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

public class PrimeFactorizationTest {
    public static void main(String[] args) {
        Runnable lazy = new LazyPrimeFactorization();
        Runnable optimized = new OptimizedPrimeFactorization();

        Thread thread1 = new Thread(lazy);
        Thread thread2 = new Thread(optimized);
        thread1.start();
        thread2.start();

    }

}