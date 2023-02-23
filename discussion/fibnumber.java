public class fibnumber {
    public static int fib(int n)
    {
        if (n == 1 || n == 2)
            return n - 1;
        int i = 2;
        int f0 = 0;
        int f1 = 1;
        while (i < n)
        {
            int x = f0 + f1;
            f0 = f1;
            f1 = x;
            i++;
        }
        return f1;
    }

    public static int fib2 (int n, int k, int f0, int f1)
    {
        if (n == k)
            return f0;
        else
            return  fib2(n, k+1, f1, f1+f0);
    }

    public static void main(String[] args)
    {
        int x = fib(10);
        int y = fib2(10,1,0,1);
    }
}
