package burp.RawHexler;

import burp.api.montoya.MontoyaApi;
import burp.api.montoya.ui.editor.extension.*;

public class RawHexlerHttpEditorProvider implements HttpRequestEditorProvider, HttpResponseEditorProvider {
    private final MontoyaApi api;

    private boolean requestMode;
    private boolean spaceDelimiters;
    private boolean fixedWidth;
    private boolean prefixRowCount;
    private boolean postfixUTF8;

    public boolean isFixedWidth() {
        return fixedWidth;
    }

    public void setFixedWidth(boolean fixedWidth) {
        this.fixedWidth = fixedWidth;
    }

    public boolean isPrefixRowCount() {
        return prefixRowCount;
    }

    public void setPrefixRowCount(boolean prefixRowCount) {
        this.prefixRowCount = prefixRowCount;
    }

    public boolean isPostfixUTF8() {
        return postfixUTF8;
    }

    public void setPostfixUTF8(boolean postfixUTF8) {
        this.postfixUTF8 = postfixUTF8;
    }

    public RawHexlerHttpEditorProvider(MontoyaApi api) {
        this.api = api;
        this.requestMode = true;

        this.spaceDelimiters = true;
        this.fixedWidth = true;
        this.postfixUTF8 = true;
    }

    public boolean isSpaceDelimiters() {
        return spaceDelimiters;
    }

    public void setSpaceDelimiters(boolean spaceDelimiters) {
        this.spaceDelimiters = spaceDelimiters;
    }

    @Override
    public ExtensionProvidedHttpRequestEditor provideHttpRequestEditor(EditorCreationContext editorCreationContext) {
        return new RawHexlerEntensionProvidedEditor(api, editorCreationContext, this);
    }

    @Override
    public ExtensionProvidedHttpResponseEditor provideHttpResponseEditor(EditorCreationContext editorCreationContext) {
        return new RawHexlerEntensionProvidedEditor(api, editorCreationContext, this);
    }

    public boolean isRequestMode() {
        return requestMode;
    }

    public void setRequestMode(boolean b) {
        this.requestMode = b;
    }
}
