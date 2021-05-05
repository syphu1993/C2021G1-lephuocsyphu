package Commons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;
    private static String path;

    public static void writeFile(String[] content) {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(path, true));
            bufferedWriter.write(StringUtils.concat(content, StringUtils.COMMA));
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile() {
        List<String> arrayContent = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                arrayContent.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayContent;
    }
    public static void setFullPath(String fileName){
        StringBuffer path = new StringBuffer("E:\\CODEGYM\\C2021G1 LEPHUOCSYPHU\\MODULE 2\\FuramaResort\\src\\Data\\");
        path.append(fileName);
        path.append(StringUtils.CSV);
        FileUtils.path=path.toString();
    }
}