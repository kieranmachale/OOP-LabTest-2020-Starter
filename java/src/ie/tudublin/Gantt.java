package ie.tudublin;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import java.util.ArrayList;

public class Gantt extends PApplet
{	
	
	

	public void settings()
	{
		size(800, 600);
	}

	public void setup()
	{
		loadTasks();
		printTasks();
	}

	public void loadTasks()
	{
		Table t = loadTable("tasks.csv", "header");

		for(TableRow row:t.rows())
		{
			Task task = new Task(row);
			taskArray.add(task);
		}
	}

	public void printTasks()
	{
		for(Task task:taskArray)
		{
			System.out.println(task);
		}
	}

	ArrayList<Task> taskArray = new ArrayList<Task>();
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}


	public void drawBarChart()
	{
		
		float leftBorder = width * 0.15f;
		float rightBorder = width * 0.05f;

		for(int i = 1; i <= 30; i++)
		{
			float x = map(i, 1, 30, leftBorder, width - rightBorder);

			if(i % 2 == 0)
			{
				stroke(100);
			}
			else
			{
				stroke(255);
			}
			line(x, rightBorder, x, height - rightBorder);
			fill(255);
			textAlign(CENTER,CENTER);
			text(i, x, rightBorder - 10);
		}
		
	}	

	float rectX;
	float rectWidth;

	public void displayTasks()
	{
		float border = width * 0.09f;
		float leftBorder = width * 0.15f;
		float rightBorder = width * 0.05f;
		float x,y,w,h,xr;
		
		int count = 1;

		for(Task task: taskArray)
		{

			float s = task.getStart();
			float t = task.getEnd();
			
			x = map(s, 1, 30, leftBorder, width - rightBorder);
			xr = map(t, 1, 30, leftBorder, width - rightBorder); 
			w = xr - x;
			h = 40;
			y = map(count ,1, 9,border, height - border);

			textAlign(CENTER,CENTER);
			stroke(255);
			fill(255);
			text(task.getName(), border, y);
			count++;

			stroke(y % 255, 255,255);
			colorMode(HSB);
			fill(y % 255,255,255);
			rect(x, y - 20, w, h);		

		}
		
	}
	
	public void draw()
	{			
		background(0);
		drawBarChart();
		displayTasks();
	}
}
