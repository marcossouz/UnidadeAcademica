package UA;

public class Atividade {
	private int tipo;
	private String titulo, descricao, participantes, materialApoio;
	
	public Atividade(int tipo, String titulo, String descricao, String participantes, String materialApoio) {
		
		this.tipo = tipo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.participantes = participantes;
		this.materialApoio = materialApoio;
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
	
	//metodo pra adicionar historico de atividade de acordo com o tipo
}
