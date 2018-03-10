package shapes;
import hsa.Console;
import java.awt.*;
public class Shape {
	 private String type;
	 private int xPos, yPos, w, h;
	 private Console console;
	 private Color colour;
	 private Color stroke_colour;
	 
	 /*** CONSTRUCTORS ***/
	 public Shape(Console c, String type, int x, int y, int w, int h) {
		 this.type = type;
		 this.xPos = x;
		 this.yPos = y;
		 this.w = w;
		 this.h = h;
		 this.console = c;
		 this.colour = new Color(255, 255, 255, 255); //hopefully transparent
		 this.stroke_colour = new Color(0,0,0);
	 }
	 public Shape(Console c, String type, int x, int y, int w, int h, Color colour) {
		 this.type = type;
		 this.xPos = x;
		 this.yPos = y;
		 this.w = w;
		 this.h = h;
		 this.console = c;
		 this.colour = colour;
		 this.stroke_colour = new Color(0,0,0);
	 }
	 
	 /*** METHODS ***/
	 public void display() {
		 if(this.type == "rectangle") { 
			 Shape.drawRectangle(this.console, this.xPos, this.yPos, this.w, this.h, this.colour, this.stroke_colour);
		 }
		 else if(this.type == "ellipse") {
			 Shape.drawEllipse(this.console, this.xPos, this.yPos, this.w, this.h, this.colour, this.stroke_colour);
		 }
		 else if(this.type == "star") {
			 Shape.drawStar(this.console, this.xPos, this.yPos, this.w, this.h, this.colour, this.stroke_colour);
		 }
	 }
	 public void stroke(Color s) {
		 this.stroke_colour = s;
	 }
	 public void noStroke() {
		 this.stroke_colour = new Color(255,255,255,255);//hopefully transparent
	 }
	 public void fill(Color c) {
		 this.colour = c;
	 }
	 public void setSize(int size) {
		 this.w = this.h = size;
	 }
	 public void setSize(int w, int h) {
		 this.w = w;
		 this.h = h;
	 }
	 public void setPosition(int x, int y) {
		 this.xPos = x;
	  	 this.yPos = y;
	 }
	 public void setType(String type){
		 this.type = type;
	 }
	 public void changePosition(int x, int y){
		 this.xPos += x;
		 this.yPos += y;
	 }
	 public String getType() {
		 return this.type;
	 }
	 /****  STATIC METHODS  ****/
	 /*** DRAWS ELLIPSE***/
	 public static void drawEllipse(Console console, int x, int y, int w, int h) {
		console.setColor(new Color(255, 255, 255, 255));
	  	console.fillOval(x, y, w, h);
	  	console.setColor(new Color(0, 0, 0));
	  	console.drawOval(x, y, w, h);
	 }
	 public static void drawEllipse(Console console, int x, int y, int w, int h, Color colour) {
		console.setColor(colour);
		console.fillOval(x, y, w, h);
		console.setColor(new Color(0, 0, 0));
		console.drawOval(x, y, w, h);
	 }
	 public static void drawEllipse(Console console, int x, int y, int w, int h, Color colour, Color stroke_colour) {
		console.setColor(colour);
		console.fillOval(x, y, w, h);
		console.setColor(stroke_colour);
		console.drawOval(x, y, w, h);
	 }
	 /***DRAWS RECTANGLE***/
	 public static void drawRectangle(Console console, int x, int y, int w, int h) {
		console.setColor(new Color(255, 255, 255, 255));
		console.fillRect(x, y, w, h);
		console.setColor(new Color(0, 0, 0));
		console.drawRect(x, y, w, h);
	 }
 	 public static void drawRectangle(Console console, int x, int y, int w, int h, Color colour) {
		console.setColor(colour);
		console.fillRect(x, y, w, h);
		console.setColor(new Color(0, 0, 0));
		console.drawRect(x, y, w, h);
	 }
	 public static void drawRectangle(Console console , int x, int y, int w, int h, Color colour, Color stroke_colour) {
		console.setColor(colour);
		console.fillRect(x, y, w, h);
		console.setColor(stroke_colour);
		console.drawRect(x, y, w, h);
	 }
	 /***DRAWS STAR***/
	 public static void drawStar(Console console , int x, int y, int w, int h) {
		console.setColor(new Color(255, 255, 255, 255));
		console.fillStar(x, y, w, h);
		console.setColor(new Color(0, 0, 0));
		console.drawRect(x, y, w, h);
	 }
	 public static void drawStar(Console console , int x, int y, int w, int h, Color colour) {
		console.setColor(colour);
		console.fillStar(x, y, w, h);
		console.setColor(new Color(0, 0, 0));
		console.drawStar(x, y, w, h);
	 }
	 public static void drawStar(Console console , int x, int y, int w, int h, Color colour, Color stroke_colour) {
		console.setColor(colour);
		console.fillStar(x, y, w, h);
		console.setColor(stroke_colour);
		console.drawStar(x, y, w, h);
	 }
 
}

