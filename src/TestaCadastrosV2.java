import java.util.List;

public class TestaCadastrosV2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SisalocaIF sistema = new Sisaloca();
		try {
			//cadastro de aluna Maria de matr�cula 111
			sistema.cadastraAluno("Maria", "111");
			//cadastro de aluna Mariana de matr�cula 112
			sistema.cadastraAluno("Mariana", "112");
			//cadastro do professor Jos� Paulo de matr�cula 311
			sistema.cadastraProfessor("Jos� Paulo", "311");
			//cadastro do professor Jos� Lu�s de matr�cula 312
			sistema.cadastraProfessor("Jos� Lu�s", "312");
			
			//Pesquisa do aluno de matr�cula 112
			Aluno aluno = sistema.pesquisaAlunoPelaMatricula("112");
			//Impress�o dos dados do aluno pesquisado
			System.out.println("Aluno encontrado no sistema:"+aluno.getDescricao());
			//Pesquisa do professor de matr�cula 312
			Professor professor = sistema.pesquisaProfessorPelaMatricula("312");
			//Impress�o dos dados do professor
			System.out.println("Professor encontrado no sistema:"+professor.getDescricao());
			//Remo��o do aluno 111 (Maria)
			sistema.removeAluno("111");
			//Pesquisa dos professores que tem Jos� em seu nome
			List < Professor > profs = sistema.pesquisaProfessorPeloNome("Jos�");
			System.out.println("Professores Jos� encontrados:");
			for (Professor p: profs){
				System.out.println(p.getDescricao());
			}
			if (profs.size() ==2 ){
				System.out.println("OK - parte 1 do sistema testada");
			} else {
				System.out.println("ERRO: N�o conseguiu achar os dois professores");
				return; //Teste para aqui se ocorrer o erro
			}
			//Cadastro da disciplina Linguagem de Programa��o de c�digo 888
			sistema.adicionaDisciplina("Linguagem de Programa��o", "888");
			//Cadastro da disciplina POO de c�digo 999
			sistema.adicionaDisciplina("POO", "999");
			sistema.adicionaTurma("999", 1);
			sistema.adicionaTurma("999", 2);
			sistema.removeDisciplina("888");
			//Pesquisa da disciplina de c�digo 999, que � POO
			Disciplina d = sistema.pesquisaDisciplina("999");
                        //Se a disciplina encontrada for POO e ela tiver duas turmas, est� tudo OK
			if (d.getNome().equals("POO") && d.getTurmas().size()==2){
				System.out.println("Disciplina achada:"+d.getNome()+", de c�digo:"+d.getCodigo());
				for (Turma t: d.getTurmas()){
					System.out.println("Turma n�mero:"+t.getNumero());
				}
				System.out.println("OK - sistema testado");
			} else {
				System.out.println("ERRO: Problema na pesquisa da disciplina");
			}
			
			
		} catch (AlunoJaExisteException e) {
			System.out.println("ERRO: Exce��o n�o esperada:"+e.getMessage());
		} catch (ProfessorJaExisteException e) {
			System.out.println("ERRO: Exce��o n�o esperada:"+e.getMessage());
		} catch (AlunoInexistenteException e) {
			System.out.println("ERRO: Exce��o n�o esperada:"+e.getMessage());
		} catch (ProfessorInexistenteException e) {
			System.out.println("ERRO: Exce��o n�o esperada:"+e.getMessage());
		} catch (DisciplinaJaExisteException e) {
			System.out.println("ERRO: Exce��o n�o esperada:"+e.getMessage());
		} catch (DisciplinaInexistenteException e) {
			System.out.println("ERRO: Exce��o n�o esperada:"+e.getMessage());
		} catch (TurmaJaExisteException e) {
			System.out.println("ERRO: Exce��o n�o esperada:"+e.getMessage());
		} 
	}
	
}
