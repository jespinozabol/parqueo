/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Manager {
    private final ArrayList<Lugar> Campos;
    private int CamposLibres;
    private int Precio;
    private final ArrayList<Tiquete> Boletas;
    private final int[] IngresosporHora;
    private final int[] SalidasHora;
    private final int[] EntradasHora;
    private double IngresoTotal;
    private int totalEspacios;
    public Manager(int espacios) {
        totalEspacios = espacios*espacios;//Integer.parseInt(prop.getProperty("pisos"))* Integer.parseInt(prop.getProperty("espacios"));
        this.Campos = new ArrayList<>();
        for (int i = 0; i < totalEspacios; i++) {
            Campos.add(new Lugar(i));
        }
        this.CamposLibres = Libres();
        this.IngresoTotal = 0.0;
        this.IngresosporHora = new int[24];
        this.SalidasHora = new int[24];
        this.EntradasHora = new int[24];
        for (int i = 0; i < IngresosporHora.length; i++) {
            IngresosporHora[i]=0;
        }
        this.Boletas = new ArrayList<>();
    }
    
    public final int Libres(){
        int disponible=0;
        for(int i = 0; i <totalEspacios; i++)
        {
            if (Campos.get(i).isDisponible())
            {
                disponible++;
            }            
        }
        
        if (((double)disponible/totalEspacios)>0.5) {
            Precio = 800;
        }else if(((double)disponible/totalEspacios)<0.25){
            Precio = 1500;
        }else{
            Precio = 1000;
        }
        return disponible;
    }

    public boolean OcuparCampo(int nc,Usuario cliente){
        for (Lugar campo : Campos) {
            if(campo.isDisponible()&&nc==campo.getNumero()){
                campo.setDisponible(false);
                campo.setCliente(cliente);
                agregarBoleta(campo, Precio);
                return true;
            }
        }
        return false;
    }
    
    public Tiquete LiberarCampo(int nc,int hora,int minutos){
        for (Lugar campo : Campos) {
            if(!campo.isDisponible()&&nc==campo.getNumero()){
                Tiquete tiquet = Pagar(nc,hora,minutos);
                campo.setDisponible(true);
                campo.setCliente(null);
                return tiquet;
            }
        }
        return null;
    }
    
    public Tiquete Pagar(int nc,int hor,int minutos){
        for (Tiquete boleta : Boletas) {
            if (!boleta.isEstado()&&boleta.getCampo().getNumero()==nc) {
                boleta.sethora(new GregorianCalendar(2017,07,1,hor,minutos,0).getTime());
                IngresoTotal += boleta.getPrecioFinal();
                int hora =Integer.valueOf(boleta.getFormatohsalida().split(":")[0]);
                IngresosporHora[hora] += boleta.getPrecioFinal();
                SalidasHora[hora] += 1;
                return boleta;
            }
        }
        return null;
    }
     
    public void agregarBoleta(Lugar campo, int precio){
        Tiquete boleta = new Tiquete(Boletas.size(),campo,precio);
        int hora =Integer.valueOf(boleta.getFormatohingreso().split(":")[0]);
        EntradasHora[hora] += 1;
        Boletas.add(boleta);
    }

    public double getTotalIngresos() {
        return IngresoTotal;
    }

    public int[] getIngresosporHora() {
        return IngresosporHora;
    }
    
    public int getCamposLibres() {
        this.CamposLibres = Libres();
        return CamposLibres;
    }

    public int getPrecio() {
        return Precio;
    }

    public int[] getSalidasHora() {
        return SalidasHora;
    }

    public int[] getEntradasHora() {
        return EntradasHora;
    }
}
