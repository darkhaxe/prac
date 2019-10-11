package experiment.jdk8;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * 测试jdk8的Collectors操作
 *
 * @author haxe
 */
public class CollectorsBehaviorTest {

    /**
     * @see Collectors#collectingAndThen(Collector, Function)
     */
    @Test
    public void collectorsToMap() {
        Album album = new Album(Arrays.asList(new Track("A", 33),
                new Track("B", 44),
                new Track("A", 55)
        ));
        List<Track> collect1 = album.getTracks().stream().collect(Collectors.collectingAndThen(toList(),
                (list) -> Collections.unmodifiableList(list)));

        Map<String, List<Track>> collect2 = album.getTracks().stream().collect(
                Collectors.groupingBy(Track::getName,
                        Collectors.collectingAndThen(toList(),
                                (list) -> {
                                    System.out.println("list:" + JSON.toJSONString(list));
                                    return Collections.unmodifiableList(list);
                                }
                        )
                )
        );
        System.out.println(collect2);
        Map<String, BInfo> collect3 = album.getTracks().stream().collect(
                Collectors.groupingBy(Track::getName,
                        //分组后,将每个分组下的结果list转换成另一个对象
                        Collectors.collectingAndThen(
                                Collectors.groupingBy(Track::getName),
                                (Map<String,List<Track>> list) -> {
                                    System.out.println("list:" + JSON.toJSONString(list));
//                                    return new BInfo(list);
                                    return null;
                                }
                        )
                )
        );
        System.out.println(collect3);
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
    @AllArgsConstructor
    private class Album {
        List<Track> tracks;

    }

    @Data
    @AllArgsConstructor
    public static class Track {
        String name;
        Integer length;
    }

    @Data
    public static class BInfo {
        List<Track> list;

        public BInfo(List<Track> list) {
            this.list = list;
        }
    }
}
