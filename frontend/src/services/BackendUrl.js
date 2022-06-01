export let backendUrl = () => { 
	
	const aBackendUrl = process.env.REACT_APP_BACKEND_URL
	console.info(aBackendUrl)
	
	if (aBackendUrl === undefined)
	{
	  console.info(aBackendUrl)
	  throw new Error("enviroment variable BACKEND_URL not defined")
	}
	
	   console.info(aBackendUrl)
       return aBackendUrl
   

  }