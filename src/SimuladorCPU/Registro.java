package SimuladorCPU;

public class Registro {
    private long valor;

    public void Registro(){
        this.valor = 0;
    }

    public long getValor() {
        return this.valor;
    }

    public void setValor(long valor) {
        if(valor > 4294967295L){
            this.valor=0;
        }else if(valor < 0){
            this.valor=4294967295L;
        }else{
            this.valor=valor;
        }
        //this.valor = valor;
    }


}
