package users.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="eyes")
public class Eyes {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "brand", nullable = false, length = 45)
    private String brand;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "consist", nullable = false, length = 150)
    private String consist;

    @Column(name = "liningMaterial", nullable = false, length = 150)
    private String liningMaterial;

    @Column(name = "country", nullable = false, length = 45)
    private String country;

    @Column(name = "provider", nullable = false)
    private int provider;
    public Eyes() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getConsist() {
        return consist;
    }

    public void setConsist(String consist) {
        this.consist = consist;
    }

    public String getLiningMaterial() {
        return liningMaterial;
    }

    public void setLiningMaterial(String liningMaterial) {
        this.liningMaterial = liningMaterial;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getProvider() {
        return provider;
    }

    public void setProvider(int provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "Eyes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", consist='" + consist + '\'' +
                ", liningMaterial='" + liningMaterial + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
