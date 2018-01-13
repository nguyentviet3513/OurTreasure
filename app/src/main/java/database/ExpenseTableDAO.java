package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * EXPENSE_TABLE(EXPENSE_ID,EXPENSE_TYPE_ID,EXPENSE_NAME,EXPENSE_PRICE,EXPENSE_DATE)
 * Created by nguyentviet3513 on 1/11/2018.
 */

public class ExpenseTableDAO extends ExpenseTable {
    public static long addExpense(Context applicationContext, int EXPENSE_TYPE_ID, int EXPENSE_NAME,
                                  double EXPENSE_PRICE) {
        SQLiteDatabase database = DatabaseHelper.getWritableDatabase(applicationContext);
        ContentValues values = new ContentValues();
        values.put(COLUMN_EXPENSE_TYPE_ID, EXPENSE_TYPE_ID);
        values.put(COLUMN_EXPENSE_NAME, EXPENSE_NAME);
        values.put(COLUMN_EXPENSE_PRICE, EXPENSE_PRICE);
        values.put(COLUMN_EXPENSE_DATE, System.currentTimeMillis());
        return database.insert(TABLE_NAME, null, values);
    }

    public static int updateExpense(Context applicationContext, long EXPENSE_ID, int EXPENSE_TYPE_ID, int EXPENSE_NAME,
                                    double EXPENSE_PRICE, String EXPENSE_DATE) {
        SQLiteDatabase database = DatabaseHelper.getWritableDatabase(applicationContext);
        ContentValues values = new ContentValues();
        values.put(COLUMN_EXPENSE_TYPE_ID, EXPENSE_TYPE_ID);
        values.put(COLUMN_EXPENSE_NAME, EXPENSE_NAME);
        values.put(COLUMN_EXPENSE_PRICE, EXPENSE_PRICE);
        values.put(COLUMN_EXPENSE_DATE, EXPENSE_DATE);
        return database.update(TABLE_NAME, values, "_id = ?",
                new String[]{String.valueOf(EXPENSE_ID)});
    }

    public static ArrayList<ExpenseTableDTO> getExpenseListView(Context applicationContext) {
        ArrayList<ExpenseTableDTO> arrayList = new ArrayList<>();
        SQLiteDatabase db = DatabaseHelper.getReadableDatabase(applicationContext);
        String query = "select EXPENSE.expense_name,EXPENSE.expense_price," +
                "EXPENSE.EXPENSE_PRICE,EXPENSE.EXPENSE_DATE,EXPENSE.EXPENSE_TYPE,TYPE.expense_type_name" +
                " from EXPENSE_TABLE EXPENSE inner join EXPENSE_TYPE TYPE on  EXPENSE.EXPENSE_TYPE_ID = TYPE.EXPENSE_TYPE_ID ";
              /*  "ORDER BY " + ExpenseTable.COLUMN_EXPENSE_DATE +
                " ASC";*/
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            ExpenseTableDTO expenseTableDTO = new ExpenseTableDTO();
            expenseTableDTO.setExpenseName(cursor.getString(cursor.getColumnIndex(ExpenseTable.COLUMN_EXPENSE_NAME)));
            expenseTableDTO.setExpenseDate(cursor.getString(cursor.getColumnIndex(ExpenseTable.COLUMN_EXPENSE_NAME)));
            expenseTableDTO.setExpenseId(cursor.getInt(cursor.getColumnIndex(ExpenseTable.COLUMN_EXPENSE_ID)));
            expenseTableDTO.setExpensePrice(cursor.getDouble(cursor.getColumnIndex(ExpenseTable.COLUMN_EXPENSE_PRICE)));
            expenseTableDTO.setExpenseTypeName(cursor.getString(cursor.getColumnIndex(ExpenseTypeTable.COLUMN_EXPENSE_TYPE_NAME)));
            arrayList.add(expenseTableDTO);
        }
        return arrayList;
    }
}
