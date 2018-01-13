package database;

/**
 * Created by nguyentviet3513 on 1/11/2018.
 * USER_TABLE(USER_ID,USER_PASSWORD)
 */

public class UserTable {
    public static final String TABLE_NAME = "user_table";

    public static final String COLUMN_USER_TYPE_ID = "expense_type_id";
    public static final String COLUMN_USER_PASSWORD = "expense_type_name";

    private static final String CREATE_LOG_TABLE = "create table " + "if not exists " + TABLE_NAME +
            "(" + COLUMN_USER_TYPE_ID + " integer PRIMARY KEY, " + COLUMN_USER_PASSWORD + "TEXT);";

    private static final String DROP_SQL = "drop table " + TABLE_NAME;


    public static String getCreateQuery() {
        return CREATE_LOG_TABLE;
    }

    public static String getDropQuery() {
        return DROP_SQL;
    }
}
