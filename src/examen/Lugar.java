/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;


public class Lugar {
    
    private boolean Disponible;
    private Usuario cliente;
    private final int Numero;

    public Lugar(int Numero) {
        this.Numero = Numero;
        this.Disponible = true;
        this.cliente = null;
    }

    public int getNumero() {
        return Numero;
    }

    public boolean isDisponible() {
        return Disponible;
    }

    public void setDisponible(boolean Disponible) {
        this.Disponible = Disponible;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }
    
    public Lugar getCampo(){
        Lugar libre= new Lugar(this.getNumero());
        Usuario nuevo =new Usuario(this.getCliente().getMatricula(),this.getCliente().getDNI(),this.getCliente().getNombre());
        nuevo.setIngreso(this.getCliente().getIngreso());
       libre.setCliente(nuevo);
        libre.setDisponible(this.isDisponible());
        return libre;
    }
    
}
