package ru.perminov.PlayerCsvParser;

import ru.perminov.Entity.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CsvPlayerParser {

  public void parseCSVtoDataBase(String path){
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

        Player player = parseFromStringToPlayer(line);

        statement.setLong(1, player.getId());
        statement.setString(2, player.getShort_name());
        statement.setString(3, player.getLong_name());
        statement.setString(4, player.getPlayer_positions());
        statement.setInt(5, player.getValue_eur());
        statement.setInt(6, player.getAge());
        statement.setInt(7, player.getHeight_cm());
        statement.setDouble(8, player.getWeight_kg());
        statement.setString(9, player.getLeague_name());
        statement.setString(10, player.getClub_name());
        statement.setString(11, player.getNationality_name());
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

  public Player parseFromStringToPlayer(String line){

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

    Player player = new Player.Builder()
        .setId(id)
        .setShortName(short_name)
        .setLongName(long_name)
        .setPlayerPositions(player_positions)
        .setValueEur(value_eur)
        .setAge(age)
        .setHeightCm(height_cm)
        .setWeightKg(weight_kg)
        .setLeagueName(league_name)
        .setClubName(club_name)
        .setNationalityName(nationality_name)
        .build();

    return player;
  }
}
