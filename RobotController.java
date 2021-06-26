/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csc262.robot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
    public Label status;
    public Label position;
    public Label q;
    public Label s;
    public Label v;
    public Label g;
    public Label z;
    public Label load;
    public boolean cargo=false;
    public Button up;
    public Button down;
    public Button left;
    public Button right;
    
    public int x= 0;
    public int y= 0;
    
    
    @FXML
    void moveDown(ActionEvent event) {
    if (y<24){
    grid.setRowIndex(bot,++y);
    bot.toFront();
    position.setText("Current location: "+x+", "+y);
    }
    }

    @FXML
    void moveLeft(ActionEvent event) {
    if (x>0)
    grid.setColumnIndex(bot,--x);
    bot.toFront();
    position.setText("Current location: "+x+", "+y);
    }

    @FXML
    void moveRight(ActionEvent event) {
    if (x<24)
    grid.setColumnIndex(bot,++x);
    bot.toFront();
    position.setText("Current location: "+x+", "+y);
    }

    @FXML
    void moveUp(ActionEvent event) {
    if (y>0)
    grid.setRowIndex(bot,--y);
    bot.toFront();
    position.setText("Current location: "+x+", "+y);
    }
  
    
    
    @FXML
    void pickUp(ActionEvent event){
        if(y==grid.getRowIndex(q)&&x==grid.getColumnIndex(q) && !cargo){
            load=q;
            cargo=true;
            grid.getChildren().remove(q);
            status.setText("Carrying payload: "+q.getText().charAt(0));
        }
        else if (y==grid.getRowIndex(s)&&x==grid.getColumnIndex(s)&& !cargo){
            load=s;
            cargo=true;
            grid.getChildren().remove(s);
            status.setText("Carrying payload: "+s.getText().charAt(0));
        }
        else if (y==grid.getRowIndex(v)&&x==grid.getColumnIndex(v)&& !cargo){
            load=v;
            cargo=true;
            grid.getChildren().remove(v);  
            status.setText("Carrying payload: "+v.getText().charAt(0));
        }
        else if (y==grid.getRowIndex(g)&&x==grid.getColumnIndex(g)&& !cargo){
            load=g;
            cargo=true;
            grid.getChildren().remove(g); 
            status.setText("Carrying payload: "+g.getText().charAt(0));
        }
        else if (y==grid.getRowIndex(z)&&x==grid.getColumnIndex(z)&& !cargo){
            load=z;
            cargo=true;
            grid.getChildren().remove(z); 
            status.setText("Carrying payload: "+z.getText().charAt(0));
        }                         
    }
    
    @FXML
    void dropOff(ActionEvent event){
 
    if (cargo){
    grid.add(load, x, y);
    cargo=false;
    status.setText("Carrying payload: None");
        }
    }
  
    @FXML
    public void arrowKeys(KeyEvent event) {        
    switch (event.getCode()) {    
    case LEFT:
        moveLeft(null);
        left.requestFocus();
        break;      
    case RIGHT:
        moveRight(null);
        right.requestFocus();
        break; 
    case UP:
        moveUp(null);
        up.requestFocus();
        break; 
    case DOWN:
        moveDown(null);
        down.requestFocus();
        break;
    }
}
}

