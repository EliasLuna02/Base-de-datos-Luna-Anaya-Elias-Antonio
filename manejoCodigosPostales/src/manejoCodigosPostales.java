import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class manejoCodigosPostales {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fr = null;

        try (java.io.FileReader fileReader=fr=new FileReader("C:\\Users\\elias\\IdeaProjects\\Base-de-datos\\manejoCodigosPostales\\codigos_postales_hmo.csv")){
            BufferedReader br = new BufferedReader(fr);
            String line = null;

            String cpString= null;
            int contador= 1;
            int lastCP= 0;
            while ( (line = br.readLine()) != null){

                cpString = line.substring(0,5);
                int currentCp= Integer.parseInt(cpString);

                if(currentCp == lastCP){
                    contador++;

                }else {
                    System.out.printf("Código postal: %d - Número de asentamientos: %d\n", lastCP, contador);
                    contador= 1;
                    lastCP= currentCp;
                }


            }

        }catch (FileNotFoundException e){
            throw new RuntimeException(e);

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}