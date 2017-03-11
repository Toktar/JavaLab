package lab3;

import java.util.*;

/**
 * Created by Kida on 18.02.2017.
 */
public class Lab3 {

    final int listLength = 10000000;
    final Class elementType = Integer.class;
    final int iterationCount = 1000;

    public static void main(String[] args) {

        Lab3 lab = new Lab3();
//        List<Integer> arrayList = new ArrayList<>();
//        lab.randomList(list);
        System.out.println("--------ArrayList--------");
        lab.testTime(new ArrayList<>());
        System.out.println("--------LinkedList--------");
        lab.testTime(new LinkedList<>());
    }

    public void testTime(List<Integer> list) {
        randomList(list);

        System.out.println("Получение");
        System.out.println("в начало: " + getUpTime(list, 0));
        System.out.println("в середину: " + getUpTime(list, listLength / 2));
        System.out.println("в конец: " + getUpTime(list, listLength - 1));

        System.out.println("Вставка");
        System.out.println("в начало: " + getPutIntegerTime(list, 5555, 0));
        System.out.println("в середину: " + getPutIntegerTime(list, 5555, listLength / 2));
        System.out.println("в конец: " + getPutIntegerTime(list, 5555, listLength));


    }


    private void randomList(List<Integer> list) {
        if (elementType == Integer.class) randomIntegerList(list);
        //if(elementType==Double.class) randomDoubleList(list);
        //if(elementType==String.class) randomIntegerList(list);
    }

    private void randomIntegerList(List<Integer> list) {
        System.out.println("LIST:");
        for (int i = 0; i < listLength; i++) {
            Integer el = new Random().nextInt(20);
            list.add(i, el);
            // System.out.print(el + " ");
        }
        System.out.println();
    }


    private long getPutIntegerTime(List<Integer> list, Integer obj, int index) {
        Long curTime = System.currentTimeMillis();
        for (int i = 0; i < iterationCount && i < list.size(); i++) {

            list.add(index + i, obj);
        }

        long endTime = System.currentTimeMillis();

        return System.currentTimeMillis() - curTime;
    }


    private long getUpTime(List<Integer> list, int index) {
        Long curTime = System.currentTimeMillis();
        Integer element = null;
        for (int i = 0; i < iterationCount && i < list.size(); i++) {
            if (index + (int) Math.pow(-1, i) > 0 && index + (int) Math.pow(-1, i) < list.size())
                element = list.get(index + (int) Math.pow(-1, i));
        }
        return (element != null) ? System.currentTimeMillis() - curTime : -1;
    }
}
