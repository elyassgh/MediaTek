package fstg.irisi.MediaTek.bean;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="facture_seq_gen")
    @SequenceGenerator(name="facture_seq_gen", sequenceName="FACT_SEQ")
    private Long id;

    private Long num;
    @ManyToOne
    private Client client;
    @Column(name="dateFact")
    private LocalDate date;
    private String adresseFact;


    public Facture() {
    }

    public Facture(Long id, Long num, LocalDate date, String adresseFact, Client client) {
        this.id = id;
        this.num = num;
        this.date = date;
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
