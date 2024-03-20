import java.util.Scanner;
public class quicksort {
    private static int P_T(int[] A, int min, int max) {
        int P = A[max];
        int k=(min-1);
        for (int l=min;l<max;l++) {
            if (A[l] <= P) {
                k++;
                int t = A[k];
                A[k] = A[l];
                A[l] = t;
            }
        }
        int t = A[k+1];
        A[k+1] = A[max];
        A[max] = t;
        return k+1;
    }
    public static int I_S(int[] A, int k) {
        return I_S(A, 0, A.length - 1, k);
    }
    private static int I_S(int[] A, int min, int max, int k) {
        if (k>0 && k<=max-min+1) {
            int P_I = P_T(A, min, max);
            if (P_I-min==k-1)
                return A[P_I];
            if (P_I-min>k- 1)
                return I_S(A, min, P_I - 1, k);
            return I_S(A, P_I + 1, max, k-P_I + min - 1);
        }
        return Integer.MAX_VALUE;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("total elements in an array: ");
        int num = scanner.nextInt();
        int[] A=new int[num];

        System.out.println("Array elements:");
        for (int k=0;k<num;k++) {
            A[k] = scanner.nextInt();
        }
        System.out.print("Ith order statistic: ");
        int k=scanner.nextInt();
        int quicksort = I_S(A, k);
        System.out.println( k + "th order statistic is" + quicksort);
        scanner.close();
    }
}
