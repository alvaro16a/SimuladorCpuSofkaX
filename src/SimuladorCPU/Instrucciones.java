package SimuladorCPU;

import javax.sound.sampled.ReverbType;

public class Instrucciones {

    Registro [] R = new Registro[43];

    Instrucciones(){
        for(int i=0;i<43;i++) {
            R [i] = new Registro();
        }
    }

    public void MOV(int Rxx, int Ryy){
        R[Ryy].setValor(R[Rxx].getValor());
    }

    public void MOV(long d, int Ryy){
        R[Ryy].setValor(d);
    }

    public void ADD(int Rxx, int Ryy){
       R[Rxx].setValor((long) ((R[Rxx].getValor() + R[Ryy].getValor()) % Math.pow(2,32)));
    }

    public void DEC(int Rxx){
        R[Rxx].setValor(R[Rxx].getValor() - 1);
    }

    public void INC(int Rxx){
        R[Rxx].setValor(R[Rxx].getValor() + 1);
    }

    public void INV(int Rxx){
        long i = Integer.reverseBytes((int) R[Rxx].getValor());
        R[Rxx].setValor(i);
    }

    public void NOP(){

    }



}
