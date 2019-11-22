import java.sql.*;

public class DBConnect
{
    private Connection conn;
    
    public DBConnect(String url, String user, String password)
    {
        conn = null;
        try
        {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connessione avvenuta con successo");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public DBConnect()
    {
        this("jdbc:postgresql://localhost/ProgettoDB", "postgres", "postgres");
    }
    
    public ResultSet ExecQuery(String SQL)
    {
        try
        {
            Statement stmt = conn.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(SQL);
            System.out.println("Eseguita con successo: \n" + SQL);
            return rs;
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public Boolean checkConnection()
    {
        if (conn == null)
            return false;
        return true;
    }
}
