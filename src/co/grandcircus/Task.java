package co.grandcircus;

public class Task {

	private String name;
	private String taskDescrip;
	private String dueDate;
	private boolean taskComplete = false;

	public Task() {
		taskComplete = false;
		dueDate = "";
		name = "";
		taskDescrip = "";
	}

	public Task(boolean taskComplete, String dueDate, String userName, String taskDescrip) {
		this.taskComplete = false;
		this.dueDate = dueDate;
		name = userName;
		this.taskDescrip = taskDescrip;
	}

	public Task(String name) {
		this.name = name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setTaskDescrip(String taskDescrip) {
		this.taskDescrip = taskDescrip;
	}

	public String getTaskDescrip() {
		return taskDescrip;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setTaskCompletion(boolean taskComplete) {
		this.taskComplete = taskComplete;
	}

	public boolean getTaskComplete() {
		return taskComplete;
	}

//	public void add(Task task) {
//		
//	}

	@Override
	public String toString() {
		return String.format("%-7s  %-15s %-15s %-15s", taskComplete, dueDate, name, taskDescrip);
}

	
}

