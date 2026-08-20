import java.util.Scanner;

class HeapSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] a = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.print("Original array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        // Create Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {

            int parent = i;

            while (2 * parent + 1 < n) {

                int child = 2 * parent + 1;

                if (child + 1 < n && a[child + 1] > a[child]) {
                    child++;
                }

                if (a[parent] >= a[child]) {
                    break;
                }

                int temp = a[parent];
                a[parent] = a[child];
                a[child] = temp;

                parent = child;
            }
        }

        // Sort
        for (int i = n - 1; i > 0; i--) {

            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            int parent = 0;

            while (2 * parent + 1 < i) {

                int child = 2 * parent + 1;

                if (child + 1 < i && a[child + 1] > a[child]) {
                    child++;
                }

                if (a[parent] >= a[child]) {
                    break;
                }

                temp = a[parent];
                a[parent] = a[child];
                a[child] = temp;

                parent = child;
            }
        }

        System.out.print("\nSorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}