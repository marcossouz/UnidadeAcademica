package UA;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static boolean autorizacao;
	public static void main(String[] args) {

		List users = new ArrayList();
		List l_recursos = new ArrayList();
		List l_atividades = new ArrayList();
		users = Usuario.preconfig();
		l_recursos = Processos.carregarRecursos();

		autorizacao = Usuario.autenticar(users);

		while(!autorizacao){
			System.out.println("Nao autorizado!\n");
			autorizacao = Usuario.autenticar(users);
		}

		System.out.println("\nBem-vindo ao sistema da Unidade Academica SouzaME");
		
		Usuario.menu();
		Usuario.escolha(users, l_recursos, l_atividades);
		
	}	
}
