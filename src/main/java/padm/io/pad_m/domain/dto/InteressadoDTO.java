package padm.io.pad_m.domain.dto;

public class InteressadoDTO {

	private Integer idProcesso;
	private Integer idUsuario;
	private Integer idSetor;
	private int ret;

	public InteressadoDTO() {
	}

	public InteressadoDTO(Integer idProcesso, Integer idUsuario, Integer idSetor, int ret) {
		this.idProcesso = idProcesso;
		this.idUsuario = idUsuario;
		this.idSetor = idSetor;
		this.ret = ret;
	}

	public Integer getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(Integer idProcesso) {
		this.idProcesso = idProcesso;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(Integer idSetor) {
		this.idSetor = idSetor;
	}

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}
}
