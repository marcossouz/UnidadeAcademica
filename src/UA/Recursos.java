package UA;


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
		
}