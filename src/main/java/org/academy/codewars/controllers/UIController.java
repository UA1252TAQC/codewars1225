import org.academy.codewars.services.UIService;

public class UIController {
    private final UIService uiService;

    public UIController(UIService uiService) {
        this.uiService = uiService;
    }

    public void start() {
        uiService.start();
    }
