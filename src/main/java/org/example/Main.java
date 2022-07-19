package org.example;

import org.DatabaseFunctions.DatabaseFunctions;
import org.testng.annotations.Test;
public class Main
{
    @Test
    public void NewSelectUsers ()
    {
        DatabaseFunctions databaseFunctions = new DatabaseFunctions();
        databaseFunctions.selectUsers();
    }

}



/*
Integer a  = null;
Integer b  = 0;

try {
    Integer c = a / b;
} catch(ArithmeticException e) {
    System.out.println("division by zero"); // если не вписать исключения, то при любой ошибке код остановится
}
        System.out.println("all the rest code is ok");

    }





ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(7);
        array.add(8);
        array.add(9);
        array.add(10);
        ArrayList<Integer> array2 = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++)
        {
            if (array.get(i) % 2 == 0)
            {
                array2.add(array.get(i));
                System.out.println(array2);
            }
        }

Cat Kostik = new Cat();
        System.out.println(Kostik.voice());

        Dog Konstantin = new Dog();
        System.out.println(Konstantin.voice());



Cat Kostik = new Cat("white");
        System.out.println("This is cat Kostik and his color is: " + Kostik.color);
        System.out.println("Kostik please say: " + Kostik.sayMeow());

        Dog Konstantin = new Dog("brown");
        System.out.println("This is dog Konstantin and his color is: " + Konstantin.color);
        System.out.println("Konstantin please say: " + Konstantin.sayBark());




         Дан массив от 1 до 10. Создать новый массив где только чётные числа

1) Создаёте массив в 1 до 10
2) используете цикл, где условие окончания длина массива.
3) В цикле к каждому числу применяете if. Если число делится на 2 без остатка, значит оно чётное
4) Четные числа добавляем в новый массив
5) в консоли вывести второй массив второй 2,4,6,8,10



 ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++)
        {
            array.add(i);
        }
        ArrayList<Integer> NewArray = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            if (array.get(i) % 2 == 0) {
                NewArray.add(array.get(i));
            }
        }
        System.out.println(NewArray);



// из консоли вводится имя и возраст. Если возраст меньше 18, то на экран выводится сообщение "доступ запрещен".
// Если больше 18 - выводится имя, возраст.
// Если возраст меньше 0, пишем "неправильные данные"


        Scanner in = new Scanner(System.in);
        System.out.print("please enter your name");
        String name = in.nextLine();
        System.out.print("please enter your age");
        Integer age = in.nextInt();
while (name != "exit")
{
    if (age >= 18)
    {
        System.out.println(name+","+age);
    }
    else if (age >= 0)
    {
        System.out.println("error");
    }
    else
    {
        System.out.println("wrong value");
    }
    System.out.print("please enter your name");
  name = in.nextLine();
    System.out.print("please enter your age");
    age = in.nextInt();
}



// создать массив из нечетных чисел от 1 до 99. +
        // создать второй массив, который нужно заполнить элементами 1-го+1.+
        // вывести первый массив в строку, второй - в столбик




        ArrayList<Integer> NewArray = new ArrayList<Integer>();
        for (int i = 1; i <= 99; i++)
        {
            if (i % 2 != 0)
            {
                NewArray.add(i);
            }
        }
        ArrayList<Integer> NewArray2 = new ArrayList<Integer>();
        for (int j = 1; j < NewArray.size(); j++) // узнаем длину динамического массива (для статичекого будет array.length)
            {
                NewArray2.add(NewArray.get(j)+1); // get вытягивает значение, записанное в элементе массива. Сначала вытягиваеем значение, потом записываем в 2 массив.
            }
        System.out.println(NewArray);
for (int k = 0; k < NewArray2.size(); k++)
{
    System.out.println(NewArray2.get(k));
}





        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(7);
        array.add(8);
        array.add(9);
        array.add(10);
        ArrayList<Integer> array2 = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++)
        {
            if (array.get(i) % 2 == 0)
            {
                array2.add(array.get(i));
                System.out.println(array2);
            }
        }
    }


       Integer monthNumber; // задание 1

        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер месяца, чтобы узнать, к какому времени года принадлежит этот месяц");
        monthNumber = in.nextInt();
        switch(monthNumber)
        {
            case 12 , 1 , 2:
                System.out.println("winter");
                break;
            case 3 , 4 , 5:
                System.out.println("spring");
                break;
            case 6 , 7 , 8:
                System.out.println("summer");
                break;
            case 9 , 10 , 11:
                System.out.println("autumn");
                break;
            default:
                System.out.println("введено неверное значение месяца");




/*

for(int count = 30; count >= 0; count--) // цикл со счетчиком и внутренним условием
        {
            if (count == 20)
            {
                System.out.println("its 20");
            }
            System.out.println("номер итерации" + count);
        }



        Integer countDown  = 1;
        while (countDown  <= 20) // цикл с предусловием
        {
            System.out.println("number" + countDown);
            countDown++;

        }


      ArrayList<String> arrayNew = new ArrayList<>();
        for(int count = 15; count >= 0; count--)
        {
            arrayNew.add("номер FOR итерации" + count);

        }





        Integer num1 = 2;
        Integer num2 = 6;

        if (num1 > num2 && num1 == 7) {
            System.out.println("wright");

        } else {
            System.out.println("wrong");

        }
    }

        switch(num1)
        {
            case 2:
                System.out.println("yes 2");
                break;
            case 10:
                System.out.println("yes 10");
                break;
            default:
                System.out.println("no");



                int[] newArray = new int[10]; // обычный массив с заданным количеством элементов
        System.out.println(newArray.length);

String[] seasons = new String[4];
seasons[0] = "winter";
seasons[1] = "spring";
seasons[2] = "summer";
seasons[3] = "autumn";
System.out.println(seasons [4]);


ArrayList<Integer> array = new ArrayList<Integer>(); // динамический массив
array.add(1);
array.add(4);
array.add(8);
array.remove(2);
System.out.println(array.get(1));



        // Less5

        Cube anotherKubik = new Cube(8.5, 8.5, 8.5);
        System.out.println("We've just created a new cube with parms listed: hight: "  + anotherKubik.hight + ", lenth: " + anotherKubik.lenth + ", width: " + anotherKubik.width);
        System.out.println("the volume of this cube is: " + anotherKubik.multiplent());

        Cube unknownKubik = new Cube();
        System.out.println("We've just created a new cube with parms listed: hight: "  + unknownKubik.hight + ", lenth: " + unknownKubik.lenth + ", width: " + unknownKubik.width);

 */

