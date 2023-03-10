/*
Implement by: Abdulrahman Taymor 20210200

Maintenance by: Tarek Mostafa 20200916

Test by: Tarek Mostafa 20200916/Ahmed Mohamed Ahmed Sadek 20210029
Total time: 7h
game with java
 */
import java.util.Scanner;
public class Main {

  public static void main(String[] args) {
    GameManager gm=new GameManager();
    gm.managegame();

  }
}

class Board{
  int turns=0;
  Scanner scanner=new Scanner(System.in);
  String[][] board = {{"-","-","-"},{"-","-","-"},{"-","-","-"}};
  boolean player=true;
  void add(){   //addition function
    System.out.println("Add a number between 0 -> 8 ");
    int uinp=scanner.nextInt();
    if (uinp>8 || uinp<0) {
      System.out.println("Invalid Input >=^( ");
    }else{
    int a=uinp/3;
    int b=uinp%3;   //Equation for 3x3 board
    if(board[a][b]=="-"){
      if(player){
        board[a][b]="X";
        turns++;
      }else{
        board[a][b]="0";
        turns++;
      }
    }else{
      System.out.println("Invalid Input !");
    }
    player=! player;    //alter player
  }}
  void printboard(){  //display board
    for (String[] i : board) {
      System.out.println(i[0]+" "+i[1]+" "+i[2]);
    }
  }
  boolean check(){      //Checks for winner
    if(board[0][0]=="X" &&board[0][1]=="X" &&board[0][2]=="X" ||board[0][0]=="0" &&board[0][1]=="0" &&board[0][2]=="0" ){
      return true;
    }
    if(board[1][0]=="X" &&board[1][1]=="X" &&board[1][2]=="X" ||board[1][0]=="0" &&board[1][1]=="0" &&board[1][2]=="0" ){
      return true;
    }
    if(board[2][0]=="X" &&board[2][1]=="X" &&board[2][2]=="X" ||board[2][0]=="0" &&board[2][1]=="0" &&board[2][2]=="0" ){
      return true;
    }
    if(board[0][0]=="X" &&board[1][0]=="X" &&board[2][0]=="X" ||board[0][0]=="0" &&board[1][0]=="0" &&board[2][0]=="0" ){
      return true;
    }
    if(board[0][1]=="X" &&board[1][1]=="X" &&board[2][1]=="X" ||board[0][1]=="0" &&board[1][1]=="0" &&board[2][1]=="0" ){
      return true;
    }
    if(board[0][2]=="X" &&board[1][2]=="X" &&board[2][2]=="X" ||board[0][2]=="0" &&board[1][2]=="0" &&board[2][2]=="0" ){
      return true;
    }
    if(board[2][2]=="X" &&board[1][1]=="X" &&board[0][0]=="X" ||board[0][0]=="0" &&board[1][1]=="0" &&board[2][2]=="0" ){
      return true;
    }
    if(board[0][2]=="X" &&board[1][1]=="X" &&board[2][0]=="X" ||board[2][0]=="0" &&board[1][1]=="0" &&board[0][2]=="0" ){
      return true;
    }
    return false;
  }
}

class  GameManager{       //Game management class
  Board xo=new Board();
  player player1= new player();
  player player2= new player();
  void managegame(){
    xo.printboard();
    while(true){
      xo.add();
      xo.printboard();
      if(xo.check()){
        if(xo.player){
          System.out.println(player2.playername + " WON !");
        }else{
          System.out.println(player2.playername+ " WON !");
        }
        break;
      }
      if(xo.turns==9){
        System.out.println("TIE !");
        break;
      }
    }

  }

}

class player{
  String playername;
  char item;
  player(){
    Scanner scanner=new Scanner(System.in);
    System.out.println("ADD YOUR NAME HERE : ");
    String username=scanner.nextLine();
    playername=username;
  }
}