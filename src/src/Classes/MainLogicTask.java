package src.Classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*  таск 9 вар 9

Реализовать функцию:
public static List<Integer> inList1XorInList2(
 List<Integer> list1, List<Integer> list2)
, которая вернет список чисел, представленных по одному разу, которые есть или только
в первом списке или только во втором списке, но не в двух списках одновременно
(вначале числа, которые есть в первом списке в порядке появления, затем числа, которые
есть во втором списке (но нет в первом), также в порядке появления).

 */

public class MainLogicTask {
        public static int[][] getAnswer(int [][] arr){

        List<Integer> list1 = new ArrayList<Integer>();//пихаем эл из масива в листы
        for (int elememt : arr[0]) {
            list1.add(elememt);
        }
        List<Integer> list2 = new ArrayList<Integer>();
        for (int elememt : arr[1]) {
            list2.add(elememt);
        }

        int [][] array = new int [3][Math.max(Math.max(arr[0].length, inList1XorInList2(list1,list2).toArray().length), arr[1].length)];
        int i = 0;
        int j = 0;
        int k = 0;
        for (int element : arr[0]){ //записываем 1 список
            array[0][i] = element;
            i++;
        }
        for (int element : arr[1]){//записываем 2 список(но вообще как массив но да не важно)
            array[1][j] = element;
            j++;
        }
        for (int element : inList1XorInList2(list1,list2)){ //записываем xor те только 3 строка ответ до этого чисто для красоты сами числа
            array[2][k] = element;
            k++;
        }
        return array;
    }
    public static List<Integer> inList1XorInList2(List<Integer> list1, List<Integer> list2){
        List<Integer> list = new ArrayList<Integer>();
        for (int elememt1 : inList1NotInList2(list1, list2)){ //числа, которые есть в 1 списке есть а во 2 нет
            list.add(elememt1);
        }
        for (int elememt2 : inList1NotInList2(list2, list1)){ //числа, которые есть в0 2 списке есть а в 1 нет
            list.add(elememt2);
        }
        return list;
    }
    public static List<Integer> inList1NotInList2(List<Integer> list1, List<Integer> list2){
        List<Integer> list = new ArrayList<Integer>();
        int otsutstviePovtorov = 1; //1 же типо true
        for (int element1 : list1){
            for (int element2 : list2){
                if (element1 == element2){
                    otsutstviePovtorov = 0;
                    break;
                } else {
                    otsutstviePovtorov = 1;
                }
            }
            if (otsutstviePovtorov == 1){
                list.add(element1);
            } else {
                break;
            }
        }
        return list;
    }
    public static String massivVStroki(int [][] array){
        StringBuilder answer = new StringBuilder();
        for (int [] mas : array){
            for (int znach : mas){
                answer.append(znach);
                answer.append(" ");
            }
            answer.append("\n");

        }
        return answer.toString();
    }
//    .\input.txt .\output.txt
    //метод для чтения и записи результата
    public static void readAndWriteMethod(InputArgs inputArgs) throws IOException {
        int[][] arr = ClassesForInAndOut.readFile(inputArgs.getInputFile());
        String answer = MainLogicTask.massivVStroki(MainLogicTask.getAnswer(arr));
        ClassesForInAndOut.writeFile(inputArgs.getOutputFile(),answer);
    }
    public static void printSuccessMessage(int num){
        if(num==0){
            System.out.println("Основная программа выполнена.");
        }else{
            System.out.println("Тест " + num + " выполнен успешно.");
        }
        System.out.println();
    }
}
