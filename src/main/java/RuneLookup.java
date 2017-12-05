import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RuneLookup {

    private static final String CHAMP_WEBPAGE = "http://euw.op.gg/champion/%s";
    public static final String SRC = "src";
    public static final int FIRST_GROUP = 1;
    public static final int MAX_RUNES = 6;
    public static final int PRIMARY_TREE = 0;
    public static final int SECONDARY_TREE = 1;
    public static final int MAX_PRIMARY_RUNES = 4;
    public static final String RUNE_LOOKUP = "C:\\Users\\Tom\\IdeaProjects\\runes\\src\\main\\java\\rune-positions.json";
    private JsonElement json = new JsonParser().parse(readFile());
    private Pattern pattern = Pattern.compile(".*/([0-9]+)\\.png");

    private Document getPage(String champion) throws IOException {
        return Jsoup.connect(String.format(CHAMP_WEBPAGE, champion)).get();
    }

    private Elements getRuneElements(Document document) {
         return document.select(".ChampionKeystoneRune-1");
    }

    public PageDTO getRunes(String champion) throws IOException {

        Elements select = getRuneElements(getPage(champion));

        List<Integer> treeIds = new ArrayList<>();

        for (Element runeElement : getRunesOnPage(select)) {
            Matcher matcher = pattern.matcher(runeElement.attr(SRC));
            if (matcher.find()) {
                treeIds.add(Integer.parseInt(matcher.group(FIRST_GROUP)));
            }
        }

        Elements elements = getActiveRunes(select);
        List<Integer> runeIds = new ArrayList<>();

        for (int i = 0; i< MAX_RUNES; i++) {
            Element activeRune = elements.get(i);
            Matcher matcher = pattern.matcher(activeRune.attr(SRC));
            if (matcher.find()) {
                runeIds.add(Integer.parseInt(matcher.group(FIRST_GROUP)));
            }
        }

        PageDTO page = new PageDTO();
        page.setPrimaryTree(convertTreeIdToPosition(treeIds.get(PRIMARY_TREE)));
        page.setSecondaryTree(convertTreeIdToPosition(treeIds.get(SECONDARY_TREE)));

        for (int i = 0; i < MAX_PRIMARY_RUNES; i++) {
            page.addPrimaryRune(convertRuneIdToPosition(runeIds.get(i)));
        }

        for (int i = MAX_PRIMARY_RUNES; i < runeIds.size(); i++) {
            page.addSecondaryRune(convertRuneIdToPosition(runeIds.get(i)));
        }

        return page;
    }

    private Elements getActiveRunes(Elements select) {
        return select.select(".perk-page__item--active").select(".tip");
    }

    private Elements getRunesOnPage(Elements select) {
        return select.select(".perk-page__item--mark").select(".tip");
    }

    private int convertTreeIdToPosition(int id) {
        return json.getAsJsonObject().getAsJsonObject("trees").get(String.valueOf(id)).getAsInt();
    }
    private int convertRuneIdToPosition(int id) {
        int position = json.getAsJsonObject().getAsJsonObject("runes").get(String.valueOf(id)).getAsInt();

        String strPos = String.valueOf(position);

        int result;

        if (strPos.length() > 1) {
            result = Integer.parseInt(strPos.substring(0, 1))*3+Integer.parseInt(strPos.substring(1));
        } else {
            result = position;
        }

        return result;
    }

    private String readFile() {
        try(BufferedReader br = new BufferedReader(new FileReader(RUNE_LOOKUP))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
