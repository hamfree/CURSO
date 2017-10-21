/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paq1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class Mastermind {

    private static final int NUMERO_DIGITOS = 3;
    private String numeroSecreto;
    private List<String> intentos = new ArrayList<>();

    public Mastermind() {

    }

    public void iniciarJuego() {
        //generamos un numero en el que no haya un digito repetido
        int[] digitos = new int[NUMERO_DIGITOS];

        while (true) {
            digitos[0] = (int) (Math.random() * 10);
            if (digitos[0] != 0) {
                break;
            }
        }
        for (int i = 1; i < digitos.length; i++) {
            digitos[i] = (int) (Math.random() * 10);
            for (int j = 0; j < i; j++) {
                if (digitos[j] == digitos[i]) {
                    i--;
                    break;
                }
            }
        }
        setNumeroSecreto("");
        for (int i = 0; i < digitos.length; i++) {
            setNumeroSecreto(getNumeroSecreto() + digitos[i]);
        }
        System.out.println(getNumeroSecreto());
    }

    // devuelve una cadena con los muertos y heridos
    public String adivinar(String numeroCandidato) {
        String retorno = null;
        if (!isNumeroValido(numeroCandidato)) {
            retorno = numeroCandidato
                    + ": Numero introducido invalido. Intenta otro.";
        } else {

            int muertos = 0;
            int heridos = 0;

            for (int i = 0; i < NUMERO_DIGITOS; i++) {
                for (int j = 0; j < NUMERO_DIGITOS; j++) {
                    if (getNumeroSecreto().charAt(i) == numeroCandidato.charAt(j)) {
                        if (i == j) {
                            // muertos
                            muertos++;
                        } else {
                            // heridos
                            heridos++;
                        }
                    }
                }
            }// fin for i

            if (muertos == NUMERO_DIGITOS) {
                retorno = numeroCandidato + ": ACERTASTE. Intentos: " + getIntentos().size();
            } else {
                retorno = numeroCandidato + ": Muertos: " + muertos + ", Heridos: " + heridos;
            }
        }
        getIntentos().add(retorno);
        return retorno;
    }

    // Numero valido: 102 < x < 987 , y sin digitos repetidos
    private boolean isNumeroValido(String aux) {

        boolean retorno = true;

        if (aux.length() != NUMERO_DIGITOS) {
            retorno = false;
        } else if (aux.charAt(0) == '0') {
            retorno = false;
        } else {

            fin:
            for (int i = 0; i < aux.length() - 1; i++) {
                for (int j = i + 1; j < aux.length(); j++) {
                    if (aux.charAt(i) == aux.charAt(j)) {
                        // numeros repes
                        retorno = false;
                        break fin;
                    }
                }
            }
        }
        return retorno;
    }

    /**
     * @return the numeroSecreto
     */
    public String getNumeroSecreto() {
        return numeroSecreto;
    }

    /**
     * @param numeroSecreto the numeroSecreto to set
     */
    public void setNumeroSecreto(String numeroSecreto) {
        this.numeroSecreto = numeroSecreto;
    }

    /**
     * @return the intentos
     */
    public List<String> getIntentos() {
        return intentos;
    }

}
