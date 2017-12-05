import org.sikuli.script.FindFailed;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FindFailed, IOException {

        Interaction interaction = new Interaction();
        RuneLookup runeLookup = new RuneLookup();

        PageDTO page = runeLookup.getRunes("Braum");

        interaction.clickPrimaryTree(page.getPrimaryTree());

        List<Integer> primaryRunes = page.getPrimaryRunes();
        interaction.clickKeystone(primaryRunes.get(0));
        interaction.clickPrimaryRune(getColumnsFromPosition(primaryRunes.get(1)), getRowsFromPosition(primaryRunes.get(1)));
        interaction.clickPrimaryRune(getColumnsFromPosition(primaryRunes.get(2)), getRowsFromPosition(primaryRunes.get(2)));
        interaction.clickPrimaryRune(getColumnsFromPosition(primaryRunes.get(3)), getRowsFromPosition(primaryRunes.get(3)));

        List<Integer> secondaryRunes = page.getSecondaryRunes();
        interaction.clickSecondaryTree(page.getSecondaryTree());
        interaction.clickSecondaryRune(getColumnsFromPosition(secondaryRunes.get(0)), getRowsFromPosition(secondaryRunes.get(0)));
        interaction.clickSecondaryRune(getColumnsFromPosition(secondaryRunes.get(1)), getRowsFromPosition(secondaryRunes.get(1)));

        page = runeLookup.getRunes("Ezreal");

        interaction.clickPrimaryTree(page.getPrimaryTree());

        primaryRunes = page.getPrimaryRunes();
        interaction.clickKeystone(primaryRunes.get(0));
        interaction.clickPrimaryRune(getColumnsFromPosition(primaryRunes.get(1)), getRowsFromPosition(primaryRunes.get(1)));
        interaction.clickPrimaryRune(getColumnsFromPosition(primaryRunes.get(2)), getRowsFromPosition(primaryRunes.get(2)));
        interaction.clickPrimaryRune(getColumnsFromPosition(primaryRunes.get(3)), getRowsFromPosition(primaryRunes.get(3)));

        secondaryRunes = page.getSecondaryRunes();
        interaction.clickSecondaryTree(page.getSecondaryTree());
        interaction.clickSecondaryRune(getColumnsFromPosition(secondaryRunes.get(0)), getRowsFromPosition(secondaryRunes.get(0)));
        interaction.clickSecondaryRune(getColumnsFromPosition(secondaryRunes.get(1)), getRowsFromPosition(secondaryRunes.get(1)));

        page = runeLookup.getRunes("Katarina");

        interaction.clickPrimaryTree(page.getPrimaryTree());

        primaryRunes = page.getPrimaryRunes();
        interaction.clickKeystone(primaryRunes.get(0));
        interaction.clickPrimaryRune(getColumnsFromPosition(primaryRunes.get(1)), getRowsFromPosition(primaryRunes.get(1)));
        interaction.clickPrimaryRune(getColumnsFromPosition(primaryRunes.get(2)), getRowsFromPosition(primaryRunes.get(2)));
        interaction.clickPrimaryRune(getColumnsFromPosition(primaryRunes.get(3)), getRowsFromPosition(primaryRunes.get(3)));

        secondaryRunes = page.getSecondaryRunes();
        interaction.clickSecondaryTree(page.getSecondaryTree());
        interaction.clickSecondaryRune(getColumnsFromPosition(secondaryRunes.get(0)), getRowsFromPosition(secondaryRunes.get(0)));
        interaction.clickSecondaryRune(getColumnsFromPosition(secondaryRunes.get(1)), getRowsFromPosition(secondaryRunes.get(1)));

        page = runeLookup.getRunes("Gragas");

        interaction.clickPrimaryTree(page.getPrimaryTree());

        primaryRunes = page.getPrimaryRunes();
        interaction.clickKeystone(primaryRunes.get(0));
        interaction.clickPrimaryRune(getColumnsFromPosition(primaryRunes.get(1)), getRowsFromPosition(primaryRunes.get(1)));
        interaction.clickPrimaryRune(getColumnsFromPosition(primaryRunes.get(2)), getRowsFromPosition(primaryRunes.get(2)));
        interaction.clickPrimaryRune(getColumnsFromPosition(primaryRunes.get(3)), getRowsFromPosition(primaryRunes.get(3)));

        secondaryRunes = page.getSecondaryRunes();
        interaction.clickSecondaryTree(page.getSecondaryTree());
        interaction.clickSecondaryRune(getColumnsFromPosition(secondaryRunes.get(0)), getRowsFromPosition(secondaryRunes.get(0)));
        interaction.clickSecondaryRune(getColumnsFromPosition(secondaryRunes.get(1)), getRowsFromPosition(secondaryRunes.get(1)));
    }

    static int getRowsFromPosition(int position) {
        return (int) Math.floor(position / 3)-1;
    }

    static int getColumnsFromPosition(int position) {
        return position % 3;
    }
}
