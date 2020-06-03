package fstg.irisi.MediaTek.bean;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LignesFact implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    CleLignesFact id;

    @Column(name="qteCom")
    private int qteCom;

    public LignesFact() {
    }

    public LignesFact(CleLignesFact id, int qteCom) {
        this.id = id;
        this.qteCom = qteCom;
    }

    public CleLignesFact getId() {
        return id;
    }

    public void setId(CleLignesFact id) {
        this.id = id;
    }

    public int getQteCom() {
        return qteCom;
    }

    public void setQteCom(int qteCom) {
        this.qteCom = qteCom;
    }
}
