import java.util.Scanner;

class LinearSearch {
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

        System.out.print("\nEnter element to search: ");
        int key = sc.nextInt();

        // Searching
        for (int i = 0; i < n; i++) {

            if (a[i] == key) {
                System.out.println("Element found at index: " + i);
                return;
            }
        }

        System.out.println("Element not found");
        sc.close();
    }
}