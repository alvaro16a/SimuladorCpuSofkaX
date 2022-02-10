package SimuladorCPU;

public class contadorPrograma {
    private int siguienteInstruccion;
    private int contadorDeInstrucciones;

    public contadorPrograma(){
        this.siguienteInstruccion=0;
        this.contadorDeInstrucciones=0;
    }

    public int getSiguienteInstruccion() {
        this.siguienteInstruccion++;
        return siguienteInstruccion-1;
    }
    
    public int getInstruccion()
    {
        return this.siguienteInstruccion;
    }

    public int getContadorDeInstrucciones() {
        return contadorDeInstrucciones;
    }

    public void setSiguienteInstruccion(int siguienteInstruccion) {
        this.siguienteInstruccion = siguienteInstruccion;
    }
    
    public boolean incrementarContador(){
        this.contadorDeInstrucciones++;
        if(this.contadorDeInstrucciones > 50000){
            return false;
        }
        return true;
    }
    
}
