package ie.tudublin;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import java.util.ArrayList;

public class Gantt extends PApplet
{	
	
	ArrayList<Task> task = new ArrayList<Task>();

	public void settings()
	{
		size(800, 600);
	}

	public void setup()
	{
		loadTasks();
	}

	public void loadTasks()
	{
		Table t = loadTable("tasks.csv", "header");

		for(TableRow row:t.rows())
		{
			Task task = new Task(row);
		}
	}

	public void printTasks()
	{
		for(Task t:task)
		{
			System.out.println(t);
		}
	}
	
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
