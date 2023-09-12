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
            .setId(resultSet.getLong("id"))
            .setShort_name(resultSet.getString("short_name"))
            .setLong_name(resultSet.getString("long_name"))
            .setPlayer_positions(resultSet.getString("player_positions"))
            .setValue_eur(resultSet.getInt("value_eur"))
            .setAge(resultSet.getInt("age"))
            .setHeight_cm(resultSet.getInt("height_cm"))
            .setWeight_kg(resultSet.getInt("weight_kg"))
            .setLeague_name(resultSet.getString("league_name"))
            .setClub_name(resultSet.getString("club_name"))
            .setNationality_name(resultSet.getString("nationality_name"))
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
          .setId(resultSet.getLong("id"))
          .setShort_name(resultSet.getString("short_name"))
          .setLong_name(resultSet.getString("long_name"))
          .setPlayer_positions(resultSet.getString("player_positions"))
          .setValue_eur(resultSet.getInt("value_eur"))
          .setAge(resultSet.getInt("age"))
          .setHeight_cm(resultSet.getInt("height_cm"))
          .setWeight_kg(resultSet.getInt("weight_kg"))
          .setLeague_name(resultSet.getString("league_name"))
          .setClub_name(resultSet.getString("club_name"))
          .setNationality_name(resultSet.getString("nationality_name"))
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
      preparedStatement.setString(2, player.getShort_name());
      preparedStatement.setString(3, player.getLong_name());
      preparedStatement.setString(4, player.getPlayer_positions());
      preparedStatement.setInt(5, player.getValue_eur());
      preparedStatement.setInt(6, player.getAge());
      preparedStatement.setInt(7, player.getHeight_cm());
      preparedStatement.setDouble(8, player.getWeight_kg());
      preparedStatement.setString(9, player.getLeague_name());
      preparedStatement.setString(10, player.getClub_name());
      preparedStatement.setString(11, player.getNationality_name());
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
      preparedStatement.setString(1, updatePlayer.getShort_name());
      preparedStatement.setString(2, updatePlayer.getLong_name());
      preparedStatement.setString(3, updatePlayer.getPlayer_positions());
      preparedStatement.setInt(4, updatePlayer.getValue_eur());
      preparedStatement.setInt(5, updatePlayer.getAge());
      preparedStatement.setInt(6, updatePlayer.getHeight_cm());
      preparedStatement.setDouble(7, updatePlayer.getWeight_kg());
      preparedStatement.setString(8, updatePlayer.getLeague_name());
      preparedStatement.setString(9, updatePlayer.getClub_name());
      preparedStatement.setString(10, updatePlayer.getNationality_name());
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
