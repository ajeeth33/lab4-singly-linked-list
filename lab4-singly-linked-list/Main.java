import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Playlist Manager ---");
            System.out.println("1) Add song");
            System.out.println("2) Remove song by title");
            System.out.println("3) Play next");
            System.out.println("4) Display playlist");
            System.out.println("5) Exit");
            System.out.print("> ");

            String choice = sc.nextLine().trim();

            if (choice.equals("1")) {
                System.out.print("Title: ");
                String title = sc.nextLine();
                System.out.print("Artist: ");
                String artist = sc.nextLine();

                playlist.addSong(new Song(title, artist));
                System.out.println("Added!");

            } else if (choice.equals("2")) {
                System.out.print("Enter title to remove: ");
                String title = sc.nextLine();

                boolean removed = playlist.removeSong(title);
                System.out.println(removed ? "Removed!" : "Song not found.");

            } else if (choice.equals("3")) {
                Song nowPlaying = playlist.playNext();
                if (nowPlaying == null) System.out.println("Playlist is empty.");
                else System.out.println("Now playing: " + nowPlaying);

            } else if (choice.equals("4")) {
                playlist.displayPlaylist();

            } else if (choice.equals("5")) {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid option.");
            }
        }

        sc.close();
    }
}
