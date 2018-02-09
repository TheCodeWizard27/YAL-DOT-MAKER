package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import core.Model;

public class Canvas extends JPanel{
	private Model model;
	
	public Canvas(Model model) {
		super();
		this.setBackground(Color.BLACK);
	}
}
