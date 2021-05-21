package CampoMinado.Modelo;

import CampoMinado.Exececao.ExplosaoException;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {

    private int linhas;
    private int colunas;
    private int minas;

    private final List<Campo> campos = new ArrayList<>();

    public Tabuleiro(int linhas, int colunas, int minas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.minas = minas;
        
        gerarCampos();
        associarVizinhos();
        sortearMinas();
    }

    public void abrir(int linhas , int colunas){
        try{
            campos.stream()
                    .filter(c -> c.getLinha() == linhas && c.getColuna() == colunas)
                    .findFirst()
                    .ifPresent(Campo::abrir);
        }catch (ExplosaoException e){
            campos.forEach(c -> c.setAberto(true));
            throw e;
        }
    }
     public void alternarMarcacao(int linhas , int colunas){
        campos.stream()
                .filter(c -> c.getLinha() == linhas && c.getColuna() == colunas)
                .findFirst()
                .ifPresent(Campo::alternarMarcaçao);
    }


    private void gerarCampos() {
        for (int l = 0; l < linhas; l++) {
            for (int c = 0; c < colunas ; c++) {
                campos.add(new Campo(l,c));
            }
        }

    }

    private void associarVizinhos() {
        for(Campo c1 : campos){
            for (Campo c2 : campos){
                c1.adicionarVizinho(c2);
            }
        }
    }

    private void sortearMinas() {
        long minasArmadas = 0;
        do{
            int aleatorio = (int) (Math.random()*campos.size());
            campos.get(aleatorio).minar();
            minasArmadas = campos.stream().filter(c -> c.isMinado()).count();
        }while(minasArmadas<minas);
    }

    public boolean objetivoAlcancado(){
        return campos.stream().allMatch(c -> c.objetivoAlcancado());
    }

    public void reiniciar(){
        campos.stream().forEach(c -> c.reiniciar());
        sortearMinas();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("  ");
        for (int i = 0; i <colunas ; i++) {
            sb.append(" ");
            sb.append(i);
            sb.append("_");
        }
            sb.append("\n");
        
        int i = 0;
        for (int l = 0; l < linhas ; l++) {
            sb.append(" ");
            sb.append(l+"|");

            for (int c = 0; c < colunas ; c++) {
                sb.append(" ");
                sb.append(campos.get(i));
                sb.append(" ");
                i++;
            }
            sb.append("\n");
        }


        return sb.toString();
    }

}
