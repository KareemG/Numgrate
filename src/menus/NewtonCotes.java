package src.menus;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import src.*;
import src.calculators.*;
public class NewtonCotes extends Menu{
  StateManager sm;
  JButton boole;
  JButton trapezoid;
  JButton simpson;
  Calculator calc = null;
  Calculator trapezoids;
  Calculator booles;
  Calculator simpsons;
  //JTextField field;
  JTextField field = new JTextField(20);
  
  public NewtonCotes(StateManager sm) {
    super(sm.pane);
    this.sm = sm;
    trapezoids = new Trapezoid(sm.pane);
    booles = new Boole(sm.pane);
    simpsons = new Simpson(sm.pane);
  }
  
  public void init() {
    try {
      URL trapURL = getClass().getResource("/assets/trapezoidrule.png");
      URL trapRollURL = getClass().getResource("/assets/trapezoidruleroll.png");
      URL booleURL = getClass().getResource("/assets/boolesrule.png");
      URL booleRollURL = getClass().getResource("/assets/boolesruleroll.png");
      URL simpsonURL = getClass().getResource("/assets/simpsonsrule.png");
      URL simpsonRollURL = getClass().getResource("/assets/simpsonsruleroll.png");
      URL backURL = getClass().getResource("/assets/back.png");
      URL backRollURL = getClass().getResource("/assets/backroll.png");
      
      ImageIcon trapIcon = new ImageIcon(trapURL);
      ImageIcon backIcon = new ImageIcon(backURL);
      ImageIcon booleIcon = new ImageIcon(booleURL);
      ImageIcon simpsonIcon = new ImageIcon(simpsonURL);
      ImageIcon trapRollIcon = new ImageIcon(trapRollURL);
      ImageIcon backRollIcon = new ImageIcon(backRollURL);
      ImageIcon booleRollIcon = new ImageIcon(booleRollURL);
      ImageIcon simpsonRollIcon = new ImageIcon(simpsonRollURL);
      
      setButton(trapIcon,trapRollIcon,"Trapezoid",this,1);
      setButton(booleIcon,booleRollIcon,"Boole",this,2);
      setButton(simpsonIcon,simpsonRollIcon,"Simpson",this,3);
      setButton(backIcon,backRollIcon,"Back",this,4);
      
      field.setText("Java Code Geeks");
      Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
      field.setBorder(border);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void removeUI() {
    super.removeUI();
   // if (field != null)
    //  sm.pane.remove(field);
  }
  
  public void constraints() {
    super.constraints();
    sm.layout.putConstraint(SpringLayout.SOUTH, field, -70, SpringLayout.SOUTH, sm.pane);
    sm.layout.putConstraint(SpringLayout.EAST, field, -30, SpringLayout.EAST, sm.pane);
  }
  
  public void actionPerformed(ActionEvent ae) {
    if (ae.getActionCommand().equals("Back")) {
      if (calc !=null)
      calc.removeUI();
      sm.setState(sm.MAINSTATE);
    }
    else if (ae.getActionCommand().equals("Boole")) {
      if (calc != null)
        calc.removeUI();
      calc = booles;
      calc.showUI();
      calc.constraints();
      
      sm.pane.repaint();
      sm.pane.validate();
      System.out.println("yey boole");
    }
    else if (ae.getActionCommand().equals("Trapezoid")) {
      if (calc != null)
        calc.removeUI();
      calc = trapezoids;
      calc.showUI();
      calc.constraints();
      
      sm.pane.repaint();
      sm.pane.validate();
    }
    else if (ae.getActionCommand().equals("Simpson")) {
      if (calc!= null)
        calc.removeUI();
      calc = simpsons;
      calc.showUI();
      calc.constraints();
      
      sm.pane.repaint();
      sm.pane.validate();
    }
  }
  
}