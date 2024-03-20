import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        String[] stationNamn = {"Släpp", "Garderob", "Ölbar","Bar","Kök", "Plock"};
        int[] stationMaxAntal = {5, 2, 5, 2, 2, 1};
        String[] sexitNamn = {"Päng", "Fritte", "Snäckan", "Öst"}; // ta med sexit som inte har fast position
        String[] plebNamn = {};

        ArrayList<Station> Stationer= new ArrayList<Station>();
        for (int i = 0; i < stationNamn.length; i++) {
            Stationer.add(new Station(stationNamn[i], stationMaxAntal[i])); //skapa alla stationer som instanser av stationer klassen
        }

        ArrayList<Puff> sexit= new ArrayList<Puff>();
        for (String cooltNamn : sexitNamn) {
            sexit.add(new Puff(cooltNamn, true)); // skapa sexit som instanser av puff
        }

        ArrayList<Puff> plebs= new ArrayList<Puff>();
        for (String cringeNamn : plebNamn) {
            plebs.add(new Puff(cringeNamn, false)); // skapa plebs som instanser av puff
        }

        Schema schema = new Schema();
        Stationer.get(3).addPuff(new Puff("Kretty", true)); // lägg till ölchef i baren föralltid
        Stationer.get(4).addPuff(new Puff("Olle", true));   // lägg till sexmästarina i köket föralltid
        for (int rowIndex = 0; rowIndex < 5; rowIndex++) {
            schema.addRad(new Rad(rowIndex, sexit, plebs, Stationer));
            while (true) {
                Rad currentRow = schema.getRow(rowIndex);
                currentRow.clearStations();
                currentRow.shuffleSexit();
                currentRow.shufflePlebs();
                if (schema.compareRow(rowIndex) < 10 || rowIndex == 0) { // bestämmer hur många dubbelpass som får finnas.
                    break;
                }
            }

        }
        schema.printResult();

    }
}