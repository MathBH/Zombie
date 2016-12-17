import java.util.List;

/**
 * Responsible for finding an element of type T that adheres to a given Criterion.
 * 
 * @author Mathieu
 *
 * @param <T> element type
 */


public class CriterionSearch<T> {

	private Criterion<T> searchCriterion;
	private List<T> listToSearch;
	
	public CriterionSearch(){
		setCriterion(null);
	}
	
	public void setSearchList(List<T> listToSearch){
		this.listToSearch = listToSearch;
	}
	
	public void setCriterion(Criterion<T> searchCriterion){
		this.searchCriterion = searchCriterion;
	}
	
	public T performSearch(){
		if (this.searchCriterion == null || this.listToSearch == null)
			return null;
					
		for (T data: listToSearch)
			if (this.searchCriterion.match(data))
				return data;
		
		return null;
	}
}
