package CampoMinado.Modelo;

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


}