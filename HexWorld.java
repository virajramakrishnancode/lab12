package byow.lab12;
import org.junit.Test;
import static org.junit.Assert.*;

import byow.TileEngine.TERenderer;
import byow.TileEngine.TETile;
import byow.TileEngine.Tileset;

import java.util.ArrayList;
import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    private static final int WIDTH = 70;
    private static final int HEIGHT = 50;


    public static final ArrayList<Integer[]> tessFinder(int x, int y, int sideLength) {

        ArrayList<Integer[]> result = new ArrayList<>();

        // Integer[] initial = {x, y};
        // result.add(initial);

        int x_increment = 2 * sideLength - 1;
        int y_increment = sideLength;

        for (int i = 0; i < 3; i++) {

            int new_x = x + x_increment * i;
            int new_y = y + y_increment * i;
            Integer[] adding = {new_x, new_y};

            result.add(adding);

        }

        x = x - (sideLength*2 - 1);
        y += sideLength;

        for (int i = 0; i < 4; i++) {

            int new_x = x + x_increment * i;
            int new_y = y + y_increment * i;
            Integer[] adding = {new_x, new_y};

            result.add(adding);

        }

        x = x - (sideLength*2 - 1);
        y += sideLength;

        for (int i = 0; i < 5; i++) {

            int new_x = x + x_increment * i;
            int new_y = y + y_increment * i;
            Integer[] adding = {new_x, new_y};

            result.add(adding);

        }

        y += sideLength*2;

        for (int i = 0; i < 4; i++) {

            int new_x = x + x_increment * i;
            int new_y = y + y_increment * i;
            Integer[] adding = {new_x, new_y};

            result.add(adding);

        }

        y += sideLength*2;

        for (int i = 0; i < 3; i++) {

            int new_x = x + x_increment * i;
            int new_y = y + y_increment * i;
            Integer[] adding = {new_x, new_y};

            result.add(adding);

        }

        return result;
    }

    public static final void tessMaker(int x, int y, int sideLength, TETile[][] world) {

        ArrayList<Integer[]> result = tessFinder(x, y, sideLength);

        Random r = new Random(1000);

        ArrayList<TETile> allMaterials = new ArrayList<>();

        allMaterials.add(Tileset.TREE);
        allMaterials.add(Tileset.FLOWER);
        allMaterials.add(Tileset.GRASS);
        allMaterials.add(Tileset.WATER);
        allMaterials.add(Tileset.SAND);
        allMaterials.add(Tileset.MOUNTAIN);



        for (Integer[] corner: result) {

            int temp_x = corner[0];
            int temp_y = corner[1];

            int next = Math.floorMod(r.nextInt(), 6);

            addHexagon(temp_x, temp_y, sideLength, world, allMaterials.get(next));
        }

    }
    
    
    public static final void addHexagon(int x, int y, int sideLength, TETile[][] world, TETile material) {

        for (int i = 0; i < sideLength; i++) {

            writeLine(x - i, y + i, sideLength + 2*i, world, material);
        }

        for (int i = 0; i < sideLength; i++) {

            int start_x = x - (sideLength - 1);
            int startLen = sideLength + 2 * (sideLength - 1);
            int start_y = y + sideLength;

            writeLine(start_x + i, start_y + i, startLen - 2*i, world, material);
        }
    }

    private static final void writeLine(int x, int y, int size, TETile[][] world, TETile material) {

        for (int i = x; i < x + size; i++) {
            world[i][y] = material;
        }
    }

    public static void main(String[] args) {

        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        tessMaker(30, 10, 4, world);

        ter.renderFrame(world);

    }
}
