package newcando.ceshidb;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2016/11/15.
 */

@DatabaseTable(tableName = "t_user")
public class User {

    @DatabaseField(generatedId =true)
    private int id;

    @DatabaseField
    private String name;

    public User(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}