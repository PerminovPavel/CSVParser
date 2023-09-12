package ru.perminov.Entity;

import java.util.Objects;

public final class PlayerEntity {
  private Long id;
  private String shortName;
  private String longName;
  private String playerPositions;
  private int valueEur;
  private int age;
  private int heightCm;
  private double weightKg;
  private String leagueName;
  private String clubName;
  private String nationalityName;

  public Long getId() {
    return id;
  }

  public String getShortName() {
    return shortName;
  }

  public String getLongName() {
    return longName;
  }

  public String getPlayerPositions() {
    return playerPositions;
  }

  public int getValueEur() {
    return valueEur;
  }

  public int getAge() {
    return age;
  }

  public int getHeightCm() {
    return heightCm;
  }

  public double getWeightKg() {
    return weightKg;
  }

  public String getLeagueName() {
    return leagueName;
  }

  public String getClubName() {
    return clubName;
  }

  public String getNationalityName() {
    return nationalityName;
  }

  private PlayerEntity(Builder builder) {
    this.id = builder.id;
    this.shortName = builder.shortName;
    this.longName = builder.longName;
    this.playerPositions = builder.playerPositions;
    this.valueEur = builder.valueEur;
    this.age = builder.age;
    this.heightCm = builder.heightCm;
    this.weightKg = builder.weightKg;
    this.leagueName = builder.leagueName;
    this.clubName = builder.clubName;
    this.nationalityName = builder.nationalityName;
  }

  @Override
  public String toString() {
    return "PlayerEntity{" +
        "id=" + id +
        ", short_name='" + shortName + '\'' +
        ", long_name='" + longName + '\'' +
        ", player_positions='" + playerPositions + '\'' +
        ", value_eur=" + valueEur +
        ", age=" + age +
        ", height_cm=" + heightCm +
        ", weight_kg=" + weightKg +
        ", league_name='" + leagueName + '\'' +
        ", club_name='" + clubName + '\'' +
        ", nationality_name='" + nationalityName + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PlayerEntity that = (PlayerEntity) o;
    return valueEur == that.valueEur && age == that.age && heightCm == that.heightCm && Double.compare(that.weightKg, weightKg) == 0 && Objects.equals(id, that.id) && Objects.equals(shortName, that.shortName) && Objects.equals(longName, that.longName) && Objects.equals(playerPositions, that.playerPositions) && Objects.equals(leagueName, that.leagueName) && Objects.equals(clubName, that.clubName) && Objects.equals(nationalityName, that.nationalityName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, shortName, longName, playerPositions, valueEur, age, heightCm, weightKg, leagueName, clubName, nationalityName);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Long id;
    private String shortName;
    private String longName;
    private String playerPositions;
    private int valueEur;
    private int age;
    private int heightCm;
    private double weightKg;
    private String leagueName;
    private String clubName;
    private String nationalityName;



    private Builder() {
    }

    public Builder Id(Long id) {
      this.id = id;
      return this;
    }

    public Builder ShortName(String shortName) {
      this.shortName = shortName;
      return this;
    }

    public Builder LongName(String longName) {
      this.longName = longName;
      return this;
    }

    public Builder PlayerPositions(String playerPositions) {
      this.playerPositions = playerPositions;
      return this;
    }

    public Builder ValueEur(int valueEur) {
      this.valueEur = valueEur;
      return this;
    }

    public Builder Age(int age) {
      this.age = age;
      return this;
    }

    public Builder HeightCm(int heightCm) {
      this.heightCm = heightCm;
      return this;
    }

    public Builder WeightKg(double weightKg) {
      this.weightKg = weightKg;
      return this;
    }

    public Builder LeagueName(String leagueName) {
      this.leagueName = leagueName;
      return this;
    }

    public Builder ClubName(String clubName) {
      this.clubName = clubName;
      return this;
    }

    public Builder NationalityName(String nationalityName) {
      this.nationalityName = nationalityName;
      return this;
    }
    public PlayerEntity build() {
      return new PlayerEntity(this);
    }
  }
}