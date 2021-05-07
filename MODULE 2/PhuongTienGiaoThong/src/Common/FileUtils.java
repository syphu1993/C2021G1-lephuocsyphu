package Common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static BufferedWriter bufferedWriter;
    private static BufferedReader bufferedReader;
    private static String path;

    public static void wirteFile(String[] content,boolean append) {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(path,append));
            bufferedWriter.write(StringUtils.concat(content,StringUtils.COMMA));
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void wirteFileSpace() {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(path,false));
            bufferedWriter.write("");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> readFile(){
        List<String> contentList = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String line =null;
            while ((line = bufferedReader.readLine())!=null){
                contentList.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Danh sách đang tróng.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentList;
    }
    public static void setFullPath(String nameFile){
        StringBuffer path = new StringBuffer("E:\\CODEGYM\\C2021G1 LEPHUOCSYPHU\\MODULE 2\\PhuongTienGiaoThong\\src\\Data\\");
        path.append(nameFile);
        path.append(StringUtils.CSV);
        FileUtils.path = path.toString();
    }

}
