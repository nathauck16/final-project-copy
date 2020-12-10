import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/*
@author Owen Lottman, Nat Hauck, John Thomas, Sam Deckel
@version 12/8/20
*/
public class Game implements ActionListener{
  ArrayList<Question> questionList= new ArrayList<Question>();
  JLabel userWelcome,questionLabel, currentScore,questionWorth;
  JButton questionOneButton,questionTwoButton,questionThreeButton, questionFourButton,nextQuestion,beginButton,quitButton,resetButton;
  JTextField userNameEnter;
  int questionCount,userScore,beginButtonCount;
  String userNameFinal;
/* @method 
  this is the default method that reads all of the data from the trivia file in. It also sets up the frame and adds all labels, buttons, etc. It then fills the objects with the data from the array list of questions 
*/
  Game()
  {
    questionCount=0;
    try{
        FileReader myFile;
        myFile= new FileReader("trivia.txt");
        BufferedReader reader = new BufferedReader(myFile);
        while(reader.ready())
        {
          questionList.add(new Question(reader.readLine(),reader.readLine(),reader.readLine(),reader.readLine(),reader.readLine(),Integer.parseInt(reader.readLine()),Integer.parseInt(reader.readLine())));
        }
        reader.close();
      }catch(IOException exception){
        System.out.println("Error: "+ exception);
      }
    JFrame frame = new JFrame("Trivia Game");
    frame.setLayout(new GridLayout(12,1));
    frame.setSize(700,400);
    userWelcome = new JLabel("Welcome to this trivia game"); 
    beginButton= new JButton("Click to Enter Name");
    questionLabel = new JLabel("Enter Name");
    questionLabel.setFont(new Font("Serif", Font.PLAIN, 18));
    userNameEnter =new JTextField("Enter Name Here");
    questionWorth=new JLabel(" Worth: "+questionList.get(questionCount).getPointValue());
    currentScore= new JLabel("Score: "+ userScore);
    questionOneButton= new JButton(questionList.get(questionCount).getOption1());
    questionTwoButton= new JButton(questionList.get(questionCount).getOption2());
    questionThreeButton= new JButton(questionList.get(questionCount).getOption3());
    questionFourButton= new JButton(questionList.get(questionCount).getOption4());
    nextQuestion= new JButton("Next Question");
    quitButton= new JButton("Quit");
    resetButton = new JButton("Reset");

    questionOneButton.setVisible(false);
    questionTwoButton.setVisible(false);
    questionThreeButton.setVisible(false);
    questionFourButton.setVisible(false);
    nextQuestion.setVisible(false);
    questionWorth.setVisible(false);
    currentScore.setVisible(false);
    quitButton.setVisible(false);
    resetButton.setVisible(false);

    questionOneButton.addActionListener(this);
    questionTwoButton.addActionListener(this);
    questionThreeButton.addActionListener(this);
    questionFourButton.addActionListener(this);
    nextQuestion.addActionListener(this);
    beginButton.addActionListener(this);
    quitButton.addActionListener(this);
    resetButton.addActionListener(this);
    nextQuestion.setBackground(Color.RED);
    frame.add(questionLabel);
    frame.add(questionWorth);
    frame.add(userNameEnter);
    frame.add(currentScore);
    frame.add(beginButton);
    frame.add(questionOneButton);
    frame.add(questionTwoButton);
    frame.add(questionThreeButton);
    frame.add(questionFourButton);
    frame.add(nextQuestion);
    frame.add(resetButton);
    frame.add(quitButton);
    frame.setVisible(true);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
  }

