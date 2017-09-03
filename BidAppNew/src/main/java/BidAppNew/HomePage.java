package BidAppNew;

import BidAppNew.controller.ItemController;
import BidAppNew.repositories.ItemRepository;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

/**
 * Homepage
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	// TODO Add any page properties or variables here

    /**
	 * Constructor that is invoked when page is invoked without a session.
	 *
	 * @param parameters
	 *            Page parameters
	 */
    public HomePage(final PageParameters parameters) {
		ItemRepository itemRepository;
        // Add the simplest type of label
        add(new Label("message", "If you see this message wicket is properly configured and running"));
		//add(new Label("message", ItemController.getOneItem("item100").toString()));

		// TODO Add your page's components here .
    }
}
