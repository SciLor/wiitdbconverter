package com.scilor.wii.wiitdb2romcollectionbrowser;

import org.apache.commons.cli.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SciLor on 30.01.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Options options = generateOptions();

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("WiiTDB.xml to flat file converter", options);

            System.exit(1);
            return;
        }

        XmlFileParser xmlParser = new XmlFileParser();
        List<Game> games = xmlParser.readGames(new File(cmd.getOptionValue("input")));
        FlatFileCreator creator = new FlatFileCreator();

        for (Game game : games) {
            creator.createFile(cmd.getOptionValue("output") + game.getId() + ".txt", game, Arrays.asList(cmd.getOptionValues("lang-priority")));
        }
    }

    private static Options generateOptions() {
        Options options = new Options();

        Option option;
        option = new Option("i", "input", true, "WiiTDB.xml file path");
        option.setRequired(true);
        options.addOption(option);

        option = new Option("o", "output", true, "directory to put the flat files");
        option.setRequired(true);
        options.addOption(option);

        option = new Option("lp", "lang-priority", true, "List of language codes (EN DE FR etc.) to extract the game name / description. First serves first!");
        option.setRequired(true);
        option.setArgs(Option.UNLIMITED_VALUES);
        options.addOption(option);

        return options;
    }
}
