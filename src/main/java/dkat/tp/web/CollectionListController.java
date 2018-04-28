package dkat.tp.web;

import dkat.tp.Author;
import dkat.tp.Puzzle;
import dkat.tp.Utils;
import dkat.tp.Wood;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/collection")
public class CollectionListController {
    @GetMapping
    public String showCollectionForm(Model model) {
        List<Puzzle> puzzles = Collections.EMPTY_LIST;
        try {
            puzzles = Arrays.asList(
                    new Puzzle("AYFR", "Frankenstein", Arrays.asList(
                            new Wood(1L, "Purpleheart"),
                            new Wood(2L, "Yellowheart"),
                            new Wood(3L, "Paduak")),
                            Utils.dateFormat.parse("12/11/2017"),
                            new Author(1L, "Alfons Eyckmans"),
                            7.518, "25.15.7.19.3.6.5.2.1.3.2.4",
                            Arrays.asList("static/images/Frankenstein/fr1.JPG",
                                            "static/images/Frankenstein/fr2.JPG")),
                    new Puzzle("NPKB", "Knotted Burr", Arrays.asList(
                            new Wood(4L, "Black Limba")),
                            Utils.dateFormat.parse("12/11/2017"),
                            new Author(1L, "Noah Prettyman"),
                            7.543, "6.3",
                            Arrays.asList("static/images/KnottedBurr/kb1.JPG",
                                    "static/images/KnottedBurr/kb1.JPG",
                                    "static/images/KnottedBurr/kb1.JPG")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Date> releases = puzzles.stream()
                .map(Puzzle::getReleaseDate)
                .collect(Collectors.toCollection(ArrayList::new));
        for(Date releaseDate : releases)
            model.addAttribute(Utils.dateFormat.format(releaseDate), puzzles.stream().filter(puzzle -> releaseDate.compareTo(puzzle.getReleaseDate())==0).
                    collect(Collectors.toCollection(ArrayList::new)));

        return "collection";
    }
}
