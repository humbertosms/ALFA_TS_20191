package teste;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.com.gilmar.Avaliacao;
import br.com.gilmar.ValoresInvalidosException;

@RunWith(Parameterized.class)
public class TesteUnitario {

	Avaliacao avaliacao;

	@Before
	public void setup() {
		avaliacao = new Avaliacao();
	}

//	@Test
//	public void testaNotaMenorQueZero() {
//		try {
//			String res = avaliacao.avalia(11d, 6d, 5d, 96d);
//		} catch (Exception e) {
//			Assert.assertTrue(e instanceof ValoresInvalidosException);
//		}
//	}

	@Parameters	
	public static Object[][] data() {
		return new Object[][] { {8.0, 7.0, 28, 96,Avaliacao.REPROVADO_POR_FALTA},
			    	  { 2.0, 3.0, 15, 96,Avaliacao.REPROVADO_POR_MEDIA },
			    	  { 4.0, 5.0, 15, 96,Avaliacao.PROVA_EXTRA},
			    	  { 7d, 8d, 15d, 96d ,Avaliacao.APROVADO},
			    	  { 7d, 8d, 15d, 96d ,Avaliacao.REPROVADO_POR_FALTA}};
	}

	@Parameter(0)
	public double p1;
	@Parameter(1)
	public double p2;
	@Parameter(2)
	public double p3;
	@Parameter(3)
	public double p4;
	@Parameter(4)
	public String expectativa;

	@Test
	public void testarComParametro() {
		try {
			String res = avaliacao.avalia(p1, p2, p3, p4);
			Assert.assertSame(expectativa, res);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof ValoresInvalidosException);
		}
	}

}
