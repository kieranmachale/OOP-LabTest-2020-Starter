package ie.tudublin;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	
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
			Task task = new Task();
		}
	}

	public void printTasks()
	{
		
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
