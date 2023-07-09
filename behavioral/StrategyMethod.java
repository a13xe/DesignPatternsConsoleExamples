package behavioral;

import java.util.Arrays;
import java.util.Scanner;

interface SortingStrategy {
    void sort(int[] arr);
}

class BubbleSort implements SortingStrategy {
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Bubble Sort: " + Arrays.toString(arr));
    }
}

class SelectionSort implements SortingStrategy {
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        System.out.println("Selection Sort: " + Arrays.toString(arr));
    }
}

class InsertionSort implements SortingStrategy {
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        System.out.println("Insertion Sort: " + Arrays.toString(arr));
    }
}

public class StrategyMethod {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a list of numbers (space-separated): ");
            String input = scanner.nextLine();
            int[] numbers = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

            SortingStrategy sortingStrategy;
            System.out.println("Select sorting algorithm:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Insertion Sort");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    sortingStrategy = new BubbleSort();
                    break;
                case 2:
                    sortingStrategy = new SelectionSort();
                    break;
                case 3:
                    sortingStrategy = new InsertionSort();
                    break;
                default:
                    System.out.println("Invalid choice. Using Bubble Sort.");
                    sortingStrategy = new BubbleSort();
            }
            sortingStrategy.sort(numbers);
        }
    }
}
