/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quicksort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class QuickSort {


    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        System.out.println("Enter a number of array:");
        int n = validateNumber();
        int[] arr = genRanArray(n);
        System.out.print("Unsort array: " + Arrays.toString(arr) + "\n");
        quickSort(arr, 0, n - 1);
        System.out.print("Sorted array: " + Arrays.toString(arr) + "\n");
    }

    public static int validateNumber() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String input = sc.nextLine();
                if (input.isEmpty()) {
                    System.err.println("Input couldn't be empty");
                }
                int output = Integer.parseInt(input);
                if (output < 1) {
                    System.err.println("Number must larger than zero!!!");
                } else {
                    return output;
                }
            } catch (NumberFormatException e) {
                System.err.println("You must enter a number");
            }
        }
    }

    public static int[] genRanArray(int n) {
        Random rd = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt(n);
        }
        return arr;
    }
    public static void quickSort(int arr[], int begin, int end) {
       if(begin >= end) return;
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            // Recursively sort elements of the two sub-arrays
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }
    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;
        return i + 1;
    }
}
