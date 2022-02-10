package SimuladorCPU;

public class Decodificador {
    private Instrucciones instrucciones;
    
    public Decodificador(){
        instrucciones = new Instrucciones();
    }

    //public void decodificarInstruccion(String instruccion){
    public void DecodificarInstruccion(String instruccion, contadorPrograma counter){
        String funcion;
        String [] parts;
        String []operador = {"",""};
        String operador_1;
        String operador_2;
        parts = instruccion.split(" ");
        funcion = parts[0];
        System.out.println(funcion);

        switch (funcion) {

            case "MOV": {
                operador = parts[1].split(",");
                operador_1= operador[0];
                operador_2 = operador[1];
                if(operador_1.charAt(0)=='R')
                {
                    instrucciones.MOV(Integer.parseInt(operador_1.substring(1)),Integer.parseInt(operador_2.substring(1)));
                }
                else
                {
                    instrucciones.MOV(Long.parseLong(operador_1), Integer.parseInt(operador_2.substring(1)));
                }
                //System.out.println("MOV "+operador_1+","+operador_2);
                break;
            }

            case "ADD": {
                operador = parts[1].split(",");
                operador_1= operador[0].substring(1);
                operador_2 = operador[1].substring(1);
                instrucciones.ADD(Integer.parseInt(operador_1),Integer.parseInt(operador_2));
                System.out.println("ADD "+operador_1+","+operador_2);
                break;
            }

            case "DEC": {
                operador[0] = parts[1];
                instrucciones.DEC(Integer.parseInt(operador[0].substring(1)));
                break;
            }

            case "INC": {
                operador[0] = parts[1];
                instrucciones.INC(Integer.parseInt(operador[0].substring(1)));
                break;
            }

            case "INV": {
                operador[0] = parts[1];
                instrucciones.INV(Integer.parseInt(operador[0].substring(1)));
                break;
            }

            case "JMP":
            {
                operador[0] = parts[1];
                counter.setSiguienteInstruccion(Integer.parseInt(operador[0])-1);
                break;
            }
            case "JZ": {
                operador[0] = parts[1];
                if(instrucciones.valorRegistro(0) == 0L)
                {
                    counter.setSiguienteInstruccion(Integer.parseInt(operador[0])-1);
                }
                System.out.println();
                break;
            }
            case "NOP": {
                break;
            }

            default:
            {
                break;
            }
        }
    }
    
    public long getValorRegistro(int registro){
        return instrucciones.valorRegistro(registro);
    }
}
