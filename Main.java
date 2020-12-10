import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
@author Owen Lottman, Nat Hauck, John Thomas, Sam Deckel
@version 12/8/20
*/
class Main {
  /*
  This is the main where the game is called
  */
 public static void main(String args[]) {
   SwingUtilities.invokeLater(new Runnable() {
     public void run() {
        new Game();
     }
   });
 }
} 
