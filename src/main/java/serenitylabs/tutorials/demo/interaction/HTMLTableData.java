package serenitylabs.tutorials.demo.interaction;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.TargetedUIState;
import net.serenitybdd.screenplay.questions.UIStateReaderBuilder;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HTMLTableData extends TargetedUIState<List<Map<Integer, String>>> {

    public HTMLTableData(Target target, Actor actor) {
        super(target, actor);
    }

    public static UIStateReaderBuilder<HTMLTableData> of(Target target) {
        return new UIStateReaderBuilder(target, HTMLTableData.class);
    }

    @Override
    public List<List<Map<Integer, String>>> resolveAll() {
        return null; //TODO Don't need this - will ask John Smart for an improvement
    }

    @Override
    public List<Map<Integer, String>> resolve() {
        WebElementFacade table = target.resolveFor(actor);

        Stream<List<WebElement>> listStream = table.findElements(By.tagName("tr"))  //get all rows
                .stream()
                .map(tr -> tr.findElements(By.tagName("td")));

        List<List<WebElement>> collect = listStream.collect(Collectors.toList());


        List<Map<Integer, String>> results = new ArrayList<>();

        for (List<WebElement> webElements : collect) {
            int column = 0;
            Map<Integer, String> rowData = new HashMap<>();
            for (WebElement webElement : webElements) {
                rowData.put(column, webElement.getText());
                column++;
            }

            results.add(rowData);
        }

        return results;
    }
}
