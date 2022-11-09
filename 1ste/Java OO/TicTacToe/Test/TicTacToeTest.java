import TicTacToeGame.TicTacToe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void TestDeelbaarheidDrie(){
        TicTacToe game = new TicTacToe();
        assertTrue(game.delenDrie(444,3),"true");

    }

    @Test
    public void TestDeelbaarheidVijf(){
        TicTacToe game = new TicTacToe();
        assertTrue(game.delenVijf(55,5),"true");

    }

    @Test
    public void TestDeelbaarheidSeven(){
        TicTacToe game = new TicTacToe();
        assertTrue(game.delenSeven(77,7),"true");

    }

    @Test
    void testTicsTacsToes() {
        TicTacToe game = new TicTacToe();
        assertEquals("Tac Tac ",game.replace(5));
        assertEquals("Tic Tac Tac ",game.replace(15));
        assertEquals("Tac Tac ",game.replace(25));
    }

    @ParameterizedTest
    @MethodSource("generate")
    public void TestDeelbaar(int beginWaarde, int eindWaarde, int[]getallen, String[]woord){
        TicTacToe game = new TicTacToe();
        assertTrue(game.deelbaar(beginWaarde, eindWaarde, getallen, woord));

    }

    private static Stream<Arguments> generate(){
        return Stream.of(
                Arguments.of(0,20,new int[]{2,3},new String[]{"pief","poef"}),
                Arguments.of(50,100,new int[]{3,4},new String[]{"bam","boom"}),
                Arguments.of(1,99,new int[]{3,9},new String[]{"Duvel","Stella"})
        );
    }

}