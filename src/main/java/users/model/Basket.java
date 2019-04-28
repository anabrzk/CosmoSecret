package users.model;

import javax.persistence.*;

@Entity
@Table(name="basket")
public class Basket {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type", nullable = false)
    private int type;

    @Column(name = "idThing", nullable = false)
    private int idThing;

    @Column(name = "color", nullable = false, length = 45)
    private String color;

    @Column(name = "size", nullable = false, length = 45)
    private String size;

    @Column(name = "state", nullable = false)
    private int state;

    @Column(name = "username", nullable = false)
    private int username;

    public Basket() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIdThing() {
        return idThing;
    }

    public void setIdThing(int idThing) {
        this.idThing = idThing;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", type=" + type +
                ", idThing=" + idThing +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", state=" + state +
                ", username='" + username + '\'' +
                '}';
    }
}
