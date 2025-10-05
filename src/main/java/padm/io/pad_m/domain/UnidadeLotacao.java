package padm.io.pad_m.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbunidadelotacao")
public class UnidadeLotacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orgaoid")
	private Orgao orgaoid;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "localidadeid")
	private Localidade localidadeid;

	private String nome;

	private String descricao;

	private String segmento;

	private String sigla;

	private String obs;

	private int seq;

	private int flag;

	private int placed;

	public UnidadeLotacao() {
	}

	public UnidadeLotacao(Integer id, Orgao orgaoid, Localidade localidadeid, String nome, String descricao,
			String segmento, String sigla, String obs, int seq, int flag, int placed) {
		this.id = id;
		this.orgaoid = orgaoid;
		this.localidadeid = localidadeid;
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

	public Orgao getOrgaoid() {
		return orgaoid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setOrgaoid(Orgao orgaoid) {
		this.orgaoid = orgaoid;
	}

	public Localidade getLocalidadeid() {
		return localidadeid;
	}

	public void setLocalidadeid(Localidade localidadeid) {
		this.localidadeid = localidadeid;
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
		UnidadeLotacao other = (UnidadeLotacao) obj;
		return Objects.equals(id, other.id);
	}

}
