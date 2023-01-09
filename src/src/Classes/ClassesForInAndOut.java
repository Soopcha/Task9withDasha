package src.Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ClassesForInAndOut {
    private static String getPut(String str){
        String put = "";
        for(int i=2;i<str.length();i++){
            put+=str.charAt(i);
        }
        return put;
    }
    public static int[][] getIntArr(List<String> list){
        int stroki = list.size();
        int stolbzi = (list.get(0).split("\\s")).length;
        int[][] arr = new int[stroki][stolbzi];
        for(int i=0;i<stroki;i++){
            String[] row = list.get(i).split("\\s");
            for(int j=0;j<stolbzi;j++){
                arr[i][j]= Integer.parseInt(row[j]);
            }
        }
        return arr;
    }
//    public static int[][] getIntArr(List<String> list){
//        int stolbez1 = (list.get(0).split("\\s")).length;
//        int stolbez2 = (list.get(0).split("\\s")).length;
//        int[] arr1 = new int[stolbez1];
//        int[] arr2 = new int[stolbez1];
//        int[][] arr = new int[2][Math.max(arr1.length, arr2.length)];
//        String[] row1 = list.get(0).split("\\s");
//        String[] row2 = list.get(1).split("\\s");
//        for(int j=0;j<stolbez1;j++){
//            arr1[j]= Integer.parseInt(row1[j]);
//        }
//        for(int j=0;j<stolbez2;j++){
//            arr2[j]= Integer.parseInt(row2[j]);
//        }
//        int i = 0;
//        for (int element : arr1){
//            arr[0][i] = element;
//            i++;
//        }
//        int j = 0;
//        for (int element : arr1){
//            arr[1][i] = element;
//            j++;
//        }
//        for (int k = 0; k < arr.length; k++){
//            for (int m = 0; m < arr[i].length; m++){
//                if (arr[k][m] == 0){
//                }
//        return arr;
//    }
    public static int[][] readFile(String inputPath) throws IOException {
        Path path = Paths.get(getPut(inputPath)).toAbsolutePath();
        System.out.println("Входной файл: " + path);
        List<String> list = Files.readAllLines(path);
        return getIntArr(list);
    }
    public static void writeFile(String outputPath, String answer) throws FileNotFoundException {
        File file = new File(getPut(outputPath));
        PrintWriter pw = new PrintWriter(file);
        pw.println(answer);
        pw.close();
        System.out.println("Выходной файл: " + Paths.get(getPut(outputPath)).toAbsolutePath());
    }
}
