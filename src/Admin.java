import java.sql.Connection;

public class Admin{
    public void admins(String name, String surname){
        DBFunctions db = new DBFunctions();
        Connection con = db.connect_to_db("postgres", "postgres", "w6Yh7OHK2lxxA");
        DBFunctions_Admin dba = new DBFunctions_Admin();
        dba.create_table_admin(con,"Admin");
        dba.insert_row_admin(con, "Admin", name, surname);
    }
}
