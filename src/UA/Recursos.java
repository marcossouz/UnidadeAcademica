package UA;

import java.util.List;

public class Recursos {
	private String id;
	private String nome_recurso;
	private int status;
	private int usuario_alocador;
	private int responsavel;
	private String atividade_realizada;

	public Recursos(String id, String nome_recurso, int status, int usuario_alocador, int responsavel,
			String atividade_realizada) {
		this.id = id;
		this.nome_recurso = nome_recurso;
		this.status = status;
		this.usuario_alocador = usuario_alocador;
		this.responsavel = responsavel;
		this.atividade_realizada = atividade_realizada;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome_recurso() {
		return nome_recurso;
	}

	public void setNome_recurso(String nome_recurso) {
		this.nome_recurso = nome_recurso;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUsuario_alocador() {
		return usuario_alocador;
	}

	public void setUsuario_alocador(int usuario_alocador) {
		this.usuario_alocador = usuario_alocador;
	}

	public int getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(int responsavel) {
		this.responsavel = responsavel;
	}

	public String getAtividade_realizada() {
		return atividade_realizada;
	}

	public void setAtividade_realizada(String atividade_realizada) {
		this.atividade_realizada = atividade_realizada;
	}

	public static void listarRecursos(List<Recursos> l_recursos, List<Usuario> users) {
		for (int i = 0; i < l_recursos.size(); i++) {
			Recursos lr = l_recursos.get(i);
			System.out.print(lr.getId() + " ");
			System.out.print(lr.getNome_recurso() + " " + Processos.status(lr.getStatus()));
			System.out.println(Processos.responsavel(lr.getResponsavel(), users));
			if (!(0 == lr.getStatus()))
				System.out.println("usuario alocador: " + lr.getUsuario_alocador() + " "
						+ Usuario.userName(lr.getUsuario_alocador(), users));
		}

	}

	public static int emAlocacao(List<Recursos> l_recursos) {

		int cont = 0;
		for (int i = 0; i < l_recursos.size(); i++) {
			Recursos lr = l_recursos.get(i);
			if (lr.getStatus() == 0)
				cont++;
		}
		return cont;

	}

	public static int alocado(List<Recursos> l_recursos) {

		int cont = 0;
		for (int i = 0; i < l_recursos.size(); i++) {
			Recursos lr = l_recursos.get(i);
			if (lr.getStatus() == 1)
				cont++;
		}

		return cont;
	}

	public static int emAndamento(List<Recursos> l_recursos) {

		int cont = 0;
		for (int i = 0; i < l_recursos.size(); i++) {
			Recursos lr = l_recursos.get(i);
			if (lr.getStatus() == 2)
				cont++;
		}

		return cont;
	}

	public static int Concluido(List<Recursos> l_recursos) {
		int cont = 0;
		for (int i = 0; i < l_recursos.size(); i++) {
			Recursos lr = l_recursos.get(i);
			if (lr.getStatus() == 2)
				cont++;
		}

		return cont;
	}
}