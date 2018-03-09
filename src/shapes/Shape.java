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
			this.console.setColor(this.stroke_colour);
			this.console.drawRect(this.xPos, this.yPos, this.w, this.h);
			this.console.setColor(this.colour);
			this.console.fillRect(this.xPos, this.yPos, this.w, this.h);
		}
		else if(this.type == "circle") {
			this.console.setColor(this.stroke_colour);
			this.console.drawOval(this.xPos, this.yPos, this.w, this.h);
			this.console.setColor(this.colour);
			this.console.fillOval(this.xPos, this.yPos, this.w, this.h);
		}
		else if(this.type == "star") {
			this.console.setColor(this.stroke_colour);
			this.console.drawStar(this.xPos, this.yPos, this.w, this.h);
			this.console.setColor(this.colour);
			this.console.fillStar(this.xPos, this.yPos, this.w, this.h);
		}
	}
	public void stroke(Color s) {
		this.stroke_colour = s;
	}
	public void fill(Color c) {
		this.colour = c;
	}
	public void setSize(int size) {}
	public void setSize(int w, int h) {	}
	public void setPosition() {}
	public void changePosition(){}

}

