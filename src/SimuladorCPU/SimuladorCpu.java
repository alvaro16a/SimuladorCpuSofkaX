package SimuladorCPU;

public class SimuladorCpu {
    public static Decodificador decoder;
    public static contadorPrograma counter;


    public static void main(String args[]){
        //TODO: Modificar el decodificador
        //TODO: agregar las subrutinas desde un txt
        
        String []subrutina= {"MOV 5,R00", "MOV 10,R01", "JZ 7", "ADD R02,R01", "DEC R00", "JMP 3", "MOV R02,R42"};
        counter=new contadorPrograma();
        decoder = new Decodificador();
        boolean ejecucion= true;
        while(ejecucion && (counter.getInstruccion() < subrutina.length)){

                decoder.DecodificarInstruccion(subrutina[counter.getSiguienteInstruccion()],counter);
                ejecucion=counter.incrementarContador();
        }

        System.out.println("El resultado de la operacion es: " + decoder.getValorRegistro(42));

    }
    /*public static void main(String args[])
    {
        decoder = new Decodificador();
        decoder.decodificarInstruccion("MOV 5,R1");
        decoder.decodificarInstruccion("MOV R1,R5");
        decoder.decodificarInstruccion("ADD R02,R01");
        decoder.decodificarInstruccion("DEC R01");
        decoder.decodificarInstruccion("INC R05");
        decoder.decodificarInstruccion("INV R05");
        //decodificarInstruccion();
    }*/

}