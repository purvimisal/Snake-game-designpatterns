/**
 * Write a description of class IFoodPublisher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IFoodPublisher  
{   
     /**
     * Add Observer to Subscribers List
     * @param obj Observer Object
     */
    void attach( IFoodListner obj ) ;

    /**
     * Remove Observer from Subscription
     * @param obj Observer Object
     */
    void removeObserver( IFoodListner obj ) ;

    /**
     * Trigger Events to Observers
     */
    void notifyListner() ;

   
}
