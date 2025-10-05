package padm.io.pad_m.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "tbperfis")
public class Perfis implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "USUARIO_ID")
	private Integer idUser;

	private Integer perfis;

	public Perfis() {

	}
 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPerfis() {
		return perfis;
	}

	public void setPerfis(Integer perfis) {
		this.perfis = perfis;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfis other = (Perfis) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Perfis [id=" + id + ", descricao=" + perfis + "]";
	}

}