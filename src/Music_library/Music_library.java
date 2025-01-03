package Music_library;   // For organizing related classes
import java.util.ArrayList; //create dynamic, resizable lists for efficient storage and manipulation of elements
import java.util.Scanner; //read user input from console.

// Class to represent a song
class Song {
    private String name_song;
    private Artist artist;    //A reference type that represents another class named Artist

    public Song(String name_song, Artist artist) {
        System.out.println("Creating Song: " + name_song + " by " + artist.getName_artist());
        this.name_song = name_song; //assign the value of the parameter name_song to the instance variable name_song of the current object
        this.artist = artist;
    }

    //get the name_song
    public String getName_song() {
        return name_song;
    }

    //update or modify the value of the private name_song
    public void setName_song(String name_song) {
        this.name_song = name_song;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getDetails() {
        return "Song: " + name_song + ", Artist: " + artist.getName_artist();
    }

    public boolean equals(Song otherSong) {  //method that takes another Song object as a parameter (otherSong) for comparison
        return this.name_song.equalsIgnoreCase(otherSong.getName_song()) &&
                this.artist.getName_artist().equalsIgnoreCase(otherSong.getArtist().getName_artist()); //ignoring case differences
    }
}

// Class to represent an artist
class Artist {
    private String name_artist;

    public Artist(String name_artist) {
        System.out.println("Creating Artist: " + name_artist);
        this.name_artist = name_artist;
    }

    public String getName_artist() {
        return name_artist;
    }

    public void setName_artist(String name_artist) {
        this.name_artist = name_artist;
    }

    public boolean equals(Artist otherArtist) {
        return this.name_artist.equalsIgnoreCase(otherArtist.getName_artist());
    }
}

// Class to represent a playlist
class Playlist {
    private String name;
    private ArrayList<Song> songs; //  store and manage a dynamic list of songs

    public Playlist(String name) {
        System.out.println("Creating Playlist: " + name);
        this.name = name;
        this.songs = new ArrayList<>(); // Initialize the ArrayList
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSong(Song song) { //A parameter of type Song, representing the song to be added
        System.out.println("Adding Song to Playlist: " + song.getDetails());
        songs.add(song); // Add song to ArrayList
    }

    public void displaySongs() {
        System.out.println("Displaying Songs in Playlist: " + name);
        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + ". " + songs.get(i).getDetails()); //Adds a numerical index (starting from 1) to each song.  Calls the getDetails method of the Song object at index i to retrieve a formatted string
        }
    }

    public boolean containsSong(Song song) {
        return songs.contains(song); // Check if the song exists in ArrayList
    }
}

// Main class for user interaction
public class Music_library {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //read user input from the console

        System.out.println("Hello! Welcome to my Music Library program!");
        System.out.println("First, you should create a playlist. Please enter the name of your playlist that you want to add: ");
        String playlistName = scanner.nextLine(); //nextLine() reads everything typed by the user until the Enter key is pressed, including spaces.
        Playlist playlist = new Playlist(playlistName); //The constructor of the Playlist class is called, initializing the playlist with the given name

        while (true) {
            System.out.println("\nNow you have 4 Options:");
            System.out.println("1. Add a song to your playlist");
            System.out.println("2. View playlist that you created");
            System.out.println("3. Check if a song exists in the playlist");
            System.out.println("4. Exit the program");

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter the song name: ");
                    String songTitle = scanner.nextLine();

                    System.out.print("Enter the artist name: ");
                    String artistName = scanner.nextLine();

                    Artist artist = new Artist(artistName); //creates and initializes an artist object with the given name
                    Song song = new Song(songTitle, artist);
                    playlist.addSong(song);

                    System.out.println("Added: " + song.getDetails());
                    break;

                case "2":
                    playlist.displaySongs();
                    break;

                case "3":
                    System.out.print("Enter the song name to check: ");
                    String checkSongName = scanner.nextLine(); //allows the program to dynamically take a full line of user input for a song name

                    System.out.print("Enter the artist name to check: ");
                    String checkArtistName = scanner.nextLine();

                    Artist checkArtist = new Artist(checkArtistName);
                    Song checkSong = new Song(checkSongName, checkArtist);

                    if (playlist.containsSong(checkSong)) {
                        System.out.println("The song exists in the playlist.");
                    } else {
                        System.out.println("The song does not exist in the playlist.");
                    }
                    break;

                case "4":
                    System.out.println("Exiting the Music Streaming Library. Thank you for using! Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("There's no such option. Try again.");
            }
        }
    }
}
