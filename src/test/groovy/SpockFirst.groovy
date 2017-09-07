import com.unittest.Sum
import spock.lang.Specification

class SpockFirst extends Specification {
    def sum = new Sum();

    def "sum should return p1+p2"() {
        expect:
        sum.sum(1, 2) == 3
    }
}
