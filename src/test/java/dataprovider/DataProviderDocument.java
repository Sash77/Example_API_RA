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
    public Iterator<Object[]> validHeaderPositive() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/headerPositive.json")))) {
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
    public Iterator<Object[]> validHeaderNegative() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/headerNegative.json")))) {
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
    public Iterator<Object[]> validOverviewWellFormedNegative() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/overviewWellFormedNegative.json")))) {
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
    public Iterator<Object[]> validWorklistSelectionWellFormedNegative() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/worklistSelectionWellFormedNegative.json")))) {
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
    public Iterator<Object[]> validWorklistTreeWellFormedNegative() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/worklistTreeWellFormedNegative.json")))) {
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

    @DataProvider
    public Iterator<Object[]> validOverviewJsonSchema() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/overviewJsonSchema.json")))) {
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
    public Iterator<Object[]> validWorklistSelectionJsonSchema() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/worklistSelectionJsonSchema.json")))) {
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
    public Iterator<Object[]> validWorklistTreeJsonSchema() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/worklistTreeJsonSchema.json")))) {
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
    public Iterator<Object[]> validOverviewBodyPositive() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/overviewBodyPositive.json")))) {
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
    public Iterator<Object[]> validWorklistSelectionBodyPositive() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/worklistSelectionBodyPositive.json")))) {
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
    public Iterator<Object[]> validWorklistTreeBodyPositive() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/worklistTreeBodyPositive.json")))) {
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
    public Iterator<Object[]> validOverviewBodyNegative() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/overviewBodyNegative.json")))) {
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
    public Iterator<Object[]> validWorklistSelectionBodyNegative() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/worklistSelectionBodyNegative.json")))) {
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
    public Iterator<Object[]> validWorklistTreeBodyNegative() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/worklistTreeBodyNegative.json")))) {
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
    public Iterator<Object[]> validNullDoc() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/docNull.json")))) {
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
    public Iterator<Object[]> validNullOverview() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/overviewNull.json")))) {
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
    public Iterator<Object[]> validNullWorklistSelection() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/worklistSelectionNull.json")))) {
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
    public Iterator<Object[]> validNullWorklistTree() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testDataDocument/worklistTreeNull.json")))) {
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
