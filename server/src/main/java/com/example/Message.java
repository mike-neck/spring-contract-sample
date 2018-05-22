package com.example;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.function.Function;

public class Message {

  private final String received;
  private final long time;

  public Message(final String received, final OffsetDateTime time) {
    this.received = received;
    this.time = time.toInstant().toEpochMilli();
  }

  public String getReceived() {
    return received;
  }

  public long getTime() {
    return time;
  }

  @Override
  public String toString() {
    //noinspection StringBufferReplaceableByString
    final StringBuilder sb = new StringBuilder("Message{");
    sb.append("received='").append(received).append('\'');
    sb.append(", time=").append(time);
    sb.append('}');
    return sb.toString();
  }

  public static Builder builder(final String received) {
    return new Builder(received);
  }

  public static class Builder implements Function<ZoneOffset, Message> {

    private final String received;

    private Builder(final String received) {
      this.received = received;
    }

    @Override
    public Message apply(final ZoneOffset zoneOffset) {
      final OffsetDateTime now = OffsetDateTime.now(zoneOffset);
      return new Message(received, now);
    }
  }
}
