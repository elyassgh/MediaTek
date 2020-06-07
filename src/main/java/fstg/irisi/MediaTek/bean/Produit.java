package fstg.irisi.MediaTek.bean;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Produit implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="produit_seq_gen")
    @SequenceGenerator(name="produit_seq_gen", sequenceName="PRODUIT_SEQ")
    private Long id;

    private String designation;
    private Double prixUnit;
    private int qteStock;
    private String categorie;

    public Produit() {
    }

    public Produit(Long id, String designation, Double prixUnit, int qteStock, String categorie) {
        this.id = id;
        this.designation = designation;
        this.prixUnit = prixUnit;
        this.qteStock = qteStock;
        this.categorie = categorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getPrixUnit() {
        return prixUnit;
    }

    public void setPrixUnit(Double prixUnit) {
        this.prixUnit = prixUnit;
    }

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
