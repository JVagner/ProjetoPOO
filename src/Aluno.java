
public class Aluno extends Pessoa{

	public Aluno(String nome, String matricula, String email) {
		super(nome, matricula, email);
	}
	
	public String getDescricao(){
		return "Nome: " + super.getNome() + "; Matricula: " + super.getMatricula() + "; Email: " + super.getEmail();
	}
	

}
