/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.util.Date;
import java.util.GregorianCalendar;

public class Usuario {
    private String Matricula;
    private Date Ingreso;
    private String DNI;
    private String Nombre;

    public Usuario(String Placa, String DNI, String Nombre,int hora,int minutos) {
        this.Matricula = Placa;
        this.Ingreso = new GregorianCalendar(2017,07,1,hora,minutos,0).getTime();
        this.DNI = DNI;
        this.Nombre = Nombre;
    }
    
    public Usuario(String Placa, String DNI, String Nombre) {
        this.Matricula = Placa;
        this.Ingreso = new Date();
        this.DNI = DNI;
        this.Nombre = Nombre;
    }
    
    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public Date getIngreso() {
        return Ingreso;
    }

    public void setIngreso(Date Ingreso) {
        this.Ingreso = Ingreso;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
}
