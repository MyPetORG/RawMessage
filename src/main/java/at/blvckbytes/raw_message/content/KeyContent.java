package at.blvckbytes.raw_message.content;

import at.blvckbytes.raw_message.ServerVersion;
import at.blvckbytes.raw_message.json.JsonObject;

public class KeyContent implements MessageContent {

  public String keyBind;

  public KeyContent(String keyBind) {
    this.keyBind = keyBind;
  }

  @Override
  public void appendSelf(JsonObject component, ServerVersion version) {
    component.add("keybind", keyBind);
  }

  @Override
  public String toLegacyText() {
    return keyBind;
  }

  @Override
  public MessageContent duplicate() {
    return new KeyContent(keyBind);
  }
}
