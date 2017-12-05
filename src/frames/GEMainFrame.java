package frames;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import constants.GEConstants;
import menus.GEMenuBar;

public class GEMainFrame extends JFrame {
	// 싱클톤 패턴을 이용해서 다중 인스턴스를 막는다
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
		this.add(drawingPanel);		// 철자가 긴 것을 자동 완성 할때 this를 이용하면 편리하다
		this.add(BorderLayout.NORTH, toolBar);
	}
	
	// 만들어진 객체를 돌려주는 메소드
	public static GEMainFrame getInstance() {
		return uniqueMainFrame;
	}
	
	// 화면을 띄우기 위한 작업
	// 초기화
	public void init() {
		toolBar.init(drawingPanel);
		menuBar.init(drawingPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(GEConstants.WIDTH_MAINFRAME, GEConstants.HEIGHT_MAINFRAME);
		this.setVisible(true);
	}
}
