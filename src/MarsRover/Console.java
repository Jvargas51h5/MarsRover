package MarsRover;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
/*
 * @author Jhon Vargas
 */
public class Console {
    Rover rover = new Rover();
    public static void main(String[] args) throws IOException {
        Console cmd = new Console();
        cmd.menu();
    }
    public void menu() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nCOMMAND READER ROVERS");
        System.out.println("\nMENU\n");
        System.out.print("1.- READ COMANDS\n");
        System.out.print("2.- HELP\n");
        System.out.print("3.- EXIT\n");
        int option = keyboard.nextInt();
        switch (option) {
            case 1:
                ReadComands();
                menu();
                break;
            case 2:
                System.out.println("\nTo read commands should have a text document\n"
                        + "Select option 1 and specifies the address of the file with a .txt extension");
                menu();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.print("\nSelect choice right");
                menu();
        }
    }
    public void ReadInput(BufferedReader file) throws IOException {
        file.mark(10000);
        System.out.println("\nProcessing Instructions:\n");
        while(file.ready())
            System.out.println(file.readLine());
        System.out.println("\nOutput results:\n");
        file.reset();
    }
    public void ReadComands() throws IOException {
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(null);
        BufferedReader file = new BufferedReader(new FileReader(jfc.getSelectedFile().getPath()));
        ReadInput(file);
        String length = file.readLine(); //the first line is length
        while (file.ready())
            System.out.println(rover.ExecuteComands(length, file.readLine(), file.readLine()));
    }
}