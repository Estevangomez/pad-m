package padm.io.pad_m.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbatendente")
public class Atendente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private Usuario usuario;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "setor_id")
	private Setor setor;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "servidor_id")
	private Servidor servidor;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sigilo_id")
	private Sigilo sigilo;

	private String visibilidade;

	private LocalDateTime data;

	private String obs;

	@Column(name = "datacriacao")
	private LocalDateTime datacriacao;

	@Column(name = "dataremocao")
	private LocalDateTime dataremocao;

	private int seq;

	private int flag;

	public Atendente() {

	}

	public Atendente(Integer id, Usuario usuario, Setor setor, Servidor servidor, Sigilo sigilo, String visibilidade,
			LocalDateTime data, String obs, LocalDateTime datacriacao, LocalDateTime dataremocao, int seq, int flag) {
		this.id = id;
		this.usuario = usuario;
		this.setor = setor;
		this.servidor = servidor;
		this.sigilo = sigilo;
		this.visibilidade = visibilidade;
		this.data = data;
		this.obs = obs;
		this.datacriacao = datacriacao;
		this.dataremocao = dataremocao;
		this.seq = seq;
		this.flag = flag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public Sigilo getSigilo() {
		return sigilo;
	}

	public void setSigilo(Sigilo sigilo) {
		this.sigilo = sigilo;
	}

	public String getVisibilidade() {
		return visibilidade;
	}

	public void setVisibilidade(String visibilidade) {
		this.visibilidade = visibilidade;
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
		Atendente other = (Atendente) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Atendente [id=" + id + ", usuario=" + usuario + ", setor=" + setor + ", servidor=" + servidor
				+ ", sigilo=" + sigilo + ", visibilidade=" + visibilidade + ", data=" + data + ", obs=" + obs
				+ ", datacriacao=" + datacriacao + ", dataremocao=" + dataremocao + ", seq=" + seq + ", flag=" + flag
				+ "]";
	}

}
