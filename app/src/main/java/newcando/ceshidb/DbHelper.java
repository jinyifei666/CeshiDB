package newcando.ceshidb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016/11/15.
 */

public class DbHelper extends OrmLiteSqliteOpenHelper {

    private DbHelper(Context context) {
        //参数:上下文,数据库名称,cursor factory,数据库版本.
        super(context, "test.db", null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            //这里只是粗暴的移除了旧表,新建新表,这样会导致数据丢失,现实一般不这么做
            TableUtils.dropTable(connectionSource, User.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //实现一个单例返回DbHelper实例
    private static DbHelper helper;

    public static DbHelper getHelper(Context context) {
        if (helper == null) {
            helper = new DbHelper(context);
        }
        return helper;
    }

}
