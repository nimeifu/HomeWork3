package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class hw3 {


    public static void main(String[] args) throws IOException {
        String[] data;
        String line;
        int count = 0;
        int ConvertoNum;
        FileReader fileReader = new FileReader("Albany_Climate_Data082019.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        line = bufferedReader.readLine();


        while (line != null) {

            count++;
            line = bufferedReader.readLine();

        }
        data = new String[count - 2];


        fileReader.close();



        FileReader fileReader1 = new FileReader("Albany_Climate_Data082019.csv");
        BufferedReader bufferedReader1 = new BufferedReader(fileReader1);

        int iteration = 0;
        int counter = 0;
        while ((line = bufferedReader1.readLine()) != null) {
            if (iteration < 2) {
                iteration++;
                continue;
            }

            if (line.equals("") || line.length() == 0) {
                continue;
            }

            data[counter++]=line;
        }

        for (int i = 0; i < counter; i++) {
            for (String item : data[i].split(",")) {
               ConvertoNum=Integer.parseInt(item);
               System.out.println(ConvertoNum);

            }
            System.out.println();
        }
    }
/*
    public static double[] ConvertoNum(String[] data, String[] num)
    {
        for(String a:data)
        {
            while(a.length()>0)
                for(int i=0;i<data.length;i++)
                {
                    num=data[i].split(",");
                }
        }
    }
*/

}
