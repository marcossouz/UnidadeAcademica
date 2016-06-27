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
	// recursos disponiveis
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

	public static List carregarRecursos() {
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

	public static String status(int status) {
		String situacao = null;

		switch (status) {
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

	public static String responsavel(int id, List users) {

		for (int i = 0; i < users.size(); i++) {
			Usuario us = (Usuario) users.get(i);
			if (id == us.getId()) {

				return (" Resp: " + us.getId() + " " + us.getNome() + " " + us.getSobrenome());
			}
		}

		return "";
	}

	public static boolean vericacaoDeDisponibilidade(String cod_recurso, List l_recursos) {
		boolean autorizacao = false;
		int verificador = 0;

		for (int i = 0; i < l_recursos.size(); i++) {
			Recursos lr = (Recursos) l_recursos.get(i);

			if (cod_recurso.equals(lr.getId())) {

				if (lr.getStatus() == 0) {
					autorizacao = true;
					verificador = 2;
					break;
				} else {
					verificador = 1;
				}
			}
		}

		if (verificador == 0)
			System.out.println("cod de recurso invalido");
		if (verificador == 1)
			System.out.println("Recurso nao disponivel");
		return autorizacao;
	}

	public static List cadastrarAtividade(List l_atividades, int atividade, int id_user, String titulo, String descricao,
			String participantes, String materialApoio, String dataHoraInicio, String dataHoraFim, String recurso) {

		Atividade ativ = new Atividade(atividade, id_user, titulo, descricao, participantes, materialApoio, dataHoraInicio,
				dataHoraFim, recurso);
		l_atividades.add(ativ);

		return l_atividades;
	}

	public static boolean autorizacaoAdm(List users, String titulo, String descricao, String participantes,
			String materialApoio, String dataHoraInicio, String dataHoraFim) {
		boolean bool = false;
		String login, senha;

		if (validarDatas(dataHoraInicio, dataHoraFim) && !(titulo == null || titulo.equals("") || descricao == null
				|| descricao.equals("") || participantes == null || participantes.equals("") || materialApoio == null
				|| materialApoio.equals(""))) {

			System.out.println("Verificando consistencia de dados...");
			System.out.println("Digite o usuario e a senha do administrador para confirmar alocacao de Recurso");
			System.out.print("user: ");
			login = input.next();
			System.out.print("senha: ");
			senha = input.next();

			for (int i = 0; i < users.size(); i++) {
				Usuario us = (Usuario) users.get(i);

				if (login.equals(us.getLogin()) && senha.equals(us.getSenha()) && us.getTipo() == 1) {

					System.out.println("Autorizado, status modificado para \"Alocado\"");
					bool = true;
					break;
				}
			}
		} else {
			System.out.println("Voce deve preencher todos campos solicitados corretamente...\nalocacao cancelada...");
		}

		if (!bool)
			System.out.println("Alocacao de recurso nao autorizada...");
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
		if (bool) {

			// verificar se a data de inicio acontece dps da data atual
			// verificar se a data final eh depois da data inicial
			if (!(dhi.after(dataAtual) && dhf.after(dhi))) {
				bool = false;
			}
		}

		if (!bool)
			System.out.println("Datas de inicio/fim invalidas...");
		return bool;
	}

	public static void listarAtividades(List l_atividades, String cod_rec) {
		for (int i = 0; i < l_atividades.size(); i++) {
			Atividade lat = (Atividade) l_atividades.get(i);

			if(cod_rec.equals(lat.getRecurso())){
				System.out.println(lat.getRecurso() + " " + lat.getUser()+ " " + lat.getTitulo());
			}
		}

	}

	public static void autorizacaoResp(List l_recursos, List users) {

		String login, senha, id_rec;
		int id_user = 0;
		boolean autentic = false;

		System.out.println("--- Recursos que aguardam autorizacao do responsavel ---");
		for (int i = 0; i < l_recursos.size(); i++) {
			Recursos lr = (Recursos) l_recursos.get(i);

			if (1 == lr.getStatus()) {
				System.out.print("--> " + lr.getId() + " ");
				System.out.println(Processos.responsavel(lr.getResponsavel(), users));
			}
		}

		System.out.print("\nid do recurso que vc deseja autorizar: ");

		id_rec = input.next();

		// verificando se o user esta em algum outro processo "Em andamento"
		// 1 coletando o usuario alocador
		for (int i = 0; i < l_recursos.size(); i++) {
			Recursos lr = (Recursos) l_recursos.get(i);

			if (id_rec.equals(lr.getId())) {
				id_user = lr.getUsuario_alocador();

			}
		}

		// agora verificando se ele tem algum processo "Em andamento"
		for (int i = 0; i < l_recursos.size(); i++) {
			Recursos lr = (Recursos) l_recursos.get(i);

			if (id_user == lr.getUsuario_alocador() && lr.getStatus() == 2) {
				System.out
				.println("o usuario " + lr.getUsuario_alocador() + " ja possui um outro recurso em andamento");
				System.out.println("autorizacao nao permitida...");
				return;
			}
		}

		System.out.println("--- Entre com login e senha do responsavel ---\n");

		autentic = Usuario.autenticar(users);

		for (int i = 0; i < l_recursos.size(); i++) {
			Recursos lr = (Recursos) l_recursos.get(i);

			if (1 == lr.getStatus() && id_rec.equals(lr.getId()) && autentic) {
				lr.setStatus(2);
				System.out.println("efetuado, status modificado para \"Em andamento\" ");
				return;
			}

		}

		System.out.println("Dados nao conferem, autorizacao nao efetuada\n");
	}

	public static List confirmarConclusao(List l_recursos, List l_atividades, List users) {
		String login, senha, id_rec;
		boolean bool = false;

		System.out.println("--- Recursos que aguardam confirmacao de conclusao ---");
		for (int i = 0; i < l_recursos.size(); i++) {
			Recursos lr = (Recursos) l_recursos.get(i);

			if (2 == lr.getStatus()) {
				System.out.print("--> " + lr.getId() + " ");
				System.out.println(Processos.responsavel(lr.getResponsavel(), users));
			}
		}

		System.out.print("\nid do recurso que vc deseja confirmar a conclusao: ");

		id_rec = input.next();

		for (int i = 0; i < l_recursos.size(); i++) {
			Recursos lr = (Recursos) l_recursos.get(i);

			if (2 == lr.getStatus() && id_rec.equals(lr.getId())) {

				for (int j = 0; j < l_atividades.size(); j++) {
					Atividade lat = (Atividade) l_atividades.get(j);

					if (lat.getDescricao() != null && !("".equals(lat.getDescricao()))) {
						System.out.println("Digite o usuario e a senha do administrador para confirmar a conclusao");
						System.out.print("usuario: ");
						login = input.next();
						System.out.print("senha: ");
						senha = input.next();

						for (int k = 0; k < users.size(); k++) {
							Usuario us = (Usuario) users.get(k);

							if (login.equals(us.getLogin()) && senha.equals(us.getSenha()) && us.getTipo() == 1) {

								System.out.println("Autorizado, status modificado para \"Concluido\"");
								lr.setStatus(3);
								return l_recursos;
							}
						}
						System.out.println("confirmacao nao concluida, usuario nao adm/Login ou senha Errados");
						return l_recursos;
					}
				}
				System.out.println("confirmacao nao concluida, Descricao nao pode ser vazia");
				return l_recursos;
			}
		}
		System.out.println("confirmacao nao concluida, id nao encontrado/Nao existe nenhum recurso a confirmar");
		return l_recursos;
	}

	public static List disponibizarRecursos(List l_recursos, List users) {

		System.out.println("--- Recursos a liberar  ---\n");
		for (int i = 0; i < l_recursos.size(); i++) {
			Recursos lr = (Recursos) l_recursos.get(i);

			if (3 == lr.getStatus()) {
				System.out.print("--> " + lr.getId() + " ");
				System.out.println(Processos.responsavel(lr.getResponsavel(), users));
			}
		}

		System.out.print("\nid do recurso que vc deseja liberar: ");

		String id_rec = input.next();
		boolean bool = false;

		for (int i = 0; i < l_recursos.size(); i++) {
			Recursos lr = (Recursos) l_recursos.get(i);

			if (id_rec.equals(lr.getId()) && lr.getStatus() == 3) {
				if (bool = Processos.isAdm(users)) {
					lr.setStatus(0);
					System.out.println("\n**  Recurso liberado com sucesso **");
					return l_recursos;
				}
			}
		}

		if (!bool)
			System.out.println("Id nao encontrada e/ou recurso com status diferente de\"Concluido\" ");
		return l_recursos;
	}

	private static boolean isAdm(List users) {
		System.out.println("Digite o usuario e a senha do administrador para confirmar a conclusao");
		System.out.print("usuario: ");
		String login = input.next();
		System.out.print("senha: ");
		String senha = input.next();

		for (int i = 0; i < users.size(); i++) {
			Usuario us = (Usuario) users.get(i);

			if (login.equals(us.getLogin()) && senha.equals(us.getSenha()) && us.getTipo() == 1) {
				return true;
			}
		}

		System.out.println("Usuario nao autorizado..");
		return false;
	}

	public static void consultarUser(List users, List histRec) {
		int id;

		System.out.println("id do usuario a ser consultado: ");
		id = input.nextInt();

		for (int i = 0; i < users.size(); i++) {
			Usuario us = (Usuario) users.get(i);

			if (id == us.getId()) {
				System.out.println(us.getId() + " " + us.getNome() + " " + us.getSobrenome() + " " + us.getEmail());
				System.out.println("Recursos alocados...");
				Processos.imprimirRecursosAlocados(us.getId(), histRec);
			}
		}
	}

	private static void imprimirRecursosAlocados(int id, List histRec) {
		for (int i = 0; i < histRec.size(); i++) {
			HistRecursos hr = (HistRecursos) histRec.get(i);

			if (hr.getId_user() == id) {
				System.out.println(hr.getCod_rec() + " " + Atividade.nomeAtividade(hr.getAtividade()));
			}
		}
	}

	public static void consultarRecurso(List l_recursos, List l_atividades) {
		System.out.print("digite o codigo do recurso desejado: ");
		String cod_rec = input.next();
		
		
		for (int i = 0; i < l_recursos.size(); i++) {
			Recursos lr = (Recursos) l_recursos.get(i);
			System.out.println(cod_rec);
			if (cod_rec.equals(lr.getId())) {
				System.out.println(lr.getId() + " " + lr.getNome_recurso() + " atividade Realizada:\n ");
				Processos.listarAtividades(l_atividades, cod_rec);
			}
		}
	}
} // fim da classe


