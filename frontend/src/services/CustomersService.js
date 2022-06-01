import  {backendUrl}  from './BackendUrl'

async function getCustomers  ()  {

	const response = await fetch(backendUrl())
	
	if (response.ok) 
	    {
	       const customers = await response.json()
           console.log(customers)
	       return customers
        } 
    else
        { 
	       throw  new Error('Get customer do not return customer data')
        }  
}

export {getCustomers}