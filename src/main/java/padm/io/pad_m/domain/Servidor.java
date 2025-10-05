package padm.io.pad_m.domain;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbservidor")
public class Servidor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Nome é obrigatório")
	private String nome;

	private String nomereduzido;

	private String cpf;

	private String rg;

	private String rgorgao;

	private String cargofuncao;

	private String endereco;

	private String numero;

	private String bairro;

	private String complemento;

	private String cidade;

	private String cep;

	private String telefone1;

	private String telefone2;

	private String redesocial;

	private String email;

	private LocalDate dataadmissao;

	private LocalDate datadesligamento;

	private int contratoId;

	private int setorpaiId;

	private int setorlotacaoId;

	private LocalDate datacadastro;

	private int perfilId;

	private String hash;

	private String certificado;

	private LocalDate dataexpiracao;

	private LocalDate ultimoacesso;

	private LocalDate datacriacao;

	private String image;

	private int placed;

	private int ativo;

	private String obs;

	private int seq;

	private int flag;

	public Servidor() {
	}

	public Servidor(Integer id, String nome, String nomereduzido, String cpf, String rg, String rgorgao,
			String cargofuncao, String endereco, String numero, String bairro, String complemento, String cidade,
			String cep, String telefone1, String telefone2, String redesocial, String email, LocalDate dataadmissao,
			LocalDate datadesligamento, int contratoId, int setorpaiId, int setorlotacaoId, LocalDate datacadastro,
			int perfilId, String hash, String certificado, LocalDate dataexpiracao, LocalDate ultimoacesso,
			LocalDate datacriacao, String image, int placed, int ativo, String obs, int seq, int flag) {
		this.id = id;
		this.nome = nome;
		this.nomereduzido = nomereduzido;
		this.cpf = cpf;
		this.rg = rg;
		this.rgorgao = rgorgao;
		this.cargofuncao = cargofuncao;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.cep = cep;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.redesocial = redesocial;
		this.email = email;
		this.dataadmissao = dataadmissao;
		this.datadesligamento = datadesligamento;
		this.contratoId = contratoId;
		this.setorpaiId = setorpaiId;
		this.setorlotacaoId = setorlotacaoId;
		this.datacadastro = datacadastro;
		this.perfilId = perfilId;
		this.hash = hash;
		this.certificado = certificado;
		this.dataexpiracao = dataexpiracao;
		this.ultimoacesso = ultimoacesso;
		this.datacriacao = datacriacao;
		this.image = image;
		this.placed = placed;
		this.ativo = ativo;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomereduzido() {
		return nomereduzido;
	}

	public void setNomereduzido(String nomereduzido) {
		this.nomereduzido = nomereduzido;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRgorgao() {
		return rgorgao;
	}

	public void setRgorgao(String rgorgao) {
		this.rgorgao = rgorgao;
	}

	public String getCargofuncao() {
		return cargofuncao;
	}

	public void setCargofuncao(String cargofuncao) {
		this.cargofuncao = cargofuncao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getRedesocial() {
		return redesocial;
	}

	public void setRedesocial(String redesocial) {
		this.redesocial = redesocial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getContratoId() {
		return contratoId;
	}

	public void setContratoId(int contratoId) {
		this.contratoId = contratoId;
	}

	public int getSetorpaiId() {
		return setorpaiId;
	}

	public void setSetorpaiId(int setorpaiId) {
		this.setorpaiId = setorpaiId;
	}

	public int getSetorlotacaoId() {
		return setorlotacaoId;
	}

	public void setSetorlotacaoId(int setorlotacaoId) {
		this.setorlotacaoId = setorlotacaoId;
	}

	public int getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(int perfilId) {
		this.perfilId = perfilId;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getCertificado() {
		return certificado;
	}

	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

	public LocalDate getDataadmissao() {
		return dataadmissao;
	}

	public void setDataadmissao(LocalDate dataadmissao) {
		this.dataadmissao = dataadmissao;
	}

	public LocalDate getDatadesligamento() {
		return datadesligamento;
	}

	public void setDatadesligamento(LocalDate datadesligamento) {
		this.datadesligamento = datadesligamento;
	}

	public LocalDate getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(LocalDate datacadastro) {
		this.datacadastro = datacadastro;
	}

	public LocalDate getDataexpiracao() {
		return dataexpiracao;
	}

	public void setDataexpiracao(LocalDate dataexpiracao) {
		this.dataexpiracao = dataexpiracao;
	}

	public LocalDate getUltimoacesso() {
		return ultimoacesso;
	}

	public void setUltimoacesso(LocalDate ultimoacesso) {
		this.ultimoacesso = ultimoacesso;
	}

	public LocalDate getDatacriacao() {
		return datacriacao;
	}

	public void setDatacriacao(LocalDate datacriacao) {
		this.datacriacao = datacriacao;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPlaced() {
		return placed;
	}

	public void setPlaced(int placed) {
		this.placed = placed;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
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
		Servidor other = (Servidor) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Servidor [id=" + id + ", nome=" + nome + ", nomereduzido=" + nomereduzido + ", cpf=" + cpf + ", rg="
				+ rg + ", rgorgao=" + rgorgao + ", cargofuncao=" + cargofuncao + ", endereco=" + endereco + ", numero="
				+ numero + ", bairro=" + bairro + ", complemento=" + complemento + ", cidade=" + cidade + ", cep=" + cep
				+ ", telefone1=" + telefone1 + ", telefone2=" + telefone2 + ", redesocial=" + redesocial + ", email="
				+ email + ", dataadmissao=" + dataadmissao + ", datadesligamento=" + datadesligamento + ", contratoId="
				+ contratoId + ", setorpaiId=" + setorpaiId + ", setorlotacaoId=" + setorlotacaoId + ", datacadastro="
				+ datacadastro + ", perfilId=" + perfilId + ", hash=" + hash + ", certificado=" + certificado
				+ ", dataexpiracao=" + dataexpiracao + ", ultimoacesso=" + ultimoacesso + ", datacriacao=" + datacriacao
				+ ", image=" + image + ", placed=" + placed + ", ativo=" + ativo + ", obs=" + obs + ", seq=" + seq
				+ ", flag=" + flag + "]";
	}

}
