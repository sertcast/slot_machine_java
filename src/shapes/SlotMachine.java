package shapes;
import hsa.Console;
import java.awt.*;
import java.util.Random;
public class SlotMachine {
	public static Shape shape1;
	public static Shape shape2;
	public static Shape shape3;
	public static Console console;
	public static boolean running;
	public static boolean turning;
	public static Random randNum;
	public static double timer;
 
	public static void main(String []a) throws InterruptedException {
		console = new Console(40, 100, 20);
		randNum = new Random();
		final String []shapes = {"ellipse", "rectangle", "star"};
		running = true;
		turning = true;
		shape1 = new Shape(console, "ellipse", 0, 0, 100, 100);
		shape2 = new Shape(console, "rectangle", 200, 0, 100, 100);
		shape3 = new Shape(console, "star", 400, 0, 100, 100);
		timer = 0;
		int input;
		while(running){
			if(!turning){
				input = console.getChar();
		        if(input== 10){
		        		turning = true;
		        		timer = 0;
		        } else if(input==32){
		            running = false;
		        }
			}else{
				shape1.fill(new Color(randNum.nextInt(255),randNum.nextInt(255),randNum.nextInt(255)));
		        shape1.setType(shapes[randNum.nextInt(3)]);
		        shape2.fill(new Color(randNum.nextInt(255),randNum.nextInt(255),randNum.nextInt(255)));
		        shape2.setType(shapes[randNum.nextInt(3)]);
		        shape3.fill(new Color(randNum.nextInt(255),randNum.nextInt(255),randNum.nextInt(255)));
		        shape3.setType(shapes[randNum.nextInt(3)]);
		        Thread.sleep((int)(timer*1000));
		        console.clear();
		        timer+=0.05;
		        shape1.display();
		        shape2.display();
		        shape3.display();
		        if(timer >= 0.75){
		            turning = false;
		            console.setColor(new Color(255,0,0));
		            console.drawString("to try again press enter", 0, 200);
		            console.setColor(new Color(0,0,0,0));
		        }
		     }
		  }
		  console.close();
 }
}
