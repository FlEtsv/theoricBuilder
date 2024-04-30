/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.util.List;

/**
 * clase Pregunta representa como objetos los datos de nuestro csv
 * @author steve
 */
public class Pregunta {
    private String pregunta;
    private List<String> respuestas;
    private String respuestaCorrecta;
    
    public Pregunta(){
    }

    public String getPregunta() {
        return pregunta;
    }

    public Pregunta setPregunta(String pregunta) {
        this.pregunta = pregunta;
        return this;
    }

    public List<String> getRespuestas() {
        return respuestas;
    }

    public Pregunta setRespuestas(List<String> respuestas) {
        this.respuestas = respuestas;
        return this;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public Pregunta setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
        return this;
    }
    /**
     * nos devuelve un valor boolean segun las instancias validas o no
     * @return 
     */
    public boolean isValide(){
        boolean resultado = false;
        if(this != null){
            if(!pregunta.isEmpty() && !respuestaCorrecta.isEmpty()){
                for(String respuesta : respuestas){
                    resultado = (!respuesta.isEmpty());
                    if(!resultado){
                        break;
                    }
                }
            }
        }
        return resultado;
    }
    
}
