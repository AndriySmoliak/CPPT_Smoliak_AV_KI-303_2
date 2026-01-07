package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class labSmoliakKI303 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ввід розміру матриці
        System.out.println("Введіть розмір матриці: ");
        int row = sc.nextInt();

        // Ввід символа заповнювача
        System.out.println("Введіть символ заповнювач: ");
        String symbol = sc.next();

        if (symbol.length() != 1) {
            System.out.println("Введіть коректний символ заповнювач");
            return;
       

        { String[][] arr = createLengthOfEachSubArr(row);
        String fileName = "Lab1.txt";
        }
         
        
   
    public static void printMatrix(String[][] arr, String symbol, String edgeSymbol, int row, String file) throws IOException {
        System.out.println("Результат матриці: ");

        try (FileWriter writer = new FileWriter(file)) {

            int mid = row / 2;

            for (int i = 0; i < row; i++) {
                int indexJ = 0;

                for (int j = 0; j < row; j++) {

                    if ((i + j >= mid) && (j - i <= mid) && (i - j <= mid) && (i + j <= (3 * mid))) {

                        // ✅ КРАЙ / СЕРЕДИНА
                        if (indexJ == 0 || indexJ == arr[i].length - 1)
                            arr[i][indexJ] = edgeSymbol;
                        else
                            arr[i][indexJ] = symbol;

                        writer.write(arr[i][indexJ] + " ");
                        System.out.print(arr[i][indexJ] + " ");

                        indexJ++;
                    } else {
                        writer.write("  ");
                        System.out.print("  ");
                    }
                }
                System.out.println();
                writer.write("\n");
            }

            writer.flush();
        }
    }

    
    public static String[][] createLengthOfEachSubArr(int row) {
        String[][] arr = new String[row][];

        int mid = row / 2;

        for (int i = 0; i < row; i++) {
            int length = 0;

            for (int j = 0; j < row; j++) {
                if ((i + j >= mid) && (j - i <= mid) && (i - j <= mid) && (i + j <= (3 * mid))) {
                    length++;
                }
            }

            arr[i] = new String[length];
        }

        return arr;
    }
}
