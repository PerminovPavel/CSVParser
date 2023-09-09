package ru.perminov.Entity;

import java.util.Objects;

public class Player {
  private Long id;
  private String short_name ;
  private String long_name;
  private String player_positions;
  private int value_eur;
  private int age;
  private int height_cm;
  private double weight_kg;
  private String league_name;
  private String club_name;
  private String nationality_name;

  public Player() {
  }

  public Player(Builder builder) {
    this.id = builder.id;
    this.short_name = builder.short_name;
    this.long_name = builder.long_name;
    this.player_positions = builder.player_positions;
    this.value_eur = builder.value_eur;
    this.age = builder.age;
    this.height_cm = builder.height_cm;
    this.weight_kg = builder.weight_kg;
    this.league_name = builder.league_name;
    this.club_name = builder.club_name;
    this.nationality_name = builder.nationality_name;
  }

  public Long getId() {
    return id;
  }

  public String getShort_name() {
    return short_name;
  }

  public String getLong_name() {
    return long_name;
  }

  public String getPlayer_positions() {
    return player_positions;
  }

  public int getValue_eur() {
    return value_eur;
  }

  public int getAge() {
    return age;
  }

  public int getHeight_cm() {
    return height_cm;
  }

  public double getWeight_kg() {
    return weight_kg;
  }

  public String getLeague_name() {
    return league_name;
  }

  public String getClub_name() {
    return club_name;
  }

  public String getNationality_name() {
    return nationality_name;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setShort_name(String short_name) {
    this.short_name = short_name;
  }

  public void setLong_name(String long_name) {
    this.long_name = long_name;
  }

  public void setPlayer_positions(String player_positions) {
    this.player_positions = player_positions;
  }

  public void setValue_eur(int value_eur) {
    this.value_eur = value_eur;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setHeight_cm(int height_cm) {
    this.height_cm = height_cm;
  }

  public void setWeight_kg(double weight_kg) {
    this.weight_kg = weight_kg;
  }

  public void setLeague_name(String league_name) {
    this.league_name = league_name;
  }

  public void setClub_name(String club_name) {
    this.club_name = club_name;
  }

  public void setNationality_name(String nationality_name) {
    this.nationality_name = nationality_name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Player player = (Player) o;
    return Objects.equals(id, player.id) && Objects.equals(short_name, player.short_name) && Objects.equals(long_name, player.long_name) && Objects.equals(player_positions, player.player_positions) && Objects.equals(value_eur, player.value_eur) && Objects.equals(age, player.age) && Objects.equals(height_cm, player.height_cm) && Objects.equals(weight_kg, player.weight_kg) && Objects.equals(league_name, player.league_name) && Objects.equals(club_name, player.club_name) && Objects.equals(nationality_name, player.nationality_name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, short_name, long_name, player_positions, value_eur, age, height_cm, weight_kg, league_name, club_name, nationality_name);
  }

  @Override
  public String toString() {
    return "Player{" +
        "id='" + id + '\'' +
        ", short_name='" + short_name + '\'' +
        ", long_name='" + long_name + '\'' +
        ", player_positions='" + player_positions + '\'' +
        ", value_eur='" + value_eur + '\'' +
        ", age='" + age + '\'' +
        ", height_cm='" + height_cm + '\'' +
        ", weight_kg='" + weight_kg + '\'' +
        ", league_name='" + league_name + '\'' +
        ", club_name='" + club_name + '\'' +
        ", nationality_name='" + nationality_name + '\'' +
        '}';
  }

  public static class Builder {
    private Long id;
    private String short_name ;
    private String long_name;
    private String player_positions;
    private int value_eur;
    private int age;
    private int height_cm;
    private double weight_kg;
    private String league_name;
    private String club_name;
    private String nationality_name;

    public Builder() {
    }

    public Builder setId(Long id) {
      this.id = id;
      return this;
    }

    public Builder setShortName(String short_name) {
      this.short_name = short_name;
      return this;
    }

    public Builder setLongName(String long_name) {
      this.long_name = long_name;
      return this;
    }

    public Builder setPlayerPositions(String player_positions) {
      this.player_positions = player_positions;
      return this;
    }

    public Builder setValueEur(int value_eur) {
      this.value_eur = value_eur;
      return this;
    }

    public Builder setAge(int age) {
      this.age = age;
      return this;
    }

    public Builder setHeightCm(int height_cm) {
      this.height_cm = height_cm;
      return this;
    }

    public Builder setWeightKg(double weight_kg) {
      this.weight_kg = weight_kg;
      return this;
    }

    public Builder setLeagueName(String league_name) {
      this.league_name = league_name;
      return this;
    }

    public Builder setClubName(String club_name) {
      this.club_name = club_name;
      return this;
    }

    public Builder setNationalityName(String nationality_name) {
      this.nationality_name = nationality_name;
      return this;
    }

    public Player build() {
      return new Player(this);
    }
  }
}
