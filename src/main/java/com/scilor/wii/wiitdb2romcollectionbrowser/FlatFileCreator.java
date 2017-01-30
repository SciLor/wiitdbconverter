package com.scilor.wii.wiitdb2romcollectionbrowser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by SciLor on 30.01.2017.
 */
public class FlatFileCreator {
    public void createFile(String path, Game game, List<String> langPriority) throws Exception {
        try{
            PrintWriter writer = new PrintWriter(path, "UTF-8");
            writer.print(generateText(game, langPriority));
            writer.close();
        } catch (Exception e) {
            throw e;
        }
    }

    private String generateText(Game game, List<String> langPriority) {
        final String newline = "\r\n";
        StringBuilder sb = new StringBuilder();

        sb.append("Id: ").append(game.getId()).append(newline);
        sb.append("Name: ").append(game.getName()).append(newline);
        sb.append("Platform: ").append(game.getType() == null ? "Wii" : game.getType()).append(newline);
        sb.append("Region: ").append(game.getRegion()).append(newline);

        sb.append("Languages: ");
        appendList(sb, game.getLanguages()).append(newline);

        sb.append("Title: ");
        for (String langCode : langPriority) {
            if (game.getLocales().containsKey(langCode)) {
                String text = game.getLocales().get(langCode).getTitle();
                if (text != null)
                    sb.append(text);
                break;
            }
        }
        sb.append(newline);

        sb.append("Developer: ").append(game.getDeveloper()).append(newline);
        sb.append("Publisher: ").append(game.getPublisher()).append(newline);
        sb.append("Release Year: ").append(game.getReleaseDate().getYear()).append(newline);
        sb.append("Release Month: ").append(game.getReleaseDate().getMonthValue()).append(newline);
        sb.append("Release Day: ").append(game.getReleaseDate().getDayOfMonth()).append(newline);

        sb.append("Genre: ");
        appendList(sb, game.getGenres()).append(newline);

        sb.append("Rating: ").append(game.getRating().getType()).append(" ").append(game.getRating().getValue()).append(newline);
        sb.append("Players: ").append(game.getInput().getPlayers()).append(newline);

        sb.append("Controllers: ");
        for (GameControl control : game.getInput().getControls()) {
            sb.append(control.getType());
            if (control.isRequired()) {
                sb.append(" required,");
            } else {
                sb.append(" optional,");
            }
        }
        if (game.getInput().getControls().size() > 0)
            sb.setLength(sb.length()-1);
        sb.append(newline);

        sb.append("Description: ");
        for (String langCode : langPriority) {
            if (game.getLocales().containsKey(langCode)) {
                String text = game.getLocales().get(langCode).getSynopsis();
                if (text != null)
                    sb.append(text);
                break;
            }
        }
        sb.append(newline);

        sb.append("***EOF***");

        return sb.toString();
    }

    private StringBuilder appendList(StringBuilder sb, List<String> list) {
        for (Object entry : list) {
            sb.append(entry.toString());
            sb.append(",");
        }
        if (list.size()>0)
            sb.setLength(sb.length()-1); //remove last comma
        return sb;
    }
}
