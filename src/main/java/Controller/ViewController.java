package Controller;

import com.group.quiz.FxController;

public class ViewController {
    private final ModelController modelController;
    private final FxController fxController;

    public ViewController(FxController fxController) {
        this.fxController = fxController;
        modelController = new ModelController(this);
        
    }
}
