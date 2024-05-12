package com.tefaz.mdm_backend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@SpringBootApplication
public class MdmBackendApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MdmBackendApplication.class, args);

        MdmBackendApplication application = context.getBean(MdmBackendApplication.class);
        TableCreationService tableCreationService = context.getBean(TableCreationService.class);
        String[] tableNames = {"object_type", "product"}; // Replace with your actual table names
        for (String tableName : tableNames) {
            if (!tableCreationService.tableExists(tableName)) {
                String createScript = application.getCreateTableScript(tableName); // Call non-static method
                if (createScript != null) {
                    tableCreationService.createTable(createScript);
                    System.out.println("Created table: " + tableName);
                } else {
                    throw new IllegalArgumentException("Script not found for table: " + tableName);
                }
            }
        }
    }

    private String getCreateTableScript(String tableName) {
        String scriptFileName = "sqltablecreations/" + tableName + ".sql";
        ClassLoader classLoader = getClass().getClassLoader();
        URL scriptResourceUrl = classLoader.getResource(scriptFileName);
        if (scriptResourceUrl == null) {
            throw new IllegalArgumentException("Script not found for table: " + tableName);
        }
        try (InputStreamReader reader = new InputStreamReader(scriptResourceUrl.openStream())) {
            StringBuilder scriptBuilder = new StringBuilder();
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                scriptBuilder.append(line).append("\n");
            }
            return scriptBuilder.toString();
        } catch (IOException e) {
            // Handle the exception properly
            e.printStackTrace();
            return null;
        }
    }
}