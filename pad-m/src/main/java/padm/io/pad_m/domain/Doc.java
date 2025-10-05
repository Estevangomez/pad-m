package padm.io.pad_m.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbdoc")
public class Doc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "usu_id")
	private Usuario usu_id;

	@Column(name = "NOMDOC")
	private String nomdoc;

	@Column(name = "HASHDOC")
	private String hashdoc;

	@Column(name = "EXTDOC")
	private String extdoc;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TIPODOC_ID")
	private TipoDoc tipoDoc;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sigilo_id")
	private Sigilo sigiloId;

	@Column(name = "TIPODOC")
	private String tipodocDesc;

	@Column(name = "TAMDOC")
	private String tamdoc;

	@Column(name = "CONTEUDO")
	private String conteudo;

	private LocalDateTime data;

	private String obs;

	private int seq;

	@Column(name = "FLAG")
	private int flag;

	public Doc() {

	}

	public Doc(Integer id, Usuario usu_id, String nomdoc, String hashdoc, String extdoc, TipoDoc tipoDoc,
			Sigilo sigiloId, String tipodocDesc, String tamdoc, String conteudo, LocalDateTime data, String obs,
			int seq, int flag) {
		this.id = id;
		this.usu_id = usu_id;
		this.nomdoc = nomdoc;
		this.hashdoc = hashdoc;
		this.extdoc = extdoc;
		this.tipoDoc = tipoDoc;
		this.sigiloId = sigiloId;
		this.tipodocDesc = tipodocDesc;
		this.tamdoc = tamdoc;
		this.conteudo = conteudo;
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

	public Usuario getUsu_id() {
		return usu_id;
	}

	public void setUsu_id(Usuario usu_id) {
		this.usu_id = usu_id;
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

	public String getTipodocDesc() {
		return tipodocDesc;
	}

	public void setTipodocDesc(String tipodocDesc) {
		this.tipodocDesc = tipodocDesc;
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

	public String getHashdoc() {
		return hashdoc;
	}

	public void setHashdoc(String hashdoc) {
		this.hashdoc = hashdoc;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public TipoDoc getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(TipoDoc tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public Sigilo getSigiloId() {
		return sigiloId;
	}

	public void setSigiloId(Sigilo sigiloId) {
		this.sigiloId = sigiloId;
	}

}
