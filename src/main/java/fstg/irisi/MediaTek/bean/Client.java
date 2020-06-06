package fstg.irisi.MediaTek.bean;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="client_seq_gen")
    @SequenceGenerator(name="client_seq_gen", sequenceName="CLIENT_SEQ")
    private Long id;

    private String nom;
    private String prenom;
    @Column(unique = true)
    private String cin;
    private String adresse;
    private String tele;

    public Client() {
    }

    public Client(Long id, String cin, String nom, String prenom, String adresse, String tele) {
        this.id = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tele = tele;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }
}
