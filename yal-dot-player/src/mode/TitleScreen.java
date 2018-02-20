package mode;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import core.Model;
import titlescreen.TitleButton;

public class TitleScreen {
	private JPanel container;
	private JLabel title;
	private JPanel btnContainer;
	private TitleButton startBtn;
	private TitleButton exitBtn;
	private JList mapList;
	private DefaultListModel list;
	private JScrollPane scrollPane;
	
	public TitleScreen(Model model) {
		this.title = new JLabel("YAL DOT PLAYER");
		this.btnContainer = new JPanel();
		this.container = new JPanel();
		this.mapList = new JList();
		this.list = new DefaultListModel();
		this.scrollPane = new JScrollPane(this.mapList);
		
		this.mapList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.mapList.setLayoutOrientation(JList.VERTICAL);
		
		File[] maps = new File("src/maps/").listFiles();
		
		for(File file : maps) {
			this.list.addElement(file.getName());
		}
		
		this.mapList.setModel(this.list);
		
		this.startBtn = new TitleButton(GameOption.START,model,this.mapList);
		this.exitBtn = new TitleButton(GameOption.EXIT,model,null);
		this.startBtn.setText("start");
		this.exitBtn.setText("exit");
		
		this.container.setLayout(new BorderLayout());
		this.btnContainer.setLayout(new BorderLayout());
		
		this.btnContainer.add(startBtn, BorderLayout.NORTH);
		this.btnContainer.add(exitBtn, BorderLayout.SOUTH);
		
		this.container.add(mapList, BorderLayout.EAST);
		this.container.add(title,BorderLayout.NORTH);
		this.container.add(this.btnContainer, BorderLayout.WEST);
		this.container.setFocusable(false);
	}
	
	public JPanel getTitle() {
		return this.container;
	}
}
