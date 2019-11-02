package com.company;

import java.io.IOException;


import java.io.BufferedReader;
import java.io.FileReader;


    public class Homework3 {


        public static void main(String[] args) throws IOException {
            String[] data,date,Max,Min,temp;
            int[]day,max,min;
            String line;
            int count = 0;
            int smallestTempSpreadDate;
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

            date=new String[counter];
            Max=new String[counter];
            Min=new String[counter];
            day=new int[counter];
            max=new int[counter];
            min=new int[counter];

            for (int i = 0; i < counter; i++) {
                {
                    temp = data[i].split(",");
                    date[i] = temp[0];
                    Max[i] = temp[1];
                    Min[i] = temp[2];
                }
            }
            for(int i=0;i<counter;i++)
            {
                day[i]=Integer.parseInt(date[i]);
                max[i]=Integer.parseInt(Max[i]);
                min[i]=Integer.parseInt(Min[i]);
            }

            smallestTempSpreadDate=smallestSpreadDate(day,max,min);
            System.out.println("The day of smallest temperature spread is "+"day "+smallestTempSpreadDate);

        }

        public static int smallestSpreadDate(int[]day,int[]max,int[]min)
        {
            int smallest=max[0]-min[0];
            int index=0;
            for(int i=0;i<day.length;i++)
            {

                if((max[i]-min[i])<smallest)
                {
                    smallest=max[i]-min[i];
                    index=i;
                }
            }
            return day[index];
        }

}
