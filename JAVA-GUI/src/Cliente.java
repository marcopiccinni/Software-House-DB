import java.sql.Timestamp;

public class Cliente extends Persona
{
    private Timestamp data_registrazione;
    private String p_iva, azienda;
    
    public Cliente()
    {
        super();
        p_iva = azienda = "";
    }
    
    public Cliente(String cf, String nome, String cognome, String email,
                    String psw, String telefono, String citta, String cap,
                    String indirizzo, int civico, Timestamp data_registrazione,
                    String p_iva, String azienda)
    {
        super(cf, nome, cognome, email, psw, telefono, citta,
                cap, indirizzo, civico);
        this.data_registrazione = data_registrazione;
        this.p_iva = p_iva;
        this.azienda = azienda;
    }

    public Timestamp getData_registrazione() {
        return data_registrazione;
    }

    public void setData_registrazione(Timestamp data_registrazione) {
        this.data_registrazione = data_registrazione;
    }

    public String getP_iva() {
        return p_iva;
    }

    public void setP_iva(String p_iva) {
        this.p_iva = p_iva;
    }

    public String getAzienda() {
        return azienda;
    }

    public void setAzienda(String azienda) {
        this.azienda = azienda;
    }
    
    
}
