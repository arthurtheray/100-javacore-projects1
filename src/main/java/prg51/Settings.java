package prg51;

import java.util.Arrays;

public class Settings {
    private final int width;
    private final int height;
    private final String color;

    public Settings(String userInput) throws WrongSettingsException {
        String[] tokens = userInput.split("\\s+");
        if (tokens.length != 3) {
            throw new WrongSettingsException("Неверное количество параметров");
        }
        if (Arrays.stream(Color.values()).noneMatch(color1 ->
                color1
                        .getColor()
                        .trim()
                        .equalsIgnoreCase(tokens[2]))) {
            throw new WrongSettingsException("Неверно указан цвет");
        } else {
            this.color = tokens[2];
        }
        try {
            this.width = Integer.parseInt(tokens[0]);
        } catch (NumberFormatException e) {
            throw new WrongSettingsException("Неверный формат ширины");
        }
        try {
            this.height = Integer.parseInt(tokens[1]);
        } catch (NumberFormatException e) {
            throw new WrongSettingsException("Неверный формат ширины");
        }
    }

    @Override
    public String toString() {
        return "Settings{" +
                "width=" + width +
                ", height=" + height +
                ", color='" + color + '\'' +
                '}';
    }
}

enum Color {
    RED("red"),
    GREEN("green"),
    BLUE("blue");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
