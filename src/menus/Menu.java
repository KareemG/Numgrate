package src.menus;
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import src.*;
public abstract class Menu implements ActionListener, View{
  private double buttonWidthFactor = 2.75;
  private double titleWidthFactor = 3.5;
  private double buttonHeightFactor = 7.75;
  private double titleHeightFactor = 4.6;
  private JPanel pane;
  private JButton buttonOne = null;
  private JButton buttonTwo = null;
  private JButton buttonThree = null;
  private JButton buttonFour = null;
  private JLabel gif = new JLabel();
  JLabel title = new JLabel();
  
  public Menu(JPanel pane) {
    this.pane = pane;
  }
  
  public void showUI() {
    pane.add(title);
    pane.add(gif);
    if (buttonOne != null)
    pane.add(buttonOne);
    if (buttonTwo != null)
    pane.add(buttonTwo);
    if (buttonThree != null)
    pane.add(buttonThree);
    if (buttonFour != null)
    pane.add(buttonFour);
  }
  
  public void removeUI() {
    if (buttonOne != null)
    pane.remove(buttonOne);
    if (buttonTwo != null)
    pane.remove(buttonTwo);
    if (buttonThree != null)
    pane.remove(buttonThree);
    if (buttonFour != null)
    pane.remove(buttonFour);
  }
  
  public void setButton(ImageIcon icon, ImageIcon rollIcon, String actionCommand, ActionListener i, int buttonNumber) {
    JButton button = new JButton();
    icon = new ImageIcon(icon.getImage().getScaledInstance((int)(pane.getWidth()/buttonWidthFactor),(int)(pane.getHeight()/buttonHeightFactor),java.awt.Image.SCALE_SMOOTH));
    rollIcon = new ImageIcon(rollIcon.getImage().getScaledInstance((int)(pane.getWidth()/buttonWidthFactor),(int)(pane.getHeight()/buttonHeightFactor),java.awt.Image.SCALE_SMOOTH));
    button.setIcon(icon);
    button.setBorderPainted(false);
    button.setContentAreaFilled(false);
    button.setFocusPainted(false);
    button.setRolloverIcon(rollIcon);
    button.setActionCommand(actionCommand);
    button.addActionListener(i);
    if (buttonNumber == 1)
      buttonOne = button;
    else if (buttonNumber == 2)
      buttonTwo = button;
    else if (buttonNumber == 3)
      buttonThree = button;
    else
      buttonFour = button;
  }
  
  public void constraints() {
    double widthButtonFactor = 45.6;
    double heightIntroFactor = 3.5;
    
    SpringLayout layout = (SpringLayout)pane.getLayout();
    
    if (buttonOne != null) {
    layout.putConstraint(SpringLayout.WEST, buttonOne, -1*(int)(pane.getWidth()/widthButtonFactor), SpringLayout.WEST, pane);
    layout.putConstraint(SpringLayout.NORTH, buttonOne, (int)(pane.getHeight()/heightIntroFactor), SpringLayout.NORTH, pane);
    }
    
    if (buttonTwo != null) {
    layout.putConstraint(SpringLayout.WEST, buttonTwo, -1*(int)(pane.getWidth()/widthButtonFactor), SpringLayout.WEST, pane);
    layout.putConstraint(SpringLayout.NORTH, buttonTwo, 2, SpringLayout.SOUTH, buttonOne);
    }
    
    if (buttonThree != null) {
    layout.putConstraint(SpringLayout.WEST, buttonThree, -1*(int)(pane.getWidth()/widthButtonFactor), SpringLayout.WEST, pane);
    layout.putConstraint(SpringLayout.NORTH, buttonThree, 2, SpringLayout.SOUTH, buttonTwo);
    }
    
    if (buttonFour != null) {
    layout.putConstraint(SpringLayout.WEST, buttonFour, -1*(int)(pane.getWidth()/widthButtonFactor), SpringLayout.WEST, pane);
    layout.putConstraint(SpringLayout.NORTH, buttonFour, 2, SpringLayout.SOUTH, buttonThree);
    }
  }
}