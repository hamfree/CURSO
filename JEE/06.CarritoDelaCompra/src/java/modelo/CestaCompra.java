package modelo;

import java.util.ArrayList;
import java.util.List;

public class CestaCompra {

    private List<Articulo> lista;
    private double valor;

    public CestaCompra() {
        lista = new ArrayList<>();
        valor = 0.0f;
    }

    public List<Articulo> getLista() {
        return lista;
    }

    public void setLista(List<Articulo> lista) {
        this.lista = lista;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void agregar(Articulo a) {
        if (a != null) {
            lista.add(a);
            valor = valor + a.getPrecio();
        }
    }
    
    public void limpiar(){
        setLista(null);
        lista = new ArrayList<>();
        valor = 0.0f;
    }

    @Override
    public String toString() {
        return "CestaCompra{" + "lista=" + lista + ", valor=" + valor + '}';
    }
    
    
}
