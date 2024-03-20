import java.util.ArrayList;
import java.util.HashSet;

public class Schema {
    private ArrayList<Rad> radLista;

    public Schema() {
        this.radLista = new ArrayList<>();
    }
    public void addRad(Rad rad) {
        radLista.add(rad);
    }
    public Rad getRow(int i) {
        return radLista.get(i);
    }
    public Rad getPrevious(int currentRowIndex) {
        if (currentRowIndex > 0) {
            return radLista.get(currentRowIndex-1);
        }
        return radLista.get(currentRowIndex);
    }

    public Rad getNext(int currentRowIndex) {
        if (currentRowIndex < 4) {
            return radLista.get(currentRowIndex+1);
        }
        return radLista.get(currentRowIndex);
    }

    public int compareRow(int rowIndex) {
        int equalElementsCount = 0;
        for (int i = 0; i < 5; i++) {
            Station previousStation = getPrevious(rowIndex).getStation(i);
            Station currentStation = getRow(rowIndex).getStation(i);
            for (Puff puff : currentStation.getPuffar()) {
                if (previousStation.containsPuff(puff)) {
                    equalElementsCount++;
                }
            }
        }
        return equalElementsCount;
    }

    public void printResult() {
        for (Rad row : radLista) {
            String printResult = "" + 22+row.getRowNumber() + ": ";
            for (Station station : row.getFinalStations()) {
                for (Puff puff : station.getPuffar()) {
                    printResult += puff.getName() + ", ";
                }
            }
        System.out.println(printResult);
        }

    }
}
