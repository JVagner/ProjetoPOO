import java.util.List;

public class TestaCadastros {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SisalocaIF sistema = new Sisaloca();
		try {
			//cadastro de aluna Maria de matrícula 111
			sistema.cadastraAluno("Maria", "111");
			//cadastro do professor José Paulo de matrícula 311
			sistema.cadastraProfessor("José Paulo", "311");
			//cadastro do professor José Luís de matrícula 312
			sistema.cadastraProfessor("José Luís", "312");
			
			
			//Pesquisa do aluno de matrícula 111
			Aluno aluno = sistema.pesquisaAlunoPelaMatricula("111");
			//Impressão dos dados do aluno pesquisado
			System.out.println("Aluno encontrado no sistema:"+aluno.getDescricao());
			//Pesquisa do professor de matrícula 311
			Professor professor = sistema.pesquisaProfessorPelaMatricula("311");
			//Impressão dos dados do professor
			System.out.println("Professor encontrado no sistema:"+professor.getDescricao());
			
			//Pesquisa dos professores que tem José em seu nome
			List < Professor > profs = sistema.pesquisaProfessorPeloNome("José");
			System.out.println("Professores José encontrados:");
			for (Professor p: profs){
				System.out.println(p.getDescricao());
			}
			System.out.println("OK - sistema testado");
		} catch (AlunoJaExisteException e) {
			System.out.println("Exceção não esperada:"+e.getMessage());
		} catch (ProfessorJaExisteException e) {
			System.out.println("Exceção não esperada:"+e.getMessage());
		} catch (AlunoInexistenteException e) {
			System.out.println("Exceção não esperada:"+e.getMessage());
		} catch (ProfessorInexistenteException e) {
			System.out.println("Exceção não esperada:"+e.getMessage());
		}
	}
	
}