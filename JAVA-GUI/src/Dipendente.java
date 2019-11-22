import java.sql.Timestamp;

public class Dipendente extends Persona
{
    private Timestamp data_assunzione;
    private double stipendio;
    private Boolean leader;
    private String divisione;
    
    public Dipendente()
    {
        super();
        this.data_assunzione = null;
        this.stipendio = 0.0;
        this.leader = false;
        this.divisione = "";
    }
    
    public Dipendente(String cf, String nome, String cognome, String email,
                    String psw, String telefono, String citta, String cap,
                    String indirizzo, int civico, Timestamp data_assunzione,
                    double stipendio, Boolean leader, String divisione)
    {
        super(cf, nome, cognome, email, psw, telefono, citta, cap, indirizzo,
                civico);
        this.data_assunzione = data_assunzione;
        this.stipendio = stipendio;
        this.leader = leader;
        this.divisione = divisione;
    }
    
    public Timestamp getData_assunzione() {
        return data_assunzione;
    }

    public void setData_assunzione(Timestamp data_assunzione) {
        this.data_assunzione = data_assunzione;
    }

    public Double getStipendio() {
        return stipendio;
    }

    public void setStipendio(Double stipendio) {
        this.stipendio = stipendio;
    }

    public Boolean getLeader() {
        return leader;
    }

    public void setLeader(Boolean leader) {
        this.leader = leader;
    }

    public String getDivisione() {
        return divisione;
    }

    public void setDivisione(String divisione) {
        this.divisione = divisione;
    }
    
}
