import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class BowlingGameTest {

    @Test
    void should_input_full_score() {
        FrameScore[] frames=new FrameScore[11];
        for(int i=0;i<10;i++){
            frames[i]=new FrameScore(10);
        }
        frames[10]=new FrameScore(10,10);
        int result=BowlingGame.calculate(frames);
        assertEquals(result,300);
    }

    @Test
    void should_input_full_0() {
        FrameScore[] frames=new FrameScore[11];
        for(int i=0;i<11;i++){
            frames[i]=new FrameScore(0,0);
        }
        int result=BowlingGame.calculate(frames);
        assertEquals(result,0);
    }

    @Test
    void should_input_spare() {
        FrameScore[] frames=new FrameScore[11];
        for(int i=0;i<10;i++){
            frames[i]=new FrameScore(4,6);
        }
        frames[10]=new FrameScore(10);
        int result=BowlingGame.calculate(frames);
        assertEquals(result,146);
    }
}
