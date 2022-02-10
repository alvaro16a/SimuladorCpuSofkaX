package SimuladorCPU;

public class contadorPrograma {
    private int siguienteInstruccion;
    private int contadorDeInstrucciones;

    public contadorPrograma(){
        this.siguienteInstruccion=0;
        this.contadorDeInstrucciones=0;
    }
    
    public int getSiguienteInstruccion() {
        return siguienteInstruccion;
    }

    public int getContadorDeInstrucciones() {
        return contadorDeInstrucciones;
    }

    public void setSiguienteInstruccion(int siguienteInstruccion) {
        this.siguienteInstruccion = siguienteInstruccion;
    }

    public void incrementarContador(){
        this.contadorDeInstrucciones++;
    }
}
