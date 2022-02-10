package SimuladorCPU;

public class Decodificador {
    public Instrucciones matriz;
    Instrucciones instrucciones= new Instrucciones();

    public void DecodificarInstruccion(String instruccion){
        String funcion;

        if (instruccion.charAt(3) == ' ') {
            funcion = instruccion.substring(0, 3);
        } else {
            funcion = instruccion.substring(0, 2);
        }
        System.out.println(funcion);

        switch (funcion) {

            case "MOV": {

                String operador = instruccion.substring(4, encontrarComa(instruccion));


                try {
                    long operador_1 = Long.parseLong(operador);
                    String operador_2 = instruccion.substring(encontrarComa(instruccion) + 2, instruccion.length());
                    instrucciones.MOV(operador_1,Integer.parseInt(operador_2));
                } catch (NumberFormatException e) {
                    operador = instruccion.substring(5, 7);
                    int operador_1 = Integer.parseInt(operador);
                    operador = instruccion.substring(9, 11);
                    int operador_2 = Integer.parseInt(operador);
                    instrucciones.MOV(operador_1,operador_2);
                    break;
                }
                break;
            }


            case "ADD": {
                String operador = instruccion.substring(5, 7);
                int operador_1 = Integer.parseInt(operador);
                operador = instruccion.substring(9, 11);
                int operador_2 = Integer.parseInt(operador);
                instrucciones.ADD(operador_1,operador_2);
                break;
            }

            case "DEC": {
                String operador = instruccion.substring(5, instruccion.length());
                int operador_1 = Integer.parseInt(operador);
                instrucciones.DEC(operador_1);
                break;
            }

            case "INC": {
                String operador = instruccion.substring(5, instruccion.length());
                int operador_1 = Integer.parseInt(operador);
                instrucciones.INC(operador_1);
                break;
            }

            case "INV": {
                String operador = instruccion.substring(5, instruccion.length());
                int operador_1 = Integer.parseInt(operador);
                instrucciones.INV(operador_1);
                break;
            }

            case "JMP": {
                String operador = instruccion.substring(4, instruccion.length());
                int operador_1 = Integer.parseInt(operador);
                break;
            }
            case "JZ": {
                String operador = instruccion.substring(3, instruccion.length());
                int operador_1 = Integer.parseInt(operador);
                break;
            }
            case "NOP": {
                break;
            }
        }
    }

    public static int encontrarComa(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ',') {
                return i;
            }
        }
        return -1;
    }
}
