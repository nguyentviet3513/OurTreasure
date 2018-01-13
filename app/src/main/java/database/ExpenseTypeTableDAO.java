package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by nguyentviet3513 on 1/13/2018.
 */

public class ExpenseTypeTableDAO extends ExpenseTypeTable {
    public static long addExpenseType(Context applicationContext, String type_name) {
        SQLiteDatabase database = DatabaseHelper.getWritableDatabase(applicationContext);
        ContentValues values = new ContentValues();
        values.put(COLUMN_EXPENSE_TYPE_NAME, type_name);
        return database.insert(TABLE_NAME, null, values);
    }

    public static int updateExpense(Context applicationContext, int id, String type_name) {
        SQLiteDatabase database = DatabaseHelper.getWritableDatabase(applicationContext);
        ContentValues values = new ContentValues();
        values.put(COLUMN_EXPENSE_TYPE_NAME, type_name);
        return database.update(TABLE_NAME, values, "_id = ?",
                new String[]{String.valueOf(id)});
    }

}
