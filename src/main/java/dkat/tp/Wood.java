package dkat.tp;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Wood {
    private final Long id;
    private final String name;
    private List<String> countriesList;
    private Double density;


}
