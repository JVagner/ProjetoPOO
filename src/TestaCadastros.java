import java.util.List;

public class TestaCadastros {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SisalocaIF sistema = new Sisaloca();
		try {
			//cadastro de aluna Maria de matr�cula 111
			sistema.cadastraAluno("Maria", "111");
			//cadastro do professor Jos� Paulo de matr�cula 311
			sistema.cadastraProfessor("Jos� Paulo", "311");
			//cadastro do professor Jos� Lu�s de matr�cula 312
			sistema.cadastraProfessor("Jos� Lu�s", "312");
			
			
			//Pesquisa do aluno de matr�cula 111
			Aluno aluno = sistema.pesquisaAlunoPelaMatricula("111");
			//Impress�o dos dados do aluno pesquisado
			System.out.println("Aluno encontrado no sistema:"+aluno.getDescricao());
			//Pesquisa do professor de matr�cula 311
			Professor professor = sistema.pesquisaProfessorPelaMatricula("311");
			//Impress�o dos dados do professor
			System.out.println("Professor encontrado no sistema:"+professor.getDescricao());
			
			//Pesquisa dos professores que tem Jos� em seu nome
			List < Professor > profs = sistema.pesquisaProfessorPeloNome("Jos�");
			System.out.println("Professores Jos� encontrados:");
			for (Professor p: profs){
				System.out.println(p.getDescricao());
			}
			System.out.println("OK - sistema testado");
		} catch (AlunoJaExisteException e) {
			System.out.println("Exce��o n�o esperada:"+e.getMessage());
		} catch (ProfessorJaExisteException e) {
			System.out.println("Exce��o n�o esperada:"+e.getMessage());
		} catch (AlunoInexistenteException e) {
			System.out.println("Exce��o n�o esperada:"+e.getMessage());
		} catch (ProfessorInexistenteException e) {
			System.out.println("Exce��o n�o esperada:"+e.getMessage());
		}
	}
	
}