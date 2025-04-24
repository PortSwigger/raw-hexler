package burp.RawHexler;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;

import java.io.InputStream;
import java.util.Properties;

public class EditorTab implements BurpExtension {
    private RawHexlerHttpEditorProvider RawHexlerRequestEditorProvider, RawHexlerResponseEditorProvider;

    @Override
    public void initialize(MontoyaApi api) {
        api.extension().setName("RawHex-ler");
        api.logging().logToOutput("Author: SVETTERIO");

        // 🔥 Load version from properties file
        String version = loadVersion();
        api.logging().logToOutput("Version: " + version);

        RawHexlerRequestEditorProvider = new RawHexlerHttpEditorProvider(api);
        RawHexlerRequestEditorProvider.setSpaceDelimiters(true);
        RawHexlerRequestEditorProvider.setRequestMode(true);
        api.userInterface().registerHttpRequestEditorProvider(RawHexlerRequestEditorProvider);

        RawHexlerResponseEditorProvider = new RawHexlerHttpEditorProvider(api);
        RawHexlerResponseEditorProvider.setRequestMode(false);
        api.userInterface().registerHttpResponseEditorProvider(RawHexlerResponseEditorProvider);
    }

    private String loadVersion() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("version.properties")) {
            Properties props = new Properties();
            if (input != null) {
                props.load(input);
                return props.getProperty("version", "Unknown");
            } else {
                return "Not Found";
            }
        } catch (Exception e) {
            return "Error";
        }
    }
}
