package Controller;

import Model.Vraag;

public class ModelController {
    private final Object viewController;

    public ModelController(ViewController viewController) {
        this.viewController = viewController;

        Vraag vraag1 = new Vraag;
        vraag1.category = "Entertainment: Video Games"
    }
}
