/**
 * Zombie Tracking System View
 * 
 * Type of view that depicts items of the tracking system by text.
 * 
 * @author Mathieu Belzile-Ha
 *
 */
public class ZTSTextView implements ZTSView{

	private PopulationTextObserver populationObserver;
	private ZSMTextObserver zsmTextObserver;

	public ZTSTextView(){
		this.populationObserver = new PopulationTextObserver();
		this.zsmTextObserver = new ZSMTextObserver();
	}

	/**
	 * returns the population observer to be assigned.
	 */
	public PopulationObserver getPopulationObserver() {
		return this.populationObserver;
	}

	/**
	 * returns the Zombie Search Module observer to be assigned.
	 */
	public ZSMObserver getZSMObserver() {
		return this.zsmTextObserver;
	}
}