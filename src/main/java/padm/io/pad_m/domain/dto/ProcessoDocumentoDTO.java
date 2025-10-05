package padm.io.pad_m.domain.dto;

public class ProcessoDocumentoDTO {

	private Integer idProcesso;
	private Integer idDocumento;
	private Integer idUsuario;
	private int ret;

	public ProcessoDocumentoDTO() {
	}

	public ProcessoDocumentoDTO(Integer idProcesso, Integer idDocumento, Integer idUsuario, int ret) {
		this.idProcesso = idProcesso;
		this.idDocumento = idDocumento;
		this.idUsuario = idUsuario;
		this.ret = ret;
	}

	public Integer getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(Integer idProcesso) {
		this.idProcesso = idProcesso;
	}

	public Integer getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Integer idDocumento) {
		this.idDocumento = idDocumento;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

}
