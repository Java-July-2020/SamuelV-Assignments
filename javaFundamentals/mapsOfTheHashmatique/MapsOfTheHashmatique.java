import java.util.Set;
import java.util.HashMap;

public class MapsOfTheHashmatique {
    public static void main(String[] args) {
        HashMap<String, String> tracklist = new HashMap<String, String>();
        
        // O'bella mia
        tracklist.put("O'bella mia", "Lorem ipsum dolor sit amet consectetur adipiscing elit faucibus torquent eleifend venenatis, scelerisque suspendisse arcu tincidunt aliquet nec blandit himenaeos tortor mollis. At condimentum posuere urna interdum duis dictumst commodo augue risus placerat, ac ullamcorper purus luctus cum nam pretium enim curabitur tempus, malesuada et fames egestas sed arcu aptent fermentum volutpat. ");
        
        // Buenasera
        tracklist.put("Buenasera", "Luctus inceptos imperdiet sagittis varius nec suscipit natoque tellus erat, est cum eleifend aliquam per nisi facilisis. Maecenas felis quam ac est auctor vulputate cubilia odio pellentesque ligula luctus hac, condimentum fames consequat iaculis magnis commodo scelerisque purus proin mollis nibh, nisi vel ridiculus primis lacus sodales eleifend turpis aliquam elementum mattis.");
        
        // Bonjorno Principessa
        tracklist.put("Bonjorno Principessa", "Felis nostra quam penatibus fringilla erat hac sollicitudin praesent, accumsan fermentum est sociosqu condimentum class inceptos, aliquam non luctus ad vulputate senectus duis.");
        
        // Tante Prego
        tracklist.put("Tante Prego", "Litora odio volutpat suspendisse mus mollis fringilla tellus accumsan ad fusce, dis eleifend nec vulputate dui iaculis fermentum in consequat tristique velit, sollicitudin phasellus urna nullam mi gravida mattis feugiat ut.");
        
        String songName = "Buenasera";
        String lyric = tracklist.get(songName);
        System.out.println("\nI) The lyric of " + songName + "is the following:\n" + lyric);

        
        Set<String> tracklistKeys = tracklist.keySet();
        System.out.println("\nII) The name and lyrics of all songs in the track are:\n");
        for(String key : tracklistKeys) {
            System.out.println("- " + key + ": "+tracklist.get(key));
        }
    }
}
