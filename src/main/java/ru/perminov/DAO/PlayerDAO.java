package ru.perminov.DAO;

import ru.perminov.Entity.PlayerEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {
  private static final String JDBC_URL = "jdbc:postgresql://localhost:5400/postgres";
  private static final String USERNAME = "userok";
  private static final String PASSWORD = "p@ssw0rd";

  private static Connection connection;

  static {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    try {
      connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public List<PlayerEntity> index() {
    List<PlayerEntity> players = new ArrayList<>();

    String SQL = "SELECT * FROM players";

    try (Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(SQL)){
      while (resultSet.next()) {
        PlayerEntity player = PlayerEntity.builder()
            .Id(resultSet.getLong("id"))
            .ShortName(resultSet.getString("short_name"))
            .LongName(resultSet.getString("long_name"))
            .PlayerPositions(resultSet.getString("player_positions"))
            .ValueEur(resultSet.getInt("value_eur"))
            .Age(resultSet.getInt("age"))
            .HeightCm(resultSet.getInt("height_cm"))
            .WeightKg(resultSet.getInt("weight_kg"))
            .LeagueName(resultSet.getString("league_name"))
            .ClubName(resultSet.getString("club_name"))
            .NationalityName(resultSet.getString("nationality_name"))
            .build();
        players.add(player);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return players;
  }

  public PlayerEntity show (int id) {
    PlayerEntity player = null;
    try (PreparedStatement preparedStatement =
             connection.prepareStatement("SELECT * FROM players WHERE id=?");){
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      resultSet.next();
      player = PlayerEntity.builder()
          .Id(resultSet.getLong("id"))
          .ShortName(resultSet.getString("short_name"))
          .LongName(resultSet.getString("long_name"))
          .PlayerPositions(resultSet.getString("player_positions"))
          .ValueEur(resultSet.getInt("value_eur"))
          .Age(resultSet.getInt("age"))
          .HeightCm(resultSet.getInt("height_cm"))
          .WeightKg(resultSet.getInt("weight_kg"))
          .LeagueName(resultSet.getString("league_name"))
          .ClubName(resultSet.getString("club_name"))
          .NationalityName(resultSet.getString("nationality_name"))
          .build();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return player;
  }

  public void save(PlayerEntity player) {
    try (PreparedStatement preparedStatement
             = connection.prepareStatement("INSERT INTO Players (id, short_name, long_name, player_positions, value_eur, age, height_cm, weight_kg, league_name, club_name, nationality_name) " +
                                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )")){
      preparedStatement.setLong(1, player.getId());
      preparedStatement.setString(2, player.getShortName());
      preparedStatement.setString(3, player.getLongName());
      preparedStatement.setString(4, player.getPlayerPositions());
      preparedStatement.setInt(5, player.getValueEur());
      preparedStatement.setInt(6, player.getAge());
      preparedStatement.setInt(7, player.getHeightCm());
      preparedStatement.setDouble(8, player.getWeightKg());
      preparedStatement.setString(9, player.getLeagueName());
      preparedStatement.setString(10, player.getClubName());
      preparedStatement.setString(11, player.getNationalityName());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void update(int id, PlayerEntity updatePlayer) {
    try (PreparedStatement preparedStatement =
             connection.prepareStatement("UPDATE Player SET short_name = ?, " +
                 "long_name = ?, player_positions = ?, value_eur = ?, age = ?, " +
                 "height_cm = ? , weight_kg = ? , league_name = ? , " +
                 "club_name = ?, nationality_name = ?  WHERE id=?");){
      preparedStatement.setString(1, updatePlayer.getShortName());
      preparedStatement.setString(2, updatePlayer.getLongName());
      preparedStatement.setString(3, updatePlayer.getPlayerPositions());
      preparedStatement.setInt(4, updatePlayer.getValueEur());
      preparedStatement.setInt(5, updatePlayer.getAge());
      preparedStatement.setInt(6, updatePlayer.getHeightCm());
      preparedStatement.setDouble(7, updatePlayer.getWeightKg());
      preparedStatement.setString(8, updatePlayer.getLeagueName());
      preparedStatement.setString(9, updatePlayer.getClubName());
      preparedStatement.setString(10, updatePlayer.getNationalityName());
      preparedStatement.setInt(11, id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void delete(int id) {
    try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM players WHERE id=?")) {
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
