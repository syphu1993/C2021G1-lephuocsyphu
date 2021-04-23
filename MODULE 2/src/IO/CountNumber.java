package IO;

import java.io.*;

public class CountNumber {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("src\\IO\\phuxxx.txt", false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append("2\n34\n3\n46\n54\n76\n575\n7");
            bufferedWriter.newLine();
            bufferedWriter.close();
            FileReader fileReader = new FileReader("src\\IO\\phuxxx.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int sum = 0;
            while ((line=bufferedReader.readLine())!=null){
                System.out.println(line);
                sum+=Integer.parseInt(line);
            }
            System.out.println("Tong la :" + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
