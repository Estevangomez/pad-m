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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tbevento")
public class Evento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "tipo_id")
	private TipoEvento tipo_id;

	@ManyToOne
	@JoinColumn(name = "tramite_id")
	private Tramite tramite_id;

	@ManyToOne
	@JoinColumn(name = "proc_id")
	private Processo proc_id;

	@ManyToOne
	@JoinColumn(name = "doc_id")
	private Doc doc_id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataevento;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime datainicio;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime datatermino;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Usuario user_id;

	private Integer usercriador_id;

	@Column(name = "RESPONSAVEL_ID")
	private Integer responsavel_id;

	@ManyToOne
	@JoinColumn(name = "atendente_id")
	private Atendente atendente_id;

	@ManyToOne
	@JoinColumn(name = "moderador_id")
	private Moderador moderador_id;

	@ManyToOne
	@JoinColumn(name = "gestor_id")
	private Gestor gestor_id;

	@ManyToOne
	@JoinColumn(name = "setor_Id")
	private Setor setor_Id;

	private String evento;

	private String orgenv;

	private LocalDateTime dataorgenv;

	private String usuenv;

	private LocalDateTime datausuenv;

	private String orgrec;

	private LocalDateTime dataorgrec;

	private String usurec;

	private LocalDateTime datausurec;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime datachegada;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime datasaida;

	@ManyToOne
	@JoinColumn(name = "finalidade_id")
	private Finalidade finalidade_id;

	private String finalidade;

	@Column(name = "MOTIVO_ID")
	private Integer motivo_id;

	private String motivo;

	private String statusenviado;

	private String statusrecebido;

	private String statusproc;

	private String obs;

	private Integer seq;

	private Integer flag;

	private Integer placed;

	public Evento() {

	}

	public Evento(Integer id, TipoEvento tipo_id, Tramite tramite_id, Processo proc_id, Doc doc_id,
			LocalDateTime dataevento, LocalDateTime datainicio, LocalDateTime datatermino, Usuario user_id,
			Integer usercriador_id, Integer responsavel_id, Atendente atendente_id, Moderador moderador_id,
			Gestor gestor_id, Setor setor_Id, String evento, String orgenv, LocalDateTime dataorgenv, String usuenv,
			LocalDateTime datausuenv, String orgrec, LocalDateTime dataorgrec, String usurec, LocalDateTime datausurec,
			LocalDateTime datachegada, LocalDateTime datasaida, Finalidade finalidade_id, String finalidade,
			Integer motivo_id, String motivo, String statusenviado, String statusrecebido, String statusproc,
			String obs, Integer seq, Integer flag, Integer placed) {
		super();
		this.id = id;
		this.tipo_id = tipo_id;
		this.tramite_id = tramite_id;
		this.proc_id = proc_id;
		this.doc_id = doc_id;
		this.dataevento = dataevento;
		this.datainicio = datainicio;
		this.datatermino = datatermino;
		this.user_id = user_id;
		this.usercriador_id = usercriador_id;
		this.responsavel_id = responsavel_id;
		this.atendente_id = atendente_id;
		this.moderador_id = moderador_id;
		this.gestor_id = gestor_id;
		this.setor_Id = setor_Id;
		this.evento = evento;
		this.orgenv = orgenv;
		this.dataorgenv = dataorgenv;
		this.usuenv = usuenv;
		this.datausuenv = datausuenv;
		this.orgrec = orgrec;
		this.dataorgrec = dataorgrec;
		this.usurec = usurec;
		this.datausurec = datausurec;
		this.datachegada = datachegada;
		this.datasaida = datasaida;
		this.finalidade_id = finalidade_id;
		this.finalidade = finalidade;
		this.motivo_id = motivo_id;
		this.motivo = motivo;
		this.statusenviado = statusenviado;
		this.statusrecebido = statusrecebido;
		this.statusproc = statusproc;
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

	public TipoEvento getTipo_id() {
		return tipo_id;
	}

	public void setTipo_id(TipoEvento tipo_id) {
		this.tipo_id = tipo_id;
	}

	public Tramite getTramite_id() {
		return tramite_id;
	}

	public void setTramite_id(Tramite tramite_id) {
		this.tramite_id = tramite_id;
	}

	public Processo getProc_id() {
		return proc_id;
	}

	public void setProc_id(Processo proc_id) {
		this.proc_id = proc_id;
	}

	public Doc getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(Doc doc_id) {
		this.doc_id = doc_id;
	}

	public LocalDateTime getDataevento() {
		return dataevento;
	}

	public void setDataevento(LocalDateTime dataevento) {
		this.dataevento = dataevento;
	}

	public LocalDateTime getDatainicio() {
		return datainicio;
	}

	public void setDatainicio(LocalDateTime datainicio) {
		this.datainicio = datainicio;
	}

	public LocalDateTime getDatatermino() {
		return datatermino;
	}

	public void setDatatermino(LocalDateTime datatermino) {
		this.datatermino = datatermino;
	}

	public Usuario getUser_id() {
		return user_id;
	}

	public void setUser_id(Usuario user_id) {
		this.user_id = user_id;
	}

	public Integer getUsercriador_id() {
		return usercriador_id;
	}

	public void setUsercriador_id(Integer usercriador_id) {
		this.usercriador_id = usercriador_id;
	}

	public Integer getResponsavel_id() {
		return responsavel_id;
	}

	public void setResponsavel_id(Integer responsavel_id) {
		this.responsavel_id = responsavel_id;
	}

	public Atendente getAtendente_id() {
		return atendente_id;
	}

	public void setAtendente_id(Atendente atendente_id) {
		this.atendente_id = atendente_id;
	}

	public Moderador getModerador_id() {
		return moderador_id;
	}

	public void setModerador_id(Moderador moderador_id) {
		this.moderador_id = moderador_id;
	}

	public Gestor getGestor_id() {
		return gestor_id;
	}

	public void setGestor_id(Gestor gestor_id) {
		this.gestor_id = gestor_id;
	}

	public Setor getSetor_Id() {
		return setor_Id;
	}

	public void setSetor_Id(Setor setor_Id) {
		this.setor_Id = setor_Id;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getOrgenv() {
		return orgenv;
	}

	public void setOrgenv(String orgenv) {
		this.orgenv = orgenv;
	}

	public LocalDateTime getDataorgenv() {
		return dataorgenv;
	}

	public void setDataorgenv(LocalDateTime dataorgenv) {
		this.dataorgenv = dataorgenv;
	}

	public String getUsuenv() {
		return usuenv;
	}

	public void setUsuenv(String usuenv) {
		this.usuenv = usuenv;
	}

	public LocalDateTime getDatausuenv() {
		return datausuenv;
	}

	public void setDatausuenv(LocalDateTime datausuenv) {
		this.datausuenv = datausuenv;
	}

	public String getOrgrec() {
		return orgrec;
	}

	public void setOrgrec(String orgrec) {
		this.orgrec = orgrec;
	}

	public LocalDateTime getDataorgrec() {
		return dataorgrec;
	}

	public void setDataorgrec(LocalDateTime dataorgrec) {
		this.dataorgrec = dataorgrec;
	}

	public String getUsurec() {
		return usurec;
	}

	public void setUsurec(String usurec) {
		this.usurec = usurec;
	}

	public LocalDateTime getDatausurec() {
		return datausurec;
	}

	public void setDatausurec(LocalDateTime datausurec) {
		this.datausurec = datausurec;
	}

	public LocalDateTime getDatachegada() {
		return datachegada;
	}

	public void setDatachegada(LocalDateTime datachegada) {
		this.datachegada = datachegada;
	}

	public LocalDateTime getDatasaida() {
		return datasaida;
	}

	public void setDatasaida(LocalDateTime datasaida) {
		this.datasaida = datasaida;
	}

	public Finalidade getFinalidade_id() {
		return finalidade_id;
	}

	public void setFinalidade_id(Finalidade finalidade_id) {
		this.finalidade_id = finalidade_id;
	}

	public String getFinalidade() {
		return finalidade;
	}

	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}

	public Integer getMotivo_id() {
		return motivo_id;
	}

	public void setMotivo_id(Integer motivo_id) {
		this.motivo_id = motivo_id;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getStatusenviado() {
		return statusenviado;
	}

	public void setStatusenviado(String statusenviado) {
		this.statusenviado = statusenviado;
	}

	public String getStatusrecebido() {
		return statusrecebido;
	}

	public void setStatusrecebido(String statusrecebido) {
		this.statusrecebido = statusrecebido;
	}

	public String getStatusproc() {
		return statusproc;
	}

	public void setStatusproc(String statusproc) {
		this.statusproc = statusproc;
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
		Evento other = (Evento) obj;
		return Objects.equals(id, other.id);
	}

}
