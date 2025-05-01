import java.io.*;  // ফাইল ইনপুট/আউটপুট অপারেশনের জন্য
import java.util.*; // স্ক্যানার ক্লাসের জন্য

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user name and store in file
        System.out.print("Enter your name to store in file or enter to proceed: ");
        String userName = scanner.nextLine();

        if (!userName.isEmpty()) {
            try (FileWriter fw = new FileWriter("user_info.txt", true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {
                out.println(userName);
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        }

        // Ask if user wants to see all names
        System.out.print("Do you want to see all user names? y/n: ");
        String showInfo = scanner.nextLine();

        if (showInfo.equalsIgnoreCase("y")) {
            try (BufferedReader br = new BufferedReader(new FileReader("user_info.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }

        scanner.close();
    }
}