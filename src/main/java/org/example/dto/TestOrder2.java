package org.example.dto;

public class TestOrder2
{
    private String courierId;
    private String customerName;
    private String customerPhone;
    private String status;
    private String comment;

    // конструктор класса (аналог setters, getters)
    public TestOrder2(String courierId, String customerName, String customerPhone, String comment, String status) {
        this.courierId = courierId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.comment = comment;
        this.status = status;
    }
}
