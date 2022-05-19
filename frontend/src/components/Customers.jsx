import  React,{useState, useEffect} from 'react';
import  {getCustomers} from '../services/CustomersService'

function Customers () {
	
    const [customerList, setCustomerList] = useState([])

    
     useEffect(() => {
        (async () => {
	       const result = await getCustomers()
           console.log(result)
           setCustomerList(result)
        }) ()
     }, [])



	        
    return (<div>
	           <h1> Customer Id </h1>
               <ul>
                   {customerList.map(customer => (
                      <li key={customer.personId}>
                         {customer.personId}
                      </li>
                      ))}
               </ul>
            </div>)

}

export default Customers