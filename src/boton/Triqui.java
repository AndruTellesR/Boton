/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boton;

/**
 *
 * @author ACER
 */
public class Triqui {

    private static String marca;
    private final String ficha1 = "X";
    private final String ficha2 = "O";
    private String[][] fichas = new String[3][3];

    /**
     * Constructor for objects of class Triqui
     */
    public Triqui() {
        // initialise instance variables
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                fichas[i][j] = "";
            }

        }
        marca = "O";
    }

    public String getMarca() {
        if (this.marca.equals(ficha1)) {
            this.marca = ficha2;
        } else {
            this.marca = ficha1;
        }
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String buscarGanador() {
        for (int i = 0; i < 3; i++) {
            String tmp = fichas[i][0];
            int c = 1;
            boolean flag = true;
            if (tmp != "") {
                for (int j = 1; j < 3 && flag; j++) {
                    if (tmp.equals(fichas[i][j])) {
                        c++;
                        if (c == 3) {
                            return "Ha ganado el jugador con la ficha: " + tmp;
                        }
                    } else {
                        flag = false;
                    }
                }
            }

        }
        for (int i = 0; i < 3; i++) {
            String tmp = fichas[0][i];
            int c = 1;
            boolean flag = true;
            if (tmp != "") {
                for (int j = 1; j < 3 && flag; j++) {
                    if (tmp.equals(fichas[j][i])) {
                        c++;
                        if (c == 3) {
                            return "Ha ganado el jugador con la ficha: " + tmp;
                        }
                    } else {
                        flag = false;
                    }
                }
            }

        }
        String tmp=fichas[1][1];
        if(tmp!=null){
        if((fichas[0][0].equals(tmp) && fichas[2][2].equals(tmp)) || (fichas[0][2].equals(tmp) && fichas[2][0].equals(tmp)) ){
        return "Ha ganado el jugador con la ficha: " + tmp;
        }
        }
        return "";
    }

    public String marcar(int i, int j) {
        this.fichas[i][j] = this.marca;
        return buscarGanador();
    }

}
