package dataprovider;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.entity.EntityRequest;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class DataProviderDocument {

    @DataProvider
    public Iterator<Object[]> validDocHeaderPositive() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/docHeaderPositive.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<EntityRequest> entityRequests = gson.fromJson(json, new TypeToken<List<EntityRequest>>() {
            }.getType());
            return entityRequests.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();

        }
    }

    @DataProvider
    public Iterator<Object[]> validDocHeaderNegative() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/docHeaderNegative.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<EntityRequest> entityRequests = gson.fromJson(json, new TypeToken<List<EntityRequest>>() {
            }.getType());
            return entityRequests.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();

        }
    }

    @DataProvider
    public Iterator<Object[]> validDocWellFormedNegative() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/docWellFormedNegative.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<EntityRequest> entityRequests = gson.fromJson(json, new TypeToken<List<EntityRequest>>() {
            }.getType());
            return entityRequests.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();

        }
    }

    @DataProvider
    public Iterator<Object[]> validDocBodyPositive() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/docBodyPositive.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<EntityRequest> entityRequests = gson.fromJson(json, new TypeToken<List<EntityRequest>>() {
            }.getType());
            return entityRequests.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();

        }
    }

    @DataProvider
    public Iterator<Object[]> validDocBodyNegative() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/docBodyNegative.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<EntityRequest> entityRequests = gson.fromJson(json, new TypeToken<List<EntityRequest>>() {
            }.getType());
            return entityRequests.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();

        }
    }

    @DataProvider
    public Iterator<Object[]> validDocJsonSchema() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/docJsonSchema.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<EntityRequest> entityRequests = gson.fromJson(json, new TypeToken<List<EntityRequest>>() {
            }.getType());
            return entityRequests.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();

        }
    }

}
