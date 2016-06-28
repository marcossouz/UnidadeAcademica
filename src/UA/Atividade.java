package UA;

public class Atividade {

	private int tipo, user;
	private String titulo, descricao, participantes, materialApoio;
	private String dataHoraInicio, dataHoraFim;
	private String recurso;

	public Atividade(int tipo, int user, String titulo, String descricao, String participantes, String materialApoio,
			String dataHoraInicio, String dataHoraFim, String recurso) {
		this.tipo = tipo;
		this.user = user;
		this.titulo = titulo;
		this.descricao = descricao;
		this.participantes = participantes;
		this.materialApoio = materialApoio;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFim = dataHoraFim;
		this.recurso = recurso;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getParticipantes() {
		return participantes;
	}

	public void setParticipantes(String participantes) {
		this.participantes = participantes;
	}

	public String getMaterialApoio() {
		return materialApoio;
	}

	public void setMaterialApoio(String materialApoio) {
		this.materialApoio = materialApoio;
	}

	public String getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(String dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public String getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(String dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public static String nomeAtividade(int atividade) {

		if (atividade == 1) {
			return "Aula tradicional";
		} else if (atividade == 2) {
			return "Apresentacoes";
		} else if (atividade == 3)
			return "Laboratorio";

		return null;
	}

	public String getRecurso() {
		return recurso;
	}

}
