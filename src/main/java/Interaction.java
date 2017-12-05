import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

public class Interaction {

    private static final String EDIT_RUNES = "C:\\Users\\Tom\\Desktop\\edit-runes-button.png";
    private static final int PRIMARY_TREE_REGION_HEIGHT = 70;
    private static final int MASTERY_REGION_WIDTH = 250;
    private static final int MASTERY_REGION_HEIGHT = 560;
    private static final int REGION_OFFSET_X = 95;
    private static final int REGION_OFFSET_Y = 90;

    private Screen screen = new Screen();
    private Region primaryRegion = null;
    private Region secondaryRegion = null;

    public boolean editRunes() {
        try {
            Match match = screen.find(EDIT_RUNES);
            match.click();
        } catch (FindFailed findFailed) {
            return false;
        }
        return true;
    }

    private void setPrimaryRegion() throws FindFailed {
        if (primaryRegion == null) {
            Match match = screen.find(EDIT_RUNES);
            int x = match.x + REGION_OFFSET_X;
            int y = match.y + REGION_OFFSET_Y;

            int width = MASTERY_REGION_WIDTH;
            int height = MASTERY_REGION_HEIGHT;
            primaryRegion = new Region(x, y, width, height);
        }
    }

    private void setSecondaryRegion() throws FindFailed {
        if (secondaryRegion == null) {
            setPrimaryRegion();
            secondaryRegion = new Region(primaryRegion.x+410, primaryRegion.y, 247, 355);
        }
    }

    private Region getPrimaryTrees() throws FindFailed {
        setPrimaryRegion();
        return new Region(primaryRegion.x, primaryRegion.y, primaryRegion.w, 70);
    }

    private Region getKeystones() throws FindFailed {
        setPrimaryRegion();
        return new Region(primaryRegion.x, primaryRegion.y+135, primaryRegion.w, 95);
    }

    private Region getPrimaryRunes() throws FindFailed {
        setPrimaryRegion();
        return new Region(primaryRegion.x, primaryRegion.y+245, primaryRegion.w, 335);
    }

    private Region getSecondaryTrees() throws FindFailed{
        setSecondaryRegion();
        return new Region(secondaryRegion.x, secondaryRegion.y, secondaryRegion.w, 70);
    }

    private Region getSecondaryRunes() throws FindFailed {
        setSecondaryRegion();
        return new Region(secondaryRegion.x, secondaryRegion.y+100, secondaryRegion.w, 285);
    }

    public boolean clickPrimaryTree(int tree) {
        Region primaryTrees;
        try {
            primaryTrees = getPrimaryTrees();
        } catch (FindFailed findFailed) {
            return false;
        }

        new Region(primaryTrees.x+(int) (primaryTrees.w*(0.2*tree)),
                primaryTrees.y,
                (int) (primaryTrees.w*.2),
                PRIMARY_TREE_REGION_HEIGHT)
                .click();

        return true;
    }

    public boolean clickKeystone(int keystone) {
        Region keystones;
        try {
            keystones = getKeystones();
        } catch (FindFailed findFailed) {
            return false;
        }

        new Region(keystones.x+ (int) (keystones.w*(0.33*keystone)), keystones.y, (int) (keystones.w*0.33), 95).click();

        return true;
    }

    public boolean clickPrimaryRune(int runeX, int runeY) {
        Region primaryRunes;
        try {
            primaryRunes = getPrimaryRunes();
        } catch (FindFailed findFailed) {
            return false;
        }

        new Region(primaryRunes.x+ (int) (primaryRunes.w*(0.33*runeX)),
                primaryRunes.y+ (int) (primaryRunes.h*(0.33*runeY)),
                (int) (primaryRunes.w*0.33),
                (int) (primaryRunes.h*0.33)).click();

        return true;
    }

    public boolean clickSecondaryTree(int tree) {
        Region secondaryTrees;
        try {
            secondaryTrees = getSecondaryTrees();
        } catch (FindFailed findFailed) {
            return false;
        }

        new Region(secondaryTrees.x+ (int) (secondaryTrees.w*(0.25*tree)), secondaryTrees.y, (int) (secondaryTrees.w*0.25), secondaryTrees.h).click();

        return true;
    }

    public boolean clickSecondaryRune(int runeX, int runeY) {
        Region secondaryRunes;
        try {
            secondaryRunes = getSecondaryRunes();
        } catch (FindFailed findFailed) {
            return false;
        }

        new Region(secondaryRunes.x+ (int) (secondaryRunes.w*(0.33*runeX)),
                secondaryRunes.y+ (int) (secondaryRunes.h*(0.33*runeY)),
                (int) (secondaryRunes.w*0.33),
                (int) (secondaryRunes.h*0.33)).click();

        return true;
    }
}
