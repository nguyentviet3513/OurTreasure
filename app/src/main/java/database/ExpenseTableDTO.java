package database;

/**
 * Created by nguyentviet3513 on 1/13/2018.
 */

public class ExpenseTableDTO {
    private int expenseId, expenseTypeId;
    private String expenseDate, expenseTypeName, expenseName;
    private double expensePrice;
/*
    public ExpenseTableDTO(String expenseTypeName, String expenseName, double expensePrice) {
        this.expenseTypeName = expenseTypeName;
        this.expenseName = expenseName;
        this.expensePrice = expensePrice;
    }*/

    public double getExpensePrice() {
        return expensePrice;
    }

    public void setExpensePrice(double expensePrice) {
        this.expensePrice = expensePrice;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public int getExpenseTypeId() {
        return expenseTypeId;
    }

    public void setExpenseTypeId(int expenseTypeId) {
        this.expenseTypeId = expenseTypeId;
    }

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getExpenseTypeName() {
        return expenseTypeName;
    }

    public void setExpenseTypeName(String expenseTypeName) {
        this.expenseTypeName = expenseTypeName;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }
}
