package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    public static final String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public static final int KEYS_LEN = KEYBOARD.length();

    public static void main(String[] args) {
        GuitarString[] list = new GuitarString[KEYS_LEN];
        for (int i = 0; i < KEYS_LEN; i++) {
            double fre = 440 * Math.pow(2, (i - 24) / 12.0);
            list[i] = new GuitarString(fre);
        }

        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = KEYBOARD.indexOf(key);
                if (index != -1) {
                    list[index].pluck();
                }
            }

            double sample = 0.0;
            for (GuitarString s: list) {
                sample += s.sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (GuitarString s: list) {
                s.tic();
            }
        }
    }
}
