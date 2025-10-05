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
@Table(name = "tbmoderador")
public class Moderador {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "setor_id")
	private Setor setorId;

	@ManyToOne
	@JoinColumn(name = "servidor_id")
	private Servidor servidorId;

	@ManyToOne
	@JoinColumn(name = "sigilo_id")
	private Sigilo sigiloId;

	private String visibilidade;

	private LocalDateTime data;

	private String obs;

	@Column(name = "usercriador_id")
	private Integer usercriadorId;

	private LocalDateTime datacriacao;

	@Column(name = "DATAREMOCAO")
	private LocalDateTime dataremocao;

	private int seq;

	private int flag;

	private int placed;

	public Moderador() {
	}

	public Moderador(Integer id, Setor setorId, Servidor servidorId, Sigilo sigiloId, String visibilidade,
			LocalDateTime data, String obs, Integer usercriadorId, LocalDateTime datacriacao, LocalDateTime dataremocao,
			int seq, int flag, int placed) {
		this.id = id;
		this.setorId = setorId;
		this.servidorId = servidorId;
		this.sigiloId = sigiloId;
		this.visibilidade = visibilidade;
		this.data = data;
		this.obs = obs;
		this.usercriadorId = usercriadorId;
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

	public Setor getSetorId() {
		return setorId;
	}

	public void setSetorId(Setor setorId) {
		this.setorId = setorId;
	}

	public Servidor getServidorId() {
		return servidorId;
	}

	public void setServidorId(Servidor servidorId) {
		this.servidorId = servidorId;
	}

	public Sigilo getSigiloId() {
		return sigiloId;
	}

	public void setSigiloId(Sigilo sigiloId) {
		this.sigiloId = sigiloId;
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

	public Integer getUsercriadorId() {
		return usercriadorId;
	}

	public void setUsercriadorId(Integer usercriadorId) {
		this.usercriadorId = usercriadorId;
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
		Moderador other = (Moderador) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Moderador [id=" + id + ", setorId=" + setorId + ", sigiloId=" + sigiloId + ", visibilidade="
				+ visibilidade + ", data=" + data + ", obs=" + obs + ", usercriadorId=" + usercriadorId
				+ ", datacriacao=" + datacriacao + ", dataremocao=" + dataremocao + ", seq=" + seq + ", flag=" + flag
				+ ", placed=" + placed + "]";
	}

}
