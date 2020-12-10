import java.io.*;
import java.util.ArrayList;
/*
@author Owen Lottman, Nat Hauck, John Thomas, Sam Deckel
@version 12/8/20
*/
class Question{
  String askQuestion,option1,option2,option3,option4;
  int correctAnwser,pointValue;
  /* @method 
  this is the default constructor which sets all the values of a 
  question object
  @param
  the paramater includes each seperate part of a question
  */
  Question(String a, String b, String c, String d, String e, int f, int g)
  {
    askQuestion=a;
    option1=b;
    option2=c;
    option3=d;
    option4=e;
    correctAnwser=f;
    pointValue=g;

  }
  /* @method @return
  returns the trivia question
  */
  String getQuestion(){
    return askQuestion;
  }
  /* @method @return
  returns the trivia option 1
  */
  String getOption1(){
    return option1;
  }
  /* @method @return
  returns the trivia option 2
  */
  String getOption2(){
    return option2;
  }
  /* @method @return
  returns the trivia option 3
  */
  String getOption3(){
    return option3;
  }
  /* @method @return
  returns the trivia option 4
  */
  String getOption4(){
    return option4;
  }
  /* @method @return
  returns the correct anwser to the trivia question
  */
  int getCorrectAnwser()
  {
    return correctAnwser;
  } 
  /* @method @return
  returns the point value to the question
  */
  int getPointValue()
  {
    return pointValue;
  }

}