import java.util.Scanner;
public class Queue {
    int[] A;
    int h, t, len;
    public Queue(int n) {
        len = n;
        A = new int[len];
        h = 0;
        t = 0;
    }
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        A[t] = value;
        t = (t + 1) % len;
    }
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int value = A[h];
        h = (h + 1) % len;
        return value;
    }
    public boolean isEmpty() {
        return h == t;
    }
    public boolean isFull() {
        return (t + 1) % len == h;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Length of the queue: ");
        int n = scanner.nextInt();
        Queue queue = new Queue(n);
        System.out.println("Enqueue elements: ");
        scanner.nextLine();
        String[] elements = scanner.nextLine().split("\\s+");
        for (String str : elements) {
            queue.enqueue(Integer.parseInt(str));
        }
        System.out.println("Dequeue elements: ");
        int dq;
        while ((dq = queue.dequeue()) != -1) {
            System.out.println(dq);
        }
        scanner.close();
    }
}


OUTPUT:
Length of the queue: 5
Enqueue elements: 
2 3 4 1 5
Queue is full
Dequeue elements: 
2
3
4
1
Queue is empty
