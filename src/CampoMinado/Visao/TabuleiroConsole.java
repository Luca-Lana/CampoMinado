package CampoMinado.Visao;

import CampoMinado.Exececao.ExplosaoException;
import CampoMinado.Exececao.SairException;
import CampoMinado.Modelo.Tabuleiro;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class TabuleiroConsole {

    private Tabuleiro tabuleiro;
    private Scanner teclado = new Scanner(System.in);


    public TabuleiroConsole(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        
        executarJogo();
    }

    private void executarJogo() {

        try{
            boolean continuar = true;
            while(continuar){
                cicloJogo();
                System.out.println("Quer outra partida (S/n)");
                String resposta = teclado.next();

                if(resposta.equalsIgnoreCase("n")){
                    continuar =false;
                } else{
                    tabuleiro.reiniciar();
                }
            }

        }catch (SairException e){
            System.out.println("FALOU AMIGÃO!!!");
        }finally {
            teclado.close();
        }

    }

    private void cicloJogo(){
        try{
            while (!tabuleiro.objetivoAlcancado()){
                System.out.println(tabuleiro);

                String digitado = capturarValorDigitado("DIGITE (X, Y)");
                Iterator<Integer> xy = Arrays.stream(digitado.split(","))
                        .map(e -> Integer.parseInt(e.trim())).iterator();
                digitado = capturarValorDigitado("1-Abri 2-(des)Marcar");

                if(digitado.equalsIgnoreCase("1")){
                    tabuleiro.abrir(xy.next(),xy.next());
                } else if(digitado.equalsIgnoreCase("2")){
                    tabuleiro.alternarMarcacao(xy.next(),xy.next());
                }

            }
            System.out.println("VOCE GANHOU!!");
        }catch (ExplosaoException e){
            System.out.println(tabuleiro);
            System.out.println("VOCE PERDEU!!");
        }
    }

    private String capturarValorDigitado(String texto) {
        System.out.print(texto);
        String digitado = teclado.next();
        if(digitado.equalsIgnoreCase("sair")){
            throw new SairException();
        }
        return digitado;
    }

}
