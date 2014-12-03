import java.util.ArrayList;
import java.util.List;


public class Turma {

	private int numero;
	private Disciplina disciplina;
	private Professor professor;
	private List < Horario > horarios;
	
	public Turma(Disciplina disciplina, int numero){
		this.numero = numero;
		this.disciplina = disciplina;
		this.professor = null;
		this.horarios = new ArrayList< Horario >();
		
	}
	
	public int getNumero(){
		return this.numero;
	}
	
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public void setNumero(int numero){
		this.numero = numero;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public String toString(){
		String txt = "numero" + this.numero;	
		return txt;
	}
	
	public void adicionarHorario(Horario horario){
		horarios.add(horario);			
	}
	
	public boolean equals(Object obj) {
		
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (disciplina.getCodigo() == null) {
			if (other.disciplina.getCodigo() != null)
				return false;
		} else if (!disciplina.getCodigo().equals(other.disciplina.getCodigo())){
			return false;
		}
		if(disciplina.getCodigo().equals(other.disciplina.getCodigo())){
			if(numero == other.numero){
				return true;
			}
		}
		return false;
		
	}
	
	
}
