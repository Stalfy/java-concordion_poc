import java.util.logging.Level;
import java.util.logging.Logger;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import org.powermock.reflect.Whitebox;

@RunWith(ConcordionRunner.class)
public class MainTest {

    public MainTest() {}

    public int solve(String input) {
        int exitCode = 0;

        try {
            Main main = new Main();
            exitCode = Whitebox.invokeMethod(main, "solve", input);
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, "Exception occured.", e);
            exitCode = -1;
        }
        
        return exitCode;
    }
}
