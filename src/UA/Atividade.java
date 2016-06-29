/*
 * @author Marcos Souza
 */
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

	public int getTipo() {
		return tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getParticipantes() {
		return participantes;
	}

	public String getMaterialApoio() {
		return materialApoio;
	}

	public String getDataHoraInicio() {
		return dataHoraInicio;
	}

	public String getDataHoraFim() {
		return dataHoraFim;
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

	public static void escolhaTipo() {
		System.out.println("TIPOS:\n*      1 - Adm\n*      2 - Pesquisador\n*     "
				+ " 3 - Professor\n*      4 - Aluno Doutorado\n*      "
				+ "5 - Aluno Mestrado\n*      6 - Aluno Graduacao \n********* Digite 7 para voltar");
	}

}
