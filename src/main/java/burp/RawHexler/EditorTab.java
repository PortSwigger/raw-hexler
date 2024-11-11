package burp.RawHexler;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;

public class EditorTab implements BurpExtension {
    private RawHexlerHttpEditorProvider RawHexlerRequestEditorProvider, RawHexlerResponseEditorProvider;

    @Override
    public void initialize(MontoyaApi api) {
        api.extension().setName("RawHex-ler");
        api.logging().logToOutput("Author: SVETTERIO");

        RawHexlerRequestEditorProvider = new RawHexlerHttpEditorProvider(api);
        RawHexlerRequestEditorProvider.setSpaceDelimiters(true);
        RawHexlerRequestEditorProvider.setRequestMode(true);
        api.userInterface().registerHttpRequestEditorProvider(RawHexlerRequestEditorProvider);

        RawHexlerResponseEditorProvider = new RawHexlerHttpEditorProvider(api);
        RawHexlerResponseEditorProvider.setRequestMode(false);
        api.userInterface().registerHttpResponseEditorProvider(RawHexlerResponseEditorProvider);
    }
}
