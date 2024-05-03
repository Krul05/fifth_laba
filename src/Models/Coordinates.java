package Models;

/**
 * Класс координат с полями <b>x</b>, <b>y</b>.
 */
public class Coordinates {
    private double x;
    private int y;
    /**
     *
     * @param x - X координата
     * @param y - Y координата
     */
    public Coordinates(double x, int y) {
        this.x = x;
        this.y = y;
    }
    public Coordinates() {

    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public String toString() {

        return "(" +x + "; " + y + ")";
    }
}
