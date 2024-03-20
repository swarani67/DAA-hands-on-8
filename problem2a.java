import java.util.Scanner;
public class Main {
    int[] A;
    int tp, x;
    public void push(int value) {
        if (tp==x) {
            System.out.println("Stack Overflow/Full");
            return;
        }
        A[tp++]=value;
    }
   public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow/Empty");
            return -1;
        }
        return A[tp--];
   }
    public boolean isEmpty() {
        return tp==0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Length of stack:");
        int len = scanner.nextInt();
        Stack st=new Stack(len);
        System.out.println("Elements of array:");
        scanner.nextLine();
        String[] n=scanner.nextLine().split("\\s+");
        for (String str:n) {
            st.push(Integer.parseInt(str));
        }
        System.out.println("Does stack is empty? : " + st.isEmpty());
        System.out.println("Order of elements that are popped:");
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
        scanner.close();
    }
}


OUTPUT:
Length of stack:6
Elements of array:
5 4 8 6 2 1
Does stack is empty? : false
Order of elements that are popped:
1
2
6
8
4
5
