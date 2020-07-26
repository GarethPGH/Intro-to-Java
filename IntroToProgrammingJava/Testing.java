import java.awt.*;
import javax.swing.*;

class Testing
{
  public Testing()
  {
    String answer = new ColoredJOptionPane(Color.RED).showInputDialog("Color changed?");
    System.out.println(answer);
    System.exit(0);
  }

  public static void main(String args[]){new Testing();}
}
class ColoredJOptionPane extends JOptionPane
{
  public ColoredJOptionPane(){}
  public ColoredJOptionPane(Color c)
  {
    UIManager.put("OptionPane.background",c);
    UIManager.put("Panel.background",c);
    UIManager.put("Button.background",c);
  }
}