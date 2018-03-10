package shapes;
import hsa.Console;
import java.awt.*;
import java.util.Random;
public class SlotMachine {

	private static Shape []slots;
	private static Console console;
	private static boolean running;
	private static boolean turning;
	private static Random randNum;
	private static double timer;
	private static final String []shapes = {"ellipse", "rectangle", "star"};
 
	public static void main(String []a) throws InterruptedException {
		init();
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
				for(int i = 0; i < slots.length; i++) {
					slots[i].fill(new Color(randNum.nextInt(255),randNum.nextInt(255),randNum.nextInt(255)));
					slots[i].setType(shapes[randNum.nextInt(3)]);
				}
		        Thread.sleep((int)(timer*1000));
		        console.clear();
		        timer+=0.05;
		        for(int i = 0; i < slots.length; i++) {
		        		slots[i].display();
		        }
		        if(timer >= 0.75){
		            turning = false;
		            if(!win()) {
		            		console.setColor(new Color(255,0,0));
		            		console.drawString("to try again press enter", 0, 200);
		            }else {
		            		console.setColor(new Color(0,0,255));
		            		console.drawString("NICE JOB. to play again press enter", 0, 200);
		            }
		            console.setColor(new Color(0,0,0,0));
		        }
		     }
		  }
		  console.close();
	}
	private static void init() {
		console = new Console(40, 100, 20);
		randNum = new Random();
		slots = new Shape[3];
		slots[0] = new Shape(console, "ellipse", 0, 0, 100, 100);
		slots[1] = new Shape(console, "rectangle", 200, 0, 100, 100);
		slots[2] = new Shape(console, "star", 400, 0, 100, 100);
		running = true;
		turning = true;
		timer = 0;
	}
	private static boolean win() {
		boolean check = true;
		for(int i = 1; i < slots.length; i++) {
			if(slots[0].getType() != slots[i].getType()) {
				check = false;
				break;
			}
			if(!check)break;
		}
		return check;
	}
}
