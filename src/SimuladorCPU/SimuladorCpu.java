package SimuladorCPU;

public class SimuladorCpu {
    public static Decodificador decoder;
    public static contadorPrograma counter;


    public static void main(String args[]){
        String []subrutina= {"MOV 5,R00", "MOV 10,R01", "JZ 7", "ADD R02,R01", "DEC R00", "JMP 3", "MOV R02,R42"};
        counter=new contadorPrograma();
        decoder = new Decodificador();
        boolean ejecucion= true;
        while(ejecucion && (counter.getInstruccion() < subrutina.length)){

                decoder.DecodificarInstruccion(subrutina[counter.getSiguienteInstruccion()],counter);
                ejecucion=counter.incrementarContador();
        }

        System.out.println(decoder.getValorRegistro(42));

    }

}