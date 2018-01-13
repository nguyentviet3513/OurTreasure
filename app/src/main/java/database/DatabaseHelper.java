package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import base.MLog;

/**
 * Created by nguyentviet3513 on 1/11/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "first_assert.db";
    private static final int DATABASE_VERSION = 1;
    private static DatabaseHelper sHelper = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * WriteAble Database
     * Edit,Delete,Create
     *
     * @param context
     */
    public static SQLiteDatabase getWritableDatabase(Context context) {
        if (sHelper == null) {
            sHelper = new DatabaseHelper(context);
        }
        return sHelper.getWritableDatabase();
    }

    /**
     * Readable Database
     * Select
     *
     * @param context
     */
    public static SQLiteDatabase getReadableDatabase(Context context) {
        if (sHelper == null) {
            sHelper = new DatabaseHelper(context);
        }

        return sHelper.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(ExpenseTable.getCreateQuery());
            sqLiteDatabase.execSQL(ExpenseTypeTable.getCreateQuery());
            //sqLiteDatabase.execSQL(UserTable.getCreateQuery());
            setBaseTypeOfExpense();
        } catch (Exception e) {
            MLog.e("SQLiteDatabase--onCreateError--" + e);
        }

    }

    private void setBaseTypeOfExpense() {
        SQLiteDatabase database = getWritableDatabase();
        StringBuffer query = new StringBuffer("Insert into " + ExpenseTypeTable.TABLE_NAME + " value");
        query.append("Entertaiment,");
        query.append("Book,");
        query.append("Study,");
        query.append("WORK,");
        query.append("Mobile Card,");
        query.append("Others");
        database.rawQuery(query.toString(), null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if (oldVersion > newVersion) {
            //...
        }

    }

}
