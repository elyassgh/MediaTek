package fstg.irisi.MediaTek.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Facture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="facture_seq_gen")
    @SequenceGenerator(name="facture_seq_gen", sequenceName="FACT_SEQ")
    private Long id;

    @Column(unique = true)
    private String reference;
    @ManyToOne
    @JoinColumn(name ="id_client",insertable=true, updatable=false)
    private Client client;
    @Column(name="dateFact")
    private LocalDate date;
    private String adresseFact;


    public Facture() {
    }

    public Facture(Long id, String reference, Client client, LocalDate date, String adresseFact) {
        this.id = id;
        this.reference = reference;
        this.client = client;
        this.date = date;
        this.adresseFact = adresseFact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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
