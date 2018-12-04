package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
        QueryBuilder query = new QueryBuilder();

//        Matcher m = query.playsIn("EDM").hasAtLeast(60, "points").build();
        Matcher m = query.oneOf(
                new QueryBuilder().playsIn("PHI")
                        .hasAtLeast(10, "goals")
                        .hasFewerThan(20, "assists").build(),
                new QueryBuilder().playsIn("EDM")
                        .hasAtLeast(60, "points").build()
        ).build();

//        Matcher m = query.playsIn("NYR")
//                         .hasAtLeast(10, "goals")
//                         .hasFewerThan(25, "goals")
//                         .build();
//        Matcher m = new And( new HasAtLeast(10, "goals"),
//                             new HasAtLeast(10, "assists"),
//                             new PlaysIn("PHI")
//        );
//        Matcher m = new Not( new HasAtLeast(1, "goals") );
//        Matcher m = new Or(new HasAtLeast(40, "goals"),
//                new HasAtLeast(60, "assists"),
//                new HasAtLeast(85, "points")
//        );
//        Matcher m = new HasFewerThan(1, "goals");
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
