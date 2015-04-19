package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GameTests {

    private Game game;
    @Before
    public void setup(){
        game = new Game();
    }

    private ByteArrayOutputStream getConsoleOutput() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);
        return stream;
    }

    @Test
    public void whenGameIsCreatedNothingIsWrittenToTheOutput(){
        ByteArrayOutputStream stream = getConsoleOutput();
        String emptyString = "";

        assertEquals(emptyString, stream.toString());
    }

    @Test
    public void whenPlayerIsAddedHisNameAndPlayerNumberIsWritten(){
        ByteArrayOutputStream stream = getConsoleOutput();
        String playerNameAndNumber = "Adi was added\n" +
                "They are player number 1\n";
        String playerName = "Adi";

        game.add(playerName);

        assertEquals(playerNameAndNumber, stream.toString());
    }

    @Test
    public void whenTwoPlayersAreAddedTheirNameAndPlayerNumbersAreWritten(){
        ByteArrayOutputStream stream = getConsoleOutput();
        String playerNameAndNumber = "Adi was added\n" +
                "They are player number 1\n" +
                "Alex was added\n" +
                "They are player number 2\n";
        String playerName = "Adi";
        String secondPlayerName = "Alex";

        game.add(playerName);
        game.add(secondPlayerName);

        assertEquals(playerNameAndNumber, stream.toString());
    }

    @Test
    public void whenRollingDiceMessageAboutDiceAndPlayerLocationAndCategoryIsWrittenToOutput(){
        ByteArrayOutputStream stream = getConsoleOutput();
        game.add("SomePlayer");

        game.roll(1);

        assertEquals("SomePlayer was added\n" +
                "They are player number 1\n" +
                "SomePlayer is the current player\n" +
                "They have rolled a 1\n" +
                "SomePlayer's new location is 1\n" +
                "The category is Science\n" +
                "Science Question 0\n", stream.toString());
    }

    @Test
    public void whenRollingDiceTwoMessageAboutDiceAndPlayerLocationAndCategoryIsWrittenToOutput(){
        ByteArrayOutputStream stream = getConsoleOutput();
        game.add("SomePlayer");

        game.roll(2);

        assertEquals("SomePlayer was added\n" +
                "They are player number 1\n" +
                "SomePlayer is the current player\n" +
                "They have rolled a 2\n" +
                "SomePlayer's new location is 2\n" +
                "The category is Sports\n" +
                "Sports Question 0\n", stream.toString());
    }

    @Test
    public void whenRollingDiceFourMessageAboutDiceAndPlayerLocationAndCategoryIsWrittenToOutput(){
        ByteArrayOutputStream stream = getConsoleOutput();
        game.add("SomePlayer");

        game.roll(4);

        assertEquals("SomePlayer was added\n" +
                "They are player number 1\n" +
                "SomePlayer is the current player\n" +
                "They have rolled a 4\n" +
                "SomePlayer's new location is 4\n" +
                "The category is Pop\n" +
                "Pop Question 0\n", stream.toString());
    }

    @Test
    public void whenRollingDiceThreeMessageAboutDiceAndPlayerLocationAndCategoryIsWrittenToOutput(){
        ByteArrayOutputStream stream = getConsoleOutput();
        game.add("SomePlayer");

        game.roll(3);

        assertEquals("SomePlayer was added\n" +
                "They are player number 1\n" +
                "SomePlayer is the current player\n" +
                "They have rolled a 3\n" +
                "SomePlayer's new location is 3\n" +
                "The category is Rock\n" +
                "Rock Question 0\n", stream.toString());
    }

    @Test
    public void playerWasAddedMessageIsComposedCorrectly(){
        String actual = Game.createPlayerWasAddedMessage("Adi");

        assertEquals("Adi was added", actual);
    }

    @Test
    public void playerNumberMessageComposedCorrectly(){
        String actual = Game.createPlayerNumberMessage(3);

        assertEquals("They are player number 3", actual);
    }
}