package database;

/**
 * Created by nguyentviet3513 on 1/11/2018.
 * EXPENSE_TABLE(EXPENSE_ID,EXPENSE_TYPE_ID,EXPENSE_NAME,EXPENSE_PRICE,EXPENSE_DATE)
 * USER_ID,
 */

public class ExpenseTable {
    public static final String TABLE_NAME = "expense_table";
    public static final String COLUMN_EXPENSE_ID = "expense_id";
    public static final String COLUMN_EXPENSE_TYPE_ID = "expense_type_id";
    // public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_EXPENSE_NAME = "expense_name";
    public static final String COLUMN_EXPENSE_PRICE = "expense_price";
    public static final String COLUMN_EXPENSE_DATE = "expense_date";

    private static final String CREATE_LOG_TABLE = "create table " + "if not exists " +
            "" + TABLE_NAME +
            "(" + COLUMN_EXPENSE_ID + " integer PRIMARY KEY, " + COLUMN_EXPENSE_TYPE_ID + " INTEGER, " +
            COLUMN_EXPENSE_NAME + " TEXT, " + COLUMN_EXPENSE_PRICE + " DOUBLE, " + COLUMN_EXPENSE_DATE + " INTEGER);";

    private static final String DROP_SQL = "drop table " + TABLE_NAME;


    public static String getCreateQuery() {
        return CREATE_LOG_TABLE;
    }

    public static String getDropQuery() {
        return DROP_SQL;
    }
}
