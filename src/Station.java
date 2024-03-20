import java.util.HashSet;


public class Station {

    private String name;
    private HashSet<Puff> Puffar;
    private int size;
    private int maxSize;
    public Station(String name, int maxSize) {
        this.name = name;
        this.Puffar = new HashSet<>();
        this.size = 0;
        this.maxSize = maxSize;
    }

    public String getName() {
        return name;
    }

    public HashSet<Puff> getPuffar() {
        return Puffar;
    }
    public boolean stationIsNotFull() {
        if (maxSize-size == 0) {return false;}
        return true;
    }
    public void addPuff(Puff puff) {
        Puffar.add(puff);
    }
    public boolean containsPuff(Puff puff) {
        return Puffar.contains(puff);
    }
}
