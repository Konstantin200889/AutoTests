package org.example;

public class Rectangle extends Figure
{


    public Rectangle(Double height, Double length, Double width)
    {
        super();
    }

    @Override  // аннотация
    public Double RectangleArea() // дополненный унаследованный метод абстр.класса
    {
        Double area = width * height * length;
        return area;
    }


}
