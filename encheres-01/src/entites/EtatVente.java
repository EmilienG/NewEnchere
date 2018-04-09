package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class EtatVente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    // associations ------------------
    @OneToMany(mappedBy = "etatVente")
    private Collection<Vente> ventes;

    public EtatVente() {
        ventes = new ArrayList<>();
    }

    public EtatVente(String nom) {
        this();
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtatVente)) {
            return false;
        }
        EtatVente other = (EtatVente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<Vente> getVentes() {
        return ventes;
    }

    public void setVentes(Collection<Vente> ventes) {
        this.ventes = ventes;
    }

    @Override
    public String toString() {
        return "EtatVente[ nom : " + nom + " (" + id + ") ]";
    }
}
