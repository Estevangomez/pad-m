package padm.io.pad_m.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbprocesso")
public class Processo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String numproc;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo")
	private TipoProcesso tipo;

	private Integer ano;

	private String numanoproc;

	private String assunto;

	private Integer tramitado;

	private Integer arquivado;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "docproc_id")
	private Doc documento;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "setcriador_id")
	private Setor setorcriadorId;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "evento_id") private Evento eventoId;
	 */
	@ManyToOne
	@JoinColumn(name = "fase_id")
	private Fase faseId;

	@ManyToOne
	@JoinColumn(name = "interessado_id")
	private Interessado interessadoId;

	@ManyToOne
	@JoinColumn(name = "minuta_id")
	private Minuta minutaId;

	private int lembreteId;

	@ManyToOne
	@JoinColumn(name = "sigilo_id")
	private Sigilo sigiloId;

	@Column(name = "class_id")
	private int classId;

	private String classificacao;

	private int rotuloId;

	private Integer usucriadorId;

	private LocalDateTime datacriacao;

	private int procapensadoId;

	private int flagapensoId;

	private String motivoapenso;

	private int procapensoprincId;

	private String motivoapensoprinc;

	private int procanexado_id;

	private int flaganexado_id;

	private String motivoanexo;

	private int procanexoprincId;

	private int flaganexoprincId;

	private String motivoanexoprinc;

	private LocalDateTime data;

	private String obs;

	private int seq;

	private int flag;

	public Processo() {
	}

	public Processo(Integer id, String numproc, TipoProcesso tipo, Integer ano, String numanoproc, String assunto,
			Integer tramitado, Integer arquivado, Doc documento, Setor setorcriadorId, Fase faseId,
			Interessado interessadoId, Minuta minutaId, int lembreteId, Sigilo sigiloId, int classId,
			String classificacao, int rotuloId, Integer usucriadorId, LocalDateTime datacriacao, int procapensadoId,
			int flagapensoId, String motivoapenso, int procapensoprincId, String motivoapensoprinc, int procanexado_id,
			int flaganexado_id, String motivoanexo, int procanexoprincId, int flaganexoprincId, String motivoanexoprinc,
			LocalDateTime data, String obs, int seq, int flag) {
		super();
		this.id = id;
		this.numproc = numproc;
		this.tipo = tipo;
		this.ano = ano;
		this.numanoproc = numanoproc;
		this.assunto = assunto;
		this.tramitado = tramitado;
		this.arquivado = arquivado;
		this.documento = documento;
		this.setorcriadorId = setorcriadorId;
		this.faseId = faseId;
		this.interessadoId = interessadoId;
		this.minutaId = minutaId;
		this.lembreteId = lembreteId;
		this.sigiloId = sigiloId;
		this.classId = classId;
		this.classificacao = classificacao;
		this.rotuloId = rotuloId;
		this.usucriadorId = usucriadorId;
		this.datacriacao = datacriacao;
		this.procapensadoId = procapensadoId;
		this.flagapensoId = flagapensoId;
		this.motivoapenso = motivoapenso;
		this.procapensoprincId = procapensoprincId;
		this.motivoapensoprinc = motivoapensoprinc;
		this.procanexado_id = procanexado_id;
		this.flaganexado_id = flaganexado_id;
		this.motivoanexo = motivoanexo;
		this.procanexoprincId = procanexoprincId;
		this.flaganexoprincId = flaganexoprincId;
		this.motivoanexoprinc = motivoanexoprinc;
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

	public String getNumproc() {
		return numproc;
	}

	public void setNumproc(String numproc) {
		this.numproc = numproc;
	}

	public TipoProcesso getTipo() {
		return tipo;
	}

	public void setTipo(TipoProcesso tipo) {
		this.tipo = tipo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getNumanoproc() {
		return numanoproc;
	}

	public void setNumanoproc(String numanoproc) {
		this.numanoproc = numanoproc;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public int getRotuloId() {
		return rotuloId;
	}

	public void setRotuloId(int rotuloId) {
		this.rotuloId = rotuloId;
	}

	public Integer getUsucriadorId() {
		return usucriadorId;
	}

	public void setUsucriadorId(Integer usucriadorId) {
		this.usucriadorId = usucriadorId;
	}

	public Setor getSetorcriadorId() {
		return setorcriadorId;
	}

	public void setSetorcriadorId(Setor setorcriadorId) {
		this.setorcriadorId = setorcriadorId;
	}

	public LocalDateTime getDatacriacao() {
		return datacriacao;
	}

	public void setDatacriacao(LocalDateTime datacriacao) {
		this.datacriacao = datacriacao;
	}

	public Interessado getInteressadoId() {
		return interessadoId;
	}

	public void setInteressadoId(Interessado interessadoId) {
		this.interessadoId = interessadoId;
	}

	public Minuta getMinutaId() {
		return minutaId;
	}

	public void setMinutaId(Minuta minutaId) {
		this.minutaId = minutaId;
	}

	public int getLembreteId() {
		return lembreteId;
	}

	public void setLembreteId(int lembreteId) {
		this.lembreteId = lembreteId;
	}

	public Sigilo getSigiloId() {
		return sigiloId;
	}

	public void setSigiloId(Sigilo sigiloId) {
		this.sigiloId = sigiloId;
	}

	public int getProcapensadoId() {
		return procapensadoId;
	}

	public void setProcapensadoId(int procapensadoId) {
		this.procapensadoId = procapensadoId;
	}

	public int getFlagapensoId() {
		return flagapensoId;
	}

	public void setFlagapensoId(int flagapensoId) {
		this.flagapensoId = flagapensoId;
	}

	public String getMotivoapenso() {
		return motivoapenso;
	}

	public void setMotivoapenso(String motivoapenso) {
		this.motivoapenso = motivoapenso;
	}

	public int getProcapensoprincId() {
		return procapensoprincId;
	}

	public void setProcapensoprincId(int procapensoprincId) {
		this.procapensoprincId = procapensoprincId;
	}

	public String getMotivoapensoprinc() {
		return motivoapensoprinc;
	}

	public void setMotivoapensoprinc(String motivoapensoprinc) {
		this.motivoapensoprinc = motivoapensoprinc;
	}

	public int getProcanexado_id() {
		return procanexado_id;
	}

	public void setProcanexado_id(int procanexado_id) {
		this.procanexado_id = procanexado_id;
	}

	public int getFlaganexado_id() {
		return flaganexado_id;
	}

	public void setFlaganexado_id(int flaganexado_id) {
		this.flaganexado_id = flaganexado_id;
	}

	public String getMotivoanexo() {
		return motivoanexo;
	}

	public void setMotivoanexo(String motivoanexo) {
		this.motivoanexo = motivoanexo;
	}

	public int getProcanexoprincId() {
		return procanexoprincId;
	}

	public void setProcanexoprincId(int procanexoprincId) {
		this.procanexoprincId = procanexoprincId;
	}

	public int getFlaganexoprincId() {
		return flaganexoprincId;
	}

	public void setFlaganexoprincId(int flaganexoprincId) {
		this.flaganexoprincId = flaganexoprincId;
	}

	public String getMotivoanexoprinc() {
		return motivoanexoprinc;
	}

	public void setMotivoanexoprinc(String motivoanexoprinc) {
		this.motivoanexoprinc = motivoanexoprinc;
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

	public Doc getDocumento() {
		return documento;
	}

	public void setDocumento(Doc documento) {
		this.documento = documento;
	}

	public Fase getFaseId() {
		return faseId;
	}

	public void setFaseId(Fase faseId) {
		this.faseId = faseId;
	}

	public Integer getTramitado() {
		return tramitado;
	}

	public void setTramitado(Integer tramitado) {
		this.tramitado = tramitado;
	}

	public Integer getArquivado() {
		return arquivado;
	}

	public void setArquivado(Integer arquivado) {
		this.arquivado = arquivado;
	}

	@Override
	public String toString() {
		return "Processo [id=" + id + ", numproc=" + numproc + ", tipo=" + tipo + ", ano=" + ano + ", numanoproc="
				+ numanoproc + ", assunto=" + assunto + ", tramitado=" + tramitado + ", arquivado=" + arquivado
				+ ", documento=" + documento + ", setorcriadorId=" + setorcriadorId + ", faseId=" + faseId
				+ ", interessadoId=" + interessadoId + ", minutaId=" + minutaId + ", lembreteId=" + lembreteId
				+ ", sigiloId=" + sigiloId + ", classId=" + classId + ", classificacao=" + classificacao + ", rotuloId="
				+ rotuloId + ", usucriadorId=" + usucriadorId + ", datacriacao=" + datacriacao + ", procapensadoId="
				+ procapensadoId + ", flagapensoId=" + flagapensoId + ", motivoapenso=" + motivoapenso
				+ ", procapensoprincId=" + procapensoprincId + ", motivoapensoprinc=" + motivoapensoprinc
				+ ", procanexado_id=" + procanexado_id + ", flaganexado_id=" + flaganexado_id + ", motivoanexo="
				+ motivoanexo + ", procanexoprincId=" + procanexoprincId + ", flaganexoprincId=" + flaganexoprincId
				+ ", motivoanexoprinc=" + motivoanexoprinc + ", data=" + data + ", obs=" + obs + ", seq=" + seq
				+ ", flag=" + flag + "]";
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
		Processo other = (Processo) obj;
		return Objects.equals(id, other.id);
	}

}
