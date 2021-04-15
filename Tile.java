import java.util.*;

public class Tile {
    int value;
    ArrayList<String> names;

    public Tile (int value) {
        this.value = value;
        names = new ArrayList<>();
    }

    public int getValue () {
        return value;
    }

    public void setValue (int value) {
        this.value = value;
    }

    public ArrayList<String> getNames () {
        return names;
    }

    public void addName (String name) {
        if (!names.contains(name)) names.add(name);
    }

    public void addName (ArrayList<String> nameList) {
        for (String s : nameList) this.addName(s);
    }

    public void clearNames () {
        names.clear();
    }

    public boolean isSameAs (Tile o) {
        if (o.getValue() != this.getValue ()) return false;
        for (String n : o.getNames()) if (!this.getNames().contains(n)) return false;
        for (String n : this.getNames()) if (!o.getNames().contains(n)) return false;
        return true;
    }

}
