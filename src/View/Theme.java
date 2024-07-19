package View;

public class Theme {
    private final int red, green, blue;
    String theme_Name;

    public Theme(int red, int green, int blue, String theme_Name) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.theme_Name = theme_Name;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public String getTheme_Name() {
        return theme_Name;
    }
}
