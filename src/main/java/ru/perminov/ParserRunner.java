package ru.perminov;

import ru.perminov.PlayerCsvParser.CsvPlayerParser;

public class ParserRunner {
  public static void main(String[] args) {
    CsvPlayerParser csvPlayerParser = new CsvPlayerParser();
    csvPlayerParser.parse("src/main/resources/players.csv");
  }
}