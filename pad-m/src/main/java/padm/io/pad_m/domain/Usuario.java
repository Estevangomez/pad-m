package padm.io.pad_m.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import padm.io.pad_m.domain.enums.Perfil;

@Entity
@Table(name = "tbusuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private String cpf;

	private String nickname;

	@ManyToOne(fetch = FetchType.EAGER)	
	@JoinColumn(name = "servidor_id")
	private Servidor servidorId;

	@JsonIgnore
	private String senha;

	private int perfilId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "lotacao_id")
	private Setor lotacao_id;

	private String ativo;

	private String certificado;

	private LocalDateTime dataexpiracao;

	private LocalDateTime ultimoacesso;

	private LocalDateTime datacriacao;

	private String image;

	private int flag;
	
	@Transient
	private boolean isProducao;

	@JsonIgnore
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "tbperfis")
	private Set<Integer> perfis = new HashSet<>();
	
	public Usuario() {
		
	}

	public Usuario(Integer id, String nome, String cpf, String nickname, Servidor servidorId, String senha,
			int perfilId, Setor lotacao_id, String ativo, String certificado, LocalDateTime dataexpiracao,
			LocalDateTime ultimoacesso, LocalDateTime datacriacao, String image, int flag) {		
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.nickname = nickname;
		this.servidorId = servidorId;
		this.senha = senha;
		this.perfilId = perfilId;
		this.lotacao_id = lotacao_id;
		this.ativo = ativo;
		this.certificado = certificado;
		this.dataexpiracao = dataexpiracao;
		this.ultimoacesso = ultimoacesso;
		this.datacriacao = datacriacao;
		this.image = image;
		this.flag = flag;		
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	
	public String getFirstName() {
		String[] nameparts = nome.split(" ");
		return nameparts[0];
	}
	
	public boolean isProducao() {
		return isProducao;
	}

	public void setProducao(boolean isProducao) {
		this.isProducao = isProducao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Servidor getServidorId() {
		return servidorId;
	}

	public void setServidorId(Servidor servidorId) {
		this.servidorId = servidorId;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(int perfilId) {
		this.perfilId = perfilId;
	}

	public String getCertificado() {
		return certificado;
	}

	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

	public LocalDateTime getDataexpiracao() {
		return dataexpiracao;
	}

	public void setDataexpiracao(LocalDateTime dataexpiracao) {
		this.dataexpiracao = dataexpiracao;
	}

	public LocalDateTime getUltimoacesso() {
		return ultimoacesso;
	}

	public void setUltimoacesso(LocalDateTime ultimoacesso) {
		this.ultimoacesso = ultimoacesso;
	}

	public LocalDateTime getDatacriacao() {
		return datacriacao;
	}

	public void setDatacriacao(LocalDateTime datacriacao) {
		this.datacriacao = datacriacao;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Setor getLotacao_id() {
		return lotacao_id;
	}

	public void setLotacao_id(Setor lotacao_id) {
		this.lotacao_id = lotacao_id;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", nickname=" + nickname + ", servidorId="
				+ servidorId + ", senha=" + senha + ", perfilId=" + perfilId + ", ativo=" + ativo + ", certificado="
				+ certificado + ", dataexpiracao=" + dataexpiracao + ", ultimoacesso=" + ultimoacesso + ", datacriacao="
				+ datacriacao + ", image=" + image + ", flag=" + flag + "]";
	}

}
