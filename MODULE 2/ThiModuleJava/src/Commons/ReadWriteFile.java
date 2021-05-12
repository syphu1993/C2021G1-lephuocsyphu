package Commons;

import Models.MucDanhBa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    public static final String path1 = "E:\\CODEGYM\\C2021G1 LEPHUOCSYPHU\\MODULE 2\\ThiModuleJava\\src\\Data\\contacts.csv";

    public static void writeFile(List<MucDanhBa> list, String path, boolean isapend) {
        File file = new File(path);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(path, isapend);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (MucDanhBa danhBa : list) {
                bufferedWriter.write(danhBa.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<MucDanhBa> readFile(String path) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = null;
        String[] content;
        List<MucDanhBa> listdanhba = new ArrayList<>();
        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                content = line.split(",");
                MucDanhBa mucDanhBa = new MucDanhBa(content[0], content[1], content[2], content[3], content[4], content[5], content[0]);
                listdanhba.add(mucDanhBa);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listdanhba;
    }

    public static void writeFileReset(String path) {
        File file = new File(path);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(path, false);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
