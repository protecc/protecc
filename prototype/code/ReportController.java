import java.util.Scanner;

public class ReportController {
	private Report report;

	public ReportController() {
		report = new Report();
	}

	public void reportMenu() {
		Scanner input = new Scanner(System.in);
		String contents;

		System.out.println("Report Menu:");
		System.out.println("Type \"help\" for commands.");

		while (true) {
			System.out.print(">>> ");
         	String command = input.nextLine();

         	switch (command.toLowerCase()) {
         		case "help":
         			help();
         			break;
         		case "show contents":
         			contents = report.getContents();
         			System.out.println("Report Contents:");
         			System.out.println(contents);
         			break;
         		case "change contents":
         			System.out.print("Enter new report contents: ");
         			contents = input.nextLine();
         			report.setContents(contents);
         			System.out.println("Contents of report have been changed.");
         			break;
         		case "exit":
         			System.out.println("Type \"help\" for commands.");
         			return;
         		default:
               		System.out.println("Invalid command. Type \"help\" for commands.");
         	}
		}
	}

	public void help() {
		System.out.println("\nCommands: ");
		System.out.println("show contents - show contents of the report.");
		System.out.println("change contents - change the contents of the report.");
		System.out.println("exit - exit report menu.\n");
	}
}