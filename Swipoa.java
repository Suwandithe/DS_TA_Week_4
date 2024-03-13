import java.util.Scanner;

public class Swipoa {
    // Iterative SWIPOA algorithm
    public static int[] swipoaIterative(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i += 2) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
            if (i < n - 2 && arr[i + 1] < arr[i + 2]) {
                int temp = arr[i + 1];
                arr[i + 1] = arr[i + 2];
                arr[i + 2] = temp;
            }
        }
        return arr;
    }

    // Recursive SWIPOA algorithm
    public static int[] swipoaRecursive(int[] arr, int i) {
        if (i >= arr.length - 1) {
            return arr;
        }
        if (arr[i] > arr[i + 1]) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        if (i < arr.length - 2 && arr[i + 1] < arr[i + 2]) {
            int temp = arr[i + 1];
            arr[i + 1] = arr[i + 2];
            arr[i + 2] = temp;
        }
        return swipoaRecursive(arr, i + 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose method:");
        System.out.println("1. Iterative");
        System.out.println("2. Recursive");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        int[] arr = {5, 3, 8, 2, 1, 4};

        switch (choice) {
            case 1:
                // Iterative SWIPOA
                System.out.print("Original array: ");
                printArray(arr);
                int[] resultIterative = swipoaIterative(arr.clone());
                System.out.print("Array after SWIPOA (iterative): ");
                printArray(resultIterative);
                break;
            case 2:
                // Recursive SWIPOA
                System.out.print("Original array: ");
                printArray(arr);
                int[] resultRecursive = swipoaRecursive(arr.clone(), 0);
                System.out.print("Array after SWIPOA (recursive): ");
                printArray(resultRecursive);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    // Utility method to print array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
