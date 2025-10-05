package padm.io.pad_m.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbclassif")
public class Classif {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private int classgeral_id;

	private String nome;

	private String descricao;

	private String sigla;

	private String obs;

	private int seq;

	private int flag;

	private int placed;

	public Classif() {

	}

	public Classif(Integer id, int classgeral_id, String nome, String descricao, String sigla, String obs, int seq,
			int flag, int placed) {
		this.id = id;
		this.classgeral_id = classgeral_id;
		this.nome = nome;
		this.descricao = descricao;
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

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getPlaced() {
		return placed;
	}

	public void setPlaced(int placed) {
		this.placed = placed;
	}

	public int getClassgeral_id() {
		return classgeral_id;
	}

	public void setClassgeral_id(int classgeral_id) {
		this.classgeral_id = classgeral_id;
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
		Classif other = (Classif) obj;
		return Objects.equals(id, other.id);
	}

}
