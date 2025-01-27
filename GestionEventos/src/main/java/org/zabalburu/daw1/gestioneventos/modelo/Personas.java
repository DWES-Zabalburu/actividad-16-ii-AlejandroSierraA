/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.gestioneventos.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


/**
 *
 * @author DAW1
 */

public class Personas {
    private static int numpersonas = 0;
    
    private int idPersona;
    private String nombre;
    private String apellidos;
    private String dni;
    private String password;
    private Date fnacimiento;
    private List<Eventos> evento = new ArrayList<>();

    public Personas() {
        Personas.numpersonas++;
        this.idPersona = Personas.numpersonas;
    }

    public Personas(String nombre, String apellidos, String dni, String password, Date fnacimiento) {
        this();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.password = password;
        this.fnacimiento = fnacimiento;
    }
    
    
    
    
    public static int getNumpersonas() {
        return numpersonas;
    }

    public static void setNumpersonas(int numpersonas) {
        Personas.numpersonas = numpersonas;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    public List<Eventos> getEvento() {
        return evento;
    }

    public void setEvento(List<Eventos> evento) {
        this.evento = evento;
    }
    
    
    
    public boolean isMayor(){
        GregorianCalendar gcHoy = new GregorianCalendar();
        GregorianCalendar gcFechaNacimiento = new GregorianCalendar();
        gcFechaNacimiento.setTime(this.fnacimiento);
        int añoActual = gcHoy.get(Calendar.YEAR);
        int añoNacimiento = gcFechaNacimiento.get(Calendar.YEAR);
        int edad = añoActual - añoNacimiento;
        // si no ha cumplido el día actual será en el año MENOR respecto al día de su nacimiento
        if(gcHoy.get(Calendar.DAY_OF_YEAR)< gcFechaNacimiento.get(Calendar.DAY_OF_YEAR)){
            edad--;
        }
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "Personas{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", password=" + password + ", fnacimiento=" + fnacimiento + ", evento=" + evento + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personas other = (Personas) obj;
        return this.idPersona == other.idPersona;
    }
    
}
