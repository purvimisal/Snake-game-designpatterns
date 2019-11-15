import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
public class Level1 implements Ilevel{

    LevelController controller;

    public Level1(LevelController controller) {
        
        this.controller = controller;
    }

    @Override
    public void changeState() {
        JOptionPane.showMessageDialog(new JInternalFrame(), "Level2","Congrats!", JOptionPane.INFORMATION_MESSAGE);
       // System.out.println("level1 to level2");
        controller.changeLevel2();
        
    }
}
