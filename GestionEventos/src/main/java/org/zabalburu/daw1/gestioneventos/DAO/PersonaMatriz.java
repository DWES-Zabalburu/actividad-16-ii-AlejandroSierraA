/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.gestioneventos.DAO;

import java.util.ArrayList;
import java.util.List;
import org.zabalburu.daw1.gestioneventos.modelo.Personas;

/**
 *
 * @author DAW1
 */
public class PersonaMatriz implements personasDAO{
        
    private static Personas[] persona = new Personas[100];
    private static int numPersonas = 0;
    
    @Override
    public Personas añadirPersonas(Personas nueva) {
        if(numPersonas < persona.length){
            persona[numPersonas] = nueva;
            numPersonas++;
        }
        return nueva;
    }

    @Override
    public void eliminarPersona(int id) {
        int i = buscarPosicionPersona(id);
        if(i != -1){
            for(i=i+1;i<numPersonas;i++){
                persona[i-1] = persona[i];
            }
            numPersonas--;
        }    
        
    }

    @Override
    public void modificarPersona(Personas modificar) {
        int pos = buscarPosicionPersona(modificar.getIdPersona());
        if(pos != -1){
            persona[pos] = modificar;
        }
    }

    @Override
    public List<Personas> getPersonas() {
        List<Personas> temp = new ArrayList<>();
        for(int i=0;i<numPersonas;i++){
            temp.add(persona[i]);
        }
        return temp;
    }

    @Override
    public Personas getPersona(int id) {
        int pos = buscarPosicionPersona(id);
        if(pos != -1){
            return persona[pos];
        }else{
            return null;
        }
    }

    @Override
    public Personas getPersonas(String dni) {
        int i;
        for(i=0;i<numPersonas &&
                !dni.equalsIgnoreCase(dni);i++);
        //es igual al if del metodo buscarPosicionPersona
        return (1 < numPersonas)?null:persona[i];
        
    }
    private int buscarPosicionPersona(int id){
         int i;
        for (i = 0; i < numPersonas &&
                id!= persona[i].getIdPersona(); i++);
        if(i < numPersonas){
            return i;
        }else{
            return -1;
        }
    } 
    
}
