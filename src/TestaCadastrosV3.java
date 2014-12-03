import java.io.IOException;
import java.util.List;

public class TestaCadastrosV3 {

	public static void main(String[] args) {
		SisalocaIF sistema = new Sisaloca();
		try {
			//cadastro de aluna Maria de matrícula 111
			sistema.cadastraAluno("Maria", "111");
			//cadastro de aluna Mariana de matrícula 112
			sistema.cadastraAluno("Mariana", "112");
			//cadastro de professores pelo arquivo
			sistema.carregarProfessoresDeArquivo("professores.txt");
			//cadastro de disciplinas pelo arquivo
			sistema.carregarDisciplinasDeArquivo("disciplinas.txt");
			//Verificação da quantidade de disciplinas e professores no sistema
			if (sistema.obterListaDeDisciplinas().size() == 2 &&
					sistema.obterListaDeProfessores().size()==2){
				System.out.println("OK: 2 disciplinas e 2 professores encontrados");
			}
			
			//Pesquisa dos alunos com nome que contém Maria
			List <Aluno> alunos = sistema.pesquisaAlunoPeloNome("Maria");
			System.out.println("Número de alunos encontrados:"+alunos.size());
			//Impressão dos dados dos alunos pesquisados
			for (Aluno a: alunos){
				System.out.println("Aluno encontrado no sistema:"+a.getDescricao());
			}
		
			Professor p = sistema.pesquisaProfessorPelaMatricula("444");
			if (p.getNome().equals("Silvia")){
				System.out.println("OK: Sistema achou Silvia no arquivo");
			} else {
				System.out.println("Arquivo passado não tinha Silvia");
			}
			
			sistema.adicionaTurma("222", 1);
			sistema.adicionaTurma("222", 2);
			//Pesquisa da disciplina de código 222, que é "Introdução à Programação" pelo arquivo
			Disciplina d = sistema.pesquisaDisciplina("222");
			if (d.getNome().equals("Introdução à Programação") && d.getTurmas().size()==2){
				System.out.println("Disciplina achada:"+d.getNome()+", de código:"+d.getCodigo());
				for (Turma t: d.getTurmas()){
					System.out.println("Turma número:"+t.getNumero());
				}
				System.out.println("OK - achou turmas da disciplina");
			} else {
				System.out.println("ERRO: Problema na pesquisa da disciplina");
			}


			sistema.cadastraNivelDeInteresseDeProfessorPorDisciplina("444", "222", Professor.PREF_P1);
			List < Disciplina > disciplinasPreferidas = sistema.consultaDisciplinasPorPreferenciaPorProfessor("444", Professor.PREF_P1);
			if (disciplinasPreferidas.size()==1){
				Disciplina dPreferida = disciplinasPreferidas.get(0);
				System.out.println("Cadastro de preferência OK. Disciplina preferida do"
                                         + "professor:"+dPreferida.getNome()+","+dPreferida.getCodigo());				
			}
			
			System.out.println("OK - sistema testado");
			
		} catch (Exception e) {// Todas as exceções que podem acontecer são subtipos
			                   // de exception. Como o tratamento é o mesmo para todas, 
							   // podemos fazer assim:
			System.out.println("ERRO: Exceção não esperada:"+e.getMessage());
			e.printStackTrace();
		}
	}
}