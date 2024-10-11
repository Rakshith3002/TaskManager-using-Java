import java.util.Scanner;
class Task{
	private String description;
	private boolean isCompleted;
	Task(String description){
		this.description=description;
	}
	String getDescription(){
		return this.description;
	}
	boolean isCompleted(){
		return this.isCompleted;
	}
	void markComplete() {
		this.isCompleted=true;
	}
}
class TaskManager{
	Task task[];
	int taskCount;
	TaskManager(int initalCapasity){
		task=new Task[initalCapasity];
	}
	void addTask(String desc) {
		if(taskCount==task.length) {
			System.out.println("Task List is completed...");
		}else {
			task[taskCount]=new Task(desc);
			taskCount++;
			System.out.println("Task Added is Succussfully added");
		}
	}
	void markTaskComplete(int index) {
		task[index].markComplete();
		System.out.println("Status Updated Updated Succussfully");
	}
	void listPendingTasks() {
		int count=0;
		for(int i=0;i<taskCount;i++) {
			if(task[i].isCompleted()==false) {
				System.out.println("Task Description="+task[i].getDescription());
				System.out.println("Task Status="+task[i].isCompleted());
				count++;
			}
			if(count==0)System.out.println("No Pending Tasks");
		}
	}
	void listCompletedTasks() {
		int count=0;
		for(int i=0;i<taskCount;i++) {
			if(task[i].isCompleted()==true) {
				System.out.println("Task Description="+task[i].getDescription());
				System.out.println("Task Status="+task[i].isCompleted());
				count++;
			}
		}
		if(count==0)System.out.println("No Completed Tasks");
	}
	void listAllTasks() {
		for(int i=0;i<taskCount;i++) {
			
				System.out.println("Task Description="+task[i].getDescription());
				System.out.println("Task Status="+task[i].isCompleted());
			
		}
	}
}
public class TestMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		TaskManager tm=new TaskManager(10);
		boolean isExit=false;
		while(!isExit) {
			System.out.println("1.Add Task");
			System.out.println("2.Mark Task As complete");
			System.out.println("3.List all Completed Tasks");
			System.out.println("4.List all pending Tasks");
			System.out.println("5.List all tasks");
			System.out.print("Enter Option:");
			int op=sc.nextInt();
			sc.nextLine();
			switch(op) {
			case 1:System.out.println("Enter Task Info:");
			String desc=sc.nextLine();
			tm.addTask(desc);break;
			case 2:tm.listPendingTasks();
			System.out.print("Enter Task Number to Complete:");
			int index=sc.nextInt();
			tm.markTaskComplete(index);break;
			case 3:tm.listCompletedTasks();break;
			case 4:tm.listPendingTasks();break;
			case 5:tm.listAllTasks();break;
			case 6:isExit=true;break;
			default:System.out.println("Invalid Option");
			}
		}

	}

}
