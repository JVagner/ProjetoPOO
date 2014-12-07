import static org.junit.Assert.*;

import org.junit.Test;


public class ProfessorTest {

	@Test
	public void test() {

		Professor p1 = new Professor("Carlos", "01", "carlos@dce.ufpb.br");
		assertTrue(p1.getNome().equals("Carlos"));
		p1.setNome("carlos");
		assertEquals(p1.getNome(), "carlos");
		
	}

}
