package experiment.jdk8;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 测试jdk8的Collectors操作
 *
 * @author haxe
 */
public class CollectorsBehaviorTest {
    @Test
    public void collectorsToMap() {

    }

    public Set<String> findLongTracks(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.forEach(album -> {
            album.getTracks().stream()
                    .filter(track -> track.getLength() > 60)
                    .map(track -> track.getName())
                    .forEach(name -> {
                        trackNames.add(name);
                    });
        });

//        albums.stream()
//                .flatMap(album -> album.getTracks() )
//                .filter(track -> track.getLength() > 60)
//                .map(track -> track.getName())
//                .forEach(name -> trackNames.add(name));
        return trackNames;
    }

    @Data
    private class Album {
        List<Track> tracks;

        @Data
        private class Track {
            String name;
            Integer length;
        }
    }


}
