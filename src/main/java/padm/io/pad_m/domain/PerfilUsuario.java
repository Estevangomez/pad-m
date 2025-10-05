package padm.io.pad_m.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbperfilusuario")
public class PerfilUsuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String descricao;

	private int nivel;

	@Column(name = "regra_id")
	private int regraId;

	private int seq;

	private String obs;

	private int flag;

	public PerfilUsuario() {
	}

	public PerfilUsuario(Integer id, String descricao, int nivel, int regraId, int seq, String obs, int flag) {
		this.id = id;
		this.descricao = descricao;
		this.nivel = nivel;
		this.regraId = regraId;
		this.seq = seq;
		this.obs = obs;
		this.flag = flag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getRegraId() {
		return regraId;
	}

	public void setRegraId(int regraId) {
		this.regraId = regraId;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
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
		PerfilUsuario other = (PerfilUsuario) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "PerfilUsuario [id=" + id + ", descricao=" + descricao + ", nivel=" + nivel + ", regraId=" + regraId
				+ ", seq=" + seq + ", obs=" + obs + ", flag=" + flag + "]";
	}

}
