import java.util.Scanner;

class MergeSort {

    static void merge(int[] a, int left, int mid, int right) {

        int i = left;
        int j = mid + 1;
        int k = 0;

        int[] temp = new int[right - left + 1];

        while (i <= mid && j <= right) {

            if (a[i] < a[j]) {
                temp[k] = a[i];
                i++;
            } else {
                temp[k] = a[j];
                j++;
            }

            k++;
        }

        while (i <= mid) {
            temp[k] = a[i];
            i++;
            k++;
        }

        while (j <= right) {
            temp[k] = a[j];
            j++;
            k++;
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            a[i] = temp[k];
        }
    }

    static void sort(int[] a, int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;

            sort(a, left, mid);
            sort(a, mid + 1, right);

            merge(a, left, mid, right);
        }
    }

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

        sort(a, 0, n - 1);

        System.out.print("\nSorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        sc.close();
    }
}