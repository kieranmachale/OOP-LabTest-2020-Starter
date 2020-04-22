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

	}
	
	public void draw()
	{			
		background(0);
		drawBarChart();
	}
}
