import java.util.List;

public class TestaCadastrosV2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SisalocaIF sistema = new Sisaloca();
		try {
			//cadastro de aluna Maria de matrícula 111
			sistema.cadastraAluno("Maria", "111");
			//cadastro de aluna Mariana de matrícula 112
			sistema.cadastraAluno("Mariana", "112");
			//cadastro do professor José Paulo de matrícula 311
			sistema.cadastraProfessor("José Paulo", "311");
			//cadastro do professor José Luís de matrícula 312
			sistema.cadastraProfessor("José Luís", "312");
			
			//Pesquisa do aluno de matrícula 112
			Aluno aluno = sistema.pesquisaAlunoPelaMatricula("112");
			//Impressão dos dados do aluno pesquisado
			System.out.println("Aluno encontrado no sistema:"+aluno.getDescricao());
			//Pesquisa do professor de matrícula 312
			Professor professor = sistema.pesquisaProfessorPelaMatricula("312");
			//Impressão dos dados do professor
			System.out.println("Professor encontrado no sistema:"+professor.getDescricao());
			//Remoção do aluno 111 (Maria)
			sistema.removeAluno("111");
			//Pesquisa dos professores que tem José em seu nome
			List < Professor > profs = sistema.pesquisaProfessorPeloNome("José");
			System.out.println("Professores José encontrados:");
			for (Professor p: profs){
				System.out.println(p.getDescricao());
			}
			if (profs.size() ==2 ){
				System.out.println("OK - parte 1 do sistema testada");
			} else {
				System.out.println("ERRO: Não conseguiu achar os dois professores");
				return; //Teste para aqui se ocorrer o erro
			}
			//Cadastro da disciplina Linguagem de Programação de código 888
			sistema.adicionaDisciplina("Linguagem de Programação", "888");
			//Cadastro da disciplina POO de código 999
			sistema.adicionaDisciplina("POO", "999");
			sistema.adicionaTurma("999", 1);
			sistema.adicionaTurma("999", 2);
			sistema.removeDisciplina("888");
			//Pesquisa da disciplina de código 999, que é POO
			Disciplina d = sistema.pesquisaDisciplina("999");
                        //Se a disciplina encontrada for POO e ela tiver duas turmas, está tudo OK
			if (d.getNome().equals("POO") && d.getTurmas().size()==2){
				System.out.println("Disciplina achada:"+d.getNome()+", de código:"+d.getCodigo());
				for (Turma t: d.getTurmas()){
					System.out.println("Turma número:"+t.getNumero());
				}
				System.out.println("OK - sistema testado");
			} else {
				System.out.println("ERRO: Problema na pesquisa da disciplina");
			}
			
			
		} catch (AlunoJaExisteException e) {
			System.out.println("ERRO: Exceção não esperada:"+e.getMessage());
		} catch (ProfessorJaExisteException e) {
			System.out.println("ERRO: Exceção não esperada:"+e.getMessage());
		} catch (AlunoInexistenteException e) {
			System.out.println("ERRO: Exceção não esperada:"+e.getMessage());
		} catch (ProfessorInexistenteException e) {
			System.out.println("ERRO: Exceção não esperada:"+e.getMessage());
		} catch (DisciplinaJaExisteException e) {
			System.out.println("ERRO: Exceção não esperada:"+e.getMessage());
		} catch (DisciplinaInexistenteException e) {
			System.out.println("ERRO: Exceção não esperada:"+e.getMessage());
		} catch (TurmaJaExisteException e) {
			System.out.println("ERRO: Exceção não esperada:"+e.getMessage());
		} 
	}
	
}
