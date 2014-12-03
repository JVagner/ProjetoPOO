import java.io.IOException;
import java.util.List;

public class TestaCadastrosV3 {

	public static void main(String[] args) {
		SisalocaIF sistema = new Sisaloca();
		try {
			//cadastro de aluna Maria de matr�cula 111
			sistema.cadastraAluno("Maria", "111");
			//cadastro de aluna Mariana de matr�cula 112
			sistema.cadastraAluno("Mariana", "112");
			//cadastro de professores pelo arquivo
			sistema.carregarProfessoresDeArquivo("professores.txt");
			//cadastro de disciplinas pelo arquivo
			sistema.carregarDisciplinasDeArquivo("disciplinas.txt");
			//Verifica��o da quantidade de disciplinas e professores no sistema
			if (sistema.obterListaDeDisciplinas().size() == 2 &&
					sistema.obterListaDeProfessores().size()==2){
				System.out.println("OK: 2 disciplinas e 2 professores encontrados");
			}
			
			//Pesquisa dos alunos com nome que cont�m Maria
			List <Aluno> alunos = sistema.pesquisaAlunoPeloNome("Maria");
			System.out.println("N�mero de alunos encontrados:"+alunos.size());
			//Impress�o dos dados dos alunos pesquisados
			for (Aluno a: alunos){
				System.out.println("Aluno encontrado no sistema:"+a.getDescricao());
			}
		
			Professor p = sistema.pesquisaProfessorPelaMatricula("444");
			if (p.getNome().equals("Silvia")){
				System.out.println("OK: Sistema achou Silvia no arquivo");
			} else {
				System.out.println("Arquivo passado n�o tinha Silvia");
			}
			
			sistema.adicionaTurma("222", 1);
			sistema.adicionaTurma("222", 2);
			//Pesquisa da disciplina de c�digo 222, que � "Introdu��o � Programa��o" pelo arquivo
			Disciplina d = sistema.pesquisaDisciplina("222");
			if (d.getNome().equals("Introdu��o � Programa��o") && d.getTurmas().size()==2){
				System.out.println("Disciplina achada:"+d.getNome()+", de c�digo:"+d.getCodigo());
				for (Turma t: d.getTurmas()){
					System.out.println("Turma n�mero:"+t.getNumero());
				}
				System.out.println("OK - achou turmas da disciplina");
			} else {
				System.out.println("ERRO: Problema na pesquisa da disciplina");
			}


			sistema.cadastraNivelDeInteresseDeProfessorPorDisciplina("444", "222", Professor.PREF_P1);
			List < Disciplina > disciplinasPreferidas = sistema.consultaDisciplinasPorPreferenciaPorProfessor("444", Professor.PREF_P1);
			if (disciplinasPreferidas.size()==1){
				Disciplina dPreferida = disciplinasPreferidas.get(0);
				System.out.println("Cadastro de prefer�ncia OK. Disciplina preferida do"
                                         + "professor:"+dPreferida.getNome()+","+dPreferida.getCodigo());				
			}
			
			System.out.println("OK - sistema testado");
			
		} catch (Exception e) {// Todas as exce��es que podem acontecer s�o subtipos
			                   // de exception. Como o tratamento � o mesmo para todas, 
							   // podemos fazer assim:
			System.out.println("ERRO: Exce��o n�o esperada:"+e.getMessage());
			e.printStackTrace();
		}
	}
}