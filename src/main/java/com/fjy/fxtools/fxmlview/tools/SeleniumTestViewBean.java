package com.fjy.fxtools.fxmlview.tools;

import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import org.springframework.context.annotation.Scope;

/**
 * @apiNote :视图绑定到bean
 * @author : fangjy
 */
@Scope("prototype")
@FXMLView(value = "/com/fjy/fxtools/tools/seleniumtest-view.fxml")
public class SeleniumTestViewBean extends AbstractFxmlView {

}
