import java.sql.*;
public class DBInterface
{
    private DBConnect conn;

    public DBInterface(String url, String user, String password)
    {
        conn = new DBConnect(url, user, password);
    }
    
    public Persona[] PersonaSQL(String cf, String nome, String cognome,
                String e_mail, String psw, String telefono, String citta,
                String cap, String indirizzo, int civico)
    {
        String SQL = "SELECT * FROM persona WHERE ";
        String filtro = "";
        
        if (!cf.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "cf = '" + cf + "'";
        }
        if (!nome.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "nome = '" + nome + "'";
        }
        if (!cognome.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "cognome = '" + cognome + "'";
        }
        if (!e_mail.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "e_mail = '" + e_mail + "'";
        }
        if (!psw.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "psw = '" + psw + "'";
        }
        if (!telefono.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "telefono = '" + telefono + "'";
        }
        if (!citta.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "citta = '" + citta + "'";
        }
        if (!cap.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "cap = '" + cap + "'";
        }
        if (!indirizzo.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "indirizzo = '" + indirizzo + "'";
        }
        if (civico != -1)
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "civico = " + civico;
        }
        SQL += filtro;
        
        ResultSet rs = conn.ExecQuery(SQL);
        int size = 0;
        Persona p[];
        try
        {
            if (rs.last())
            {
                size = rs.getRow();
                rs.beforeFirst();
            }
            p = new Persona[size];
            int i = 0;
            while (rs.next())
            {
                p[i] = new Persona(rs.getString("cf"), rs.getString("nome"),
                            rs.getString("cognome"), rs.getString("e_mail"),
                            rs.getString("psw"), rs.getString("telefono"), 
                            rs.getString("citta"), rs.getString("cap"), 
                            rs.getString("indirizzo"), rs.getInt("civico"));
                i++;
            }
        }
        catch (SQLException ex)
        {
            p = null;
        }
        return p;
    }
    
    public Persona[] cercaNome(String nome)
    {
        return PersonaSQL("", nome, "", "", "", "", "", "", "", -1);
    }
    
    public Dipendente[] DipendenteDB(String cf, String nome, String cognome,
                String e_mail, String psw, String telefono, String citta,
                String cap, String indirizzo, int civico, String divisione, 
                Timestamp data_assunzione, double stipendio, Boolean leader)
    {
        String SQL = "SELECT p.*, d.data_assunzione, d.stipendio, d.leader, "
                + "d.divisione FROM persona AS p " +
                "JOIN dipendente AS d ON p.cf = d.cf";
        String filtro = "";
        
        if (!cf.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "p.cf = '" + cf + "'";
        }
        if (!nome.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "p.nome = '" + nome + "'";
        }
        if (!cognome.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "p.cognome = '" + cognome + "'";
        }
        if (!e_mail.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "p.e_mail = '" + e_mail + "'";
        }
        if (!psw.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "p.psw = '" + psw + "'";
        }
        if (!telefono.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "p.telefono = '" + telefono + "'";
        }
        if (!citta.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "p.citta = '" + citta + "'";
        }
        if (!cap.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "p.cap = '" + cap + "'";
        }
        if (!indirizzo.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "p.indirizzo = '" + indirizzo + "'";
        }
        if (civico != -1)
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "p.civico = " + civico;
        }
        if (data_assunzione != null)
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "d.data_assunzione = '" + data_assunzione + "'"; //FACILE CHE DIA PROBLEMI L'USO DEL TEMPO INSERITO COSì
        }
        if (stipendio != -1)
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "d.stipendio = " + stipendio;
        }
        if (leader != null)
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            if (leader)
                filtro += "d.leader = TRUE";
            else
                filtro += "d.leader = FALSE";
        }
        if (!divisione.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "d.divisione = '" + divisione + "'";
        }
        
        if (!filtro.equals(""))
            SQL += " WHERE " + filtro;
        
        ResultSet rs = conn.ExecQuery(SQL);
        int size = 0;
        Dipendente d[];
        try
        {
            if (rs.last())
            {
                size = rs.getRow();
                rs.beforeFirst();
            }
            d = new Dipendente[size];
            int i = 0;
            while (rs.next())
            {
                d[i] = new Dipendente(rs.getString("cf"), rs.getString("nome"),
                        rs.getString("cognome"), rs.getString("e_mail"),
                        rs.getString("psw"), rs.getString("telefono"), 
                        rs.getString("citta"), rs.getString("cap"), 
                        rs.getString("indirizzo"), rs.getInt("civico"),
                        rs.getTimestamp("data_assunzione"), rs.getDouble("stipendio"),
                        rs.getBoolean("leader"), rs.getString("divisione"));
                i++;
            }
        }
        catch (SQLException ex)
        {
            d = null;
        }
        return d;
    }
    
    public Cliente[] ClienteDB(String cf, String nome, String cognome,
                            String e_mail, String psw, String telefono,
                            String citta, String cap, String indirizzo,
                            int civico, Timestamp data_registrazione,
                            String p_iva, String azienda)
    {
        String SQL = "SELECT p.*, c.data_registrazione, c.p_iva, c.azienda "
                + "FROM persona AS p "
                + "JOIN cliente AS c ON p.cf = c.cf";
        String filtro = "";
        
        if (!cf.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "p.cf = '" + cf + "'";
        }
        if (!nome.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "p.nome = '" + nome + "'";
        }
        if (!cognome.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "p.cognome = '" + cognome + "'";
        }
        if (!e_mail.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "p.e_mail = '" + e_mail + "'";
        }
        if (!psw.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "p.psw = '" + psw + "'";
        }
        if (!telefono.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "p.telefono = '" + telefono + "'";
        }
        if (!citta.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "p.citta = '" + citta + "'";
        }
        if (!cap.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "p.cap = '" + cap + "'";
        }
        if (!indirizzo.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "p.indirizzo = '" + indirizzo + "'";
        }
        if (civico != -1)
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "p.civico = " + civico;
        }
        if (data_registrazione != null)
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "c.data_registrazione = '" + data_registrazione + "'"; //FACILE CHE DIA PROBLEMI L'USO DEL TEMPO INSERITO COSì
        }
        if (!p_iva.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "c.p_iva = '" + p_iva + "'";
        }
        if (!azienda.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "c.azienda = '" + azienda + "'";
        }
        
        if (!filtro.equals(""))
            SQL += " WHERE " + filtro;
        
        ResultSet rs = conn.ExecQuery(SQL);
        int size = 0;
        Cliente c[];
        try
        {
            if (rs.last())
            {
                size = rs.getRow();
                rs.beforeFirst();
            }
            c = new Cliente[size];
            int i = 0;
            while (rs.next())
            {
                c[i] = new Cliente(rs.getString("cf"), rs.getString("nome"),
                        rs.getString("cognome"), rs.getString("e_mail"),
                        rs.getString("psw"), rs.getString("telefono"), 
                        rs.getString("citta"), rs.getString("cap"), 
                        rs.getString("indirizzo"), rs.getInt("civico"),
                        rs.getTimestamp("data_registrazione"), rs.getString("p_iva"),
                        rs.getString("azienda"));
                i++;
            }
        }
        catch (SQLException ex)
        {
            c = null;
        }
        return c;
    }
    
    public Ticket[] TicketDB(int id, Timestamp data, String stato,
            String descrizione, int priorita, double prezzo,
            Time durata_totale, String cf, int id_sw, int id_hw,
            String divisione)
    {
        String SQL = "SELECT * FROM Ticket";
        String filtro = "";
        if (id != -1)
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "id = " + id;
        }
        if (data != null)
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "data = '" + data + "'"; //FACILE CHE DIA PROBLEMI L'USO DEL TEMPO INSERITO COSì
        }
        if (!cf.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "stato = '" + stato + "'";
        }
        if (!descrizione.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "descrizione = '" + descrizione + "'";
        }
        if (priorita != -1)
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "priorita = " + priorita;
        }
        if (prezzo != -1)
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "prezzo = " + prezzo;
        }
        if (durata_totale != null)
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "durata_totale = '" + durata_totale + "'"; //FACILE CHE DIA PROBLEMI L'USO DEL TEMPO INSERITO COSì
        }
        if (!cf.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "cf = '" + cf + "'";
        }
        if (id_sw != -1)
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "id_sw = " + id_sw;
        }
        if (id_hw != -1)
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "id_hw = " + id_hw;
        }
        if (!divisione.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "divisione = '" + divisione + "'";
        }
        
        if (!filtro.equals(""))
            SQL += " WHERE " + filtro;
        
        SQL += " ORDER BY data ASC";
        
        ResultSet rs = conn.ExecQuery(SQL);
        int size = 0;
        Ticket t[];
        try
        {
            if (rs.last())
            {
                size = rs.getRow();
                rs.beforeFirst();
            }
            t = new Ticket[size];
            int i = 0;
            while (rs.next())
            {
                t[i] = new Ticket(rs.getInt("id"), rs.getTimestamp("data"),
                        rs.getString("stato"), rs.getString("descrizione"),
                        rs.getInt("priorita"), rs.getDouble("prezzo"),
                        rs.getTime("durata_totale"), rs.getString("cf"),
                        rs.getInt("id_sw"), rs.getInt("id_hw"),
                        rs.getString("divisione"));
                i++;
            }
        }
        catch (SQLException ex)
        {
            t = null;
        }
        return t;
    }
    
    public Ticket[] tuttiTicket()
    {
        return TicketDB(-1, null, "", "", -1, -1, null, "", -1, -1, "");
    }
    
    public Ticket[] ticketAperti()
    {
        String SQL = "SELECT * " +
                    "FROM Ticket " +
                    "WHERE stato <> 'Rejected' AND stato <> 'Completed' " +
                    "ORDER BY data ASC";
        ResultSet rs = conn.ExecQuery(SQL);
        int size = 0;
        Ticket t[];
        try
        {
            if (rs.last())
            {
                size = rs.getRow();
                rs.beforeFirst();
            }
            t = new Ticket[size];
            int i = 0;
            while (rs.next())
            {
                t[i] = new Ticket(rs.getInt("id"), rs.getTimestamp("data"),
                        rs.getString("stato"), rs.getString("descrizione"),
                        rs.getInt("priorita"), rs.getDouble("prezzo"),
                        rs.getTime("durata_totale"), rs.getString("cf"),
                        rs.getInt("id_sw"), rs.getInt("id_hw"),
                        rs.getString("divisione"));
                i++;
            }
        }
        catch (SQLException ex)
        {
            t = null;
        }
        return t;
    }
    
    public Ticket[] ticketcompletati()
    {
        return TicketDB(-1, null, "Completed", "", -1, -1, null, "", -1, -1, "");
    }
    
    public Ticket[] ticketFiltrati(String stato, String divisione, int prioIn,
            int prioFin, String dataIn, String dataFin)
    {
        String SQL = "SELECT * " +
                "FROM Ticket " +
                "WHERE ";
        String filtro = "priorita BETWEEN " + prioIn + " AND " + prioFin;
        if (!stato.equals(""))
        {
            if(stato.equals("Aperti"))
                filtro += " AND stato <> 'Rejected' AND stato <> 'Completed'";
            else
                filtro += " AND stato = '" + stato + "'";
        }
        if(!divisione.equals(""))
        {
            filtro += " AND divisione = '" + divisione + "'";
        }
        if(!dataIn.equals("") && !dataFin.equals(""))
            filtro += " AND data BETWEEN '"+dataIn+"' AND '"+dataFin+"'";
        
        SQL += filtro;
        SQL += " ORDER BY data ASC";
        ResultSet rs = conn.ExecQuery(SQL);
        int size = 0;
        Ticket t[];
        try
        {
            if (rs.last())
            {
                size = rs.getRow();
                rs.beforeFirst();
            }
            t = new Ticket[size];
            int i = 0;
            while (rs.next())
            {
                t[i] = new Ticket(rs.getInt("id"), rs.getTimestamp("data"),
                        rs.getString("stato"), rs.getString("descrizione"),
                        rs.getInt("priorita"), rs.getDouble("prezzo"),
                        rs.getTime("durata_totale"), rs.getString("cf"),
                        rs.getInt("id_sw"), rs.getInt("id_hw"),
                        rs.getString("divisione"));
                i++;
            }
        }
        catch (SQLException ex)
        {
            t = null;
        }
        return t;
    }
    
    public Ticket getTicket(int id)
    {
        String SQL = "SELECT * FROM Ticket WHERE id = " + id;
        ResultSet rs = conn.ExecQuery(SQL);
        Ticket t;
        try
        {
            rs.next();
            t = new Ticket(rs.getInt("id"), rs.getTimestamp("data"),
                        rs.getString("stato"), rs.getString("descrizione"),
                        rs.getInt("priorita"), rs.getDouble("prezzo"),
                        rs.getTime("durata_totale"), rs.getString("cf"),
                        rs.getInt("id_sw"), rs.getInt("id_hw"),
                        rs.getString("divisione"));
        }
        catch (SQLException ex)
        {
            t = null;
        }
        return t;
    }
    
    public void updateTicket(int id, String stato, String descrizione,
            int priorita, double prezzo)
    {
        String SQL = "UPDATE Ticket SET ";
        SQL += "stato = '" + stato + "', ";
        SQL += "descrizione = '" + descrizione + "', ";
        SQL += "priorita = " + priorita;
        if (prezzo != 0)
            SQL += ", prezzo = " + prezzo;
        SQL += " WHERE id = " + id;
        conn.ExecQuery(SQL);
    }
    
    public void deleteTicket(int id)
    {
        String SQL = "DELETE FROM Ticket WHERE id = " + id;
        conn.ExecQuery(SQL);
    }
    
    public ResultSet eseguiQuery(String SQL)
    {
        return conn.ExecQuery(SQL);
    }
    
    public ResultSet cercaPersona(String nome, String cognome)
    {
        String SQL = "SELECT cf, nome, cognome, e_mail, telefono, citta, " +
                "concat(indirizzo, ' ', civico) AS indirizzo, cap ";
        SQL +="FROM persona";
        String filtro = "";
        
        if (!nome.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "nome LIKE '" + nome + "%'";
        }
        if (!cognome.equals(""))
        {
            if (!filtro.equals(""))
                filtro += " AND ";
            filtro += "cognome LIKE '" + cognome + "%'";
        }
        if (!filtro.equals(""))
            SQL += " WHERE " + filtro;
        SQL += " ORDER BY cf";
        return conn.ExecQuery(SQL);
    }
    
    public Boolean checkConnection()
    {
        return conn.checkConnection();
    }
    
    public Software[] getAllSofware()
    {
        String SQL = "SELECT * FROM software";
        ResultSet rs = conn.ExecQuery(SQL);
        Software s[];
        
        try
        {
            int size = 0;
            if (rs.last())
            {
                size = rs.getRow();
                rs.beforeFirst();
            }
            s = new Software[size];
            int i = 0;
            while (rs.next())
            {
                s[i] = new Software(rs.getInt("id"), rs.getString("nome"),
                            rs.getString("versione"), rs.getString("stato"),
                            rs.getString("so"), rs.getString("descrizione"),
                            rs.getDouble("prezzo_listino"));
                i++;
            }
        }
        catch (SQLException ex)
        {
            s = null;
        }
        return s;
    }
    
    public Hardware[] getAllHardware()
    {
        String SQL = "SELECT * FROM m_assistenza";
        ResultSet rs = conn.ExecQuery(SQL);
        Hardware h[];
        
        try
        {
            int size = 0;
            if (rs.last())
            {
                size = rs.getRow();
                rs.beforeFirst();
            }
            h = new Hardware[size];
            int i = 0;
            while (rs.next())
            {
                h[i] = new Hardware(rs.getInt("id"),
                    rs.getTimestamp("data_entrata"),
                    rs.getTimestamp("data_uscita"), rs.getString("posizione"),
                    rs.getString("tipo"), rs.getString("descrizione"),
                    rs.getString("marca"), rs.getString("modello"));
                i++;
            }
        }
        catch (SQLException ex)
        {
            h = null;
        }
        return h;
    }
    
    public Software getSoftware(int id)
    {
        String SQL = "SELECT * FROM software WHERE id = " + id;
        ResultSet rs = conn.ExecQuery(SQL);
        Software s;
        
        try
        {
            rs.next();
            s = new Software(rs.getInt("id"), rs.getString("nome"),
                rs.getString("versione"), rs.getString("stato"),
                rs.getString("so"), rs.getString("descrizione"),
                rs.getDouble("prezzo_listino"));
        }
        catch (SQLException ex)
        {
            s = null;
        }
        return s;
    }
    
    public Hardware getHardware(int id)
    {
        String SQL = "SELECT * FROM m_assistenza WHERE id = " + id;
        ResultSet rs = conn.ExecQuery(SQL);
        Hardware h;
        
        try
        {
            rs.next();
            h = new Hardware(rs.getInt("id"),
                rs.getTimestamp("data_entrata"), rs.getTimestamp("data_uscita"),
                rs.getString("posizione"), rs.getString("tipo"),
                rs.getString("descrizione"), rs.getString("marca"),
                rs.getString("modello"));
        }
        catch (SQLException ex)
        {
            h = null;
        }
        return h;
    }
    
    public void inserisciTicket(String data, String stato, String descrizione, 
            String cf, int id_sw, int id_hw, String divisione)
    {
        String SQL = "INSERT INTO Ticket (priorita, data, stato, cf, divisione";
        if(!descrizione.equals(""))
            SQL += ", descrizione";
        if(id_sw != -1)
            SQL += ", id_sw";
        if(id_hw != -1)
            SQL += ", id_hw";
        SQL += ") VALUES (1, '" + data + "', '" + stato + "', '" + cf + "', '" +
                divisione+"'";
        if(!descrizione.equals(""))
            SQL += ", '" + descrizione + "'";
        if(id_sw != -1)
            SQL += ", " + id_sw;
        if(id_hw != -1)
            SQL += ", " + id_hw;
        SQL += ")";
        conn.ExecQuery(SQL);
    }
    
    public void inserisciTicketSoftware(String data, String stato,
            String descrizione, String cf, int id_sw, String divisione)
    {
        inserisciTicket(data,stato,descrizione,cf,id_sw,-1,divisione);
    }
    
    public void inserisciTicketHardware(String data, String stato,
            String descrizione, String cf, int id_hw, String divisione)
    {
        inserisciTicket(data,stato,descrizione,cf,-1,id_hw,divisione);
    }
}
