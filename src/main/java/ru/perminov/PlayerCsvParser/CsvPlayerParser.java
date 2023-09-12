package ru.perminov.PlayerCsvParser;

import ru.perminov.Entity.PlayerEntity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CsvPlayerParser {

  public void parse(String path){
    String jdbcUrl = "jdbc:postgresql://localhost:5400/postgres";
    String username = "userok";
    String password = "p@ssw0rd";
    String filePath = "src/main/resources/players.csv";

    try(Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        PreparedStatement statement
            = connection.prepareStatement("INSERT INTO Players (id, short_name, long_name, player_positions, value_eur, age, height_cm, weight_kg, league_name, club_name, nationality_name) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )")){

      String line;
      int batchSize = 1000;
      int count = 0;

      reader.readLine();

      while ((line = reader.readLine()) != null) {

        PlayerEntity player = parseString(line);

        statement.setLong(1, player.getId());
        statement.setString(2, player.getShortName());
        statement.setString(3, player.getLongName());
        statement.setString(4, player.getPlayerPositions());
        statement.setInt(5, player.getValueEur());
        statement.setInt(6, player.getAge());
        statement.setInt(7, player.getHeightCm());
        statement.setDouble(8, player.getWeightKg());
        statement.setString(9, player.getLeagueName());
        statement.setString(10, player.getClubName());
        statement.setString(11, player.getNationalityName());
        statement.addBatch();

        if (++count % batchSize == 0) {
          statement.executeBatch();
        }
      }
      statement.executeBatch();
    } catch (IOException | SQLException e) {
      e.printStackTrace();
    }
  }

  public PlayerEntity parseString(String line){

    String[] parts = line.split(",(?![\\s])");

    Long id = parts[0].isEmpty()?0:Long.parseLong(parts[0]);
    String short_name = parts[5];
    String long_name = parts[6];
    String player_positions = parts[7];
    int value_eur = parts[10].isEmpty()?0:Integer.parseInt(parts[10]);
    int age = parts[12].isEmpty()?0:Integer.parseInt(parts[12]);
    int height_cm = parts[14].isEmpty()?0:Integer.parseInt(parts[14]);
    double weight_kg = parts[15].isEmpty()?0:Double.parseDouble(parts[15]);
    String league_name = parts[17];
    String club_name = parts[20];
    String nationality_name = parts[27];

    PlayerEntity player = PlayerEntity.builder()
        .Id(id)
        .ShortName(short_name)
        .LongName(long_name)
        .PlayerPositions(player_positions)
        .ValueEur(value_eur)
        .Age(age)
        .HeightCm(height_cm)
        .WeightKg(weight_kg)
        .LeagueName(league_name)
        .ClubName(club_name)
        .NationalityName(nationality_name)
        .build();

    return player;
  }
}
