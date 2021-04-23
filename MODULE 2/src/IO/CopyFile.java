package IO;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        try {
            String path1 = "src\\IO\\phu.txt";
            String path2 = "src\\IO\\phu3.txt";
            FileReader fileReader = new FileReader(path1);
            FileWriter fileWriter = new FileWriter(path2,true);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            while ((line = bufferedReader.readLine())!=null){
                bufferedWriter.append(line);
                bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.flush();
            bufferedWriter.close();

        }catch (IOException  e){
            e.printStackTrace();
        }

    }
}
