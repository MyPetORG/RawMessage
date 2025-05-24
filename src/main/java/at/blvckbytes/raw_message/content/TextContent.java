package at.blvckbytes.raw_message.content;

import at.blvckbytes.raw_message.ServerVersion;
import at.blvckbytes.raw_message.json.JsonObject;
import org.jetbrains.annotations.Nullable;

public class TextContent implements MessageContent {

  public String text;

  public TextContent(@Nullable Object value) {
    this(String.valueOf(value));
  }

  public TextContent(String text) {
    this.text = text;
  }

  @Override
  public void appendSelf(JsonObject component, ServerVersion version) {
    component.add("text", text);
  }

  @Override
  public String toLegacyText() {
    return this.text;
  }

  @Override
  public MessageContent duplicate() {
    return new TextContent(text);
  }
}
