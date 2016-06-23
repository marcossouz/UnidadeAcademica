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


	public static boolean autenticar(List users){
		Scanner input = new Scanner(System.in);
		String user;
		String senha;
		boolean autorizado = false;

		System.out.print("Login: ");
		user = input.next();
		System.out.print("Senha: ");
		senha = input.next();


		for (int i = 0; i < users.size(); i++) {
			Usuario us = (Usuario) users.get(i);

			if(user.equals(us.login) && senha.equals(us.senha))
			{
				autorizado = true;
				break;
			}
		}

		return autorizado;

	}

	public static List preconfig(){
		Scanner input = new Scanner(System.in);
		List users = new ArrayList();

		//adm
		Usuario adm = new Usuario(1, 100, "Administrador", "", "admin", "admin", "adm@ua.com");
		users.add(adm);

		Usuario marcos = new Usuario(1, 101, "Marcos", "Souza", "marcos", "admin", "ms@ua.com");
		users.add(marcos);

		Usuario elizania = new Usuario(1, 102, "Elizania", "Goncalves", "elizania", "admin", "eg@ua.com");
		users.add(elizania);

		Usuario moreira = new Usuario(1, 103, "Moreira", "Lima", "moreira", "admin", "ml@ua.com");
		users.add(moreira);

		Usuario esequiel = new Usuario(1, 104, "Esequiel", "Fernandes", "esequiel", "admin", "ef@ua.com");
		users.add(esequiel);

		Usuario  joyce = new Usuario( 1, 105, "Joyce", "Karine", "joyce", "admin", "jk@ua.com");
		users.add(joyce);

		//Pesquisadores
		Usuario ronaldo = new Usuario( 2, 106, "Ronaldo", "Santos", "ronaldo", "pesq", "rs@ua.com");
		users.add(ronaldo);

		Usuario  josue = new Usuario( 2, 107, "Josue", "Mendonça", "josue", "pesq", "jm@ua.com");
		users.add(josue);

		Usuario  jessica = new Usuario( 2, 108, "Jessica", "Keislane", "jessica", "pesq", "jkes@ua.com");
		users.add(jessica);

		Usuario  gustavo = new Usuario( 2, 109, "Gustavo", "Lourenço", "gustavo", "pesq", "lg@ua.com");
		users.add(gustavo);

		//professores
		Usuario  flavio = new Usuario( 3, 110, "Flavio", "Oliveira", "flavio", "prof", "fo@ua.com");
		users.add(flavio);

		Usuario  mateus = new Usuario( 3, 111, "Mateus", "Lima", "mateus", "prof", "ml@ua.com");
		users.add(mateus);

		Usuario cicero = new Usuario( 3, 112, "Cicero", "Jose", "cicero", "prof", "cj@ua.com");
		users.add(cicero);

		Usuario maria = new Usuario( 3, 113, "Maria", "Moreira", "maria", "prof", "mm@ua.com");
		users.add(maria);

		Usuario  raquel = new Usuario( 3, 114, "Raquel", "Lima", "raquel", "prof", "rli@ua.com");
		users.add(raquel);

		Usuario  josefa = new Usuario( 3, 115, "Josefa", "Lima", "josefa", "prof", "jl@ua.com");
		users.add(josefa);

		Usuario  eliude = new Usuario( 3, 116, "Eliude", "Gonçalves", "eliude", "prof", "ego@ua.com");
		users.add(eliude);

		Usuario  rafael = new Usuario( 3, 117, "Rafael", "Rocha", "rafael", "prof", "rr@ua.com");
		users.add(rafael);

		return users;
	}

	public static List adicionar(int cod, List users){

		Scanner input = new Scanner(System.in);

		Usuario user = new Usuario(0,0,"","","","","");
		System.out.print("****** CADASTRO ******\n");
		user.id = cod;
		System.out.println("id: " + user.id);
		System.out.print("tipo: ");
		user.tipo = input.nextInt();
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

		return users;
	}

	public static String tipoDeUsuario(int tipo){

		switch (tipo){
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
		}
		return "";
	}

	public static void menu(){
		System.out.println("1 - Cadastrar novo usuario");
		System.out.println("2 - Consulta por usuario");
		System.out.println("3 - Solicitar recurso");
		System.out.println("4 - Listar usuarios");
		System.out.println("5 - Listar recursos");
		System.out.println("7 - Sair");
		System.out.println("   -- escolha -- ");

	}

	public static void escolha(List users, List l_recursos){
		Scanner input = new Scanner(System.in);
		int esc, cod = 118;
		String nome, cod_recurso;
		boolean permissao = false;

		esc = input.nextInt();
		while(esc < 0 || esc > 7){
			esc = input.nextInt();
		}

		while(esc >= 0 && esc <= 7){

			switch(esc){
			case 1:
				System.out.println("*** Cadastro de usuarios ***");
				System.out.println("TIPOS:\n*      1 - Adm\n*      2 - Pesquisador\n*     "
						+ " 3 - Professor\n*      4 - Aluno Doutorado\n*      "
						+ "5 - Aluno Mestrado\n*      6 - Aluno Graduação");
				users = Usuario.adicionar(cod, users);
				System.out.println("Cadastro realizado com Sucesso...\n");
				cod++;
				break;

			case 2:
				System.out.println("\n*** Consulta por usuario ***\n");
				System.out.print("nome: ");
				nome = input.next();
				break;

			case 3:
				System.out.println("\n*** Solicitação de recurso ***\n");
				System.out.print("cod do recurso desejado: ");
				cod_recurso = input.next();

				System.out.println("Verificando disponibilidade...");
				permissao = Processos.vericacaoDeDisponibilidade(cod_recurso, l_recursos);

				if(permissao){
					System.out.println("Recurso disponivel");
					System.out.print("id do usuario alocador: ");
					int id_user = input.nextInt();
					if(verificacaoDeUsuarioValido(id_user, users)){
						System.out.print("\n1 - Aula tradicional\n2 - Apresentacoes\n3 - laboratorios\n0 - sair\nAtividade a realizar: ");
						int atividade = input.nextInt();
						while(atividade < 1 || atividade > 4){
							System.out.print("\n1 - Aula tradicional\n2 - Apresentacoes\n3 - laboratorios\n0 - sair\nAtividade a realizar: ");
							atividade = input.nextInt();
							if(atividade == 0) break;
						}
						if(atividade == 1 || atividade == 3){
							permissao = permissaoParaAlocacao(users);

						} else {
							permissao = true;
							System.out.println("Voce não tem permissao para alocar esse espaco");
						}
					}
				
					if(permissao){
						System.out.print("Titulo da atividade: ");
						String titulo = input.next();
						System.out.print("Descrição breve: ");
						String descricao = input.next();
						System.out.print("Participantes: ");
						String participantes = input.next();
						System.out.print("Material de apoio: ");
						String materialApoio = input.next();
						
					}
					
					//adicionar os dados a uma classe atividade e copiar todos os dados coletados para ela

				} else {
					System.out.println("Esse usuario não está cadastrado no sistema");
				}

				break;

			case 4:

				System.out.println("\n*** Usuarios Cadastrados ***\n");
				for (int i = 0; i < users.size(); i++) {
					Usuario us = (Usuario) users.get(i);
					System.out.print(us.id + " ");
					System.out.print(tipoDeUsuario(us.tipo) + " ");
					System.out.println(us.getNome() + " " + us.getSobrenome());
				}
				break;

			case 5:
				System.out.println("\n*** Recursos***\n");

				for (int i = 0; i < l_recursos.size(); i++) {
					Recursos lr = (Recursos) l_recursos.get(i);				  
					System.out.print(lr.getId()+ " ");			
					System.out.print(lr.getNome_recurso() + " " + Processos.status(lr.getStatus()));
					System.out.println(Processos.responsavel(lr.getResponsavel(), users));
				}
				break;
			case 7:
				System.out.println("\nSaindo...\n");
				System.exit(0);
			}
			System.out.println("\n-------------------------------------------\n");
			menu();
			esc = input.nextInt();
			while(esc < 0 || esc > 7){
				esc = input.nextInt();
			}
		} //end switch
	}

	private static boolean permissaoParaAlocacao(List users) {
		boolean bool = false;
		for (int i = 0; i < users.size(); i++) {
			Usuario us = (Usuario) users.get(i);				  
			if( 3 == us.getTipo()){
				bool = true;
			}
		}

		return bool;
	}

	private static boolean verificacaoDeUsuarioValido(int id_user, List users) {
		boolean bool = false;
		for (int i = 0; i < users.size(); i++) {
			Usuario us = (Usuario) users.get(i);				  
			if(id_user == us.id){
				bool = true;
			}
		}
		return bool;
	}

	public static void listar(List users){

		for (int i = 0; i < users.size(); i++) {
			Usuario us = (Usuario) users.get(i);				  
			System.out.println(us.getId() + " " + us.getNome() + " " + us.getSobrenome());
		}
	}
}