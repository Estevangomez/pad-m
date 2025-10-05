package padm.io.pad_m.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbminuta")
public class Minuta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "PROC_ID")
	private Processo proc_id;

	@ManyToOne
	@JoinColumn(name = "usu_id")
	private Usuario usu_id;

	@ManyToOne
	@JoinColumn(name = "set_id")
	private Setor set_id;

	@Column(name = "NOMDOC")
	private String nomdoc;

	@Column(name = "EXTDOC")
	private String extdoc;

	@Column(name = "TIPODOC")
	private String tipodoc;

	@Column(name = "TAMDOC")
	private String tamdoc;

	private LocalDateTime data;

	private String obs;

	private int seq;

	private int flag;

	public Minuta() {

	}

	public Minuta(Integer id, Processo proc_id, Usuario usu_id, Setor set_id, String nomdoc, String extdoc,
			String tipodoc, String tamdoc, LocalDateTime data, String obs, int seq, int flag) {
		super();
		this.id = id;
		this.proc_id = proc_id;
		this.usu_id = usu_id;
		this.set_id = set_id;
		this.nomdoc = nomdoc;
		this.extdoc = extdoc;
		this.tipodoc = tipodoc;
		this.tamdoc = tamdoc;
		this.data = data;
		this.obs = obs;
		this.seq = seq;
		this.flag = flag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Processo getProc_id() {
		return proc_id;
	}

	public void setProc_id(Processo proc_id) {
		this.proc_id = proc_id;
	}

	public Usuario getUsu_id() {
		return usu_id;
	}

	public void setUsu_id(Usuario usu_id) {
		this.usu_id = usu_id;
	}

	public Setor getSet_id() {
		return set_id;
	}

	public void setSet_id(Setor set_id) {
		this.set_id = set_id;
	}

	public String getNomdoc() {
		return nomdoc;
	}

	public void setNomdoc(String nomdoc) {
		this.nomdoc = nomdoc;
	}

	public String getExtdoc() {
		return extdoc;
	}

	public void setExtdoc(String extdoc) {
		this.extdoc = extdoc;
	}

	public String getTipodoc() {
		return tipodoc;
	}

	public void setTipodoc(String tipodoc) {
		this.tipodoc = tipodoc;
	}

	public String getTamdoc() {
		return tamdoc;
	}

	public void setTamdoc(String tamdoc) {
		this.tamdoc = tamdoc;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
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
		Minuta other = (Minuta) obj;
		return Objects.equals(id, other.id);
	}

}
