package padm.io.pad_m.domain.enums;

public enum Perfil {
	ADMIN(1, "ROLE_ADMIN"),
	GESTOR(2, "ROLE_GESTOR"),
	SERVIDOR(3, "ROLE_SERVIDOR"),
	EXTERNO(4, "ROLE_EXTERNO"),
	TERCEIRO(5, "ROLE_TERCEIRO");

	private int cod;
	private String descricao;

	private Perfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Perfil toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Perfil x : Perfil.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id Inválido: " + cod);
	}

}
