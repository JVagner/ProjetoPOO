
public class Questao {

	private int numQuestao;
	private String pergunta;
	private Resposta resposta;
	
	public Questao(int numQuestao, String pergunta, Resposta resposta) {
		this.numQuestao = numQuestao;
		this.pergunta = pergunta;
		this.resposta = resposta;
	}

	public int getNumQuestao() {
		return numQuestao;
	}

	public void setNumQuestao(int numQuestao) {
		this.numQuestao = numQuestao;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public Resposta getResposta() {
		return resposta;
	}

	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}

}
