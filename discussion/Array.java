public class Array {
    public static int[] insert(int[] arr, int item, int position) {
        int[] a = new int[arr.length + 1];
        if (position > arr.length)
        {
            int i = 0;
            while (i < arr.length)
            {
                a[i] = arr[i];
                i++;
            }
            a[i] = item;
            return  a;
        }
        int i = 0;
        while (i < position) {
            a[i] = arr[i];
            i++;
        }
        a[i] = item;
        while (i < arr.length) {
            a[i + 1] = arr[i];
            i++;
        }
        return a;
    }
    public static void reverse(int[] arr)
    {
        for (int i = 0; i < arr.length/2; i++)
        {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - i - 1] = temp;
        }
    }

    public static int[] replicate(int[] arr)
    {
        int length = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == 0)
                length += 1;
            else
                length += arr[i];
        }
        int[] a = new int[length];
        int index = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == 0) {
                a[index] = 0;
                index += 1;
            }
            else
            {
                int j = 0;
                while (j < arr[i])
                {
                    a[index+j] = arr[i];
                    j++;
                }
                index += j;
            }
        }
        return a;
    }

    public static int[] flatten(int[][] a)
    {
        int totallength = 0;
        for (int i = 0; i < a.length; i++)
        {
            totallength += a[i].length;
        }
        int[] x = new int[totallength];
        int xindex = 0;
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                x[xindex] = a[i][j];
                xindex++;
            }
        }
        return x;
    }

    public static void main(String[] args)
    {
        int[] a = {1,2,3};
        reverse(a);
        int[] b = replicate(a);
        int[] c = insert(a,4,3);
        int[] d = insert(c,5,2);
        int[][] x = {{1,2,3},{},{7,8}};
        int[] e = flatten(x);
    }
}
