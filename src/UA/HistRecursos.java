/*
 * @author Marcos Souza
 */
package UA;

public class HistRecursos {
	private int id_user;
	private String cod_rec;
	private int atividade;

	public HistRecursos(int id_user, String cod_rec, int atividade) {
		super();
		this.id_user = id_user;
		this.cod_rec = cod_rec;
		this.atividade = atividade;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getCod_rec() {
		return cod_rec;
	}

	public void setCod_rec(String cod_rec) {
		this.cod_rec = cod_rec;
	}

	public int getAtividade() {
		return atividade;
	}

	public void setAtividade(int atividade) {
		this.atividade = atividade;
	}

}
