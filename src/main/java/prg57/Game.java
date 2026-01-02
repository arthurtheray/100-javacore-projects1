package prg57;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Класс хранит текущее состояние шахматной партии
 */
public class Game implements Serializable {
    private final LocalDateTime startTime;
    private LocalDateTime currentTime;
    private final List<ChessPiece> chessPieces;
    /**
     * Текущий ход после загрузки игры
     */
    private transient int moveNumber;
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     *
     * @param chessPieces список шахматных фигур на доске. От индекса каждой фигуры зависит ее расположение на доске.
     *                    Отсчет начинает с клетки A1, которая соответствует индексу 0 и заканчивается на клетке H8,
     *                    которой соответствует индекс 63. null означает пустую клетку.
     */
    public Game(List<ChessPiece> chessPieces) throws IndexOutOfBoundsException {
        if (chessPieces.size() != 64) {
            throw new IndexOutOfBoundsException("Неверное количество элементов: " + chessPieces.size());
        }
        this.startTime = LocalDateTime.now();
        this.chessPieces = chessPieces;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }

    public List<ChessPiece> getChessPieces() {
        return chessPieces;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public void setMoveNumber(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return moveNumber == game.moveNumber && Objects.equals(startTime, game.startTime) && Objects.equals(currentTime, game.currentTime) && Objects.equals(chessPieces, game.chessPieces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, currentTime, chessPieces, moveNumber);
    }

    @Override
    public String toString() {
        String gameInfo = "Game{" +
                "startTime=" + startTime +
                ", currentTime=" + currentTime +
                ", moveNumber=" + moveNumber +
                '}' +"\n";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(gameInfo);
        for (int i = 0; i < chessPieces.size(); i++) {
            ChessPiece cp = chessPieces.get(i);
            if (cp == null) {
                stringBuilder.append("[ ]");
            } else {
                stringBuilder.append("[").append(cp.getName()).append("]");
            }
            if ((i + 1) % 8 == 0) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
