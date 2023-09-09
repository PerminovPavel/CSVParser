package ru.perminov;

import ru.perminov.DAO.PlayerDAO;
import ru.perminov.Entity.Player;

import java.util.List;

public class Test {
  public static void main(String[] args) {
    PlayerDAO playerDAO = new PlayerDAO();
    List<Player> list = playerDAO.index();
    list.stream().filter(player -> player.getClub_name().equals("FC Barcelona")).forEach(System.out::println);
  }


}
