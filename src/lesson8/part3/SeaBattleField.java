package lesson8.part3;

public class SeaBattleField {
    public int sizeX;
    public int sizeY;
    private byte[][] field = new byte[sizeX][sizeY];

    // inner class.
    // Внутренний класс. Нельзя создавать static-переменные, но можно создавать константы (static final)
    public class Ship {
        int x, y;
        boolean isVertical;
        int length;
        int maxLength = 5;
        final static int MAX_LENGTH = 5;

        public Ship(int length) {
            this.length = length;
        }

        void generateShip() {
            for (int i = 0; i < sizeY; i++) {
                for (int j = 0; j < sizeX; j++) {
// ...
                }
            }
        }
    }

}
