package br.com.gilmar;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AvaliacaoTeste {

    private Avaliacao avaliacao;

    @BeforeTest
    public void setup(){
        avaliacao = new Avaliacao();
    }
/*
    //CT01
    @Test
    public void testaQuantidadeParametrosMenorQuatro(){
        String resultado = avaliacao.avalia(7.0, 6.0, 5);
    }

    //CT02
    @Test
    public void testaQuantidadeParametrosMaiorQuatro(){
        String resultado = avaliacao.avalia(7.0, 6.0, 5, 96, 48);
    }
 */

    //CT03
    @Test
    public void testaNota1MenorZero(){
        try{
            String resultado = avaliacao.avalia(-7.0, 6.0, 5.0, 96.0);
        }catch (Exception e){
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }

    }

    //CT04
    @Test
    public void testaNota1MaiorDez(){
        try{
            String resultado = avaliacao.avalia(11.0, 6.0, 5.0, 96.0);
        }catch (Exception e){
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }

    }

    //CT05
    @Test
    public void testaNota2MenorZero(){
        try{
            String resultado = avaliacao.avalia(8.0, -1.0, 5.0,96.0);
        }catch (Exception e){
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }

    //CT06
    @Test
    public void testaNota2MaiorDez(){
        try{
            String resultado = avaliacao.avalia(8.0, 11.0, 5,96);
        }catch (Exception e){
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }

    //CT07
    @Test
    public void testaQuantidadeFaltasMenorZero(){
        try{
            String resultado = avaliacao.avalia(8.0, 7.0, -3,96);
        }catch (Exception e){
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }

    //CT08
    @Test
    public void testaQuantidadeFaltasMaiorCargaHoraria(){
        try{
            String resultado = avaliacao.avalia(8.0, 7.0, 97, 96);
        }catch (Exception e){
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }

    //CT09
    @Test
    public void testaCargaHorariaMenorZero(){
        try{
            String resultado = avaliacao.avalia(8.0, 7.0, 16, -1);
        }catch (Exception e){
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }

    //CT10
    @Test
    public void testaCargaHorariaMaior97(){
        try{
            String resultado = avaliacao.avalia(8.0, 7.0, 16, 97);
        }catch (Exception e){
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }

    //CT11
    @Test
    public void testaReprovacaoPorFalta(){
        try{
            String resultado = avaliacao.avalia(8.0, 7.0, 28, 96);
            Assert.assertTrue(resultado.equals("Reprovado por Falta."));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //CT12
    @Test
    public void testaReprovacaoPorMedia(){
        try{
            String resultado = avaliacao.avalia(2.0, 3.0, 15, 96);
            Assert.assertTrue(resultado.equals("Reprovado por Média."));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //CT13
    @Test
    public void testaSegundaChamada(){
        try{
            String resultado = avaliacao.avalia(4.0, 5.0, 15, 96);
            Assert.assertTrue(resultado.equals("Prova Extra."));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //CT14
    @Test
    public void testaAprovacao(){
        try{
            String resultado = avaliacao.avalia(7.0, 8.0, 15, 96);
            Assert.assertTrue(resultado.equals("Aprovado."));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
