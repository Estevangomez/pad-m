package padm.io.pad_m.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tbassinador")
public class Assinador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario userId;

	@ManyToOne
	@JoinColumn(name = "id_documento")
	private Doc doc;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime data;

	private String hashdoc;

	public Assinador() {

	}

	public Assinador(Integer id, Usuario userId, Doc doc, LocalDateTime data, String hashdoc) {
		this.id = id;
		this.userId = userId;
		this.doc = doc;
		this.data = data;
		this.hashdoc = hashdoc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUserId() {
		return userId;
	}

	public void setUserId(Usuario userId) {
		this.userId = userId;
	}

	public Doc getDoc() {
		return doc;
	}

	public void setDoc(Doc doc) {
		this.doc = doc;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getHashdoc() {
		return hashdoc;
	}

	public void setHashdoc(String hashdoc) {
		this.hashdoc = hashdoc;
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
		Assinador other = (Assinador) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Assinador [id=" + id + ", userId=" + userId + ", doc=" + doc + ", data=" + data + ", hashdoc=" + hashdoc
				+ "]";
	}

}
