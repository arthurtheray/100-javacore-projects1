package prg57;

import java.io.*;

public class Serializator {
    private final File file;

    public Serializator(File file) {
        this.file = file;
    }

    public void serialize(Game game) throws FileNotFoundException {
        try (ObjectOutputStream os = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                )
        )) {
            os.writeObject(game);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            throw e;
        } catch (IOException e) {
            System.out.println("Ошибка создания потока");
        }
    }

    public Game deserialize(File file) throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException("Файл не доступен");
        }
        Game game = null;
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)))) {
            game = (Game) ois.readObject();
        } catch (IOException e) {
            System.err.println("Ошибка чтения из потока");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return game;
    }
}
