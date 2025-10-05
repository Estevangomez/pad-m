package padm.io.pad_m.domain.dto;

import java.util.ArrayList;
import java.util.List;

import padm.io.pad_m.domain.Usuario;
import padm.io.pad_m.domain.enums.Perfil;

public class UsuarioDTO {

	private Integer id;

	private String nome;

	private String matricula;

	private Integer idUnidade;

	private String siglaUnd;

	private int perfil;

	private List<Perfil> perfis = new ArrayList<Perfil>();

	public UsuarioDTO() {
	}

	public UsuarioDTO(Integer id, String nome, String matricula, Integer idUnidade, String siglaUnd, int perfil) {
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.idUnidade = idUnidade;
		this.siglaUnd = siglaUnd;
		this.perfil = perfil;
	}

	public UsuarioDTO(Integer id, String nome, String matricula, Integer idUnidade, String siglaUnd) {
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.idUnidade = idUnidade;
		this.siglaUnd = siglaUnd;
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Integer getIdUnidade() {
		return idUnidade;
	}

	public void setIdUnidade(Integer idUnidade) {
		this.idUnidade = idUnidade;
	}

	public String getSiglaUnd() {
		return siglaUnd;
	}

	public void setSiglaUnd(String siglaUnd) {
		this.siglaUnd = siglaUnd;
	}

	public int getPerfil() {
		return perfil;
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public Usuario toUsuario() {
		Usuario usuario = new Usuario();
		usuario.setId(this.id);
		usuario.setNome(this.nome);

		return usuario;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", nome=" + nome + ", matricula=" + matricula + ", idUnidade=" + idUnidade
				+ ", siglaUnd=" + siglaUnd + ", perfil=" + perfil + ", perfis=" + perfis + "]";
	}

}