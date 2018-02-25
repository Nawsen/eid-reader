package be.wannesvandorpe.eid;

import be.fedict.commons.eid.client.*;
import be.fedict.commons.eid.consumer.Address;
import be.fedict.commons.eid.consumer.Identity;
import be.fedict.commons.eid.consumer.tlv.TlvParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.smartcardio.CardException;
import java.io.IOException;

public class BeIDCardReader {

    public void readIdentityAndAddress() throws InterruptedException {
        final BeIDCards beIDCards = new BeIDCards();

        try {
            final BeIDCard card = beIDCards.getOneBeIDCard();
            CitizenJson citizenJson = new CitizenJson();
            try {
                //get the identity from card
                final byte[] idData = card.readFile(FileType.Identity);
                final Identity id = TlvParser.parse(idData, Identity.class);
                citizenJson.addIdentity(id);

                //get the address from card
                final byte[] addressData = card.readFile(FileType.Address);
                final Address address = TlvParser.parse(addressData, Address.class);
                citizenJson.addAddress(address);

                //convert to json and send it out
                String json = new ObjectMapper().writeValueAsString(citizenJson);
                System.out.println(json);

            } catch (final CardException cex) {
                cex.printStackTrace();
            } catch (final IOException iox) {
                iox.printStackTrace();
            }
        } catch (final CancelledException cex) {
            System.out.println("Cancelled By User");
        }

    }

    public static void main(final String[] args) throws InterruptedException,
            BeIDCardsException {
        final BeIDCardReader reader = new BeIDCardReader();
        reader.readIdentityAndAddress();
    }

}
