package org.example.dto;

public class TestOrder
{

    private String status;
    private String customerName;
    private String customerPhone;
    private String comment;

    public TestOrder(String status, String customerName, String customerPhone, String comment) {
        this.status = status;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "TestOrder{" +
                "status='" + status + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}


