package at.blvckbytes.raw_message.content;

import at.blvckbytes.raw_message.RawMessage;
import at.blvckbytes.raw_message.ServerVersion;
import at.blvckbytes.raw_message.json.JsonArray;
import at.blvckbytes.raw_message.json.JsonObject;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TranslationContent implements MessageContent {

  public String key;
  public @Nullable List<RawMessage> with;
  public @Nullable RawMessage fallback;

  public TranslationContent(String key, @Nullable List<RawMessage> with, @Nullable RawMessage fallback) {
    this.key = key;
    this.with = with;
    this.fallback = fallback;
  }

  @Override
  public void appendSelf(JsonObject component, ServerVersion version) {
    component.add("translate", this.key);

    if (with != null) {
      JsonArray withArray = new JsonArray();

      for (RawMessage value : with)
        withArray.add(value.toJsonObject(version));

      component.add("with", withArray);
    }

    if (fallback != null)
      component.add("fallback", fallback.toJsonObject(version));
  }

  @Override
  public String toLegacyText() {
    if (fallback != null)
      return fallback.toLegacyText();
    return key;
  }

  @Override
  public MessageContent duplicate() {
    TranslationContent duplicate = new TranslationContent(key, null, null);

    if (with != null) {
      duplicate.with = new ArrayList<>();

      for (RawMessage item : with)
        duplicate.with.add(item.duplicate());
    }

    if (fallback != null)
      duplicate.fallback = fallback.duplicate();

    return duplicate;
  }
}
