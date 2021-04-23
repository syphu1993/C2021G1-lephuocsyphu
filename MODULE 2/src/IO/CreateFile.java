package IO;

import java.io.*;

public class CreateFile {
    public CreateFile() throws FileNotFoundException {
    }

    public static void main(String[] args) throws IOException {
        try {
            File file = new File("src\\IO\\test.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append("1.0.0.0\",\"1.0.0.255\",\"16777216\",\"16777471\",\"AU\",\"Australia");
            bufferedWriter.newLine();
            bufferedWriter.append("1.0.1.0\",\"1.0.3.255\",\"16777472\",\"16778239\",\"CN\",\"China");
            bufferedWriter.newLine();
            bufferedWriter.append("1.0.4.0\",\"1.0.7.255\",\"16778240\",\"16779263\",\"AU\",\"Australia");
            bufferedWriter.newLine();
            bufferedWriter.append("1.0.16.0\",\"1.0.31.255\",\"16781312\",\"16785407\",\"JP\",\"Japan");
            bufferedWriter.newLine();
            bufferedWriter.append("1.0.64.0\",\"1.0.127.255\",\"16793600\",\"16809983\",\"JP\",\"Japan");
            bufferedWriter.close();
            FileReader fileReader = new FileReader("src\\IO\\test.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line ;
            while ((line = bufferedReader.readLine())!=null){
                String[] result = line.split(",");
                System.out.println(result[result.length - 1]);
            }
            bufferedReader.hashCode();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
