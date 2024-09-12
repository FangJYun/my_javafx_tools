package com.example.selinuim.fxmlview;

import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import org.springframework.context.annotation.Scope;

/**
 * @apiNote :视图绑定到bean
 * @author : fangjy
 */
@Scope("prototype")
@FXMLView(value = "/com/example/selinuim/home/home-view.fxml")
public class HomeView extends AbstractFxmlView {

}
