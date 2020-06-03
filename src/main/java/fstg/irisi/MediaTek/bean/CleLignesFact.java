package fstg.irisi.MediaTek.bean;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CleLignesFact implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="num_facture")
    private Facture facture;

	@ManyToOne
	@JoinColumn(name="id_produit")
    private Produit produit;

    public CleLignesFact() {
    }

	public CleLignesFact(Facture facture, Produit produit) {
		this.facture = facture;
		this.produit = produit;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(facture, produit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CleLignesFact other = (CleLignesFact) obj;
		return Objects.equals(facture, other.facture) && Objects.equals(produit, other.produit);
	}

	

}
