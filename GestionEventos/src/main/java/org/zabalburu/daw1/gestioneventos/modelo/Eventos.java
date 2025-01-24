/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.gestioneventos.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author DAW1
 */
@Getter
@Setter

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Eventos {
    private static int numEventos = 0;
    @EqualsAndHashCode.Include
    private int idEvento;
    private String descripcion;
    private Date fechaEvento;
    private String lugar;
    private boolean mayorEdad;
    private double coste;
    private List<Personas> asistentes = new ArrayList<>();

    public Eventos() {
        Eventos.numEventos++;
        this.idEvento = Eventos.numEventos;
    }

    public Eventos(String descripcion, Date fechaEvento, String lugar, boolean mayorEdad, double coste) {
        this();
        this.descripcion = descripcion;
        this.fechaEvento = fechaEvento;
        this.lugar = lugar;
        this.mayorEdad = mayorEdad;
        this.coste = coste;
    }

    @Override
    public String toString() {
        return "Eventos{" + "idEvento=" + idEvento + ", descripcion=" + descripcion + ", fechaEvento=" + fechaEvento + ", lugar=" + lugar + ", mayorEdad=" + mayorEdad + ", coste=" + coste + ", asistentes=" + asistentes + '}';
    }
    
    
    
}
