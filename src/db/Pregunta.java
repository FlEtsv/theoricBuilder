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
class Pregunta {
    private String pregunta;
    private List<String> respuestas;
    private String respuestaCorrecta;
    
    public Pregunta(String pregunta, List<String> respuestas, String respuestaCorrecta){
    this.pregunta = pregunta;
    this.respuestas = respuestas;
    this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public List<String> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<String> respuestas) {
        this.respuestas = respuestas;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
}
