/*
 * @author Marcos Souza
 */
package UA;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private static boolean autorizacao;

	public static void main(String[] args) {

		List<Usuario> users = new ArrayList<Usuario>();
		List<Recursos> l_recursos = new ArrayList<Recursos>();
		List<Atividade> l_atividades = new ArrayList<Atividade>();
		List<HistRecursos> historicoRecurso = new ArrayList<HistRecursos>();
		CodigoAutomatico cod = new CodigoAutomatico();
		
		users = Usuario.preconfig(cod);
		l_recursos = Processos.carregarRecursos();

		autorizacao = Usuario.autenticar(users);

		while (!autorizacao) {
			System.out.println("Nao autorizado!\n");
			autorizacao = Usuario.autenticar(users);
		}

		System.out.println("\nBem-vindo ao sistema da Unidade Academica SouzaME");

		Usuario.menu();
		Usuario.escolha(users, l_recursos, l_atividades, historicoRecurso, cod);

	}
	
	
}
