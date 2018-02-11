package titlescreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import core.Model;
import mode.GameOption;
import mode.Mode;

public class TitleButton extends JButton implements ActionListener{
	private GameOption type;
	private Model model;
	
	public TitleButton(GameOption type, Model model) {
		super();
		this.model = model;
		this.type = type;
		this.addActionListener(this);
		this.setFocusable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(this.type) {
		case START:
			this.model.setMode(Mode.IN_GAME);
			break;
		case EXIT:
			this.model.setRun(false);
			break;
		}
	}
	
}
