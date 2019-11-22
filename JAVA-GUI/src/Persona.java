
import java.sql.ResultSet;
import java.sql.SQLException;

public class Persona
{
    private String cf, nome, cognome, email, psw;
    private String telefono, citta, cap, indirizzo;
    private int civico;
    
    public Persona()
    {
        cf = nome = cognome = email = psw = "";
        telefono = citta = cap = indirizzo = "";
        civico = -1;
    }
    public Persona(String cf, String nome, String cognome, String email,
                    String psw, String telefono, String citta, String cap,
                    String indirizzo, int civico)
    {
        this.cf = cf;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.psw = psw;
        this.telefono = telefono;
        this.citta = citta;
        this.cap = cap;
        this.indirizzo = indirizzo;
        this.civico = civico;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getCivico() {
        return civico;
    }

    public void setCivico(int civico) {
        this.civico = civico;
    }
    
    
    
}
