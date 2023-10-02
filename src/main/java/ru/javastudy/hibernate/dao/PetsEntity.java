package ru.javastudy.hibernate.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "pets", schema = "webdb1", catalog = "webdb1")
public class PetsEntity {
    private int id;
    private String animalName;
    private String animalType;
    private String animalColor;
    private Integer animalAge;
    private String animalHost;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "AnimalName", nullable = true, length = 30)
    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    @Basic
    @Column(name = "AnimalType", nullable = true, length = 30)
    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    @Basic
    @Column(name = "AnimalColor", nullable = true, length = 30)
    public String getAnimalColor() {
        return animalColor;
    }

    public void setAnimalColor(String animalColor) {
        this.animalColor = animalColor;
    }

    @Basic
    @Column(name = "AnimalAge", nullable = true)
    public Integer getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(Integer animalAge) {
        this.animalAge = animalAge;
    }

    @Basic
    @Column(name = "AnimalHost", nullable = true, length = 30)
    public String getAnimalHost() {
        return animalHost;
    }

    public void setAnimalHost(String animalHost) {
        this.animalHost = animalHost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PetsEntity that = (PetsEntity) o;

        if (id != that.id) return false;
        if (animalName != null ? !animalName.equals(that.animalName) : that.animalName != null) return false;
        if (animalType != null ? !animalType.equals(that.animalType) : that.animalType != null) return false;
        if (animalColor != null ? !animalColor.equals(that.animalColor) : that.animalColor != null) return false;
        if (animalAge != null ? !animalAge.equals(that.animalAge) : that.animalAge != null) return false;
        if (animalHost != null ? !animalHost.equals(that.animalHost) : that.animalHost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (animalName != null ? animalName.hashCode() : 0);
        result = 31 * result + (animalType != null ? animalType.hashCode() : 0);
        result = 31 * result + (animalColor != null ? animalColor.hashCode() : 0);
        result = 31 * result + (animalAge != null ? animalAge.hashCode() : 0);
        result = 31 * result + (animalHost != null ? animalHost.hashCode() : 0);
        return result;
    }
}
