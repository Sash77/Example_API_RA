package dataprovider;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class DataProviderDocument {
//
//    @DataProvider
//    public Iterator<Object[]> validDocumentDetailSimplePositive() throws IOException {
//        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocumentDetailSimple/detailSimpleBusinessLogicPositive.json")))) {
//            String json = "";
//            String line = reader.readLine();
//            while (line != null) {
//                json += line;
//                line = reader.readLine();
//            }
//            Gson gson = new Gson();
//            List<RegularSimpleSchemaModel> logons = gson.fromJson(json, new TypeToken<List<RegularSimpleSchemaModel>>() {
//            }.getType());
//            return logons.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
//
//        }
//    }
//
//    @DataProvider
//    public Iterator<Object[]> validDocumentDetailSimpleNegative() throws IOException {
//        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocumentDetailSimple/detailSimpleBusinessLogicNegative.json")))) {
//            String json = "";
//            String line = reader.readLine();
//            while (line != null) {
//                json += line;
//                line = reader.readLine();
//            }
//            Gson gson = new Gson();
//            List<ExceptionSimpleSchemaModel> logons = gson.fromJson(json, new TypeToken<List<ExceptionSimpleSchemaModel>>() {
//            }.getType());
//            return logons.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
//        }
//    }


}
