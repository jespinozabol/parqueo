/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Tiquete {
    private final Lugar campo;
    private final Date hingreso;
    private Date hsalida;
    private Double horas;
    private final int precio;
    private final int id;
    private boolean Estado;
    private Double PrecioFinal;
    private final DateFormat formato;

    public Tiquete(int id, Lugar campo, int precio) {
        this.hsalida = null;
        this.precio = precio;
        this.Estado = false;
        this.PrecioFinal = 0.0;
        this.formato = new SimpleDateFormat("HH:mm:ss");
        this.campo = campo.getCampo();
        this.hingreso = campo.getCliente().getIngreso();
        this.horas = 0.0;
        this.id = id;
    }

    public Lugar getCampo() {
        return campo;
    }

    public Date gethingreso() {
        return hingreso;
    }

    public Date gethsalida() {
        return hsalida;
    }

    public void sethora(Date hora) {
        this.hsalida = hora;
        this.horas = ((((double) ((hora.getHours()*60)+hora.getMinutes()))-((double) ((hingreso.getHours()*60)+hingreso.getMinutes())))/60);
        this.PrecioFinal = precio * (horas < 1 ? 1 : horas);
        this.Estado = true;
    }

    public double gethora() {
        return horas < 1 ? 1 : horas;
    }

    public int getPrecio() {
        return precio;
    }

    public int getId() {
        return id;
    }

    public boolean isEstado() {
        return Estado;
    }

    public String getFormatohingreso() {
        return formato.format(hingreso);
    }
    
    public String getFormatohsalida() {
        return formato.format(hsalida);
    }

    public Double getPrecioFinal() {
        return PrecioFinal;
    }
}
