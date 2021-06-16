/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csc262.robot;

public class Robot {

public static char grid[][]= new char[25][25]; 

private int xLocation;  
private int yLocation;       
private char payload;        

Robot() {
		xLocation = 0; 
		yLocation = 0;  
		payload = ' ';

	}
Robot(int x, int y, char letter) { 
		xLocation = x;
		yLocation = y;
		payload = letter;
	}
	int getx() { return xLocation; } 
	void setx(int newx) { xLocation = newx; }
	int gety() { return yLocation; }
	void sety(int newy) { yLocation = newy; }
	char getPayload() { return payload; }
	void setPayload(char newload) { payload = newload;}
        
void moveLeft(){
    xLocation--;
    if(xLocation==0)
        System.out.println("Left boundary reached.");
}
void moveRight(){
    xLocation++;
    if(xLocation==24)
        System.out.println("Right boundary reached.");
}
void moveUp(){
    yLocation--;
    if(yLocation==0)
        System.out.println("Top boundary reached.");
}
void moveDown(){
    yLocation++;
    if(yLocation==24)
        System.out.println("Bottom boundary reached.");
}
	
boolean moveTo(int lx, int ly) 
{
	if (lx < 0 || lx > 24 || ly < 0 || ly > 24) { 
		System.out.println("Destination is out of bounds!"); 
		return false;
	}
	else 
            System.out.printf("Moving to %d,%d... ", lx,ly);
	
		while (xLocation < lx)
			{moveRight();}
		while (xLocation > lx)
			{moveLeft();}
		while (yLocation < ly)
			{moveDown();}
		while (yLocation > ly)
			{moveUp();}
            System.out.println("Destination reached.");
		return true;
	
}

boolean pickUp(int lx, int ly) {      
        if (xLocation != lx || yLocation != ly){
            System.out.printf("The robot is not at location %f,%f!\n", lx,ly);
            return false;
        }
        if(grid[lx][ly]==' '){
            System.out.printf("No load at location %f,%f to pick up!", lx,ly);
            return false;
        }
        if(payload!=' '){
            System.out.println("This robot is already carrying a payload! Drop something off first to make room.");
            return false;
        }
            
		if (grid[lx][ly] != ' ' && payload==' ' && xLocation==lx && yLocation==ly) {
			payload = grid[lx][ly];
			grid[lx][ly] = ' ';
                        System.out.printf("Payload \"%c\" picked up.\n", payload);
            }
		return true;
	}

boolean dropOff(int lx, int ly) {                     
        if (xLocation != lx || yLocation != ly){
            System.out.printf("The robot is not at location %f,%f!\n", lx,ly);
            return false;
        }        
		if (payload != ' ' && grid[lx][ly] == ' ') {
			grid[lx][ly] = payload;
			payload = ' ';
		}
		return true;
	}

	
static void print2D(){
    for(int i=0;i<25;i++){
        for(int j=0;j<25;j++){
            System.out.print(grid[i][j]+" ");
        }
     System.out.println();
    }
}



    public static void main(String[] args) {
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid.length;j++)
                grid[i][j]='.';
        
        grid[10][8]='B';
        grid[22][4]='C';
        print2D();
        
        Robot R1=new Robot();
        Robot R2=new Robot(3,4,' ');
        
        R1.moveTo(23,24);
        R2.moveTo(15,3);
        System.out.printf("Robot 1 location: %d, %d\n", R1.getx(), R1.gety());
        System.out.printf("Robot 2 location: %d, %d\n", R2.getx(), R2.gety());
        R1.moveTo(10,8);
        R1.pickUp(10,8);
        System.out.printf("Robot 1 location: %d, %d. Payload: %c\n", R1.getx(), R1.gety(), R1.getPayload());
        R2.moveTo(22,4);
        R2.pickUp(22,4);
        System.out.printf("Robot 2 location: %d, %d. Payload: %c\n", R2.getx(), R2.gety(), R2.getPayload());
        print2D();
        
    }

}

