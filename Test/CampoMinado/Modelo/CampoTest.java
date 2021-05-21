package CampoMinado.Modelo;

import CampoMinado.Exececao.ExplosaoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampoTest {

    Campo campo= new Campo(3,3);



    @Test
    void testarVizinhoDistancia1Esquerda(){
        Campo vizinho = new Campo(2,3);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testarVizinhoDistancia1Direita(){
        Campo vizinho = new Campo(4,3);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testarVizinhoDistancia1Cima(){
        Campo vizinho = new Campo(3,4);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }
   @Test
    void testarVizinhoDistancia1Baixo(){
        Campo vizinho = new Campo(3,2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }
   @Test
    void testarVizinhoDistancia2CimaDireita(){
        Campo vizinho = new Campo(4,4);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }
    @Test
    void testarVizinhoDistancia2CimaEsquerda(){
        Campo vizinho = new Campo(2,4);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }
    @Test
    void testarVizinhoDistancia2BaixoDireita(){
        Campo vizinho = new Campo(4,2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }
    @Test
    void testarVizinhoDistancia2BaixoEsquerda(){
        Campo vizinho = new Campo(2,2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }
    @Test
    void testarNaoVizinho(){
        Campo vizinho = new Campo(6,6);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertFalse(resultado);
    }

    @Test
    void testeAlternarMarcacao(){
       campo.alternarMarcaçao();
       assertTrue(campo.isMarcado());

    }
    @Test
    void testeValorPadraoMarcacao(){
       assertFalse(campo.isMarcado());

    }
    @Test
    void abrirNaoMinadoNaoMarcado(){
       boolean r = campo.abrir();
        assertTrue(r);
    }
    @Test
    void abrirNaoMinadoMarcado(){
        campo.alternarMarcaçao();
       boolean r = campo.abrir();
        assertFalse(r);
    }
     @Test
    void abrirMinadoMarcado(){
        campo.minar();
        campo.alternarMarcaçao();
       boolean r = campo.abrir();
        assertFalse(r);
    }
     @Test
    void abrirMinadoNaoMarcado(){
        campo.minar();
        assertThrows(ExplosaoException.class, () -> campo.abrir());
    }
    @Test
    void testeAbirComVizinhos(){
        Campo campo22 = new Campo(2,2);
        Campo campo12 = new Campo(1,2);
        campo12.minar();
        Campo campo11 = new Campo(1,1);
        campo22.adicionarVizinho(campo11);
        campo22.adicionarVizinho(campo12);
        campo.adicionarVizinho(campo22);

        campo.abrir();

        assertTrue(campo22.isAberto() && !campo11.isAberto());

    }

}