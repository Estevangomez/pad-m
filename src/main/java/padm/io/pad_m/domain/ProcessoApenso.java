package padm.io.pad_m.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbprocessoapensos")
public class ProcessoApenso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "processo_id")
	private Processo idProcesso;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "processo")
	private Processo processo;

	private LocalDateTime datacad;

	private String obs;

	public ProcessoApenso() {
	}

	public ProcessoApenso(Integer id, Processo idProcesso, Usuario usuario, Processo processo, LocalDateTime datacad,
			String obs) {
		this.id = id;
		this.idProcesso = idProcesso;
		this.usuario = usuario;
		this.processo = processo;
		this.datacad = datacad;
		this.obs = obs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Processo getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(Processo idProcesso) {
		this.idProcesso = idProcesso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public LocalDateTime getDatacad() {
		return datacad;
	}

	public void setDatacad(LocalDateTime datacad) {
		this.datacad = datacad;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Override
	public String toString() {
		return "ProcessoApenso [id=" + id + ", idProcesso=" + idProcesso + ", usuario=" + usuario + ", processo="
				+ processo + ", datacad=" + datacad + ", obs=" + obs + "]";
	}

}
