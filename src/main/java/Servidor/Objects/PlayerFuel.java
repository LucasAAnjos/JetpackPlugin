package Servidor.Objects;

public class PlayerFuel {
    private String name;
    private int fuel;

    public PlayerFuel(String name, int fuel) {
        this.name = name;
        this.fuel = fuel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
}
