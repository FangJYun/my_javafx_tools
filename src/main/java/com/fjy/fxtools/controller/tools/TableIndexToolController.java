package com.fjy.fxtools.controller.tools;

import com.fjy.fxtools.view.tools.TableIndexToolView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import org.apache.commons.lang3.StringUtils;

/**
 * @apiNote  首页控制器
 * @author fangjy
 */
@FXMLController
public class TableIndexToolController extends TableIndexToolView {

    @FXML
    protected void confirmButtonClick() {
        String keyText = keyTextField.getText();
        int count = Integer.parseInt(StringUtils.defaultString(countTextField.getText(), "1"));
        RadioButton selectRadio = (RadioButton)algorithmGroup.getSelectedToggle();
        int index = -1;
        if(selectRadio!=null){
            switch (selectRadio.getId()){
                case "hashCode": index = (Math.abs(keyText.hashCode()) % count);break;
                default:break;
            }
        }
        resultTable.setText("所在分表：table_"+ index);
    }
}