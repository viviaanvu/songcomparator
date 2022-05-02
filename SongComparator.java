/******************************************************************************************************

 Name - Vivian Vu
 Date - 3/27/20
 Course - CMSC 256

 Project 3

 File Name - SongComparator
 File Purpose - Comparator Class that is used to compare and alphabetize between the artist's album
 then alphabetize each song in the album.

 ******************************************************************************************************/

package cmsc256;

import bridges.data_src_dependent.Song;
import java.util.Comparator;

public class SongComparator implements Comparator<Song> {

    //compare method header
    public int compare(Song s1, Song s2) {

        //if first song artist equals second song artist return compared artists
        if (s1.getArtist().equals(s2.getArtist())) {
            //if first song's album title equals second song's album title return compared album titles
            if (s1.getAlbumTitle().equals(s2.getAlbumTitle())) {
                //if first song's title equals second song's title return 0
                if (s1.getSongTitle().equals(s2.getSongTitle())) {
                    return 0;
                }
                return s1.getSongTitle().compareTo(s2.getSongTitle());
            }
            return s1.getAlbumTitle().compareTo(s2.getAlbumTitle());
        }
        return s1.getArtist().compareTo(s2.getArtist());

    }

}
