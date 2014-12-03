import java.util.ArrayList;
import java.util.List;


public class Professor extends Pessoa{

	public static final int PREF_P1 = 1;
	public static final int PREF_P2 = 2;
	public static final int PREF_P3 = 3;
	public static final int PREF_NP = 4;
	private List<Disciplina> listaDisciplinasP1; //Disciplinas que o professor tem preferência máxima em ensinar
	private List<Disciplina> listaDisciplinasP2;//Disciplinas que o professor tem um nível P2 de preferência
	private List<Disciplina> listaDisciplinasP3;//Disciplinas que o professor tem um nível P3 de preferência
	private List<Disciplina> listaDisciplinasNP;//Disciplinas que o professor explicitou que não gostaria de ensinar
	private List < Turma >turmasAlocado;
	
	public Professor(String nome, String matricula){
		super(nome, matricula);
		this.listaDisciplinasNP = new ArrayList<Disciplina>();
		this.listaDisciplinasP1 = new ArrayList<Disciplina>();
		this.listaDisciplinasP2 = new ArrayList<Disciplina>();
		this.listaDisciplinasP3 = new ArrayList<Disciplina>();
		this.turmasAlocado = new ArrayList< Turma >();
	}
	
	public Professor(){
		super("Sem nome","Sem Matricula");
	}
	
	public String getDescricao(){
		return "Nome: "+ super.getNome()+" Matricula: " + super.getMatricula(); 
	}
	
	public void adicionaPreferenciaDisciplina(Disciplina d, int nivelPreferencia) throws PreferenciaInvalidaException{
		
		if(nivelPreferencia == PREF_P1){
			listaDisciplinasP1.add(d);
		}
		
		else if(nivelPreferencia == PREF_P2){
			listaDisciplinasP2.add(d);
		}
		
		else if(nivelPreferencia == PREF_P3){
			listaDisciplinasP3.add(d);
		}
		
		else if(nivelPreferencia == PREF_NP){
			listaDisciplinasNP.add(d);
		}
		
		else{
			throw new PreferenciaInvalidaException("A preferencia passada é invalida");
		}
				
	}
	
	public List<Disciplina> getDisciplinasPreferidasComNivel(int nivelPreferencia) throws PreferenciaInvalidaException{
		
		if(nivelPreferencia == PREF_P1){
			return listaDisciplinasP1;
		}
		
		else if(nivelPreferencia == PREF_P2){
			return listaDisciplinasP2;
		}
		
		else if(nivelPreferencia == PREF_P3){
			return listaDisciplinasP3;
		}
		
		else if(nivelPreferencia == PREF_NP){
			return listaDisciplinasNP;
		}
		
		else{
			throw new PreferenciaInvalidaException("A preferencia passada é invalida");
		}
	}
	
	public String toString(){
		String txt = getDescricao()+"\n";
		txt+="Disciplinas P1:"+getListaNomesDisciplinas(this.listaDisciplinasP1);		
		txt+="\nDisciplinas P2:"+getListaNomesDisciplinas(this.listaDisciplinasP2);
		txt+="\nDisciplinas P3:"+getListaNomesDisciplinas(this.listaDisciplinasP3);
		txt+="\nDisciplinas NP:"+getListaNomesDisciplinas(this.listaDisciplinasNP);
		return txt;
	}
	
	public String getListaNomesDisciplinas(List < Disciplina > lista){
		String listaNomes="";
		for (int k=0; k< lista.size(); k++){
			Disciplina d  = lista.get(k);
			listaNomes+= d.getNome();
			if (k!= lista.size()-1){
				listaNomes+=",";
			}
		}
		return listaNomes;
	}
	
	public String getTextoPreferenciasDisciplinasComCodigo(){
		String txt = "";
		txt += "P1:" + this.getListaCodigosDisciplinas(listaDisciplinasP1);
		txt += "\nP2:" + this.getListaCodigosDisciplinas(listaDisciplinasP2);
		txt += "\nP3:" + this.getListaCodigosDisciplinas(listaDisciplinasP3);
		txt += "\nNP:" + this.getListaCodigosDisciplinas(listaDisciplinasNP);
		return txt;
	}
	
	public String getListaCodigosDisciplinas(List < Disciplina > lista){
		String listaCodigos="";
		for (int k=0; k< lista.size(); k++){
			Disciplina d  = lista.get(k);
			listaCodigos+= d.getCodigo();
			if (k!= lista.size()-1){
				listaCodigos+=",";
			}
		}
		return listaCodigos;
	}
	
	public  void alocaTurma(Turma t){
		turmasAlocado.add(t);
	}
	
	public void desalocaTurma(Turma t){		
		turmasAlocado.remove(t);
	}
	
	public List < Turma > getTurmasAlocado(){
		List< Turma > turmasA = new ArrayList< Turma >();
		for(Turma t: turmasAlocado){
			turmasA.add(t);
		}
		return turmasA;
	}
	
	public List < Disciplina > getDisciplinasAlocado(){
		List < Disciplina > disciplinasA = new ArrayList < Disciplina>();
		for(Turma t: turmasAlocado){
			Disciplina disciplina = t.getDisciplina();
			if(!disciplinasA.equals(disciplina)){
				disciplinasA.add(disciplina);	
			}
		}
		return disciplinasA;
	}
	
	public List < Horario > getHorarios(){
		List< Horario > horarios = new ArrayList< Horario >();
		for(Turma t: this.getTurmasAlocado()){
			horarios.addAll(t.getHorarios());
		}
		return horarios;
		
	}
}
