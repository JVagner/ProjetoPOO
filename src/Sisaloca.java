
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class Sisaloca implements SisalocaIF{

	private List <Professor> professores = new ArrayList<Professor>();
	private List<Aluno> alunos = new ArrayList<Aluno>();
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public void cadastraProfessor(String nome, String matricula)throws ProfessorJaExisteException{
		
		boolean jaCadastrou = true;
		for(Professor p: professores){
			if (p.getMatricula().equals(matricula)){
				jaCadastrou = false;
				break;
			}
		}	
		if(jaCadastrou == true){
			Professor p = new Professor(nome,matricula);
			this.professores.add(p);

			
		}else{
			throw new ProfessorJaExisteException("Existe Professor com essa matricula.");
		}
	}
	
	public void cadastraAluno(String nome, String matricula)throws AlunoJaExisteException{
		
		boolean jaCadastrou  = true;
		for(Aluno a: alunos){
			if (a.getMatricula().equals(matricula)){
				jaCadastrou = false;
				break;
			}
		}	
		if(jaCadastrou == true){
			Aluno a = new Aluno(nome,matricula);
			this.alunos.add(a);
		}else{
			throw new AlunoJaExisteException("Existe Aluno com essa matricula.");
		}
	}
	
	public List<Professor> pesquisaProfessorPeloNome(String nome){
		
		List<Professor> profComNome = new ArrayList<Professor>();
		for(Professor p: professores){
			if(p.getNome().indexOf(nome) >= 0){
				profComNome.add(p);
			}
		}
		return profComNome;
	}
	
	public Professor pesquisaProfessorPelaMatricula(String matricula) throws ProfessorInexistenteException{
		
		for(Professor p: professores){
			if(p.getMatricula().equals(matricula)){
				return p;
			}
		}
		throw new ProfessorInexistenteException("O Professor com essa matricula não existe");	
	}
	
	public List <Aluno> pesquisaAlunoPeloNome(String nome){
		
		List<Aluno> alunosEncontrado= new ArrayList<Aluno>();
		for(Aluno a: alunos){
			if(a.getNome().indexOf(nome) >= 0){
				alunosEncontrado.add(a);
			}
		}
		return alunosEncontrado;
	}
	
	public Aluno pesquisaAlunoPelaMatricula(String matricula) throws AlunoInexistenteException{
			
			for(Aluno a: alunos){
				if(a.getMatricula().equals(matricula)){
					return a;
				}
			}
			
			throw new AlunoInexistenteException("O Aluno com essa matricula não existe");
	}
	
	public void removeProfessor(String matricula) throws ProfessorInexistenteException{
		
		boolean remove = false;
		for(Professor p: professores){
			if(p.getMatricula().equals(matricula)){
				professores.remove(p);
				remove = true;
				break;
			}
		}
		
		if(! remove){
			throw new ProfessorInexistenteException("O Professor com essa matricula não existe");
		}
	}
	
	public void removeAluno(String matricula) throws AlunoInexistenteException{
		
		boolean remove = false;
		for(Aluno a: alunos){
			if(a.getMatricula().equals(matricula)){
				alunos.remove(a);
				remove = true;
				break;
			}
		}
		
		if(! remove){
			throw new AlunoInexistenteException("O Aluno com essa matricula não existe");
		}
	}
	
	public void adicionaDisciplina(String nome, String codigo) throws DisciplinaJaExisteException {

		for(Disciplina d: disciplinas){
			if(d.getCodigo().equals(codigo)){
				throw new DisciplinaJaExisteException("A disciplina com esse codigo já existe");
			}
		}	
		Disciplina d = new Disciplina(nome,codigo);
		this.disciplinas.add(d);
		
	}
	public void removeDisciplina(String codigo) throws DisciplinaInexistenteException {
		
		boolean remove = false;
		for(Disciplina d: disciplinas){
			if(d.getCodigo().equals(codigo)){
				disciplinas.remove(d);
				remove = true;
				break;
			}
		}
		
		if(! remove){
			throw new DisciplinaInexistenteException("A disciplina com esse codigo não existe");
		}
	}
		
    public Disciplina pesquisaDisciplina(String codigoDisciplina) throws DisciplinaInexistenteException {
    	
    	for(Disciplina d: disciplinas){
    		if(d.getCodigo().equals(codigoDisciplina)){
    			return d;
    		}
    	}
    	
    	throw new DisciplinaInexistenteException("A disciplina com esse codigo não existe");
    }
    
	public void adicionaTurma(String codigoDisciplina, int numTurma) throws DisciplinaInexistenteException, TurmaJaExisteException {
	
		boolean achou = false;
		for(Disciplina d: disciplinas){
			if(d.getCodigo().equals(codigoDisciplina)){
				d.adicionaTurma(numTurma);
				achou = true;
				break;
			}
		}
		
		if(!achou){
			throw new DisciplinaInexistenteException("A disciplina com esse codigo não existe");
		}
	}
	
	public void removeTurma(String codigoDisciplina, int numTurma) throws DisciplinaInexistenteException {
		
		boolean remove = false;
		for(Disciplina d: disciplinas){
			if(d.getCodigo().equals(codigoDisciplina)){
				d.removeTurma(numTurma);
				remove = true;
				break;
			}
		}
		
		if(!remove){
			throw new DisciplinaInexistenteException("A disciplina com esse codigo não existe");
		}
	}
	
	public void cadastraNivelDeInteresseDeProfessorPorDisciplina(String matriculaProf,String codDisciplina, int nivelPreferencia)throws PreferenciaInvalidaException, ProfessorInexistenteException, DisciplinaInexistenteException {
		Professor prof = this.pesquisaProfessorPelaMatricula(matriculaProf);
		Disciplina dis = this.pesquisaDisciplina(codDisciplina);
		prof.adicionaPreferenciaDisciplina(dis, nivelPreferencia);
	}
	
	public List <Disciplina> consultaDisciplinasPorPreferenciaPorProfessor(String matriculaProfessor, int nivelPreferencia) throws ProfessorInexistenteException, PreferenciaInvalidaException{
		
		for(Professor p: professores){
			if(p.getMatricula().equals(matriculaProfessor)){
				return p.getDisciplinasPreferidasComNivel(nivelPreferencia);
			}
		}
		throw new ProfessorInexistenteException("O Professor com essa maricula não existe.");
	}
	
	public List <Professor> obterListaDeProfessores(){
		return professores;
	}
	
	public List <Disciplina> obterListaDeDisciplinas(){
		return disciplinas;
	}
	
	public void carregarProfessoresDeArquivo(String nomeArquivo) throws ProfessorJaExisteException, IOException {
		BufferedReader leitor = null;
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String nomeProf = null;
			do {
				nomeProf = leitor.readLine(); // lê a próxima linha do arquivo, nome do professor
				if (nomeProf != null){
                    String matriculaProf = leitor.readLine(); //Lê a próxima linha do arquivo, matrícula do professor
				    this.cadastraProfessor(nomeProf, matriculaProf);
                }
			} while(nomeProf != null); //vai ser null quando chegar no fim do arquivo
		} finally {
			if (leitor!=null){
				leitor.close();
			}
		}
	}

	
	public void carregarDisciplinasDeArquivo(String nomeArquivo) throws DisciplinaJaExisteException, IOException {
		BufferedReader leitor = null;
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String nomeDisciplina = null;
			do {
				nomeDisciplina = leitor.readLine(); // lê a próxima linha do arquivo, nome da disciplina.
				if (nomeDisciplina != null){
                    String matriculaDisciplina = leitor.readLine(); //Lê a próxima linha do arquivo, matrícula da disciplina.
				    this.adicionaDisciplina(nomeDisciplina, matriculaDisciplina);
                               }
			} while(nomeDisciplina != null); //vai ser null quando chegar no fim do arquivo
		} finally {
			if (leitor!=null){
				leitor.close();
			}
		}
				
		
	}
	
	public void gravarDisciplinasEmArquivo(String nomeArquivo) throws IOException {
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for (Disciplina disciplina: this.disciplinas){
				gravador.write(disciplina.getNome()+"\n");
				gravador.write(disciplina.getCodigo()+"\n");
			}
		} finally {
			if (gravador!=null){
				gravador.close();
			}
		}		
	}
	
	public void gravarProfessoresEmArquivo(String nomeArquivo) throws  IOException{
		BufferedWriter gravador = null;
		try{
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for (Professor p: this.professores){
				gravador.write(p.getNome()+"\n");
				gravador.write(p.getMatricula()+"\n");
			}
		} finally {
			if (gravador!=null){
				gravador.close();
			}
		}		
	}
	
	public void gravarTurmasDeDisciplinasEmArquivo(String nomeArquivo) throws IOException{
		BufferedWriter gravador = null;
		try{
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for (Disciplina disciplina: this.disciplinas){
				gravador.write(disciplina.getCodigo()+"\n");
				gravador.write(disciplina.getTurmas().size()+"\n");
				for (int k=0; k< disciplina.getTurmas().size(); k++){
					Turma t = disciplina.getTurmas().get(k);
					gravador.write(t.getNumero()+"\n");
				}
			}
		} finally {
			if (gravador!=null){
				gravador.close();
			}
		}		
	}


	public void carregarTurmasDeDisciplinasEmArquivo(String nomeArquivo) throws IOException, DisciplinaInexistenteException,TurmaJaExisteException {
		BufferedReader leitor = null;
		try{
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String codigoDisciplina = null;
			do{
				codigoDisciplina = leitor.readLine();
				if(codigoDisciplina != null){
					String numTurmasStr = leitor.readLine();
					int numTurma = Integer.parseInt(numTurmasStr);
					for(int k = 0; k<numTurma;k++){
						String numTurmaStr = leitor.readLine();
						int t = Integer.parseInt(numTurmaStr);
						this.adicionaTurma(codigoDisciplina, t);
					}
				}
			} while(codigoDisciplina != null);
				

			
		} finally {
			if (leitor!=null){
				leitor.close();
			}
		}		
	}
	
	public void imprimeProfessoresEDisciplinas(){
		for(Professor p: professores){
			System.out.println(p.toString());
		}
		
		for(Disciplina d: disciplinas){
			System.out.println(d.toString());
		}
	}
	
	public void gravaInteressesDeProfessoresPorDisciplinasEmArquivo(String nomeArquivo) throws  IOException{
		BufferedWriter gravador = null;
		try{
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for (int k = 0;k < professores.size();k++){
				gravador.write(professores.get(k).getMatricula()+"\n");
				gravador.write(professores.get(k).getTextoPreferenciasDisciplinasComCodigo()+"\n");
			}
		} finally {
			if (gravador!=null){
				gravador.close();
			}
		}		
	}

	public void carregaInteressesDeProfessoresPorDisciplinasDeArquivo(String nomeArquivo) throws PreferenciaInvalidaException, ProfessorInexistenteException, DisciplinaInexistenteException, IOException{
 		BufferedReader leitor = null;
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String matricula = leitor.readLine();
			
			do {
				
				String linhaCod1 = leitor.readLine(); // lê a próxima linha do arquivo, preferencias 1
				List<String> codDisciplinasP1 = new LinkedList<String>();
				codDisciplinasP1.addAll(leListaDeCodigosDeDisciplinasDeLinha(linhaCod1));
				if(codDisciplinasP1.size() > 0){
					for(String cd: codDisciplinasP1){
						cadastraNivelDeInteresseDeProfessorPorDisciplina(matricula,cd,Professor.PREF_P1);
					}
				}
				String linhaCod2 = leitor.readLine(); // lê a próxima linha do arquivo, preferencias 2
				List<String> codDisciplinasP2 = new LinkedList<String>();
				codDisciplinasP2.addAll(leListaDeCodigosDeDisciplinasDeLinha(linhaCod2));
				if(codDisciplinasP2.size() > 0){
					for(String cd: codDisciplinasP2){
						cadastraNivelDeInteresseDeProfessorPorDisciplina(matricula,cd,Professor.PREF_P2);
					}
				}
				String linhaCod3 = leitor.readLine(); // lê a próxima linha do arquivo, preferencias 3
				List<String> codDisciplinasP3 = new LinkedList<String>();
				codDisciplinasP3.addAll(leListaDeCodigosDeDisciplinasDeLinha(linhaCod3));
				if(codDisciplinasP3.size() > 0){
					for(String cd: codDisciplinasP3){
						cadastraNivelDeInteresseDeProfessorPorDisciplina(matricula,cd,Professor.PREF_P3);
					}
				}
				String linhaCod4 = leitor.readLine(); // lê a próxima linha do arquivo, preferencias 4
				List<String> codDisciplinasNP = new LinkedList<String>();
				codDisciplinasNP.addAll(leListaDeCodigosDeDisciplinasDeLinha(linhaCod4));
				if(codDisciplinasNP.size() > 0){
					for(String cd: codDisciplinasNP){
						cadastraNivelDeInteresseDeProfessorPorDisciplina(matricula,cd,Professor.PREF_NP);
					}
				}
				matricula = leitor.readLine(); // lê a próxima linha do arquivo, cod do professor
			} while(matricula != null); //vai ser null quando chegar no fim do arquivo
		} finally {
			if (leitor!=null){
				leitor.close();
			}
		}	
 	}
	
	private List <String> leListaDeCodigosDeDisciplinasDeLinha(String linha){
		List <String> codigos = new LinkedList<String>();
		StringTokenizer tokenizer = new StringTokenizer(linha,":");
		String nivelPreferencia = tokenizer.nextToken();//parte antes dos :
		if (tokenizer.hasMoreTokens()){ // Se tiver algo depois dos :
			String listaCodigos = tokenizer.nextToken(); // parte depois dos :
			System.out.println("listaCodigos:"+listaCodigos);
			StringTokenizer tokenizerVirgula = new StringTokenizer(listaCodigos,",");
			while (tokenizerVirgula.hasMoreTokens()){
				String codigo = tokenizerVirgula.nextToken();
				codigos.add(codigo);
			}
		}
		return codigos;
	}
	
	public Turma pesquisaTurma(String codDisciplina, int numTurma) throws DisciplinaInexistenteException, TurmaInexistenteException{
		
		Disciplina d = this.pesquisaDisciplina(codDisciplina);
		for(Turma t: d.getTurmas()){
			if(t.getNumero() == numTurma){
				return t;
			}
		}
		
		throw new TurmaInexistenteException("Turma não existe:");
		
	}
	
	public void cadastraHorarioTurma(String codDisciplina, int numTurma,String dia, int horaInicio, int horaFim) throws DisciplinaInexistenteException, TurmaInexistenteException {
		
		Turma t = this.pesquisaTurma(codDisciplina, numTurma);
		Horario horario = new Horario(dia, horaInicio, horaFim);
		t.adicionarHorario(horario);
		
	}

	public void alocaProfessorATurma(String codDisciplina, int numTurma, String matriculaProf) throws DisciplinaInexistenteException,TurmaInexistenteException, ProfessorInexistenteException {
		
		Turma t = this.pesquisaTurma(codDisciplina, numTurma);
		Professor p = this.pesquisaProfessorPelaMatricula(matriculaProf);
		p.alocaTurma(t);
		t.setProfessor(p);
		
	}

	public void desalocaProfessorDeTurma(String codDisciplina, int numTurma, String matriculaProf) throws DisciplinaInexistenteException, TurmaInexistenteException, ProfessorInexistenteException {
		
		Turma t = this.pesquisaTurma(codDisciplina, numTurma);
		Professor p = this.pesquisaProfessorPelaMatricula(matriculaProf);
		p.desalocaTurma(t);
		t.setProfessor(null);
		
	}

	public List<Horario> pesquisaHorariosProfessor(String matriculaProf) throws ProfessorInexistenteException {
		
		Professor p = this.pesquisaProfessorPelaMatricula(matriculaProf);
		return p.getHorarios();
	}
		
	
	public List<Turma> pesquisaTurmasDoProfessor(String matriculaProf) throws ProfessorInexistenteException {
		
		Professor p = this.pesquisaProfessorPelaMatricula(matriculaProf);
		return p.getTurmasAlocado();
		
	}

	public List<Disciplina> pesquisaDisciplinasDoProfessor(String matriculaProf) throws ProfessorInexistenteException {
		
		Professor p = this.pesquisaProfessorPelaMatricula(matriculaProf);
		return p.getDisciplinasAlocado();
		
	}
}

