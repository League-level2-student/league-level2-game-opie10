import javax.swing.JFrame;

public class OrbAttacker {
	JFrame jf ;
	public static final int width = 1200  ;
	public static final int height = 900  ;
	GamePanel GP = new GamePanel();

public static void main(String[] args) {
	OrbAttacker OA = new OrbAttacker();
OA.setup();
}
OrbAttacker(){
	jf = new JFrame();
}
void setup() {
	jf.add(GP);
	jf.setSize(width, height);
	jf.setVisible(true);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jf.addKeyListener(GP);
}
}
