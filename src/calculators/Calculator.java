package src.calculators;
import src.View;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;
public abstract class Calculator implements ActionListener{
  boolean usesSetInterval;
  JLabel polyLab = new JLabel("f(x):");
  JLabel innerLab = new JLabel("Inner Bound:");
  JLabel outerLab = new JLabel("Outer Bound:");
  JLabel interLab = new JLabel("Intervals:");
  JLabel resultLab = new JLabel("Result:");
  JTextField polynomial = new JTextField (20);
  JTextField innerBound = new JTextField (20);
  JTextField outerBound= new JTextField (20);
  JTextField intervals = new JTextField (20);
  JTextField result= new JTextField (20);
  JButton calculate = new JButton("Calculate!");
  boolean added = false;
  Equations equation = new Equations();
  JPanel pane;
  int interval;
  int inner;
  int outer;
  public Calculator(JPanel pane, boolean interval) {
    this.pane = pane;
    Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
    polynomial.setBorder(border);
    innerBound.setBorder(border);
    outerBound.setBorder(border);
    intervals.setBorder(border);
    result.setBorder(border);
    usesSetInterval = interval;
    calculate.addActionListener(this);
  }
  
  public void removeUI(){
    pane.remove(polynomial);
    pane.remove(polyLab);
    pane.remove(innerBound);
    pane.remove(innerLab);
    pane.remove(outerBound);
    pane.remove(outerLab);
    pane.remove(intervals);
    pane.remove(interLab);
    pane.remove(result);
    pane.remove(resultLab);
    pane.remove(calculate);
  }
  
  public void showUI(){
    pane.add(polynomial);
    pane.add(polyLab);
    pane.add(innerBound);
    pane.add(innerLab);
    pane.add(outerBound);
    pane.add(outerLab);
    if (!usesSetInterval) {
    pane.add(intervals);
    pane.add(interLab);
    }
    pane.add(result);
    pane.add(resultLab);
    pane.add(calculate);
  }
  
  public void constraints(){
    SpringLayout layout = (SpringLayout)pane.getLayout();
    System.out.println(pane.getHeight());
    layout.putConstraint(SpringLayout.EAST, polynomial, (int)(-1*(pane.getWidth()/6.3)), SpringLayout.EAST, pane);
    layout.putConstraint(SpringLayout.SOUTH, polynomial,(int)(-1*(pane.getHeight()/2.24)), SpringLayout.SOUTH, pane);
    
    layout.putConstraint(SpringLayout.EAST, polyLab, (int)(-1*(pane.getWidth()/81.7)), SpringLayout.WEST, polynomial);
    layout.putConstraint(SpringLayout.SOUTH, polyLab,(int)(-1*(pane.getHeight()/2.2415)),SpringLayout.SOUTH,pane);
    
    layout.putConstraint(SpringLayout.EAST,innerBound,(int)(-1*(pane.getWidth()/6.284)),SpringLayout.EAST,pane);
    layout.putConstraint(SpringLayout.NORTH,innerBound,(int)(pane.getHeight()/54.8),SpringLayout.SOUTH,polynomial);
    
    layout.putConstraint(SpringLayout.EAST, innerLab, (int)(-1*(pane.getWidth()/81.7)), SpringLayout.WEST, innerBound);
    layout.putConstraint(SpringLayout.NORTH, innerLab,(int)(pane.getHeight()/42.154),SpringLayout.SOUTH,polyLab);
    
    layout.putConstraint(SpringLayout.EAST, outerBound,(int)(-1*(pane.getWidth()/6.284)),SpringLayout.EAST,pane);
    layout.putConstraint(SpringLayout.NORTH,outerBound,(int)(pane.getHeight()/54.8),SpringLayout.SOUTH,innerBound);
    
    layout.putConstraint(SpringLayout.EAST, outerLab, (int)(-1*(pane.getWidth()/81.7)), SpringLayout.WEST, outerBound);
    layout.putConstraint(SpringLayout.NORTH, outerLab,(int)(pane.getHeight()/42.154),SpringLayout.SOUTH,innerLab);
    
    layout.putConstraint(SpringLayout.EAST,intervals,(int)(-1*(pane.getWidth()/6.284)),SpringLayout.EAST,pane);
    layout.putConstraint(SpringLayout.NORTH,intervals,(int)(pane.getHeight()/54.8),SpringLayout.SOUTH,outerBound);
    
    layout.putConstraint(SpringLayout.EAST, interLab, (int)(-1*(pane.getWidth()/81.7)), SpringLayout.WEST, innerBound);
    layout.putConstraint(SpringLayout.NORTH, interLab,(int)(pane.getHeight()/42.154),SpringLayout.SOUTH,outerLab);
    
    layout.putConstraint(SpringLayout.EAST, calculate, (int)(-1*(pane.getWidth()/4.2)), SpringLayout.EAST,pane);
    layout.putConstraint(SpringLayout.NORTH,calculate,(int)(pane.getHeight()/54.8), SpringLayout.SOUTH, intervals);
    
    layout.putConstraint(SpringLayout.EAST,result,(int)(-1*(pane.getWidth()/6.284)),SpringLayout.EAST,pane);
    layout.putConstraint(SpringLayout.NORTH,result,(int)(pane.getHeight()/54.8),SpringLayout.SOUTH,calculate);
    
    layout.putConstraint(SpringLayout.EAST,resultLab, (int)(-1*(pane.getWidth()/81.7)), SpringLayout.WEST, result);
    layout.putConstraint(SpringLayout.NORTH, resultLab,(int)(pane.getHeight()/42.154),SpringLayout.SOUTH, calculate);
  }
  
  public abstract String calculate (ArrayList<Integer> values);
  
  public void setInterval(int interval) {
    this.interval = interval;
  }
  public ArrayList<Integer> values(int interval) {
    ArrayList<Integer> value = new ArrayList<Integer>();
    inner = Integer.parseInt(innerBound.getText());
    outer = Integer.parseInt(outerBound.getText());
    try {
     // if (equation.check(polynomial.getText())){
   //   for (int x = inner; x < outer; x = x + ((outer-inner)/interval)) {
        value.add((int)(equation.result("x+y", 1, 2)));
    //}
      //}
      //else
      //      System.out.println("bad equation");
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return value;
  }
  
  public void actionPerformed(ActionEvent ae) {
    if (ae.getActionCommand().equals("Calculate!")) {
      
      
      if (polynomial.getText().equals(""))
        result.setText("Please enter a function.");
      else if (innerBound.getText().equals(""))
        result.setText("Please enter a lower limit.");
      else if (outerBound.getText().equals(""))
        result.setText("Please enter an upper limit.");
      else if (!usesSetInterval && intervals.getText().equals(""))
        result.setText("Please enter an interval");
      else
        result.setText(calculate(values(interval)));
    }
  }
}