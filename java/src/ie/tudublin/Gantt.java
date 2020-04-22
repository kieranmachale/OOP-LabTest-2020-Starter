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
	
	float currentX;
	float currentY;
	float border = width * 0.09f;
	float leftBorder = width * 0.15f;
	float rightBorder = width * 0.05f;
	float s, t;
	boolean taskClicked = false;

	public void mousePressed()
	{
		println("Mouse pressed");

		int count = 1;

		for(Task task:taskArray)
		{	
			s = task.getStart();
			t = task.getEnd();

			currentX = map(s, 1, 30, leftBorder, width - rightBorder);
			currentY = map(count, 1, 9, border, height - border) - 20;
			float xr = map(t, 1, 30, leftBorder, width - rightBorder);
			float w = xr - currentX;
			float h = 40;
			float halfWidth = currentX + w/2;

			if(mouseX >= currentX && mouseX < (currentX + w) && mouseY >= currentY &&
			mouseY < (currentY + h)) // <----
			{
				if(s + t >= 1 && t < 30)
				{
					
					t += 1;
					task.setEnd((int)t);

					taskClicked = true;

				}
			}
			count++;
			
		}
		
	}


	public void mouseDragged()
	{
		println("Mouse dragged");

		if(taskClicked)
		{
			while((s + t >= 1) && t < 30)
			{
				
			}
		}
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

			colorMode(HSB);
			stroke(y % 255, 255, 255);
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
