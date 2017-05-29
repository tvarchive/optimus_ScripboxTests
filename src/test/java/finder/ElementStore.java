package finder;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ElementStore {

    UIElement uiElement;

    public ElementStore() {

        String appJson = getAppJson("elements.json");
        uiElement = new Gson().fromJson(appJson, UIElement.class);
    }

    private String getAppJson(String fileName) {
        String result = "";
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            InputStream resourceAsStream = classLoader.getResourceAsStream(fileName);
            result = IOUtils.toString(resourceAsStream);
        } catch (FileNotFoundException f) {
            throw new RuntimeException("File not found exception");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


    public Element find(String appName, String fieldName, String screen) {
        List<App> apps = uiElement.getApps();
        App aut = apps.stream().filter(app -> app.getApp().equalsIgnoreCase(appName)).findFirst().get();

        return aut.getElements().stream()
                .filter(element -> element.getName().equalsIgnoreCase(fieldName))
                .filter(element -> element.getScreen().equalsIgnoreCase(screen))
                .findFirst().get();


    }
}
