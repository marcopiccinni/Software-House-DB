import java.sql.Timestamp;
public class Hardware
{
    private int id;
    private Timestamp data_e, data_u;
    private String posizione, tipo, descrizione, marca, modello;

    public Hardware(int id, Timestamp data_e, Timestamp data_u,
            String posizione, String tipo, String descrizione,
            String marca, String modello)
    {
        this.id = id;
        this.data_e = data_e;
        this.data_u = data_u;
        this.posizione = posizione;
        this.tipo = tipo;
        this.descrizione = descrizione;
        this.marca = marca;
        this.modello = modello;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getData_e() {
        return data_e;
    }

    public void setData_e(Timestamp data_e) {
        this.data_e = data_e;
    }

    public Timestamp getData_u() {
        return data_u;
    }

    public void setData_u(Timestamp data_u) {
        this.data_u = data_u;
    }

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }
    
    public String getInfo()
    {
        return tipo + " - " + marca + " " + modello;
    }
    
}
