async function getCustomers  ()  {
	//process.env.BACKEND_URL
	const backendUrl = 'https://localhost:9000/customers'
	const response = await fetch(backendUrl)
	
	if (response.ok) 
	    {
	       const customers = await response.json()
           console.log(customers)
           
	       return customers
        } 
    else
        { 
	       throw new Error('Get customer do not return customer data')
        }  
}

export {getCustomers}