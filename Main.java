import java.util.Scanner;
public class Main {
  
  public static void main(String[] args) {
    Game xo=new Game();
    xo.GameManager();
  }
}

class Game{
  Game(){
    System.out.println("Donneeee");
  }
Scanner scanner=new Scanner(System.in);
String[][] board = {{"-","-","-"},{"-","-","-"},{"-","-","-"}};
boolean player=true;
void add(){
  System.out.println("Add a number between 1 -> 9 ");
  int uinp=scanner.nextInt();
  int a=uinp/3;
  int b=uinp%3;
  if(board[a][b]=="-"){
    if(player){
      board[a][b]="X";
    }else{
      board[a][b]="0";
    }
  }else{
    System.out.println("Invalid Input !");
  }
  player=! player;
}
void printboard(){
  for (String[] i : board) {
  System.out.println(i[0]+" "+i[1]+" "+i[2]);
}
}
boolean check(){
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
void GameManager(){
  int turns=0;
  printboard();
  while(true){
    add();
    turns++;
    printboard();
    if(check()){
      if(player){
        System.out.println("0 WON !");
      }else{
        System.out.println("X WON !");
      }
      break;
    }
    if(turns==9){
      System.out.println("TIE !");
      break;
    }
  }

}
}
