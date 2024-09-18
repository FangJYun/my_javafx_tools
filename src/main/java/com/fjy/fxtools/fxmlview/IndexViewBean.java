package com.fjy.fxtools.fxmlview;

import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import org.springframework.context.annotation.Scope;

/**
 * @apiNote :视图绑定到bean
 * @author : fangjy
 */
@Scope("prototype")
@FXMLView(value = "/com/fjy/fxtools/index-view.fxml")
public class IndexViewBean extends AbstractFxmlView {

}