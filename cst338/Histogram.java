// Kyle Xyian Dilbeck 
// CST338 | HW1 
// 2/3/2020
// This program will take input and create/read a new file to create a histogram from the given values 
// v1.3.4

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class Histogram {
    public static void main(String args[]) {
        int count = 0;
        int i = 0;
        String filename;
        Scanner S = new Scanner(System.in);
        filename = S.next();
        File f = new File(filename);
        Scanner scan = null;
        try {
            if (f.createNewFile()) {
            }
            scan = new Scanner(f);
        } catch (IOException e) {
            System.out.println("Problem when making the file... " + e);
            e.printStackTrace();
        }
        int counter = 0;
        int[] arr2 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int size = 11;
        char input;
        char[] arr = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};
        while (scan != null && scan.hasNext()) {
            input = scan.next().charAt(counter);
            for (int k = 0; k < 11; k++) {
                if (arr[k] == input) {
                    arr2[k]++;
                }
            }
        }
        System.out.println("Char  Occurrence");
        for(int m = 0; m < 11; m++){
            if(arr2[m]>0){
                System.out.print(" " + arr[m]+ "     ");
                System.out.println("   " + arr2[m]);
            }
        }
        for (int j = 0; j < size - 1; j++) {
            for (int l = 0; l < size - i - 1; l++) {
                if (arr2[l] > arr2[l + 1]) {
                    int temp = arr2[l + 1];
                    char temp2 = arr[l + 1];
                    arr2[l + 1] = arr2[l];
                    arr[l + 1] = arr[l];
                    arr2[l] = temp;
                    arr[l] = temp2;
                }
            }
        }
        count = arr2[10];
        System.out.println("============= Vertical Bar ============= ");
        for(int n = 0; n < 11; n++){
            if(count > 0) {
                System.out.print("| " + count + " |");
                for(int q = 0; q < 11; q++){
                    if(arr2[q] >= count){
                        System.out.print("  *");
                    }else{
                        System.out.print("   ");
                    }
                }
                count = count - 1;
                System.out.println();
            }
        }
        System.out.println("========================================");
        System.out.print("| No | ");
        for(int b=0;b<11;b++){
            System.out.print(arr[b] + "  ");
        }
        System.out.println();
        System.out.println("========================================");
    }
}