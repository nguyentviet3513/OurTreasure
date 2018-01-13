package database;

/**
 * Created by nguyentviet3513 on 1/11/2018.
 * Type of expense
 * EXPENSE_TYPE_TABLE(EXPENSE_TYPE_ID,EXPENSE_TYPE_NAME)
 */

public class ExpenseTypeTable {
    public static final String TABLE_NAME = "expense_type_table";

    public static final String COLUMN_EXPENSE_TYPE_ID = "expense_type_id";
    public static final String COLUMN_EXPENSE_TYPE_NAME = "expense_type_name";

    private static final String CREATE_LOG_TABLE = "create table " + "if not exists " + TABLE_NAME +
            "(" + "expense_type_id integer PRIMARY KEY, " + COLUMN_EXPENSE_TYPE_NAME + "TEXT);";

    private static final String DROP_SQL = "drop table " + TABLE_NAME;


    public static String getCreateQuery() {
        return CREATE_LOG_TABLE;
    }

    public static String getDropQuery() {
        return DROP_SQL;
    }

}
