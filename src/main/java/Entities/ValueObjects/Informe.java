package Entities.ValueObjects;

public class Informe {
    int resultado;  //0 positivo, 1 negativo.
    String comentario;
    String muestraId;

    public Informe(int resultado, String comentario, String muestraId) {
        this.resultado = resultado;
        this.comentario = comentario;
        this.muestraId = muestraId;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getMuestraId() {
        return muestraId;
    }

    public void setMuestraId(String muestraId) {
        this.muestraId = muestraId;
    }
}
