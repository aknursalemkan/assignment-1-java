package Music_library;
import java.util.ArrayList;
import java.util.Scanner;

class Song {
    private String name_song;
    private Artist artist;

    public Song(String name_song, Artist artist) {
        System.out.println("Creating Song: " + name_song + " by " + artist.getName_artist());
        this.name_song = name_song;
        this.artist = artist;
    }

    public String getName_song() {
        System.out.println("Getting Song name_song: " + name_song);
        return name_song;
    }

    public void setName_song(String name_song) {
        System.out.println("Setting Song name_song to: " + name_song);
        this.name_song = name_song;
    }

    public Artist getArtist() {
        System.out.println("Getting Song Artist: " + artist.getName_artist());
        return artist;
    }

    public void setArtist(Artist artist) {
        System.out.println("Setting Song Artist to: " + artist.getName_artist());
        this.artist = artist;
    }

    public String getDetails() {
        return "Song: " + name_song + ", Artist: " + artist.getName_artist();
    }
}

class Artist {
    private String name_artist;

    public Artist(String name_artist) {
        System.out.println("Creating Artist: " + name_artist);
        this.name_artist = name_artist;
    }

    public String getName_artist() {
        System.out.println("Getting Artist name: " + name_artist);
        return name_artist;
    }

    public void setName_artist(String name_artist) {
        System.out.println("Setting Artist name to: " + name_artist);
        this.name_artist = name_artist;
    }
}

class Playlist {
    private String name;
    private Song[] songs;
    private int numberOfSongs;

    public Playlist(String name, int maxSongs) {
        System.out.println("Creating Playlist: " + name);
        this.name = name;
        this.songs = new Song[maxSongs];
        this.numberOfSongs= 0;
    }

    public String getName() {
        System.out.println("Getting Playlist name: " + name);
        return name;
    }

    public void setName(String name) {
        System.out.println("Setting Playlist name to: " + name);
        this.name = name;
    }

    public void addSong(Song song) {
        if (numberOfSongs < songs.length) {
            System.out.println("Adding Song to Playlist: " + song.getDetails());
            songs[numberOfSongs++] = song;
        } else {
            System.out.println("Playlist is full. Cannot add more songs.");
        }
    }

    public void displaySongs() {
        System.out.println("Displaying Songs in Playlist: " + name);
        for (int i = 0; i < numberOfSongs; i++) {
            System.out.println((i + 1) + ". " + songs[i].getDetails());
        }
    }
}

public class Music_library {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of your playlist: ");
        String playlistName = scanner.nextLine();
        Playlist playlist = new Playlist(playlistName, 10);

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Add a song");
            System.out.println("2. View playlist");
            System.out.println("3. Exit");

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter the song title: ");
                    String songTitle = scanner.nextLine();

                    System.out.print("Enter the artist name: ");
                    String artistName = scanner.nextLine();

                    Artist artist = new Artist(artistName);
                    Song song = new Song(songTitle, artist);
                    playlist.addSong(song);

                    System.out.println("Added: " + song.getDetails());
                    break;

                case "2":
                    playlist.displaySongs();
                    break;

                case "3":
                    System.out.println("Exiting the Music Streaming Library. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}