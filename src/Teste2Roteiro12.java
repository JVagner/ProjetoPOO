public class Teste2Roteiro12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Antes de executar esse programa, execute o Teste1Roteiro12 para criar os arquivos
		
		SisalocaIF sistema = new Sisaloca();
		try {
			//cadastro de professores que est�o no arquivo
			sistema.carregarProfessoresDeArquivo("professores2.txt");
			//cadastro de disciplinas pelo arquivo
			sistema.carregarDisciplinasDeArquivo("disciplinas2.txt");
			//cadastro das turmas que est�o no arquivo
			sistema.carregarTurmasDeDisciplinasEmArquivo("turmas2.txt");
			//cadastro das preferencias dos professores
			sistema.carregaInteressesDeProfessoresPorDisciplinasDeArquivo("preferencias2.txt");
			
			//Verifica��o da quantidade de disciplinas e professores no sistema
			if (sistema.obterListaDeDisciplinas().size() == 3 &&
					sistema.obterListaDeProfessores().size()==3){
				System.out.println("OK: 3 disciplinas e 3 professores encontrados");
			}
			
		
			Professor p = sistema.pesquisaProfessorPelaMatricula("001");
			if (p.getNome().equals("Manoel")){
				System.out.println("OK: Sistema achou Manoel");
			} else {
				System.out.println("ERRO:Arquivo passado n�o tinha Manoel");
			}
			
			Professor p2 = sistema.pesquisaProfessorPelaMatricula("123");
			if (p2.getNome().equals("Ayla") && p2.getDisciplinasPreferidasComNivel(Professor.PREF_P1).size()==2){
				System.out.println("OK: Sistema achou Ayla e suas preferencias");
			} else {
				System.out.println("ERRO:Arquivo passado n�o tinha Ayla");
			}
			
			
			Professor p3 = sistema.pesquisaProfessorPelaMatricula("444");
			if (p3.getNome().equals("Silvia") && p3.getDisciplinasPreferidasComNivel(Professor.PREF_P1).size() ==1
					&& p3.getDisciplinasPreferidasComNivel(Professor.PREF_P2).size() ==1){
				System.out.println("OK: Sistema achou Silvia e suas prefer�ncias");
			} else {
				System.out.println("ERRO:Arquivo passado n�o tinha Silvia");
			}
			
			Disciplina d = sistema.pesquisaDisciplina("444");
			if (d.getNome().equals("Estrutura de Dados") && d.getTurmas().size()==2){
				System.out.println("Disciplina encontrada:"+d.getCodigo()+"-"+d.getNome());
				for (Turma t: d.getTurmas()){
					System.out.println("Turma n�mero:"+t.getNumero());
				}
				System.out.println("OK: Sistema achou disciplina e suas turmas");
			} else {
				System.out.println("ERRO: Sistema n�o achou disciplina");
			}
			
		sistema.imprimeProfessoresEDisciplinas();
			
			
			
			System.out.println("OK - sistema testado");
			
		} catch (Exception e) {// Todas as exce��es que podem acontecer s�o subtipos
			                   // de exception. Como o tratamento � o mesmo para todas, 
							   // podemos fazer assim:
			System.out.println("ERRO: Exce��o n�o esperada:"+e.getMessage());
			e.printStackTrace();
		}
	}


}