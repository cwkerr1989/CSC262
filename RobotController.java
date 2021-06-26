/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csc262.robot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.UP;
import static javafx.scene.input.KeyCode.LEFT;
import static javafx.scene.input.KeyCode.RIGHT;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class RobotController {

    
    @FXML
    public GridPane grid=new GridPane();
    public Node bot;
    public Label q;
    public Label s;
    public Label v;
    public Label g;
    public Label z;
    public Label load;
    public boolean cargo=false;
    
    public int x= 0;
    public int y= 0;
    
    
    @FXML
    void moveDown(ActionEvent event) {
    if (y<24)
    grid.setRowIndex(bot,++y);
    bot.toFront();
    }

    @FXML
    void moveLeft(ActionEvent event) {
    if (x>0)
    grid.setColumnIndex(bot,--x);
    bot.toFront();
    }

    @FXML
    void moveRight(ActionEvent event) {
    if (x<24)
    grid.setColumnIndex(bot,++x);
    bot.toFront();
    }

    @FXML
    void moveUp(ActionEvent event) {
    if (y>0)
    grid.setRowIndex(bot,--y);
    }
  
    @FXML
    void pickUp(ActionEvent event){
        if(y==grid.getRowIndex(q)&&x==grid.getColumnIndex(q) && !cargo){
            load=q;
            cargo=true;
            grid.getChildren().remove(q);
        }
        else if (y==grid.getRowIndex(s)&&x==grid.getColumnIndex(s)&& !cargo){
            load=s;
            cargo=true;
            grid.getChildren().remove(s); 
        }
        else if (y==grid.getRowIndex(v)&&x==grid.getColumnIndex(v)&& !cargo){
            load=v;
            cargo=true;
            grid.getChildren().remove(v);  
        }
        else if (y==grid.getRowIndex(g)&&x==grid.getColumnIndex(g)&& !cargo){
            load=g;
            cargo=true;
            grid.getChildren().remove(g); 
        }
        else if (y==grid.getRowIndex(z)&&x==grid.getColumnIndex(z)&& !cargo){
            load=z;
            cargo=true;
            grid.getChildren().remove(z); 
        }                         
    }
    
    @FXML
    void dropOff(ActionEvent event){
    if (cargo){
    grid.add(load, x, y);
    cargo=false;
        }
    }
    
    @FXML
    void arrowKeys(KeyEvent event) {    
    switch (event.getCode()) {
        
    case LEFT:
        moveLeft(null);
        break;      
    case RIGHT:
        moveRight(null);
        break; 
    case UP:
        moveUp(null);
        break; 
    case DOWN:
        moveDown(null);
        break;
    }

}
}