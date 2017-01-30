package com.scilor.wii.wiitdb2romcollectionbrowser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SciLor on 30.01.2017.
 */
public class XmlFileParser {

    public List<Game> readGames(File file) throws ParserConfigurationException, IOException, SAXException {
        List<Game> games = new ArrayList<Game>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);

        NodeList nodes = doc.getElementsByTagName("game");
        for (int i=0; i<nodes.getLength(); i++) {
            games.add(parseGame((Element)nodes.item(i)));
        }

        return games;
    }

    private Game parseGame(Element element) {
        Game game = new Game();

        game.setId(getText(element, "id"));
        game.setName(element.getAttribute("name"));

        game.setType(getText(element, "type"));
        game.setRegion(getText(element, "region"));
        game.setLanguages(getTextList(element, "languages"));

        NodeList nodes = element.getElementsByTagName("locale");
        GameLocale locale;
        Element tagElement;
        for (int i=0; i<nodes.getLength(); i++) {
            tagElement = (Element)nodes.item(i);
            locale = new GameLocale();
            locale.setLanguageCode(tagElement.getAttribute("lang"));
            locale.setTitle(getText(tagElement, "title"));
            locale.setSynopsis(getText(tagElement, "synopsis"));
            game.getLocales().put(locale.getLanguageCode(), locale);
        }

        game.setDeveloper(getText(element, "developer"));
        game.setPublisher(getText(element, "publisher"));

        tagElement = ((Element)element.getElementsByTagName("date").item(0));
        game.setReleaseDate(LocalDateTime.of(
                Integer.parseInt(emptyToOne(tagElement.getAttribute("year"))),
                Integer.parseInt(emptyToOne(tagElement.getAttribute("month"))),
                Integer.parseInt(emptyToOne(tagElement.getAttribute("day"))),
                0, 0
        ));

        game.setGenres(getTextList(element, "genre"));

        tagElement = ((Element)element.getElementsByTagName("rating").item(0));
        nodes = tagElement.getElementsByTagName("descriptor");
        GameRating rating = new GameRating();
        rating.setType(tagElement.getAttribute("type"));
        rating.setValue(tagElement.getAttribute("value"));
        List<String> descriptors = new ArrayList<String>();
        for (int i=0; i<nodes.getLength(); i++) {
            descriptors.add(nodes.item(i).getTextContent());
        }
        game.setRating(rating);


        tagElement = ((Element)element.getElementsByTagName("wi-fi").item(0));
        nodes = tagElement.getElementsByTagName("feature");
        GameWiFi wifi = new GameWiFi();
        wifi.setPlayers(Byte.parseByte(tagElement.getAttribute("players")));
        List<String> features = new ArrayList<String>();
        for (int i=0; i<nodes.getLength(); i++) {
            features.add(nodes.item(i).getTextContent());
        }
        wifi.setFeatures(features);
        game.setWifi(wifi);

        tagElement = ((Element)element.getElementsByTagName("input").item(0));
        nodes = tagElement.getElementsByTagName("control");
        GameInput input = new GameInput();
        input.setPlayers(Byte.parseByte(tagElement.getAttribute("players")));
        GameControl control;
        for (int i=0; i<nodes.getLength(); i++) {
            tagElement = (Element)nodes.item(i);
            control = new GameControl();
            control.setType(tagElement.getAttribute("type"));
            control.setRequired(Boolean.parseBoolean(tagElement.getAttribute("required")));
            input.getControls().add(control);
        }
        game.setInput(input);

        return game;
    }

    private String getText(Element element, String tag) {
        NodeList nodes = element.getElementsByTagName(tag);
        if (nodes.getLength() == 0)
            return "";
        return nodes.item(0).getTextContent();
    }
    private List<String> getTextList(Element element, String tag) {
        return Arrays.asList(getText(element, tag).split(","));
    }
    private String emptyToOne(String value) {
        if (value == null || "".equals(value))
            return "1";
        return value;
    }
}
