import static org.junit.Assert.*;

import org.junit.Test;


public class PessoaTest {

	@Test
	public void test() {
		Pessoa p = new Pessoa("Jos�", "109","jose@dce");
		assertTrue(p.getMatricula().equals("109"));
		p.setMatricula("1");
		assertFalse(p.getMatricula().equals("109"));
		assertEquals("Jos�", p.getNome());
	}

}
