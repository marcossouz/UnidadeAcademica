/*
 * @author Marcos Souza
 */
package UA;

public class CodigoAutomatico {
	private int codigo = 100;
	private int contadorDeAlocacoes = 0;
	private int aulaTrad = 0;
	private int apresentacoes = 0;
	private int laboratorio = 0;
	
	public int codAuto(){
		return codigo++;	
	}
	
	public void somadorDeAlocacoes(){
		contadorDeAlocacoes++;
	}
	
	public int alocacoes(){
		return contadorDeAlocacoes;
	}
	
	public void somadorAulaTrad(){
		aulaTrad++;
	}
	
	public void somadorApres(){
		apresentacoes++;
	}
	
	public void somadorlab(){
		laboratorio++;
	}
	
	public int aulasTrad(){
		return aulaTrad;
	}
	
	public int apresentacoes(){
		return apresentacoes;
	}
	
	public int laboratorio(){
		return laboratorio;
	}
}

