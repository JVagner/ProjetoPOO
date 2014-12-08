import static org.junit.Assert.*;

import org.junit.Test;


public class QuestaoTest {

	@Test
	public void test() {
		Resposta r = new Resposta(1,"Indefinido", TipoDeQuestaoEResposta.DISSERTATIVA);
		assertEquals(TipoDeQuestaoEResposta.DISSERTATIVA,r.getTipo());
		Questao q = new Questao(1,"Qual a diferença?", r);
		if(q.getNumQuestao() == 1){
			assertTrue(q.getResposta().getNumResposta() == 1);
		}
	}

}
