package src;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.util.*;

public class MainMenu implements ActionListener, View {
  JPanel pane;
  JLabel title = new JLabel();
  JButton intro = new JButton();
  JButton newtoncotes = new JButton();
  JButton gaussian = new JButton();
  JButton clenshaw = new JButton();
  JButton exit = new JButton();
  
  public MainMenu(JPanel pane) {
    this.pane = pane;
  }
  
  public void showUI() {
    URL titleURL = getClass().getResource("/assets/umgrate.png");
    URL introURL = getClass().getResource("/assets/introduction.png");
    URL introRollURL = getClass().getResource("/assets/introductionroll.png");
    URL newtonURL = getClass().getResource("/assets/newtoncotes.png");
    URL newtonRollURL = getClass().getResource("/assets/newtoncotesroll.png");
    URL gaussianURL = getClass().getResource("/assets/gaussian.png");
    URL gaussianRollURL = getClass().getResource("/assets/gaussianroll.png");
    URL clenshawURL = getClass().getResource("/assets/clenshaw.png");
    URL clenshawRollURL = getClass().getResource("/assets/clenshawroll.png");
    
    ImageIcon titleIcon = new ImageIcon(titleURL);
    ImageIcon introIcon = new ImageIcon(introURL);
    ImageIcon introRollIcon = new ImageIcon(introRollURL);
    ImageIcon newtonIcon = new ImageIcon(newtonURL);
    ImageIcon newtonRollIcon = new ImageIcon(newtonRollURL);
    ImageIcon gaussianIcon = new ImageIcon(gaussianURL);
    ImageIcon gaussianRollIcon = new ImageIcon(gaussianRollURL);
    ImageIcon clenshawIcon = new ImageIcon(clenshawURL);
    ImageIcon clenshawRollIcon = new ImageIcon(clenshawRollURL);
    
    titleIcon = new ImageIcon(titleIcon.getImage().getScaledInstance(240,120,java.awt.Image.SCALE_SMOOTH));
    introIcon = new ImageIcon(introIcon.getImage().getScaledInstance((int)(pane.getWidth()/2.8),(int)(pane.getHeight()/7.8),java.awt.Image.SCALE_SMOOTH));
    introRollIcon = new ImageIcon(introRollIcon.getImage().getScaledInstance((int)(pane.getWidth()/2.8),(int)(pane.getHeight()/7.8),java.awt.Image.SCALE_SMOOTH));
    newtonIcon = new ImageIcon(newtonIcon.getImage().getScaledInstance((int)(pane.getWidth()/2.8),(int)(pane.getHeight()/7.8),java.awt.Image.SCALE_SMOOTH));
    newtonRollIcon = new ImageIcon(newtonRollIcon.getImage().getScaledInstance((int)(pane.getWidth()/2.8),(int)(pane.getHeight()/7.8),java.awt.Image.SCALE_SMOOTH));
    gaussianIcon = new ImageIcon(gaussianIcon.getImage().getScaledInstance((int)(pane.getWidth()/2.8),(int)(pane.getHeight()/7.8),java.awt.Image.SCALE_SMOOTH));
    gaussianRollIcon = new ImageIcon(gaussianRollIcon.getImage().getScaledInstance((int)(pane.getWidth()/2.8),(int)(pane.getHeight()/7.8),java.awt.Image.SCALE_SMOOTH));
    clenshawIcon = new ImageIcon(clenshawIcon.getImage().getScaledInstance((int)(pane.getWidth()/2.8),(int)(pane.getHeight()/7.8),java.awt.Image.SCALE_SMOOTH));
    clenshawRollIcon = new ImageIcon(clenshawRollIcon.getImage().getScaledInstance((int)(pane.getWidth()/2.8),(int)(pane.getHeight()/7.8),java.awt.Image.SCALE_SMOOTH));
    
    title.setIcon(titleIcon);
    styleButton(intro,introIcon,introRollIcon);
    styleButton(newtoncotes,newtonIcon,newtonRollIcon);
    styleButton(gaussian,gaussianIcon,gaussianRollIcon);
    styleButton(clenshaw,clenshawIcon,clenshawRollIcon);
    constraints();
    pane.add(title);
    pane.add(intro);
    pane.add(newtoncotes);
    pane.add(gaussian);
    pane.add(clenshaw);
  }
  
  private void styleButton(JButton button, ImageIcon icon, ImageIcon rollIcon) {
    button.setIcon(icon);
    button.setBorderPainted(false);
    button.setContentAreaFilled(false);
    button.setFocusPainted(false);
    button.setRolloverIcon(rollIcon);
  }
  
  private void constraints() {
    SpringLayout layout = (SpringLayout)pane.getLayout();
    layout.putConstraint(SpringLayout.WEST, title, 19, SpringLayout.WEST, pane);
    layout.putConstraint(SpringLayout.NORTH, title, 25, SpringLayout.NORTH, pane);
    layout.putConstraint(SpringLayout.WEST, intro, -18, SpringLayout.WEST,pane);
    layout.putConstraint(SpringLayout.NORTH, intro, 15, SpringLayout.SOUTH, title);
    layout.putConstraint(SpringLayout.WEST, newtoncotes, -18, SpringLayout.WEST,pane);
    layout.putConstraint(SpringLayout.NORTH, newtoncotes, 2, SpringLayout.SOUTH, intro);
    layout.putConstraint(SpringLayout.WEST, gaussian, -18, SpringLayout.WEST,pane);
    layout.putConstraint(SpringLayout.NORTH, gaussian, 2, SpringLayout.SOUTH, newtoncotes);
    layout.putConstraint(SpringLayout.WEST, clenshaw, -18, SpringLayout.WEST,pane);
    layout.putConstraint(SpringLayout.NORTH, clenshaw, 2, SpringLayout.SOUTH, gaussian);
  }
  
  public void actionPerformed(ActionEvent ae) {
  }
}