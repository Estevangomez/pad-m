package padm.io.pad_m.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbinteressado")
public class Interessado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "proc_id")
	private Processo proc_id;

	@ManyToOne
	@JoinColumn(name = "usu_id")
	private Usuario usu_id;

	@ManyToOne
	@JoinColumn(name = "setor_id")
	private Setor setor;

	private String interessado;

	private LocalDateTime data;

	private String obs;

	private int seq;

	private int flag;

	public Interessado() {

	}
	
	

	public Interessado(Integer id, String interessado) {		
		this.id = id;
		this.interessado = interessado;
	}



	public Interessado(Integer id, Processo proc_id, Usuario usu_id, Setor setor, String interessado,
			LocalDateTime data, String obs, int seq, int flag) {
		this.id = id;
		this.proc_id = proc_id;
		this.usu_id = usu_id;
		this.setor = setor;
		this.interessado = interessado;
		this.data = data;
		this.obs = obs;
		this.seq = seq;
		this.flag = flag;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
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

	public String getInteressado() {
		return interessado;
	}

	public void setInteressado(String interessado) {
		this.interessado = interessado;
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
		Interessado other = (Interessado) obj;
		return Objects.equals(id, other.id);
	}

}
