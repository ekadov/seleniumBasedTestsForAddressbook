package custom_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class WebTable {

    private WebElement tableWithContacts;

    public WebTable(WebElement webTable) {
        this.tableWithContacts = webTable;
    }

    public int getRowsCount() {
        return tableWithContacts.findElements(By.tagName("tr")).size() - 1;
    }

    private List<String> getAllLastNamesFromTable() {
        List<WebElement> list = tableWithContacts.findElements(By.xpath("//tbody/tr"));
        List<String> data = new ArrayList<>();
        for (int i = 2; i < list.size() + 1; i++) {
            data.add(tableWithContacts.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText());
        }
        return data;
    }

    public boolean checkIfLastNameExistsInTable(String lastName) {
        return getAllLastNamesFromTable().contains(lastName);
    }

    public void clickFirstCheckbox() {
        tableWithContacts.findElement(By.xpath("//tbody/tr[2]/td[1]/input")).click();
    }

}
