import java.sql.Timestamp;
import java.sql.Time;

public class Ticket
{
    private int id, priorita, id_sw, id_hw;
    private Timestamp data;
    private Time durata_totale;
    private String stato, descrizione, cf, divisione;
    private double prezzo;
    
    public Ticket()
    {
        id = priorita = id_sw = id_hw = -1;
        data = null;
        durata_totale = null;
        stato = descrizione = cf = divisione = "";
        prezzo = 0.0;
    }
    
    public Ticket (int id, Timestamp data, String stato, String descrizione,
                int priorita, double prezzo, Time durata_totale,
                String cf, int id_sw, int id_hw, String divisione)
    {
        this.id = id;
        this.data = data;
        this.stato = stato;
        this.descrizione = descrizione;
        this.priorita = priorita;
        this.prezzo = prezzo;
        this.durata_totale = durata_totale;
        this.cf = cf;
        this.id_sw = id_sw;
        this.id_hw = id_hw;
        this.divisione = divisione;
    }

    public int getId() {
        return id;
    }

    public int getPriorita() {
        return priorita;
    }

    public void setPriorita(int priorita) {
        this.priorita = priorita;
    }

    public int getId_sw() {
        return id_sw;
    }

    public void setId_sw(int id_sw) {
        this.id_sw = id_sw;
    }

    public int getId_hw() {
        return id_hw;
    }

    public void setId_hw(int id_hw) {
        this.id_hw = id_hw;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public Time getDurata_totale() {
        return durata_totale;
    }

    public void setDurata_totale(Time durata_totale) {
        this.durata_totale = durata_totale;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getDivisione() {
        return divisione;
    }

    public void setDivisione(String divisione) {
        this.divisione = divisione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    
    
}