package model.regular;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import model.BaseModel;
import model.exception.ExceptionWorklistSelectionModel;

import java.util.Map;

abstract public class RegularWorklistSelectionModel extends RegularModel {


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegularWorklistSelectionModel regularWorklistSelectionModel = (RegularWorklistSelectionModel) o;

//        if (code != regularNodeModel.code) return false;
//        if ((id==null||id.equals(""))&(regularNodeModel.id==null||regularNodeModel.id.equals(""))) return false;
//        if ((name==null||name.equals(""))&(regularNodeModel.name==null||regularNodeModel.name.equals(""))) return false;
//        if ((documentType==null||documentType.equals(""))&(regularNodeModel.documentType==null||regularNodeModel.documentType.equals(""))) return false;
        return true;
    }

    @Override
    public String toString() {
        return "WorklistSelection{" +
                "testCase=" + getTestCase() + '\'' +
                '}';
    }
}
