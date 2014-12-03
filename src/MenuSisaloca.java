import javax.swing.JOptionPane;

public class MenuSisaloca {



   public static void main(String[] args) {
      boolean sair = false;
      SisalocaIF sistema = new Sisaloca();
      try{
	      while (!sair){
	         String opcaoStr = JOptionPane.showInputDialog("Digite uma opção: \n1) Cadastrar Professor; \n2)Cadastrar aluno; \n3) Pesquisa Professor pelo nome; \n4) Pesquisa Professor pela matricula; \n5)Pesquisa Aluno pelo nome; \n6Pesquisa Aluno pela matricula; \n7Remove Professor; \n8)Remove Aluno; \n9Adiciona Disciplina; \n10Remove Disciplina; \n11Adiciona Turma; \n12Remove Turma; \n13Pesquisa Disciplina; \n14Cadastra Nivel de Interesse de professor por disciplina; \n15Consulta Disciplina por preferencia por professor; \n16Carregar Professor de Arquivo; \n17Obter Lista de Professoes; \n18Obter Lista de Disciplinas; \n19Carrega Disciplina de arquivo; \n20 Gravar Disciplinas em arquivo; \n21 Gravar professores em arquivos; \n22 Gravar Turmas de disciplinas em arquivo; \n23Carregar Turmas de disciplinas em arquivo; \n24Carrega interesses de professores por disciplinas de arquivo; \n25Lê lista de codigo de disciplinas de linha; \n26Grava Interesses de professores por disciplinas em arquivo; \n27Imprime Professores e disciplinas; \n28Cadastra Horario Turma; \n29Aloca Professor a Turma; \n30Desaloca Pofessor de turma; \n31Pesquisa horario professor; \32Pesquisa Turmas do Professor; \n33Pesquisa Disciplinas do professor; \n34Pesquisa Turma; \n35 Sair; ");
	         int opcao = Integer.parseInt(opcaoStr);
			 switch(opcao){
		       case 1: //Cadastrar Professor
		               String nome1 = JOptionPane.showInputDialog("Digite o nome do Professor:");
		               String matricula1 = JOptionPane.showInputDialog("Digite a matricula do professor:");
		               sistema.cadastraProfessor(nome1, matricula1);
		               JOptionPane.showMessageDialog(null, "Professor Cadastrado");
		               break;
		
		            case 2: //Cadastrar aluno;
		            	String nome2 = JOptionPane.showInputDialog("Digite o nome do Aluno:");
			            String matricula2 = JOptionPane.showInputDialog("Digite a matricula do Aluno:");
			            sistema.cadastraAluno(nome2, matricula2);
			            JOptionPane.showMessageDialog(null, "Aluno Cadastrado");
		                break;
		
		            case 3: //Pesquisa Professor pelo nome
		            	String nome3 = JOptionPane.showInputDialog("Digite o nome do Professor:");
		               	JOptionPane.showMessageDialog(null, sistema.pesquisaProfessorPeloNome(nome3));
		                break;
		
		            case 4: //Pesquisa Professor pela matricula
		            	String matricula3 = JOptionPane.showInputDialog("Digite a matricula do Professor:");
		               	JOptionPane.showMessageDialog(null, sistema.pesquisaProfessorPelaMatricula(matricula3));
		                break;
		
			     case 5://Pesquisa Aluno pelo nome
			    	 	String nome4 = JOptionPane.showInputDialog("Digite o nome do Aluno:");
		               	JOptionPane.showMessageDialog(null, sistema.pesquisaAlunoPeloNome(nome4));
		                break;
		 
		             case 6:// Pesquisa Aluno pela matricula
		            	 String nome5 = JOptionPane.showInputDialog("Digite a matricula do Aluno:");
			             JOptionPane.showMessageDialog(null, sistema.pesquisaAlunoPelaMatricula(nome5));
			             break;
		
		             case 7:// Remove Professor
		            	 String matricula4 = JOptionPane.showInputDialog("Digite a matricula do Professor:");
		            	 sistema.removeProfessor(matricula4);
			             JOptionPane.showMessageDialog(null, "Matricula do professor removida");
			             break;
		
		             case 8://Remove Aluno
		            	 String matricula5 = JOptionPane.showInputDialog("Digite a matricula do Aluno:");
		            	 sistema.removeAluno(matricula5);
			             JOptionPane.showMessageDialog(null, "Matricula do aluno removida");
			             break;
			             
		             case 9://Adiciona disciplina
		            	 String nome6 = JOptionPane.showInputDialog("Digite o nome da Disciplina:");
		            	 String codigo1 = JOptionPane.showInputDialog("Digite o codigo da Disciplina:");
		            	 sistema.adicionaDisciplina(nome6, codigo1);
			             JOptionPane.showMessageDialog(null, "Disciplina adicionada");
			             break;
			             
		             case 10://Remove disciplina
		            	 String codigo2 = JOptionPane.showInputDialog("Digite o codigo da Disciplina:");
		            	 sistema.removeDisciplina(codigo2);
			             JOptionPane.showMessageDialog(null, "Disciplina removida");
			             break;
			             
		             case 11://Adiciona turma	 
		            	 String codigo3 = JOptionPane.showInputDialog("Digite o codigo da Disciplina:");
		            	 int numTurma1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da Turma:"));
		            	 sistema.adicionaTurma(codigo3, numTurma1);
			             JOptionPane.showMessageDialog(null, "Turma adicionada");
			             break;
			             
		             case 12://Remove turma
		            	 String codigo4 = JOptionPane.showInputDialog("Digite o codigo da Disciplina:");
		            	 int numTurma2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da Turma:"));
		            	 sistema.removeTurma(codigo4, numTurma2);
			             JOptionPane.showMessageDialog(null, "Turma removida");
			             break;
			             
		             case 13://Pesquisa Disciplina
		            	 String codigo5 = JOptionPane.showInputDialog("Digite o codigo:");
			             JOptionPane.showMessageDialog(null, sistema.pesquisaDisciplina(codigo5));
			             break;
			             
		             case 14://Cadastra Nivel de Interesse de professor por disciplina
		            	 String matricula8 = JOptionPane.showInputDialog("Digite a matricula do professor:");
		            	 String codigo6 = JOptionPane.showInputDialog("Digite o codigo da Disciplina:");
		            	 int nivelPreferencia = Integer.parseInt(JOptionPane.showInputDialog("Digite o nivel de peferencia:"));
		            	 sistema.cadastraNivelDeInteresseDeProfessorPorDisciplina(matricula8, codigo6, nivelPreferencia);
			             JOptionPane.showMessageDialog(null, "Nivel de Interesse cadastrado");
			             break;
			             
		             case 15://Consulta Disciplina por preferencia por professor
		            	 String matricula6 = JOptionPane.showInputDialog("Digite a matricula do professor:");
		            	 int nivelPreferencia1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo:"));
			             JOptionPane.showMessageDialog(null, sistema.consultaDisciplinasPorPreferenciaPorProfessor(matricula6, nivelPreferencia1));
			             break;
			             
		             case 16://Carrega Professor de arquivo
		            	 String nomeArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo:");
		            	 sistema.carregarProfessoresDeArquivo(nomeArquivo);
		            	 JOptionPane.showMessageDialog(null, "O arquivo dos professores foi caregado.");
		            	 break;
		            	 
		             case 17://Obter Lista de professores
		            	 JOptionPane.showMessageDialog(null, sistema.obterListaDeProfessores());
		            	 break;
		            	 
		             case 18://Obter Lista de disciplina
		            	 JOptionPane.showMessageDialog(null, sistema.obterListaDeDisciplinas());
		            	 break;
		            	 
		             case 19://Carrega disciplina de arquivo
		            	 String nomeArquivo1 = JOptionPane.showInputDialog("Digite o nome do arquivo:");
		            	 sistema.carregarDisciplinasDeArquivo(nomeArquivo1);
		            	 JOptionPane.showMessageDialog(null, "O arquivo das disciplinas foi caregada.");
		            	 break;
		            	 
		             case 20://Gravar disciplinas em arquivo
		            	 String nomeArquivo2 = JOptionPane.showInputDialog("Digite o nome do arquivo:");
		            	 sistema.gravarDisciplinasEmArquivo(nomeArquivo2);
		            	 JOptionPane.showMessageDialog(null, "O arquivo das disciplinas foi gravado.");
		            	 break;
		            	 
		             case 21://Gravar professores em arquivo
		            	 String nomeArquivo3 = JOptionPane.showInputDialog("Digite o nome do arquivo:");
		            	 sistema.gravarProfessoresEmArquivo(nomeArquivo3);
		            	 JOptionPane.showMessageDialog(null, "O arquivo dos professores foi gravado.");
		            	 break;
		            	 
		             case 22://Gravar turmas de disciplinas em arquivo
		            	 String nomeArquivo4 = JOptionPane.showInputDialog("Digite o nome do arquivo:");
		            	 sistema.gravarTurmasDeDisciplinasEmArquivo(nomeArquivo4);
		            	 JOptionPane.showMessageDialog(null, "O arquivo das turmas de disciplinas foi gravado.");
		            	 break;
		            	 
		             case 23://Carregar turmas de disciplina em arquivo
		            	 String nomeArquivo5 = JOptionPane.showInputDialog("Digite o nome do arquivo:");
		            	 sistema.carregarTurmasDeDisciplinasEmArquivo(nomeArquivo5);
		            	 JOptionPane.showMessageDialog(null, "O arquivo das turmas de disciplinas foi caregada.");
		            	 break;
		            	 

		             case 24://Carrega interesses de professores por disciplinas de arquivo; 
		            	 String nomeArquivo6 = JOptionPane.showInputDialog("Digite o nome do arquivo:");
		            	 sistema.carregaInteressesDeProfessoresPorDisciplinasDeArquivo(nomeArquivo6);
		            	 JOptionPane.showMessageDialog(null, "O arquivo de interesses de professor por disciplinas foi caregada.");
		            	 break;
		            	 
		            	 
		            /* case 25://Lê lista de codigo de disciplinas de linha;
		            	 String linha = JOptionPane.showInputDialog("Digite a linha da lista:");
			             JOptionPane.showMessageDialog(null, sistema.leListaDeCodigosDeDisciplinasDeLinha(linha));
			             break; */
		            	 
			             
		             case 26://Grava Interesses de professores por disciplinas em arquivo;
		            	 String nomeArquivo7 = JOptionPane.showInputDialog("Digite o nome do arquivo:");
		            	 sistema.gravaInteressesDeProfessoresPorDisciplinasEmArquivo(nomeArquivo7);
		            	 JOptionPane.showMessageDialog(null, "O arquivo de interesses de professor foi gravado.");
		            	 break;
		            	 
		             case 27://Imprime Professores e disciplinas; 
			             sistema.imprimeProfessoresEDisciplinas();
			             break;
			             
		             case 28://Cadastra Horario Turma;
		            	 String codDisciplina = JOptionPane.showInputDialog("Digite o codigo da disciplina:");
		            	 int numTurma = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da turma:"));
		            	 String dia = JOptionPane.showInputDialog("Digite o dia do hoario:");
		            	 int horaInicio = Integer.parseInt(JOptionPane.showInputDialog("Digite a hora inicio do hoario:"));
		            	 int horaFim = Integer.parseInt(JOptionPane.showInputDialog("Digite a hora final do hoario:"));
		            	 sistema.cadastraHorarioTurma(codDisciplina, numTurma, dia, horaInicio, horaFim);
		            	 JOptionPane.showMessageDialog(null, "Foi cadasrado o horario a turma");
		            	 break;
		            	 
		             case 29://Aloca Professor a Turma;
		            	 String codDisciplina1 = JOptionPane.showInputDialog("Digite o codigo da disciplina:");
		            	 int numTurma3 = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da turma:"));
		            	 String matriculaProf = JOptionPane.showInputDialog("Digite a matricula do professor:");
		            	 sistema.alocaProfessorATurma(codDisciplina1, numTurma3, matriculaProf);
		            	 JOptionPane.showMessageDialog(null, "Foi alocado o professor a turma");
		            	 break;
		            	 
		             case 30://Desaloca Pofessor de turma;
		            	 String codDisciplina2 = JOptionPane.showInputDialog("Digite o codigo da disciplina:");
		            	 int numTurma4 = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da turma:"));
		            	 String matriculaProf1 = JOptionPane.showInputDialog("Digite a matricula do professor:");
		            	 sistema.desalocaProfessorDeTurma(codDisciplina2, numTurma4, matriculaProf1);
		            	 JOptionPane.showMessageDialog(null, "Já foi desalocada o professor a turma");
		            	 break;
		            	 
		             case 31://Pesquisa horario professor;
		            	 String matriculaProf5 = JOptionPane.showInputDialog("Digite a matricula do professor:");
			             JOptionPane.showMessageDialog(null, sistema.pesquisaHorariosProfessor(matriculaProf5));
			             break;
			             
		             case 32://Pesquisa Turmas do Professor;
		             	String matriculaProf6 = JOptionPane.showInputDialog("Digite a matricula do professor:");
		             	JOptionPane.showMessageDialog(null, sistema.pesquisaTurmasDoProfessor(matriculaProf6));
		             	break;
		             	
		             case 33://Pesquisa Disciplinas do professor;
		            	 String matriculaProf7 = JOptionPane.showInputDialog("Digite a matricula do professor:");
			             JOptionPane.showMessageDialog(null, sistema.pesquisaDisciplinasDoProfessor(matriculaProf7));
			             break;
			             
		             case 34://Pesquisa Turma;
		            	 String codDisciplina3 = JOptionPane.showInputDialog("Digite o codigo da turma:");
		            	 int numTurma5 = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da turma:"));
			             JOptionPane.showMessageDialog(null, sistema.pesquisaTurma(codDisciplina3, numTurma5));
			             break;
			             
		             case 35://Sair;
		            	sair = true;
		     	        JOptionPane.showMessageDialog(null, "Programa controle academico foi terminado. Até mais");
		     	        break;
			     default:
			        JOptionPane.showMessageDialog(null, "Opção digitada inválida:"+opcao);
		         }
		      }
				
	
	   
      }catch(Exception e){
    	  System.out.println("Exceção não esperada:"+e.getMessage());
    	  e.printStackTrace();
      }
   }
}
      

