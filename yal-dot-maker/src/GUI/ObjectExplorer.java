package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import constants.ObjectType;
import core.Model;
import core.View;

public class ObjectExplorer extends JPanel implements ActionListener{
	private JFileChooser fileS = new JFileChooser();
	private JButton newBtn = new JButton("Open new file");
	private View view;
	
	public ObjectExplorer(View view, Model model) {
		super();
		this.view = view;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		for(ObjectType type : ObjectType.values()) {
			Element element = new Element(type, null, view , model);
			this.add(element);
		}
		this.add(newBtn);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		this.fileS.showOpenDialog(this);
	}
}
