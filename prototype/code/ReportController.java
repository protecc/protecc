import java.util.Scanner;

public class ReportController {
	private Report openReport;

	public ReportController() {
		openReport = new Report();
	}

	public void reportMenu() {
		Scanner input = new Scanner(System.in);
		String contents;
		boolean menuChoice = true;
		
		System.out.println("Report Menu:");
		System.out.println("Type \"help\" for commands.");

		while (menuChoice) {
			System.out.print(">>> ");
         	String command = input.nextLine();

         	switch (command.toLowerCase()) {
         		case "help":
         			help();
         			break;
         		case "show contents":
         			contents = openReport.getContents();
         			System.out.println("Report Contents:");
         			System.out.println(contents);
         			break;
         		case "change contents":
         			System.out.print("Enter new report contents: ");
         			contents = input.nextLine();
         			openReport.setContents(contents);
         			System.out.println("Contents of report have been changed.");
         			break;
         		case "exit":
         			System.out.println("Type \"help\" for commands.");
				menuChoice = false;
         			return;
         		default:
               		System.out.println("Invalid command. Type \"help\" for commands.");
         	}
		}
	}

	public void help() {
		System.out.println("\nCommands: ");
		System.out.println("Show contents - show contents of the report.");
		System.out.println("Change contents - change the contents of the report.");
		System.out.println("Exit - exit report menu.\n");
	}
}
