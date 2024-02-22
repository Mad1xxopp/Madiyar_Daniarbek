import java.sql.Connection;

public class Client{
    public void clients(String name, String surname){
        DBFunctions db = new DBFunctions();
        Connection con = db.connect_to_db("postgres", "postgres", "w6Yh7OHK2lxxA");
        DBFuncrions_Client dbc = new DBFuncrions_Client();
        dbc.create_table_client(con,"Client");
        dbc.insert_row_client(con, "Client", name, surname);
    }
}
