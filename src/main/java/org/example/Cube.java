package org.example;

public class Cube {



   // Урок 5

   public Double hight; // поля класса
   public Double width;
   public Double lenth;


   public Cube(Double hight, Double width, Double lenth)
   { // 2й конструктор с аргументами
      this.hight = hight;
      this.width = width;
      this.lenth = lenth;
   }

   public Cube() // пустой конструктор без аргументов
   {

   }

   public Double multiplent() // метод, который рассчитывает и возвращает объём куба
   {
      Double volume = hight * width * lenth;
      return volume;
   }

   public void jump() // метод ничего не возвращает
   {
      System.out.println("jump!");
   }


   public String cubeLevitate() // здесь мы создали переменную типа строка, которую мы хотим, чтобы метод возвращал
   {
      String cubeLevitate = "levitate!"; // здесь мы присвоили этой переменной текстовое значение
      return cubeLevitate; // здесь мы использовали метод return, чтобы вернуть значение
   }

public String dance(String text)
{
   return text;
}

}


