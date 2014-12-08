
public class Resposta {

	private int numResposta;
	private String resposta;
	private TipoDeQuestaoEResposta tipo;
	
	public Resposta(int numResposta, String resposta,TipoDeQuestaoEResposta tipo){
		this.numResposta = numResposta;
		this.resposta = resposta;
		this.tipo = tipo;
	}

	public int getNumResposta() {
		return this.numResposta;
	}

	public void setNumResposta(int numResposta) {
		this.numResposta = numResposta;
	}

	public String getResposta() {
		return this.resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public TipoDeQuestaoEResposta getTipo() {
		return this.tipo;
	}

	public void setTipo(TipoDeQuestaoEResposta tipo) {
		this.tipo = tipo;
	}
	
	
}
