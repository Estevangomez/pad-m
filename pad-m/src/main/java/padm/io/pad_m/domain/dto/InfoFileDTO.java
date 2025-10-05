package padm.io.pad_m.domain.dto;

public class InfoFileDTO {
	private String name;
	private String url;
	private String id;
	private String codehash;
	private String type;
	private String datacad;

	public InfoFileDTO() {
	}

	public InfoFileDTO(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public InfoFileDTO(String name, String url, String id, String codehash, String type, String datacad) {
		this.name = name;
		this.url = url;
		this.id = id;
		this.codehash = codehash;
		this.type = type;
		this.datacad = datacad;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodehash() {
		return codehash;
	}

	public void setCodehash(String codehash) {
		this.codehash = codehash;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDatacad() {
		return datacad;
	}

	public void setDatacad(String datacad) {
		this.datacad = datacad;
	}

}
