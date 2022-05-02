/******************************************************************************************************

 Name - Vivian Vu
 Date - 3/27/20
 Course - CMSC 256

 Project 3

 File Name - SongList
 File Purpose - Contains the main method that calls the method to get an artist's songs and print them
 in alphabetical order according to album and song.

 ******************************************************************************************************/

package cmsc256;

import java.util.*;
import java.util.List;
import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.Song;

public class SongList {

    //main method
    public static void main(String[] args) {

        //ask user for artist name
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an Artist Name: ");
        String input = in.nextLine();

        SongList s = new SongList();

        //call getSongsByArtist method
        s.getSongsByArtist(input);

    }

    public String getSongsByArtist(String artist) {

        //create the Bridges object
        Bridges bridges = new Bridges(3, "vivitrinhvu", "145852909132");

        //create the DataSource object
        DataSource ds = bridges.getDataSource();

        //create songData list
        List<Song> songData = null;

        //implement try catch block for reaching Bridges server
        try {
            songData = ds.getSongData();
        }
        catch (Exception e) {
            System.out.println("Unable to Connect.");
        }

        //use SongComparator class with Collections.sort
        Collections.sort(songData, new SongComparator());

        //loop through the song data
        for (Song s : songData) {

            //if the song's artist is equal to the input artist print out attributes
            if (s.getArtist().equals(artist)) {
                System.out.println("Title: " + s.getSongTitle() + " Artist: " + s.getArtist() + " Album: " + s.getAlbumTitle());
            }

        }

        return null;

    }
}