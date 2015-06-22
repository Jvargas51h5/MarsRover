package MarsRover;
/*
 * @author Jhon Vargas
 */
public class Rover {
    public String ExecuteComands(String length, String position, String Instruccion) {
        String[] arrayLength = length.split(" ");     //plateau length
        int dimX = Integer.parseInt(arrayLength[0]);
        int dimY = Integer.parseInt(arrayLength[1]);
        String[] arrayPosition = position.split(" ");       //robert positioning  
        int x = Integer.parseInt(arrayPosition[0]);
        int y = Integer.parseInt(arrayPosition[1]);
        char looking = arrayPosition[2].charAt(0);        //where looking at robert
        for (int limite = 0; limite < Instruccion.length(); limite++) {
            if (Instruccion.charAt(limite) == 'L') {
                if (looking == 'N') 
                    looking = 'W';
                 else if (looking == 'W') 
                    looking = 'S';
                 else if (looking == 'S') 
                    looking = 'E';
                 else if (looking == 'E') 
                    looking = 'N';
            } else if (Instruccion.charAt(limite) == 'R') {
                if (looking == 'N') 
                    looking = 'E';
                 else if (looking == 'E') 
                    looking = 'S';
                 else if (looking == 'S') 
                    looking = 'W';
                 else if (looking == 'W') 
                    looking = 'N';
                
            } else if (Instruccion.charAt(limite) == 'M') {
                if (looking == 'N' && y < dimY) 
                    y++;
                 else if (looking == 'E') 
                    x++;
                 else if (looking == 'S') 
                    y--;
                 else if (looking == 'W') 
                    x--;   
            }
        }
        if(x > dimX ||y > dimY)
            return "Rover Lost";
        else
            return Integer.toString(x) + " " + Integer.toString(y) + " " + looking;
    }
}