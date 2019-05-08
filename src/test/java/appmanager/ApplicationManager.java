package appmanager;

import api.*;
import ch.qos.logback.classic.Level;
import model.specification.SpecificationRequest;
import model.specification.SpecificationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class ApplicationManager {
    private final Properties properties;

    private String apiBaseURL;
    private int apiPort;
    private String docID;
    private String apiToken;

    private JavaRunCommand javaRunCommand;

    private static ch.qos.logback.classic.Logger logger;

    private String checkCurrent;

    private SpecificationRequest specificationRequest;
    private SpecificationResponse specificationResponse;
    private HelperHTTPRequest helperHTTPRequest;


    public ApplicationManager() {
        properties = new Properties();
        //To make a log
        ApplicationManager.logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(ApplicationManager.class);
        ApplicationManager.logger.setLevel(Level.ALL);
    }

    public void init() throws IOException {
        String target = System.getProperty("target","local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));

        apiBaseURL = properties.getProperty("auth.URL");
        apiPort = Integer.parseInt(properties.getProperty("auth.Port"));
        docID = properties.getProperty("data.docId");

        javaRunCommand = new JavaRunCommand();
        specificationRequest = new SpecificationRequest(this);
        specificationResponse = new SpecificationResponse(this);
        helperHTTPRequest = new HelperHTTPRequest(this);

    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getURL() {
        return apiBaseURL;
    }

    public int getApiPort() {
        return apiPort;
    }

    public String getApiToken() {
        return apiToken;
    }

    public SpecificationRequest getSpecificationRequest() {
        return specificationRequest;
    }

    public SpecificationResponse getSpecificationResponse() {
        return specificationResponse;
    }

    public HelperHTTPRequest getHelperHTTPRequest() {
        return helperHTTPRequest;
    }

    public String getDocID() {
        return docID;
    }

    public JavaRunCommand getJavaRunCommand() {
        return javaRunCommand;
    }

    public String returnCurrentDateFullData(){
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

        return formatForDateNow.format(dateNow);
    }

    public String getCheck() {
        return checkCurrent;
    }

    public void setCheck(String checkCurrent) {
        this.checkCurrent = checkCurrent;
    }

    public static void setLogger(Class<?> clazz) {
        ApplicationManager.logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(clazz);
        ApplicationManager.logger.setLevel(Level.ALL);
    }

    public Logger getLogger(){
        return ApplicationManager.logger;
    }

    public void logError(String value){
        getLogger().error(value);
    }

    public void logWarn(String value){
        getLogger().warn(value);
    }

    public void logTrace(String value){
        getLogger().trace(value);
    }

    public void logInfo(String value){
        getLogger().info(value);
    }
}
