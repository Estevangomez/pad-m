package padm.io.pad_m.domain.dto;

public class ResultDTO {

	private int id;
	private String type;
	private String mensagem;	
	private int ret;
	
	public ResultDTO() {
	}
	
	public ResultDTO(String message, String type, int ret) {
		this.mensagem = message;
		this.type = type;
		this.ret = ret;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String message) {
		this.mensagem = message;
	}
	public void setMsg(String message, String type, int ret) {
		this.mensagem = message;
		this.type = type;
		this.ret = ret;
	}

	public int getRet() {
		return ret;
	}
	public void setRet(int ret) {
		this.ret = ret;
	}
}
