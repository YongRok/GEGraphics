package menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.GEConstants.EFileMenuItems;

public class GEMenuFile extends JMenu {

	public GEMenuFile(String s) {
		super(s);
		for(EFileMenuItems btn : EFileMenuItems.values()) {
			JMenuItem menuItem = new JMenuItem(btn.toString());
			this.add(menuItem);
		}
	}
	

}
