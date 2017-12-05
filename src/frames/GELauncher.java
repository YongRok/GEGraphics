package frames;

public class GELauncher {
	public static void main(String[] args) {
		// 이미 GEMainFrame은 만들어 져있고 가져오기만 하는 것이다
		GEMainFrame frame = GEMainFrame.getInstance();
		frame.init();
	}
}
