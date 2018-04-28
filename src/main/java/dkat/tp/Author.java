package dkat.tp;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Author {
    private final Long id;
    private final String name;
    private String email;
    private String url;
}
