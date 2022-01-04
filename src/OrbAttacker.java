import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class OrbAttacker {
	JFrame jf ;
	public static final int width = 1200  ;
	public static final int height = 900  ;
GamePanel GP;

public static void main(String[] args) {
	OrbAttacker OA = new OrbAttacker();
OA.setup();

}
OrbAttacker(){
	jf = new JFrame();
}
void setup() {
	GP = new GamePanel(jf);
	jf.add(GP);
	jf.setSize(width, height);
	jf.setVisible(true);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jf.addKeyListener(GP);


}
}
