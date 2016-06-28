package UA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
	private int tipo;
	private int id;
	private String nome;
	private String sobrenome;
	private String login;
	private String senha;
	private String email;
	private static Scanner input;

	public Usuario(int tipo, int id, String nome, String sobrenome, String login, String senha, String email) {
		this.tipo = tipo;
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.login = login;
		this.senha = senha;
		this.email = email;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static boolean autenticar(List<Usuario> users) {
		input = new Scanner(System.in);
		String user;
		String senha;
		boolean autorizado = false;

		System.out.print("Login: ");
		user = input.next();
		System.out.print("Senha: ");
		senha = input.next();

		for (int i = 0; i < users.size(); i++) {
			Usuario us = users.get(i);

			if (user.equals(us.login) && senha.equals(us.senha)) {
				autorizado = true;
				break;
			}
		}

		return autorizado;

	}

	public static List<Usuario> preconfig(CodigoAutomatico cod) {
		List<Usuario> users = new ArrayList<Usuario>();

		// adm
		Usuario adm = new Usuario(1, cod.codAuto(), "Administrador", "", "admin", "admin", "adm@ua.com");
		users.add(adm);

		Usuario marcos = new Usuario(1, cod.codAuto(), "Marcos", "Souza", "marcos", "admin", "ms@ua.com");
		users.add(marcos);

		Usuario elizania = new Usuario(1, cod.codAuto(), "Elizania", "Goncalves", "elizania", "admin", "eg@ua.com");
		users.add(elizania);

		Usuario moreira = new Usuario(1, cod.codAuto(), "Moreira", "Lima", "moreira", "admin", "ml@ua.com");
		users.add(moreira);

		Usuario esequiel = new Usuario(1, cod.codAuto(), "Esequiel", "Fernandes", "esequiel", "admin", "ef@ua.com");
		users.add(esequiel);

		Usuario joyce = new Usuario(1, cod.codAuto(), "Joyce", "Karine", "joyce", "admin", "jk@ua.com");
		users.add(joyce);

		// Pesquisadores
		Usuario ronaldo = new Usuario(2, cod.codAuto(), "Ronaldo", "Santos", "ronaldo", "pesq", "rs@ua.com");
		users.add(ronaldo);

		Usuario josue = new Usuario(2, cod.codAuto(), "Josue", "Mendonca", "josue", "pesq", "jm@ua.com");
		users.add(josue);

		Usuario jessica = new Usuario(2, cod.codAuto(), "Jessica", "Keislane", "jessica", "pesq", "jkes@ua.com");
		users.add(jessica);

		Usuario gustavo = new Usuario(2, cod.codAuto(), "Gustavo", "Lourenco", "gustavo", "pesq", "lg@ua.com");
		users.add(gustavo);

		// professores
		Usuario flavio = new Usuario(3, cod.codAuto(), "Flavio", "Oliveira", "flavio", "prof", "fo@ua.com");
		users.add(flavio);

		Usuario mateus = new Usuario(3, cod.codAuto(), "Mateus", "Lima", "mateus", "prof", "ml@ua.com");
		users.add(mateus);

		Usuario cicero = new Usuario(3, cod.codAuto(), "Cicero", "Jose", "cicero", "prof", "cj@ua.com");
		users.add(cicero);

		Usuario maria = new Usuario(3, cod.codAuto(), "Maria", "Moreira", "maria", "prof", "mm@ua.com");
		users.add(maria);

		Usuario raquel = new Usuario(3, cod.codAuto(), "Raquel", "Lima", "raquel", "prof", "rli@ua.com");
		users.add(raquel);

		Usuario josefa = new Usuario(3, cod.codAuto(), "Josefa", "Lima", "josefa", "prof", "jl@ua.com");
		users.add(josefa);

		Usuario eliude = new Usuario(3, cod.codAuto(), "Eliude", "Goncalves", "eliude", "prof", "ego@ua.com");
		users.add(eliude);

		Usuario rafael = new Usuario(3, cod.codAuto(), "Rafael", "Rocha", "rafael", "prof", "rr@ua.com");
		users.add(rafael);

		return users;
	}

	public static List<Usuario> adicionar(List<Usuario> users, CodigoAutomatico cod) {

		int tipo = 0;
		System.out.println("TIPOS:\n*      1 - Adm\n*      2 - Pesquisador\n*     "
				+ " 3 - Professor\n*      4 - Aluno Doutorado\n*      "
				+ "5 - Aluno Mestrado\n*      6 - Aluno Graduacao \n********* Digite 7 para voltar");
		input = new Scanner(System.in);

		System.out.print("tipo: ");

		try {

			tipo = input.nextInt();

		} catch (Exception e) {
			System.out.println("Digite um numero inteiro..");
			input.nextLine();
			
		}
			while(tipo < 1 || tipo > 7){
				System.out.println("Digite um numero entre 1 e 7...\n-->");
				try {

					tipo = input.nextInt();

				} catch (Exception e) {
					System.out.println("Digite um numero inteiro..");
					input.nextLine();
					
				}
			}
		
		

		if (tipo == 7) {
			System.out.println("Voltando ao menu, cadastro cancelado..");
			return users;
		}

		Usuario user = new Usuario(0, 0, "", "", "", "", "");
		user.tipo = tipo;
		System.out.print("****** CADASTRO ******\n");
		user.id = cod.codAuto();
		System.out.println("id: " + user.id);
		System.out.print("nome: ");
		user.nome = input.next();
		System.out.print("sobrenome: ");
		user.sobrenome = input.next();
		System.out.print("login: ");
		user.login = input.next();
		System.out.print("senha: ");
		user.senha = input.next();
		System.out.print("email: ");
		user.email = input.next();

		users.add(user);
		System.out.println("*** Cadastro Realizado com sucesso. ***");
		return users;
	}

	public static String tipoDeUsuario(int tipo) {

		switch (tipo) {
		case 1:
			return "Adm ";
		case 2:
			return "Pesq";
		case 3:
			return "Prof";
		case 4:
			return "Alun Dout";
		case 5:
			return "Alun Mest";
		case 6:
			return "Alun Grad";
		default:
			return "";
		}
	}

	public static void menu() {
		System.out.println("\n-------------------------------------------\n");
		System.out.println("1 - Cadastrar novo usuario");
		System.out.println("2 - Consulta por usuario"); // sem codificacao ainda
		System.out.println("3 - Solicitar recurso");
		System.out.println("4 - Listar usuarios");
		System.out.println("5 - Listar recursos");
		System.out.println("6 - Autorizacao do responsavel pelo recurso");
		System.out.println("7 - Confirmar conclusao do uso do recurso");
		System.out
				.println("8 - disponibilizar recursos para alocacao (\"concluido\" para \"Em processo de alocacao\")");
		System.out.println("9 - Consulta por recurso");
		System.out.println("10 - Relatorio de atividades na unidade");
		System.out.println("0 - Sair");
		System.out.println("\n-------------------------------------------\n");
		System.out.print("--> ");

	}

	public static void escolha(List<Usuario> users, List<Recursos> l_recursos, List<Atividade> l_atividades,
			List<HistRecursos> historicoRecurso, CodigoAutomatico cod) {
		input = new Scanner(System.in);
		int esc = -1;

		try {
			esc = input.nextInt();
		} catch (Exception e) {
			System.out.println("Voce deve digitar um inteiro..");
			input.nextLine();
		}

		while (esc < 0 || esc > 10) {

			System.out.print("Digite um numero entre 0 e 10\n-->");

			try {
				esc = input.nextInt();
			} catch (Exception e) {
				System.out.println("Voce deve digitar um inteiro..");
				input.nextLine();
			}
		}

		while (esc >= 0 && esc <= 10) {

			switch (esc) {
			case 1:
				System.out.println("** Cadastro de usuarios **");
				users = Usuario.adicionar(users, cod);

				break;

			case 2:
				System.out.println("\n** Consulta por usuario **\n");
				Processos.consultarUser(users, historicoRecurso);

				break;

			case 3:
				System.out.println("\n** Solicitacao de recurso **\n");
				Processos.solicitarRecurso(l_recursos, users, historicoRecurso, l_atividades, cod);

				break;

			case 4:

				System.out.println("\n** Usuarios Cadastrados **\n");
				listarUsuarios(users);
				break;

			case 5:
				System.out.println("\n** Recursos **\n");
				Recursos.listarRecursos(l_recursos, users);

			case 6:
				System.out.println("** Autorizacao do responsal pelo recurso **");

				Processos.autorizacaoResp(l_recursos, users);
				break;

			case 7:
				System.out.println("** confirmacao de conclusao (apenas adm) **");
				l_recursos = Processos.confirmarConclusao(l_recursos, l_atividades, users);
				break;

			case 8:
				System.out.println("** Disponibilizar recursos para usuarios (adm) **");
				l_recursos = Processos.disponibizarRecursos(l_recursos, users);
				break;
			case 9:
				System.out.println("** Consulta por recurso **");
				Processos.consultarRecurso(l_recursos, l_atividades, users);
				break;
			case 10:
				System.out.println("** Relatorio de atividades na unidade **\n");
				Processos.relatorioDeAtividades(users, l_recursos, l_atividades, cod);
				break;

			case 0:
				System.out.println("\nSaindo...\n");
				System.exit(0);
			}

			menu();
			try {
				esc = input.nextInt();
			} catch (Exception e) {
				System.out.println("Voce deve digitar um inteiro..");
				input.nextLine();
			}

			while (esc < 0 || esc > 10) {

				System.out.print("Digite um numero entre 0 e 10\n-->");

				try {
					esc = input.nextInt();
				} catch (Exception e) {
					System.out.println("Voce deve digitar um inteiro..");
					input.nextLine();
				}
			}
		} // end switch
	}

	private static void listarUsuarios(List<Usuario> users) {
		for (int i = 0; i < users.size(); i++) {
			Usuario us = users.get(i);
			System.out.print(us.id + " ");
			System.out.print(tipoDeUsuario(us.tipo) + " ");
			System.out.println(us.getNome() + " " + us.getSobrenome());
		}
	}

	public static String userName(int usuario_alocador, List<Usuario> users) {
		String name = null;
		for (int i = 0; i < users.size(); i++) {
			Usuario us = users.get(i);

			if (usuario_alocador == us.getId()) {
				return (us.getNome() + " " + us.getSobrenome());
			}
		}

		return name;
	}

	public static boolean permissaoParaAlocacao(List<Usuario> users, int id_user) {
		boolean bool = false;
		for (int i = 0; i < users.size(); i++) {
			Usuario us = users.get(i);
			if (id_user == us.getId() && us.getTipo() == 3) {
				bool = true;
				break;
			}
		}

		return bool;
	}

	public static boolean verificacaoDeUsuarioValido(int id_user, List<Usuario> users) {
		boolean bool = false;
		for (int i = 0; i < users.size(); i++) {
			Usuario us = users.get(i);
			if (id_user == us.id) {
				System.out.println("\n" + us.getId() + " " + tipoDeUsuario(us.getTipo()) + " " + us.getNome() + " "
						+ us.getSobrenome());
				bool = true;
			}
		}
		if(!bool)System.out.println("id invalido..");
		return bool;
	}

	public static void listar(List<Usuario> users) {

		for (int i = 0; i < users.size(); i++) {
			Usuario us = users.get(i);
			System.out.println(us.getId() + " " + us.getNome() + " " + us.getSobrenome());
		}
	}

	public static String NomeUser(int user, List<Usuario> users) {

		for (int i = 0; i < users.size(); i++) {
			Usuario us = users.get(i);
			if (user == us.getId()) {
				return (Usuario.tipoDeUsuario(us.getTipo()) + " " + us.getNome() + " " + us.getSobrenome());
			}
		}
		return null;
	}
}