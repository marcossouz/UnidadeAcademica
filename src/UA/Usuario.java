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

	public static void menu(){
		System.out.println("1 - Cadastrar novo usuario");
		System.out.println("2 - Consulta por usuario");
		System.out.println("4 - Listar usuarios");
		System.out.println("5 - Listar recursos");
		System.out.println("7 - Sair");
		System.out.println("   -- escolha -- ");

	}

	public static void escolha(List users, List l_recursos){
		Scanner input = new Scanner(System.in);
		int esc, cod = 118;
		String nome;
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

			case 4:

				System.out.println("\n*** Usuarios Cadastrados ***\n");
				for (int i = 0; i < users.size(); i++) {
					Usuario us = (Usuario) users.get(i);				  
					System.out.print(us.getId()+ " ");
					if (us.getTipo() == 1){
						System.out.print("Adm ");
					}else if (us.getTipo() == 2){
						System.out.print("Pesq ");
					}else if (us.getTipo() == 3){
						System.out.print("Prof ");
					}else if (us.getTipo() == 4){
						System.out.print("Alun Dout ");
					}else if (us.getTipo() == 5){
						System.out.print("Alun Mest ");
					}else if (us.getTipo() == 6){
						System.out.print("Alun Grad ");
					}

					System.out.println(us.getNome() + " " + us.getSobrenome());
				}
				break;

			case 5:
				System.out.println("\n*** Recursos***\n");
				System.out.println("\n*** Usuarios Cadastrados ***\n");
				for (int i = 0; i < l_recursos.size(); i++) {
					Recursos lr = (Recursos) l_recursos.get(i);				  
					System.out.print(lr.getId()+ " ");			
					System.out.println(lr.getNome_recurso() + " " + Processos.status(lr.getStatus()));
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

	public static void listar(List users){

		for (int i = 0; i < users.size(); i++) {
			Usuario us = (Usuario) users.get(i);				  
			System.out.println(us.getId() + " " + us.getNome() + " " + us.getSobrenome());
		}
	}
}