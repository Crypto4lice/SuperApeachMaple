import java.awt.Button;
import java.awt.Frame;

public class GraphicUI {
	public void createFrame() {
		
		Frame frame = new Frame("abc");
		Button button = new Button("but");
		
		frame.add(button);
		
		frame.setSize(300,600);
		
		frame.setVisible(true);
	}
}
