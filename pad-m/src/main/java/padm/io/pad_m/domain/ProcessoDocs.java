package padm.io.pad_m.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbprocessodocs")
public class ProcessoDocs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "processo_id")
	private Processo processo;

	@ManyToOne
	@JoinColumn(name = "documento_id")
	private Doc documento;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	private String datacad;

	public ProcessoDocs() {
	}

	public ProcessoDocs(Integer id, Processo processo, Doc documento, Usuario usuario, String datacad) {
		this.id = id;
		this.processo = processo;
		this.documento = documento;
		this.usuario = usuario;
		this.datacad = datacad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public Doc getDocumento() {
		return documento;
	}

	public void setDocumento(Doc documento) {
		this.documento = documento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDatacad() {
		return datacad;
	}

	public void setDatacad(String datacad) {
		this.datacad = datacad;
	}

	@Override
	public String toString() {
		return "ProcessoDocs [id=" + id + ", processo=" + processo + ", documento=" + documento + ", usuario=" + usuario
				+ ", datacad=" + datacad + "]";
	}

}
