package padm.io.pad_m.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tborgao")
public class Orgao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	private String segmento;
	
	private String sigla;
	
	private String obs;
	
	private Integer seq;
	
	private Integer flag;
	
	private Integer placed;

	public Orgao() {

	}

	public Orgao(Integer id, String nome, String descricao, String segmento, String sigla, String obs, Integer seq,
			Integer flag, Integer placed) {

		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.segmento = segmento;
		this.sigla = sigla;
		this.obs = obs;
		this.seq = seq;
		this.flag = flag;
		this.placed = placed;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getPlaced() {
		return placed;
	}

	public void setPlaced(Integer placed) {
		this.placed = placed;
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
		Orgao other = (Orgao) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Orgao [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", segmento=" + segmento + ", sigla="
				+ sigla + ", obs=" + obs + ", seq=" + seq + ", flag=" + flag + ", placed=" + placed + "]";
	}

}