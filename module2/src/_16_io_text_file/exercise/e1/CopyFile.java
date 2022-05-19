package _16_io_text_file.exercise.e1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {
    public List<String> readFile(String fileSourcePath) {
        List<String> list = new ArrayList<>();
        int count = demKiTuCuaFile(fileSourcePath);
        try {
            FileReader fileReader = new FileReader(fileSourcePath);
            BufferedReader brReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = brReader.readLine()) != null) {
                list.add(line);
            }
            list.add("So ky tu cua file la: " + count);
            brReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void writeFile(String fileTargetPath, List<String> list) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileTargetPath, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter brWriter = new BufferedWriter(fileWriter);
        for (String i: list) {
            try {
                brWriter.write(i);
                brWriter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            brWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int demKiTuCuaFile(String fileSourcePath) {
        int count = 0;
        try {
            FileReader fileReader = new FileReader(fileSourcePath);
            int i;
            while ((i = fileReader.read()) != -1) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void main(String[] args) {
        CopyFile obj = new CopyFile();
        List<String> list = obj.readFile("D:\\CodegymDN\\module2\\src\\_16_io_text_file\\exercise\\e1\\read.txt");
        obj.writeFile("D:\\CodegymDN\\module2\\src\\_16_io_text_file\\exercise\\e1\\write.txt", list);
    }
}
