package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

class Task {

    private String taskName;
    private int start;
    private int end;

    public Task(TableRow row)
    {
        taskName = row.getString("Task");
        start = row.getInt("Start");
        end = row.getInt("End");
    }

    public void setName(String taskName)
    {
        this.taskName = taskName;
    }

    public String getName()
    {
        return taskName;
    }

    public void setStart(int start)
    {
        this.start = start;
    }

    public int getStart()
    {
        return start;
    }

    public void setEnd(int end)
    {
        this.end = end;
    }

    public int getEnd()
    {
        return end;
    }

    public String toString()
    {
        return taskName + "/t" + start + "/t" + end;
    }
}