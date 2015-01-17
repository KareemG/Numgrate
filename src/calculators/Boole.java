package src.calculators;
import src.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Boole extends Calculator {
  int intervals;
  final double constant = 2.0/45.0;
  JLabel title = new JLabel("Trapezoid Rule");
  JLabel sentence = new JLabel("The intergral is approximated using the following formula:");
  JLabel formula = new JLabel();
  public void init() {
    super.init();
    
    try {
      ImageIcon titleImg = new ImageIcon(getClass().getResource("/assets/booletitle.png"));
      ImageIcon formImg = new ImageIcon(getClass().getResource("/assets/booleform.png"));
      formImg = new ImageIcon(formImg.getImage().getScaledInstance(340,40,java.awt.Image.SCALE_SMOOTH));
      titleImg = new ImageIcon(titleImg.getImage().getScaledInstance(220,57,java.awt.Image.SCALE_SMOOTH));
      title = new JLabel(titleImg);
      formula = new JLabel(formImg);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void showUI() {
    super.showUI();
    pane.add(title);
    pane.add(sentence);
    pane.add(formula);
  }
  
  public void removeUI() {
    super.removeUI();
    pane.remove(title);
    pane.remove(sentence);
    pane.remove(formula);
  }
  public void constraints() {
    super.constraints();
    layout.putConstraint(SpringLayout.NORTH, title, 50, SpringLayout.NORTH, pane);
    layout.putConstraint(SpringLayout.EAST, title, -133, SpringLayout.EAST, pane);
    
    layout.putConstraint(SpringLayout.NORTH, sentence, 110, SpringLayout.NORTH, pane);
    layout.putConstraint(SpringLayout.EAST, sentence, -80, SpringLayout.EAST, pane);
    
    layout.putConstraint(SpringLayout.NORTH, formula, 10, SpringLayout.SOUTH, sentence);
    layout.putConstraint(SpringLayout.EAST, formula, -74, SpringLayout.EAST, pane);
  }
  public Boole(JPanel pane) {
    super(pane,true);
    setInterval(4);
  }

  public String calculate() {
    double value = constant*((outer-inner)/interval)*(7*values.get(0) + 32*values.get(1) + 12*values.get(2) + 32*values.get(3) + 7*values.get(4));
    //System.out.println(values.get(0) + " " + values.get(1) + " " + values.get(2) + " " + values.get(3) + " " + values.get(4));
    System.out.println(value);
    return "" + value;

  }
}