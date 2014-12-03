import java.util.ArrayList;
import java.util.List;


public class Disciplina {

	private String nome;
	private String codigo;
	private List<Turma> turmas =new ArrayList<Turma>(); 
	
	public Disciplina(String nome, String codigo){
		this.nome = nome;
		this.codigo = codigo;
	}
	public String getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Turma> getTurmas() {
		return this.turmas;
	}

	public void adicionaTurma(int numero) throws TurmaJaExisteException {
		for (Turma t: this.turmas){
			if (t.getNumero() == numero){
				throw new TurmaJaExisteException("Já existe a turma de número:"+numero);
			}
		}
		//Caso não lance a exceção, ele adiciona a nova turma assim:
		Turma t = new Turma(this, numero);
		this.turmas.add(t);
	}
	
	public void removeTurma(int numero){
		for (Turma t: this.turmas){
			if (t.getNumero() == numero){
				this.turmas.remove(t);
				break;
			}
		}
	}
	
	public String toString(){
		String txt = this.getNome() + this.getCodigo();
		for(Turma t : turmas){
			txt += t.toString();
		}
		return txt;
	}
	
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
