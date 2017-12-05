import java.util.ArrayList;
import java.util.List;

public class PageDTO {
    private int primaryTree;
    private int secondaryTree;
    private List<Integer> primaryRunes = new ArrayList<>();
    private List<Integer> secondaryRunes = new ArrayList<>();

    public int getPrimaryTree() {
        return primaryTree;
    }

    public void setPrimaryTree(int primaryTree) {
        this.primaryTree = primaryTree;
    }

    public int getSecondaryTree() {
        return secondaryTree;
    }

    public void setSecondaryTree(int secondaryTree) {
        this.secondaryTree = secondaryTree < 3 ? secondaryTree : 3;
    }

    public List<Integer> getPrimaryRunes() {
        return primaryRunes;
    }

    public void setPrimaryRunes(List<Integer> primaryRunes) {
        this.primaryRunes = primaryRunes;
    }

    public void addPrimaryRune(int primaryRune) {
        this.primaryRunes.add(primaryRune);
    }

    public List<Integer> getSecondaryRunes() {
        return secondaryRunes;
    }

    public void setSecondaryRunes(List<Integer> secondaryRunes) {
        this.secondaryRunes = secondaryRunes;
    }

    public void addSecondaryRune(int secondaryRune) {
        this.secondaryRunes.add(secondaryRune);
    }
}
