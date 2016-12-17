/**
 * Zombie Tracking System Text Controller
 * 
 * A type of ZTSController that functions by user text input.
 * Holds the Zombie Search Module Controller which it will assign when it is run.
 * 
 * @author Mathieu
 *
 */

public class ZTSTextController implements ZTSController {

	private ZTSModel model;
	private ZSMTextController zsmController;

	public ZTSTextController(ZTSModel model) {
		this.model = model;
		this.zsmController = new ZSMTextController(model.getSearchModule());
	}

	/**
	 * Assign model to control
	 */
	public void assignModel(ZTSModel model) {
		this.model = model;
		this.zsmController.assignModel(model.getSearchModule());
	}

	/**
	 * call run on ZTS component controllers (which is only zsmController right now)
	 */
	@Override
	public void run() {
		this.zsmController.run();
	}
}
