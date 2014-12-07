import static org.junit.Assert.*;

import org.junit.Test;


public class AlunoTest {

	@Test
	public void test() {
		Aluno a1 = new Aluno("João", "10","joao@dce");
		assertEquals("joao@dce", a1.getEmail());
		a1.setEmail("joao.leo@dce");
		a1.setEmail("joao.leo@dce.ufpb.br");
		assertFalse(a1.getMatricula().equals("joao.leo@dce"));
	}

}
