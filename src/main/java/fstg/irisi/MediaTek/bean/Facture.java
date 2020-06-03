package fstg.irisi.MediaTek.bean;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="facture_seq_gen")
    @SequenceGenerator(name="facture_seq_gen", sequenceName="FACT_SEQ")
    private Long id;

    private Long num;
    @Column(name="dateFact")
    private LocalDate date;
    private LocalTime temps;
    private String adresseFact;
    @ManyToOne
    private Client client;

    public Facture() {
    }

    public Facture(Long id, Long num, LocalDate date, LocalTime temps, String adresseFact, Client client) {
        this.id = id;
        this.num = num;
        this.date = date;
        this.temps = temps;
        this.adresseFact = adresseFact;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTemps() {
        return temps;
    }

    public void setTemps(LocalTime temps) {
        this.temps = temps;
    }

    public String getAdresseFact() {
        return adresseFact;
    }

    public void setAdresseFact(String adresseFact) {
        this.adresseFact = adresseFact;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
