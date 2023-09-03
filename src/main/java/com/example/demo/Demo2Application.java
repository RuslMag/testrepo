package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo2Application {

    public static void main(String[] args) {
        //SpringApplication.run(Demo2Application.class, args);

        int[] numbers = {};

        System.out.print("[");
        if (numbers.length == 0) {
            System.out.print("]");
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(", ");
            } else {
                System.out.print("]");
            }
        }


        //System.out.println(String.join(",", ids));

    }

    private static int[] getSubArrayBetween(int[] numbers, int start, int end) {
        //вычисляем количество чисел которые будут между двумя числами + 2(количество этих чисел включительно)
        int count = 2;
        for (int j = 0; j < numbers.length; j++) {
            if (numbers[j] > start && numbers[j] < end) {
                count++;
            }
        }
        //создаем массив у которого объем равен вычисленному значению count
        int[] result = new int[count];

        //сразу вставляем начальное значение start в 0 индекс
        result[0] = start;

        // перебираем результирующий массив.
        // берем сразу 1 индекс, т.к в 0 индексе уже записано число start(4).
        for (int i = 1; i < result.length; ) {

            for (int j = 0; j < numbers.length; j++) {         // перебираем массив с числами
                if (numbers[j] > start && numbers[j] < end) {  // если число из массива numbers под индексом j больше чем start и меньше чем end
                    result[i] = numbers[j];                    // в массив result под индекс i добавляем число из массива numbers под индексом j
                    ++i;                                       // сразу переводим на следующий индекс в массиве result.
                }
            }
            result[i] = end;        // когда перебрали все числа, которые подходят под условие, в конце добавляем число end
            break;                  // завершаем выполнение цикла
        }
        return result;              //возвращаем result
    }


}
