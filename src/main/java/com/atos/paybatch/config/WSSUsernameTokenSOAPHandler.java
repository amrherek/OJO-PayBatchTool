package com.atos.paybatch.config;

import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPHeaderElement;

public class WSSUsernameTokenSOAPHandler implements SOAPHandler<SOAPMessageContext> {
	// Username for the WS-Security UsernameToken.
	private final String username;
	// Password for the WS-Security UsernameToken.
	private final String password;

	// Constructor to initialize the handler with username and password.
	public WSSUsernameTokenSOAPHandler(String username, String password) {
		this.username = username;
		this.password = password;
	}

	// This method is called for normal processing of inbound and outbound messages.
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		// Check if the message is outbound (client request).
		Boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if (outbound) {
			try {
				// Get the SOAP message.
				SOAPMessage msg = context.getMessage();
				SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
				SOAPHeader header = env.getHeader();
				if (header == null) {
					header = env.addHeader();
				}

				// Get a SOAPFactory instance.
				SOAPFactory factory = SOAPFactory.newInstance();
				// Create a QName for the Security header.
				Name secName = factory.createName("Security", "wsse",
						"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
				// Add the Security header element.
				SOAPHeaderElement security = header.addHeaderElement(secName);
				// Add the mustUnderstand attribute to the Security header.
				security.addAttribute(
						factory.createName("mustUnderstand", "soapenv", "http://schemas.xmlsoap.org/soap/envelope/"),
						"1");

				// Create the UsernameToken element.
				SOAPElement userToken = security.addChildElement("UsernameToken", "wsse");
				// Create the Username element.
				SOAPElement userElem = userToken.addChildElement("Username", "wsse");
				// Add the username text node.
				userElem.addTextNode(username);

				// Create the Password element.
				SOAPElement pwdElem = userToken.addChildElement("Password", "wsse");
				// Set the Type attribute for the Password element.
				pwdElem.setAttribute("Type",
						"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
				// Add the password text node.
				pwdElem.addTextNode(password);

			} catch (SOAPException e) {
				// Throw a runtime exception if adding the header fails.
				throw new RuntimeException("Failed to add WS-Security header", e);
			}
		}
		// Continue processing the message.
		return true;
	}

	// This method is called if an exception occurs during message processing.
	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// Simply return true to continue processing the fault.
		return true;
	}

	// This method is called at the end of the handler chain.
	@Override
	public void close(MessageContext context) {
		// No specific actions needed on close.
	}

	// This method returns the set of SOAP headers this handler understands.
	@Override
	public Set<QName> getHeaders() {
		// This handler does not explicitly declare any understood headers.
		return null;
	}
}