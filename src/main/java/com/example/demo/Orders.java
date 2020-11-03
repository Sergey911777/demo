package com.example.demo;

import com.opencsv.bean.CsvBindByPosition;

//класс для данных из CSV
public class Orders {

    @CsvBindByPosition(position = 0)
    private String orderId;
    @CsvBindByPosition(position = 1)
    private String amount;
    @CsvBindByPosition(position = 2)
    private String currecy;
    @CsvBindByPosition(position = 3)
    private String comment;

    private int line;
    public void setLine(int line) {
        this.line = line;
    }




    //Getters and setters
    public String getOrderId() {
        return orderId;
    }

    public String getAmount() {
        return amount;
    }

    public String getCurrecy() {
        return currecy;
    }

    public String getComment() {
        return comment;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setCurrecy(String currecy) {
        this.currecy = currecy;
    }



    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {

        var builder = new StringBuilder();

        builder.append("Заказ{id:").append(orderId).append(", amount:")
                .append(amount).append(", currecy:").append(currecy)
                .append(", comment:").append(comment).append(", имя файла:").append(FileWork.getFileName()).append(", строка№:").append(line).append("}");

        return builder.toString();
    }

}
