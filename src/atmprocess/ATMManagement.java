package atmprocess;

import java.util.HashMap;
import java.util.Map;

public class ATMManagement 
{
      private Map<Long,Customer> customersMap=new HashMap<>();
      

	  public Map<Long, Customer> getCustomersMap() 
	  {
		    return customersMap;
	  }

      public void setCustomersMap(Map<Long, Customer> customersMap) 
      {
		    this.customersMap = customersMap;
	  }
     
      public void addCustomer(Customer customer)
      {
    	    customersMap.put( customer.getAccountNumber(), customer );
      }
      
      public Customer getCustomer(long accountNo)
      {
    	    return customersMap.get(accountNo);
      }
      
}
