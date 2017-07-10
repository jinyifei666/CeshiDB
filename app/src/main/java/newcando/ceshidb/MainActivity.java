package newcando.ceshidb;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity   {
    private Dao userDao;
    private List<User> userArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ceshi();
    }

    private void ceshi() {
        DbHelper helper=DbHelper.getHelper(MainActivity.this);
        try {
            userDao=helper.getDao(User.class);
            Log.e("ssss",userDao.getTableName());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        User user1=new User(0,"hah");
        try {

            userDao.create(user1);
            userArray=new ArrayList<User>();
            userArray=(List<User>) userDao.queryForAll();
            Log.e("ss",String.valueOf(userArray.size()));
            for (int i=0;i<userArray.size();i++){
                Log.e("info",userArray.get(i).getName()+String.valueOf(userArray.get(i).getId()));
            }
            userDao.createOrUpdate(user1);
            Log.e("ss",userDao.queryForId(7).toString());
            user1.setName("jinyifei");
            userDao.createIfNotExists(user1);
            User q2=(User)userDao.queryForId(13);
            userDao.delete(userArray);
            userArray=(List<User>) userDao.queryForAll();
            for (int i=0;i<userArray.size();i++){
                Log.e("info",userArray.get(i).getName()+String.valueOf(userArray.get(i).getId()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        try {
//            userDao.delete(user1);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        try {
            userDao.update(new User(1,"jinyifei"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            User q=(User)userDao.queryForId(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
