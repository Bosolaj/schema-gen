import java.util.ArrayList;
import java.util.*;

public class Rad {
    private int rowNumber;
    private ArrayList<Puff> sexit;
    private ArrayList<Puff> plebs;
    private ArrayList<Station> sexitStation;
    private ArrayList<Station> plebStation;
    private ArrayList<Station> finalStations;
    private ArrayList<Station> emptyStations;

    public Rad(int rowNumber, ArrayList<Puff> sexit, ArrayList<Puff> plebs, ArrayList<Station> emptyStations) {
        this.rowNumber = rowNumber;
        this.sexit = sexit;
        this.plebs = plebs;

        this.emptyStations = emptyStations;
        this.finalStations = emptyStations;
        
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public Station getStation(int i) {
        return finalStations.get(i);
    }

    public ArrayList<Station> getFinalStations() {
        return finalStations;
    }

    public void clearStations() {
        this.finalStations = emptyStations;
    }
    public void shuffleSexit() {
        Collections.shuffle(sexit);
        for (int i = 0; i < sexit.size(); i++) {
            finalStations.get(i).addPuff(sexit.get(i));

        }

    }

    public void shufflePlebs() {
        Collections.shuffle(plebs);
        for (int i = 0; i < plebs.size(); i++) {
            for (Station currentStation : finalStations)
                if (currentStation.stationIsNotFull()) {
                    currentStation.addPuff(plebs.get(i));
                }


        }
    }

}
