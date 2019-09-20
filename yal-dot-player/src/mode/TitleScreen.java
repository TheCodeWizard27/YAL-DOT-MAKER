package mode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import core.Model;
import titlescreen.TitleButton;

/**
 * class for the titlescreen
 * @author bschab
 *
 */
public class TitleScreen {
	private JPanel container;
	private JLabel title;
	private Box btnContainer;
	private TitleButton startBtn;
	private TitleButton exitBtn;
	private JList mapList;
	private DefaultListModel list;
	private JScrollPane scrollPane;
	
	/**
	 * constructor
	 * @param model passes model information
	 */
	public TitleScreen(Model model) {
		this.title = new JLabel("YAL DOT PLAYER");
		this.title.setFont(new Font("", Font.BOLD, 40));
		this.title.setForeground(Color.WHITE);
		
		this.btnContainer = Box.createVerticalBox();
		this.container = new JPanel();
		this.mapList = new JList();
		this.list = new DefaultListModel();
		this.scrollPane = new JScrollPane(this.mapList);
		
		this.mapList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.mapList.setLayoutOrientation(JList.VERTICAL);
		
		//gets all maps in maps folder
		File[] maps = new File("maps/").listFiles();
		
		if(maps != null) {
			for(File file : maps) {
				this.list.addElement(file.getName());
			}
		}
		
		this.mapList.setModel(this.list);
		
		this.startBtn = new TitleButton(GameOption.START,model,this.mapList);
		this.exitBtn = new TitleButton(GameOption.EXIT,model,null);
		this.startBtn.setText("start");
		this.exitBtn.setText("exit");
		
		this.container.setLayout(new BorderLayout());
		
		this.btnContainer.add(startBtn, BorderLayout.NORTH);
		this.btnContainer.add(exitBtn, BorderLayout.SOUTH);
		
		this.container.add(mapList, BorderLayout.EAST);
		this.container.add(title,BorderLayout.NORTH);
		this.container.add(this.btnContainer, BorderLayout.WEST);
		this.container.setFocusable(false);
		this.container.setBackground(new Color(55,55,55));
		this.container.setPreferredSize(new Dimension(800,600));
	}
	
	/*
	 * getter
	 */
	public JPanel getTitle() {
		return this.container;
	}
}
