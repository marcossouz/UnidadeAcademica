package UA;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;


public class Processos {

	private static Scanner input = new Scanner(System.in);
	//recursos disponiveis
	private static Recursos lab01 = new Recursos("LAB01", "Laboratorio 01", 0, 0, 106, "");
	private static Recursos lab02 = new Recursos("LAB02", "Laboratorio 02", 0, 0, 107, "");
	private static Recursos aud01 = new Recursos("AUD01", "Auditorio 01", 0, 0, 108, "");
	private static Recursos aud02 = new Recursos("AUD02", "Auditorio 02", 0, 0, 109, "");
	private static Recursos sala01 = new Recursos("SALA01", "Sala de Aula 01", 0, 0, 110, "");
	private static Recursos sala02 = new Recursos("SALA02", "Sala de Aula 02", 0, 0, 111, "");
	private static Recursos sala03 = new Recursos("SALA03", "Sala de Aula 03", 0, 0, 112, "");
	private static Recursos sala04 = new Recursos("SALA04", "Sala de Aula 04", 0, 0, 113, "");
	private static Recursos sala05 = new Recursos("SALA05", "Sala de Aula 05", 0, 0, 114, "");
	private static Recursos sala06 = new Recursos("SALA06", "Sala de Aula 06", 0, 0, 115, "");
	private static Recursos sala07 = new Recursos("SALA07", "Sala de Aula 07", 0, 0, 116, "");
	private static Recursos sala08 = new Recursos("SALA08", "Sala de Aula 08", 0, 0, 117, "");
	private static Recursos proj01 = new Recursos("PROJ01", "Projetor 01", 0, 0, 101, "");
	private static Recursos proj02 = new Recursos("PROJ02", "Projetor 02", 0, 0, 102, "");
	private static Recursos proj03 = new Recursos("PROJ03", "Projetor 03", 0, 0, 103, "");
	private static Recursos proj04 = new Recursos("PROJ04", "Projetor 04", 0, 0, 104, "");
	private static Recursos proj05 = new Recursos("PROJ05", "Projetor 05", 0, 0, 105, "");

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
			return "** Em processo de alocacao **";
		case 1:
			return "** Alocado **";
		case 2:
			return "** Em andamento **";
		case 3:
			return "** Concluido **";
		}
		return situacao;
	}

	public static String responsavel(int id, List users){

		for (int i = 0; i < users.size(); i++) {
			Usuario us = (Usuario) users.get(i);
			if(id == us.getId()){

				return (" Resp: " + us.getId() + " " + us.getNome() + " " + us.getSobrenome());
			}
		}

		return "";
	}

	public static boolean vericacaoDeDisponibilidade(String  cod_recurso, List l_recursos) {
		boolean autorizacao = false;
		int verificador = 0;

		for (int i = 0; i < l_recursos.size(); i++) {
			Recursos lr = (Recursos) l_recursos.get(i);				  

			if(cod_recurso.equals(lr.getId()) ){

				if(lr.getStatus() == 0){
					autorizacao = true;
					verificador = 2;
					break;
				} else {
					verificador = 1;
				}
			} 
		}

		if(verificador == 0) System.out.println("cod de recurso invalido");
		if(verificador == 1) System.out.println("Recurso nao disponivel");
		return autorizacao;
	}

	public static void cadastrarAtividade(int atividade, String titulo, String descricao, String participantes,
			String materialApoio, String dataHoraInicio, String dataHoraFim) {


		Atividade ativ = new Atividade(atividade, titulo, descricao, participantes, materialApoio, dataHoraInicio, dataHoraFim);
		List at = new ArrayList();
		at.add(ativ);

	}

	public static boolean autorizacaoAdm(List users, String titulo, String descricao, String participantes, String materialApoio,
			String dataHoraInicio, String dataHoraFim) {
		boolean bool = false;
		String login , senha;

		if(validarDatas(dataHoraInicio, dataHoraFim) && !(titulo == null || titulo.equals("") || descricao == null || descricao.equals("")
				|| participantes == null || participantes.equals("") || materialApoio == null || materialApoio.equals(""))){

			System.out.println("Verificando consistencia de dados...");
			System.out.println("Digite o usuario e a senha do administrador para confirmar alocacao de Recurso");
			System.out.print("user: ");
			login = input.next();
			System.out.print("senha: ");
			senha = input.next();

			for (int i = 0; i < users.size(); i++) {
				Usuario us = (Usuario) users.get(i);
				
				if(login.equals(us.getLogin()) && senha.equals(us.getSenha()) && us.getTipo() == 1){
					
					System.out.println("Autorizado, status modificado para \"Alocado\"");
					bool = true;
					break;
				}
			}
		} else {
			System.out.println("Voce deve preencher todos campos solicitados corretamente...\nalocacao cancelada...");
		}
		
		if(!bool) System.out.println("Alocacao de recurso nao autorizada...");
		return bool;
	}

	private static boolean validarDatas(String dataHoraInicio, String dataHoraFim) {
		
		boolean bool = false;
		
		Calendar dataAtual = new GregorianCalendar();
		Calendar dhi = Calendar.getInstance();
		Calendar dhf = Calendar.getInstance();
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		dhi.setLenient(false);
		dhf.setLenient(false);

		try {
			
			dhi.setTime(formatoData.parse(dataHoraInicio));
			dhf.setTime(formatoData.parse(dataHoraFim));
			bool = true;
		} catch (ParseException ex) {
			bool = false;
		}
		if(bool){
			
			//verificar se a data de inicio acontece dps da data atual
			//verificar se a data final eh depois da data inicial
			if(!(dhi.after(dataAtual) && dhf.after(dhi))){
				bool = false;
			}
		}
		
		if(!bool) System.out.println("Digite datas de inicio e fim invalidas...");
		return bool;
	}
}

