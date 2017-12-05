package menus;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.GEConstants;
import constants.GEConstants.EColorMeumItems;
import frames.GEDrawingPanel;

public class GEMenuColor extends JMenu {
	private GEDrawingPanel drawingPanel;
	private ColorMenuHandler colorMenuHandler;
	
	public GEMenuColor(String s) {
		super(s);
		
		colorMenuHandler = new ColorMenuHandler();
		for(EColorMeumItems btn : EColorMeumItems.values()) {
			JMenuItem menuItem = new JMenuItem(btn.toString());
			menuItem.setActionCommand(btn.toString());
			menuItem.addActionListener(colorMenuHandler);
			this.add(menuItem);
		}
	}
	
	public void init(GEDrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	public void setLineColor() {
		Color lineColor = JColorChooser.showDialog(null, GEConstants.TITLE_LINECOLOR, null);
		drawingPanel.setLineColor(lineColor);
	}
	
	public void setFillColor() {
		Color fillColor = JColorChooser.showDialog(null, GEConstants.TITLE_FILLCOLOR, null);
		drawingPanel.setFillColor(fillColor);
	}

	public void clearLineColor() {
		drawingPanel.setLineColor(GEConstants.DEFAULT_LINE_COLOR);
	}
	
	public void clearFillColor() {
		drawingPanel.setFillColor(GEConstants.DEFAULT_FILL_COLOR);	
	}

	private class ColorMenuHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch(EColorMeumItems.valueOf(e.getActionCommand())) {
			case SetLineColor:
				setLineColor();
				break;
			case SetFillColor:
				setFillColor();
				break;
			case ClearLineColor:
				setLineColor();
				break;
			case ClearFillColor:
				setFillColor();
				break;
			}
		}
	}
}
