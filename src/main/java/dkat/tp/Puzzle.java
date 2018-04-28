package dkat.tp;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Puzzle {
    private final String id;
    private final String name;
    private final List<Wood> materialList;
    private final Date releaseDate;
    private final Author author;
    private final Double size;
    private final String level;
    private final List<String> imgUrls;

}
