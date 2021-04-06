import ca.minion.model.Minion;
import ca.minion.model.MinionManager;
import ca.minion.ui.MinionUI;

/**
 * The Class creates the model, creates the UI, and launches the program.
 */

public class Main {
    public static void main(String args[]) {
        MinionManager manager = new MinionManager();
        MinionUI ui = new MinionUI(manager);
        ui.show();
    }
}
