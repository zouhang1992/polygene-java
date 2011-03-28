package se.citerus.dddsample.application.messaging;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import se.citerus.dddsample.domain.model.cargo.TrackingId;
import se.citerus.dddsample.domain.model.handling.HandlingEvent;
import se.citerus.dddsample.domain.service.DomainEventNotifier;

/**
 * JMS based implementation.
 */
public final class JmsDomainEventNotifierImpl implements DomainEventNotifier {
  private JmsOperations jmsOperations;
  private Destination destination;
  public static final String TRACKING_ID_KEY = TrackingId.class.getName() + ".KEY";

  public void cargoWasHandled(final HandlingEvent event) {
    // TODO richer message type
    jmsOperations.send(destination, new MessageCreator() {
      public Message createMessage(final Session session) throws JMSException {
        final MapMessage message = session.createMapMessage();
        message.setStringProperty(TRACKING_ID_KEY, event.cargo().trackingId().idString());
        return message;
      }
    });
  }

  public void setJmsOperations(final JmsOperations jmsOperations) {
    this.jmsOperations = jmsOperations;
  }

  public void setDestination(final Destination destination) {
    this.destination = destination;
  }
}