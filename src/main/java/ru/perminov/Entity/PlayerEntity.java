package ru.perminov.Entity;

import java.util.Objects;

public final class PlayerEntity {
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

  private PlayerEntity(Builder builder) {
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

  @Override
  public String toString() {
    return "PlayerEntity{" +
        "id=" + id +
        ", short_name='" + short_name + '\'' +
        ", long_name='" + long_name + '\'' +
        ", player_positions='" + player_positions + '\'' +
        ", value_eur=" + value_eur +
        ", age=" + age +
        ", height_cm=" + height_cm +
        ", weight_kg=" + weight_kg +
        ", league_name='" + league_name + '\'' +
        ", club_name='" + club_name + '\'' +
        ", nationality_name='" + nationality_name + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PlayerEntity that = (PlayerEntity) o;
    return value_eur == that.value_eur && age == that.age && height_cm == that.height_cm && Double.compare(that.weight_kg, weight_kg) == 0 && Objects.equals(id, that.id) && Objects.equals(short_name, that.short_name) && Objects.equals(long_name, that.long_name) && Objects.equals(player_positions, that.player_positions) && Objects.equals(league_name, that.league_name) && Objects.equals(club_name, that.club_name) && Objects.equals(nationality_name, that.nationality_name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, short_name, long_name, player_positions, value_eur, age, height_cm, weight_kg, league_name, club_name, nationality_name);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
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



    private Builder() {
    }

    public Builder setId(Long id) {
      this.id = id;
      return this;
    }

    public Builder setShort_name(String short_name) {
      this.short_name = short_name;
      return this;
    }

    public Builder setLong_name(String long_name) {
      this.long_name = long_name;
      return this;
    }

    public Builder setPlayer_positions(String player_positions) {
      this.player_positions = player_positions;
      return this;
    }

    public Builder setValue_eur(int value_eur) {
      this.value_eur = value_eur;
      return this;
    }

    public Builder setAge(int age) {
      this.age = age;
      return this;
    }

    public Builder setHeight_cm(int height_cm) {
      this.height_cm = height_cm;
      return this;
    }

    public Builder setWeight_kg(double weight_kg) {
      this.weight_kg = weight_kg;
      return this;
    }

    public Builder setLeague_name(String league_name) {
      this.league_name = league_name;
      return this;
    }

    public Builder setClub_name(String club_name) {
      this.club_name = club_name;
      return this;
    }

    public Builder setNationality_name(String nationality_name) {
      this.nationality_name = nationality_name;
      return this;
    }
    public PlayerEntity build() {
      return new PlayerEntity(this);
    }
  }
}