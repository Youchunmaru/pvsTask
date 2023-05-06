package Blatt04_2020;

import java.io.*;
import java.util.Scanner;

public class BigInput {

    public static void main(String[] args) throws IOException {

        readInt();
        readString();
    }

    static void readInt() throws FileNotFoundException {

        long start = System.currentTimeMillis();
        Scanner in = new Scanner(new FileInputStream("C:\\Users\\samue\\IdeaProjects\\PvS\\bigInput.txt"));
        long sum = 0;
        while(in.hasNext()){
            sum += in.nextInt();
        }
        in.close();
        System.out.print("sum: " + sum + " mil sec: ");
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
    static void readString() throws IOException {

        long start = System.currentTimeMillis();
        BufferedReader in = new BufferedReader(new FileReader("bigInput.txt"));
        String number;
        long sum = 0;
        while((number = in.readLine()) != null){
        sum += Integer.parseInt(number);
        }
        long finish = System.currentTimeMillis();
        System.out.println(sum + " " + (finish - start));
    }
}
