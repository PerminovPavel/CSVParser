package ru.perminov.DAO;

import ru.perminov.Entity.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {
  private static final String jdbcUrl = "jdbc:postgresql://localhost:5400/postgres";
  private static final String username = "userok";
  private static final String password = "p@ssw0rd";

  private static Connection connection;

  static {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    try {
      connection = DriverManager.getConnection(jdbcUrl, username, password);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public List<Player> index() {
    List<Player> players = new ArrayList<>();

    try {
      Statement statement = connection.createStatement();
      String SQL = "SELECT * FROM players";
      ResultSet resultSet = statement.executeQuery(SQL);

      while (resultSet.next()) {
        Player player = new Player();

        player.setId(resultSet.getLong("id"));
        player.setShort_name(resultSet.getString("short_name"));
        player.setLong_name(resultSet.getString("long_name"));
        player.setPlayer_positions(resultSet.getString("player_positions"));
        player.setValue_eur(resultSet.getInt("value_eur"));
        player.setAge(resultSet.getInt("age"));
        player.setHeight_cm(resultSet.getInt("height_cm"));
        player.setWeight_kg(resultSet.getInt("weight_kg"));
        player.setLeague_name(resultSet.getString("league_name"));
        player.setClub_name(resultSet.getString("club_name"));
        player.setNationality_name(resultSet.getString("nationality_name"));

        players.add(player);
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    try {
      connection.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return players;
  }

  public Player show (int id) {
    Player player = null;

    try {
      PreparedStatement preparedStatement =
          connection.prepareStatement("SELECT * FROM players WHERE id=?");

      preparedStatement.setInt(1, id);

      ResultSet resultSet = preparedStatement.executeQuery();

      resultSet.next();

      player = new Player();

      player.setId(resultSet.getLong("id"));
      player.setShort_name(resultSet.getString("short_name"));
      player.setLong_name(resultSet.getString("long_name"));
      player.setPlayer_positions(resultSet.getString("player_positions"));
      player.setValue_eur(resultSet.getInt("value_eur"));
      player.setAge(resultSet.getInt("age"));
      player.setHeight_cm(resultSet.getInt("height_cm"));
      player.setWeight_kg(resultSet.getInt("weight_kg"));
      player.setLeague_name(resultSet.getString("league_name"));
      player.setClub_name(resultSet.getString("club_name"));
      player.setNationality_name(resultSet.getString("nationality_name"));

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    try {
      connection.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return player;
  }

  public void save(Player player) {
    try {
      PreparedStatement preparedStatement
          = connection.prepareStatement("INSERT INTO Players (id, short_name, long_name, player_positions, value_eur, age, height_cm, weight_kg, league_name, club_name, nationality_name) " +
          "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");

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
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    try {
      connection.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void update(int id, Player updatePlayer) {
    try {
      PreparedStatement preparedStatement =
          connection.prepareStatement("UPDATE Player SET short_name = ?, long_name = ?, player_positions = ?, value_eur = ?, age = ?, height_cm = ? , weight_kg = ? , league_name = ? , club_name = ?, nationality_name = ?  WHERE id=?");

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
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    try {
      connection.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void delete(int id) {
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("DELETE FROM players WHERE id=?");

      preparedStatement.setInt(1, id);

      preparedStatement.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    try {
      connection.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
