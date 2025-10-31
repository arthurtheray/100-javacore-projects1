package prg32;

public class Cat implements Animal, Drawable {

    @Override
    public int getNumberOfPaws() {
        return 4;
    }

    @Override
    public void draw(String drawingOptions) {
        System.out.println("Нарисован очень милый котик. " + drawingOptions);
    }
}
