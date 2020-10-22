package life;

public class Generation {
    private Universe universe;

    public Generation(Universe universe) {
        this.universe = universe;
    }

    public void nextGen() {
        Universe universeCopy = universe.copy();
        universeCopy.setGeneration(universe.getGeneration() + 1);

        for (int y = 0; y < universeCopy.getSize(); y++) {
            for (int x = 0; x < universeCopy.getSize(); x++) {
                int c = getCountOfNeighbors(x, y);

                if (!(c == 2 || c == 3)) {
                    if (universeCopy.getAreaScf(x, y)) universeCopy.setAlive(universeCopy.getAlive() + 1);
                    universeCopy.setArea(x, y, false);
                }
                else if (c == 3) {
                    if (!universeCopy.getAreaScf(x, y)) universeCopy.setAlive(universeCopy.getAlive() - 1);
                    universeCopy.setArea(x, y, true);
                }
            }
        }

        universe.update(universeCopy);
    }

    private int getCountOfNeighbors(int x, int y) {
        int count = 0;

        int left, right, top, down;

        left = x - 1;
        right = x + 1;
        top = y - 1;
        down = y + 1;

        if (x == 0) left = universe.getSize() - 1;
        if (y == 0) top = universe.getSize() - 1;

        if (x == universe.getSize() - 1) right = 0;
        if (y == universe.getSize() - 1) down = 0;

//        N
        if (universe.getAreaScf(x, top)) count++;
//        NE
        if (universe.getAreaScf(right, top)) count++;
//        E
        if (universe.getAreaScf(right, y)) count++;
//        SE
        if (universe.getAreaScf(right, down)) count++;
//        S
        if (universe.getAreaScf(x, down)) count++;
//        SW
        if (universe.getAreaScf(left, down)) count++;
//        W
        if (universe.getAreaScf(left, y)) count++;
//        NW
        if (universe.getAreaScf(left, top)) count++;

        return count;
    }
}
