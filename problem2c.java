public class SinglyLinkedList {
    private static final int MAX_SIZE = 100;
    private int[] data = new int[MAX_SIZE];
    private int[] next = new int[MAX_SIZE];
    private int head = -1;
    private int tail = -1;
    private int size = 0;
    public void insert(int value) {
        if (size == MAX_SIZE) {
            System.out.println("list is full.");
            return;
        }

        if (head == -1) {
            head = 0;
            tail = 0;
        } else {
            next[tail] = tail + 1;
            tail++;
        }

        data[tail] = value;
        size++;
    }
    public void delete(int value) {
        int current = head;
        int prev = -1;

        while (current != -1) {
            if (data[current] == value) {
                if (prev == -1) {
                    head = next[current];
                } else {
                    next[prev] = next[current];
                }

                size--;
                return;
            }

            prev = current;
            current = next[current];
        }

        System.out.println("list does not found element.");
    }
    public boolean search(int value) {
        int current = head;

        while (current != -1) {
            if (data[current] == value) {
                return true;
            }
            current = next[current];
        }

        return false;
    }
    public void printList() {
        int current = head;
        System.out.print("List: ");
        while (current != -1) {
            System.out.print(data[current] + " ");
            current = next[current];
        }
        System.out.println();
    }
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        list.printList();

        list.delete(3);
        list.printList();
    }
}
