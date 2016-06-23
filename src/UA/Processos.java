package UA;

import java.util.ArrayList;
import java.util.List;


public class Processos {
	//recursos disponiveis
	private static Recursos lab01 = new Recursos("LAB01 ", "Laboratorio 01 ", 0, 0, 106, "", null, null, null, null );
	private static Recursos lab02 = new Recursos("LAB02 ", "Laboratorio 02 ", 0, 0, 107, "", null, null, null, null );
	private static Recursos aud01 = new Recursos("AUD01 ", "Auditorio 01   ", 0, 0, 108, "", null, null, null, null );
	private static Recursos aud02 = new Recursos("AUD02 ", "Auditorio 02   ", 0, 0, 109, "", null, null, null, null );
	private static Recursos sala01 = new Recursos("SALA01", "Sala de Aula 01", 0, 0, 110, "", null, null, null, null );
	private static Recursos sala02 = new Recursos("SALA02", "Sala de Aula 02", 0, 0, 111, "", null, null, null, null );
	private static Recursos sala03 = new Recursos("SALA03", "Sala de Aula 03", 0, 0, 112, "", null, null, null, null );
	private static Recursos sala04 = new Recursos("SALA04", "Sala de Aula 04", 0, 0, 113, "", null, null, null, null );
	private static Recursos sala05 = new Recursos("SALA05", "Sala de Aula 05", 0, 0, 114, "", null, null, null, null );
	private static Recursos sala06 = new Recursos("SALA06", "Sala de Aula 06", 0, 0, 115, "", null, null, null, null );
	private static Recursos sala07 = new Recursos("SALA07", "Sala de Aula 07", 0, 0, 116, "", null, null, null, null );
	private static Recursos sala08 = new Recursos("SALA08", "Sala de Aula 08", 0, 0, 117, "", null, null, null, null );
	private static Recursos proj01 = new Recursos("PROJ01", "Projetor 01    ", 0, 0, 101, "", null, null, null, null );
	private static Recursos proj02 = new Recursos("PROJ02", "Projetor 02    ", 0, 0, 101, "", null, null, null, null );
	private static Recursos proj03 = new Recursos("PROJ03", "Projetor 03    ", 0, 0, 101, "", null, null, null, null );
	private static Recursos proj04 = new Recursos("PROJ04", "Projetor 04    ", 0, 0, 101, "", null, null, null, null );
	private static Recursos proj05 = new Recursos("PROJ05", "Projetor 05    ", 0, 0, 101, "", null, null, null, null );
	
	public static List carregarRecursos(){
		List l_recursos = new ArrayList();
		l_recursos.add(lab01);
		l_recursos.add(lab02);
		l_recursos.add(aud01);
		l_recursos.add(aud02);
		l_recursos.add(sala01);
		l_recursos.add(sala02);
		l_recursos.add(sala03);
		l_recursos.add(sala04);
		l_recursos.add(sala05);
		l_recursos.add(sala06);
		l_recursos.add(sala07);
		l_recursos.add(sala08);
		l_recursos.add(proj01);
		l_recursos.add(proj02);
		l_recursos.add(proj03);
		l_recursos.add(proj04);
		l_recursos.add(proj05);
		
		return l_recursos;
	}
	
	public static String status(int status){
		String situacao = null;
		
		switch (status){
		case 0:
			return "Em processo de alocação";
		case 1:
			return "Alocado";
		case 2:
			return "Em andamento";
		case 3:
			return "Concluído";
		}
		
		return situacao;
	}
	
}
