package frames;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import constants.GEConstants;
import menus.GEMenuBar;

public class GEMainFrame extends JFrame {
	// ��Ŭ�� ������ �̿��ؼ� ���� �ν��Ͻ��� ���´�
	private static GEMainFrame uniqueMainFrame = 
			new GEMainFrame(GEConstants.TITLE_MAINFRAME);
	
	private GEDrawingPanel drawingPanel;
	private GEMenuBar menuBar;
	private GEToolBar toolBar;
	
	private GEMainFrame(String title) {
		super(title);
		drawingPanel = new GEDrawingPanel();
		menuBar = new GEMenuBar();
		toolBar = new GEToolBar(GEConstants.TITLE_TOOLBAR);
		this.setJMenuBar(menuBar);
		this.add(drawingPanel);		// ö�ڰ� �� ���� �ڵ� �ϼ� �Ҷ� this�� �̿��ϸ� ���ϴ�
		this.add(BorderLayout.NORTH, toolBar);
	}
	
	// ������� ��ü�� �����ִ� �޼ҵ�
	public static GEMainFrame getInstance() {
		return uniqueMainFrame;
	}
	
	// ȭ���� ���� ���� �۾�
	// �ʱ�ȭ
	public void init() {
		toolBar.init(drawingPanel);
		menuBar.init(drawingPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(GEConstants.WIDTH_MAINFRAME, GEConstants.HEIGHT_MAINFRAME);
		this.setVisible(true);
	}
}
