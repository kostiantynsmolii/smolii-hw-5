class Level {
    private int width;
    private int height;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

class LevelTooBigException extends Exception {
    LevelTooBigException() {
        super();
    }
}

class LevelLoader {
public void load(Level level) throws LevelTooBigException {
        int result = level.getHeight() * level.getWidth();
        if (result < 100000) {
            System.out.println("Level loaded");
            return;
        }
       throw new LevelTooBigException();
    }
}

class LevelLoaderTest {
    public static void main(String[] args) {
        //Level loaded
        try {
            new LevelLoader().load(new Level(10, 20));
        } catch (LevelTooBigException ex) {
            System.out.println("Level too big");
        }

        //Level too big
        try {
            new LevelLoader().load(new Level(10000, 2000));
        } catch (LevelTooBigException ex) {
            System.out.println("Level too big");
        }
    }
}
