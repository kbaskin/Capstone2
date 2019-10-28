package co.grandcircus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int userInput;
		int counter = 0;
		Task task = new Task();
		List<Task> newTask = new ArrayList<>();

		System.out.println("Welcome to the Task Manager!");

		do {
			System.out.println("\n1. List tasks\n2. Add task\n3. Delete task\n4. Mark task complete\n5. Quit");
			userInput = Validator.getInt(scan, "\nWhat would you like to do?\n ", 1, 5);

			if (userInput == 1) {
				// 1. list tasks
				System.out.println("Done?    Due Date:       Team Member:    Description:  ");
				for (int i = 0; i < newTask.size(); i++)
					System.out.println(newTask.get(i));

			} else if (userInput == 2) {
				// 2. add task
				String userName = Validator.getString(scan, "Name: ");
				task.setName(userName);

				String taskDescrip = Validator.getString(scan, "Task Description: ");
				task.setTaskDescrip(taskDescrip);

				String dueDate = Validator.getStringMatchingRegex(scan, "Due Date: (mm/dd/yyyy)",
						("([0-9]{2})/([0-9]{2})/([0-9]{4})"));
				task.setDueDate(dueDate);

				boolean taskComplete = false;
				task.setTaskCompletion(taskComplete);
				task.getTaskComplete();

				newTask.add(new Task(taskComplete, dueDate, userName, taskDescrip));
				counter++;
				System.out.println("\nTask added!");

				continue;

			} else if (userInput == 3) {
				// 3. delete task
				for (int i = 0; i < newTask.size(); i++)
					System.out.println(newTask.get(i));
				int deleteTask = Validator.getInt(scan, "Which task would you like to delete?", 1, newTask.size());
				deleteTask = deleteTask - 1;
					String confirmDelete = Validator.getString(scan,
						"\nAre you sure you want to delete this task? (y/n)");
					if ((confirmDelete.equalsIgnoreCase("yes")) || (confirmDelete.equalsIgnoreCase("y"))) {
						newTask.remove(deleteTask);
					System.out.println("\nTask was deleted.");
						continue;
					} else {
						continue;
					}


			} else if (userInput == 4) {
				// 4. mark task complete
				for (int i = 0; i < newTask.size(); i++)
					System.out.println(newTask.get(i));
				int askTaskComplete = Validator.getInt(scan, "What task do you want to mark complete?", 1,
						newTask.size());
				String taskComplete = Validator.getString(scan,
						"\nAre you sure you want to mark this task complete? (y/n)");
				if ((taskComplete.equalsIgnoreCase("y")) || (taskComplete.equalsIgnoreCase("yes"))) {
					task = newTask.get(askTaskComplete - 1);
					task.setTaskCompletion(true);
					System.out.println("\nTask marked completed.");
					continue;
				} else {
					continue;

				}
			} else if (userInput == 5) {
				// 5. quit
				// ask if they're sure
				// if they answer y, exit the program
				// if they answer n, return to main menu
				String confirmQuit = Validator.getString(scan, "Are you sure you want to exit? (y/n)");
				if ((confirmQuit.equalsIgnoreCase("y")) || (confirmQuit.equalsIgnoreCase("yes"))) {
					break;
				} else {
					continue;
				}
			}

		} while (userInput == 1 || userInput == 2 || userInput == 3 || userInput == 4 || userInput == 5);

		System.out.println("\nHave a great day!");

	}
}