  /* @method 
   Allows buttons to have functionality. Makes user able to move onto next question and select anwser choices. Also enables users to quit and reset game
   @param 
   Action Event allows functionality to buttons and other interactable objects
  */
  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==questionOneButton&&questionList.get(questionCount).getCorrectAnwser()==1)
    {
      questionLabel.setText("Congrats, that is the correct anwser!");
      userScore+=questionList.get(questionCount).getPointValue();
      questionCount++;
      currentScore.setText("Score: "+userScore);
      nextQuestion.setBackground(Color.GREEN);
    }
    else if(ae.getSource()==questionTwoButton&&questionList.get(questionCount).getCorrectAnwser()==2)
    {
      questionLabel.setText("Congrats, that is the correct anwser!");
      userScore+=questionList.get(questionCount).getPointValue();
      questionCount++;
      currentScore.setText("Score: "+userScore);
      nextQuestion.setBackground(Color.GREEN);
    }
    else if(ae.getSource()==questionThreeButton&&questionList.get(questionCount).getCorrectAnwser()==3)
    {
      questionLabel.setText("Congrats, that is the correct anwser!");
      userScore+=questionList.get(questionCount).getPointValue();
      questionCount++;
      currentScore.setText("Score: "+userScore);
      nextQuestion.setBackground(Color.GREEN);
    }
    else if(ae.getSource()==questionFourButton&&questionList.get(questionCount).getCorrectAnwser()==4)
    {
      questionLabel.setText("Congrats, that is the correct anwser!");
      userScore+=questionList.get(questionCount).getPointValue();
      questionCount++;
      currentScore.setText("Score: "+userScore);
      nextQuestion.setBackground(Color.GREEN);
    }
    else if(ae.getSource()==questionOneButton&&questionList.get(questionCount).getCorrectAnwser()!=1)
    {
      questionLabel.setText("Sorry, that is the wrong anwser");
      userScore = userScore-1;
      currentScore.setText("Score: "+userScore);
      questionOneButton.setVisible(false);
    }
    else if(ae.getSource()==questionTwoButton&&questionList.get(questionCount).getCorrectAnwser()!=2)
    {
      questionLabel.setText("Sorry, that is the wrong anwser");
      userScore = userScore-1;
      currentScore.setText("Score: "+userScore);
      questionTwoButton.setVisible(false);
    }
    else if(ae.getSource()==questionThreeButton&&questionList.get(questionCount).getCorrectAnwser()!=3)
    {
      questionLabel.setText("Sorry, that is the wrong anwser");
      userScore = userScore-1;
      currentScore.setText("Score: "+userScore);
      questionThreeButton.setVisible(false);
    }
    else if(ae.getSource()==questionFourButton&&questionList.get(questionCount).getCorrectAnwser()!=4)
    {
      questionLabel.setText("Sorry, that is the wrong anwser");
      userScore = userScore-1;
      currentScore.setText("Score: "+userScore);
      questionFourButton.setVisible(false);
    }
    else if(ae.getSource()==nextQuestion)
    {
      if(questionCount!=5)
      {
        questionLabel.setText((questionList.get(questionCount).getQuestion()));
        questionWorth.setText(" Worth: "+questionList.get(questionCount).getPointValue());
        questionOneButton.setText(questionList.get(questionCount).getOption1());
        questionTwoButton.setText(questionList.get(questionCount).getOption2());
        questionThreeButton.setText(questionList.get(questionCount).getOption3());
        questionFourButton.setText(questionList.get(questionCount).getOption4());
        questionOneButton.setVisible(true);
        questionTwoButton.setVisible(true);
        questionThreeButton.setVisible(true);
        questionFourButton.setVisible(true);
        nextQuestion.setBackground(Color.RED);
      }
      else{
        questionLabel.setText("You have finished the trivia game with "+userScore+" points.");
        questionWorth.setVisible(false);
        currentScore.setVisible(false);
        questionOneButton.setVisible(false);
        questionTwoButton.setVisible(false);
        questionThreeButton.setVisible(false);
        questionFourButton.setVisible(false);
        nextQuestion.setVisible(false);
        resetButton.setVisible(true);
        try{
          FileWriter toWriteFile;
          toWriteFile = new FileWriter("scores.txt");
          BufferedWriter output=new BufferedWriter(toWriteFile);
          output.write(userNameFinal);
          output.write(userScore+"");
          output.newLine();
          output.close();
      }catch(IOException exception){
          System.out.println("Error: "+ exception);
        }
      }
    }
    else if(ae.getSource()==resetButton){
      questionCount=0;
      questionLabel.setText((questionList.get(questionCount).getQuestion()));
      questionWorth.setText(" Worth: "+questionList.get(questionCount).getPointValue());
      questionOneButton.setText(questionList.get(questionCount).getOption1());
      questionTwoButton.setText(questionList.get(questionCount).getOption2());
      questionThreeButton.setText(questionList.get(questionCount).getOption3());
      questionFourButton.setText(questionList.get(questionCount).getOption4());
      questionOneButton.setVisible(true);
      questionTwoButton.setVisible(true);
      questionThreeButton.setVisible(true);
      questionFourButton.setVisible(true);
      nextQuestion.setVisible(true);
      questionWorth.setVisible(true);
      currentScore.setVisible(true);
      quitButton.setVisible(true);
      resetButton.setVisible(true);
      nextQuestion.setBackground(Color.RED);
      userScore = 0;
      currentScore.setText("Score: "+userScore);

    }
    else if(ae.getSource()==beginButton)
    {
      
      if(beginButtonCount==0)
      {
        questionLabel.setText("Welcome "+userNameEnter.getText());
        userNameFinal=userNameEnter.getText();
        userNameEnter.setVisible(false);
        beginButton.setText("Click here to begin");
      }
      else if(beginButtonCount>0)
      {
        questionLabel.setText(questionList.get(questionCount).getQuestion()+" Worth: "+questionList.get(questionCount).getPointValue());
        beginButton.setVisible(false);
        questionOneButton.setVisible(true);
        questionTwoButton.setVisible(true);
        questionThreeButton.setVisible(true);
        questionFourButton.setVisible(true);
        nextQuestion.setVisible(true);
        questionWorth.setVisible(true);
        currentScore.setVisible(true);
        quitButton.setVisible(true);
      }
      beginButtonCount++;

    }
    else if (ae.getSource()==quitButton){
      questionLabel.setText("You have quit the trivia game. You had "+userScore+" points.");
        questionWorth.setVisible(false);
        currentScore.setVisible(false);
        questionOneButton.setVisible(false);
        questionTwoButton.setVisible(false);
        questionThreeButton.setVisible(false);
        questionFourButton.setVisible(false);
        nextQuestion.setVisible(false);
        quitButton.setVisible(false);
        resetButton.setVisible(true);
    }

    
  }


}