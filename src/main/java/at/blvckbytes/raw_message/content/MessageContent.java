package at.blvckbytes.raw_message.content;

import at.blvckbytes.raw_message.ServerVersion;
import at.blvckbytes.raw_message.json.JsonObject;

public interface MessageContent {

  void appendSelf(JsonObject component, ServerVersion version);

  String toLegacyText();

  MessageContent duplicate();

}
