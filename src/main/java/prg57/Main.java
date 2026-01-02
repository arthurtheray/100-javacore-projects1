package prg57;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static prg57.ChessPiece.*;

/**
 * 57. Сериализация объектов (Serializable)
 * Суть: сохранить объект в файл и загрузить обратно; на вход — объект; на выход — восстановленный объект (эквивалентность по equals).
 * Ограничения: ObjectOutputStream/ObjectInputStream; указать serialVersionUID; без внешних форматов.
 * Теория: механизм сериализации, совместимость версий, transient.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("data\\chess.dat");
        File file;
        try {
            if (!Files.exists(path)) {
                file = Files.createFile(path).toFile();
            } else {
                file = path.toFile();
            }
        } catch (IOException e) {
            System.out.println("Не удалось создать файл\n" + e);
            throw e;
        }
        List<ChessPiece> chessPieces = new ArrayList<>();
        chessPieces.add(WHITE_ROOK);
        chessPieces.add(WHITE_KNIGHT);
        chessPieces.add(WHITE_BISHOP);
        chessPieces.add(WHITE_KING);
        chessPieces.add(WHITE_QUEEN);
        chessPieces.add(WHITE_BISHOP);
        chessPieces.add(WHITE_KNIGHT);
        chessPieces.add(WHITE_ROOK);
        chessPieces.add(WHITE_PAWN);
        chessPieces.add(WHITE_PAWN);
        chessPieces.add(WHITE_PAWN);
        chessPieces.add(WHITE_PAWN);
        chessPieces.add(WHITE_PAWN);
        chessPieces.add(WHITE_PAWN);
        chessPieces.add(WHITE_PAWN);
        chessPieces.add(WHITE_PAWN);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(null);
        chessPieces.add(BLACK_PAWN);
        chessPieces.add(BLACK_PAWN);
        chessPieces.add(BLACK_PAWN);
        chessPieces.add(BLACK_PAWN);
        chessPieces.add(BLACK_PAWN);
        chessPieces.add(BLACK_PAWN);
        chessPieces.add(BLACK_PAWN);
        chessPieces.add(BLACK_PAWN);
        chessPieces.add(BLACK_ROOK);
        chessPieces.add(BLACK_KNIGHT);
        chessPieces.add(BLACK_BISHOP);
        chessPieces.add(BLACK_KING);
        chessPieces.add(BLACK_QUEEN);
        chessPieces.add(BLACK_BISHOP);
        chessPieces.add(BLACK_KNIGHT);
        chessPieces.add(BLACK_ROOK);
        Game game = new Game(chessPieces);
        System.out.println(game);
        Serializator serializator = new Serializator(file);
        serializator.serialize(game);
        Game game1 = serializator.deserialize(file);
        System.out.println(game1.equals(game));
    }
}
