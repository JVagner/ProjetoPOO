
public class Professor extends Pessoa{

	public Professor(String nome, String matricula, String email) {
		super(nome, matricula, email);
	}

	public String getDescricao(){
		return "Nome: " + super.getNome() + "; Matricula: " + super.getMatricula() + "; Email: " + super.getEmail();
	}
	
}
