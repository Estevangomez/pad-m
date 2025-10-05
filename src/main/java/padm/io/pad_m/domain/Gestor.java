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
@Table(name = "tbgestor")
public class Gestor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Usuario user_id;

	@ManyToOne
	@JoinColumn(name = "setor_id")
	private Setor setor_id;

	@ManyToOne
	@JoinColumn(name = "servidor_id")
	private Servidor servidor_id;

	@ManyToOne
	@JoinColumn(name = "sigilo_id")
	private Sigilo sigilo_id;

	private String visibilidade;

	private String obs;

	@Column(name = "USERCRIADOR_ID")
	private int usercriador_id;

	private LocalDateTime datacriacao;

	private LocalDateTime dataremocao;

	private int seq;

	private int flag;

	private int placed;

	public Gestor() {

	}

	public Gestor(Integer id, Usuario user_id, Setor setor_id, Servidor servidor_id, Sigilo sigilo_id,
			String visibilidade, String obs, int usercriador_id, LocalDateTime datacriacao,
			LocalDateTime dataremocao, int seq, int flag, int placed) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.setor_id = setor_id;
		this.servidor_id = servidor_id;
		this.sigilo_id = sigilo_id;
		this.visibilidade = visibilidade;
		this.obs = obs;
		this.usercriador_id = usercriador_id;
		this.datacriacao = datacriacao;
		this.dataremocao = dataremocao;
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

	public Usuario getUser_id() {
		return user_id;
	}

	public void setUser_id(Usuario user_id) {
		this.user_id = user_id;
	}

	public Setor getSetor_id() {
		return setor_id;
	}

	public void setSetor_id(Setor setor_id) {
		this.setor_id = setor_id;
	}

	public Servidor getServidor_id() {
		return servidor_id;
	}

	public void setServidor_id(Servidor servidor_id) {
		this.servidor_id = servidor_id;
	}

	public Sigilo getSigilo_id() {
		return sigilo_id;
	}

	public void setSigilo_id(Sigilo sigilo_id) {
		this.sigilo_id = sigilo_id;
	}

	public String getVisibilidade() {
		return visibilidade;
	}

	public void setVisibilidade(String visibilidade) {
		this.visibilidade = visibilidade;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public int getUsercriador_id() {
		return usercriador_id;
	}

	public void setUsercriador_id(int usercriador_id) {
		this.usercriador_id = usercriador_id;
	}

	public LocalDateTime getDatacriacao() {
		return datacriacao;
	}

	public void setDatacriacao(LocalDateTime datacriacao) {
		this.datacriacao = datacriacao;
	}

	public LocalDateTime getDataremocao() {
		return dataremocao;
	}

	public void setDataremocao(LocalDateTime dataremocao) {
		this.dataremocao = dataremocao;
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
		Gestor other = (Gestor) obj;
		return Objects.equals(id, other.id);
	}

}
