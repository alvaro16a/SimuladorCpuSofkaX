package SimuladorCPU;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SimuladorCpu {
    public static Decodificador decoder;
    public static contadorPrograma counter;

    public static int leerArchivo(String nombreArchivo, String[] temp) {
        int i = 0;
        try {
            FileReader r = new FileReader(nombreArchivo);
            BufferedReader buffer = new BufferedReader(r);

            do {
                temp[i] = buffer.readLine();
                if (temp[i] == null) {
                    break;
                }
                i++;
                System.out.println("1."+temp[i-1]);
            } while (temp[i - 1] != null);

        } catch (IOException e) {
            System.out.println("error: "+e.getMessage());
        }
        return i;
    }

    public static void main(String args[]){
        //TODO: Modificar el decodificador
        //TODO: agregar las subrutinas desde un txt
        
        //String []subrutina= {"MOV 5,R00", "MOV 10,R01", "JZ 7", "ADD R02,R01", "DEC R00", "JMP 3", "MOV R02,R42"};
        String []subrutina= new String[1024];
        int cantidadSubrutina=leerArchivo("instrucciones.txt", subrutina );
        counter=new contadorPrograma();
        decoder = new Decodificador();
        boolean ejecucion= true;
        while(ejecucion && (counter.getInstruccion() < cantidadSubrutina)){

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