
import java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class EpisodeTest {

    private Episode e1;

    @BeforeEach
    public void setUp() {
        this.e1 = new Episode(1, "7AM", LocalDate.of(2025, 1, 9), "R. Scott Gemmill", "John Wells");
    }

    @Test
    public void testGetEpisodeData() {
        assertEquals(1, e1.getEpisodeNumber());
        assertEquals("7AM", e1.getEpisodeTitle());
        assertEquals(LocalDate.of(2025, 1, 9), e1.getPublishedDate());
        assertEquals("R. Scott Gemmill", e1.getWriter());
        assertEquals("John Wells", e1.getDirector());
        assertEquals(50, e1.getDuration());
        assertEquals(0, e1.getWatchTime());
        assertEquals(0, e1.getRewatchCount());
        assertFalse(e1.isWatched());
        assertFalse(e1.isRewatched());
    }

    @Test
    public void testSetEpisodeData() {
        e1.setEpisodeNumber(2);
        e1.setEpisodeTitle("8PM");
        e1.setPublishedDate(LocalDate.of(2025, 1, 10));
        e1.setWriter("J. K. Rowling");
        e1.setDirector("J.K. Rowling");
        e1.setDuration(60);
        e1.setWatchTime(30);
        e1.setRewatchCount(2);
        e1.setWatched(true);
        assertTrue(e1.isWatched());
        assertTrue(e1.isRewatched());
    }
}
